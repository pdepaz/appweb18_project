<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='false' errorPage='error'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario"); %>
<% Usuario usuario = (Usuario) request.getAttribute("usuario"); %>


<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
	<title>Perfil de: <%= usuario.getNombre()%></title>
</head>

<body class="is-preload">

    <%@ include file='header.jsp' %>

  	<section id="main" class="container">
		<header>
            <h2>Este es el perfil de: <%= usuario.getNombre()%></h2>
            <p>Aquí tienes algo de información acerca de este usuario </p>
        </header>

        <div class="col-6 col-12-mobilep" >
            <ul class="alt">
                <li>Nombre: <%= usuario.getNombre() %></li>
                <li>Apellidos: <%= usuario.getApellido1() %> <%= usuario.getApellido2() %></li>
                <li>Email: <%= usuario.getEmail() %></li>
            </ul>
        </div>
	</section>
</body>
</html>
