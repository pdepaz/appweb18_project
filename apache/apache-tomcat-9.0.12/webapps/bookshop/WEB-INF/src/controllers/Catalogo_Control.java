package bookshop;

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
 * Servlet para el controlador del catalogo de BookLab (mi libreria)
 * ¿Qué hace?
 * Recupera de la base de datos la lista completa de libros. 
 * Pasa el control mediante "forward" a la vista del catálogo pasando este listado como parámetro. Si el usuario no tiene aún un carro de la compra, crea uno vacío.
 *
 */
@WebServlet("/catalogo")
public class Catalogo_Control extends HttpServlet {

    /**
     * Método del servlet que responde a una petición GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
        
        //Crear Carro de la compra si no hay uno todavia en la Session
        if (session.getAttribute("carro") == null){ //No hay carro
            List<Book> carro = new ArrayList<Book>();
            session.setAttribute("carro", carro);
        }

        
        try (DBManager db = new DBManager()){
            List<Book> lista_catalogo = db.listBooks();
            
            request.setAttribute("catalogo", lista_catalogo);
            RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
            rd.forward(request, response);
            
        } catch (NamingException e){
            e.printStackTrace(); //Almacena en CATALINA_HOME/logs archivos para ver los errores
            response.sendError(500); //Para ver si es un error del servidor!
        } catch (SQLException e){
            e.printStackTrace(); //Almacena en CATALINA_HOME/logs archivos para ver los errores
            response.sendError(500); //Para ver si es un error del servidor!
        }
    }
}
