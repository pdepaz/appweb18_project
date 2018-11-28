<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<link rel="stylesheet" href="assets/css/main.css" /> 

<!DOCTYPE html>
<html>
<<<<<<< HEAD
<section id="main" class="container">
    <header>
        <h2>Pelicula</h2>
        <p><%= pelicula.getTitulo() %></p>
    </header>
    <body>
        <div class="box">
            <div class="row">
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Anyo: <%= pelicula.getAnyo()%></h3>
                    </input>
                </div>
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Duracion: <%= pelicula.getDuracion()%></h3>
                    </input>
                </div>
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Director: <%= pelicula.getDirector()%></h3>
                    </input>
                </div>
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Anyo: <%= pelicula.getAnyo()%></h3>
                    </input>
                </div>
                <div class="row-6 row-12-mobilep">
                    <textarea rows="10" cols="40"> 
                    <h3>Descripcion: <%= pelicula.getDescripcion()%></h3>
                    </textarea>
                </div>
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Trailer: <%= pelicula.getTrailer()%></h3>
                    </input>
                </div>
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Usuario Creador: <%= pelicula.getCreador()%></h3>
                    </input>
                </div>
            </div>
        </div>
        
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
=======
<title>Debate sobre la pelicula </title>

<head>
    <h1><%= pelicula.getTitulo() %></h1>
</head>

<body>

<p> Año: <%= pelicula.getAnyo()%> </p>
<p> Duracion: <%= pelicula.getDuracion()%> </p>
<p> Director: <%= pelicula.getDirector()%> </p>
<p> Director: <%= pelicula.getDirector()%> </p>
<p> Descripcion: <%= pelicula.getDescripcion()%> </p>
<p> Trailer: <%= pelicula.getTrailer()%> </p>
<p> Usuario creador: <%= pelicula.getCreador()%> </p>


<% if (comentarios.size() > 0){ %>
<p>Comentarios</p>
<table>
    <tbody>
        <% for(Comentario tmp: comentarios)%>
            <% if (tmp.getBloqueado() == 0){ %>
                <tr>info del comentario: <%= tmp.getText()%> creador: <%= tmp.getUsuario() %></tr>
>>>>>>> f36407d37976d9bb0359755fa8dea04c4e9b4f24
            <% } %>
        
        <form id = "creacion_comentario" action = "/comentario_peli_guardar">
            <textarea name="comentario" rows="10" cols="40">Escribe aquí tu comentario</textarea>
            <div class = "boton">
                <input type = "submit" value = "Publicar">
            </div>
        </form>
    </body>
</section>
</html>
