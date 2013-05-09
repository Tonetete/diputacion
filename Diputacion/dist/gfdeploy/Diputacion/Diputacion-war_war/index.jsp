
<%@page import="java.io.Console"%>
<%-- 
    Document   : index
    Created on : 30-abr-2013, 14:17:02
    Author     : Tone
--%>

<%@page import="app.entity.Usuario" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <%  session = request.getSession(false);
        if(session.getAttribute("usuario") == null) {        
            RequestDispatcher rd;
            rd = this.getServletContext().getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
        }
        else{
            Usuario u = (Usuario)session.getAttribute("usuario");            
            String nombre = u.getNombre()+" "+u.getApellidos();                        
        }
    %>
    <jsp:include page="res/header.jsp"/>
    <body>
        <form name="send" method="POST" action="http://localhost:8080/Diputacion-war/listmovil">
            <input type="text" name="dni">
            <input type="submit" name="submit" value="ENVIAR DNI">  
        </form>
        
    </body>
</html>
