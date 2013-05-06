<%-- 
    Document   : llamadas
    Created on : 30-abr-2013, 14:17:02
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="app.entity.Linea, app.entity.Llamada, java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diputación - Llamadas</title>
    </head>
    <body>
        <% Linea linea = (Linea)request.getAttribute("linea"); %>
        <h1>Llamadas para la línea <% out.print(linea.getNumero()); %></h1>
        <select>
            <% List<Linea> lineas = (List<Linea>)request.getAttribute("listaLineas");
            for(int i=0; i<lineas.size();i++){
            out.print("<option value='"+lineas.get(i).getNumero()+"'>"+lineas.get(i).getNumero()+"</option>");
            }
            %>
        </select>
        
        
            <%
            List<Llamada> l = (List<Llamada>)request.getAttribute("listaLlamadas");
            out.print("<table border='1'>");                        
            out.print("<tr><td>Numero destino</td><td>Duracion</td><td>Coste</td><td>Inicio</td>"
                    + "<td>Fin</td><td>Duracion</td></tr>");
            
            for (int i = 0; i < l.size(); i++) 
            {
                out.print("<tr>");
                out.print("<td>"+l.get(i).getNumeroDestino()+"</td>");
                out.print("<td>"+l.get(i).getDuracion()+"</td>");
                out.print("<td>"+l.get(i).getCoste()+"</td>");
                out.print("<td>"+l.get(i).getInicio()+"</td>");
                out.print("<td>"+l.get(i).getFin()+"</td>");
                out.print("<td>"+l.get(i).getDuracion()+"</td>");
                //out.print("<td>"+l.get(i).g()+"</td>");
                //out.println("<td><input type='radio' name='grupo1' value="+asign.get(i).getLinea().getCodigo()+"></td>");
                out.print("</tr>");                
            }
            out.print("</table>");
            
            %>
        
    </body>
</html>
