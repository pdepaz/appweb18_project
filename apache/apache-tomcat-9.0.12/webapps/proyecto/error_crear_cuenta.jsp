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
                    
                    <%if(session.getAttribute("session_id") == null){ %>	
						<ul class="actions special">
							<li><a class="button primary" onclick="document.getElementById('id03').style.display='block'" style="width:auto;">Crear Cuenta</a></li>
						</ul>
					<%}%>

                </header>
            </section>

        <%@ include file='footer.jsp' %>

        </div>

    </body>
</html>