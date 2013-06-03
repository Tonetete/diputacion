/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var fila_edit;
var action;

//jQuery.noConflict(); 

function checkCRUD(xhr, status, args){        
        $('#insertar-linea').modal('hide');
       
        if(status === "success"){
            if(action==="insert"){
                var index = $(".datatable").dataTable().fnAddData( [
                args.codigo,
                args.numero,
                args.fecha,
                args.publico,
                '<a data-toggle="modal" href="#insertar-linea" class="btn btn-success edit"><i class="icon3-edit icon-white"></i>Editar</a>\n\
                 <a data-toggle="modal" href="#borrar-linea" class="btn btn-danger delete"><i class="icon3-trash icon-white"></i>Borrar</a>'
                ]);
                var tr = $(".datatable").dataTable().fnGetNodes(index[0]);
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").effect("highlight", {}, 5500); 
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(0).addClass("codigo");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(1).addClass("numero");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(2).addClass("fechafacturacion");                
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(3).addClass("publico");                
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(3).addClass("hide");                
            }

            else if(action==="edit"){
                fila_edit.siblings('.codigo').text(args.codigo);
                fila_edit.siblings('.numero').text(args.numero);
                fila_edit.siblings('.fechafacturacion').text(args.fecha);
                fila_edit.siblings('.publico').text(args.publico);
            }

            else if(action==="delete"){
                $('#borrar-linea').modal('hide');                
                $('.datatable').dataTable().fnDeleteRow(fila_edit[0]);   
            }
        }
        else if(status === "error" || status==="parseerror"){
            alert("Ha ocurrido un error al procesar los datos.");
        }
    }
    
    
$(document).ready(function() {
   $( "input[name='form-insertar-linea:fecha-form']" ).datepicker();   
   $( "input[name='form-insertar-linea:fecha-form']" ).datepicker( "option", "showAnim", "drop" );
   $( "input[name='form-insertar-linea:fecha-form']" ).datepicker( "option", "dateFormat", "dd/mm/yy");
   
 });   

$('body').on('shown','#insertar-linea', function() {
        $("input[name='form-insertar-linea:numero-form']").focus();
        $("#form-insertar-linea").validationEngine();
        // Evento que se dispara al insertar una fila nueva

    });

$('body').on('click','.insertar',function(){
        $("input[name='form-insertar-linea:numero-form']").val("");
        $("input[name='form-insertar-linea:fecha-form']").val("");
        $("input:radio[name='form-insertar-linea:publico-form'][value='Y']").attr('checked',true);
        action="insert";        
    });    
    
$('body').on('click','.edit', function(){        
        $("input[name='form-insertar-linea:numero-form']").val($(this).parent().siblings('.numero').text());
        $("input[name='form-insertar-linea:fecha-form']").val($(this).parent().siblings('.fechafacturacion').text());
        var publico = $(this).parent().siblings('.publico').text();    
        if(publico==='Y'){
            $("input:radio[name='form-insertar-linea:publico-form'][value='Y']").attr('checked',true);
        }
        else{
            $("input:radio[name='form-insertar-linea:publico-form'][value='n']").attr('checked',true);
        }
        fila_edit = $(this).parent();                      
        action="edit";
   });    

$('body').on('click','.delete',function(){
        fila_edit = $(this).closest('tr');   
        action = "delete";
        $("input[name='form-linea-borrar:cod_linea-form']").val($(this).parent().siblings('.codigo').text());      
        
 });