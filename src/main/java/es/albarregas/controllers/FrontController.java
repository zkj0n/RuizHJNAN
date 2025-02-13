package es.albarregas.controllers;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAO.GenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Ciclo;



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
        String url= ".";
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        List<Ciclo> ciclos = null;

        switch (accion.substring(0, 1).toLowerCase()) {
            case "c":
                url = "./JSP/create/create.jsp";
                break;
            case "r":
            case "u":
            case "d":
                ciclos = genericoDAO.selectAll(Ciclo.class);
                request.setAttribute("ciclos", ciclos);
                url = "./JSP/" + accion.toLowerCase() + "/" + accion.toLowerCase() + ".jsp";
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