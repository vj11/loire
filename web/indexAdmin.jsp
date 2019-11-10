
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="img/logo.jpg">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Required meta tags -->
    
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <title>Administrador</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link rel="stylesheet" href="css/index-admin.css">
    <style>
        .borde{border:1vh #fff; text-align: center; height: 650px; width: 100%;}
        .borde1{border:1px #000 solid; text-align: center; height: 250px; width: 100%;}
        .color1{background: #010101;}
        .color2{background: #fff}
        .color{background:#010101;}

    </style>
  </head>
  <body>
    <div class="container-fluid">  
    <div id="header" class="container-fluid">
       <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

          <a class="navbar-brand" href="#">
              <img src="img/logo2.jpg" alt="Home" width="90" height="50">
          </a>
          <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
          <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
            <a class="nav-link" href="#">Inicio</a>
            </li>
            <li class="nav-item">
            <a class="nav-link" href="#">Zona Gestión</a>
            <ul>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="pagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Usuarios</span>
                  </a>
                  <div class="dropdown-menu" aria-labelledby="pagesDropdown">
                    <h6 class="dropdown-header">Gestión de Usuarios:</h6>
                    <a class="dropdown-item nav-item" href="adminU.jsp">Consultar Usuarios</a>
                  </div>
                </li>
            </ul>
            <ul>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="">Inventario</a>
                    <div class="dropdown-menu">
                        <a class="dropdown-item nav-link" href="listarInventario.jsp">Consultar Inventario</a>
                        <a class="dropdown-item nav-link" href="registrarInventario.jsp">Registrar Registro de residuos</a>
                        <a class="dropdown-item nav-link" href="modificarInventario.jsp">Modificar Registro de residuos</a>
                        <a class="dropdown-item nav-link" href="eliminarInventario.jsp">Eliminar Entrada de residuos</a>
                    </div>
                 </li>

            </ul>
            </li>
        </ul>
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
  </div>
    <div class="row">
        <div class="borde col-12 col-sm-6 color1">
            <div class="caption">
                <h3>Servicio Disposición</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis repudiandae soluta adipisci assumenda incidunt sequi, similique earum corrupti iure deleniti eos quaerat alias, fuga voluptate error! Temporibus consectetur ducimus culpa, dolorum cum assumenda dignissimos, maxime doloribus eum blanditiis nisi sunt ullam tenetur, quos enim. Fugiat, nam, reprehenderit. Dolore, sed ex, perspiciatis, a illum corrupti qui tempore nisi neque consequatur expedita quos quisquam maiores quas necessitatibus. Obcaecati, officiis quibusdam praesentium dolores quisquam numquam repudiandae cupiditate facere maxime corporis. Vel, facere ullam.</p>
            </div>
        </div>
        <div class="borde col-12 col-sm-6 color1">
            <div class="caption">
                <h3>Servicio Recolección</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis repudiandae soluta adipisci assumenda incidunt sequi, similique earum corrupti iure deleniti eos quaerat alias, fuga voluptate error! Temporibus consectetur ducimus culpa, dolorum cum assumenda dignissimos, maxime doloribus eum blanditiis nisi sunt ullam tenetur, quos enim. Fugiat, nam, reprehenderit. Dolore, sed ex, perspiciatis, a illum corrupti qui tempore nisi neque consequatur expedita quos quisquam maiores quas necessitatibus. Obcaecati, officiis quibusdam praesentium dolores quisquam numquam repudiandae cupiditate facere maxime corporis. Vel, facere ullam.</p>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="borde col-12 col-sm-6 color2">
            <div class="caption1">
                <h3>Misión</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis repudiandae soluta adipisci assumenda incidunt sequi, similique earum corrupti iure deleniti eos quaerat alias, fuga voluptate error! Temporibus consectetur ducimus culpa, dolorum cum assumenda dignissimos, maxime doloribus eum blanditiis nisi sunt ullam tenetur, quos enim. Fugiat, nam, reprehenderit. Dolore, sed ex, perspiciatis, a illum corrupti qui tempore nisi neque consequatur expedita quos quisquam maiores quas necessitatibus. Obcaecati, officiis quibusdam praesentium dolores quisquam numquam repudiandae cupiditate facere maxime corporis. Vel, facere ullam.</p>
            </div>
        </div>
        <div class="borde col-12 col-sm-6 color2">
            <div class="caption1">
                <h3>Visión</h3>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quis repudiandae soluta adipisci assumenda incidunt sequi, similique earum corrupti iure deleniti eos quaerat alias, fuga voluptate error! Temporibus consectetur ducimus culpa, dolorum cum assumenda dignissimos, maxime doloribus eum blanditiis nisi sunt ullam tenetur, quos enim. Fugiat, nam, reprehenderit. Dolore, sed ex, perspiciatis, a illum corrupti qui tempore nisi neque consequatur expedita quos quisquam maiores quas necessitatibus. Obcaecati, officiis quibusdam praesentium dolores quisquam numquam repudiandae cupiditate facere maxime corporis. Vel, facere ullam.</p>
            </div>
            </div>
    </div>
    <footer id="footer">
        <div class="row">
            <div class="borde1 col-sm-4 color1">
                <div class="footer-info">
                    <h3>Contáctenos</h3>
                    <input type="text" placeholder="Razon Social" name="razon social"><br>
                        <textarea name="description" placeholder="Description"></textarea><br>
                    <button class="btn">Enviar</button>
                </div>
            </div>
            
            <div class="borde1 col-sm-4 color1">
                <div class="footer-info">
                    <iframe src= "https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3976.8095745870037!2d-74.06768554932947!3d4.628037343554653!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x8e3f9a286d598bd5%3A0xddf14904a87dfb47!2sUniversidad+Distrital+Francisco+Jos%C3%A9+de+Caldas!5e0!3m2!1ses-419!2sco!4v1542470620275" frameborder="0" style="border:0" allowfullscreen></iframe>
                </div>
            </div>
            
            <div class="borde1 col-sm-4 color1">
                <div class="footer-info">
                    <h3>Contáctenos</h3>
                    <p><strong>Dirección:</strong> CRA 10 #128-60</p>
                    <p><strong>Correo:</strong> loire@email.com</p>
                    <p><strong>Teléfono:</strong> 89556215</p>
                </div>
            </div>

        </div>
    </footer>

    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  
</body>
</html>
