/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Linea;
import app.entity.Llamada;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tone
 */
@Stateless
public class LlamadaFacade extends AbstractFacade<Llamada> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LlamadaFacade() {
        super(Llamada.class);
    }

    public List<Llamada> findByLinea(Linea linea) {
        return em.createNamedQuery("Llamada.findByCodigoNumero")
                .setParameter("codigoNumero", linea.getCodigo())
                .getResultList();
    }
    
}
