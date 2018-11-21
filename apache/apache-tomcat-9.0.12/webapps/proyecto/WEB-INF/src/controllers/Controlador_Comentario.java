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
@WebServlet("/añadir_comentario")
public class Controlador_Tema extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
    
    
        try (DBManager db = new DBManager()){
        
            Comentario comentario = ; //coger comentario del jsp
            
            int conseguido = db.creaComentario(); //devuelve -1 si no se ha conseguido crear
            
            if(comentario.pelicula = 1){
                RequestDispatcher rd = request.getRequestDispatcher("pelicula.jsp");
                rd.forward(request, response);
            }
            if(comentario.serie = 1){
                RequestDispatcher rd = request.getRequestDispatcher("serie.jsp");
                rd.forward(request, response);
            }
            if(comentario.libro = 1){
                RequestDispatcher rd = request.getRequestDispatcher("libro.jsp");
                rd.forward(request, response);
            }
            
                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
