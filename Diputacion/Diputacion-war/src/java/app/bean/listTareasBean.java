/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;


import app.dao.AsignacionFijoFacade;
import app.dao.TareaFacade;
import app.entity.AsignacionFijo;
import app.entity.Tarea;
import app.entity.Usuario;
import java.text.DateFormat;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author urden
 */
@ManagedBean
@SessionScoped
public class listTareasBean {

    /**
     * Creates a new instance of listTareasBean
     */
    @EJB
    TareaFacade tF;
    @EJB
    AsignacionFijoFacade asF;
    
    Tarea tarea;
    Usuario user;
    int dni;
    int id;

    public listTareasBean() 
    {
    }
    //-----get-set tarea
    public void setTarea(Tarea t)
    {
        tarea = t;
    }
    @PostConstruct
    public List<Tarea> getTarea()
    {
        return tF.findByValidado('N');
    }
    //--------
    public void setUsuario(Usuario u)
    {
        user = u;
    }
    @PostConstruct
    public Usuario getUsuario()
    {
        return (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
    }
    public int getIdTarea()
    {
        return id;
    }
    public void setIdTarea(int i)
    {
        id = i;
    }
    
    @PostConstruct
    public String borrar()
    {
        Tarea t = tF.findByIdTarea(id);
        //AsignacionFijo as = crearAsignacion(t);
        //asF.remove(as);
       // tF.borrarTarea(id);
        tF.remove(t);
        return null;
    }
    
    @PostConstruct
    public String add()
    {
        Tarea t = tF.findByIdTarea(id);
        AsignacionFijo as = crearAsignacion(t);
        asF.create(as);
        borrar();
        
        return null;
    }
   // @PostConstruct
    public AsignacionFijo crearAsignacion(Tarea t)
    {
        AsignacionFijo as = new AsignacionFijo();
        
        SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
        String strFecha = "2015-11-25";
        Date fecha = null;
        try {        
            fecha = formatoDelTexto.parse(strFecha);
        } catch (ParseException ex) {
            Logger.getLogger(listTareasBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        System.out.println(t.getFechaEmision());
        as.setFechaAsignacion(t.getFechaEmision());
        as.setFechaFin(fecha);
        as.setDni(t.getDniTareaAsignado());
        as.setCodigoNumero(t.getCodigoNumero());
        as.setCodigoTerminal(t.getCodigoTerminal());
        as.setCodigoCat(t.getCodigoCategoria());
        as.setAsignado('S');
        
        as.setCoste(null);
        
        as.setCodigo(Long.parseLong(String.valueOf(asF.findAll().size() + 1))); //identificador
        return as;
    }
    
    //-------------
    
    public String doEnviar()
    {
        tarea = (Tarea) tF.findAll();            
        return "success";
        
    }
    
}
