<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/cliente.css" type="text/css"/>
        <script src="../index_files/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="css/js/sweetalert2.min.css"  type="text/css"/>
        <link rel="stylesheet" href="css/js/sweetalert2.css"  type="text/css"/>
        
        <script src="css/js/sweetalert2.min.js" type="text/javascript"></script>
        <script src="css/js/sweetalert2.js" type="text/javascript"></script>
        <script src="css/js/sweetalert2.all.min.js" type="text/javascript"></script>
        <script src="css/js/sweetalert2.all.js" type="text/javascript"></script>
        <title>Conductor</title>
    </head>
    <body>
        <div class="container-fluid">  
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

          <a class="navbar-brand" href="#">
              <img src="css/img/IMG-20180919-WA0004.jpg" alt="Home" width="80" height="40">
          </a>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
            <a class="nav-link" href="iniciocliente.html">Inicio</a>
            </li>
            <li class="nav-item">
            
            </li>
           <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Solicitudes</a>
            <div class="dropdown-menu">
                   <a class="nav-link dropdown-item"href="solicitudMante.jsp">Solicitar Mantenimiento</a>
                  <a class="nav-link dropdown-item" href="indexConduc.jsp">Solicitar Agendar Ruta</a>
            </div>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">Contáctenos</a>
            </li>
            </ul>
        <ul class="navbar-nav ml-auto mt-2 mt-lg-0  col-sm-3">         
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Conductor<br>${user}</a>
          <div class="dropdown-menu">
               <a class="nav-link dropdown-item" href="controlador1?accion=salir">Cerrar Sesión</a>
               <a class="nav-link dropdown-item"href="../inicio conductor/html/indexconductorinicio.html.html">Cambiar Contraseña</a>
               </div>
          </li>    
      </ul>
    </div>
    </nav>
    </div>

        <br>
        <br>
        <br>
        <div class="login__container">

       <div class="login__top">
           <h2 class="login__title">SOLICITAR <span> RUTA</span></h2>
       </div>
        <form class="login__form">
                <legend>Diligencie el siguiente formulario:</legend>
                <span> NOMBRE COMPLETO</span>
                <input type="text" pattern="[a-zA-Z](1,30)" maxlength="30"id="empresa"  name=" empresa" placeholder="Debes introducir un texto" required/>
                <br/>
                 
                <span>Documento de identidad</span>
                <input type="text" pattern="[0-9](9)" maxlength="9"id="Nit" name="Nit" placeholder="Debes introducir los digitos" required/>
                <br>
                <span> Placa vehículo</span>
                <input type="text" pattern="[a-zA-Z](1,30)" maxlength="50"id="direccion"  name=" direccion" placeholder="Debes introducir un texto" required/>
                <br/>
                <span>Teléfono</span>
                <input type="text" pattern="[0-9](9)" maxlength="9"id="telefono" name="telefono" placeholder="Debes introducir los digitos" required/>
                <br>
                <span> Tipo de Servicio
                <select name="servicio" id="servicio" required="">
                <option value="">seleccione un servicio</option>
                <option value="1">Recolección de Residuos</option>
                <option value="2">Disposición de Residuos</option>
                <option value="3">Otro</option>
                </select>
                </span>
              </br>
              
              <br>                    
                  <span>Fecha de Servicio</span>
                   <input type="date" id="date" name="date"/>
                     <br />
                     
             
               <span>Formato servicio</span>
               <input type="file" class="form-control" id="file" name="file"  accept="application/pdf,image/jpg"/>
               <br />
              <br />

                <input class="btn btn-primary" type="reset" value="Crear" onclick="validar()">
                <br /> 
            </form>

     
            </div>
 
 <div id="footer">
    <div class="derechos">
        Derechos Reservados © <a href="https://www.miusystem.com" target="_blank">MIU SYSTEM</a>  2019 SENA  
    </div>
</div>
<script>
  function validar() {
      var empresa= document.getElementById('empresa').value;
      var Nit= document.getElementById('Nit').value;
      var servicio= document.getElementById('servicio').value;
      var date=document.getElementById('date').value;

      if( empresa && Nit && servicio && date ){
         Swal.fire(
          'Formulario procesado exitosamente!',
          '',
          'success'
          )
        return true;

      }else{
        Swal.fire(
          'Campos Incompletos',
          'No se ha podido procesar el formulario',
          'error'
          )
        return false;
      }
    }   
    
</script>
     <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    
    </body>
</html>
