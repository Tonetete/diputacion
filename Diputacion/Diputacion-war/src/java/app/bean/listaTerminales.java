/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.AsignacionMovilFacade;
import app.dao.LineaFacade;
import app.dao.PerfilFacade;
import app.dao.TerminalFacade;
import app.dao.UsuarioFacade;
import app.entity.AsignacionMovil;
import app.entity.Linea;
import app.entity.Perfil;
import app.entity.Terminal;
import app.entity.Usuario;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Deiver
 */
@ManagedBean
@RequestScoped
public class listaTerminales
{    
    @EJB
    private AsignacionMovilFacade AsigFaca;
    @EJB
    private LineaFacade lineaFaca;
    @EJB
    private PerfilFacade perfilFaca;
    @EJB
    private TerminalFacade terminalFaca;
    @EJB
    private UsuarioFacade usuarioFaca;
    
    List<AsignacionMovil> listaAsigMovil;
    List<AsignacionMovil> listaAsigMovil_2;
    
    private char codigoAsignado;
    private String fechaFin;
    private String fechaIni;
    private Long codigo;
    private int codigoTerminal;
    private int codigoNumero;
    private int codigoPerfil;
    private BigInteger coste;
    private String dni;
    private Date fechaIniDate;
    private Date fechaFinDate;
    /**
     * Creates a new instance of listaTerminales
     */
    @PostConstruct
    public void listaTarea()
    {
        Map<String,Object> map = FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap();
        Usuario u = (Usuario)map.get("usuario");
        listaAsigMovil = AsigFaca.getMovilesAsignadosbyDni(u);
        listaAsigMovil_2 = AsigFaca.findAll();
    }
    
    //Inicio CodAsignado
    public void setCodAsignado(char codigoAsignado)
    {
        this.codigoAsignado = codigoAsignado;
    }
    
    public char getCodAsignado()
    {
        return codigoAsignado;
    }
    //Fin CodAsignado
    
    //Inicio FechaAsignacion
    public void setFechaAsig(String fecha)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {        
            this.fechaIniDate = formatoFecha.parse(fecha);
            this.fechaIni = fecha;
        } catch (ParseException ex) {
            Logger.getLogger(lineasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFechaAsig()
    {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");        
        if(fechaIniDate!=null)
            return formatoFecha.format(fechaIniDate);
        return null;
    }
    //Fin FechaAsignacion
    
    //Inicio FechaFin
    public void setFechaFin(String fecha)
    {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {        
            this.fechaFinDate = formatoFecha.parse(fecha);
            this.fechaFin = fecha;
        } catch (ParseException ex) {
            Logger.getLogger(lineasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getFechaFin()
    {
         SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");        
        if(fechaFinDate!=null)
            return formatoFecha.format(fechaFinDate);
        return null;
    }
    //Fin FechaFin
    
    //Inicio Codigo
    public void setCodigo(Long codigo)
    {
        this.codigo = codigo;
    }
    
    public Long getCodigo()
    {
        return codigo;
    }
    //Fin Codigo
    
    //Inicio CodigoTerminal
    public void setCodigoTerminal(int codigoTerminal)
    {
        this.codigoTerminal = codigoTerminal;
    }
    
    public int getCodigoTerminal()
    {
        return codigoTerminal;
    }
    //Fin CodigoTerminal
    
    //Inicio CodigoNumero
    public void setCodigoNumero(int codigoNumero)
    {
        this.codigoNumero = codigoNumero;
    }
    
    public int getCodigoNumero()
    {
        return codigoNumero;
    }
    //Fin CodigoNumero
    
    //Inicio Dni
    public void setDni(String dni)
    {
        this.dni = dni;
    }
    
    public String getDni()
    {
        return dni;
    }
    //Fin Dni
    
    //Inicio CodigoPerfil
    public void setCodigoPerfil(int codigoPerfil)
    {
        this.codigoPerfil = codigoPerfil;
    }
    
    public int getCodigoPerfil()
    {
        return codigoPerfil;
    }
    //Fin CodigoPerfil
    
    //Inicio Coste
    public void setCoste(BigInteger coste)
    {
        this.coste = coste;
    }
    
    public BigInteger getCoste()
    {
        return coste;
    }
    //Fin Coste
    
    
    public void setListaAsigMovil(List<AsignacionMovil> listaAsigMovil)
    {
        this.listaAsigMovil = listaAsigMovil;
    }
    
    public List<AsignacionMovil> getListaAsigMovil()
    {
        return listaAsigMovil;
    }
    
    public void setListaAsigMovil_2(List<AsignacionMovil> listaAsigMovil)
    {
        this.listaAsigMovil_2 = listaAsigMovil;
    }
    
    public List<AsignacionMovil> getListaAsigMovil_2()
    {
        return listaAsigMovil_2;
    }
    
    public void borrar()
    {
        AsignacionMovil am;
        am = (AsignacionMovil) AsigFaca.find(codigo);
        AsigFaca.delete(am);
    }
    
    /**
     *
     */
    public void modificar()
    {
        AsignacionMovil am = new AsignacionMovil();
        
        am.setAsignado(codigoAsignado);
        
        am.setCodigo(codigo);
        
        Linea l = lineaFaca.find(codigoNumero);
        am.setCodigoNumero(l);
        
        Perfil p = perfilFaca.find(codigoPerfil);
        am.setCodigoPerfil(p);
        
        Terminal t = terminalFaca.find(codigoTerminal);
        am.setCodigoTerminal(t);
        
        am.setCoste(coste);
        
        Usuario u = usuarioFaca.find(dni);
        am.setDni(u);
        
        am.setFechaAsignacion(fechaIniDate);
        
        am.setFechaFin(fechaFinDate);
        
        AsigFaca.edit(am);
        
        RequestContext reqCtx = RequestContext.getCurrentInstance();
        reqCtx.addCallbackParam("terminal", am.getCodigoTerminal().getMarca()+" "+am.getCodigoTerminal().getModelo());
        reqCtx.addCallbackParam("asignado", String.valueOf(am.getAsignado()));        
        reqCtx.addCallbackParam("numero", am.getCodigoNumero().getNumero());
        reqCtx.addCallbackParam("usuario", am.getDni().getDni());
        reqCtx.addCallbackParam("fechaini", am.getFechaIniStr());
        reqCtx.addCallbackParam("fechafin", am.getFechaFinStr()); 
        reqCtx.addCallbackParam("perfil", am.getCodigoPerfil().getDescripcion()); 
        reqCtx.addCallbackParam("idperfil", am.getCodigoPerfil().getCodigo()); 
        reqCtx.addCallbackParam("idterminal", am.getCodigoTerminal().getCodigo()); 
    }
}
