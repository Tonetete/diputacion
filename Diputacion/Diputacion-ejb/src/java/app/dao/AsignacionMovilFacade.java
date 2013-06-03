/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.AsignacionMovil;
import app.entity.Usuario;
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
public class AsignacionMovilFacade extends AbstractFacade<AsignacionMovil> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionMovilFacade() {
        super(AsignacionMovil.class);
    }

    public List<AsignacionMovil> getMovilesAsignadosbyDni(Usuario dni)
    {
        Query q = em.createQuery("SELECT a FROM AsignacionMovil a WHERE a.dni = :dni")
                .setParameter("dni", dni);

        return q.getResultList();
    }
    
    public void delete(AsignacionMovil um)
    {
        Query q = em.createQuery("DELETE FROM AsignacionMovil am WHERE am.codigo = :codigo").setParameter("codigo", um.getCodigo());
        q.executeUpdate();
    }
    
}
