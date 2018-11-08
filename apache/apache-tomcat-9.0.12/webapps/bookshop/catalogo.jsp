<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%
   // Get session attribute "carro"
   List<Book> carro = (List<Book>) session.getAttribute("carro");
%>


<!DOCTYPE html>
<html>
<head>
<title>Catalogo de BookLab</title>
</head>

<body>


<table>
<thead>
<tr>
<th><h2>BookLab le ofrece un amplio catálogo de libros</h2></th>
<th></th>
<th></th>
</tr>
</thead>


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
