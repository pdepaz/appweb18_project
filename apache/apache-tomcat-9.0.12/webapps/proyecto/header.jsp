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
									<li><p onclick="document.getElementById('id04').style.display='block'" style="width:auto;">Pelicula</p></li>
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

					<%--FORMULARIO de CREAR PELICULA --%>
					<div id="id04" class="modal">
					  <form class="modal-content animate" method="post" action="pelicula_guardar"> <!--Mandar a nuestro servlet-->
					    <!--Aspa de cerrar-->
					    <div class="imgcontainer">
					      <span onclick="document.getElementById('id04').style.display='none'" class="close" title="Cerrar">&times;</span>
					    </div>

					    <!--Form propiamente dicho-->
					    <div class="container">
					      <form method="post" action="pelicula_guardar">
                            <div class="row gtr-uniform gtr-50">
                                <div class="col-6 col-12-mobilep">
                                    <select name="genero" >

                                        <option value="Comedia">Comedia</option>
                                        <option value="Accion">Accion</option>
                                        <option value="Animacion">Animacion</option>
                                        <option value="Documental">Documental</option>
                                        <option value="Drama">Drama</option>
                                        <option value="Ciencia Ficcion">Ciencia Ficcion</option>
                                        <option value="Erotico">Erotico</option>
                                        <option value="Terror">Terror</option>
                                    </select>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Titulo *" name="titulo" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Duracion (min) *" name="duracion" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Año *" name="anyo" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Director *" name="director" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="YouTube Trailer" name="trailer" >
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <textarea name="descripcion" rows="5" cols="40" placeholder="Escriba aqui la descipcion"></textarea>
                                </div>

                            <div class="col-12">
                                <ul class="actions">
                                    <li><input type="submit" value="Enviar" class="submitbutton"></li>
                                    <li><input type="reset" value="Reset" class="cancelbutton"></li>
                                </ul>
                            </div>
                           </div>
                    	 </form>
                        </div>

					    <!--Cancelar y olvidar contrasenya-->
					    <div class="container">
					      <button type="button" onclick="document.getElementById('id04').style.display='none'" class="cancelbutton">Cancelar</button>
					    </div>
					  </form>
					</div>

</header>