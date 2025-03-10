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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;


@WebServlet(name = "Create", value = "/Create")
public class Create extends HttpServlet {

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
        request.getRequestDispatcher("./JSP/create/create.jsp").forward(request, response);
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
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        Profesor profesor = new Profesor();
        List<Modulo> modulos = new ArrayList<>();
        String url = ".";

        try {
            BeanUtils.populate(profesor, request.getParameterMap());
            String[] modulosSelects = request.getParameterValues("modulosSelect");
            String[] modulosInput = request.getParameterValues("modulosInput");

            if (modulosSelects != null ) {
                for (String moduloSelect : modulosSelects) {
                    Modulo modulo = new Modulo();
                    String[] partes = moduloSelect.split("-");
                    modulo.setId(Integer.parseInt(partes[0]));
                    modulo.setTitulo(partes[1]);
                    modulos.add(modulo);
                }
            }

            if (modulosInput != null) {
                for (String moduloInput : modulosInput) {
                    if (!moduloInput.isEmpty()) {
                        Modulo modulo = new Modulo();
                        modulo.setTitulo(moduloInput);

                        boolean moduloExistente = modulos.stream()
                                .anyMatch(m -> m.getTitulo().equals(moduloInput));

                        if (!moduloExistente) {
                            modulos.add(modulo);
                        }
                    }
                }
            }

            profesor.setModulos(new HashSet<>(modulos));

            genericoDAO.insertOrUpdate(profesor);

        } catch (HibernateException e) {
            request.setAttribute("mensaje", "Error: " + e.getMessage());
            url = "./JSP/notify/notify.jsp";
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
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