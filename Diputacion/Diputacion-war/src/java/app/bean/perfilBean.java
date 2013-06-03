/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.PerfilFacade;
import app.entity.Perfil;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Tone
 */
@ManagedBean
@RequestScoped
public class perfilBean {
    
    @EJB
    private PerfilFacade perfilFacade;

    /**
     * Creates a new instance of perfilBean
     */
    public perfilBean() {
    }
    
    public List<Perfil> getListaPerfiles(){
        List<Perfil> listaPerfil = (List<Perfil>)perfilFacade.findAll();
        return listaPerfil; 
    }
}
