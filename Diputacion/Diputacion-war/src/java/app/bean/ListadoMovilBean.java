/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.AsignacionFijoFacade;
import app.dao.TerminalFacade;
import app.dao.UsuarioFacade;
import app.entity.AsignacionFijo;
import app.entity.Usuario;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author urden
 */
@ManagedBean
@RequestScoped
public class ListadoMovilBean {

    /**
     * Creates a new instance of ListadoMovilBean
     */
    @EJB
    TerminalFacade tF;
    @EJB
    UsuarioFacade uF;
    @EJB
    AsignacionFijoFacade asigfF;
    
    int dni;
    List<AsignacionFijo> asignfijo;
    private Usuario user;
    public ListadoMovilBean() 
    {
    }
    
    public List<AsignacionFijo> getAsignF()
    {
        return asigfF.findAll();
    }
    public void setAsignFijo(List<AsignacionFijo> a)
    {
        asignfijo = a;
    }
    public Integer getDni()
    {
        return dni;
    }
    public void setDni(int d)
    {
        dni = d;
    }
    public void serUser(Usuario u)
    {
        user = u;
    }
    public Usuario getUser()
    {
        return user;
    }
    public String doEnviar()
    {
        user = null;
        List<Usuario> lU = uF.findAll();
        for (int i = 0; i < lU.size(); i++) {
            if(lU.get(i).getDni().equals(dni))
            {
                user = lU.get(i);
            }
        }
        
        asignfijo = asigfF.findAll();
        if(!user.equals("null"))
            return "success";
        else
            return"bad";
    }
}
