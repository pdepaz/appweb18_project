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
 * Guardara los datos del nuevo usuario generado
 *
 */
@WebServlet("/usuario_guardar")
@MultipartConfig(maxFileSize = 16777215) //16MB maximum MEDIUMBLOB size
public class Usuario_Guardar extends HttpServlet {

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

            String contrasenya1 = request.getParameter("contrasenya");
            String contrasenya2 = request.getParameter("contrasenya2");

            if (contrasenya1.equals(contrasenya2)){
                user.setContrasenya(request.getParameter("contrasenya"));
            } else{
                throw new SQLException();
            }

            user.setUsuario(request.getParameter("usuario"));
            user.setTipo_usuario("USUARIO");
            user.setBloqueado(0);

            int nuevo = db.crearUsuario(user);

            if (nuevo == 1){
                Usuario aux = db.cargar_usuario_nombreusuario(user.getUsuario());
                //Almacenamos el id del usuario a través de uno auxiliar
                session.setAttribute("session_id", aux.getId());
            } else{
              throw new NamingException();
            }

            db.enviarConGMail(user.getEmail());

            request.getRequestDispatcher("perfil").forward(request, response);

        } catch (NamingException|SQLException|NumberFormatException e){
            //e.printStackTrace();
            response.sendRedirect("error_crear_cuenta");
        }
    }
}
