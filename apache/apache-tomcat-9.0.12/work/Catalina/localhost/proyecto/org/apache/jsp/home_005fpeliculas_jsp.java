/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-12-03 18:22:42 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import proyecto.*;
import java.util.List;
import java.io.*;
import java.util.*;

public final class home_005fpeliculas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/header.jsp", Long.valueOf(1543861282000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("proyecto");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"error", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/css/main.css\" /> \n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <section id=\"main\" class=\"container\">\n");
      out.write("        <head>\n");
      out.write("            <title>Home</title>\n");
      out.write("        </head>\n");
      out.write("\n");
      out.write("        <body>\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
      out.write("\t\t\t\t<header id=\"header\" class=\"alt\"> ");
      out.write("\n");
      out.write("\t\t\t\t\t<h1><a href=\"home\">Manloo</h1>\n");
      out.write("\t\t\t\t\t<!-- BUSCADOR -->\n");
      out.write("\t\t\t\t\t<nav id=\"nav\">\n");
      out.write("\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"home_peliculas\">Peliculas</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"home\">Series</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"home\">Libros</a></li>\n");
      out.write("\t\t\t\t\t\t\t");
 if(session.getAttribute("session_id") != null){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"#\" class=\"icon fa-angle-down\">Nuevo tema</a>\n");
      out.write("\t\t\t\t\t\t\t\t<ul>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"crear_pelicula.html\">Pelicula</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"home\">Serie</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"home\">Libro</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t");
 if(session.getAttribute("session_id") == null){ 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<li><button class=\"button\" onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\">Iniciar Sesion</button></li>\n");
      out.write("\t\t\t\t\t\t\t");
 } else { 
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t<li><form action=\"cerrar_sesion\"><button class=\"button\">Cerrar Sesion</button></form></li>\n");
      out.write("\t\t\t\t\t\t\t");
 } 
      out.write("\t\t\t\t\t\t\t\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t<div id=\"id01\" class=\"modal\">\n");
      out.write("\t\t\t\t\t  <form class=\"modal-content animate\" method=\"post\" action=\"iniciar_sesion\"> <!--Mandar a nuestro servlet-->\n");
      out.write("\t\t\t\t\t    <!--Aspa de cerrar y avatar usuario-->\n");
      out.write("\t\t\t\t\t    <div class=\"imgcontainer\">\n");
      out.write("\t\t\t\t\t      <span onclick=\"document.getElementById('id01').style.display='none'\" class=\"close\" title=\"Cerrar\">&times;</span>\n");
      out.write("\t\t\t\t\t      <img src=\"images/img_avatar.png\" alt=\"Avatar\" class=\"avatar\">\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t    <!--Form propiamente dicho-->\t\t\t\t\t    \n");
      out.write("\t\t\t\t\t    <div class=\"container\">\n");
      out.write("\t\t\t\t\t      <label for=\"username\"><b>Usuario</b></label>\n");
      out.write("\t\t\t\t\t      <input type=\"text\" placeholder=\"Introduzca su usuario\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t      <label for=\"password\"><b>Contraseña</b></label>\n");
      out.write("\t\t\t\t\t      <input type=\"password\" placeholder=\"Introduzca su contraseña\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t      <div class=\"g-recaptcha\" data-sitekey=\"6LfsT34UAAAAADa3jHrtDwYSF7qPbOKuqjJr9QKR\"></div>\n");
      out.write("\t\t\t\t\t        \n");
      out.write("\t\t\t\t\t      <button type=\"submit\" class=\"submitbutton\">Iniciar Sesion</button>\n");
      out.write("                        </div> \n");
      out.write("                        \n");
      out.write("                        <div class=\"container\">\n");
      out.write("\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"remember\" name=\"remember\">\n");
      out.write("\t\t\t\t\t\t\t<label for=\"remember\">Recuérdame</label>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t    <!--Cancelar y olvidar contrasenya-->\n");
      out.write("\t\t\t\t\t    <div class=\"container\">\n");
      out.write("\t\t\t\t\t      <button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" class=\"cancelbutton\">Cancelar</button>\n");
      out.write("\t\t\t\t\t      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\n");
      out.write("\t\t\t\t\t      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;\n");
      out.write("\t\t\t\t\t      <button type=\"button\" class=\"olvidarcontrasenya\" onclick=\"location.href='#'\">Olvidé mi contraseña</button>\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t  </form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</header>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <table name=\"html_header\" border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td><h1>Temas de Debate</h1></td>\n");
      out.write("                <td>BUSCADOR</td>\n");
      out.write("                <td>Otras cosas por aqui...</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    \n");
      out.write("        <section id=\"main\" class=\"container\">\n");
      out.write("            <h2><b>Peliculas más nuevas</b></h2>\n");
      out.write("            ");
 List<Pelicula> pelis_nuevas = (List<Pelicula>) request.getAttribute("pelis_nuevas");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
for(Pelicula movie: pelis_nuevas){
      out.write("\n");
      out.write("                    <div class=\"col-6 col-12-narrower\">\n");
      out.write("                        <section class=\"box special\">\n");
      out.write("                            <span class=\"image featured\"><img src=\"");
      out.print(movie.getTitulo());
      out.write(".jpg\" alt=\"\" /></span>\n");
      out.write("                                <h3><b>");
      out.print( movie.getTitulo());
      out.write("</b></h3>\n");
      out.write("                                    <p>");
      out.print( movie.getDescripcion());
      out.write("</p>\n");
      out.write("                                <ul class=\"actions special\">\n");
      out.write("                                    <li><a href=\"#\" class=\"button alt\">+Info</a></li>\n");
      out.write("                                </ul>  \n");
      out.write("                        </section>\n");
      out.write("                    </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        <section id=\"main\" class=\"container\">\n");
      out.write("        <h2><b>Peliculas Recomendadas</b></h2>\n");
      out.write("        ");
 List<Pelicula> pelis_recomendadas = (List<Pelicula>) request.getAttribute("pelis_recomendadas");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
for(Pelicula movie: pelis_recomendadas){
      out.write("\n");
      out.write("                    <div class=\"col-6 col-12-narrower\">\n");
      out.write("                        <section class=\"box special\">\n");
      out.write("                            <span class=\"image featured\"><img src=\"");
      out.print(movie.getTitulo());
      out.write(".jpg\" alt=\"\" /></span>\n");
      out.write("                                <h3><b>");
      out.print( movie.getTitulo());
      out.write("</b></h3>\n");
      out.write("                                    <p>");
      out.print( movie.getDescripcion());
      out.write("</p>\n");
      out.write("                                <ul class=\"actions special\">\n");
      out.write("                                    <li><a href=\"#\" class=\"button alt\">+Info</a></li>\n");
      out.write("                                </ul>  \n");
      out.write("                        </section>\n");
      out.write("                    </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        <section id=\"main\" class=\"container\">\n");
      out.write("        <h2><b>Peliculas más comentadas</b></h2>\n");
      out.write("        ");
 List<Pelicula> pelis_mas_comentadas = (List<Pelicula>) request.getAttribute("pelis_mas_comentadas");
      out.write("\n");
      out.write("        </section>\n");
      out.write("        \n");
      out.write("            <div class=\"row\">\n");
      out.write("                ");
for(Pelicula movie: pelis_mas_comentadas){
      out.write("\n");
      out.write("                    <div class=\"col-6 col-12-narrower\">\n");
      out.write("                        <section class=\"box special\">\n");
      out.write("                            <span class=\"image featured\"><img src=\"");
      out.print(movie.getTitulo());
      out.write(".jpg\" alt=\"\" /></span>\n");
      out.write("                                <h3><b>");
      out.print( movie.getTitulo());
      out.write("</b></h3>\n");
      out.write("                                    <p>");
      out.print( movie.getDescripcion());
      out.write("</p>\n");
      out.write("                                <ul class=\"actions special\">\n");
      out.write("                                    <li><a href=\"#\" class=\"button alt\">+Info</a></li>\n");
      out.write("                                </ul>  \n");
      out.write("                        </section>\n");
      out.write("                    </div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </body>\n");
      out.write("    </section>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
