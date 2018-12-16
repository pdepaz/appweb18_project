package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Blob;
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

import org.apache.commons.io.IOUtils;

/**
 * Guarda en SQL los datos de un usuario
 *
 */
@WebServlet("/pelicula_guardar")
@MultipartConfig(maxFileSize = 16777215) //16MB maximum MEDIUMBLOB size
public class Pelicula_Guardar extends HttpServlet {

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

            Pelicula pelicula = new Pelicula();
            pelicula.setTitulo(request.getParameter("titulo"));
            pelicula.setAnyo(Integer.parseInt((request.getParameter("anyo"))));
            pelicula.setDuracion(Integer.parseInt((request.getParameter("duracion"))));
            pelicula.setDescripcion(request.getParameter("descripcion"));
            pelicula.setDirector(request.getParameter("director"));
            pelicula.setGenero(request.getParameter("genero"));
            

            //PORTADA
            InputStream inputStream = null; //Input stream of the upload file
            
            //Now, obtain the upload file part in this multipart request
            Part filePart = request.getPart("portada");
            
            if (filePart != null) {
                //Obtains input stream of the upload file
                //the InputStream will point to a stream that contains the contents of the file
                inputStream = filePart.getInputStream();
            }    
            
            if (inputStream != null) {
                //Files are treated as BLOB objects in database
                byte[] portada_imagen = IOUtils.toByteArray(inputStream);
                pelicula.setPortada(portada_imagen);
            }
            
            pelicula.setTrailer(request.getParameter("trailer"));

            //El creador es el id del usuario de la sesion
            pelicula.setCreador((int) session.getAttribute("session_id"));
            pelicula.setBloqueado(0); //No bloqueado la pelicula al principio

            if(!db.checkPelicula(pelicula)){
                throw new NamingException();
            }

            db.creaPelicula(pelicula);
            List<Comentario> comentarios = new ArrayList<Comentario>(); //No hay comentarios al principio

            Pelicula movie = db.cargar_pelicula_nombrepeli(pelicula.getTitulo());

            String url = "pelicula?id=" + movie.getId();
            response.sendRedirect(url);

        } catch (NamingException|SQLException e){
           // e.printStackTrace();
            response.sendRedirect("error");
        }
    }
}
