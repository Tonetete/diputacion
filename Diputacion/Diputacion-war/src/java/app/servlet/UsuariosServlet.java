/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.servlet;

import app.dao.UsuarioFacade;
import app.entity.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tone
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

    private UsuarioFacade usuarioFacade;
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            usuarioFacade = (UsuarioFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/UsuarioFacade!app.dao.UsuarioFacade");
        } catch (NamingException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Usuario> listaUsuarios = (List<Usuario>)usuarioFacade.findAll();
        
        request.setAttribute("listaUsuarios", listaUsuarios);        
        
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/usuarios.jsp");
        rd.forward(request, response);
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
