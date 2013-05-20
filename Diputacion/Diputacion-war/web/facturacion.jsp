<%@page import="app.entity.Linea"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="app.entity.Llamada"%>
<%@page import="java.util.Collection"%>
<%@page import="app.entity.AsignacionMovil"%>
<%@page import="app.entity.AsignacionFijo"%>
<%@page import="app.entity.Roles"%>
<%@page import="app.entity.Diputacion"%>
<%@page import="java.util.List, app.entity.Usuario"%>
<%@page import="java.io.Console"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%-- 
    Document   : facturacion
    Created on : 19-may-2013, 4:19:49
    Author     : Francisco Manuel Fernández Lozano
--%>

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
                                <a href="facturacion">Gestión de Gastos</a>
                            </li>
                        </ul>
                    </div>

                    <div class="row-fluid sortable">		
                        <div class="box span12">
                            <div class="box-header well" data-original-title>
                                <h2><i class="icon-user"></i>Gestión de Gastos</h2>
                            </div>
                            <div class="box-content">

                                <%-- Tabs de selección: Mis líneas, Grupo de Rescate... --%>
                                <ul class="nav nav-tabs" id="myTab">
                                    <li class="active"><a href="#mis-lineas">Mis líneas</a></li>
                                        <%
											Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
											if (usuario.getCodigoRol().getCodigo() < 4) {%>
                                    <li><a href="#grupos-rescate">Grupos de Rescate</a></li>
                                        <% }
											if (usuario.getCodigoRol().getCodigo() < 3) {%>
                                    <li><a href="#diputacion">Diputación</a></li>
                                        <% }%>
                                </ul>


                                <div id="myTabContent" class="tab-content">

									<%-- TAB: MIS LÍNEAS --%>
                                    <div class="tab-pane active" id="mis-lineas">

										<%
											List<Linea> lineas = (List<Linea>) request.getAttribute("lineas");

											if (lineas.isEmpty()) {%>
												<div class="alert alert-info">
													<p><strong>¡No hay líneas!</strong></p>
													<p>No dispone de ninguna línea asignada en el sistema</p>
												</div>
										<% } else { %>
										<form method="post" action="blablabla">
											<div class="well">
												<p>Línea:
													<select><%

														for (int i = 0; i < lineas.size(); i++) {
															Linea linea = lineas.get(i);
															if (i == 0) {
																out.println("<option value='" + linea.getNumero() + "' selected='selected'>" + linea.getNumero() + "</option>");
															} else {
																out.println("<option value='" + linea.getNumero() + "'>" + linea.getNumero() + "</option>");
															}
														}%>
													</select>
												</p>
											</div>
										</form>



										<p><h3>Listado de llamadas <small>a fully featued template</small></h3></p>

										<table class="table table-striped table-bordered bootstrap-datatable datatable">
											<thead>
												<tr>
													<th>Fecha y Hora</th>
													<th>Destinatario</th>
													<th>Tipo</th>
													<th>Duración</th>
													<th>Coste</th>
												</tr>
											</thead>
											<tbody><%
												Object oAsignacion = request.getAttribute("asignacion");

												Collection<Llamada> llamadas = null;

												if (oAsignacion instanceof AsignacionFijo) {
													AsignacionFijo asignacion = (AsignacionFijo) oAsignacion;
													llamadas = asignacion.getLinea().getLlamadaCollection();
												} else if (oAsignacion instanceof AsignacionMovil) {
													AsignacionFijo asignacion = (AsignacionFijo) oAsignacion;
													llamadas = asignacion.getLinea().getLlamadaCollection();
												}

												if (llamadas == null) {
													// TODO: Mostrar: No hay llamadas
												} else if (llamadas.isEmpty()) {
													// TODO: Mostrar: No hay líneas
												} else {
													SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM HH:mm");

													for (Llamada llamada : llamadas) {
												%>

												<tr>
													<td><%= llamada.getInicio() == null ? "" : dateFormat.format(llamada.getInicio())%></td>
													<td><%= llamada.getNumeroDestino()%></td>
													<td><%= llamada.getTipo()%></td>
													<td><%= llamada.getDuracion()%></td>
													<td><%= llamada.getCoste()%></td>
												</tr>
												<%
														}
													}%>
											</tbody>
										</table>
										<% } %>
                                    </div>

									<%-- TAB: GRUPOS DE RESCATE --%>
                                    <div class="tab-pane" id="grupos-rescate">
                                        <h3>Custom <small>small text</small></h3>
                                        <p>LISTADO DE LÍNEAS DE GRUPO DE RESCATE</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor.</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at. Nulla tellus elit, varius non commodo eget, mattis vel eros. In sed ornare nulla. Donec consectetur, velit a pharetra ultricies, diam lorem lacinia risus, ac commodo orci erat eu massa. Sed sit amet nulla ipsum. Donec felis mauris, vulputate sed tempor at, aliquam a ligula. Pellentesque non pulvinar nisi.</p>
                                    </div>

									<%-- TAB: DIPUTACIÓN --%>
                                    <div class="tab-pane" id="diputacion">
                                        <h3>Messages <small>small text</small></h3>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor, quis ullamcorper ligula sodales at. Nulla tellus elit, varius non commodo eget, mattis vel eros. In sed ornare nulla. Donec consectetur, velit a pharetra ultricies, diam lorem lacinia risus, ac commodo orci erat eu massa. Sed sit amet nulla ipsum. Donec felis mauris, vulputate sed tempor at, aliquam a ligula. Pellentesque non pulvinar nisi.</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur bibendum ornare dolor.</p>
                                    </div>
                                </div>





                                <% if (false) {%>


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
											List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios");
											for (int i = 0; i < listaUsuarios.size(); i++) {
												out.print("<tr>");
												out.print("<td id='dni'>" + listaUsuarios.get(i).getDni() + "</td>");
												out.print("<td id='contrasena' class='center'>" + listaUsuarios.get(i).getContrasena() + "</td>");
												out.print("<td id='nombre' class='center'>" + listaUsuarios.get(i).getNombre() + "</td>");
												out.print("<td id='apellidos' class='center'>" + listaUsuarios.get(i).getApellidos() + "</td>");
												out.print("<td id='email' class='center'>" + listaUsuarios.get(i).getEmail() + "</td>");
												out.print("<td id='diputacion' class='center'>" + listaUsuarios.get(i).getCodigoDip().getCiudad() + "</td>");
												out.print("<td id='rol' class='center'>" + listaUsuarios.get(i).getCodigoRol().getTipo() + "</td>");
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
                                                    <% List<Diputacion> diputaciones = (List<Diputacion>) request.getAttribute("listaDiputaciones");
														for (int i = 0; i < diputaciones.size(); i++) {
															out.print("<option value='" + diputaciones.get(i).getCiudad() + "'>" + diputaciones.get(i).getCiudad() + "</value>");
														}
                                                    %>
                                                </select>
                                                <h4>Rol: </h4><select name="rol" id="rol">
                                                    <% List<Roles> roles = (List<Roles>) request.getAttribute("listaRoles");
														for (int i = 0; i < roles.size(); i++) {
															out.print("<option value='" + roles.get(i).getTipo() + "'>" + roles.get(i).getTipo() + "</value>");
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


                                <% }%>

                            </div>
                        </div><!--/span-->

                    </div><!--/row-->
                </div>
                <!-- footer -->
                <jsp:include page="res/footer.jsp"/>    
            </div>
        </div>
    </body>
</html>
