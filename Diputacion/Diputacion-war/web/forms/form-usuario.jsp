<%-- 
    Document   : form-usuario
    Created on : 13-may-2013, 23:57:37
    Author     : Tone
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="thanks"><p><a data-toggle="modal" href="#form-content" class="btn btn-primary">Contact us</a></p></div>
            <!-- model content -->    
            <div id="form-content" class="modal hide fade in" style="display: none; ">
                    <div class="modal-header">
                          <a class="close" data-dismiss="modal">×</a>
                          <h3>Contact us</h3>
                    </div>
                <div>
                    <form class="contact">
                    <fieldset>
                         <div class="modal-body">
                             <ul class="nav nav-list">
                        <li class="nav-header">Name</li>
                        <li><input class="input-xlarge" value=" krizna" type="text" name="name"></li>
                        <li class="nav-header">Email</li>
                        <li><input class="input-xlarge" value=" user@krizna.com" type="text" name="Email"></li>
                        <li class="nav-header">Message</li>
                        <li><textarea class="input-xlarge" name="sug" rows="3"> Thanks for the article and demo
                        </textarea></li>
                        </ul> 
                        </div>
                    </fieldset>
                    </form>
                </div>
                 <div class="modal-footer">
                     <button class="btn btn-success" id="submit">submit</button>
                     <a href="#" class="btn" data-dismiss="modal">Close</a>
                  </div>
            </div>
    </body>
</html>
