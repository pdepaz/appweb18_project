<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%

        Serie serie = (Serie) request.getAttribute("serie");
        
%>

<!DOCTYPE html>
<html>
<title> <% SERIES %> </title>

<head>
    <h1><% =serie.getTitulo() %></h1>
</head>

<body>

<p> Anyo: <%serie.getAnyo()%> </p>
<p> Temporadas: <%serie.getTemporadas()%> </p>
<p> Capitulos Totales: <%serie.getCapitulos()%> </p>
<p> Genero: <%serie.getGenero()%> </p>
<p> Trailer: <%serie.getTrailer()%> </p>

<p>Su comentario va a ser respuesta a algun comentario, marque respuesta de ser así</p>
<input type="checkbox" name="respuesta" value="Respuesta">

<form id ="creacion_comentario" action = "/añadir_comentario">
    <textarea name="comentario" rows="10" cols="40">Escribe aquí tu comentario</textarea>
    <div class = "boton">
        <input type = "submit" value = "Publicar">
    </div>
</form>

</body>

</html>
