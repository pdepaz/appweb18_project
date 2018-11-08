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
 * Controlador que añade libros al carro de la compra
 * ¿Qué hace?
 * Recibe como parámetros de la petición los identificadores de los libros a añadir al carro, tal como se envíen desde el formulario de la vista del catálogo. 
 * Introduce los libros en el carro de la compra y envía una respuesta de redirección hacia el controlador de visualización del carro de la compra. 
 * Si el usuario no tiene aún un carro de la compra, crea uno vacío.
 *
 */
@WebServlet("/carro_add")
public class Carro_Add_Control extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
        
        //Crear Carro de la compra si no hay uno todavia en la Session
        if (session.getAttribute("carro") == null){ //No hay carro
            List<Book> carro = new ArrayList();
            session.setAttribute("carro", carro);
        }
    
    
        try (DBManager db = new DBManager()){
            List<Book> carro = (List<Book>) session.getAttribute("carro");
            
            List<Book> catalogo = (List<Book>) request.getAttribute("catalogo");

            
            //Si no se marca niguno en los "checklist", se recibirá "NULL"
            //Solo recibe los ISBNs de los libros
            //List<Book> aux_carro = new ArrayList<Book>();
            
            String[] isbn_recibidos = request.getParameterValues("catalogo_form");
            
            //Convert ISBN array (String) to integers!
            //AHORA YA SON STRING QUE VIENEN DE INT (sin XXX.0)
            /*int[] array_isbn = new int[isbn_recibidos.length];
            
            for (int i = 0 ; i < array_isbn.length; i++){
                array_isbn[i]= Integer.parseInt(isbn_recibidos[i]);// Parsing from string to int
            }
            
            //Convert ISBN int array to String!
            int[] array_isbn_final = new int[array_isbn.length];
            
            for (int i = 0 ; i < array_isbn_final.length; i++){
                array_isbn_final[i]= Integer.parseInt(array_isbn[i]);
            }  */

            //Acceder a SQL para coger los libros que tengan como ISBN los de "array_isbn"
            for (int i = 0 ; i < isbn_recibidos.length; i++){
                Book libro = db.searchBook(isbn_recibidos[i]);
                carro.add(libro);
            } 
                        
            //Envia una respuesta de redirección hacia el controlador de visualización del carro de la compra
            //request.setAttribute("carro_actual", carro);
            response.sendRedirect("carro_vista_control");
                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
