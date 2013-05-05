<%-- 
    Document   : llamadas
    Created on : 30-abr-2013, 14:17:02
    Author     : Tone
--%>

<%@page import="app.entity.Llamada"%>
<%@page import="app.entity.Usuario"%>
<%@page import="app.entity.AsignacionFijo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="app.entity.Linea, java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diputación - LINEAS FIJAS</title>
    </head>
    <body>
        <h1>Llamadas realizadas</h1>
        <h2>L&iacute;nea: <%= ((Linea)request.getAttribute("linea")).getNumero() %></h2>
                
        <table border="1">
            <tr>
                <th>Fecha</th>
                <th>Hora</th>
                <th>Destino</th>
                <th>Tipo</th>
                <th>Duraci&oacute;n</th>
                <th>Coste</th>
            </tr>
            
            <%
                List<Llamada> llamadas = (List<Llamada>) request.getAttribute("llamadas");
                for (Llamada llamada : llamadas) {
                %>
                <tr>
                    <td>---</td>
                    <td>---</td>
                    <td><%= llamada.getNumeroDestino() %></td>
                    <td><%= llamada.getTipo() %></td>
                    <td><%= llamada.getDuracion() %></td>
                    <td><%= llamada.getCoste() %></td>
                </tr>
                <%
                }
            %>
        </table>
    </body>
</html>
