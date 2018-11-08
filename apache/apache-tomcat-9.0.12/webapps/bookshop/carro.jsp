<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%
   // Get session attribute "carro_actual"
   List<Book> carro_actual = (List<Book>) session.getAttribute("carro");
%>


<!DOCTYPE html>
<html>
<head>
<title>Carro de BookLab</title>
</head>


<body>

<table>
<thead>
<tr>
<th><h2>Tu carro:</h2></th>
<th></th>
</tr>
</thead>


<%if(carro_actual.size() > 0){%>

<tbody>
<tr>
<td align="right">Tienes estos libros en el carro:</td>
<td><%= carro_actual.size()%></td>
</tr>
</tbody>

<%} else {%>

<tbody>
<tr>
<td>No tienes libros el carro :(</td>
<td></td>
</tr>
</tbody>

<%}%>
</table>

<br/>

<form action="catalogo">
    <input type="submit" value="Ver el Catálogo" />
</form>


<table>

<thead>
<tr>
<th>Titulo</th>
<th>Año</th>
<th>ISBN</th>
</tr>
</thead>

<tbody>
<%for(Book book: carro_actual){%>
<tr>
<td><%= book.getTitle()%></td>
<td><%= book.getYear()%></td>
<td><%= book.getIsbn()%></td>
</tr>
<%}%>
</tbody>

</table>


<%if(carro_actual.size() > 0){%>
<form method="POST" action="carro_vaciado_control">
    <input type="submit" value="Vaciar Carro" />
</form>
<%}%>


</body>
</html>
