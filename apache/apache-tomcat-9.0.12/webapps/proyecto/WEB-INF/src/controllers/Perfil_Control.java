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
 * Este servlet cargará el perfil de usuario conectado
 *
 */
@WebServlet("/perfil")
public class Perfil_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int mi_usuario_id = 0;

        try (DBManager db = new DBManager()){

            if(session.getAttribute("session_id") == null){
                //SI NO HAY SESION INCIADA, TE REDIRIGE A LA HOME DE PELICULAS
                response.sendRedirect("home");
            }else {
                mi_usuario_id = (int) session.getAttribute("session_id");

                Usuario mi_usuario = db.cargar_usuario(mi_usuario_id);

                session.setAttribute("mi_usuario", mi_usuario);

            }

            response.sendRedirect("perfil.jsp");

        } catch (NamingException|SQLException|NumberFormatException e){
            //e.printStackTrace();
            response.sendRedirect("error");
        }
    }

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int mi_usuario_id = 0;

        try (DBManager db = new DBManager()){

            if(session.getAttribute("session_id") == null){
                //SI NO HAY SESION INCIADA, TE REDIRIGE A LA HOME DE PELICULAS
                response.sendRedirect("home");
            }else {
                mi_usuario_id = (int) session.getAttribute("session_id");

                Usuario mi_usuario = db.cargar_usuario(mi_usuario_id);

                session.setAttribute("mi_usuario", mi_usuario);

            }

            //request.getRequestDispatcher("perfil.jsp").forward(request, response);
            response.sendRedirect("perfil.jsp");

        } catch (NamingException|SQLException|NumberFormatException e){
            //e.printStackTrace();
            response.sendRedirect("error");
        }
    }
}
