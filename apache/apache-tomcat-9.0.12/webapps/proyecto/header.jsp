<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%
Usuario mi_usuario = new Usuario();
if(session.getAttribute("session_id") != null){
	mi_usuario = (Usuario) session.getAttribute("mi_usuario");
}
%>

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
								<a href="perfil">Mi perfil | <%=mi_usuario.getNombre()%></a>
							</li>
							<li>
								<a class="icon fa-angle-down">Nuevo tema</a>
								<ul>
									<li><a href="crear_pelicula.jsp">Pelicula</a></li>
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
					      <%--&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
					      <button type="button" class="olvidarcontrasenya" onclick="location.href='#'">Olvidé mi contraseña</button>--%>
					    </div>
					  </form>
					</div>

</header>