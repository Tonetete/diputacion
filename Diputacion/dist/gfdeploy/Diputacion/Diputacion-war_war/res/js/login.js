/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    //hide the loginbox and the error msg
    $('.loginBox').hide().fadeIn(1000);
    $('.errorMsg').hide();
    
    $('.errorMsg a').click(function(){
        $('.errorMsg').fadeOut(500);
    });
    //When a user clicks or tabs onto an input remove the word that's inside the input.
	$('.loginBox input').focus(function() {
        if (!$(this).data('originalValue')) {
           
            $(this).data('originalValue', $(this).val());
            //change the colour of that word to look more 'active'
            $(this).css("color", "#666666");
            
            if($(this).data('originalValue') === "Password"){
                //mask the password
            	$(this).attr("type", "password");
            }
        }
        //if the data of this is the same as the data original value, empty it.
        if ($(this).val() == $(this).data('originalValue')) {
            $(this).val('');
        }
    }); 
    
    $("#login").click(function(e){          
            
           
            var usuario = $("input#usuario").val(); 
            var pass = $("input#contrasena").val(); 
            dataString = "usuario=" + usuario+"&contrasena="+pass;

            $.ajax({
                type: "POST",
                url: "LoginServlet",
                data: dataString,
                dataType: "json",
                async: false,
                
                //if received a response from the server
                success: function(data) {
                    
                    if(data.usuariorol === -1){
                        $('.errorMsg').fadeIn(500).delay(5000).fadeOut(500);
                    }
                    else{
                        document.getElementById("formLogin").action = "main.jsp";
                        document.getElementById("formLogin").onsubmit = "return true";
                    }
                },
                
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
                     console.log("Something really bad happened " + textStatus);                      
                }      
      
            });        
    });
});