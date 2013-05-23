/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

var fila_edit;
var action;
var oTable;


function checkCRUD(xhr, status, args){        
        $('#form-usuario').modal('hide');
       
        if(status === "success"){
            if(action==="insert"){
                var index = $(".datatable").dataTable().fnAddData( [
                args.dni,
                args.contrasena,
                args.nombre,
                args.apellidos,
                args.email,
                args.diputacion,
                args.rol,
                '<a data-toggle="modal" href="#form-usuario" class="btn btn-success edit"><i class="icon3-edit icon-white"></i>Editar</a>\n\
                 <a data-toggle="modal" href="#form-borrar-usuario" class="btn btn-danger delete"><i class="icon3-trash icon-white"></i>Borrar</a>'
                ]);
                var tr = $(".datatable").dataTable().fnGetNodes(index[0]);
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").effect("highlight", {}, 5500); 
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(0).addClass("dni");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(1).addClass("contrasena");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(2).addClass("nombre");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(3).addClass("apellidos");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(4).addClass("email");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(5).addClass("diputacion");
                $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").eq(6).addClass("rol");
                  
//                tr.cells[0].id="dni";
//                tr.cells[1].id="contrasena";
//                tr.cells[2].id="nombre";
//                tr.cells[3].id="apellidos";
//                tr.cells[4].id="email";
//                tr.cells[5].id="diputacion";
//                tr.cells[6].id="rol";
            }

            else if(action==="edit"){
                fila_edit.siblings('.nombre').text(args.nombre);
                fila_edit.siblings('.apellidos').text(args.apellidos);
                fila_edit.siblings('.contrasena').text(args.contrasena);
                fila_edit.siblings('.diputacion').text(args.diputacion);
                fila_edit.siblings('.rol').text(args.rol);
                fila_edit.siblings('.email').text(args.email);
            }

            else if(action==="delete"){
                $('#form-borrar-usuario').modal('hide');                
                $('.datatable').dataTable().fnDeleteRow(fila_edit[0]);   
            }
        }
        else if(status === "error" || status==="parseerror"){
            alert("Ha ocurrido un error al procesar los datos.");
        }
    }


// Evento cuando se muestra el formulario
    $('body').on('shown','#form-usuario', function() {
            $("input[name='form-contact-usuario:dni-form']").focus();
            $("#form-contact-usuario").validationEngine();
            // Evento que se dispara al insertar una fila nueva

        });

        
    

 /* Referente a la inserción del usuario */
    $('body').on('click','.insertar',function(){
        $("input[name='form-contact-usuario:dni-form']").show();
        $("#dni-h4").show();
        $("input[name='form-contact-usuario:dni-form']").val("");
        $("input[name='form-contact-usuario:contrasena-form']").val("");
        $("input[name='form-contact-usuario:nombre-form']").val("");
        $("input[name='form-contact-usuario:apellidos-form']").val("");            
        $("input[name='form-contact-usuario:email-form']").val("");            
        $("select[name='form-contact-usuario:diputacion-form']").val($("select[name='form-contact-usuario:diputacion-form'] option:first").val());
        $("select[name='form-contact-usuario:rol-form']").val($("select[name='form-contact-usuario:rol-form'] option:first").val());
        action="insert";        
    });

    $('body').on('click','.edit', function(){        
        $("input[name='form-contact-usuario:dni-form']").val($(this).parent().siblings('.dni').text());
        $("input[name='form-contact-usuario:contrasena-form']").val($(this).parent().siblings('.contrasena').text());
        $("input[name='form-contact-usuario:nombre-form']").val($(this).parent().siblings('.nombre').text());
        $("input[name='form-contact-usuario:apellidos-form']").val($(this).parent().siblings('.apellidos').text());            
        $("input[name='form-contact-usuario:email-form']").val($(this).parent().siblings('.email').text());            
        $("select[name='form-contact-usuario:diputacion-form'] option:contains("+$(this).parent().siblings(".diputacion").text()+")").attr("selected", "selected");
        $("select[name='form-contact-usuario:rol-form'] option:contains("+$(this).parent().siblings(".rol").text()+")").attr("selected", "selected");                
        fila_edit = $(this).parent();
        $("input[name='form-contact-usuario:dni-form']").hide();        
        $("#dni-h4").hide();
        action="edit";
   });
   
    
    $('body').on('click','.delete',function(){
        fila_edit = $(this).closest('tr');   
        action = "delete";
        $("input[name='form-contact-borrar:dni-form']").val($(this).parent().siblings('.dni').text());        
    });
    
     $('body').on('click','.delete-ok',function(){
         
     });
    
//    $('body').on('click','.delete-ok',function(){
//        var dni = fila_edit.find('#dni').text();     
//        var data = "&dni="+dni;
//        $.ajax({
//            type: "POST",
//            url: "usuarios?action=delete",
//            data:data,
//            dataType: "json",
//            async: false,
//
//            success: function(data, status) {
//                $('#form-borrar-usuario').modal('hide');                
//                $('.datatable').dataTable().fnDeleteRow(fila_edit[0]);                                
//            }                      
//            ,
//            error: function(textStatus){
//              alert("Ha ocurrido un error y no se ha podido eliminar el registro.");             
//            }
//        });
            
    
//  });

   
 
    
 /* Referente a la edición e inserción del usuario */
    $('body').on('click','.ok',function(){   
        if($("#form-contact-usuario").validationEngine('validate')===true){
            $('#form-usuario').modal('hide');
//            if(action==="insert"){
//                var index = $(".datatable").dataTable().fnAddData( [
//                    data.dni,
//                    data.contrasena,
//                    data.nombre,
//                    data.apellidos,
//                    data.email,
//                    data.diputacion,
//                    data.rol,
//                    '<a data-toggle="modal" href="#form-usuario" class="btn btn-success edit"><i class="icon3-edit icon-white"></i>Editar</a>\n\
//                     <a data-toggle="modal" href="#form-borrar-usuario" class="btn btn-danger delete"><i class="icon3-trash icon-white"></i>Borrar</a>'
//                    ]);
//                    var tr = $(".datatable").dataTable().fnGetNodes(index[0]);
//                    $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").effect("highlight", {}, 5500); 
//                    tr.cells[0].id="dni";
//                    tr.cells[1].id="contrasena";
//                    tr.cells[2].id="nombre";
//                    tr.cells[3].id="apellidos";
//                    tr.cells[4].id="email";
//                    tr.cells[5].id="diputacion";
//                    tr.cells[6].id="rol";
//            }
//            else if(action === "edit"){
//                fila_edit.siblings('#nombre').text(data.nombre);
//                fila_edit.siblings('#apellidos').text(data.apellidos);
//                fila_edit.siblings('#contrasena').text(data.contrasena);
//                fila_edit.siblings('#diputacion').text(data.diputacion);
//                fila_edit.siblings('#rol').text(data.rol);
//                fila_edit.siblings('#email').text(data.email);
//            }
            
//            $.ajax({
//                type: "POST",
//                url: "usuarios?action="+action,
//                data: $('.form-horizontal').serialize(),
//                dataType: "json",
//                async: false,
//
//                success: function(data, status) {
//                    //$target.html(data);                                                                             
//                    $('#form-usuario').modal('hide');
//                    if(action === "edit"){
//                        fila_edit.siblings('#nombre').text(data.nombre);
//                        fila_edit.siblings('#apellidos').text(data.apellidos);
//                        fila_edit.siblings('#contrasena').text(data.contrasena);
//                        fila_edit.siblings('#diputacion').text(data.diputacion);
//                        fila_edit.siblings('#rol').text(data.rol);
//                        fila_edit.siblings('#email').text(data.email);
//                    }
//                    else if(action === "insert"){
//                        var index = $(".datatable").dataTable().fnAddData( [
//                            data.dni,
//                            data.contrasena,
//                            data.nombre,
//                            data.apellidos,
//                            data.email,
//                            data.diputacion,
//                            data.rol,
//                            '<a data-toggle="modal" href="#form-usuario" class="btn btn-success edit"><i class="icon3-edit icon-white"></i>Editar</a>\n\
//                             <a data-toggle="modal" href="#form-borrar-usuario" class="btn btn-danger delete"><i class="icon3-trash icon-white"></i>Borrar</a>'
//                            ]);
//                        var tr = $(".datatable").dataTable().fnGetNodes(index[0]);
//                        $(".table > tbody > tr:nth-child("+tr.rowIndex+") td").effect("highlight", {}, 5500); 
//                        tr.cells[0].id="dni";
//                        tr.cells[1].id="contrasena";
//                        tr.cells[2].id="nombre";
//                        tr.cells[3].id="apellidos";
//                        tr.cells[4].id="email";
//                        tr.cells[5].id="diputacion";
//                        tr.cells[6].id="rol";
//                        $('.datatable').dataTable().fnReloadAjax();                        
//                    }
//                },
//                error: function(textStatus){
//                  alert("Ha ocurrido un error actualizando o insertando el registro.");
//                }
//            });
        } 

        event.preventDefault();

  });
