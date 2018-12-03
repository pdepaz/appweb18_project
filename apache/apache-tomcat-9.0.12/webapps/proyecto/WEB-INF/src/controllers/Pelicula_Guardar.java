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
            //Creador de la pelicula
            //Realmente el creador es el id del usuario creador(el de la sesion)
            pelicula.setCreador((int) session.getAttribute("session_id"));
            //de primeras no estará bloqueada
            pelicula.setBloqueado(0);

            db.creaPelicula(pelicula);

            //EN UNA PELICULA RECIEN CREADA, NO HAY COMENTARIOS!
            List<Comentario> comentarios = new ArrayList<Comentario>();

            request.setAttribute("comentarios", comentarios);
            request.setAttribute("pelicula", pelicula);

            //Enviamos los atributos a través de un request al jsp

            request.getRequestDispatcher("pelicula.jsp").forward(request, response);



          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
