package es.albarregas.controllers.delete;

import es.albarregas.DAO.IGenericoDAO;
import es.albarregas.DAOFactory.DAOFactory;
import es.albarregas.beans.Ciclo;
import es.albarregas.beans.Modulo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteModulo", value = "/DeleteModulo")
public class DeleteModulo extends HttpServlet {

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
        DAOFactory daof = DAOFactory.getDAOFactory();
        IGenericoDAO genericoDAO = daof.getGenericoDAO();
        String url;

        try {
            int idModulo = Integer.parseInt(request.getParameter("idModulo"));
            Modulo modulo = (Modulo) genericoDAO.getById(idModulo, Modulo.class);
            genericoDAO.delete(modulo);

            int idCiclo = Integer.parseInt(request.getParameter("idCiclo"));
            Ciclo ciclo = (Ciclo) genericoDAO.getById(idCiclo, Ciclo.class);
            request.setAttribute("c", ciclo);
            request.setAttribute("mensaje", "módulo eliminado correctamente");
            url = "./JSP/read/readOne.jsp";
        } catch (NumberFormatException e) {
            request.setAttribute("error", "id no válido");
            url = "./JSP/delete/deleteModulo.jsp";
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