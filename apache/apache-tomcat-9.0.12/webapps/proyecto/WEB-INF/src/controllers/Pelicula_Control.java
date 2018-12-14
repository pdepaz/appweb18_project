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
 * Muestra la vista de una pelicula de acuerdo con su ID
 *
 */
@WebServlet("/pelicula")
public class Pelicula_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int pelicula_id = 0;
 

        try (DBManager db = new DBManager()){

            if(request.getParameter("id") == null){
            //si no hay nada te da error
                throw new NamingException();

            } else {

            //Si lanza la exceipcion del tipo numberFormat(Error al pasar de string a integer) lo cojera el catch de abajo
            pelicula_id = Integer.parseInt(request.getParameter("id"));
          
            }

            if(!db.existePelicula(pelicula_id)){
                
                throw new SQLException(); //No existe la pelicula en la base de datos

            }
            

            //Accede a la base de datos y coge sus datos para mostrarlos luego en la JSP
            Pelicula mi_pelicula = db.cargarPelicula(pelicula_id);

            int session_id = -1;
            Usuario mi_usuario = new Usuario();

            if(session.getAttribute("session_id") != null){ //Hay sesion
                session_id = (int) session.getAttribute("session_id");
                mi_usuario = db.cargar_usuario(session_id);
            }

            Usuario usuariocreador = db.cargar_usuario(mi_pelicula.getCreador());

            //Ahora, cogemos los comentarios asociados a esta pelicula
            List<Comentario> comentarios = db.cargar_comentarios_list(pelicula_id,"Pelicula");

            List<Usuario> userscomentadores = new ArrayList<>();
            for(Comentario tmp: comentarios){
                userscomentadores.add(db.cargar_usuario(tmp.getUsuario()));
            }

            request.setAttribute("usuariocreador",usuariocreador);
            request.setAttribute("usersComentadores",userscomentadores);
            request.setAttribute("comentarios_pelicula", comentarios);
            request.setAttribute("pelicula", mi_pelicula);
            request.setAttribute("usuario", mi_usuario);

            request.getRequestDispatcher("pelicula.jsp").forward(request, response);

        } catch (NamingException|SQLException e){ //
           // e.printStackTrace();
            response.sendRedirect("error");
        } catch(NumberFormatException e){
            response.sendRedirect("error");

        }
    }
}
