

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
<link href="http://www.bootstrapcdn.com/twitter-bootstrap/2.2.2/css/bootstrap-combined.min.css" rel="stylesheet"> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
<script src="http://www.bootstrapcdn.com/twitter-bootstrap/2.2.1/js/bootstrap.min.js"></script>

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
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
								  <th>DNI</th>
								  <th>Contraseña</th>
								  <th>Nombre y Apellidos</th>
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
                                                         out.print("<td>"+listaUsuarios.get(i).getDni()+"</td>");
                                                         out.print("<td class='center'>"+listaUsuarios.get(i).getContrasena()+"</td>");                                                            
                                                         out.print("<td class='center'>"+listaUsuarios.get(i).getNombre()+" "+listaUsuarios.get(i).getApellidos()+"</td>");
                                                         out.print("<td class='center'>"+listaUsuarios.get(i).getEmail()+"</td>");
                                                         out.print("<td class='center'>"+listaUsuarios.get(i).getCodigoDip().getCiudad()+"</td>");
                                                         out.print("<td class='center'>"+listaUsuarios.get(i).getCodigoRol().getTipo()+"</td>");						
                                                         out.print("<td class='center'><a data-toggle='modal' href='#form-usuario' class='btn btn-success'><i class='icon3-edit icon-white'></i>Editar</a> <a class='btn btn-danger' href='#'><i class='icon3-trash icon-white'></i>Borrar</a></td>");
							 out.print("</tr>");
                                                      }%>
						  </tbody>
					  </table>
                                                  <!-- Bootstrap trigger to open modal -->
                                                  <div class="hide fade modal" id="form-usuario">
                                                        <div class="modal-header">
                                                          <button type="button" class="close" data-dismiss="modal">×</button>
                                                          <h2>Your Review</h2>
                                                        </div>

                                                        <div class="modal-body">
                                                          <!-- The async form to send and replace the modals content with its response -->
                                                          <form class="form-horizontal well" data-async data-target="#rating-modal" action="/some-endpoint" method="POST">
                                                            <fieldset>
                                                              <!-- form content -->
                                                            </fieldset>
                                                          </form>
                                                        </div>

                                                        <div class="modal-footer">
                                                          <a href="#" class="btn" data-dismiss="modal">Cancel</a>
                                                          <a href="#" class="btn" type="submit">OK</a>
                                                        </div>
                                                      </div>                                  
                
                                                    <script type="text/javascript">
//                                                    jQuery(function($) {
//                                                        $('#form-usuario').click(function(event) {
//                                                            var $form = $(this);
//                                                            var $target = $($form.attr('data-target'));
//
//                                                            $.ajax({
//                                                                type: $form.attr('method'),
//                                                                url: $form.attr('action'),
//                                                                data: $form.serialize(),
//
//                                                                success: function(data, status) {
//                                                                    $target.html(data);
//                                                                    console.log("correcto");                                                                    
//                                                                    $('#form-usuario').modal('hide');
//                                                                },
//                                                                error: function(textStatus){
//                                                                  alert("pfff!");
//                                                                  $('#form-usuario').modal('hide');
//                                                                }
//                                                            });
//
//                                                            event.preventDefault();
//                                                        });
//                                                    });
                                                    </script>
                                                  <!-- end modal -->
					</div>
				</div><!--/span-->
			
			</div><!--/row-->
                    </div>
          <!-- footer -->
        <jsp:include page="res/footer.jsp"/>
    </body>   
</html>
