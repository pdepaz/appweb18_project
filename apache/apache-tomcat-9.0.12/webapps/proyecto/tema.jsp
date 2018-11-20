<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%

    String tema = (String) request.getParameters("tema");
    
    if(tema.equals("Pelicula"){
        Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
    }
    else if(tema.equals("Serie"){
        Serie serie = (Serie) request.getAttribute("serie");
    }
    else if(tema.equals("Libro"){
        Libro libro = (Libro) request.getAttribute("libro");
    }

%>

<!DOCTYPE html>
<html>
<title> <% =tema %> </title>

<head>
    <h1><% = %></h1>
</head>

<form action = "/añadir_comentario">
    <textarea name="comentario" rows="10" cols="40">Escribe aquí tu comentario</textarea>
    <div>
        <input type = "submit" value = "Publicar">
    </div>
</form>

</html>
