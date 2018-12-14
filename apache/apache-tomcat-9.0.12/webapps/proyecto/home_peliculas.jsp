<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<link rel="stylesheet" href="assets/css/main.css" />
<%
Usuario mi_usuario = new Usuario();
if(session.getAttribute("session_id") != null){
    mi_usuario = (Usuario) session.getAttribute("mi_usuario");
} else {
    mi_usuario.setTipo_usuario("USUARIO");
}
%>


<!DOCTYPE html>
<html>
    <section id="main" class="container">
        <head>
            <title>Home</title>
        </head>

        <body>

        <%@ include file='header.jsp' %>

        <%--PELICULAS MAS NUEVAS --%>
        <section id="main" class="container">
            <h2><b>Peliculas más nuevas</b></h2>
            <% List<Pelicula> pelis_nuevas = (List<Pelicula>) request.getAttribute("pelis_nuevas");%>
        </section>

            <div class="row">
                <%for(Pelicula movie: pelis_nuevas){%>
                    
                    <%if(session.getAttribute("session_id") != null){%> <%-- Si sesion iniciada --%>
                        
                        <%if(mi_usuario.getTipo_usuario().equals("MODERADOR")){%> <%--el usuario es Moderador --%>
                            
                            <div class="col-6 col-12-narrower">
                                <section class="box special">
                                    <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                        <h3><b><%= movie.getTitulo()%></b></h3>
                                            <p><%= movie.getDescripcion()%></p>
                                        <ul class="actions special">
                                            <%if(movie.getBloqueado() == 1){%>
                                                <li><button type="button" onclick="location.href='pelicula?id=<%= movie.getId()%>'" class="cancelbutton">Bloqueada (más info)</button></li>
                                            <%} else {%>
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                            <%}%>
                                        </ul>
                                </section>
                            </div>
                            
                        <%} else {%> <%--NO moderador --%>

                            <%if(movie.getBloqueado() == 0){%> <%-- Entra, si la pelicula NO bloqueada  --%>
                                <div class="col-6 col-12-narrower">
                                    <section class="box special">
                                        <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                            <h3><b><%= movie.getTitulo()%></b></h3>
                                                <p><%= movie.getDescripcion()%></p>
                                            <ul class="actions special">
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                                
                                            </ul>
                                    </section>
                                </div>
                            <%}%>

                        <% } %>
                    <%} else {%> <%--Sesion no iniciada --%>
                            
                            <%if(movie.getBloqueado() == 0){%> <%-- Entra, si la pelicula NO bloqueada  --%>
                                <div class="col-6 col-12-narrower">
                                    <section class="box special">
                                        <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                            <h3><b><%= movie.getTitulo()%></b></h3>
                                                <p><%= movie.getDescripcion()%></p>
                                            <ul class="actions special">
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                                
                                            </ul>
                                    </section>
                                </div>
                            <%}%>
                    <%}%>
                <%}%>
            </div>
            
            
            
            
            
            
            <%--PELICULAS RECOMENDADAS --%>
            <%if(session.getAttribute("session_id") != null){%>
            <section id="main" class="container">
                <h2><b>Peliculas Recomendadas</b></h2>
                <% List<Pelicula> pelis_recomendadas = (List<Pelicula>) request.getAttribute("pelis_recomendadas");%>
            </section>

            <div class="row">
                <%for(Pelicula movie: pelis_recomendadas){%>
                    
                    <%if(session.getAttribute("session_id") != null){%> <%-- Si sesion iniciada --%>
                        
                        <%if(mi_usuario.getTipo_usuario().equals("MODERADOR")){%> <%--el usuario es Moderador --%>
                            
                            <div class="col-6 col-12-narrower">
                                <section class="box special">
                                    <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                        <h3><b><%= movie.getTitulo()%></b></h3>
                                            <p><%= movie.getDescripcion()%></p>
                                        <ul class="actions special">
                                            <%if(movie.getBloqueado() == 1){%>
                                                <li><button type="button" onclick="location.href='pelicula?id=<%= movie.getId()%>'" class="cancelbutton">Bloqueada (más info)</button></li>
                                            <%} else {%>
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                            <%}%>
                                        </ul>
                                </section>
                            </div>
                            
                        <%} else {%> <%--NO moderador --%>

                            <%if(movie.getBloqueado() == 0){%> <%-- Entra, si la pelicula NO bloqueada  --%>
                                <div class="col-6 col-12-narrower">
                                    <section class="box special">
                                        <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                            <h3><b><%= movie.getTitulo()%></b></h3>
                                                <p><%= movie.getDescripcion()%></p>
                                            <ul class="actions special">
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                                
                                            </ul>
                                    </section>
                                </div>
                            <%}%>

                        <% } %>
                    <%} else {%> <%--Sesion no iniciada --%>
                            
                            <%if(movie.getBloqueado() == 0){%> <%-- Entra, si la pelicula NO bloqueada  --%>
                                <div class="col-6 col-12-narrower">
                                    <section class="box special">
                                        <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                            <h3><b><%= movie.getTitulo()%></b></h3>
                                                <p><%= movie.getDescripcion()%></p>
                                            <ul class="actions special">
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                            </ul>
                                    </section>
                                </div>
                            <%}%>
                    <%}%>
                <%}%>
            </div>
            <%}%>
            
            
            
            
            <%--PELICULAS MAS COMENTADAS --%>
            <section id="main" class="container">
                <h2><b>Peliculas más comentadas</b></h2>
                <% List<Pelicula> pelis_mas_comentadas = (List<Pelicula>) request.getAttribute("pelis_mas_comentadas");%>
            </section>

                <div class="row">
                    <%for(Pelicula movie: pelis_mas_comentadas){%>
                        
                        <%if(session.getAttribute("session_id") != null){%> <%-- Si sesion iniciada --%>
                            
                            <%if(mi_usuario.getTipo_usuario().equals("MODERADOR")){%> <%--el usuario es Moderador --%>
                                
                                <div class="col-6 col-12-narrower">
                                    <section class="box special">
                                        <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                            <h3><b><%= movie.getTitulo()%></b></h3>
                                                <p><%= movie.getDescripcion()%></p>
                                            <ul class="actions special">
                                                <%if(movie.getBloqueado() == 1){%>
                                                    <li><button type="button" onclick="location.href='pelicula?id=<%= movie.getId()%>'" class="cancelbutton">Bloqueada (más info)</button></li>
                                                <%} else {%>
                                                    <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                                <%}%>
                                            </ul>
                                    </section>
                                </div>
                                
                            <%} else {%> <%--NO moderador --%>

                            <%if(movie.getBloqueado() == 0){%> <%-- Entra, si la pelicula NO bloqueada  --%>
                                <div class="col-6 col-12-narrower">
                                    <section class="box special">
                                        <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                            <h3><b><%= movie.getTitulo()%></b></h3>
                                                <p><%= movie.getDescripcion()%></p>
                                            <ul class="actions special">
                                                <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                                
                                            </ul>
                                    </section>
                                </div>
                            <%}%>

                        <% } %>
                    <%} else {%> <%--Sesion no iniciada --%>
                                
                                <%if(movie.getBloqueado() == 0){%> <%-- Entra, si la pelicula NO bloqueada  --%>
                                    <div class="col-6 col-12-narrower">
                                        <section class="box special">
                                            <span class="image featured"><img src="<%=movie.getTitulo()%>.jpg" alt="" /></span>
                                                <h3><b><%= movie.getTitulo()%></b></h3>
                                                    <p><%= movie.getDescripcion()%></p>
                                                <ul class="actions special">
                                                    <li><a href="pelicula?id=<%= movie.getId()%>" class="button alt">Más Info</a></li>
                                                    
                                                </ul>
                                        </section>
                                    </div>
                                <%}%>
                        <%}%>
                    <%}%>
                </div>
                
            <%@ include file='footer.jsp' %>
        </body>
    </section>
</html>
