<%-- 
    Document   : index
    Created on : 27-oct-2019, 18:17:01
    Author     : sakur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/estilosindex.css">
	<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&display=swap" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="css/loading.css"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <script src="https://kit.fontawesome.com/e60fb28277.js"></script>
    <script src="js/jquery-3.4.1.min.js"></script>
    <script src="js/filtro.js"></script>
	<title>Document</title>
</head>
<body class="hidden">
	<div class="centrado" id="onload">
		<div class="ld ld-hourglass ld-spin-fast" style="font-size:64px;color:#8da"></div>
	</div>
	<header>
		<nav id="nav" class="nav1">
			<div class="contenedor-nav">
				<div class="logo">
					<img src="img/wIPQrudF5R.svg" alt=""></div>
				<div class="enlaces" id="enlaces">
					<a href="#" id="enlace-inicio" class="btn-header">Inicio</a>
					<a href="#" id="enlace-equipo" class="btn-header">Equipo</a>
					<a href="#" id="enlace-servicio" class="btn-header">Servicio</a>
					<a href="#" id="enlace-trabajo" class="btn-header">Trabajo</a>
					<a href="#" id="enlace-contacto" class="btn-header">Contactenos</a>
                                        <a href="inicioSesion.jsp" class="btn-header">Inicio Sesión</a>    
				</div>
                            <div class="enlaces" id="enlaces"><a href="inicioSesion.jsp" class="btn-header ingles"><img src="img/ingles.jpg"></a></div>
				<div class="icono" id="open">
					<span>&#9776;</span>
				</div>
			</div>
		</nav>
		<div class="textos">
			<h1>Loire</h1>
			<h2>Recoleccion, Almacenaje y Comportaje de residuos Organicos</h2>
			<!--<a href="#">Contactenos</a>-->
		</div>
	</header>
	<main>
		<section class="team contenedor" id="equipo">
			<h3>Nuestro equipo de Trabajo</h3>
			<p class="after">conoce a nuestra gente</p>
			<div class="card">
				<div class="content-card">
					<div class="people">
						<img src="img/persona1.jpg" alt="">
					</div>
					<div class="texto-team">
						<h4>k</h4>
						<p>lorem ipsum dolor sit...</p>
					</div>
				</div>
				<div class="content-card">
					<div class="people">
						<img src="img/persona2.jpg" alt="">
					</div>
					<div class="texto-team">
						<h4>k</h4>
						<p>lorem ipsum dolor sit...</p>
					</div>
				</div>
				<div class="content-card">
					<div class="people">
						<img src="img/persona3.jpg" alt="">
					</div>
					<div class="texto-team">
						<h4>k</h4>
						<p>lorem ipsum dolor sit...</p>
					</div>
				</div>
			</div>
		</section>
		<section class="about" id="servicio">
			<div class="contenedor">
				<h3>nuestros servicios</h3>
				<p class="after">siempre mejorando para ti</p>
				<div class="servicios">
					<div class="caja-servicios">
						<img src="img/corazon.png" alt="">
						<h4>creativos y asombrosos</h4>
						<p>Lorem itsum dolor sit amet consectetur.</p>
					</div>
					<div class="caja-servicios">
						<img src="img/responsive.png" alt="">
						<h4>creativos y asombrosos</h4>
						<p>Lorem itsum dolor sit amet consectetur.</p>
					</div>
					<div class="caja-servicios">
						<img src="img/efectos.png" alt="">
						<h4>creativos y asombrosos</h4>
						<p>Lorem itsum dolor sit amet consectetur.</p>
					</div>
				</div>
			</div>
		</section>
		<section class="work contenedor" id="trabajo">
			<h3>nuestro trabajo</h3>
			<p class="after">hacemos lo extraordinario con algo simple</p>
			<div class="botones-work">
				<ul>
					<li class="filter active" data-nombre="todos">todos</li>
					<li class="filter" data-nombre="diseno">Diseno</li>
					<li class="filter" data-nombre="marketing">marketing</li>
					<li class="filter" data-nombre="programacion">programacion</li>
				</ul>
			</div>
			<div class="galeria-work">
				<div class="cont-work programacion">
					<div class="img-work">
						<img src="img/programacion1.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Programacion</h4>
					</div>
				</div>
				<div class="cont-work programacion">
					<div class="img-work">
						<img src="img/programacion2.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Programacion</h4>
					</div>
				</div>
				<div class="cont-work programacion">
					<div class="img-work">
						<img src="img/programacion3.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Programacion</h4>
					</div>
				</div>

				<div class="cont-work marketing">
					<div class="img-work">
						<img src="img/marketing1.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Marketing</h4>
					</div>
				</div>
				<div class="cont-work marketing">
					<div class="img-work">
						<img src="img/marketing2.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Marketing</h4>
					</div>
				</div>
				<div class="cont-work marketing">
					<div class="img-work">
						<img src="img/marketing3.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Marketing</h4>
					</div>
				</div>

				<div class="cont-work diseno">
					<div class="img-work">
						<img src="img/diseño1.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Diseno</h4>
					</div>
				</div>
				<div class="cont-work diseno">
					<div class="img-work">
						<img src="img/diseño2.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Diseno</h4>
					</div>
				</div>
				<div class="cont-work diseno">
					<div class="img-work">
						<img src="img/diseño3.jpg" alt="">
					</div>
					<div class="textos-work">
						<h4>Diseno</h4>
					</div>
				</div>
			</div>
		</section>
	</main>
	<footer>
		<div class="footer contenedor">
			<div class="marca-logo">
				<img src="img/wIPQrudF5R.svg" alt="">
			</div>
			<div class="iconos">
				<i class="fab fa-youtube-square"></i>
				<i class="fab fa-github"></i>
				<i class="fab fa-facebook"></i>
			</div>
			<p>la pasion y la innovacion es lo que nos destaca del resto</p>
		</div>
	</footer>
	<script src="js/script.js"></script>
</body>
</html>
