<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
		Usuario miusuario = (Usuario) session.getAttribute("miusuario")

%>


<!DOCTYPE html>
<html>
<head>

	
<title>Mi Perfil</title>
</head>

<body>

	<div class="InfoPersonal">
		name = <%= user.getName() %>
		appellidos = <%= user.getApellido1() %> <%= user.getApellido2()%>
		email = <%= getEmail()%>
	</div>


	<button onclick="editPerfil()">Editar Perfil</button>

<% boolean mostrar = false; %>
<%
public void editPerfil() {
  mostrar = true;
}

%>

<% if (mostrar){ %>
//Fomrulario para editar el perfil
<form action="/Usuario_Control" method="post" >

  Nombre:  
  <input type="text" name="nombre" value="Pablo">
  <br> primer apellido: 
  <input type="text" name="apellido1" value="Comemierda">
  <br> segundo apellido: 
  <input type="text" name="apellido2" value="De Paz">
  <br> Correo electrónico: 
  <input type="email" name="email">
  <br> Número de teléfono: 
  <input type="tel" name="telefono">
  <br> Contraseña: 
  <input type="email" name="email">
  <br> Contraseña: 
  <input type="email" name="contrasenya">
  <br><br>

  <input type="submit" value="Guardar Cambios">
</form> 

<% } %>


<%if(carro.size() > 0){%>

<tbody>
<tr>
<td align="right">Tienes estos libros en el carro:</td>
<td><%= carro.size()%></td>
<td>
<form action="carro_vista_control">
    <input type="submit" value="Ver Carro" />
</form>
<form action="carro_vaciado_control">
    <input type="submit" value="Vaciar Carro" />
</form>

</td>
</tr>
</tbody>

<%} else {%>

<tbody>
<tr>
<td>No tienes libros el carro :(</td>
<td></td>
<td></td>
</tr>
</tbody>

<%}%>

</table>

<br/>


<%List<Book> libros = (List<Book>) request.getAttribute("catalogo");%>

<form id="oferta_de_libros" method="post" action="carro_add">

<%for(Book book: libros){%>
<input type="checkbox" name="catalogo_form" value="<%= book.getIsbn()%>">
<%= book %><br>
<%}%>

<div class="boton">
<input type="submit" value="Añadir al carro">
</div>

</form>

</body>
</html>
