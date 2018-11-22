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
 * Controlador de ejemplo
 *
 */
@WebServlet("/controlar_tema")
public class Controlador_Tema extends HttpServlet {

    /**
     * Método del servlet que responde a una petición GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
    
        try (DBManager db = new DBManager()){
        
            /*Es necesario hacer casting??*/
            
            Pelicula pelicula;
            Serie serie;
            Libro libro;
            
            Comentario comentario = (Comentario) request.getAtribute("comentario");
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            String tema = (String) request.getParameters("tema");
            Integer id = (Integer) request.getParameters("id");
            
            if(tema.equals("Pelicula")){
                pelicula = db.cargarPelicula(id);
                request.setAttribute(pelicula, "pelicula");
                
                RequestDispatcher rd = request.getRequestDispatcher("pelicula.jsp");
                rd.forward(request, response);
            }
            else if(tema.equals("Serie")){
                serie = db.cargarSerie(id);
                request.setAttribute(serie, "serie");
                
                RequestDispatcher rd = request.getRequestDispatcher("serie.jsp");
                rd.forward(request, response);
            }
            else if(tema.equals("Libro")){
                libro = db.cargarLibro(id);
                request.setAttribute(libro, "libro");
                
                RequestDispatcher rd = request.getRequestDispatcher("libro.jsp");
                rd.forward(request, response);
            }
                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
