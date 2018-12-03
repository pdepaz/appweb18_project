<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='false'%>


<!-- Header -->
				<header id="header" class="alt">
					<h1><a href="home">Manloo</h1>
					<!-- BUSCADOR -->
					<nav id="nav">
						<ul>
							<li><a href="home_peliculas">Peliculas</a></li>
							<li><a href="home">Series</a></li>
							<li><a href="home">Libros</a></li>
							<% if(session.getAttribute("session_id") != null){ %>
							<li>
								<a href="#" class="icon fa-angle-down">Nuevo tema</a>
								<ul>
									<li><a href="nueva_pelicula">Pelicula</a></li>
									<li><a href="pelicula?id=2">Serie</a></li>
									<li><a href="home">Libro</a></li>
								</ul>
							</li>
							<% } %>
							<% if(session.getAttribute("session_id") == null){ %>
								<li><button class="button" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Iniciar Sesion</button></li>
							<% } else { %>
								<li><form action="cerrar_sesion"><button class="button">Cerrar Sesion</button></form></li>
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

					      <div class="g-recaptcha" data-sitekey="6LfsT34UAAAAADa3jHrtDwYSF7qPbOKuqjJr9QKR"></div>
					        
					      <button type="submit" class="submitbutton">Iniciar Sesion</button>
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
