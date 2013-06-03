/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
var fila_edit;
var action;

function checkCRUD(xhr, status, args){        
        $('#asig-fijo').modal('hide');
       
        if(status === "success"){
           if(action==="edit"){
                fila_edit.siblings('.fechaini').text(args.fechaini);
                fila_edit.siblings('.fechafin').text(args.fechafin);
                fila_edit.siblings('.terminal').text(args.terminal);
                fila_edit.siblings('.usuario').text(args.usuario);
                fila_edit.siblings('.numero').text(args.numero);
                fila_edit.siblings('.asignado').text(args.asignado);
                fila_edit.siblings('.categoria').text(args.categoria);
                fila_edit.siblings('.idCategoria').text(args.idcategoria);
                fila_edit.siblings('.idTerminal').text(args.idterminal);
           }
        }
        else if(status === "error" || status==="parseerror"){
            alert("Ha ocurrido un error al procesar los datos.");
        }
    }


$(document).ready(function() {
   $( "input[name='form-asig-fijo:fechaini-form']" ).datepicker();   
   $( "input[name='form-asig-fijo:fechafin-form']" ).datepicker();   
   $( "input[name='form-asig-fijo:fechaini-form']" ).datepicker( "option", "showAnim", "drop" );
   $( "input[name='form-asig-fijo:fechafin-form']" ).datepicker( "option", "dateFormat", "dd/mm/yy");
   $( "input[name='form-asig-fijo:fechaini-form']" ).datepicker( "option", "showAnim", "drop" );
   $( "input[name='form-asig-fijo:fechafin-form']" ).datepicker( "option", "dateFormat", "dd/mm/yy");
   
 });
   
    
    $('body').on('click','.edit', function(){   
        $("#form-asig-fijo").validationEngine();
        $("input[name='form-asig-fijo:codigo-form']").val($(this).parent().siblings('.codigo').text());
        $("input[name='form-asig-fijo:dni-form']").val($(this).parent().siblings('.usuario').text());
        var asignado = $(this).parent().siblings('.asignado').text();         
        if(asignado==='S'){
            $("input:radio[name='form-asig-fijo:asignado-form'][value='S']").attr('checked',true);
            $("select[name='form-asig-fijo:numero-form']").append('<option value="'+$(this).parent().siblings(".numero").find(".idlinea").text()+'" selected="selected">'+$(this).parent().siblings(".numero").find(".lineanum").text()+'</option>');
            $("select[name='form-asig-fijo:terminal-form']").append('<option value="'+$(this).parent().siblings(".terminal").find(".idterminal").text()+'" selected="selected">'+$(this).parent().siblings(".terminal").find(".terminalnom").text()+'</option>');
            
        }
        else{
            $("input:radio[name='form-asig-fijo:asignado-form'][value='N']").attr('checked',true);
        }        
//        $("select[name='form-asig-fijo:numero-form'] option:contains("+$(this).parent().siblings(".numero").text()+")").attr("selected", "selected");
        $("input[name='form-asig-fijo:fechaini-form']").val($(this).parent().siblings('.fechaini').text());
        $("input[name='form-asig-fijo:fechafin-form']").val($(this).parent().siblings('.fechafin').text());
//        $("select[name='form-asig-fijo:terminal-form'] option:contains("+$(this).parent().siblings(".terminal").text()+")").attr("selected", "selected");        
//        $("select[name='form-asig-fijo:terminal-form'] [value='"+$(this).parent().siblings(".idTerminal").text()+"']").attr("selected", "selected");        
//        $("select[name='form-asig-fijo:categoria-form'] [value='"+$(this).parent().siblings(".idCategoria").text()+"']").attr("selected", "selected");        
        //$("select[name='form-asig-fijo:categoria-form'] option:contains("+$(this).parent().siblings(".categoria").text()+")").attr("selected", "selected");        
        fila_edit = $(this).parent();                      
        action="edit";
   });        
    