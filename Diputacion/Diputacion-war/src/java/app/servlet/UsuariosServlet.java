/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.servlet;

import app.dao.DiputacionFacade;
import app.dao.GrupoRescateFacade;
import app.dao.RolesFacade;
import app.dao.UsuarioFacade;
import app.entity.Diputacion;
import app.entity.GrupoRescate;
import app.entity.Roles;
import app.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
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
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/usuarios"})
public class UsuariosServlet extends HttpServlet {

    private UsuarioFacade usuarioFacade;
    private DiputacionFacade diputacionFacade;
    private RolesFacade rolesFacade;
    private GrupoRescateFacade rescateFacade;
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
        
        
        String m = request.getParameter("action");
        
        if(request.getParameter("action").equals("edit") || request.getParameter("action").equals("insert")){
            insertEditUser(request, response);
        }
        
        else if(request.getParameter("action").equals("delete")){
            deleteUser(request, response);
        }
        
        
        else{
            listUsers(request, response);
        }
    }
    
    protected void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            usuarioFacade = (UsuarioFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/UsuarioFacade!app.dao.UsuarioFacade");            
        } catch (NamingException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Usuario u = (Usuario)usuarioFacade.find(request.getParameter("dni"));
        
        usuarioFacade.delete(u);       
 
        JsonObject json = new JsonObject();     
        json.addProperty("success", true); 
    }

    protected void insertEditUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            usuarioFacade = (UsuarioFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/UsuarioFacade!app.dao.UsuarioFacade");
            diputacionFacade = (DiputacionFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/DiputacionFacade!app.dao.DiputacionFacade");
            rolesFacade = (RolesFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/RolesFacade!app.dao.RolesFacade");
            rescateFacade = (GrupoRescateFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/GrupoRescateFacade!app.dao.GrupoRescateFacade");
        } catch (NamingException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Diputacion dip = diputacionFacade.getDiputacionByCiudad(request.getParameter("diputacion"));        
        Roles rol = rolesFacade.getRolByTipo(request.getParameter("rol"));  
        
        Usuario u = (Usuario)usuarioFacade.find(request.getParameter("dni"));
        if(u==null){
            u = new Usuario();
            GrupoRescate rescate = (GrupoRescate)rescateFacade.find(1);
            u.setDni(request.getParameter("dni"));
            u.setCodigoRescate(rescate);
        }
        u.setApellidos(request.getParameter("apellidos"));
        u.setContrasena(request.getParameter("contrasena"));
        u.setNombre(request.getParameter("nombre"));
        u.setCodigoRol(rol);
        u.setCodigoDip(dip);
        u.setEmail(request.getParameter("email"));
        
        if(request.getParameter("action").equals("edit")){        
            usuarioFacade.edit(u);
        }
        
        else{
            usuarioFacade.insert(u);
        }
        
        JsonElement jsonElem;
        JsonObject json = new JsonObject();
        Gson gson = new Gson();
        
        json.add("dni", gson.toJsonTree(u.getDni()));
        json.add("nombre", gson.toJsonTree(u.getNombre()));
        json.add("apellidos", gson.toJsonTree(u.getApellidos()));
        json.add("contrasena", gson.toJsonTree(u.getContrasena()));
        json.add("diputacion", gson.toJsonTree(u.getCodigoDip().getCiudad()));
        json.add("rol", gson.toJsonTree(u.getCodigoRol().getTipo()));
        json.add("email", gson.toJsonTree(u.getEmail()));
        
        PrintWriter pw = response.getWriter(); 
        pw.print(json.toString());
        pw.close();
        json.addProperty("success", true); 
        
//        usuarioFacade.updateUsuario(request.getParameter("dni"), request.getParameter("contrasena"), request.getParameter("nombre"),
//                request.getParameter("apellidos"), request.getParameter("email"), request.getParameter("diputacion"), request.getParameter("rol"));
    }
    
    protected void listUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            usuarioFacade = (UsuarioFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/UsuarioFacade!app.dao.UsuarioFacade");
            diputacionFacade = (DiputacionFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/DiputacionFacade!app.dao.DiputacionFacade");
            rolesFacade = (RolesFacade)InitialContext.doLookup("java:global/Diputacion/Diputacion-ejb/RolesFacade!app.dao.RolesFacade");
        } catch (NamingException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<Usuario> listaUsuarios = (List<Usuario>)usuarioFacade.findAll();
        List<Diputacion> listaDiputaciones = (List<Diputacion>)diputacionFacade.findAll();
        List<Roles> listaRoles = (List<Roles>)rolesFacade.findAll();
        request.setAttribute("listaUsuarios", listaUsuarios);        
        request.setAttribute("listaDiputaciones", listaDiputaciones);        
        request.setAttribute("listaRoles", listaRoles);        
        
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
