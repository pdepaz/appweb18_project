<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
		Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario");
//CARGAMOS LOS DATOS DEL USUARIO RECIBIDO POR PARAMETRO
    Usuario usuario = (Usuario) request.getParameter("usuario");
%>

<!DOCTYPE html>
<html>
<head>

	
<title><%= usuario.getNombre()%></title>
</head>

<body>
<%
//MOSTRAR INFORMACION DE USUARIO A MOSTRAR
%>
	<div class="InfoPersonal">
		<p>Nombre: <%= usuario.getNombre() %></p>
		<p>Apellidos: <%= usuario.getApellido1() %> <%= usuario.getApellido2() %></p>
		<p>Email: <%= usuario.getEmail() %></p>
    <p>Telefono: <%= usuario.getTelefono() %></p>
	
	</div>


</body>
</html>
