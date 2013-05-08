/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

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
    
}
