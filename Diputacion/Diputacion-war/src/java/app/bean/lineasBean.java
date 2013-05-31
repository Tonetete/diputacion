/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.LineaFacade;
import app.entity.Linea;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Pablo
 */
@ManagedBean
@ViewScoped
@RequestScoped
public class lineasBean {

    @EJB
    private LineaFacade lineaFac;
    private int codigo;
    protected String numero;
    protected String fecha_fact;
    protected Date fecha_fact_date;
    protected char publico;
    public lineasBean() {
    }
    
    public int getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public String getNumero(){
        return this.numero;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public String getFechaFact(){ 
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");        
        if(fecha_fact_date!=null)
            return formatoFecha.format(fecha_fact_date);
        return null;
    }
    
    public void setFechaFact(String fecha){
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        try {        
            this.fecha_fact_date = formatoFecha.parse(fecha);
            this.fecha_fact = fecha;
        } catch (ParseException ex) {
            Logger.getLogger(lineasBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.fecha_fact = fecha;
    }
    
    public char getPublico(){
        return this.publico;
    }
    
    public void setPublico(char c){
        this.publico = c;
    }
    
    public List<Linea> getListaLineas(){
        List<Linea> listaLinea = (List<Linea>)lineaFac.findAll();
        return listaLinea;
    }
    
    public void borrar()
    {
        Linea l = new Linea();
        l = (Linea)lineaFac.find(codigo);
        lineaFac.delete(l);
    }
    
    public void insertar(){
        Linea l = lineaFac.findByNumero(numero);
        if(l==null){
            l = new Linea();
            l.setNumero(numero);
            l.setPeriodoFacturacion(fecha_fact_date);
            l.setPublico(publico);
            lineaFac.insert(l);
            l = lineaFac.findByNumero(numero);
            
        }
        else{
            l.setNumero(numero);
            l.setPeriodoFacturacion(fecha_fact_date);
            l.setPublico(publico);
            lineaFac.edit(l);            
        }
//        SimpleDateFormat formateador = new SimpleDateFormat(
//        "dd 'de' MMMM 'de' yyyy", new Locale("es","ES"));
//        String f = formateador.format(fecha_fact_date);
        RequestContext reqCtx = RequestContext.getCurrentInstance();
        reqCtx.addCallbackParam("codigo", l.getCodigo());
        reqCtx.addCallbackParam("numero", l.getNumero());        
        reqCtx.addCallbackParam("fecha", l.getFechaFact());
        reqCtx.addCallbackParam("publico", l.getPublico().toString());
//        System.out.println(reqCtx.getCallbackParams().toString());
    }
}
