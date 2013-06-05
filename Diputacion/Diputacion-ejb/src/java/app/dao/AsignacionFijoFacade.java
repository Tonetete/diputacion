/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.AsignacionFijo;
import app.entity.Usuario;
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
public class AsignacionFijoFacade extends AbstractFacade<AsignacionFijo> {
    @PersistenceContext(unitName = "Diputacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionFijoFacade() {
        super(AsignacionFijo.class);
    }
    
    public void insertAsignacionFijo(AsignacionFijo asignF)
    {
        em.getTransaction().begin();
        
        em.persist(asignF);
        em.getTransaction().commit();
    }

    public List<AsignacionFijo> getFijosAsignadosbyDni(Usuario dni)
    {
        Query q = em.createQuery("SELECT a FROM AsignacionFijo a WHERE a.dni = :dni")
                .setParameter("dni", dni);

        return q.getResultList();
    }
    
    public AsignacionFijo comprobarAsignacionLineaNumero(int codigoNumero, int codigoTerminal, String dni){
        AsignacionFijo a = new AsignacionFijo();
        List<AsignacionFijo> la = new ArrayList<AsignacionFijo>();
        try{
          Query q = em.createQuery("SELECT a FROM AsignacionFijo a WHERE a.asignado = 'S' AND a.dni.dni <> :dni AND (a.codigoNumero.codigo = :codigoNumero OR a.codigoTerminal.codigo = :codigoTerminal)")
                  .setParameter("codigoNumero", codigoNumero)
                  .setParameter("codigoTerminal", codigoTerminal)
                  .setParameter("dni", dni);
          a = (AsignacionFijo)q.getSingleResult();         
          //la = (List<AsignacionFijo>)q.getResultList();         
        }
        catch(NoResultException e){
            return null;
        }
        return a;
        
    }
    
    public void delete(AsignacionFijo um)
    {
        Query q = em.createQuery("DELETE FROM AsignacionFijo am WHERE am.codigo = :codigo").setParameter("codigo", um.getCodigo());
        q.executeUpdate();
    }
    
}
