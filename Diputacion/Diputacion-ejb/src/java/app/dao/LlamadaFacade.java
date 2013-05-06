/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Linea;
import app.entity.Llamada;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

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
    
    public List<Llamada> findByCodigoNumero(Linea codigoNumero){
        List<Llamada> l = (List<Llamada>)em.createQuery(
                "SELECT l FROM Llamada l WHERE l.codigoNumero = :codigoNumero")
                .setParameter("codigoNumero", codigoNumero)
                .getResultList();
        return l;
    }
    
}
