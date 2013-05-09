/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$("#logout").click(function(e){ 

            $.ajax({
                type: "POST",
                url: "LogoutServlet",                
                dataType: "json",
                async: false,
                
                //if received a response from the server
                success: function(data) {                    
                    if(data.logout === true){
                        window.location.href="login.jsp";
                    }
                },
                
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                     console.log("Something really bad happened " + textStatus);                      
                }      
      
            });        
    });