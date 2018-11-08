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
 * Controlador de vaciado del carro de la compra.
 * Reemplaza el carro de la compra del usuario por uno nuevo vacío. 
 * Envía una respuesta de redirección hacia el controlador del catálogo.
 *
 */
@WebServlet("/carro_vaciado_control")
public class Carro_Vaciado_Control extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
        
        //Crear nuevo Carro de la compra (vacio)
            List<Book> carro = new ArrayList<Book>();
            session.setAttribute("carro", carro);

        
        try (DBManager db = new DBManager()){
            
            response.sendRedirect("catalogo");
                        
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
