/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
<<<<<<< HEAD
 * Generated at: 2018-12-03 17:43:50 UTC
=======
 * Generated at: 2018-12-03 16:30:30 UTC
>>>>>>> c43c81c7e6bb161a386db80a967f5e196a2f56e6
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

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
<<<<<<< HEAD
    _jspx_dependants.put("/header.jsp", Long.valueOf(1543857118000L));
=======
    _jspx_dependants.put("/header.jsp", Long.valueOf(1543854519000L));
>>>>>>> c43c81c7e6bb161a386db80a967f5e196a2f56e6
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
      out.write("\n");
      out.write("<!DOCTYPE HTML>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<section id=\"main\" class=\"container\">\n");
      out.write("\t<head>\n");
      out.write("\t\t<title>Manloo</title>\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n");
      out.write("\t\t<script src='https://www.google.com/recaptcha/api.js?render=6LfsT34UAAAAADa3jHrtDwYSF7qPbOKuqjJr9QKR'></script>\n");
      out.write("\n");
      out.write("\t</head>\n");
      out.write("\n");
      out.write("\t<body class=\"landing is-preload\">\n");
      out.write("\t\t<div id=\"page-wrapper\">\n");
      out.write("\n");
      out.write("\t\t\t");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
<<<<<<< HEAD
      out.write("\t\t\t\t<header id=\"header\" class=\"reveal\">\n");
=======
      out.write("\t\t\t\t<header id=\"header\" class=\"alt\"> ");
      out.write("\n");
>>>>>>> c43c81c7e6bb161a386db80a967f5e196a2f56e6
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
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"nueva_pelicula\">Pelicula</a></li>\n");
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
      out.write("\t\t\t\t\t      <label for=\"uname\"><b>Usuario</b></label>\n");
      out.write("\t\t\t\t\t      <input type=\"text\" placeholder=\"Introduzca su usuario\" name=\"username\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t      <label for=\"psw\"><b>Contraseña</b></label>\n");
      out.write("\t\t\t\t\t      <input type=\"password\" placeholder=\"Introduzca su contraseña\" name=\"password\" required>\n");
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
      out.write("\t\t\t<!-- Banner -->\n");
      out.write("\t\t\t\t<section id=\"banner\">\n");
      out.write("\t\t\t\t\t<h2>Manloo</h2>\n");
      out.write("\t\t\t\t\t<p>Descubra las nuevas maneras de comentar películas, series y libros</p>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t");
 if(session.getAttribute("session_id") == null){ 
      out.write("\n");
      out.write("\t\t\t\t\t<ul class=\"actions special\">\n");
      out.write("\t\t\t\t\t\t<li><a class=\"button primary\" onclick=\"document.getElementById('id01').style.display='block'\" style=\"width:auto;\">Iniciar Sesion</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t</section>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t<!-- Main -->\n");
      out.write("\t\t\t\t<section id=\"main\" class=\"container\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<section class=\"box special\">\n");
      out.write("\t\t\t\t\t\t<header class=\"major\">\n");
      out.write("\t\t\t\t\t\t\t<h2>AAA \n");
      out.write("\t\t\t\t\t\t\t<br />\n");
      out.write("\t\t\t\t\t\t\tAAA</h2>\n");
      out.write("\t\t\t\t\t\t\t<p>Párrafo</p>\n");
      out.write("\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t\t<span class=\"image featured\"><img src=\"images/pic01.jpg\" alt=\"\" /></span>\n");
      out.write("\t\t\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<div class=\"row\">\n");
      out.write("\t\t\t\t\t\t<div class=\"col-6 col-12-narrower\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<section class=\"box special\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"image featured\"><img src=\"images/pic02.jpg\" alt=\"\" /></span>\n");
      out.write("\t\t\t\t\t\t\t\t<h3>Sed lorem adipiscing</h3>\n");
      out.write("\t\t\t\t\t\t\t\t<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"actions special\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"button alt\">Learn More</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<div class=\"col-6 col-12-narrower\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t<section class=\"box special\">\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"image featured\"><img src=\"images/pic03.jpg\" alt=\"\" /></span>\n");
      out.write("\t\t\t\t\t\t\t\t<h3>Accumsan integer</h3>\n");
      out.write("\t\t\t\t\t\t\t\t<p>Integer volutpat ante et accumsan commophasellus sed aliquam feugiat lorem aliquet ut enim rutrum phasellus iaculis accumsan dolore magna aliquam veroeros.</p>\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"actions special\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"#\" class=\"button alt\">Learn More</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t\t<!-- Crear Cuenta -->\n");
      out.write("\t\t\t\t<section id=\"cta\">\n");
      out.write("\n");
      out.write("\t\t\t\t\t<h2>Crear cuenta</h2>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<form>\n");
      out.write("\t\t\t\t\t\t<div class=\"row gtr-50 gtr-uniform\">\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-8 col-12-mobilep\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"email\" name=\"email\" id=\"email\" placeholder=\"Email\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t<div class=\"col-4 col-12-mobilep\">\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" value=\"Crear Cuenta\" class=\"fit\" />\n");
      out.write("\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t</form>\n");
      out.write("\n");
      out.write("\t\t\t\t</section>\n");
      out.write("\n");
      out.write("\t\t\t<!-- Footer -->\n");
      out.write("\t\t\t\t<footer id=\"footer\">\n");
      out.write("\t\t\t\t\t<ul class=\"icons\">\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://twitter.com/uc3m\" target=\"_blank\" class=\"icon fa-twitter\"><span class=\"label\">Twitter</span></a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://www.facebook.com/uc3m/\" class=\"icon fa-facebook\"><span class=\"label\">Facebook</span></a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://www.youtube.com/user/UC3M\" class=\"icon fa-instagram\"><span class=\"label\">Instagram</span></a></li>\n");
      out.write("\t\t\t\t\t\t<li><a href=\"https://github.com/pdepaz/appweb18_project\" target=\"_blank\" class=\"icon fa-github\"><span class=\"label\">Github</span></a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t<ul class=\"copyright\">\n");
      out.write("\t\t\t\t\t\t<li>&copy; Alfonso Albacete, Gonzalo Puy y Pablo de Paz.</li><li>2018</a></li>\n");
      out.write("\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t</footer>\n");
      out.write("\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<!-- Scripts -->\n");
      out.write("\t\t\t<script src=\"assets/js/jquery.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/jquery.dropotron.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/jquery.scrollex.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/browser.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/breakpoints.min.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/util.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/main.js\"></script>\n");
      out.write("\t\t\t<script src=\"assets/js/login.js\"></script>\n");
      out.write("\n");
      out.write("\t</body>\n");
      out.write("\n");
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
