/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.servlet;

import app.dao.AsignacionFijoFacade;
import app.dao.LlamadaFacade;
import app.dao.LineaFacade;
import app.dao.UsuarioFacade;
import app.entity.AsignacionFijo;
import app.entity.Linea;
import app.entity.Llamada;
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
 * @author guzman
 */
@WebServlet(name = "ListadoTerminalesServlet", urlPatterns = {"/listterminales"})
public class ListadoTerminalesServlet extends HttpServlet {
    @EJB
    private AsignacionFijoFacade asigFijoFacade;
    @EJB
    private UsuarioFacade userFacade;
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<AsignacionFijo> listaAsignaciones = asigFijoFacade.findAll();
        List<Usuario> listaUsuarios = userFacade.findAll();
       
        String dni = request.getParameter("dni");
        Usuario user = null;
        for(Usuario u : listaUsuarios)
        {
            if(u.getDni().equals(dni))
                user = u;
        }
        
        request.setAttribute("listaAsignaciones", listaAsignaciones);
        request.setAttribute("usuario", user);
        
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/listterminales.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
