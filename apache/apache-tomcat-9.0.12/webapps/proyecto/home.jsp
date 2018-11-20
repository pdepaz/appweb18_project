<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>


<!DOCTYPE html>
<html>
<head>
<title>Home</title>
</head>


<body>
<table name="html_header">
<tr>
	<td><h1>Temas de Debate</h1></td>
	<td>BUSCADOR</td>
	<td>Otras cosas por aqui...</td>
</tr>
</table>

<%--Aqui, meter peliculas destacadas (carrousel) --%>

<div class=peliculas_lo_mas_nuevo">
<table name="t_peliculas_nuevo">

<tbody>
<tr>
<td></td>
<td><%= carro_actual.size()%></td>
</tr>
</tbody>
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
</div>


<%if(carro_actual.size() > 0){%>
<form method="POST" action="carro_vaciado_control">
    <input type="submit" value="Vaciar Carro" />
</form>
<%}%>


</body>
</html>
