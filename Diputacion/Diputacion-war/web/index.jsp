<%-- 
    Document   : index
    Created on : 23-abr-2013, 12:01:19
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturación</title>
    </head>
    <body>
        <form name="send" method="POST" action="http://localhost:8080/Diputacion-war/listmovil">
            <input type="text" name="dni">
            <input type="submit" name="submit" value="ENVIAR DNI">  
        </form>
        
    </body>
</html>
