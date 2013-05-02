/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.servlet;

import app.dao.LlamadaFacade;
<<<<<<< HEAD
=======
import app.dao.LineaFacade;
import app.entity.Linea;
>>>>>>> Versión 1º Definitva (eh o no?)
import app.entity.Llamada;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
<<<<<<< HEAD
import javax.ejb.EJB;
=======
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
>>>>>>> Versión 1º Definitva (eh o no?)
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
<<<<<<< HEAD
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class FacturacionServlet extends HttpServlet {
    @EJB
    private LlamadaFacade llamadaFacade;
=======
@WebServlet(name = "FacturacionServlet", urlPatterns = {"/llamadas"})
public class FacturacionServlet extends HttpServlet {
    
    private LlamadaFacade llamadaFacade;
    private LineaFacade lineaFacade;
>>>>>>> Versión 1º Definitva (eh o no?)

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
<<<<<<< HEAD
        
//        List<Customer> listClientes = customerFacade.findAll();
//        request.setAttribute("listaClientes", listClientes);
//        RequestDispatcher rd;
//        
//        rd = this.getServletContext().getRequestDispatcher("/salida.jsp");
//        rd.forward(request, response);
//        
        List<Llamada> listaLlamadas = llamadaFacade.findAll();
        request.setAttribute("listaLlamadas", listaLlamadas);
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/index.jsp");
=======
        try {
            //        List<Customer> listClientes = customerFacade.findAll();
            //        request.setAttribute("listaClientes", listClientes);
            //        RequestDispatcher rd;
            //        
            //        rd = this.getServletContext().getRequestDispatcher("/salida.jsp");
            //        rd.forward(request, response);
            //        
                    lineaFacade = (LineaFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/LineaFacade!app.dao.LineaFacade");
        } catch (NamingException ex) {
            Logger.getLogger(FacturacionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Linea> listaLineas = lineaFacade.findAll();        
        //request.setAttribute("listaLlamadas", listaLlamadas);
        request.setAttribute("listaLineas", listaLineas);
        RequestDispatcher rd;
        rd = this.getServletContext().getRequestDispatcher("/llamadas.jsp");
>>>>>>> Versión 1º Definitva (eh o no?)
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
