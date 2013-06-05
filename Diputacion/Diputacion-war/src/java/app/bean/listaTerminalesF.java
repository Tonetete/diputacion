/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.AsignacionFijoFacade;
import app.dao.CategoriaFacade;
import app.dao.LineaFacade;
import app.dao.PerfilFacade;
import app.dao.TerminalFacade;
import app.dao.UsuarioFacade;
import app.entity.AsignacionFijo;
import app.entity.Categoria;
import app.entity.Linea;
import app.entity.Perfil;
import app.entity.Terminal;
import app.entity.Usuario;
import java.math.BigDecimal;
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
public class listaTerminalesF
{
    @EJB
    private AsignacionFijoFacade AsigFacaF;
    @EJB
    private LineaFacade lineaFaca;
    @EJB
    private CategoriaFacade catFaca;
    @EJB
    private TerminalFacade terminalFaca;
    @EJB
    private UsuarioFacade usuarioFaca;
    @EJB
    private AsignacionFijoFacade aFacade;
    
    List<AsignacionFijo> listaAsigFijo;
    List<AsignacionFijo> listaAsigFijo_2;
    
    private char codigoAsignado;
    private Date fechaIniDate;
    private Date fechaFinDate;
    private Long codigo;
    private int codigoTerminal;
    private int codigoNumero;
    private int codigoCategoria;
    private BigDecimal coste;
    private String dni;
    private String fechaFin;
    private String fechaIni;
    /**
     * Creates a new instance of listaTerminales
     */
    @PostConstruct
    public void listaTarea()
    {
        Map<String,Object> map = FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap();
        Usuario u = (Usuario)map.get("usuario");
        listaAsigFijo = AsigFacaF.getFijosAsignadosbyDni(u);
        listaAsigFijo_2 = AsigFacaF.findAll();
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
    public void setCodigoCategoria(int codigoCategoria)
    {
        this.codigoCategoria = codigoCategoria;
    }
    
    public int getCodigoCategoria()
    {
        return codigoCategoria;
    }
    //Fin CodigoPerfil
    
    //Inicio Coste
    public void setCoste(BigDecimal coste)
    {
        this.coste = coste;
    }
    
    public BigDecimal getCoste()
    {
        return coste;
    }
    //Fin Coste
    
    
    public void setListaAsigFijo(List<AsignacionFijo> listaAsigFijo)
    {
        this.listaAsigFijo = listaAsigFijo;
    }
    
    public List<AsignacionFijo> getListaAsigFijo()
    {
        return listaAsigFijo;
    }
    
    public void setListaAsigFijo_2(List<AsignacionFijo> listaAsigFijo)
    {
        this.listaAsigFijo_2 = listaAsigFijo;
    }
    
    public List<AsignacionFijo> getListaAsigFijo_2()
    {
        return listaAsigFijo_2;
    }
    
    public void borrarF()
    {
        AsignacionFijo am;
        am = (AsignacionFijo) AsigFacaF.find(codigo);
        AsigFacaF.delete(am);
    }
    
    /**
     *
     */
    public void modificar()
    {
        // Comprobamos que no esté asignado la línea o número a otro usuario
        RequestContext reqCtx = RequestContext.getCurrentInstance();
        AsignacionFijo a = aFacade.comprobarAsignacionLineaNumero(codigoNumero, codigoTerminal, dni);
        
        if(a!=null){
            reqCtx.addCallbackParam("error", "asignado");
        }
        
        else{
        
            AsignacionFijo am = new AsignacionFijo();

            am.setAsignado(codigoAsignado);

            am.setCodigo(codigo);

            Linea l = lineaFaca.find(codigoNumero);
            am.setCodigoNumero(l);

            Terminal t = terminalFaca.find(codigoTerminal);
            am.setCodigoTerminal(t);

            am.setCoste(coste);

            Usuario u = usuarioFaca.find(dni);
            am.setDni(u);

            Categoria c = catFaca.find(codigoCategoria);
            am.setCodigoCat(c);
            am.setFechaAsignacion(fechaIniDate);

            am.setFechaFin(fechaFinDate);

            AsigFacaF.edit(am);


            reqCtx.addCallbackParam("terminal", am.getCodigoTerminal().getMarca()+" "+am.getCodigoTerminal().getModelo());
            reqCtx.addCallbackParam("asignado", String.valueOf(am.getAsignado()));        
            reqCtx.addCallbackParam("numero", am.getCodigoNumero().getNumero());
            reqCtx.addCallbackParam("usuario", am.getDni().getDni());
            reqCtx.addCallbackParam("fechaini", am.getFechaIniStr());
            reqCtx.addCallbackParam("fechafin", am.getFechaFinStr()); 
            reqCtx.addCallbackParam("categoria", am.getCodigoCat().getDescripcion()); 
            reqCtx.addCallbackParam("idcategoria", am.getCodigoCat().getCodigo()); 
            reqCtx.addCallbackParam("idterminal", am.getCodigoTerminal().getCodigo()); 
        }
    }
}
