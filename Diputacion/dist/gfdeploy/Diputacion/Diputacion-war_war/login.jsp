<%-- 
    Document   : login
    Created on : 07-may-2013, 18:38:08
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <!-- Tested in Chrome 24, Firefox 18, Internet Explorer 9, Internet Explorer 8 (rounded borders not enabled) -->
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Iniciar Sesión - Diputación</title>
		<link href="res/css/login.css" rel="stylesheet" type="text/css" />
</head>
	<body>
		<div class="errorMsg">
			<!-- Change this text based on the error message -->
			<span>Ooops! Los datos de usuario ó contraseña son incorrectos! Inténtelo de nuevo.</span>
			<a href="#" title="Close error message">&#10006;</a>
		</div>
		<div class="wrapper">
                    <form id="formLogin" action="#" onsubmit="return false" >
                        <div class="loginBox">

                                <h2>Iniciar Sesión al panel de la diputación</h2>

                                <fieldset class="dataCapture">
                                    <input id="usuario" type="text" placeholder="Usuario"/>
                                    <input id="contrasena" type="password" placeholder="Contraseña"/>
                                </fieldset>

                                <fieldset class="submission">
                                        <input type="checkbox" name="rememberMe" id="rememberMe" />
                                        <label for="rememberMe">Recordar contraseña</label>
                                        <button id="login">Iniciar sesión</button>
                                </fieldset>
                        </div>
                        <div class="forgotPassword">
                                ¿Olvidaste tu contraseña? <a href="#" title="Click here to reset it.">Haz click para restablecerla.</a>
                        </div>
                    </form>
		</div>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js" type="text/javascript"></script>
		<script src="res/js/login.js" type="text/javascript"></script>
	</body>
</html>