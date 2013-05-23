/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.DiputacionFacade;
import app.dao.RolesFacade;
import app.dao.UsuarioFacade;
import app.entity.Diputacion;
import app.entity.GrupoRescate;
import app.entity.Roles;
import app.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Tone
 */
@ManagedBean
@RequestScoped
public class UsuariosBean {
    
    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private DiputacionFacade diputacionFacade;
    @EJB
    private RolesFacade rolesFacade;
    
    private String dni;
    private String contrasena;   
    private String nombre;
    private String apellidos;
    private String email;
    private GrupoRescate rescate;
    private Integer rol;
    private Integer diputacion;
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getRol() {
        return rol;
    }

    public void setRol(Integer rol) {
        this.rol = rol;
    }

    public Integer getDiputacion() {
        return diputacion;
    }

    public void setDiputacion(Integer diputacion) {
        this.diputacion = diputacion;
    }

    public GrupoRescate getRescate() {
        return rescate;
    }

    public void setRescate(GrupoRescate rescate) {
        this.rescate = rescate;
    }

    public List<Usuario> getListaUsuarios(){
        
        List<Usuario> listaUsuarios = (List<Usuario>)usuarioFacade.findAll();
        return listaUsuarios;
    }
    @PostConstruct
    public List<Diputacion> getListaDiputaciones(){
        return diputacionFacade.findAll();
    }

    @PostConstruct
    public List<Roles> getListaRoles(){
        return rolesFacade.findAll();
    }
    
    public void insertar(){
        GrupoRescate gr = new GrupoRescate();
        gr.setCodigo(1);
        Diputacion d = diputacionFacade.find(diputacion);
        Roles r = rolesFacade.find(rol);
        Usuario u = new Usuario();
        u.setDni(dni);
        u.setNombre(nombre);
        u.setApellidos(apellidos);
        u.setContrasena(contrasena);
        u.setEmail(email);
        u.setCodigoRescate(gr);
        u.setCodigoDip(d);
        u.setCodigoRol(r);
        
        if(usuarioFacade.find(u.getDni())==null){
            usuarioFacade.insert(u);  
        }
        else{
            usuarioFacade.edit(u);
        }
        
        RequestContext reqCtx = RequestContext.getCurrentInstance();
        reqCtx.addCallbackParam("dni", dni);
        reqCtx.addCallbackParam("contrasena", contrasena);
        reqCtx.addCallbackParam("nombre", nombre);
        reqCtx.addCallbackParam("apellidos", apellidos);        
        reqCtx.addCallbackParam("email", email);        
        reqCtx.addCallbackParam("diputacion", u.getCodigoDip().getCiudad());
        reqCtx.addCallbackParam("rol", u.getCodigoRol().getTipo());        
    }
    
    public void borrar(){
        
        Usuario u = new Usuario();
        u = (Usuario)usuarioFacade.find(dni);
        usuarioFacade.delete(u);
    }

    
}
