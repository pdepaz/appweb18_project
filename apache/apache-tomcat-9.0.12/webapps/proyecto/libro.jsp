<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='bookshop.Book'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%

        Libro libro = (Libro) request.getAttribute("libro");
        String tema = (String) request.getAttribute("tema");
        int id = (Integer) request.getAttribute("id");
        
        List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios");

%>

<!DOCTYPE html>
<html>
<title> <% LIBROS %> </title>

<head>
    <h1><% =libro.getTitulo()%></h1>
</head>

<body>

<p> Anyo: <%libro.getAnyo()%> </p>
<p> Paginas: <%libro.getPaginas()%> </p>
<p> Escritor: <%libro.getEscritor()%> </p>
<p> Editorial: <%libro.getEditorial()%> </p>
<p> Genero: <%libro.getGenero()%> </p>

<p>Su comentario va a ser respuesta a algun comentario, marque respuesta de ser así</p>
<input type="checkbox" name="respuesta" value="Respuesta">

<table>
    <thead>
        Comentarios:
    </thead>
    <tbody>
        <% for(Comentario tmp: comentarios)%>
            <% if (tmp.getBloqueado() = 0){ %>
                <tr><td>AQUI INFO DEL COMENTARIO</td> </tr>
            <% } %>
        <% } %>
    </tbody>
</table>

<form id = "creacion_comentario" action = "/añadir_comentario">
    <textarea name="comentario" rows="10" cols="40" placeholder = "Escribe aquí tu comentario"></textarea>
    <input type="hidden" name="id" value="<% id %>">
    <input type="hidden" name="tema" value="<% tema %>">
    <div class = "boton">
        <input type = "submit" value = "Publicar">
    </div>
</form>

</body>

</html>
