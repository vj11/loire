
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
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
        <title>Registrarse</title>
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
            <a class="nav-link" href="#">Contáctenos</a>
            </li>
            </ul>
        <ul class="navbar-nav ml-auto mt-2 mt-lg-0  col-sm-4">         
          <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Nuevo Usuario</a>
          <div class="dropdown-menu">
               <a class="nav-link dropdown-item" href="controlador?accion=salir">Salir</a>
              
               </div>
          </li>    
      </ul>
    </div>
    </nav>
   <div class="login__container">

       <div class="login__top">
           <h2 class="login__title">CREAR <span>CUENTA</span></h2>
       </div>
                    <form class="login__form" action="controlador1">
                                               
                        <input type="text" class="form-input" name="Dni" id="name" placeholder="Numero de Identidad"/>
                        
                        
                        <input type="text" class="form-input" name="nombres" id="name" placeholder="Nombres"/>
                        
                       
                        <input type="text" class="form-input" name="apellidos" id="surname" placeholder="Apellidos"/>
                        
                        
                        <input type="text" class="form-input" name="direccion" id="name" placeholder="Dirección"/>
                        
                        
                        <input type="text" class="form-input" name="telefono" id="name" placeholder="Numero de Teléfono"/>
                        
                        
                        <input type="text" class="form-input" name="correoElectronico" id="name" placeholder="Correo Electrónico"/>
                        
                        
                        <input type="text" class="form-input" name="nombreUsuario" id="name" placeholder="Usuario"/>
                    
                    
                       <input type="text" class="form-input" name="contrasenaUsuario" id="name" placeholder="Contraseña"/>
                    
                       <br>
                        <select class="form-input" name="rol_idRol" id="genero" placeholder="¿Usted es?">
                            <option selected>¿Usted  es?</option>
                            <option value="1">Cliente</option>
                            <option value="2">Conductor</option>
                            <option value="3">Administrador</option>
                       
                        </select>
                       <br>
                       <br>
                        <select class="form-input" name="tipodoc_idTipoDoc" id="genero" placeholder="Digite su tipo de documento">
                            <option selected>Digite su tipo de documento</option>
                            <option value="1">Nit</option>
                            <option value="2">Cédula de Ciudadanía</option>
                            <option value="3">Cédula de Extranjería</option>
                            
                        </select>
                       <br>
                        
                        
                        <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                        <label for="agree-term" class="label-agree-term"><span></span>Estoy de acuerdo con todas las declaraciones en los <a href="#" class="term-service">Terminos de Servicios</a></label>
                        
                        
                        <input type="submit" class="btn btn-primary"  id="submit" class="form-submit" name="accion" value="Agregar"/>
                        
                        
                      </form>
       <br> 
                      <p class="loginhere">
                        ¿Ya tienes una cuenta? <a href="login.html" class="loginhere-link">Ingresa Aqui</a>
                       </p>
                </div>
            </div>
    <div id="footer">
    <div class="derechos">
        Derechos Reservados © <a href="https://www.miusystem.com" target="_blank">MIU SYSTEM</a>  2019 SENA  
    </div>

    </div>

   <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
     
    
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
