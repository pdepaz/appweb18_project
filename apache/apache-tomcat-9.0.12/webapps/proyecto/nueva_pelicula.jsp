<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<!DOCTYPE html>
<html>
            <head>
                <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
                <link rel="stylesheet" href="assets/css/main.css" />
                <title>Nueva película - Manloo</title>
            </head>

            <body class="is-preload">

            <%@ include file='header.jsp' %>

                <div class="row">
                    <div class="col-12">
                        <section class="box">
                            <br/>
                             <b><h3>Cree una nueva película</h3></b>
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
                                    <input type="text" placeholder="Titulo *" name="titulo" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Duracion (min) *" name="duracion" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Año *" name="anyo" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="Director *" name="director" required>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="text" placeholder="YouTube Trailer" name="trailer" >
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <textarea name="descripcion" rows="5" cols="40" placeholder="Escriba aqui la descipcion"></textarea>
                                </div>

                                <div class="col-6 col-12-mobilep">
                                    <input type="file" name="portada" size="50" accept="image/png,image/jpeg" placeholder="Sube una portada (en formato PNG o JPEG)"/>
                                </div>

                            <div class="container">
                                
                                <input type="submit" value="Enviar" class="submitbutton">
                                <input type="reset" value="Reset" class="cancelbutton">
                                
                            </div>
                           </div>
                         </form>
                        </section>
                    </div>
                </div>

            <%@ include file='footer.jsp' %>
            
        </body>
</html>

