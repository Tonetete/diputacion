/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//
//    $('body').on('click','.delete', function () {alert("hola!");});

var fila_edit;
var action;


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
                fila_edit.remove();                
            }           
            ,
            error: function(textStatus){
              alert("Ha ocurrido un error y no se ha podido eliminar el registro.");             
            }
        });
            
    
  });
    
    $('body').on('click','.delete',function(){
        fila_edit = $(this).parent().parent();        
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
                    var clonedRow = $(".table tr:nth-child(2)").clone(); //this will grab the first table row.
                    clonedRow.find('#dni').text(data.dni);
                    clonedRow.find('#nombre').text(data.nombre);
                    clonedRow.find('#apellidos').text(data.apellidos);
                    clonedRow.find('#contrasena').text(data.contrasena);
                    clonedRow.find('#diputacion').text(data.diputacion);
                    clonedRow.find('#rol').text(data.rol);
                    clonedRow.find('#email').text(data.email);
                    $(".table > tbody > tr:nth-child(1)").before(clonedRow);
                    $(".table > tbody > tr:nth-child(1) td").effect("highlight", {}, 5500);                    
                }
            },
            error: function(textStatus){
              alert("Ha ocurrido un error actualizando o insertando el registro.");
              //$('#form-usuario').modal('hide');
            }
        });

        event.preventDefault();

  });



