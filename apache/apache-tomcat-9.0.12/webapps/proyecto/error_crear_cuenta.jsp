<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>


<!DOCTYPE HTML>

<html>
    <head>
        <title>Error - Manloo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />


    </head>

    <body class="is-preload">
        <div id="page-wrapper">

            <%@ include file='header.jsp'%>
            <br/>

            <section id="main" class="container">
                <header>
                    <h2>Se ha producido un error al crear su cuenta, vuelva a intentarlo</h2>
                    <br/>
                    
                    <% if(session.getAttribute("session_id") != null){ %>
                            <form id = "buscar_usuario" action = "buscar_usuario" method = "post">
                                <input type="text" name ="nombre_usuario" size = "2">
                                    <div class = "boton">
                                            <input type = "submit" value = "Buscar">
                                    </div>
                            </form>
                    <%}%>

                </header>
            </section>

        <%@ include file='footer.jsp' %>

        </div>

    </body>
</html>