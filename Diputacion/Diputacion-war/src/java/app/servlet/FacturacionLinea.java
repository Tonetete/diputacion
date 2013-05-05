/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.servlet;

import app.dao.LineaFacade;
import app.dao.LlamadaFacade;
import app.entity.Linea;
import app.entity.Llamada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Francisco Fernández
 */
@WebServlet(name = "FacturacionLinea", urlPatterns = {"/FacturacionLinea"})
public class FacturacionLinea extends HttpServlet {
    @EJB
    private LlamadaFacade llamadaFacade;
    
    @EJB
    private LineaFacade lineaFacade;

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String numeroLinea = request.getParameter("linea");
        
        
//            response.setContentType("text/html;charset=UTF-8");
//            PrintWriter out = response.getWriter();
//            try {
//                out.println("<!DOCTYPE html>");
//                out.println("<html><head><title>Servlet Index</title></head><body>");
//                out.println("<h1>Servlet Index at " + request.getContextPath() + "</h1>");
//                out.println("Numero: " + numeroLinea + "<br />");
//                out.println("LlamadaFacade: " + llamadaFacade + "<br />");
//                out.println("LineaFacada: " + lineaFacade + "<br />");
//                out.println("</body></html>");
//            } finally {
//                out.close();
//            }
        
        
        
        Linea linea = lineaFacade.findByNumero(numeroLinea);
        List<Llamada> llamadas = llamadaFacade.findByLinea(linea);
        
        request.setAttribute("linea", linea);
        request.setAttribute("llamadas", llamadas);
        
        getServletContext().getRequestDispatcher("/facturacionLinea.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
