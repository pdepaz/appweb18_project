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

import java.util.stream;


/**
 * Muestra la portada de una pelicula (cogiendola de la Base de Datos)
 *
 */
@WebServlet("/imagen")
public class Imagen_Portada_Pelicula extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int pelicula_id = 0;

        //Se lo pasamos en la "src" de la imagen y obteniendo el id de la pelicula en el JSP
        //imagen?id_pelicula=___
        pelicula_id = Integer.parseInt(request.getParameter("id_pelicula"));

        try (DBManager db = new DBManager()){

            Pelicula mi_pelicula = db.cargarPelicula(pelicula_id);

            byte[] portada_img = mi_pelicula.getPortada();

            ByteArrayInputStream stream_portada_img = new ByteArrayInputStream(portada_img);

            int result_type_image = db.GetImageFormat(stream_portada_img); //DBManager line 1100
            //1: BMP.  2: GIF.  3: PNG.  4: TIFF.  5: JPEG.  0: unkwown.

            switch (result_type_image) {
                case 0:  response.sendRedirect("cerrar_sesion");
                         break;
                case 1:  response.setContentType("image/bmp");
                         break;
                case 2:  response.setContentType("image/gif");
                         break;
                case 3:  response.setContentType("image/png");
                         break;
                case 4:  response.setContentType("image/tiff");
                         break;
                case 5:  response.setContentType("image/jpeg");
                         break;
                default: response.sendRedirect("cerrar_sesion");
                         break;
            }

            request.setAttribute("portada_img", portada_img);

            request.getRequestDispatcher("pelicula.jsp").forward(request, response);

        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}
