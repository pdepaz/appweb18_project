<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='false' errorPage='error'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<link rel="stylesheet" href="assets/css/main.css" />

<%Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");%>
<%List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios_pelicula");%>
<%List<Usuario> userscomentadores = (List<Usuario>) request.getAttribute("usersComentadores"); %>
<% Usuario usuariocreador = (Usuario) request.getAttribute("usuariocreador"); %>
<!DOCTYPE html>
<html>
<section id="main" class="container">

    <header>
        <h1>Pelicula</h1>
        <h2><b><%= pelicula.getTitulo() %></b></h2>
    </header>

    <body>

    <%@ include file='header.jsp' %>

        <div class="box">
            <div class="row">
                <h2>Información acerca de la película</h3>
                <div class="row-6 row-12-mobilep">
                    <div class="row-6 row-12-mobilep">
                    <h3><b>Portada</b></h3>
                        <img src="<%=pelicula.getTitulo()%>.jpg"/> <%--Aquí para insertar la foto de la portada, falta importar la url de la imagen--%>
                    </div>
                    <br/>
                        <h3><b>Año: </b><%= pelicula.getAnyo()%></h3>
                        <h3><b>Duracion: </b><%= pelicula.getDuracion()%> min</h3>
                        <h3><b>Director: </b><%= pelicula.getDirector()%></h3>
                        <h3><b>Descripción: </b><%= pelicula.getDescripcion()%></h3>
                        <h3><b>Trailer: </b></h3> <iframe width="560" height="315" src="<%=pelicula.getTrailer()%>" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                        <p> </p>
                        <h3><b>Usuario Creador: </b><a href="usuario?usuarioid=<%= usuariocreador.getId()%>"> <b><%= usuariocreador.getUsuario() %></b></a></h3>
                </div>
            </div>
        </div>

        <h2><b>Comentarios</b></h2>
        <% if(comentarios.size() > 0){ %>
            <% for(Comentario tmp: comentarios) { %>
           
                <% if (tmp.getBloqueado() == 0){ %>
                    <div class="row-6 row-12-mobilep">
                        <%--Cargar usuario por id, COMPROBAR el usuario bloqueado no puede mostrar comments --%>
                       <h3> <a href="usuario?usuarioid=<%= tmp.getUsuario()%>"> <b><%= userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() %></b></a>: <%= tmp.getComentario_text()%></h3>
                        <%--AQUI, PONER UN TEXT AREA O ALGO PARA CONTESTAR --%>
                    </div>
                <% } %>
               
            <% } %>
        <% }else{ %>
            <p>La película no tiene comentarios</p>
        <% } %>

        <form id = "creacion_comentario" action = "comentario_peli_guardar" method = "post">
            <input type = "hidden" name ="id_peli" value="<%=pelicula.getId()%>">
            <textarea name ="comentario_text" rows="10" cols="40">Escribe aquí tu comentario</textarea>
            <div class = "boton">
                <input type = "submit" value = "Publicar">
            </div>
        </form>
    </body>
</section>
</html>
