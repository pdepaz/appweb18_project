<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<link rel="stylesheet" href="assets/css/main.css" /> 

<!DOCTYPE html>
<html>
<section id="main" class="container">

    <header>
        <h1>Pelicula</h1>
        <h2><%= pelicula.getTitulo() %></h2>
    </header>

    <body>
        <div class="box">
            <div class="row">
                <h2>Informacion acerca de la película</h3>
                <div class="row-6 row-12-mobilep">
                    <input type="text">
                        <h3>Anyo: <%= pelicula.getAnyo()%></h3>
                        <h3>Duracion: <%= pelicula.getDuracion()%></h3>
                        <h3>Director: <%= pelicula.getDirector()%></h3>
                        <h3>Anyo: <%= pelicula.getAnyo()%></h3>
                        <h3>Descripcion: <%= pelicula.getDescripcion()%></h3>
                        <h3>Trailer: <%= pelicula.getTrailer()%></h3>
                        <h3>Usuario Creador: <%= pelicula.getCreador()%></h3>
                    </input>
                </div>
                <div class="row-6 row-12-mobilep">
                    <img src="image?id=jhgkjhgjhgjh"/> <%--Aquí para insertar la foto de la portada, falta importar la url de la imagen--%>
                </div>
            </div>
        </div>
        
        <% if (comentarios.size() > 0){ %>
            <h2>Comentarios</h2>
                <% for(Comentario tmp: comentarios)%>
                    <% if (tmp.getBloqueado() == 0){ %>
                        <div class="row-6 row-12-mobilep">                                
                            <input type="text">
                                <a href=/usuario?usuarioid = <%=usuario.getId() %>><%= tmp.getUsuario() %>:</a> <%= tmp.getText()%>
                            </input>
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
