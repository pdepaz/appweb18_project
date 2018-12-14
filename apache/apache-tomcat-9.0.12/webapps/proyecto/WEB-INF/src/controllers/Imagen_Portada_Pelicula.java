package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.lang.reflect.Array;
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

import java.nio.*;
import java.net.*;

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
        

        try (DBManager db = new DBManager()){

            pelicula_id = Integer.parseInt(request.getParameter("id_pelicula"));

            Pelicula mi_pelicula = db.cargarPelicula(pelicula_id);

            byte[] portada_img = mi_pelicula.getPortada();

            //ByteArrayInputStream stream_portada_img = new ByteArrayInputStream(portada_img);

            //BYTE to INT
            int int_portada_img[] = new int[portada_img.length / 4];
            int offset = 0;
            for (int i = 0; i < int_portada_img.length; i++) {
                int_portada_img[i] = (portada_img[3 + offset] & 0xFF) | ((portada_img[2 + offset] & 0xFF) << 8) | ((portada_img[1 + offset] & 0xFF) << 16) | ((portada_img[0 + offset] & 0xFF) << 24);  
                offset += 4;
            }

            //int result_type_image = db.GetImageFormat(int_portada_img); //DBManager line 1100
            //1: BMP.  2: GIF.  3: PNG.  4: TIFF.  5: JPEG.  0: unkwown.            
            int result_type_image = 3;

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

            request.getRequestDispatcher("pelicula").forward(request, response);

        } catch (NamingException|SQLException|NumberFormatException e){
            e.printStackTrace();
            //response.sendRedirect("error");
            response.sendError(500);
        }
    }
}
