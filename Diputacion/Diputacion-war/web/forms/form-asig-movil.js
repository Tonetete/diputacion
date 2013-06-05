/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var fila_edit;
var action;

function checkCRUD(xhr, status, args){        
        $('#asig-movil').modal('hide');
       
        if(status === "success"){
           if(action==="edit"){
               if(args.error === "asignado"){
                   alert("La línea o número ya ha sido asignado a otro usuario");  
               }
               else{
                fila_edit.siblings('.fechaini').text(args.fechaini);
                fila_edit.siblings('.fechafin').text(args.fechafin);
                fila_edit.siblings('.terminal').text(args.terminal);
                fila_edit.siblings('.usuario').text(args.usuario);
                fila_edit.siblings('.numero').text(args.numero);
                fila_edit.siblings('.asignado').text(args.asignado);
                fila_edit.siblings('.perfil').text(args.perfil);
                fila_edit.siblings('.idPerfil').text(args.idperfil);
                fila_edit.siblings('.idTerminal').text(args.idterminal);
               }
           }
        }
        else if(status === "error" || status==="parseerror"){
            alert("Ha ocurrido un error al procesar los datos.");
        }
    }


$(document).ready(function() {
   $( "input[name='form-asig-movil:fechaini-form']" ).datepicker();   
   $( "input[name='form-asig-movil:fechafin-form']" ).datepicker();   
   $( "input[name='form-asig-movil:fechaini-form']" ).datepicker( "option", "showAnim", "drop" );
   $( "input[name='form-asig-movil:fechafin-form']" ).datepicker( "option", "dateFormat", "dd/mm/yy");
   $( "input[name='form-asig-movil:fechaini-form']" ).datepicker( "option", "showAnim", "drop" );
   $( "input[name='form-asig-movil:fechafin-form']" ).datepicker( "option", "dateFormat", "dd/mm/yy");
   
 });
   
    
    $('body').on('click','.edit', function(){   
        $("#form-asig-movil").validationEngine();
        
        $("input[name='form-asig-movil:codigo-form']").val($(this).parent().siblings('.codigo').text());
        $("input[name='form-asig-movil:dni-form']").val($(this).parent().siblings('.usuario').text());
        var asignado = $(this).parent().siblings('.asignado').text();         
        if(asignado==='S'){
            $("input:radio[name='form-asig-movil:asignado-form'][value='S']").attr('checked',true);
            // Añadimos los valores del terminal y la linea a los selects si está asignado
            
            $("select[name='form-asig-movil:numero-form']").val($(this).parent().siblings(".numero").find(".idlinea").text());
            $("select[name='form-asig-movil:terminal-form']").val($(this).parent().siblings(".terminal").find(".idterminal").text());
            
        }
        else{
            $("input:radio[name='form-asig-movil:asignado-form'][value='N']").attr('checked',true);
        }        
//        $("select[name='form-asig-movil:numero-form'] option:contains("+$(this).parent().siblings(".numero").text()+")").attr("selected", "selected");
        $("input[name='form-asig-movil:fechaini-form']").val($(this).parent().siblings('.fechaini').text());
        $("input[name='form-asig-movil:fechafin-form']").val($(this).parent().siblings('.fechafin').text());
//        $("select[name='form-asig-movil:terminal-form'] option:contains("+$(this).parent().siblings(".terminal").text()+")").attr("selected", "selected");        
//        $("select[name='form-asig-movil:terminal-form'] [value='"+$(this).parent().siblings(".idTerminal").text()+"']").attr("selected", "selected");        
//        $("select[name='form-asig-movil:perfil-form'] [value='"+$(this).parent().siblings(".idPerfil").text()+"']").attr("selected", "selected");        
        //$("select[name='form-asig-movil:perfil-form'] option:contains("+$(this).parent().siblings(".perfil").text()+")").attr("selected", "selected");        
        fila_edit = $(this).parent();                      
        action="edit";
   });        
    