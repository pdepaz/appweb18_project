<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<!DOCTYPE html>
<html>
            <head>
                <meta charset="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
                <link rel="stylesheet" href="assets/css/main.css" />
                <title>Crea cuenta</title>
            </head>

            <body class="is-preload">

            <%@ include file='header.jsp' %>

                <div class="row">
                    <div class="col-12">
                        <section class="box">
                           <b><h3>Formulario</h3></b>
                                <form method="post" action="usuario_guardar">
                                    <div class="row gtr-uniform gtr-50">
                                        <div class="col-6 col-12-mobilep">
                                            <input type="text" name="nombre" id="nombre" value="" placeholder="nombre">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                            <input type="text" name="apellido1" id="apellido1" value="" placeholder="Primer Apellido">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                            <input type="text" name="apellido2" id="apellido2" value="" placeholder="Segundo Apellido">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                                <input type="email" name="email" id="email" value="" placeholder="Email">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                                <input type="password" name="contrasenya" id="contrasenya" value="" placeholder="Clave">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                            <input type="password" name="contrasenya2" id="contrasenya2" value="" placeholder="Repita clave">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                            <input type="text" name="usuario" id="usuario" value="" placeholder="Usuario">
                                        </div>
                                        <div class="col-6 col-12-mobilep">
                                            <input type="text" name="telefono" id="telefono" value="" placeholder="Telefono">
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