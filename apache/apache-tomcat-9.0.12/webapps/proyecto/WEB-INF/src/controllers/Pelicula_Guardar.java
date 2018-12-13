package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Guarda en SQL los datos de un usuario
 *
 */
@WebServlet("/pelicula_guardar")
public class Pelicula_Guardar extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8"); 

        try (DBManager db = new DBManager()){
            
            Pelicula pelicula = new Pelicula();
            pelicula.setTitulo(request.getParameter("titulo"));
            pelicula.setAnyo(Integer.parseInt((request.getParameter("anyo"))));
            pelicula.setDuracion(Integer.parseInt((request.getParameter("duracion"))));
            pelicula.setDescripcion(request.getParameter("descripcion"));
            pelicula.setDirector(request.getParameter("director"));
            pelicula.setGenero(request.getParameter("genero"));
            //Portada pelicula.setPortada(request.getParameter("portada"));
            pelicula.setTrailer(request.getParameter("trailer"));
            
            //El creador es el id del usuario de la sesion
            pelicula.setCreador((int) session.getAttribute("session_id"));
            pelicula.setBloqueado(0); //No bloqueado la pelicula al principio

            db.creaPelicula(pelicula);

            List<Comentario> comentarios = new ArrayList<Comentario>(); //No hay comentarios al principio
            
            Pelicula movie = db.cargar_pelicula_nombrepeli(pelicula.getTitulo());
            
            String url = "pelicula?id=" + movie.getId();
            response.sendRedirect(url);
          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
