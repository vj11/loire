<%@page import="modelo.personaDAO"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.persona" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
  <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <title>Administrador</title>
  <link rel="shortcut icon" href="css/img/logo.jpg">
  <script
  src="https://code.jquery.com/jquery-3.4.0.min.js"
  integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg="
  crossorigin="anonymous"></script>
  <link rel="stylesheet" href="css/js/sweetalert2.min.css">
  <link href="WEB-INF/miu System2/css/sweetalert2.min.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="css/crear-usuario.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+SC" rel="stylesheet">
  
  <link href="css/js/sb-admin.css" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="css/datatables.min.css">
  <link rel="stylesheet" href="css/datatables.css">
  </head>
    <body>
        
   <style>
@import url('https://fonts.googleapis.com/css?family=Noto+Sans+SC');</style>

  <!--Navegador-->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

        <a class="navbar-brand" href="indexAdmin.jsp">
            <img src="img/logo2.jpg" alt="Home" width="90" height="40">
        </a>
          
        <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
            <li class="nav-item">
                <a class="nav-link" href="#">Administrador</a>
                <ul>
                    <li>
                        <a class="nav-link" href="index.jsp">Cerrar Sesión</a>
                    </li>
                </ul>
            </li>
        </ul>
        </div>
      </nav>

    <!--Principal-->
          <!--Barra lateral-->
  <div id="wrapper">
            <ul class="sidebar navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="indexAdmin.jsp">
          <i class="fas fa-fw fa-tachometer-alt"></i>
          <span>Inicio</span>
        </a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Usuarios</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Gestión de Usuarios:</h6>
          <a class="dropdown-item nav-item" href="adminU.jsp">Usuarios</a>
        </div>
      </li>
      <!--<li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Solicitudes</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Solicitudes:</h6>
          <a class="dropdown-item nav-item" href="index-solicitudMante.html">Mantenimiento</a>
          <a class="dropdown-item nav-item" href="index-vehiculo.html">Ruta</a>
          <a class="dropdown-item nav-item" href="index-soliservicios.html">Servicio</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Validaciones:</h6>
          <a class="dropdown-item nav-item" href="index-validarMante.html">Mantenimiento</a>
          <a class="dropdown-item nav-item" href="index-rutaSig.html">Ruta</a>
          <a class="dropdown-item nav-item" href="index-validados.html">Servicios</a>
        </div>
      </li>-->
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-fw fa-folder"></i>
          <span>Inventario</span>
        </a>
        <div class="dropdown-menu" aria-labelledby="pagesDropdown">
          <h6 class="dropdown-header">Registrar:</h6>
          <a class="dropdown-item nav-item" href="registrarInventario.jsp">Registrar Inventario</a>
          <div class="dropdown-divider"></div>
          <h6 class="dropdown-header">Consultar:</h6>
          <a class="dropdown-item nav-item" href="listarInventario.jsp">Inventario</a>
        </div>
      </li>
    </ul>
    <div class="col-sm-9" style="text-align: center;margin: 4%; background: #f1f3f6">
   <div class="content-wrapper">
   <div class="container-fluid">
    <!-- Breadcrumbs-->
    <ol class="breadcrumb">
    <li class="breadcrumb-item">
      <a href="#">Menú</a>
    </li>
    <li class="breadcrumb-item active">Editar usuario</li>
    </ol>
     
    <div class="card mb-3">
    <div class="card-header">
    <i class="fas fa-user"></i>
      Modificar Usuario</div>
    <div class="card-body">
          <form action="controlador1">
          <div class="form-row">
           <div class="form-group col-md-6">
             <label for="idpersona" class="form-control-label">id:</label>
             <input class="form-control" type="number" name="idpersona" >
           </div>
           <!--<div class="form-group col-md-6">
             <label for="Dni" class="form-control-label">Documento:</label>
             <input class="form-control" type="text" name="Dni" >
           </div>-->
           <div class="form-group col-md-6">
             <label for="nombres" class="form-control-label">Nombres:</label>
             <input class="form-control"  type="text" name="nombres" >
           </div>
           <div class="form-group col-md-6">
             <label for="apellidos" class="form-control-label">Apellidos:</label>
             <input class="form-control" type="text" name="apellidos" >
           </div>
         
         <div class="form-group col-md-6">
             <label for="direccion" class="form-control-label">Dirección:</label>
             <input class="form-control" type="text" name="direccion" >
           </div>
         <div class="form-group col-md-6">
             <label for="telefono" class="form-control-label">Teléfono:</label>
             <input class="form-control" type="text" name="telefono" >
           </div>
          <div class="form-group col-md-6 ">
              <label for="correoElectronico" class="form-control-label" >Correo Electrónico</label>
              <input name="correoElectronico"  type="email" class="form-control">
            </div>
           <div class="form-group col-md-6">
              <label for="nombreUsuario" class="form-control-label" >Usuario:</label>
              <input name="nombreUsuario"  type="text" class="form-control">
            </div>
            <!--<div class="form-group col-md-6">
              <label for="contrasenaUsuario" class="form-control-label" >Contraseña:</label>
              <input name="contrasenaUsuario"  type="text" class="form-control">
            </div>-->
            <div class="form-group col-md-6">
                  <label for="rol_idRol" class="form-control-label" >¿Usted que es?</label>    
                   <select class="form-input" name="rol_idRol" id="rol_idRol" placeholder="¿Usted que es?">
                   <option selected>¿Usted  es?</option>
                            <option value="1">Cliente</option>
                            <option value="2">Conductor</option>
                            <option value="3">Administrador</option>
                    </select>
                    </div>
            <!--<div class="form-group col-md-6">
                    <label for="tipodoc_idTipoDoc" class="form-control-label" >Digite su tipo de documento</label>    
                    <select class="form-input" name="tipodoc_idTipoDoc" id="tipodoc_idTipoDoc" placeholder="Digite su tipo de documento">
                    <option selected>Digite su tipo de documento</option>
                            <option value="1">Nit</option>
                            <option value="2">Cédula de Ciudadania</option>
                            <option value="3">Cédula de Extranjeria</option>
                    </select>
                 </div>-->   
         </div>
               <div class="form-group">
               <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit" name="accion" Value="Actualizar">Actualizar</button>
               <button class="au-btn au-btn--block au-btn--green m-b-20" type="submit" name="accion" Value="eliminar">Eliminar</button>
             </div>
            </form>
          </div>
          
        </div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <!-- Bootstrap core JavaScript-->
<script src="vendor/jquery/jquery.min.js"></script>


  <!-- Core plugin JavaScript-->
<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugin JavaScript-->
<script src="vendor/datatables/jquery.dataTables.js"></script>
<script src="vendor/datatables/dataTables.bootstrap4.js"></script>

  <!-- Custom scripts for all pages-->
<script src="js/sb-admin.min.js"></script>

  <!-- Demo scripts for this page-->
<script src="js/demo/datatables-demo.js"></script>
<script type="text/javascript" src="js/sweetalert2.min.js"></script>
</body>
</html>
