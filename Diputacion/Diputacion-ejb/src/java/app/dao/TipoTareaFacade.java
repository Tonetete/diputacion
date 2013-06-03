/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.TipoTarea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tone
 */
@Stateless
public class TipoTareaFacade extends AbstractFacade<TipoTarea> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoTareaFacade() {
        super(TipoTarea.class);
    }

    public List<TipoTarea> getTipoTareaByCod(int id)
    {
        Query q = em.createNamedQuery("TipoTarea.findById").setParameter("id", id);
        return (List<TipoTarea>) q.getResultList();
    } 
    
}
