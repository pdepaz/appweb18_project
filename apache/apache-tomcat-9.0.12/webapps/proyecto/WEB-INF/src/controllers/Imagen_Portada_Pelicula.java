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
 * Muestra la portada de una pelicula (cogiendola de la Base de Datos)
 *
 */
@WebServlet("/imagen")
public class Imagen_Portada_Pelicula extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int pelicula_id = 0;

        pelicula_id = Integer.parseInt(request.getParameter("id")); //Se lo pasamos en la "src" de la imagen y obteniendo el id de la pelicula en el JSP

        try (DBManager db = new DBManager()){

            Pelicula mi_pelicula = db.cargarPelicula(pelicula_id);

            //byte[] portada_img = mi_pelicula.getPortada();




            request.setAttribute("pelicula", mi_pelicula);

            request.getRequestDispatcher("pelicula.jsp").forward(request, response);

        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
