<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
		Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario");
    int session_id = session.getAttribute("session_id");
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="/assets/css/main.css" />
	
<title>Mi Perfil</title>
</head>
<body class="is-preload">
  <section id="main" class="container">
          <header>
            <h2>Bienvenido <%= mi_usuario.getNombre()%>, </h2>
            <h3>estos son tus datos: </h3>
          </header>


<div class="col-6 col-12-mobilep" class="alt">
                      <ul>
                        <li>Nombre: <%= mi_usuario.getNombre() %></li>
                        <li>Apellidos: <%= mi_usuario.getApellido1() %> <%= mi_usuario.getApellido2() %></li>
                        <li>Email: <%= mi_usuario.getEmail() %></li>
                        <li>Número de Telefono: <%= mi_usuario.getTelefono() %> </li>
                        <li>Tipo de Usuario: <%= mi_usuario.getTipo_usuario() %> </li>
                      </ul>
	</div>

 <button class="button special small" onclick="location.href='actualizar_usuario.html">Editar Perfil</button>




















  <footer id="footer">
          <ul class="icons">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
          </ul>
          <ul class="copyright">
            <li>All rights reserved.</li>
          </ul>
        </footer>
</body>
</html>
