<%-- 
    Document   : sidebar
    Created on : 09-may-2013, 15:50:01
    Author     : Tone
--%>

<%@page import="app.entity.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%! String rol; %>
<%  session = request.getSession(false);
    if(session.getAttribute("usuario") == null) { %> 

          <jsp:forward page="/login.jsp" />

<% }else{
       Usuario u = (Usuario)session.getAttribute("usuario");            
       rol = u.getCodigoRol().getTipo();
   }%>

<!-- left menu starts -->
<div class="span2 main-menu-span">
        <div class="well nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                        <li class="nav-header hidden-tablet">Main</li>
                        <li><a class="ajax-link" href="main.jsp"><i class="icon2-home"></i><span class="hidden-tablet"> Principal</span></a></li>
                        <li><a class="ajax-link" href="listmovil.jsp"><i class="icon2-linea"></i><span class="hidden-tablet"> Líneas</span></a></li>
                        <li><a class="ajax-link" href="form.html"><i class="icon2-terminal"></i><span class="hidden-tablet"> Terminales</span></a></li>
                        <li><a class="ajax-link" href="facturacion"><i class="icon2-gastos"></i><span class="hidden-tablet"> Gestión de Gastos</span></a></li>
                        <% if(rol.equals("administrador")){ %>
                        <li><a class="ajax-link" href="usuarios?action=list"><i class="icon2-user"></i><span class="hidden-tablet"> Gestión de Usuarios</span></a></li>
                        <%}%>
                        <li><a class="ajax-link" href="gallery.html"><i class="icon-picture"></i><span class="hidden-tablet"> Gallery</span></a></li>                        
                </ul>
            <label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" checked="true" type="checkbox"> Ajax on menu</label>
        </div><!--/.well -->
</div><!--/span-->
<!-- left menu ends -->