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
 * Gestiona el inicio de sesion (verificando que exista el usuario y si existe, verifica su contraseña)
 *
 */
@WebServlet("/iniciar_sesion")
public class Iniciar_Sesion_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

		if (session != null) {
		    // Not created yet. Now do so yourself.

			try (DBManager db = new DBManager()){

            	String username = request.getParameter("username");
            	String password = request.getParameter("password");
                //request.getParameter("g-recaptcha-response");


            	int id_usuario = db.iniciarSesion(username, password);

            	if (id_usuario == -1){
            		response.sendRedirect("error");
            	} else {
            		//Tenemos ya el ID del usuario
   	            	Usuario mi_usuario = db.cargar_usuario(id_usuario);
                    session.setAttribute("mi_usuario", mi_usuario);

                    //db.enviarConGMail(mi_usuario.getEmail());

   	            	session.setAttribute("session_id", id_usuario);

                    response.sendRedirect("home");
            	}

	        } catch (NamingException|SQLException e){
	            //e.printStackTrace();
	            response.sendRedirect("error");
	        }


		} else {
		    // Sesion already created.
            response.sendRedirect("error");
		}

    }
}
