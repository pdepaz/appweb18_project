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
 * Muestra la vista de una pelicula de acuerdo con su ID
 *
 */
@WebServlet("/pelicula")
public class Pelicula_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        //COGER EL ID DE LA PELICULA DE pelicula?id=00
        //Como!?
        //int pelicula_id = (int) session.getAttribute("id_usuario_logeado");
        int pelicula_id = 2;

        try (DBManager db = new DBManager()){

            //Accede a la base de datos y coge sus datos para mostrarlos luego en la JSP
            Pelicula mi_pelicula = db.cargarPelicula(pelicula_id);

            //Ahora, cogemos los comentarios asociados a esta pelicula
            List<Comentario> comentarios = db.cargar_comentarios_list(pelicula_id, "Pelicula");

            request.setAttribute("comentarios", comentarios);
            request.setAttribute("pelicula", mi_pelicula);

            //response.sendRedirect("pelicula.jsp");
          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
