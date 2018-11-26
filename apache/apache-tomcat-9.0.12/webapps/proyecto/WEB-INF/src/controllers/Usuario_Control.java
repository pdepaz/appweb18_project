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
 * Muestra la vista de mi usuario de acuerdo con su "id"
 *
 */
@WebServlet("/usuario")
public class Usuario_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        //int mi_usuario_id = (int) session.getAttribute("id_usuario_logeado");
        int mi_usuario_id = 2;

        try (DBManager db = new DBManager()){

            //Accede a la base de datos y coge sus datos para mostrarlos luego en la JSP
            
            Usuario mi_usuario = db.cargar_usuario(mi_usuario_id);

            session.setAttribute("mi_usuario", mi_usuario);
            response.sendRedirect("miUsuario.jsp");
          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
