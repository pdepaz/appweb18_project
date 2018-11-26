<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%
        //recoge la pelicula y la muestra por pantalla
        Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
        /*
        String tema = (String) request.getAttribute("tema");
        int id = (Integer) request.getAttribute("id");
        */
        //recoge comentarios asociados a esa pelicula
        List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios");

%>

<!DOCTYPE html>
<html>
<title>Debate sobre la pelicula </title>

<head>
    <h1><%= pelicula.getTitulo() %></h1>
</head>

<body>

<p> Anyo: <%= pelicula.getAnyo()%> </p>
<p> Duracion: <%= pelicula.getDuracion()%> </p>
<p> Director: <%= pelicula.getDirector()%> </p>
<p> Genero: <%= pelicula.getGenero()%> </p>


<% if (comentarios.size() > 0){ %>
<p>Comentarios</p>
<table>
    <tbody>
        <% for(Comentario tmp: comentarios)%>
            <% if (tmp.getBloqueado() == 0){ %>
                <tr>info del comentario: <%= tmp.getText()%> creador: <%= tmp.getUsuario() %></tr>
            <% } %>
        <% } %>
    </tbody>
</table>
<% } %>

<form id = "creacion_comentario" action = "/comentario_peli_guardar">
    <textarea name="comentario" rows="10" cols="40">Escribe aquí tu comentario</textarea>
    <div class = "boton">
        <input type = "submit" value = "Publicar">
    </div>
</form>

</body>
</html>