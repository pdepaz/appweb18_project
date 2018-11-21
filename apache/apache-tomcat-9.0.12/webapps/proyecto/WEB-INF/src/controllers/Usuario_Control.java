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
 * Usuario control se dedicará a guardar los datos del nuevo usuario una vez se edite el perfil
 *
 *
 */
@WebServlet("/usuario")
public class Usuario_Control extends HttpServlet {

    /**
     * Método del servlet que responde a una petición POST.
     *
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        HttpSession session = request.getSession();

                //hacerlo para todos y entonces hacer update a Base de Datos
                Usuario user = new Usuario();
                user.setNombre(request.getParameter("nombre"));

                //Acordarnos de asociar el usuario a la session una vez se haga iniciar session en "miusuario"

               //    Usuario user = (Usuario)session.getAtribute("user",user);


        try (DBManager db = new DBManager()){
            
    
                /*
                De momento no se usa.
                request.setAtribute("user",user);    
                RequestDispatcher rd = getRequestDispatcher("Usuario.jsp");
                rd.forward(request,response);*/

                                    
        } catch (NamingException|SQLException e){
            e.printStackTrace();
            response.sendError(500);
        }
    }
}