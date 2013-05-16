/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Diputacion;
import app.entity.Roles;
import app.entity.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Tone
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    
    private RolesFacade rolFacade;    
    private DiputacionFacade dipFacade;

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
    public Usuario getUsuarioContrasena(String usuario, String contrasena){
        Usuario u;
        try{
            u = (Usuario)em.createQuery(
                "SELECT u FROM Usuario u WHERE u.dni = :usuario AND u.contrasena = :contrasena")
                .setParameter("usuario", usuario)
                .setParameter("contrasena", contrasena)
                .getSingleResult();
        } catch(NoResultException e) {
            return null;
        }
        return u;
        
    }

    public void insert(Usuario u) {
        em.persist(u);
    }

    public void delete(Usuario u) {
        Query q = em.createQuery("DELETE FROM Usuario u WHERE u.dni = :dni").setParameter("dni", u.getDni());
        q.executeUpdate();
    }
    
}
