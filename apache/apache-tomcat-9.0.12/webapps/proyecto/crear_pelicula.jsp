<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <title>Crea pelicula</title>
    </head>

            <body class="is-preload">

            <%@ include file='header.jsp' %>
            <div class="row">
                <div class="col-12">
                    <section class="box">
                    <b><h3>Pelicula</h3></b>
                        <form method="post" action="pelicula_guardar">
                            <div class="row gtr-uniform gtr-50">
                                <div class="col-6 col-12-mobilep">
                                    <select name="genero" >

                                        <option value="Comedia">Comedia</option>
                                        <option value="Accion">Accion</option>
                                        <option value="Animacion">Animacion</option>
                                        <option value="Documental">Documental</option>
                                        <option value="Drama">Drama</option>
                                        <option value="Ciencia Ficcion">Ciencia Ficcion</option>
                                        <option value="Erotico">Erotico</option>
                                        <option value="Terror">Terror</option>
                                    </select>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Titulo" name="titulo" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Duracion (min)" name="duracion" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Anyo" name="anyo" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Director" name="director" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="YouTube Trailer" name="trailer" >
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <textarea name="descripcion" rows="5" cols="40" placeholder="Escriba aqui la descipcion"> </textarea>
                                </div>

                            <div class="col-12">
                                <ul class="actions">
                                    <li><input type="submit" value="Enviar"></li>
                                    <li><input type="reset" value="Cancelar" class="alt"></li>
                                </ul>
                            </div>
                        </div>
                    </form>
                </section>
            </div>
        </div>

        <%@ include file='footer.jsp' %>
      </body>
</html>
