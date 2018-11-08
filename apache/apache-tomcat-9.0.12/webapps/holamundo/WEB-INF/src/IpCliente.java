import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

/**
 * Servlet que muestra:
 * - dirección IP del cliente que envía la petición
 * - contenido de la cabecera User-Agent del mensaje HTTP de petición recibido
 * - fecha y hora del servidor (la obtenida, por ejemplo, al crear un nuevo objeto Date en el servlet).
 */

@WebServlet("/ipcliente")
public class IpCliente extends HttpServlet {

    /**
     * Método del servlet que responde a una petición GET.
     *
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        String ip = null; // IP del cliente
        String host = null; // Host del cliente
 
        ip = request.getRemoteAddr();
        host = request.getRemoteHost();
        
        // establece ContentType y sistema de codificación de caracteres
        response.setContentType("text/html; charset=UTF-8");
        
        // obtiene un PrintWriter para escribir la respuesta
        PrintWriter out = response.getWriter();
        
        // escribe un documento HTML
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Obtener IP del cliente</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>La <strong>IP del cliente</strong> es " +ip+ "</p>");
        out.println("<p>El <strong>host</strong> del cliente es " +host+ "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
