/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Diputacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tone
 */
@Stateless
public class DiputacionFacade extends AbstractFacade<Diputacion> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiputacionFacade() {
        super(Diputacion.class);
    }
    
    public Diputacion getDiputacionByCiudad(String ciudad){
        Query q = em.createNamedQuery("Diputacion.findByCiudad").setParameter("ciudad", ciudad);
        return (Diputacion)q.getSingleResult();
    }
    
}
