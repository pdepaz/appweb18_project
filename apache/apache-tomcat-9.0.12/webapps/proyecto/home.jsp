<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='false' errorPage='error'%>

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
					<p>Descubra las nuevas maneras de comentar películas, series y libros</p>
					
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
							<h2>AAA 
							<br />
							AAA</h2>
							<p>Párrafo</p>
						</header>
						<span class="image featured"><img src="images/pic01.jpg" alt="" /></span>
					</section>

					<div class="row">
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="images/pic02.jpg" alt="" /></span>
								<h3>Sed lorem adipiscing</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
								<ul class="actions special">
									<li><a href="#" class="button alt">Learn More</a></li>
								</ul>
							</section>

						</div>
						<div class="col-6 col-12-narrower">

							<section class="box special">
								<span class="image featured"><img src="images/pic03.jpg" alt="" /></span>
								<h3>Accumsan integer</h3>
								<p>Con la colaboracion de los ingenieros más selectos, de nosotros para vosotros.<br></br> 
								Usando el conocimiento más exclusivo de la sociedad, las ideas más creativas e innovadoras y las soluciones más ingeniosas jamás conocidas, hemos alcanzado el mejor producto hasta la fecha.
								<br></br>
								No te preocupes por la seguridad, ya nos encargamos nosotros. Tus datos pasan por un control exhaustivo y minucioso para que nadie pueda acceder a ellos. Ni nosotros mismos. Gracias a ello estarás totalmente seguro.</p>
								<ul class="actions special">
									<li><a href="#" class="button alt">Learn More</a></li>
								</ul>
							</section>

						</div>
					</div>

				</section>

			<!-- Crear Cuenta -->
				<section id="cta">

					<h2>Crear cuenta</h2>

					<form>
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

			<!-- Footer -->
				<footer id="footer">
					<ul class="icons">
						<li><a href="https://twitter.com/uc3m" target="_blank" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="https://www.facebook.com/uc3m/" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="https://www.youtube.com/user/UC3M" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="https://github.com/pdepaz/appweb18_project" target="_blank" class="icon fa-github"><span class="label">Github</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Alfonso Albacete, Gonzalo Puy y Pablo de Paz.</li><li>2018</a></li>
					</ul>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="assets/js/login.js"></script>

	</body>
</html>
