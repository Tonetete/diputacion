/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Diputacion;
import app.entity.Roles;
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
public class RolesFacade extends AbstractFacade<Roles> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }
    
    public Roles getRolByTipo(String tipo){
        Query q = em.createNamedQuery("Roles.findByTipo").setParameter("tipo", tipo);
        return (Roles)q.getSingleResult();
    }
    
    public List<String> getRolAll(){
        Query q = em.createQuery("SELECT r.tipo FROM Roles r");
        return (List<String>)q.getResultList();
    }
    
}
