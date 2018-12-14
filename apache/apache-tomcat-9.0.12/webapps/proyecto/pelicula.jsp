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
        
        <%if(mi_usuario.getTipo_usuario().equals("MODERADOR")){%>
            
            <%if(pelicula.getBloqueado()==0){%>
              
              <form id = "bloquear_pelicula" action = "bloquear_pelicula" method = "post">
                <input type = "hidden" name ="pelicula_id" value="<%=pelicula.getId()%>">
                  <div class = "boton">
                    <input type = "submit" value = "Bloquear Pelicula">
                  </div>
              </form>
            <%}else{%>
            <p>La película está Bloqueado</p>
              <form id = "desbloquear_pelicula" action = "desbloquear_pelicula" method = "post">
                  <input type = "hidden" name ="pelicula_id" value="<%=pelicula.getId()%>">
                    <div class = "boton">
                      <input type = "submit" value = "Desbloquear Pelicula">
                    </div>
              </form>
            <%}%>
        <%}%>
    </header>

    <body>

    <%@ include file='header.jsp' %>

        <div class="box">
            <div class="row">
                <h2>Información acerca de la película</h3>
                <div class="row-6 row-12-mobilep">
                    <div class="row-6 row-12-mobilep">
                    <h3><b>Portada</b></h3>
                        <%--<img src="<%=pelicula.getTitulo()%>.jpg" alt="<%=pelicula.getTitulo()%>" width="150"/>--%>
                        <img src="imagen?id_pelicula=<%=pelicula.getId()%>" alt="<%=pelicula.getTitulo()%>" width="150"/> 
                        <%--Aquí para insertar la foto de la portada, falta importar la url de la imagen--%>
                    </div>
                    <br/>
                        <h3><b>Año: </b><%= pelicula.getAnyo()%></h3>
                        <h3><b>Duracion: </b><%= pelicula.getDuracion()%> min</h3>
                        <h3><b>Director: </b><%= pelicula.getDirector()%></h3>
                        <h3><b>Descripción: </b><%= pelicula.getDescripcion()%></h3>
                        <h3><b>Trailer: </b></h3> <iframe width="853" height="480" src="<%=pelicula.getTrailer()%>" align="middle" frameborder="0" allowfullscreen ></iframe>

                        <p> </p>
                        <h3><b>Usuario Creador: </b><a href="usuario?usuarioid=<%= usuariocreador.getId()%>"> <b><%= usuariocreador.getUsuario() %></b></a></h3>
                </div>
            </div>
        </div>

        <h2><b>Comentarios</b></h2>
        <% if(comentarios.size() > 0){ %>
            <% for(Comentario tmp: comentarios) { %>
                <%if (mi_usuario.getTipo_usuario().equals("MODERADOR")){ %>
                        <%if (tmp.getBloqueado() == 0){%>
                            <div class="row-6 row-12-mobilep">
                                    <%--Cargar usuario por id, COMPROBAR el usuario bloqueado no puede mostrar comments --%>
                                    <h3> <a href="usuario?usuarioid=<%= tmp.getUsuario()%>"> <b><%= userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() %></b></a>: <%= tmp.getComentario_text()%></h3>
                                <form id = "bloquear_comentario" action = "bloquear_comentario" method = "post">
                                    <input type = "hidden" name ="pelii_id" value="<%=pelicula.getId()%>">
                                    <input type = "hidden" name ="comentario_id" value="<%=tmp.getId()%>">
                                        <div class = "boton">
                                            <input type = "submit" value = "Bloquear Comentario">
                                        </div>
                                </form>
                                <form id = "creacion_comentario_respuesta" action = "comentario_peli_guardar" method = "post">
                                    <input type = "hidden" name ="id_peli" value="<%=pelicula.getId()%>">
                                    <input type = "hidden" name ="id_coment" value="<%=tmp.getId()%>">
                                    <textarea name = "comentario_text" rows="10" cols="40" placeholder="Escriba aquí su comentario"></textarea>
                                      <div class = "boton">
                                          <input type = "submit" value = "Responder">
                                      </div>
                                </form>
                            </div>
                        <%}else{%>
                            <div class="row-6 row-12-mobilep">
                                <%--Cargar usuario por id, COMPROBAR el usuario bloqueado no puede mostrar comments --%>
                                <h3> <a href="usuario?usuarioid=<%= tmp.getUsuario()%>"> <b><%= userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() %></b></a>: <%= tmp.getComentario_text()%></h3>
                                <p>El comentario está Bloqueado</p>
                                <form id = "desbloquear_comentario" action = "desbloquear_comentario" method = "post">
                                <input type = "hidden" name ="pelii_id" value="<%=pelicula.getId()%>">
                                    <input type = "hidden" name ="comentario_id" value="<%=tmp.getId()%>">
                                    <div class = "boton">
                                        <input type = "submit" value = "Desbloquear Comentario">
                                    </div>
                                </form>
                                <form id = "creacion_comentario_respuesta" action = "comentario_peli_guardar" method = "post">
                                    <input type = "hidden" name ="id_peli" value="<%=pelicula.getId()%>">
                                    <input type = "hidden" name ="id_coment" value="<%=tmp.getId()%>">
                                    <textarea name ="comentario_text" rows="10" cols="40" placeholder="Escriba aquí su comentario"></textarea>
                                      <div class = "boton">
                                          <input type = "submit" value = "Responder">
                                      </div>
                                </form>
                            </div>
                        <%}%>
                        
                <%} else {%> <%-- USUARIO NORMAL--%>
                    <%if (tmp.getBloqueado() == 0){%>
                        <div class="row-6 row-12-mobilep">
                        <%--Cargar usuario por id, COMPROBAR el usuario bloqueado no puede mostrar comments --%>
                        <h3> <a href="usuario?usuarioid=<%= tmp.getUsuario()%>"> <b><%= userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() %></b></a>: <%= tmp.getComentario_text()%></h3>
                        <form id = "creacion_comentario_respuesta" action = "comentario_peli_guardar" method = "post">
                                    <input type = "hidden" name ="id_peli" value="<%=pelicula.getId()%>">
                                    <input type = "hidden" name ="id_coment" value="<%=tmp.getId()%>">
                                    <textarea name ="comentario_text" rows="10" cols="40" placeholder="Escriba aquí su comentario"></textarea>
                                      <div class = "boton">
                                          <input type = "submit" value = "Responder">
                                      </div>
                                </form>
                        </div>
                    <%}%>
                <%}%>
            <%}%> <%-- End of FOR--%>
        
        <%} else { %>
            <p>La película no tiene comentarios</p>
        <%}%>
        
        
        <%if(session.getAttribute("session_id") != null){ %>
            <%if(mi_usuario.getBloqueado() == 0){%>
                <form id = "creacion_comentario" action = "comentario_peli_guardar" method = "post">
                    <input type = "hidden" name ="id_peli" value="<%=pelicula.getId()%>">
                    <textarea name ="comentario_text" rows="10" cols="40" placeholder="Escriba aquí su comentario"></textarea>
                      <div class = "boton">
                          <input type = "submit" value = "Publicar">
                      </div>
                </form>
            <%}else{%>
                <p>No puedes comentar esta película, su usuario está bloqueado. Contacte con nosotros en caso de duda</p>
            <%}%>
        <%}%>
        <%@ include file='footer.jsp' %>
      </body>
</section>
</html>
