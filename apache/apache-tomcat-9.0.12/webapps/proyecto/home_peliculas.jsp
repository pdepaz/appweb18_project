<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='false' errorPage='error'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<link rel="stylesheet" href="assets/css/main.css" /> 

<!DOCTYPE html>
<html>
    <section id="main" class="container">
        <head>
            <title>Home</title>
        </head>

        <body>

        <%@ include file='header.jsp' %>
    
        <section id="main" class="container">
            <h2><b>Peliculas más nuevas</b></h2>
            <% List<Pelicula> pelis_nuevas = (List<Pelicula>) request.getAttribute("pelis_nuevas");%>
        </section>
        
            <div class="row">
                <%for(Pelicula movie: pelis_nuevas){%>
                    <div class="col-6 col-12-narrower">
                        <section class="box special">
                            <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                <h3><b><%= movie.getTitulo()%></b></h3>
                                    <p><%= movie.getDescripcion()%></p>
                                <ul class="actions special">
                                    <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">+Info</a></li>
                                </ul>  
                        </section>
                    </div>
                <%}%>
            </div>
            
        <section id="main" class="container">
        <h2><b>Peliculas Recomendadas</b></h2>
        <% List<Pelicula> pelis_recomendadas = (List<Pelicula>) request.getAttribute("pelis_recomendadas");%>
        </section>
        
            <div class="row">
                <%for(Pelicula movie: pelis_recomendadas){%>
                    <div class="col-6 col-12-narrower">
                        <section class="box special">
                            <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                <h3><b><%= movie.getTitulo()%></b></h3>
                                    <p><%= movie.getDescripcion()%></p>
                                <ul class="actions special">
                                    <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">+Info</a></li>
                                </ul>  
                        </section>
                    </div>
                <%}%>
            </div>
            
        <section id="main" class="container">
        <h2><b>Peliculas más comentadas</b></h2>
        <% List<Pelicula> pelis_mas_comentadas = (List<Pelicula>) request.getAttribute("pelis_mas_comentadas");%>
        </section>
        
            <div class="row">
                <%for(Pelicula movie: pelis_mas_comentadas){%>
                    <div class="col-6 col-12-narrower">
                        <section class="box special">
                            <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                <h3><b><%= movie.getTitulo()%></b></h3>
                                    <p><%= movie.getDescripcion()%></p>
                                <ul class="actions special">
                                    <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">+Info</a></li>
                                </ul>  
                        </section>
                    </div>
                <%}%>
            </div>
        </body>
    </section>
</html>
