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

@WebServlet(name = "Delete", value = "/Delete")
public class Delete extends HttpServlet {

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
//        processRequest(request, response);
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
        String url = "/JSP/notify/notify.jsp";

        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();

        switch (accion){
            case "eliminar profesor":
                String idProfesor = request.getParameter("idProfesor");
                Profesor profesor = (Profesor) genericoDAO.getById(Integer.parseInt(idProfesor), Profesor.class);
                request.getSession().setAttribute("profesor", profesor);
                url = "/JSP/delete/confirmarProfesor.jsp";
                break;
            case "eliminar modulo":
                String idModulo = request.getParameter("idModulo");
                Modulo modulo = (Modulo) genericoDAO.getById(Integer.parseInt(idModulo), Modulo.class);
                request.getSession().setAttribute("modulo", modulo);
                url = "/JSP/delete/confirmarModulo.jsp";
                break;
            case "eliminar profesor confirmado":
                Profesor profesorConfirmado = (Profesor) request.getSession().getAttribute("profesor");
                genericoDAO.delete(profesorConfirmado);
                request.getSession().removeAttribute("profesor");
                url = ".";
                break;
            case "eliminar modulo confirmado":
                Modulo moduloConfirmado = (Modulo) request.getSession().getAttribute("modulo");
                for (Profesor profesorModulo : moduloConfirmado.getProfesores()) {
                    profesorModulo.getModulos().remove(moduloConfirmado);
                    genericoDAO.insertOrUpdate(profesorModulo);
                }
                genericoDAO.delete(moduloConfirmado);
                request.getSession().removeAttribute("modulo");
                url = ".";
                break;
            default:
                request.setAttribute("mensaje", "no se ha seleccionado ninguna acción");
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