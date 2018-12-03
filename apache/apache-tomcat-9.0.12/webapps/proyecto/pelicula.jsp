<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='false' errorPage='error'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<link rel="stylesheet" href="assets/css/main.css" /> 

<%Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");%>
<%List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios");%>

<!DOCTYPE html>
<html>
<section id="main" class="container">

    <header>
        <h1>Pelicula</h1>
        <h2><%= pelicula.getTitulo() %></h2>
    </header>

    <body>
    
    <%@ include file='header.jsp' %>
    
        <div class="box">
            <div class="row">
                <h2>Informacion acerca de la película</h3>
                <div class="row-6 row-12-mobilep">
                        <h3>Año: <%= pelicula.getAnyo()%></h3>
                        <h3>Duracion: <%= pelicula.getDuracion()%> min</h3>
                        <h3>Director: <%= pelicula.getDirector()%></h3>
                        <h3>Descripcion: <%= pelicula.getDescripcion()%></h3>
                        <h3>Trailer: </h3> <iframe width="560" height="315" src="<%=pelicula.getTrailer()%>" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        <h3>Usuario Creador: <%= pelicula.getCreador()%></h3>
                </div>
                <div class="row-6 row-12-mobilep">
                    <img src="image?id=jhgkjhgjhgjh"/> <%--Aquí para insertar la foto de la portada, falta importar la url de la imagen--%>
                </div>
            </div>
        </div>
        
        <% if (comentarios.size() > 0){ %>
            <h2>Comentarios</h2>
                <% for(Comentario tmp: comentarios) {%>
                    <% if (tmp.getBloqueado() == 0){ %>
                        <div class="row-6 row-12-mobilep">                                
                            <a href="/usuario?usuarioid=<%=tmp.getId()%>"><%= tmp.getUsuario() %></a>:<%= tmp.getComentario_text()%>
                            <%--AQUI, PONER UN TEXT AREA O ALGO PARA CONTESTAR --%>
                        </div>
                    <% } %>
                <% } %>
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
