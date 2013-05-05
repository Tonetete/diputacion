/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Linea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tone
 */
@Stateless
public class LineaFacade extends AbstractFacade<Linea> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LineaFacade() {
        super(Linea.class);
    }
    
    public Linea findByNumero(String numero) {
        return (Linea) em.createNamedQuery("Linea.findByNumero")
                .setParameter("numero", numero)
                .getSingleResult();
    }
}
