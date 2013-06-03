/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.GrupoRescate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tone
 */
@Stateless
public class GrupoRescateFacade extends AbstractFacade<GrupoRescate> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GrupoRescateFacade() {
        super(GrupoRescate.class);
    }

    public GrupoRescate findByNombre(String nombre) {
        GrupoRescate res = (GrupoRescate) em.createNamedQuery("GrupoRescate.findByNombre").setParameter("nombre", nombre).getSingleResult();
        return res;
    }
    
    public GrupoRescate findByCodigo(int codigo) {
        GrupoRescate res = (GrupoRescate) em.createNamedQuery("GrupoRescate.findByCodigo").setParameter("codigo", codigo).getSingleResult();
        return res;
    }
    
}
