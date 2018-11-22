<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%

        Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
        String tema = (String) request.getAttribute("tema");
        int id = (Integer) request.getAttribute("id");
        
        List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios");

%>

<!DOCTYPE html>
<html>
<title> <% PELICULAS %> </title>

<head>
    <h1><% =pelicula.getTitulo() %></h1>
</head>

<body>

<p> Anyo: <%pelicula.getAnyo()%> </p>
<p> Duracion: <%pelicula.getDuracion()%> </p>
<p> Director: <%pelicula.getDirector()%> </p>
<p> Trailer: <%pelicula.Trailer()%> </p>
<p> Genero: <%pelicula.getGenero()%> </p>


<p>Su comentario va a ser respuesta a algun comentario, marque respuesta de ser así</p>
<input type="checkbox" name="respuesta" value="Respuesta">

<table>
    <thead>
        Comentarios:
    </thead>
    <tbody>
        <% for(Comentario tmp: comentarios)%>
            <% if (tmp.getBloqueado() = 0){ %>
                <tr> info del  tmp(comentario) </tr>
            <% } %>
        <% } %>
    </tbody>
</table>

<form id = "creacion_comentario" action = "/añadir_comentario">
    <textarea name="comentario" rows="10" cols="40">Escribe aquí tu comentario</textarea>
    <div class = "boton">
        <input type = "submit" value = "Publicar">
    </div>
</form>

</body>

</html>
