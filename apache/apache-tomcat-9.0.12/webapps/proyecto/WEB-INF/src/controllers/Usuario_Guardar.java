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
 * Actualiza en SQL los datos de un usuario
 *
 */
@WebServlet("/usuario_guardar")
public class Usuario_Guardar extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        try (DBManager db = new DBManager()){
            
            Usuario user = new Usuario();
            user.setNombre(request.getParameter("nombre"));
            user.setApellido1(request.getParameter("apellido1"));
            user.setApellido2(request.getParameter("apellido2"));
            user.setEmail(request.getParameter("email"));
            user.setTelefono(request.getParameter("telefono"));
            user.setContrasenya(request.getParameter("contrasenya"));
            
            int actualizado = db.actualizaUsuario(user); 
            
            if (actualizado == 1){
                session.setAttribute("mi_usuario", user);
            }

            //LA SIGUIENTE LINEA ESTA BIEN PERO NO SE A QUE .jsp MANDARLO (TODAVIA)
            //response.sendRedirect("miUsuario.jsp");
          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
