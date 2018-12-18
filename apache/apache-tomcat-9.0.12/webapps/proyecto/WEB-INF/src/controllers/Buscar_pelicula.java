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
@WebServlet("/buscar_pelicula")
public class Buscar_pelicula extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        int solucion = -1;

        HttpSession session = request.getSession();
        String peliculita = request.getParameter("nombre_pelicula");

        try (DBManager db = new DBManager()){
            solucion = db.getIdByPelicula(peliculita);
            if(solucion != -1){
              //response.sendRedirect("usuario?id="+solucion);
              response.sendRedirect("pelicula?id="+solucion);
            }
            else{
              response.sendRedirect("error_busqueda");
            }
        } catch (NamingException|SQLException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.sendRedirect("home");
        }
    }
}
