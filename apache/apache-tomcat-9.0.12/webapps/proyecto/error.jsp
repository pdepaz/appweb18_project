<%@ page language='java' contentType='text/html;charset=utf-8' isErrorPage='true'%>

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
                            <li><a href="home" class="Volver a la Home">Special</a></li>
                        </ul>
                    </section>
                </header>
            </section>

            
            
			<!-- Footer -->
				<footer id="footer">
					<ul class="icons">
						<li><a href="https://twitter.com/uc3m" target="_blank" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
						<li><a href="https://www.facebook.com/uc3m/" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
						<li><a href="https://www.youtube.com/user/UC3M" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
						<li><a href="https://github.com/pdepaz/appweb18_project" target="_blank" class="icon fa-github"><span class="label">Github</span></a></li>
					</ul>
					<ul class="copyright">
						<li>&copy; Alfonso Albacete, Gonzalo Puy y Pablo de Paz.</li><li>2018</a></li>
					</ul>
				</footer>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.dropotron.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			<script src="assets/js/login.js"></script>

	</body>
</html>
