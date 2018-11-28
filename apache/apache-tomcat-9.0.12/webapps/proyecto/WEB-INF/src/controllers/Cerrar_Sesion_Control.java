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
 * Gestiona el cierre de sesion
 *
 */
@WebServlet("/cerrar_sesion")
public class Cerrar_Sesion_Control extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
        HttpSession session = request.getSession(false);

        if(session != null){
            session.invalidate();
        }

	   response.sendRedirect("home");
        
    }
}
