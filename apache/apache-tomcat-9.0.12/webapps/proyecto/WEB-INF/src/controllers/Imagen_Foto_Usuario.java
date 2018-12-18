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

            if(foto_img.length == 0){
                response.setContentType("image/png");
                response.setHeader("Content-Type", "image/png");
                response.sendRedirect("images/default_user.png");
                return;
            }

            String image_type = db.getMimeType(foto_img);

            if(!image_type.equals("image/png") && !image_type.equals("image/jpeg")){
                response.setContentType("image/png");
                response.setHeader("Content-Type", "image/png");
                response.sendRedirect("images/default_user.png");
                return;
            }

            response.setContentType(image_type);
            response.setHeader("Content-Length", String.valueOf(foto_img.length));

            //Write Image Data to Response.
            response.getOutputStream().write(foto_img);

        } catch (SQLException|NumberFormatException|NullPointerException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.sendRedirect("error");
        } catch (NamingException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.setContentType("image/png");
            response.setHeader("Content-Type", "image/png");
            response.sendRedirect("images/default_user.png");
        }
    }
}
