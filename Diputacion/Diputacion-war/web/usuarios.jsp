

<%@page import="app.entity.Roles"%>
<%@page import="app.entity.Diputacion"%>
<%-- 
    Document   : index
    Created on : 30-abr-2013, 14:17:02
    Author     : Tone
--%>

<%@page import="java.util.List, app.entity.Usuario"%>
<%@page import="java.io.Console"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

    <jsp:include page="res/header.jsp"/>
    
    <body>       
      <!-- topbar ends -->       
                    
        <div class="container-fluid">
         <div class="row-fluid">
				
            <!-- left menu starts -->
            <jsp:include page="res/sidebar.jsp"/>
            <!-- left menu ends -->		
			
			<div id="content" class="span10">
			<!-- content starts -->		

			<div>
				<ul class="breadcrumb">
					<li>
						<a href="main.jsp">Principal</a> <span class="divider">/</span>
					</li>
					<li>
						<a href="usuarios.jsp">Usuarios</a>
					</li>
				</ul>
			</div>
			
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header well" data-original-title>
						<h2><i class="icon-user"></i> Gestión de Usuarios</h2>
						<div class="box-icon">
							<a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
							<a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
							<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
                                                        <a data-toggle='modal' href="#form-usuario" class="btn btn-primary insertar"><i class="icon3-user"></i> Crear Usuario</a>
						</div>
					</div>
					<div class="box-content">
                                            
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
                                                    
						  <thead>
							  <tr>
								  <th>DNI</th>
								  <th>Contraseña</th>
								  <th>Nombre</th>
								  <th>Apellidos</th>
								  <th>Email</th>
								  <th>Diputación</th>
								  <th>Rol</th>								  
								  <th>Acciones</th>								  
							  </tr>
						  </thead>   
						  <tbody>
                                                      <% 
                                                         List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("listaUsuarios"); 
                                                         for(int i=0; i<listaUsuarios.size(); i++) { 
							 out.print("<tr>");        
                                                         out.print("<td id='dni'>"+listaUsuarios.get(i).getDni()+"</td>");
                                                         out.print("<td id='contrasena' class='center'>"+listaUsuarios.get(i).getContrasena()+"</td>");                                                            
                                                         out.print("<td id='nombre' class='center'>"+listaUsuarios.get(i).getNombre()+"</td>");
                                                         out.print("<td id='apellidos' class='center'>"+listaUsuarios.get(i).getApellidos()+"</td>");
                                                         out.print("<td id='email' class='center'>"+listaUsuarios.get(i).getEmail()+"</td>");
                                                         out.print("<td id='diputacion' class='center'>"+listaUsuarios.get(i).getCodigoDip().getCiudad()+"</td>");
                                                         out.print("<td id='rol' class='center'>"+listaUsuarios.get(i).getCodigoRol().getTipo()+"</td>");						
                                                         out.print("<td class='center'><a data-toggle='modal' href='#form-usuario' class='btn btn-success edit'><i class='icon3-edit icon-white'></i>Editar</a> <a data-toggle='modal' href='#form-borrar-usuario' class='btn btn-danger delete' href='#'><i class='icon3-trash icon-white'></i>Borrar</a></td>");
							 out.print("</tr>");
                                                      }%>
						  </tbody>
					  </table>
                                                  <!-- Bootstrap trigger to open modal -->
                                                  <div class="hide fade modal" id="form-usuario">
                                                        <div class="modal-header">
                                                          <button type="button" class="close" data-dismiss="modal">×</button>
                                                          <h3>Editar Datos</h3>
                                                        </div>

                                                        <div class="modal-body">                                                          
                                                          <form class="form-horizontal well" id="form-contact-usuario" data-async data-target="#rating-modal" action="/usuarios" method="POST">
                                                            <fieldset>                                                              
                                                              <h4 id="dni-h4" style="display:none;">DNI: </h4><input name="dni" class="validate[required]" id="dni" type="text" style="display:none;"  />
                                                              <h4>Nombre: </h4><input name="nombre" class="validate[required]" id="nombre" type="text" />
                                                              <h4>Apellidos: </h4><input name="apellidos" class="validate[required]" id="apellidos" type="text" />
                                                              <h4>Contraseña: </h4><input name="contrasena" class="validate[required]" id="contrasena" type="text" />
                                                              <h4>Email: </h4><input name="email" id="email" class="validate[required,custom[email]]" type="text" />
                                                              <h4>Diputacion: </h4><select name="diputacion" id="diputacion">
                                                                  <% List<Diputacion> diputaciones = (List<Diputacion>)request.getAttribute("listaDiputaciones");
                                                                    for(int i=0;i<diputaciones.size();i++){                                                                        
                                                                        out.print("<option value='"+diputaciones.get(i).getCiudad()+"'>"+diputaciones.get(i).getCiudad()+"</value>");
                                                                    }   
                                                                  %>
                                                              </select>
                                                              <h4>Rol: </h4><select name="rol" id="rol">
                                                                  <% List<Roles> roles = (List<Roles>)request.getAttribute("listaRoles");
                                                                    for(int i=0;i<roles.size();i++){                                                                        
                                                                       out.print("<option value='"+roles.get(i).getTipo()+"'>"+roles.get(i).getTipo()+"</value>");
                                                                    }   
                                                                  %>
                                                              </select>                                                              
                                                            </fieldset>
                                                          </form>
                                                        </div>

                                                        <div class="modal-footer">
                                                          <a href="#" class="btn" data-dismiss="modal">Cancel</a>
                                                          <input href="#" class="btn btn-primary ok" type="submit" value="Ok"/>
                                                        </div>
                                                      </div>                                  
                
                                                    
                                                  <!-- end modal -->
                                                  <!-- Bootstrap trigger to open modal -->
                                                  <div class="hide fade modal" id="form-borrar-usuario">
                                                        <div class="modal-header">
                                                          <button type="button" class="close" data-dismiss="modal">×</button>
                                                          <h3>Borrar Datos</h3>
                                                        </div>

                                                        <div class="modal-body">
                                                            <p>Estás apunto de borrar el registro. ¿Desea seguir?</p>
                                                        </div>

                                                        <div class="modal-footer">
                                                          <a href="#" class="btn" data-dismiss="modal">Cancelar</a>
                                                          <a href="#" class="btn btn-primary delete-ok" type="submit">OK</a>
                                                        </div>
                                                      </div>  
                                                  <!-- end modal -->
                                                  
                                                  
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
                    </div>
          <!-- footer -->
        <jsp:include page="res/footer.jsp"/>    
          
    </body>   
</html>
