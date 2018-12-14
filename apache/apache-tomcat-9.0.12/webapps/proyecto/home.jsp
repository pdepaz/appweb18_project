<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>


<!DOCTYPE HTML>

<html>
	<head>
		<title>Manloo</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />

	</head>

	<body class="landing is-preload">
		<div id="page-wrapper">

			<%@ include file='header.jsp' %>

			<!-- Banner -->
				<section id="banner">
					<h2>Manloo</h2>
					<p>Descubra la nueva manera de comentar películas, series y libros</p>

					<%--<ul class="actions special" action="crear_cuenta.">
						<li><a class="button primary" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Crear Cuenta</a></li>
					</ul>--%>

					<%if(session.getAttribute("session_id") == null){ %>
							<form action = "crear_cuenta.jsp">
								<div class = "boton">
										<input type = "submit" value = "Crear Cuenta">
								</div>
							</div>
						</form>
				<%}%>

				</section>


			<!-- Main -->
				<section id="main" class="container">

					<section class="box special">
						<header class="major">
						</header>
						<% if(session.getAttribute("session_id") != null){ %>
						<h2>Busque información acerca de un usuario</h2>
								<form id = "buscar_usuario" action = "buscar_usuario" method = "post">
										<input type="text" name ="nombre_usuario" size = "2">
											<div class = "boton">
													<input type = "submit" value = "Buscar">
											</div>
								</form>
						<%}else{%>
							<h3>La red social de la que todo el mundo está hablando</h3>
						<%}%>
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

					<h2>Envianos tu consulta</h2>
					<p>¿A qué estás esperando?</p>
					<form action = "mailto:manlooAB@hotmail.com?subject=Consulta%20Manloo>
						<div class="row gtr-50 gtr-uniform">
							<div class="boton">
								<input type="submit" value="Consultar" class="fit" />
							</div>
						</div>
					</form>

				</section>

			<%@ include file='footer.jsp' %>

	</body>
</html>
