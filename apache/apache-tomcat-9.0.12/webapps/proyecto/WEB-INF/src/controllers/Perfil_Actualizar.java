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
@WebServlet("/perfil_actualizar")
public class Perfil_Actualizar extends HttpServlet {

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
            //DE AQUI HASTA TELEFONO (INCLUIDO), SE AUTORELLENA (asumimos que se mete algo)
            //Podemos hacer una prueba de que cuando se acceda a este servlet cree un usuario
            //Para ver si esque no le estan llegando bien los parametros
            user.setNombre(request.getParameter("nombre"));
            user.setApellido1(request.getParameter("apellido1"));
            user.setApellido2(request.getParameter("apellido2"));
            user.setEmail(request.getParameter("email"));
            user.setTelefono(Integer.parseInt((request.getParameter("telefono"))));
            String old_password = request.getParameter("old_contrasenya");
            
            int id_de_sesion = (int) session.getAttribute("session_id");
            //Al iniciar sesión se está atribuyendo el id de usuario a la sesion????
            boolean result_check = db.check_cambio_password(id_de_sesion, old_password);
            
            if(result_check){ //old_contrasenya es igual a la de la Base de Datos
                user.setContrasenya(request.getParameter("new_contrasenya"));
                int actualizado = db.actualizaUsuario(user);
                //Esto va a ser innecesario porque el id ya estaba en la sesion, estamos actualizando
                if (actualizado == 1){
                    session.setAttribute("session_id", user.getId());
                }
                
                response.sendRedirect("perfil");
            } else {
                response.sendRedirect("error");
            }

        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
