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
@WebServlet("/desbloquear_comentario")
public class Desbloquear_comentario extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        boolean solucion = false;
        HttpSession session = request.getSession();
        try (DBManager db = new DBManager()){
            int comentario_id = Integer.parseInt(request.getParameter("comentario_id"));
            int pelicula_id = Integer.parseInt(request.getParameter("pelii_id"));

            solucion = db.desbloquear_comentario(comentario_id);
            if(solucion == false){
              //MANDAR ERROR
              throw new SQLException();
            }
            else{
              //response.sendRedirect("home");
              response.sendRedirect("pelicula?id="+pelicula_id);
            }
        } catch (NamingException|SQLException|NumberFormatException e){
            response.sendRedirect("error");
        }
    }
}
