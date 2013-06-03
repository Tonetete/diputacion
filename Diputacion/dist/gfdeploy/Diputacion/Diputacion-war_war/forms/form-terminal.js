/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var fila_edit;
var action;


function checkCRUD(xhr, status, args){        
        $('#insertar-terminal').modal('hide');
       
        if(status === "success"){
            if(action==="insert"){
                var index = $(".datatable").dataTable().fnAddData( [
                args.codigo,
                args.fecha_alta,
                args.marca,
                args.modelo,
                args.configuracion,
                args.sn,
                '<a data-toggle="modal" href="#insertar-terminal" class="btn btn-success edit"><i class="icon3-edit icon-white"></i>Editar</a>\n\
                 <a data-toggle="modal" href="#borrar-terminal" class="btn btn-danger delete"><i class="icon3-trash icon-white"></i>Borrar</a>'
                ]);
                var tr = $(".datatable").dataTable().fnGetNodes(index[0]);
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").effect("highlight", {}, 5500); 
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(0).addClass("codigo");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(1).addClass("fecha_alta");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(2).addClass("marca");                
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(3).addClass("modelo");                
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(4).addClass("configuracion");                
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(5).addClass("sn");                
            }

            else if(action==="edit"){
                fila_edit.siblings('.codigo').text(args.codigo);
                fila_edit.siblings('.fecha_alta').text(args.fecha_alta);
                fila_edit.siblings('.marca').text(args.marca);
                fila_edit.siblings('.modelo').text(args.modelo);
                fila_edit.siblings('.configuracion').text(args.configuracion);
                fila_edit.siblings('.sn').text(args.sn);
            }

            else if(action==="delete"){
                $('#borrar-terminal').modal('hide');                
                $('.datatable').dataTable().fnDeleteRow(fila_edit[0]);   
            }
        }
        else if(status === "error" || status==="parseerror"){
            alert("Ha ocurrido un error al procesar los datos.");
        }
    }

    $('body').on('shown','#insertar-terminal', function() {
        $("input[name='form-insertar-terminal:marca-form']").focus();
        $("#form-insertar-linea").validationEngine();
        // Evento que se dispara al insertar una fila nueva

    });
    
    $('body').on('click','.insertar',function(){
        $("input[name='form-insertar-terminal:codigo-form']").val("");
        $("input[name='form-insertar-terminal:marca-form']").val("");
        $("input[name='form-insertar-terminal:modelo-form']").val("");
        $("input[name='form-insertar-terminal:configuracion-form']").val("");
        $("input[name='form-insertar-terminal:sn-form']").val("");        
        action="insert";        
    });    
    
    $('body').on('click','.edit', function(){   
        $("input[name='form-insertar-terminal:codigo-form']").val($(this).parent().siblings('.codigo').text());
        $("input[name='form-insertar-terminal:marca-form']").val($(this).parent().siblings('.marca').text());
        $("input[name='form-insertar-terminal:modelo-form']").val($(this).parent().siblings('.modelo').text());
        $("input[name='form-insertar-terminal:configuracion-form']").val($(this).parent().siblings('.configuracion').text());
        $("input[name='form-insertar-terminal:sn-form']").val($(this).parent().siblings('.sn').text());        
        fila_edit = $(this).parent();                      
        action="edit";
   });    

    $('body').on('click','.delete',function(){
            fila_edit = $(this).closest('tr');   
            action = "delete";
            $("input[name='form-borrar-terminal:codigo-form']").val($(this).parent().siblings('.codigo').text());      

     });

    
    $('body').on('click','.delete',function(){
        fila_edit = $(this).closest('tr');         
    });
    
