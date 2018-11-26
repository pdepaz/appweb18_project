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
 * Guarda en SQL los datos de un usuario
 *
 */
@WebServlet("/usuario_guardar")
public class Usuario_Guardar extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST+.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        

        try (DBManager db = new DBManager()){
            
            String[] isbn_recibidos = request.getParameterValues("catalogo_form");

            //Acceder a SQL para coger los libros que tengan como ISBN los de "array_isbn"
            for (int i = 0 ; i < isbn_recibidos.length; i++){
                Book libro = db.searchBook(isbn_recibidos[i]);
                carro.add(libro);
            } 
                        
            //Envia una respuesta de redirección hacia el controlador de visualización del carro de la compra
            //request.setAttribute("carro_actual", carro);
            response.sendRedirect("carro_vista_control");
            
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
            
            //session.setAttribute("mi_usuario", mi_usuario);
            //response.sendRedirect("miUsuario.jsp");
          
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
