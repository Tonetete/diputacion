<%-- 
    Document   : sidebar
    Created on : 09-may-2013, 15:50:01
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- left menu starts -->
<div class="span2 main-menu-span">
        <div class="well nav-collapse sidebar-nav">
                <ul class="nav nav-tabs nav-stacked main-menu">
                        <li class="nav-header hidden-tablet">Main</li>
                        <li><a class="ajax-link" href="main.jsp"><i class="icon2-home"></i><span class="hidden-tablet"> Principal</span></a></li>
                        <li><a class="ajax-link" href="listmovil.jsp"><i class="icon2-linea"></i><span class="hidden-tablet"> Líneas</span></a></li>
                        <li><a class="ajax-link" href="form.html"><i class="icon2-terminal"></i><span class="hidden-tablet"> Terminales</span></a></li>
                        <li><a class="ajax-link" href="chart.html"><i class="icon2-gastos"></i><span class="hidden-tablet"> Gestión de Gastos</span></a></li>
                        <li><a class="ajax-link" href="typography.html"><i class="icon-font"></i><span class="hidden-tablet"> Typography</span></a></li>
                        <li><a class="ajax-link" href="gallery.html"><i class="icon-picture"></i><span class="hidden-tablet"> Gallery</span></a></li>                        
                </ul>
            <label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" checked="true" type="checkbox"> Ajax on menu</label>
        </div><!--/.well -->
</div><!--/span-->
<!-- left menu ends -->