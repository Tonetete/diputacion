/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.CategoriaFacade;
import app.entity.Categoria;
import app.entity.Linea;
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
public class categoriaBean {
    
    @EJB
    private CategoriaFacade catFacade;

    /**
     * Creates a new instance of categoriaBean
     */
    public categoriaBean() {
    }
    
    public List<Categoria> getListaCategorias(){
        List<Categoria> listaCat = (List<Categoria>)catFacade.findAll();
        return listaCat; 
    }
    
}
