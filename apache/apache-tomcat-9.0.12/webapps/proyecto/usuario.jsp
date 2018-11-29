<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
	Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario");
//CARGAMOS LOS DATOS DEL USUARIO RECIBIDO POR PARAMETRO
    Usuario usuario = (Usuario) request.getParameter("usuario");
    //Arriba hay que mostrar el banner con los diferentes menus
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="/assets/css/main.css" />
	<title>Perfil de: <%= usuario.getNombre()%></title>
</head>

<body class="is-preload">

  	<section id="main" class="container">
		<header>
            <h2>Este es el perfil de: <%= usuario.getNombre()%></h2>
        </header>

	
<div class="col-6 col-12-mobilep" class="alt">
                      <ul>
                        <li>Nombre: <%= usuario.getNombre() %></li>
                        <li>Apellidos: <%= usuario.getApellido1() %> <%= usuario.getApellido2() %></li>
                        <li>Email: <%= usuario.getEmail() %></li>
                      </ul>
	</div>

</body>
</html>
