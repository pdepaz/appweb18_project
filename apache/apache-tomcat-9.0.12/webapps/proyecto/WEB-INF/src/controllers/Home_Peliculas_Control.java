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
 * Muestra la Home de las Peliculas
 *
 */
@WebServlet("/home_peliculas")
public class Home_Peliculas_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
            
        HttpSession session = request.getSession();
        
        try (DBManager db = new DBManager()){

            List<Pelicula> pelis_nuevas = db.cargar_pelis_mas_nuevas();
            List<Pelicula> pelis_recomendadas = db.cargar_pelis_recomendadas();
            List<Pelicula> pelis_mas_comentadas = db.cargar_pelis_mas_comentadas();
            
            request.setAttribute("pelis_nuevas", pelis_nuevas);
            request.setAttribute("pelis_recomendadas", pelis_recomendadas);
            request.setAttribute("pelis_mas_comentadas", pelis_mas_comentadas);

            request.getRequestDispatcher("home_peliculas.jsp").forward(request, response);
            
        } catch (NamingException|SQLException e){
            //e.printStackTrace(); 
            //response.sendError(500);
            response.sendRedirect("error");
        }
    }
}
