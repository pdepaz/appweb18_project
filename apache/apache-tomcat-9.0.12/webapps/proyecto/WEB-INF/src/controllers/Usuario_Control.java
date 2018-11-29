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
 *  Muestra el perfil de un usuario en el que hemos pinchado
 *Pasaremos el id del usuario con el ? y entonces cargaremos sus datos
 *
 */
@WebServlet("/usuario")
public class Usuario_Control extends HttpServlet {

//<a href="usuario?usuarioid=323">Pepito</a>
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        int usuario_id = request.getParameter("usuarioid");
        try (DBManager db = new DBManager()){

            //Accede a la base de datos y coge sus datos para mostrarlos luego en la JSP
            //ID PASADO POR URL
            Usuario usuario = db.cargar_usuario(usuario_id);

            //MANDAMOS EL USUARIO QUE QUEREMOS VER POR PARAMETRO ?
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("usuario.jsp").forward(request, response);            
          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
