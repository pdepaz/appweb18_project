<%@ page language='java' contentType='text/html;charset=utf-8'%>

<!-- Header -->
<header id="header" class="reveal"> <%--QUITAR "alt" EN LAS PAGINAS QUE NO SON Home Y PONER "reveal" --%>
					<h1><a href="home">Manloo</h1>
					<!-- BUSCADOR -->
					<nav id="nav">
						<ul>
							<li><a href="home_peliculas">Peliculas</a></li>
							<li><a href="home">Series</a></li>
							<li><a href="home">Libros</a></li>
							<% if(session.getAttribute("session_id") != null){ %>
							<li>
								<a href="perfil">Mi perfil</a>
							</li>
							<li>
								<a class="icon fa-angle-down">Nuevo tema</a>
								<ul>
									<li><a href="nueva_pelicula">Pelicula</a></li>
									<li><a href="home">Serie</a></li>
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
					      	<label for="username"><b>Usuario</b></label>
					      	<input type="text" placeholder="Introduzca su usuario" id="username" name="username" required>

					      	<label for="password"><b>Contraseña</b></label>
					      	<input type="password" placeholder="Introduzca su contraseña" id="password" name="password" required>

					      	<button type="submit" class="submitbutton">Iniciar Sesion</button>
                        </div>

                        <%--<div class="container">
							<input type="checkbox" id="remember" name="remember">
							<label for="remember">Recuérdame</label>
						</div>--%>

					    <!--Cancelar y olvidar contrasenya-->
					    <div class="container">
					      	<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbutton">Cancelar</button>
					    </div>
					  </form>
					</div>


					<%--FORMULARIO de CREAR CUENTA --%>
					<div id="id03" class="modal">
									<form class="modal-content animate" autocomplete="off" method="post" action="usuario_guardar">
		                                    <%--Aspa de cerrar--%>
								            <div class="imgcontainer">
										     	<span onclick="document.getElementById('id03').style.display='none'" class="close" title="Cerrar">&times;</span>
										    </div>

										    <%--Formulario--%>	
		                                    <div class="container">
		                                    <div class="row gtr-uniform gtr-50">
		                                        <div class="col-6 col-12-mobilep">
		                                            <input type="text" name="nombre" id="nombre" value="" placeholder="nombre">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                            <input type="text" name="apellido1" id="apellido1" value="" placeholder="Primer Apellido">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                            <input type="text" name="apellido2" id="apellido2" value="" placeholder="Segundo Apellido">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                                <input type="email" name="email" id="email" value="" placeholder="Email">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                                <input type="password" name="contrasenya" id="contrasenya" value="" placeholder="Clave">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                            <input type="password" name="contrasenya2" id="contrasenya2" value="" placeholder="Repita clave">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                            <input type="text" name="usuario" id="usuario" value="" placeholder="Usuario">
		                                        </div>
		                                        <div class="col-6 col-12-mobilep">
		                                            <input type="text" name="telefono" id="telefono" value="" placeholder="Telefono">
		                                        </div>
		                                   
		                                    </div>

		                                    <input type="submit" value="Enviar" class="submitbutton">
		                                    <input type="reset" value="Reset" class="cancelbutton">
		                                    
		                                    </div>
		                                </form>
					</div>

</header>