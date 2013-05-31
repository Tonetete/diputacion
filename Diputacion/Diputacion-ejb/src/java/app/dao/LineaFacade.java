/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Linea;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    
    public void delete(Linea l) {
        Query q = em.createQuery("DELETE FROM Linea l WHERE l.codigo = :codigo").setParameter("codigo", l.getCodigo());
        q.executeUpdate();
    }
    
    public void insert(Linea l){
        em.persist(l);
    }

    public Linea findByNumero(String numero) {
        Linea l;
        try{
         Query q = em.createNamedQuery("Linea.findByNumero").setParameter("numero", numero);
         l = (Linea)q.getSingleResult();
         } catch(NoResultException e) {
            return null;
        }
        return l;
    }

    public int getMaxCodigo() {
        Query q = em.createQuery("SELECT MAX(l.codigo) FROM Linea l");
        int max = (Integer)q.getSingleResult();
        return max++;
    }

}
