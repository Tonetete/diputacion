/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.UsuarioFacade;
import app.entity.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;



/**
 *
 * @author Tone
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private UsuarioFacade userFacade;
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
        response.setContentType("application/json;charset=utf-8");
        
        String usuario, contrasena;
        try {
            userFacade = (UsuarioFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/UsuarioFacade!app.dao.UsuarioFacade");
        } catch (NamingException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        usuario = request.getParameter("usuario");
        contrasena = request.getParameter("contrasena");
        Usuario u = userFacade.getUsuarioContrasena(usuario, contrasena);
      
        JsonElement jsonElem;
        JsonObject json = new JsonObject();
        Gson gson = new Gson();
        
        
        if(u==null){
            jsonElem = gson.toJsonTree(-1);
            json.add("usuariorol", jsonElem);
        }
        
        else{
            jsonElem = gson.toJsonTree(u.getCodigoRol().getCodigo().toString());
            json.add("usuariorol", jsonElem);
            request.getSession(true);
            //request.getSession().setMaxInactiveInterval(300);
            request.getSession().setAttribute("usuario", u);           
                                  
        }
        PrintWriter pw = response.getWriter(); 
        pw.print(json.toString());
        pw.close();
        json.addProperty("success", true);   
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
