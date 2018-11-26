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
 * Usuario control se dedicara a guardar los datos del nuevo usuario una vez se edite el perfil
 *
 */
@WebServlet("/usuario")
public class Usuario_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

                //hacerlo para todos y entonces hacer update a Base de Datos
                Usuario user = new Usuario();
                user.setNombre(request.getParameter("nombre"));
                user.setApellido1(request.getParameter("apellido1"));
                user.setApellido2(request.getParameter("apellido2"));
                user.setEmail(request.getParameter("email"));
                user.setTelefono(Integer.parseInt(request.getParameter("telefono")));
                user.setContrasenya(request.getParameter("contrasenya"));


        try (DBManager db = new DBManager()){

            //actualiza los datos del usuario manteniendo el id
                int actualizado = db.actualizaUsuario(user); 
                if (actualizado == 1){
                    session.setAttribute("miusuario", user);


                response.sendRedirect("MiUsuario.jsp");
                }  
                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}