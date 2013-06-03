/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Tarea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Tone
 */
@Stateless
public class TareaFacade extends AbstractFacade<Tarea> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareaFacade() {
        super(Tarea.class);
    }

    public void insert(Tarea t)
    {
        em.persist(t);
    }
    
    public Tarea findByIdTarea(int idTarea)
    {
        return (Tarea) em.createNamedQuery("Tarea.findByIdTarea").setParameter("idTarea", idTarea).getSingleResult();
    }
    
    public List<Tarea> findByValidado(char c)
    {
        return (List<Tarea>) em.createNamedQuery("Tarea.findByValidado").setParameter("validado", c).getResultList();
    }
    public void borrarTarea(int idTarea)
    {  
        em.createQuery("DELETE FROM Tarea t where t.idTarea =:idTarea").setParameter("idTarea", idTarea).executeUpdate();
        em.getTransaction().commit();
    }
}
