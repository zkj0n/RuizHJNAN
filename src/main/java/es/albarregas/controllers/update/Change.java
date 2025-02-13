package es.albarregas.controllers.update;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.GenericoDAO;


import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Ciclo;
import es.albarregas.models.Modelo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "Change", value = "/Change")
public class Change extends HttpServlet {

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
        request.getRequestDispatcher("./FrontController").forward(request, response);
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
        Ciclo ciclo = new Ciclo();
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        String url;

        try {
            BeanUtils.populate(ciclo, request.getParameterMap());

            ciclo.setIdCiclo(Integer.parseInt(request.getParameter("id")));
            ciclo.getModulos().addAll(Modelo.populateModulos(request));
        } catch (IllegalAccessException | InvocationTargetException e) {
            request.setAttribute("error", "error al procesar los datos.");
            request.getRequestDispatcher("./JSP/update/change.jsp").forward(request, response);
            return;
        }

        if (!Modelo.validar(ciclo)) {
            request.setAttribute("c", ciclo);
            request.setAttribute("error", "todos los campos son obligatorios.");
            url = "./JSP/update/change.jsp";
        } else {
            Ciclo cicloAntiguo = (Ciclo) genericoDAO.getById(ciclo.getIdCiclo(), Ciclo.class);

            if (cicloAntiguo != null && cicloAntiguo.equals(ciclo)) {
                request.setAttribute("error", "no se ha modificado ningún campo.");
                request.setAttribute("c", ciclo);
                url = "./JSP/update/change.jsp";
            } else {
                try {
                    genericoDAO.insertOrUpdate(ciclo);
                    request.setAttribute("c", ciclo);
                    request.setAttribute("mensaje", "servicio actualizado correctamente.");
                    url = "./JSP/read/readOne.jsp";
                } catch (Exception e) {
                    request.setAttribute("error", "error al actualizar los datos.");
                    url = "./JSP/update/change.jsp";
                }
            }
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