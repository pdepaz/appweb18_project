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
@WebServlet("/añadir_comentario")
public class Controlador_Tema extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        
        HttpSession session = request.getSession();
    
    
        try (DBManager db = new DBManager()){
            
            Usuario usuario = (Usuario) session.getAttribute("usuario");
        
            String comentario = request.getParametersValues("comentario"); //coger comentario del jsp
            
            Comentario comentario = new Comentario();
            comentario.setComentario_text(comentario);
            if(){
                comentario.setPelicula(1);
            }
            else{
                comentario.setPelicula(0);
            }
            if(){
                comentario.setSerie(1);
            }
            else{
                comentario.serSerie(0);
            }
            if(){
                comentario.setLibro(1);
            }
            else{
                comentario.setLibro(0);
            }
            comentario.setUsuario(usuario.getId());
            comentario.setFecha_creacion("22/11/21018");
            comentario.setComentario_padre(0);
            comentario.setTipo_usuario(usuario.getTipo_Usuario());
            comentario.setBloqueado(0);
            
            int conseguido = db.creaComentario(); //devuelve -1 si no se ha conseguido crear
            
            if(comentario.pelicula = 1){
                RequestDispatcher rd = request.getRequestDispatcher("pelicula.jsp");
                rd.forward(request, response);
            }
            if(comentario.serie = 1){
                RequestDispatcher rd = request.getRequestDispatcher("serie.jsp");
                rd.forward(request, response);
            }
            if(comentario.libro = 1){
                RequestDispatcher rd = request.getRequestDispatcher("libro.jsp");
                rd.forward(request, response);
            }
            
                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
