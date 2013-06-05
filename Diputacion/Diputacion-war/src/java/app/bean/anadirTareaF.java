/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.bean;

import app.dao.CategoriaFacade;
import app.dao.DiputacionFacade;
import app.dao.LineaFacade;
import app.dao.PerfilFacade;
import app.dao.RolesFacade;
import app.dao.TareaFacade;
import app.dao.TerminalFacade;
import app.dao.TipoTareaFacade;
import app.dao.UsuarioFacade;
import app.entity.Categoria;
import app.entity.Diputacion;
import app.entity.Linea;
import app.entity.Perfil;
import app.entity.Roles;
import app.entity.Tarea;
import app.entity.Terminal;
import app.entity.TipoTarea;
import app.entity.Usuario;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Deiver
 */
@ManagedBean
@RequestScoped
public class anadirTareaF
{
    @EJB
    private TipoTareaFacade tipoTareaFaca;
    @EJB
    private PerfilFacade perfilFaca;
    @EJB
    private CategoriaFacade cateFaca;
    @EJB
    private LineaFacade lineaFaca;
    @EJB
    private TareaFacade tareaFaca;
    @EJB
    private TerminalFacade terminalFaca;
    @EJB
    private UsuarioFacade usuarioFaca;
    @EJB
    private RolesFacade rolesFaca;
    @EJB
    private DiputacionFacade diputacionFaca;
    
    List<TipoTarea> listaTipoTarea;
    List<Perfil> listaPerfiles;
    List<Categoria> listaCategorias;
    List<Linea> listaLineas;
    List<Terminal> listaTerminal;
    
    private int id_categoria;
    private int id_tipotarea;
    private int numero;
    private int id_telefono;

    //Inicio - ID_TAREA
    public int getId_TipoTarea()
    {
        return id_tipotarea;
    }

    public void setId_TipoTarea(int id_topotarea)
    {
        this.id_tipotarea = id_topotarea;
    }
    
    public List<TipoTarea> getListaTipoTarea()
    {
        return listaTipoTarea;
    }

    public void setListaTipoTarea(List<TipoTarea> listaTipoTarea)
    {
        this.listaTipoTarea = listaTipoTarea;
    }  
    //Fin - ID_TAREA
    
    //Inicio - ID_CATEGORIA
    public int getId_Categoria()
    {
        return id_categoria;
    }

    public void setId_Categoria(int id_categoria)
    {
        this.id_categoria = id_categoria;
    }
    
    public List<Categoria> getListaCategorias()
    {
        return listaCategorias;
    }
    
    public void setListaCategorias(List<Categoria> listaCategorias)
    {
        this.listaCategorias = listaCategorias;
    }
    //Fin - ID_CATEGORIA
    
    //Inicio - NUM_TELEFONO
    public int getId_Numero()
    {
        return numero;
    }

    public void setId_Numero(int numero)
    {
        this.numero = numero;
    }
    
    public List<Linea> getListaLineas()
    {
        return listaLineas;
    }
    
    public void setListaNumero(List<Linea> listaLineas)
    {
        this.listaLineas = listaLineas;
    }
    //Fin - NUM_TELEFONO
    
    //Inicio - ID_TELEFONO
    public int getId_Telefono()
    {
        return id_telefono;
    }

    public void setId_Telefono(int id_telefono)
    {
        this.id_telefono = id_telefono;
    }
    
    public List<Terminal> getListaTerminal()
    {
        return listaTerminal;
    }
    
    public void setListaTerminal(List<Terminal> listaTerminal)
    {
        this.listaTerminal = listaTerminal;
    }
    //Fin - ID_TELEFONO
    
    @PostConstruct
    public void init()
    {
        listaCategorias = cateFaca.findAll();
        listaPerfiles = perfilFaca.findAll();
        listaTipoTarea = tipoTareaFaca.getTipoTareaByCod(2);
        listaLineas = lineaFaca.getNumByCod(41);
        listaTerminal = terminalFaca.findAll();
    }
    
    public void insertarTarea() throws ParseException, IOException
    {
        Tarea t = new Tarea();
        
        //Para el campo id_tarea
        //t.setIdTarea(tareaFaca.findAll().size()+1);
        //System.out.println(tareaFaca.findAll().size()+1);
        
        //Para el campo tipo_tarea
        TipoTarea tipo = (TipoTarea) tipoTareaFaca.find(id_tipotarea);
        t.setTipoTarea(tipo);
        System.out.println(id_tipotarea);
        
        //Para el campo dni
        Map<String,Object> map = FacesContext.getCurrentInstance().getExternalContext()
                .getSessionMap();
        Usuario u = (Usuario)map.get("usuario");
        t.setDni(u.getDni());
        System.out.println(u.getDni());
        
        //Para el campo dni_asignado
        Roles rol = rolesFaca.find(3);
        Diputacion dip = diputacionFaca.find(u.getCodigoDip().getCodigo());
        List<Usuario> us = (List<Usuario>) usuarioFaca.getUsuarioByRolDip(rol, dip);
        Random r = new Random();
        Usuario usu = us.get(r.nextInt(us.size()));
        t.setDniTareaAsignado(usu);
        System.out.println(usu.getDni());
        
        //Para el campo fecha_asignacion
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy 'de' MMMM 'de' dd", new Locale("es","ES"));
        Date fecha_actual = new Date();
        String fecha = formateador.format(fecha_actual);
        t.setFechaEmision(formateador.parse(fecha));
        System.out.println(fecha);
        
        //Para el campo codigo_categoria
        Categoria c = (Categoria) cateFaca.find(id_categoria);
        t.setCodigoCategoria(c);
        System.out.println(id_categoria);
        
        //Para el campo codigo_numero        
        Linea l;
        List<Linea> lin = (List<Linea>) lineaFaca.findNoAsigFijo();
        l = (Linea) lineaFaca.find(lin.get(0).getCodigo());         
        

        t.setCodigoNumero(l);
        System.out.println(numero);
        
        //Para el campo codigo_terminal
        Terminal ter = (Terminal) terminalFaca.find(id_telefono);
        t.setCodigoTerminal(ter);
        System.out.println(id_telefono);
        
        //Para el campo validado
        t.setValidado('N');
        
        if(id_tipotarea==0)
        {
            FacesContext.getCurrentInstance().getExternalContext().redirect("//Diputacion-war/error.jsf");
            
        }
        tareaFaca.insert(t);
        
        FacesContext.getCurrentInstance().getExternalContext().redirect("/Diputacion-war/acierto.jsf");
    }
}
