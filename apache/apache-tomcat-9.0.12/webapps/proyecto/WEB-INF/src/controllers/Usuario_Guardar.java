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
 * Guardara los datos del nuevo usuario generado 
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
            user.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            String contrasenya1 = request.getParameter("contrasenya");
            String contrasenya2 = request.getParameter("contrasenya2");
            if(contrasenya1.equals(contrasenya2)){
                user.setContrasenya(request.getParameter("contrasenya"));
            }else{
                response.sendError(500);
                return;
            }
            
            user.setUsuario(request.getParameter("usuario"));
            user.setTipo_usuario("USUARIO");
            user.setBloqueado(0);
            
            int nuevo = db.crearUsuario(user); 
            
            if (nuevo == 1){
            Usuario aux = db.cargar_usuario_nombreusuario(user.getUsuario());          
                //USER NO TIENE ID
                //Almacenamos el id del usuario a través de uno auxiliar
                session.setAttribute("session_id", aux.getId());
            }

            response.sendRedirect("perfil");

        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
