<%-- 
    Document   : llamadas
    Created on : 30-abr-2013, 14:17:02
    Author     : Tone
--%>

<%@page import="app.entity.Usuario"%>
<%@page import="app.entity.AsignacionFijo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@page import="app.entity.Linea, java.util.List" %>

<!DOCTYPE html>
<html>
    <jsp:include page="res/header.jsp"/>
    <body>
        <%
            Usuario usuarioLogueado = (Usuario) request.getAttribute("usuario");
            out.print("<h1>LISTADO DE TERMINALES DE "+usuarioLogueado.getNombre()+" "+usuarioLogueado.getApellidos()+"</h1>");
       
                List<AsignacionFijo> asign = (List<AsignacionFijo>) request.getAttribute("listaAsignaciones");
                
                
                if(usuarioLogueado.getCodigoRol().getCodigo()==4)
                {       //panel de usuarios
                     out.print("<FORM ACTION='#' METHOD='post' name='form1' id='form1'>");
                     out.print("<table class='table table-striped'>");
                        out.print("<tr>"
                                + "<td>Nombre del terminal</td>"
                            + "<td>Seleccion</td>"
                                + "</tr>");
                        out.println("");
                        for (int i = 0; i < asign.size(); i++) 
                        {
                            if(asign.get(i).getUsuario().equals(usuarioLogueado))
                            {
                                        out.print("<tr>");
                                        out.print("<td>"+asign.get(i).getCodigoTerminal().getMarca()+" "+asign.get(i).getCodigoTerminal().getModelo()+"</td>");
                                        out.println("<td><input type='radio' name='grupo1' value="+asign.get(i).getLinea().getCodigo()+"></td>");
                                        out.print("</tr>");
                            }
                        }
                        out.print("</table>");
                        out.print("<input type='submit' value='Solicitar nueva linea' id='evento_solic_nuevo' name='evento_solic_nuevo'/>");
                        out.print("<input type='submit' value='Solicitar modificar linea' id='evento_solic_modif' name='evento_solic_modif'/>");
                        out.print("<input type='submit' value='Mostrar historico de modificaciones' id='evento_solic_historico' name='evento_solic_historico'/>");
                        out.print("<input type='submit' value='Salir' id='evento_salir' name='evento_salir'/>");
                        out.print("</form>");
                }
                else if(usuarioLogueado.getCodigoRol().getCodigo()==1) //ADMINISTRADOR
                {
                    out.print("<FORM ACTION='#' METHOD='post' name='form1' id='form1'>");
                    out.print("<table class='table table-striped'>");
                    out.print("<tr><td>Usuario</td>"
                            + "<td>Diputacion</td>"
                            + "<td>Nombre del terminal</td>"
                            + "<td>Seleccion</td></tr>");
                     
                        for(int i=0; i<asign.size();i++)
                        {
                            
                                    out.print("<tr>");
                                    out.print("<td>"+ asign.get(i).getUsuario().getNombre()+"</td>");
                                    out.print("<td>"+ asign.get(i).getUsuario().getCodigoDip().getCiudad()+"</td>");
                                    out.print("<td>"+asign.get(i).getCodigoTerminal().getMarca()+" "+asign.get(i).getCodigoTerminal().getModelo()+"</td>");
                                    out.print("<td><input type='radio' name='grupo1' value="+asign.get(i).getLinea().getCodigo()+"></td>");
                                    out.print("</tr>");
                       }
                        out.print("</table>");
                        out.print("<input type='submit' value='Nueva linea' id='evento_nuevo' name='evento_nuevo'/>");
                        out.print("<input type='submit' value='Modificar linea' id='evento_modif' name='evento_modif'/>");
                        out.print("<input type='submit' value='Mostrar historico de modificaciones' id='evento_historico' name='evento_historico'/>");
                        out.print("<input type='submit' value='Borrar linea' id='evento_borrar' name='evento_borrar'/>");
                        out.print("<input type='submit' value='Salir' id='evento_salir' name='evento_salir'/>");
                        out.print("</form>");
                }
                else if(usuarioLogueado.getCodigoRol().getCodigo()==3) //JEFE DE SERVICIO
                {
                    out.print("<FORM ACTION='#' METHOD='post' name='form1' id='form1'>");
                    out.print("<table class='table table-striped'>"
                            + "<td>Usuario</td>"
                            + "<td>Departamento</td>"
                            + "<td>Nombre del terminal</td>"
                            + "<td>Seleccion</td></tr>");
                        
                        for(int i=0; i<asign.size();i++)
                        {
                            int codigo = asign.get(i).getUsuario().getCodigoDip().getCodigo();
                            if((usuarioLogueado.getCodigoDip().getCodigo()==codigo) 
                                    && (asign.get(i).getUsuario().getCodigoRol().getCodigo()>=3))
                            {
                                    out.print("<tr>");
                                    out.print("<td>"+ asign.get(i).getUsuario().getNombre()+"</td>");
                                    out.print("<td>"+ asign.get(i).getUsuario().getCodigoDip().getCodigo()+"</td>");
                                    out.print("<td>"+asign.get(i).getCodigoTerminal().getMarca()+" "+asign.get(i).getCodigoTerminal().getModelo()+"</td>");
                                    out.print("<td><input type='radio' name='grupo1' value='"+asign.get(i).getLinea().getCodigo()+"'></td>");
                                    out.print("</tr>");
                            }
                        }
                        out.print("</table>");
                        out.print("<input type='submit' value='Solicitar nueva linea' id='evento_solic_nuevo' name='evento_solic_nuevo'/>");
                        out.print("<input type='submit' value='Solicitar modificar linea' id='evento_solic_modif' name='evento_solic_modif'/>");
                        out.print("<input type='submit' value='Mostrar historico de modificaciones' id='evento_solic_historico' name='evento_solic_historico'/>");
                        out.print("<input type='submit' value='Solicitar borrar linea' id='evento_solic_borrar' name='evento_solic_borrar'/>");
                        out.print("<input type='submit' value='Salir' id='evento_salir' name='evento_salir'/>");
                        out.print("</form>");
                }
                else if(usuarioLogueado.getCodigoRol().getCodigo()==2)
                {
                    out.print("<FORM ACTION='#' METHOD='post' name='form1' id='form1'>");
                    out.print("<table class='table table-striped'>");
                    out.print("<tr><td>Usuario</td>"
                            + "<td>Diputacion</td>"
                            + "<td>Nombre de terminal</td>"
                            + "<td>Seleccion</td></tr>");
                    
                        for(int i=0; i<asign.size();i++)
                        {
                            int codigo = asign.get(i).getUsuario().getCodigoDip().getCodigo();
                            if(usuarioLogueado.getCodigoDip().getCodigo()==codigo
                                    && (asign.get(i).getUsuario().getCodigoRol().getCodigo()>=2))
                            {
                                    out.print("<tr>");
                                    out.print("<td>"+ asign.get(i).getUsuario().getNombre()+"</td>");
                                    out.print("<td>"+ asign.get(i).getUsuario().getCodigoDip().getCodigo()+"</td>");
                                    out.print("<td>"+asign.get(i).getCodigoTerminal().getMarca()+" "+asign.get(i).getCodigoTerminal().getModelo()+"</td>");
                                    out.print("<td><input type='radio' name='grupo1' value="+asign.get(i).getLinea().getCodigo()+"></td>");
                                    out.print("</tr>");
                                    
                            }
                        }
                        out.print("</table>");
                        out.print("<input type='submit' value='Solicitar nueva linea' id='evento_solic_nuevo' name='evento_solic_nuevo'/>");
                        out.print("<input type='submit' value='Solicitar modificar linea' id='evento_solic_modif' name='evento_solic_modif'/>");
                        out.print("<input type='submit' value='Mostrar historico de modificaciones' id='evento_solic_historico' name='evento_solic_historico'/>");
                        out.print("<input type='submit' value='Solicitar borrar linea' id='evento_solic_borrar' name='evento_solic_borrar'/>");
                        out.print("<input type='submit' value='Salir' id='evento_salir' name='evento_salir'/>");
                        out.print("</form>");
                }
            
        %>
        </table>
        

        
    </body>
</html>
