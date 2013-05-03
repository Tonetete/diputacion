<%-- 
    Document   : llamadas
    Created on : 30-abr-2013, 14:17:02
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="app.entity.Linea, java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diputación - Llamadas</title>
    </head>
    <body>

        <h1>Hello World!</h1>
        <select>
        <% List<Linea> lineas = (List<Linea>) request.getAttribute("listaLineas");
            for (int i = 0; i < lineas.size(); i++) {
                out.print("<option value='" + lineas.get(i).getNumero() + "'>" + lineas.get(i).getNumero() + "</option>");
            }
        %>
        </select>
        <table class="table" id="dataTable" cellspacing="0">
            <tr>
                <td class="titulo2"></td>
                <td class="titulo">L&iacute;nea</td>
                <td class="titulo">N&uacute;m.Serie</td>
                <td class="titulo">DNI</td>
            </tr>

            <tr>
                <td><input type="checkbox" name="chk" class="titulo2"></td>
                <td class="separacionColumna">615478942</td>
                <td class="separacionColumna">1212</td>
                <td class="separacionColumna">45465698L</td>
                <td class="separacionColumna"><a href="#"><img height = 25px src="drawable/edit-4.png"></img></a><a href="#"><img height = 25px onclick="deleteRow('dataTable')" src="drawable/dialog-close.png"></img></a></td>
            </tr>
        </table>
    </body>
</html>
