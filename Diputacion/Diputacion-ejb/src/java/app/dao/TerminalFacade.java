/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Terminal;
import java.util.ArrayList;
import java.util.List;
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
public class TerminalFacade extends AbstractFacade<Terminal> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TerminalFacade() {
        super(Terminal.class);
    }

    public void insert(Terminal t){
        em.persist(t);
    }
    
    public List<Terminal> findByFijoAndAsig(){
        List<Terminal> lista = new ArrayList<Terminal>();
        try{
        Query q1 = em.createQuery("SELECT t FROM Terminal t WHERE t.configuracion = 'FIJO' AND t.codigo NOT IN (SELECT a.codigoTerminal.codigo FROM AsignacionFijo a WHERE a.asignado = 'S')");
        //return (List<Terminal>)q1.getResultList();
//        Query q2 = em.createQuery("SELECT t FROM Terminal t WHERE t.configuracion = 'FIJO' AND t.codigo <> (SELECT a.codigoTerminal.codigo FROM AsignacionFijo a WHERE a.codigo = :codigo)")
//                .setParameter("codigo", codigo);
        lista.addAll((List<Terminal>)q1.getResultList());
//        lista.addAll((List<Terminal>)q2.getResultList());
        //return (List<Terminal>)q1.getResultList();
        return lista;
        } catch(NoResultException e) {
            return null;
        }
        
    }
    
    public List<Terminal> findByMovilAndAsig(){
        List<Terminal> lista = new ArrayList<Terminal>();
        try{
        Query q1 = em.createQuery("SELECT t FROM Terminal t WHERE t.configuracion = 'MOVIL' AND t.codigo NOT IN (SELECT a.codigoTerminal.codigo FROM AsignacionMovil a WHERE a.asignado = 'S')");
//        Query q2 = em.createQuery("SELECT t FROM Terminal t WHERE t.configuracion = 'MOVIL' AND t.codigo <> (SELECT a.codigoTerminal.codigo FROM AsignacionMovil a WHERE a.codigo = :codigo)")
//                .setParameter("codigo", codigo);
        lista.addAll((List<Terminal>)q1.getResultList());
//        lista.addAll((List<Terminal>)q2.getResultList());
        return lista;
        //return (List<Terminal>)q.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        
    }
    
    public Terminal findbysn(int sn){
        try{
        Query q = em.createQuery("SELECT t FROM Terminal t WHERE t.sn = :sn").setParameter("sn", sn);
        return (Terminal)q.getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        
    }
    
    public void delete(Terminal t){
        Query q = em.createQuery("DELETE FROM Terminal term WHERE term.codigo = :cod").setParameter("cod", t.getCodigo());
        q.executeUpdate();
    }
    
}
