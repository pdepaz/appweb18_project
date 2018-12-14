<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>


<!DOCTYPE HTML>

<html>
	<head>
		<title>Error - Manloo </title>
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />


	</head>

	<body class="is-preload">
		<div id="page-wrapper">

			<%@ include file='header.jsp' %>

			<section id="main" class="container">
                <header>
                    
                    <h2>Error</h2>
                    <p>Ha habido un problema procesando su solicitud</p>
                    
                    <form action = "home">
							<div class="row gtr-50 gtr-uniform">
	
								<div class="col-4 col-12-mobilep">
									<input type="submit" value="Volver a la Home" class="fit" />
								</div>

							</div>
					</form>

					<section id="cta">

						<div class="col-8 col-12-mobilep">
							<img src="404_error.png" alt="Error">	
						</div>

					</section>

                </header>

            </section>

        <%@ include file='footer.jsp' %>

		</div>

	</body>
</html>
