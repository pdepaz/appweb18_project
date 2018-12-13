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
 * Controlador que bloquea la pelicula elegida por el moderador
 *
 */
@WebServlet("/bloquear_usuario")
public class Bloquear_usuario extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {

        HttpSession session = request.getSession();
        int usuarioid = Integer.parseInt(request.getParameter("usuario_id"));

        boolean bloqueada = false;
        try (DBManager db = new DBManager()){

            bloqueada = db.bloquear_usuario(usuarioid);

              if(bloqueada){
                response.sendRedirect("home");
              }
            //Else error

        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
