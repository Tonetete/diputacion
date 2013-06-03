/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.dao;

import app.entity.Linea;
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
    
    public List<Linea> findNoAsig(){
        try{
        Query q = em.createQuery("SELECT l FROM Linea l WHERE l.codigo NOT IN (SELECT af.codigoNumero.codigo FROM AsignacionFijo af WHERE af.asignado = 'S') AND l.codigo NOT IN (SELECT am.codigoNumero.codigo FROM AsignacionMovil am WHERE am.asignado = 'S')");
        return (List<Linea>)q.getResultList();
        } catch(NoResultException e) {
            return null;
        }
        
    }

    public int getMaxCodigo() {
        Query q = em.createQuery("SELECT MAX(l.codigo) FROM Linea l");
        int max = (Integer)q.getSingleResult();
        return max++;
    }
	
	public List<Linea> findAsignadasByUsuario(String dni) {
//		String strQuery = "SELECT l FROM Linea l, AsignacionFijo af, Usuario u WHERE l.numero = af.codigoNumero AND af.dni.dni = :dni";
//		String strQuery = "SELECT l FROM Linea l WHERE l.asignacionFijoCollection.dni.dni = :dni";
		String strQuery = "SELECT l FROM Linea l WHERE :dni MEMBER OF l.asignacionFijoCollection.dni";
		Query query = em.createQuery(strQuery, Linea.class).setParameter("dni", dni);
//		String strQuery = "SELECT l FROM Linea l, AsignacionFijo af WHERE l.numero = af.codigoNumero AND af.dni = :usuario";
//		Query query = em.createQuery(strQuery, Linea.class).setParameter("usuario", usuario);
		return (List<Linea>) query.getResultList();
	}

    public List<Linea> getNumByCod(int codigo)
    {
        Query q = em.createNamedQuery("Linea.findByCodigo").setParameter("codigo", codigo);
        return (List<Linea>) q.getResultList();
    }

}
