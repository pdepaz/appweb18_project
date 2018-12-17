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
import javax.servlet.annotation.MultipartConfig;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

/**
 * Actualiza en SQL los datos de un usuario
 *
 */
@WebServlet("/perfil_actualizar")
@MultipartConfig(maxFileSize = 16777215) //16MB maximum MEDIUMBLOB size
public class Perfil_Actualizar extends HttpServlet {

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

            Usuario user = new Usuario();

            //SE DEBERIAN AUTORELLENAR ALGUNOS DATOS EN EL FORMULARIO
            user.setId((int) session.getAttribute("session_id"));
            user.setNombre(request.getParameter("nombre"));
            user.setApellido1(request.getParameter("apellido1"));

            //Not compulsory
            if (!request.getParameter("apellido2").equals("")){
                user.setApellido2(request.getParameter("apellido2"));
            } else {
                user.setApellido2(" ");
            }

            user.setEmail(request.getParameter("email"));


            //FOTO (compulsory)
            InputStream inputStream = null; //Input stream of the upload file

                //Now, obtain the upload file part in this multipart request
                Part filePart = request.getPart("foto");

                if (filePart != null) {
                    //Obtains input stream of the upload file
                    //the InputStream will point to a stream that contains the contents of the file
                    inputStream = filePart.getInputStream();
                }

                if (inputStream != null) {
                    //Files are treated as BLOB objects in database
                    byte[] foto_imagen = IOUtils.toByteArray(inputStream);
                    user.setFoto(foto_imagen);
                }


            //Not compulsory
            if (!request.getParameter("telefono").equals("")){
                user.setTelefono(Integer.parseInt(request.getParameter("telefono")));
            } else {
                user.setTelefono(0);
            }

            String old_password = request.getParameter("old_contrasenya");

            int session_id = (int) session.getAttribute("session_id");

            //Al iniciar sesión se está atribuyendo el id de usuario a la sesion????
            boolean result_check = db.check_cambio_password(session_id, old_password);

            if(result_check){ //old_contrasenya es igual a la de la Base de Datos
                user.setContrasenya(request.getParameter("new_contrasenya"));
                int actualizado = db.actualizaUsuario(user);

                //Esto va a ser innecesario porque el id ya estaba en la sesion, estamos actualizando
                if (actualizado == 1){
                    session.setAttribute("session_id", user.getId());
                    //Probar a ver si almacenando el usuario en la sesion
                    session.setAttribute("mi_usuario", user);
                }

                response.sendRedirect("perfil");
            } else {
                response.sendRedirect("error");
            }

        } catch (NamingException|SQLException|NumberFormatException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.sendRedirect("error");
        }
    }
}
