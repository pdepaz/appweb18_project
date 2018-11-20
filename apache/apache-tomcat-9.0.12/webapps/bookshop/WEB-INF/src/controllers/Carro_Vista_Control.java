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
 * Controlador de visualización del carro de la compra.
 * No hace nada más que pasar el control mediante forward a la vista del carro de la compra (carro.jsp).
 * Si el usuario no tiene aún un carro de la compra, crea uno vacío.
 *
 */
@WebServlet("/carro_vista_control")
public class Carro_Vista_Control extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
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
                        
            //Envia una respuesta de redirección hacia el controlador de visualización del carro de la compra
            //request.setAttribute("carro_actual", carro);
            RequestDispatcher rd = request.getRequestDispatcher("carro.jsp");
            rd.forward(request, response);
                        
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
