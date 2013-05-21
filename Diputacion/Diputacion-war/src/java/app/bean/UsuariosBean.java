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
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
    private String nombre;
    private String apellidos;
    private String email;
    private Roles rol;
    private Diputacion diputacion;
    private GrupoRescate rescate;
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Diputacion getDiputacion() {
        return diputacion;
    }

    public void setDiputacion(Diputacion diputacion) {
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
    public List<String> getListaDiputaciones(){
        return diputacionFacade.getDiputacionAllCiudad();
    }
    @PostConstruct
    public List<String> getListaRoles(){
        return rolesFacade.getRolAll();
    }

    
}
