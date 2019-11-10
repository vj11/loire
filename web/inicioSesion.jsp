
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modeloDAO.manteDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="css/estilos.css"  >
        <script src="../index_files/jquery-3.4.1.min.js"></script>
        <link rel="stylesheet" href="css/js/sweetalert2.min.css"  type="text/css"/>
        <link rel="stylesheet" href="css/js/sweetalert2.css"  type="text/css"/>
        
        <script src="css/js/sweetalert2.min.js" type="text/javascript"></script>
        <script src="css/js/sweetalert2.js" type="text/javascript"></script>
        <script src="css/js/sweetalert2.all.min.js" type="text/javascript"></script>
        <script src="css/js/sweetalert2.all.js" type="text/javascript"></script>
        <title>Inicio Sesión</title>
    </head>
    <body>
    <div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
    </button>

          <a class="navbar-brand" href="#">
              <img src="css/img/logo2.jpg" alt="Home" width="80" height="40">
          </a>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
            <a class="nav-link" href="../index.html">Inicio</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="../index.html">Servicios</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="../index.html">Misión y Visión</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="../index.html">Contáctenos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link " href="loginn.jsp" style="max-width: 45px; max-height: 45px">
                    <img src="img/ingles.jpg" style="width: 100%; height: 100%; border-radius: 50%">
                </a>
            </li>

        </ul>
        </div>
      </nav>
  </div>
  <div class="login__container">
       <div class="login__top">
          <h2 class="login__title">Inicio <span>Sesión</span></h2>
       </div>
        
      <form class="login__form" action="servlet">
            <input type="text" placeholder="&#128100; usuario" name="txtuser" id="user" required>
            <input type="password" placeholder="&#x1F512; contraseña" name="txtpassword" id="password" required>
            <div class="login__form">    
                   <select class="form-input" name="txtrol" id="rol" placeholder="¿Usted que es?" requered>
                   <option selected>¿Usted  es?</option>
                            <option value="1">Cliente</option>
                            <option value="2">Conductor</option>
                            <option value="3">Administrador</option>
                    </select>
                    </div>
            <br>
             <input class="btn btn-primary" type="submit" name="accion" value="ingresar" onclick="validar()">
            <br>
            <br>
            <a class="btn btn-primary" type="submit" href="controlador1?accion=add">Registrarse aquí</a>
            </form>
            
    </div>
 
 <div id="footer">
	<div class="derechos">
		Derechos Reservados © <a href="https://www.miusystem.com" target="_blank">MIU SYSTEM</a>  2019 SENA  
                <form action="mante" method="post"><button type="button" class="btn btn-outline-primary" name="accion">correo</button></form>
                <% manteDAO dao= new manteDAO();
                dao.enviarCorreo();%>
	</div>
</div>
  <script>
    function validar() {
      var user= document.getElementById('user').value;
      var password= document.getElementById('password').value;

      if (user  && password) {
        
        Swal.fire(
          'Inicio de Sesion exitosa!',
          '',
          'success'
          )
        return true;

      }else{
        Swal.fire(
          'Campos Incompletos',
          '¿si llenasté todos los campos correctamente?',
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
