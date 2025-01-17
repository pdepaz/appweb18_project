package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
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
 * Guarda en SQL un nuevo comentario asocidado a una pelicula
 *
 */
@WebServlet("/comentario_peli_guardar")
public class Comentario_Peli_Guardar extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");

        try (DBManager db = new DBManager()){

            if(session.getAttribute("session_id") == null){

                throw new SQLException();

            }

            int session_id = (int) session.getAttribute("session_id");

            Usuario usuario = db.cargar_usuario(session_id);

            Comentario nuevo_comentario = new Comentario();
            nuevo_comentario.setComentario_text(request.getParameter("comentario_text"));
            nuevo_comentario.setTipo_tema("Pelicula");
            nuevo_comentario.setPelicula(Integer.parseInt(request.getParameter("id_peli")));
            //Ver si en la funcion para añadir comentarios en DBManager trata correctamente que sea una pelicula
            nuevo_comentario.setUsuario(session_id);
            //Meter direcamente la date o hacer un get current time
            java.sql.Date dt;
            java.util.Date today = new java.util.Date();
            dt = new java.sql.Date(today.getTime());
            //java.text.SimpleDateFormat fecha = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //String currentTime = fecha.format(dt);
            nuevo_comentario.setFecha_creacion(dt);
            nuevo_comentario.setComentario_padre(Integer.parseInt(request.getParameter("comentario_id")));
            nuevo_comentario.setTipo_usuario(usuario.getTipo_usuario());
            nuevo_comentario.setBloqueado(0);

            db.creaComentarioPeli(nuevo_comentario);

            String atributo = "pelicula?id=" + nuevo_comentario.getPelicula();
            response.sendRedirect(atributo);

        } catch (NamingException|SQLException|NumberFormatException e){
            //e.printStackTrace();
            response.sendRedirect("error");
        }
    }
}
