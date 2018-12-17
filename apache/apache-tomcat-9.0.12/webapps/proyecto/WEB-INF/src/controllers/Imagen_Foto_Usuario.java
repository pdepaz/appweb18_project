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
 * Muestra la foto de un usuario (cogiendola de la Base de Datos)
 * Se lo pasamos en la "src" de la imagen y obteniendo el id del usuario en el JSP
 * foto?id_usuario=___
 *
 */
@WebServlet("/foto")
public class Imagen_Foto_Usuario extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        int usuario_id = 0;

        try (DBManager db = new DBManager()){

            //Comprobaciones
            if(request.getParameter("id_usuario") == null){
                throw new SQLException();
            } else {
                //Puede lanzar excepcion NumberFormat (error de string a integer)
                usuario_id = Integer.parseInt(request.getParameter("id_usuario"));
            }

            if(!db.existeUsuarioId(usuario_id)){
                throw new SQLException(); //No existe el usuario en la base de datos
            }

            Usuario mi_usuario = db.cargar_usuario(usuario_id);

            byte[] foto_img = mi_usuario.getFoto();

            if(foto_img == null){
                throw new NamingException();
            }

            //BYTE to INT
            /*int int_foto_img[] = new int[foto_img.length / 4];
            int offset = 0;
            for (int i = 0; i < int_foto_img.length; i++) {
                int_foto_img[i] = (foto_img[3 + offset] & 0xFF) | ((foto_img[2 + offset] & 0xFF) << 8) | ((foto_img[1 + offset] & 0xFF) << 16) | ((foto_img[0 + offset] & 0xFF) << 24);
                offset += 4;
            }*/

            String image_type = db.getMimeType(foto_img);
            response.setContentType(image_type);
            //int result_type_image = db.GetImageFormat(int_foto_img);
            //1: BMP.  2: GIF.  3: PNG.  4: TIFF.  5: JPEG.  0: unkwown.
            //int result_type_image = 5;

            /*switch (result_type_image) {
                case 0: response.sendRedirect("cerrar_sesion");
                        break;
                case 1: response.setContentType("image/bmp");
                        response.setHeader("Content-Type", "image/bmp");
                        break;
                case 2: response.setContentType("image/gif");
                        response.setHeader("Content-Type", "image/gif");
                        break;
                case 3: response.setContentType("image/png");
                        response.setHeader("Content-Type", "image/png");
                        break;
                case 4: response.setContentType("image/tiff");
                        response.setHeader("Content-Type", "image/tiff");
                        break;
                case 5: response.setContentType("image/jpeg");
                        response.setHeader("Content-Type", "image/jpeg");
                        break;
                default:response.sendRedirect("cerrar_sesion");
                        break;
            }*/

            response.setHeader("Content-Length", String.valueOf(foto_img.length));

            //Write Image Data to Response.
            response.getOutputStream().write(foto_img);

        } catch (SQLException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.sendRedirect("error");
        } catch (NamingException|NumberFormatException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.setContentType("image/png");
            response.setHeader("Content-Type", "image/png");
            response.sendRedirect("images/default_user.png");
        }
    }
}
