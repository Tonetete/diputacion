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
				<a class="brand" href="index.html"> <img alt="Charisma Logo" src="res/img/logo.png" /></a>
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"> <%=nombre%></span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">Profile</a></li>
						<li class="divider"></li>
						<li><a id="logout">Logout</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
        </header>
                                                 