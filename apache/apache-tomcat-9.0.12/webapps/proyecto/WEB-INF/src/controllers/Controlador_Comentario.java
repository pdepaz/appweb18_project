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
 * Controlador de ejemplo
 *
 */
@WebServlet("/anyadir_comentario")
public class Controlador_Comentario extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
    
    
        try (DBManager db = new DBManager()){
        
            Comentario comentario = new Comentario(); //coger comentario del jsp

            
            Usuario usuario = (Usuario) session.getAttribute("usuario");
            
            String tema = (String) request.getParameter("tema");
            int id = Integer.parseInt(request.getParameter("id"));
            String comentario_string = request.getParameter("comentario"); //coger comentario del jsp
            
            Comentario comment = new Comentario();
            comment.setComentario_text(comentario_string);
            
            if(tema.equals("pelicula")){
                comment.setTipo_tema("Pelicula");
                comment.setPelicula(id);
            }
            if(tema.equals("serie")){
                comment.setTipo_tema("Serie");
                comment.setSerie(id);
            }
            if(tema.equals("libro")){
                comment.setTipo_tema("Libro");
                comment.setLibro(id);
            }
            
            comment.setUsuario(usuario.getId());
            comment.setFecha_creacion("22/11/21018");
            comment.setComentario_padre(0);
            comment.setTipo_usuario(usuario.getTipo_usuario());
            if(usuario.getBloqueado() == 0){
                comment.setBloqueado(0);
            }
            else{
                comment.setBloqueado(1);
            }
            
            int conseguido = db.creaComentario(comentario_string, comment.getTipo_tema(), id, comment.getUsuario(), comment.getComentario_padre(), 0); //devuelve -1 si no se ha conseguido crear
            
            if(comentario.getTipo_tema().equals("Pelicula")){
                RequestDispatcher rd = request.getRequestDispatcher("pelicula.jsp");
                rd.forward(request, response);
            }
            if(comentario.getTipo_tema().equals("Serie")){
                RequestDispatcher rd = request.getRequestDispatcher("serie.jsp");
                rd.forward(request, response);
            }
            if(comentario.getTipo_tema().equals("Libro")){
                RequestDispatcher rd = request.getRequestDispatcher("libro.jsp");
                rd.forward(request, response);
            }
            
                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
