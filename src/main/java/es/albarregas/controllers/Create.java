package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.GenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;
import es.albarregas.models.Modelo;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
        String url;

        try {
            BeanUtils.populate(ciclo, request.getParameterMap());

            ciclo.getModulos().addAll(Modelo.populateModulos(request));

            if (Modelo.validar(ciclo)) {
                DAOFactory daof = DAOFactory.getDAOFactory();
                IGenericoDAO genericoDAO = daof.getGenericoDAO();
                genericoDAO.insertOrUpdate(ciclo);

                request.setAttribute("c", ciclo);
                request.setAttribute("mensaje", "agregado correctamente");
                url = "./JSP/read/readOne.jsp";
            } else {
                request.setAttribute("error", "todos los campos son obligatorios");
                url = "./JSP/create/create.jsp";
            }

        } catch (IllegalAccessException | InvocationTargetException | NumberFormatException e) {
            request.setAttribute("error", "error al procesar el formulario");
            url = "./JSP/create/create.jsp";
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