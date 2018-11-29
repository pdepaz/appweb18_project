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

			<!-- Header -->
				<header id="header" class="alt">
					<h1><a href="home">Manloo</h1>
					<!-- BUSCADOR -->
					<nav id="nav">
						<ul>
							<li><a href="home_peliculas">Peliculas</a></li>
							<li><a href="home">Series</a></li>
							<li><a href="home">Libros</a></li>
							<li>
								<a href="#" class="icon fa-angle-down">Nuevo tema</a>
								<ul>
									<li><a href="nueva_pelicula">Pelicula</a></li>
									<li><a href="home">Serie</a></li>
									<li><a href="home">Libro</a></li>
								</ul>
							</li>
							<% if(session.getAttribute("session_id") == null){ %>
								<li><button class="button" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Iniciar Sesión</button></li>
							<% } else { %>
								<li><form action="cerrar_sesion"><button class="button">Cerrar Sesión</button></form></li>
							<% } %>							
						</ul>
					</nav>

					<%--FORMULARIO de INICIAR SESION --%>
					<div id="id01" class="modal">
					  <form class="modal-content animate" method="post" action="iniciar_sesion"> <!--Mandar a nuestro servlet-->
					    <!--Aspa de cerrar y avatar usuario-->
					    <div class="imgcontainer">
					      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Cerrar">&times;</span>
					      <img src="images/img_avatar.png" alt="Avatar" class="avatar">
					    </div>

					    <!--Form propiamente dicho-->					    
					    <div class="container">
					      <label for="uname"><b>Usuario</b></label>
					      <input type="text" placeholder="Introduzca su usuario" name="username" required>

					      <label for="psw"><b>Contraseña</b></label>
					      <input type="password" placeholder="Introduzca su contraseña" name="password" required>
					        
					      <button type="submit" class="submitbutton">Iniciar Sesión</button>
					      <label>
					        <input type="checkbox" checked="checked" name="remember"> Remember me
					      </label>
					    </div>

					    <!--Cancelar y olvidar contrasenya-->
					    <div class="container">
					      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbutton">Cancelar</button>
					      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					      <button type="button" class="olvidarcontrasenya" onclick="location.href='#'">Olvidé mi contraseña</button>
					    </div>
					  </form>
					</div>

				</header>



			<!-- Banner -->
				<section id="banner">
					<h2>Manloo</h2>
					<p>Descubra las nuevas maneras de comentar películas, series y libros</p>
					
					<% if(session.getAttribute("session_id") == null){ %>
					<ul class="actions special">
						<li><a href="#" class="button primary" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Iniciar Sesion</a></li>
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

					<section class="box special features">
						<div class="features-row">
							<section>
								<span class="icon major fa-bolt accent2"></span>
								<h3>Magna etiam</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
							</section>
							<section>
								<span class="icon major fa-area-chart accent3"></span>
								<h3>Ipsum dolor</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
							</section>
						</div>
						<div class="features-row">
							<section>
								<span class="icon major fa-cloud accent4"></span>
								<h3>Sed feugiat</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
							</section>
							<section>
								<span class="icon major fa-lock accent5"></span>
								<h3>Enim phasellus</h3>
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
							</section>
						</div>
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
								<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>
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

			<script>
			// Get the modal
			var modal = document.getElementById('id01');

			// When the user clicks anywhere outside of the modal, close it
			window.onclick = function(event) {
			    if (event.target == modal) {
			        modal.style.display = "none";
			    }
			}
			</script>

	</body>
</html>



<!--
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>


<body>
<table name="html_header" border="1">
<tr>
	<td><h1>Temas de Debate</h1></td>
	<td>BUSCADOR</td>
	<td>Otras cosas por aqui...</td>
</tr>
</table>


<%--Aqui, meter peliculas destacadas (carrousel)

<h2>Peliculas más nuevas</h2>
<% List<Pelicula> pelis_nuevas = (List<Pelicula>) request.getAttribute("pelis_nuevas");%>
<div class=peliculas_lo_mas_nuevo">
	<table name="t_peliculas_nuevo">
		<tbody>
			<%for(Pelicula movie: pelis_nuevas){%>
				<tr>
						<td><%= movie.getTitulo()%></td>
						<td><%= movie.getAnyo()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</div>

<br/>

<h2>Peliculas recomendadas</h2>
<% List<Pelicula> pelis_recomendadas = (List<Pelicula>) request.getAttribute("pelis_recomendadas");%>
<div class=pelis_recomendadas">
	<table name="t_peliculas_recomen">
		<tbody>
			<%for(Pelicula movie: pelis_recomendadas){%>
				<tr>
						<td><%= movie.getTitulo()%></td>
						<td><%= movie.getAnyo()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</div>




<h2>Peliculas más comentadas</h2>
<% List<Pelicula> pelis_mas_comentadas = (List<Pelicula>) request.getAttribute("pelis_mas_comentadas");%>
<div class=pelis_comentadas">
	<table name="t_peliculas_comentadas">
		<tbody>
			<%for(Pelicula movie: pelis_mas_comentadas){%>
				<tr>
						<td><%= movie.getTitulo()%></td>
						<td><%= movie.getAnyo()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</div>

</body>
</html>
 --%>
