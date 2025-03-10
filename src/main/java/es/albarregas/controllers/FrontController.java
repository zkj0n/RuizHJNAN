package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Modulo;
import es.albarregas.beans.Profesor;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FrontController", value = "/FrontController")
public class FrontController extends HttpServlet {

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
        request.getRequestDispatcher(".").forward(request, response);
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
        List<?> items = null;

        request.getSession().removeAttribute("profesor");
        request.getSession().removeAttribute("modulo");

        switch (accion) {
            case "create":
            case "read modulos":
            case "delete modulo":
                items = genericoDAO.selectAll(Modulo.class);
                request.setAttribute("modulos", items);
                break;
            case "read profesores":
            case "delete profesor":
            case "update":
            case "delete":
                items = genericoDAO.selectAll(Profesor.class);
                request.setAttribute("profesores", items);
                break;
        }

        if ((items == null || items.isEmpty()) && !"home".equals(accion) &&  !"create".equals(accion)) {
            String mensaje = "no hay " + (accion.equals("read profesores") || accion.equals("update") || accion.equals("delete") ? "profesores" : "modulos");
            request.setAttribute("mensaje", mensaje);
            url = "./JSP/notify/notify.jsp";
        } else {
            switch (accion) {
                case "create":
                    url = "./JSP/create/create.jsp";
                    break;
                case "read profesores":
                    url = "./JSP/read/readProfesores.jsp";
                    break;
                case "read modulos":
                    url = "./JSP/read/readModulos.jsp";
                    break;
                case "update":
                    url = "./JSP/update/seleccionUpdate.jsp";
                    break;
                case "delete":
                    url = "./JSP/delete/delete.jsp";
                    break;
                case "delete profesor":
                    url = "./JSP/delete/seleccionDeleteProfesor.jsp";
                    break;
                case "delete modulo":
                    url = "./JSP/delete/seleccionDeleteModulo.jsp";
                    break;
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