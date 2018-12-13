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

			<%@ include file='header.jsp' %>

			<section id="main" class="container">
                <header>
                    <h2>Error</h2>
                    <p>Ha habido un problema procesando su solicitud :(</p>
                    
                    <section class="box">
                        <ul class="actions">
                            <li><a href="home" class="Volver a la Home">Home</a></li>
                        </ul>
                    </section>
                </header>
            </section>

        <%@ include file='footer.jsp' %>


		</div>

	</body>
</html>
