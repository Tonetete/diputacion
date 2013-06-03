/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.LineaFacade;
import app.dao.UsuarioFacade;
import app.entity.AsignacionFijo;
import app.entity.AsignacionMovil;
import app.entity.GrupoRescate;
import app.entity.Linea;
import app.entity.Llamada;
import app.entity.Usuario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Francisco Manuel Fernández Lozano
 */
@ManagedBean
@RequestScoped
public class FacturacionBean {
	@EJB
    private LineaFacade lineaFacade;
	
	private Linea lineaActual;

	public List<Linea> getLineas() {
		Map<String, Object> i = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Usuario usuario = (Usuario) i.get("usuario");

		List<Linea> lineas = new ArrayList<Linea>();

		Collection<AsignacionFijo> asigFijos = usuario.getAsignacionFijoCollection();
		for (AsignacionFijo asig : asigFijos) {
			if (asig.getAsignado() == 'S') {
				Linea linea = asig.getCodigoNumero();
				lineas.add(linea);
			}
		}

		Collection<AsignacionMovil> asigMoviles = usuario.getAsignacionMovilCollection();
		for (AsignacionMovil asig : asigMoviles) {
			if (asig.getAsignado() == 'S') {
				Linea linea = asig.getCodigoNumero();
				lineas.add(linea);
			}
		}
		
		
//		lineas = lineaFacade.findAsignadasByUsuario(usuario.getDni());
		
		
		
		if (lineaActual == null && !lineas.isEmpty())
			lineaActual = lineas.get(0);

		return lineas;
	}

	public Collection<Llamada> getLlamadas() {
//		Map<String, Objesct> i = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		Usuario usuario = (Usuario) i.get("usuario");
//
//		Linea linea = null;
//		
//		if (numeroLineaActual == null) {
//			// Ninguna línea, mostramos la 1º línea encontrada
//			Iterator<AsignacionFijo> itFijos = usuario.getAsignacionFijoCollection().iterator();
//			while (itFijos.hasNext() && linea == null) {
//				AsignacionFijo asig = itFijos.next();
//				if (asig.getAsignado() == 'S') {
//					linea = asig.getCodigoNumero();
//				}
//			}
//
//			Iterator<AsignacionMovil> itMovil = usuario.getAsignacionMovilCollection().iterator();
//			while (itMovil.hasNext() && linea == null) {
//				AsignacionMovil asig = itMovil.next();
//				if (asig.getAsignado() == 'S') {
//					linea = asig.getCodigoNumero();
//				}
//			}
//		} else {
//			// Mostramos la línea
//			
//		}
//		
//		
//
//		return llamadas;
		
		Logger.getGlobal().log(Level.WARNING, "getLlamadas. lineaActual: " + lineaActual);
		
		return lineaActual == null ? null : lineaActual.getLlamadaCollection();
	}
	
	public Boolean hasLlamadas() {
		return lineaActual == null ? Boolean.FALSE : !lineaActual.getLlamadaCollection().isEmpty();
	}
	
	public Collection<Usuario> getUsuariosGrupoRescate() {
		Map<String, Object> i = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Usuario usuario = (Usuario) i.get("usuario");
		
		GrupoRescate grupoRescate = usuario.getCodigoRescate();
		
		return grupoRescate.getUsuarioCollection();
	}
	
	public String getNumeroLineaActual() {
		return lineaActual == null ? null : lineaActual.getNumero();
	}
	
	public void setNumeroLineaActual(String numeroLinea) {
		Logger.getGlobal().log(Level.WARNING, "setNumeroLineaActual: " + numeroLinea);
		this.lineaActual = lineaFacade.findByNumero(numeroLinea);
	}
	
//	public String getCodigoLineaActual() {
//		return lineaActual == null ? null : lineaActual.getNumero();
//	}
//	
//	public void setCodigoLineaActual(String numeroLinea) {
//		this.lineaActual = lineaFacade.findByNumero(numeroLinea);
//	}
}
