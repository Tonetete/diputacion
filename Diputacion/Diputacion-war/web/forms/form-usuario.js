/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var fila_edit;
var action;
var oTable;




// Evento cuando se muestra el formulario
    $('body').on('shown','#form-usuario', function() {
            $("input[name='dni']").focus();
            $("#form-contact-usuario").validationEngine();
            // Evento que se dispara al insertar una fila nueva

        });


    
    $('body').on('click','.delete',function(){
        fila_edit = $(this).closest('tr');         
    });
    
    $('body').on('click','.delete-ok',function(){
        var dni = fila_edit.find('#dni').text();     
        var data = "&dni="+dni;
        $.ajax({
            type: "POST",
            url: "usuarios?action=delete",
            data:data,
            dataType: "json",
            async: false,

            success: function(data, status) {
                $('#form-borrar-usuario').modal('hide');                
                $('.datatable').dataTable().fnDeleteRow(fila_edit[0]);                                
            }                      
            ,
            error: function(textStatus){
              alert("Ha ocurrido un error y no se ha podido eliminar el registro.");             
            }
        });
            
    
  });

    /* Referente a la inserción del usuario */
    $('body').on('click','.insertar',function(){
        $("input[name='dni']").show();
        $("#dni-h4").show();
        $('.modal-body #dni').val("");
        $('.modal-body #contrasena').val("");
        $('.modal-body #nombre').val("");
        $('.modal-body #apellidos').val("");            
        $('.modal-body #email').val("");
        action="insert";
    });

    $('body').on('click','.edit', function(){
        
        $('.modal-body #dni').val($(this).parent().siblings('#dni').text());
        $('.modal-body #contrasena').val($(this).parent().siblings('#contrasena').text());
        $('.modal-body #nombre').val($(this).parent().siblings('#nombre').text());
        $('.modal-body #apellidos').val($(this).parent().siblings('#apellidos').text());            
        $('.modal-body #email').val($(this).parent().siblings('#email').text());            
        $(".modal-body #diputacion option[value='"+$(this).parent().siblings("#diputacion").text()+"']")
                .attr("selected","selected");
        $(".modal-body #rol option[value='"+$(this).parent().siblings("#rol").text()+"']")
                .attr("selected","selected");
        fila_edit = $(this).parent();
        $("input[name='dni']").hide();
        $("#dni-h4").hide();
        action="edit";
   });
   

 
    
 /* Referente a la edición e inserción del usuario */
    $('body').on('click','.ok',function(){   
        if($("#form-contact-usuario").validationEngine('validate')===true){
            $.ajax({
                type: "POST",
                url: "usuarios?action="+action,
                data: $('.form-horizontal').serialize(),
                dataType: "json",
                async: false,

                success: function(data, status) {
                    //$target.html(data);                                                                             
                    $('#form-usuario').modal('hide');
                    if(action === "edit"){
                        fila_edit.siblings('#nombre').text(data.nombre);
                        fila_edit.siblings('#apellidos').text(data.apellidos);
                        fila_edit.siblings('#contrasena').text(data.contrasena);
                        fila_edit.siblings('#diputacion').text(data.diputacion);
                        fila_edit.siblings('#rol').text(data.rol);
                        fila_edit.siblings('#email').text(data.email);
                    }
                    else if(action === "insert"){
                        var index = $(".datatable").dataTable().fnAddData( [
                            data.dni,
                            data.contrasena,
                            data.nombre,
                            data.apellidos,
                            data.email,
                            data.diputacion,
                            data.rol,
                            '<a data-toggle="modal" href="#form-usuario" class="btn btn-success edit"><i class="icon3-edit icon-white"></i>Editar</a>\n\
                             <a data-toggle="modal" href="#form-borrar-usuario" class="btn btn-danger delete"><i class="icon3-trash icon-white"></i>Borrar</a>'
                            ]);
                        var tr = $(".datatable").dataTable().fnGetNodes(index[0]);
                        $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").effect("highlight", {}, 5500); 
                        tr.cells[0].id="dni";
                        tr.cells[1].id="contrasena";
                        tr.cells[2].id="nombre";
                        tr.cells[3].id="apellidos";
                        tr.cells[4].id="email";
                        tr.cells[5].id="diputacion";
                        tr.cells[6].id="rol";
                        $('.datatable').dataTable().fnReloadAjax();                        
                    }
                },
                error: function(textStatus){
                  alert("Ha ocurrido un error actualizando o insertando el registro.");
                }
            });
        } 

        event.preventDefault();

  });