/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.TerminalFacade;
import app.entity.Terminal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Usuario
 */
@ManagedBean
@RequestScoped
@ViewScoped
public class terminalesBean {
    @EJB
    private TerminalFacade termFac;
    private int codigo;
    private String fecha_alta;
    private Date fecha_alta_date;
    private String marca;
    private String modelo;
    private String configuracion;
    private int sn;
    private List<Terminal> terminales;
    private int codigoAsig;
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getFechaAlta(){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");        
        if(fecha_alta_date!=null)
            return formatoFecha.format(fecha_alta_date);
        return null;
    }
    
    public void setFechaAlta(String fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {        
            this.fecha_alta_date = formatoFecha.parse(fecha);
            this.fecha_alta = fecha;
        } catch (ParseException ex) {
            Logger.getLogger(lineasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getMarca(){
        return this.marca;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    
    public String getConfiguracion(){
        return this.configuracion;
    }
    
    public void setConfiguracion(String configuracion){
        this.configuracion = configuracion;
    }
    
    public int getSN(){
        return this.sn;
    }
    
    public void setSN(int sn){
        this.sn = sn;
    }
    
    public void setCodigoAsig(int codigoAsig){
        this.codigoAsig = codigoAsig;
    }
    
    
    public List<Terminal> getTerminales(){
        terminales = (List<Terminal>)termFac.findAll();
        return this.terminales;
    }
    
    public List<Terminal> getTerminalesFijoAndAsig(){
        terminales = (List<Terminal>)termFac.findByFijoAndAsig();
        return this.terminales;
    }
    
    public List<Terminal> getTerminalesMovilAndAsig(){
        terminales = (List<Terminal>)termFac.findByMovilAndAsig();
        return this.terminales;
    }
    
    public void setTerminales(List<Terminal> terminales){
        this.terminales = terminales;
    }
    
    public void borrar(){
        Terminal t = new Terminal();
        t = termFac.find(codigo);
        termFac.delete(t);
    }
    
    public void insert(){
        Terminal t;
        t =(Terminal)termFac.findbysn(sn);
        if(t == null && this.sn != 0){
            t = new Terminal();
            //t.setCodigo(codigo);                 
            t.setFechaAlta(new Date());
            t.setConfiguracion(configuracion);
            t.setMarca(marca);
            t.setModelo(modelo);
            t.setSn(sn);
            termFac.insert(t);
        }
        else{
            t.setConfiguracion(configuracion);
            t.setMarca(marca);
            t.setModelo(modelo);
            t.setSn(sn);
            termFac.edit(t);
        }
        RequestContext reqCtx = RequestContext.getCurrentInstance();
        reqCtx.addCallbackParam("codigo", t.getCodigo());
        reqCtx.addCallbackParam("fecha_alta", t.getFechaAltaStr());        
        reqCtx.addCallbackParam("marca", t.getMarca());
        reqCtx.addCallbackParam("modelo", t.getModelo());
        reqCtx.addCallbackParam("configuracion", t.getConfiguracion());
        reqCtx.addCallbackParam("sn", t.getSn());
    }
    public terminalesBean() {
    }
}
