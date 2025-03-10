package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Profesor;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@WebServlet(name = "Update", value = "/Update")
public class Update extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("JSP/update/update.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        String url = ".";

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        List<Modulo> modulos = null;
        Profesor profesor = null;
        switch (accion) {
            case "seleccionado update":
                int idProfesor = Integer.parseInt(request.getParameter("idProfesor"));
                profesor = (Profesor) genericoDAO.getById(idProfesor, Profesor.class);
                modulos = genericoDAO.selectAll(Modulo.class);
                if (profesor != null) {
                    request.getSession().setAttribute("profesor", profesor);
                    request.getSession().setAttribute("modulos", modulos);
                    List<Modulo> modulosNoTiene = new ArrayList<>(modulos);
                    modulosNoTiene.removeAll(profesor.getModulos());
                    request.setAttribute("modulosNoTiene", modulosNoTiene);
                    url = "./JSP/update/update.jsp";
                } else {
                    request.setAttribute("mensaje", "profesor no encontrado");
                    url = "./JSP/notify/notify.jsp";
                }
                break;
            default:
                modulos = new ArrayList<>();

                try {
                    profesor = (Profesor) request.getSession().getAttribute("profesor");

                    BeanUtils.populate(profesor, request.getParameterMap());

                    String[] modulosSelects = request.getParameterValues("modulosSelect");
                    String[] modulosInput = request.getParameterValues("modulosInput");

                    Map<Integer, Modulo> moduloMap = new HashMap<>();

                    if (modulosSelects != null) {
                        for (String moduloSelect : modulosSelects) {
                            String[] partes = moduloSelect.split("-");
                            int moduloId = Integer.parseInt(partes[0]);
                            String moduloTitulo = partes[1];

                            Modulo modulo = (Modulo) genericoDAO.getById(moduloId, Modulo.class);
                            if (modulo == null) {
                                modulo = new Modulo();
                                modulo.setId(moduloId);
                            }
                            modulo.setTitulo(moduloTitulo);

                            moduloMap.put(modulo.getId(), modulo);
                        }
                    }

                    if (modulosInput != null) {
                        for (String moduloInput : modulosInput) {
                            if (!moduloInput.isEmpty()) {
                                Modulo modulo = new Modulo();
                                modulo.setTitulo(moduloInput);

                                boolean exists = moduloMap.values().stream()
                                        .anyMatch(m -> m.getTitulo().equalsIgnoreCase(moduloInput));

                                if (!exists) {
                                    modulos.add(modulo);
                                }
                            }
                        }
                    }

                    modulos.addAll(moduloMap.values());
                    profesor.setModulos(new HashSet<>(modulos));

                    genericoDAO.insertOrUpdate(profesor);

                } catch (HibernateException | IllegalAccessException | InvocationTargetException e) {
                    request.setAttribute("mensaje", "no se han podido actualizar los datos");
                    url = "./JSP/notify/notify.jsp";
                }
                break;

        }
        request.getRequestDispatcher(url).forward(request, response);
    }


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}