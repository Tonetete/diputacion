/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package app.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import app.dao.UsuarioFacade;
import app.entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Tone
 */
@ManagedBean
@RequestScoped
public class LoginBean implements Serializable {

    @EJB
    private UsuarioFacade userFacade;

    private String nombre;
    private String contrasena;

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public void logear() throws IOException{

        Usuario u = userFacade.getUsuarioContrasena(nombre, contrasena);

        JsonElement jsonElem = null;
        JsonObject json = new JsonObject();
        Gson gson = new Gson();

        if(u==null){
            jsonElem = gson.toJsonTree(-1);
        }
        else{           
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext context = facesContext.getExternalContext();  
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
            FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            FacesContext.getCurrentInstance().getExternalContext().setResponseContentType(contrasena);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", u);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("rol", u.getCodigoRol().getTipo());           
            context.redirect("main.jsf");
        }
        
        // Si el usuario es nulo, no existe, por lo tanto enviaremos los datos a través de json
        // y en el javascript mostraremos el splash de error a través de p:commandbutton en login.xhtml
        //json.add("usuariorol", jsonElem);
        RequestContext reqCtx = RequestContext.getCurrentInstance();
        reqCtx.addCallbackParam("usuariorol", -1);
    }
}
