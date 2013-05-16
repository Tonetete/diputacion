<%-- 
    Document   : header
    Created on : 06-may-2013, 23:57:57
    Author     : Tone
--%>
<%@page import="app.entity.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- Creamos el nombre para asignarselo más tarde a la caja de login -->
<%! String nombre; %>
<%  session = request.getSession(false);
    if(session.getAttribute("usuario") == null) { %> 

          <jsp:forward page="/login.jsp" />

<% }else{
       Usuario u = (Usuario)session.getAttribute("usuario");            
       nombre = u.getNombre()+" "+u.getApellidos();                        
   }%>
   
    <head>
        <!-- The styles -->
	<link id="bs-css" href="res/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="res/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="res/css/charisma-app.css" rel="stylesheet">
	<link href="res/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='res/css/fullcalendar.css' rel='stylesheet'>
	<link href='res/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='res/css/chosen.css' rel='stylesheet'>
	<link href='res/css/uniform.default.css' rel='stylesheet'>
	<link href='res/css/colorbox.css' rel='stylesheet'>
	<link href='res/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='res/css/jquery.noty.css' rel='stylesheet'>
	<link href='res/css/noty_theme_default.css' rel='stylesheet'>
	<link href='res/css/elfinder.min.css' rel='stylesheet'>
	<link href='res/css/elfinder.theme.css' rel='stylesheet'>
	<link href='res/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='res/css/opa-icons.css' rel='stylesheet'>
	<link href='res/css/uploadify.css' rel='stylesheet'>
        <link rel="stylesheet" href="res/css/validationEngine.jquery.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Diputación</title>
        
    </head>
    <header>
            	<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="main.jsp"> <img alt="Charisma Logo" src="res/img/logo.png" /></a>
				<ul class="nav ace-nav pull-right">
					<li class="tasks">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img src="res/img/bell-white.png" class="bell"></i>
							<span class="badge badge-important">8</span>
						</a>
						<ul class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-closer">
							<li class="nav-header">
								<i class="icon-warning-sign"></i> 8 Notifications
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left"><i class="icon-comment btn btn-mini btn-pink"></i> New comments</span>
										<span class="pull-right badge badge-info">+12</span>
									</div>
								</a>
							</li>
							
							<li>
								<a href="#">
									<i class="icon-user btn btn-mini btn-primary"></i> Bob just signed up as an editor ...
								</a>
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left"><i class="icon-shopping-cart btn btn-mini btn-success"></i> New orders</span>
										<span class="pull-right badge badge-success">+8</span>
									</div>
								</a>
							</li>
							
							<li>
								<a href="#">
									<div class="clearfix">
										<span class="pull-left"><i class="icon-twitter btn btn-mini btn-info"></i> Followers</span>
										<span class="pull-right badge badge-info">+4</span>
									</div>
								</a>
							</li>
																
							<li>
								<a href="#">
									See all notifications
									<i class="icon-arrow-right"></i>
								</a>
							</li>
						</ul>
					</li>


					<li class="messages">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							<img src="res/img/mail.png" class="mail">
							<span class="badge badge-success">5</span>
						</a>
						<ul class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-closer">
							<li class="nav-header">
								<i class="icon-envelope"></i> 5 Messages
							</li>
							
							<li>
								<a href="#">
									<img alt="Alex's Avatar" class="msg-photo" src="assets/avatars/avatar.png">
									<span class="msg-body">
										<span class="msg-title">
											<span class="blue">Alex:</span>
											Ciao sociis natoque penatibus et auctor ...
										</span>
										<span class="msg-time">
											<i class="icon-time"></i> <span>a moment ago</span>
										</span>
									</span>
								</a>
							</li>
							
							<li>
								<a href="#">
									<img alt="Susan's Avatar" class="msg-photo" src="assets/avatars/avatar3.png">
									<span class="msg-body">
										<span class="msg-title">
											<span class="blue">Susan:</span>
											Vestibulum id ligula porta felis euismod ...
										</span>
										<span class="msg-time">
											<i class="icon-time"></i> <span>20 minutes ago</span>
										</span>
									</span>
								</a>
							</li>
							
							<li>
								<a href="#">
									<img alt="Bob's Avatar" class="msg-photo" src="assets/avatars/avatar4.png">
									<span class="msg-body">
										<span class="msg-title">
											<span class="blue">Bob:</span>
											Nullam quis risus eget urna mollis ornare ...
										</span>
										<span class="msg-time">
											<i class="icon-time"></i> <span>3:15 pm</span>
										</span>
									</span>
								</a>
							</li>
							
							<li>
								<a href="#">
									See all messages
									<i class="icon-arrow-right"></i>
								</a>
							</li>									
	
						</ul>
					</li>


					<li class="light-blue user-profile">
						<a class="user-menu dropdown-toggle" href="#" data-toggle="dropdown">
                                                    <img src="res/img/user.png" class="user">
							<span id="user_info">
								<small>Bienvenido/a,</small> <%=nombre%>
							</span>
							<i class="icon-caret-down"></i>
						</a>
						<ul id="user_menu" class="pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-closer">
							<li><a href="#"><i class="icon-cog"></i> Configuración</a></li>
							<li><a href="#"><i class="icon-user"></i> Perfil</a></li>
							<li class="divider"></li>
							<li><a id="logout" href="#"><i class="icon-off"></i> Desconectar</a></li>
						</ul>
					</li>
			  </ul>
				
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
        </header>
                                                 