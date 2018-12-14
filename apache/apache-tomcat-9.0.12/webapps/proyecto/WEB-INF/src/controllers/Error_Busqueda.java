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
 * Gestiona los errores
 *
 */
@WebServlet("/error_busqueda")
public class Error_Busqueda extends HttpServlet {

    /**
     * Metodo del servlet que responde a una peticion GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        HttpSession session = request.getSession();

        try (DBManager db = new DBManager()){

            request.getRequestDispatcher("error_busqueda.jsp").forward(request, response);   

        } catch (NamingException|SQLException e){
            //e.printStackTrace();
            //response.sendError(500);
            response.sendRedirect("error");

        }

    }
}
