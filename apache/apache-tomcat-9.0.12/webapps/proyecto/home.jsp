<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>


<!DOCTYPE HTML>

<html>
	<head>
		<title>Manloo</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		<script src='https://www.google.com/recaptcha/api.js?render=6LfsT34UAAAAADa3jHrtDwYSF7qPbOKuqjJr9QKR'></script>

	</head>

	<body class="landing is-preload">
		<div id="page-wrapper">

			<%@ include file='header.jsp' %>

			<!-- Banner -->
				<section id="banner">
					<h2>Manloo</h2>
					<p>Descubra la nueva manera de comentar películas, series y libros</p>

					<% if(session.getAttribute("session_id") == null){ %>
					<ul class="actions special">
						<li><a class="button primary" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Iniciar Sesion</a></li>
					</ul>
					<% } %>
				</section>


			<!-- Main -->
				<section id="main" class="container">

					<section class="box special">
						<header class="major">
							<h2>La red social de la que todo el mundo está hablando.</h2>
						</header>
						<span class="image featured"><img src="images/pic01.jpg" alt="" /></span>
					</section>

					<div class="row">
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="images/book.jpg" alt="" /></span>
								<h3>¿Por qué Manloo?</h3>
								<p>Desde el nacimiento de las primeras redes sociales ya se buscaba la definitiva, esa que unificase todos tus contenidos en uno. Nosotros lo hemos conseguido.<br/>
								Gracias a una idea innovadora, hemos conseguido simplificarte la vida, para que tengas todo en un solo click. Sin cuotas de alta, sin mentiras, sin publicidad, para gente exclusiva como tú.</p>
							</section>

						</div>
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="images/fondo.jpg" alt="" /></span>
								<h3>¿Cómo lo hemos logrado?</h3>
								<p>Con la colaboracion de los ingenieros más selectos, de nosotros para vosotros.</br>
								Usando el conocimiento más exclusivo de la sociedad, las ideas más creativas e innovadoras y las soluciones más ingeniosas jamás conocidas, hemos alcanzado el mejor producto hasta la fecha.
								<br/>
								No te preocupes por la seguridad, ya nos encargamos nosotros. Tus datos pasan por un control exhaustivo y minucioso para que nadie pueda acceder a ellos. Ni nosotros mismos. Gracias a ello estarás totalmente seguro.</p>
							</section>

						</div>
					</div>

				</section>

			<!-- Crear Cuenta -->
				<section id="cta">

					<h2>Crear cuenta</h2>
					<p>¿A qué estás esperando?</p>
					<form action = "crear_cuenta.jsp">
						<div class="row gtr-50 gtr-uniform">
							<div class="col-8 col-12-mobilep">
								<input type="email" name="email" id="email" placeholder="Email" />
							</div>
							<div class="col-4 col-12-mobilep">
								<input type="submit" value="Crear Cuenta" class="fit" />
							</div>
						</div>
					</form>

				</section>

			<%@ include file='footer.jsp' %>

	</body>
</html>
