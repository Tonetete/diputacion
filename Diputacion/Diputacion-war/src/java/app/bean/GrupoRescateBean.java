/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.GrupoRescateFacade;
import app.dao.UsuarioFacade;
import app.entity.GrupoRescate;
import app.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rafael
 */

@ManagedBean
@RequestScoped
public class GrupoRescateBean {

    @EJB
    private UsuarioFacade usuarioFacade;
    @EJB
    private GrupoRescateFacade grupoRescateFacade;
    
    
    private List<GrupoRescate> listaGrupoRescate;
    private GrupoRescate gr;
    private String nombreGrupoRescate;
    private int codigoGrupoRescate;
    
    private Usuario user;
    private int roluser;

    
    @PostConstruct
    public void create() {
        
        user = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    
        roluser = user.getCodigoRol().getCodigo();
       
        listaGrupoRescate = grupoRescateFacade.findAll();
    }

    public List<GrupoRescate> getListaGrupoRescate() {
        listaGrupoRescate = grupoRescateFacade.findAll();
        return listaGrupoRescate;
    }

    public void setListaGrupoRescate(List<GrupoRescate> listaGrupoRescate) {
        this.listaGrupoRescate = listaGrupoRescate;
    }
    
    
    public int getCodigoGrupoRescate() {
        return codigoGrupoRescate;
    }

    public void setCodigoGrupoRescate(int codigoGrupoRescate) {
        this.codigoGrupoRescate = codigoGrupoRescate;
    }
    
    public GrupoRescate getGr() {
        return gr;
    }

    public void setGr(GrupoRescate gr) {
        this.gr = gr;
    }
    public String getNombreGrupoRescate() {
        return nombreGrupoRescate;
    }

    public void setNombreGrupoRescate(String nombre) {
        this.nombreGrupoRescate = nombre;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    
    public int getRoluser() {
        return roluser;
    }

    public void setRoluser(int roluser) {
        this.roluser = roluser;
    }
    
    public List<Integer> getListaCodigo(){
    
       // List<GrupoRescate> lista = grupoRescateFacade.findAll();
        
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < listaGrupoRescate.size(); i++){
            if(!listaGrupoRescate.get(i).getCodigo().equals(codigoGrupoRescate)){
                 res.add(listaGrupoRescate.get(i).getCodigo());
            }
        }
        
        return res;
    
    }   
    
    public String getGrupoRescate(){ // usuario, jefe de servicio, controlador, administrador
        
       // user = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    
        roluser = user.getCodigoRol().getCodigo();
        gr = grupoRescateFacade.find(user.getCodigoRescate().getCodigo());
        
        nombreGrupoRescate = gr.getNombre();
        codigoGrupoRescate = gr.getCodigo();
        
        return codigoGrupoRescate + " - " + nombreGrupoRescate;
        
    }
    
    
    
    
    private GrupoRescate grToUpdate;
    private int codigoToUpdate;
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public GrupoRescate getGrToUpdate() {
        return grToUpdate;
    }

    public void setGrToUpdate(GrupoRescate grToUpdate) {
        this.grToUpdate = grToUpdate;
    }
    
    public int getCodigoToUpdate() {
        return codigoToUpdate;
    }

    public void setCodigoToUpdate(int codigoToUpdate) {
        this.codigoToUpdate = codigoToUpdate;
    }
    
    public void updateGrupoRescate(){ // usuario, jefe de servicio, controlador, administrador
       
        grToUpdate = grupoRescateFacade.findByCodigo(codigoToUpdate);
        //user = (Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    
        if(user != null){
            user.setCodigoRescate(grToUpdate);
            usuarioFacade.edit(user);
        }else{
            mensaje = "user es null";
        }
        
        
    }
    
   
    
    
    
    
    
    private GrupoRescate grToAdd;
    private String newNombre;
    private int newCodigo;

    public String getNewNombre() {
        return newNombre;
    }

    public void setNewNombre(String newNombre) {
        this.newNombre = newNombre;
    }

    public int getNewCodigo() {
        return newCodigo;
    }

    public void setNewCodigo(int newCodigo) {
        this.newCodigo = newCodigo;
    }
    
    public GrupoRescate getGrToAdd() {
        return grToAdd;
    }

    public void setGrToAdd(GrupoRescate grToAdd) {
        this.grToAdd = grToAdd;
    }
    
   
    
    public void addGrupoRescate(){ // solo el administrador
       
        boolean encontrado = false;
        //List<GrupoRescate> listaGrupoRescate = grupoRescateFacade.findAll();
        
        for(int i = 0; i < listaGrupoRescate.size(); i++){
            if(listaGrupoRescate.get(i).getCodigo().equals(newCodigo)) encontrado = true;
        }
        
        grToAdd = new GrupoRescate();
        grToAdd.setCodigo(newCodigo);
        grToAdd.setNombre(newNombre);
        
        if(!encontrado){
            
            mensaje = "Nuevo";
            grupoRescateFacade.create(grToAdd); 
            
        }else{
           
            mensaje = "Ya existe Codigo del grupo de rescate";
            grupoRescateFacade.edit(grToAdd); 
        }
        
        
    }
    
   
    
    private GrupoRescate grToDelete;
    
    public GrupoRescate getGrToDelete() {
        return grToDelete;
    }

    public void setGrToDelete(GrupoRescate grToDelete) {
        this.grToDelete = grToDelete;
    }
    
    public void deleteGrupoRescate(){ // solo el administrador
        
        int num_usuarios = 0;
        List<Usuario> lista = usuarioFacade.findAll();
        
        for(int i = 0; i < lista.size(); i++){
            if(lista.get(i).getCodigoRescate().equals(grToDelete)) num_usuarios++;
        }
        
        if(num_usuarios == 0){
            mensaje = "Borrado";
            grupoRescateFacade.remove(grToDelete);
        }else{
            mensaje = "El Grupo de Rescate Seleccionado no puede ser borrado tiene " + String.valueOf(num_usuarios) +" usuarios asignado";
        }
    }
    
    
    

    
    
}
