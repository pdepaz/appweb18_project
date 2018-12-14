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
 *  Muestra el perfil de un usuario en el que hemos pinchado
 * Pasaremos el id del usuario con el ? y entonces cargaremos sus datos
 *
 */
@WebServlet("/usuario")
public class Usuario_Control extends HttpServlet {

//<a href="usuario?usuarioid=323">Pepito</a>
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

        int usuario_id = -1;
        int session_id = -1;

            try (DBManager db = new DBManager()){

                if(request.getParameter("usuarioid") == null){
                    //Intentan hacer algo raro con la url
                      throw new NamingException();
                } else {
                //El catch de abajo cogera la excepcion y lo mandara a error si pone una letra en el usuarioid
                    usuario_id = Integer.parseInt(request.getParameter("usuarioid"));

                    if(session.getAttribute("session_id")!= null){
                        session_id = (int) session.getAttribute("session_id");
                    }
                  
                }
                
                //No existe el usuario al que intenta acceder modificando la url
                if(!db.existeUsuarioId(usuario_id)){
                    throw new SQLException();
                }

                //Accede a la base de datos y coge sus datos para mostrarlos luego en la JSP
                Usuario usuario = db.cargar_usuario(usuario_id);

                //MANDAMOS EL USUARIO QUE QUEREMOS VER POR PARAMETRO ?
                request.setAttribute("usuario", usuario);

                if (usuario_id == session_id){
                    response.sendRedirect("perfil");
                } else {
                    request.getRequestDispatcher("usuario.jsp").forward(request, response);
                }


            } catch (NamingException|SQLException|NumberFormatException e){
               // e.printStackTrace();
                response.sendRedirect("error");
            }
    }
}
