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

<h2>Peliculas más nuevas</h2>
<% List<Pelicula> pelis_nuevas = (List<Pelicula>) request.getAttribute("pelis_nuevas");%>
<div class=peliculas_lo_mas_nuevo">
	<table name="t_peliculas_nuevo">
		<tbody>
			<%for(Pelicula movie: pelis_nuevas){%>
				<tr>
						<td><%= movie.getTitulo()%></td>
						<td><%= movie.getAnyo()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</div>

<br/>

<h2>Peliculas recomendadas</h2>
<% List<Pelicula> pelis_recomendadas = (List<Pelicula>) request.getAttribute("pelis_recomendadas");%>
<div class=pelis_recomendadas">
	<table name="t_peliculas_recomen">
		<tbody>
			<%for(Pelicula movie: pelis_recomendadas){%>
				<tr>
						<td><%= movie.getTitulo()%></td>
						<td><%= movie.getAnyo()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</div>




<h2>Peliculas más comentadas</h2>
<% List<Pelicula> pelis_mas_comentadas = (List<Pelicula>) request.getAttribute("pelis_mas_comentadas");%>
<div class=pelis_comentadas">
	<table name="t_peliculas_comentadas">
		<tbody>
			<%for(Pelicula movie: pelis_mas_comentadas){%>
				<tr>
						<td><%= movie.getTitulo()%></td>
						<td><%= movie.getAnyo()%></td>
				</tr>
			<%}%>
		</tbody>
	</table>
</div>

</body>
</html>
