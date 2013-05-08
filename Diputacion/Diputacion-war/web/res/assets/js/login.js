/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function(){
    //hide the loginbox and the error msg
    $('.loginBox').hide().fadeIn(1000);
    $('.errorMsg').hide();
    $('.submission button').click(function(){
       //at the moment this is just here for the example and not properly functional
        $('.errorMsg').fadeIn(500);
    });
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
    
    //Stops the submit request
    $("#myAjaxRequestForm").submit(function(e){
           e.preventDefault();
    });
    
    //checks for the button click event
    $("#login").click(function(e){
           
            //get the form data and then serialize that
            dataString = $("#formLogin").serialize();
            
            //get the form data using another method 
            var usuario = $("input#usuario").val(); 
            var password = $("input#contrasena").val(); 
            alert(usuario+" y "+password);
            dataString = "?usuario="+usuario+"&contrasena="+password;
            //make the AJAX request, dataType is set to json
            //meaning we are expecting JSON data in response from the server
            $.ajax({
                type: "POST",
                url: "http://localhost:8080/Diputacion-war/LoginServlet",
                data: dataString,
                dataType: "json",
                
                //if received a response from the server
                success: function( data, textStatus, jqXHR) {
                    //our country code was correct so we have some information to display
                     if(data.success){
                         alert("De puta madre!");
                     } 
                     //display error message
                     else {
                         alert("Datos inexistentes!");
                     }
                },
                
                //If there was no resonse from the server
                error: function(jqXHR, textStatus, errorThrown){
//                     console.log("Something really bad happened " + textStatus);
                      alert(jqXHR.responseText);
                },
                
                //capture the request before it was sent to server
                beforeSend: function(jqXHR, settings){
                    //adding some Dummy data to the request
//                    settings.data += "&dummyData=whatever";
                    //disable the button until we get the response
//                    $('#myButton').attr("disabled", true);
                },
                
                //this is called after the response or error functions are finsihed
                //so that we can take some action
                complete: function(jqXHR, textStatus){
                    //enable the button 
                    //alert("http://localhost:8080/Diputacion-war/LoginServlet"+dataString);
                }
      
            });        
    });
});