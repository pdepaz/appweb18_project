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
 * Controlador que bloquea la pelicula elegida por el moderador
 *
 */
@WebServlet("/bloquear_pelicula")
public class Bloquear_Pelicula extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {

        HttpSession session = request.getSession();
        try (DBManager db = new DBManager()){
        int peliculaid = Integer.parseInt(request.getParameter("pelii_id"));

        boolean bloqueada = false;


            bloqueada = db.bloquear_tema("Peliculas",peliculaid);

              if(bloqueada){
                response.sendRedirect("home_peliculas");
              }
            //Else error

        } catch (NamingException|SQLException|NumberFormatException e){
            response.sendRedirect("error");
        }
    }
}
