/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-12-17 15:47:14 UTC
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

public final class pelicula_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/footer.jsp", Long.valueOf(1545049397000L));
    _jspx_dependants.put("/header.jsp", Long.valueOf(1545049397000L));
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
      			null, true, 8192, true);
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
      out.write("<link rel=\"stylesheet\" href=\"assets/css/main.css\" />\n");
      out.write("\n");
      out.write("\n");

Usuario mi_usuario = new Usuario();
if(session.getAttribute("session_id") != null){
    mi_usuario = (Usuario) session.getAttribute("mi_usuario");
} else {
    mi_usuario.setTipo_usuario("USUARIO");
}

      out.write('\n');
      out.write('\n');
Pelicula pelicula = (Pelicula) request.getAttribute("pelicula");
      out.write('\n');
List<Comentario> comentarios = (List<Comentario>) request.getAttribute("comentarios_pelicula");
      out.write('\n');
      out.write('\n');
List<Usuario> userscomentadores = (List<Usuario>) request.getAttribute("usersComentadores"); 
      out.write('\n');
 Usuario usuariocreador = (Usuario) request.getAttribute("usuariocreador"); 
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<section id=\"main\" class=\"container\">\n");
      out.write("\n");
      out.write("    <header>\n");
      out.write("        <h1>Pelicula</h1>\n");
      out.write("        <h2><b>");
      out.print( pelicula.getTitulo() );
      out.write("</b></h2>\n");
      out.write("\n");
      out.write("        ");
if(mi_usuario.getTipo_usuario().equals("MODERADOR")){
      out.write("\n");
      out.write("\n");
      out.write("            ");
if(pelicula.getBloqueado()==0){
      out.write("\n");
      out.write("\n");
      out.write("              <form id = \"bloquear_pelicula\" action = \"bloquear_pelicula\" method = \"post\">\n");
      out.write("                <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                  <div class = \"boton\">\n");
      out.write("                    <input type = \"submit\" value = \"Bloquear Pelicula\">\n");
      out.write("                  </div>\n");
      out.write("              </form>\n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("            <p>La película está Bloqueado</p>\n");
      out.write("              <form id = \"desbloquear_pelicula\" action = \"desbloquear_pelicula\" method = \"post\">\n");
      out.write("                  <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                    <div class = \"boton\">\n");
      out.write("                      <input type = \"submit\" value = \"Desbloquear Pelicula\">\n");
      out.write("                    </div>\n");
      out.write("              </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    ");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Header -->\n");
      out.write("<header id=\"header\" class=\"reveal\"> ");
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
      out.write("\t\t\t\t\t\t\t\t<a href=\"perfil\">Mi perfil</a>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"icon fa-angle-down\">Nuevo tema</a>\n");
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
      out.write("\n");
      out.write("\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t</nav>\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t<div id=\"id01\" class=\"modal\">\n");
      out.write("\t\t\t\t\t  <form class=\"modal-content animate\" method=\"post\" action=\"iniciar_sesion\"> <!--Mandar a nuestro servlet-->\n");
      out.write("\t\t\t\t\t    <!--Aspa de cerrar y avatar usuario-->\n");
      out.write("\t\t\t\t\t    <div class=\"imgcontainer\">\n");
      out.write("\t\t\t\t\t      \t<span onclick=\"document.getElementById('id01').style.display='none'\" class=\"close\" title=\"Cerrar\">&times;</span>\n");
      out.write("\t\t\t\t\t      \t<img src=\"images/img_avatar.png\" alt=\"Avatar\" class=\"avatar\">\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t    <!--Form propiamente dicho-->\n");
      out.write("\t\t\t\t\t    <div class=\"container\">\n");
      out.write("\t\t\t\t\t      \t<label for=\"username\"><b>Usuario</b></label>\n");
      out.write("\t\t\t\t\t      \t<input type=\"text\" placeholder=\"Introduzca su usuario\" id=\"username\" name=\"username\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t      \t<label for=\"password\"><b>Contraseña</b></label>\n");
      out.write("\t\t\t\t\t      \t<input type=\"password\" placeholder=\"Introduzca su contraseña\" id=\"password\" name=\"password\" required>\n");
      out.write("\n");
      out.write("\t\t\t\t\t      \t<button type=\"submit\" class=\"submitbutton\">Iniciar Sesion</button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        ");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t    <!--Cancelar y olvidar contrasenya-->\n");
      out.write("\t\t\t\t\t    <div class=\"container\">\n");
      out.write("\t\t\t\t\t      \t<button type=\"button\" onclick=\"document.getElementById('id01').style.display='none'\" class=\"cancelbutton\">Cancelar</button>\n");
      out.write("\t\t\t\t\t    </div>\n");
      out.write("\t\t\t\t\t  </form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\t\t\t\t\t");
      out.write("\n");
      out.write("\t\t\t\t\t<div id=\"id03\" class=\"modal\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<form class=\"modal-content animate\" autocomplete=\"off\" method=\"post\" action=\"usuario_guardar\">\n");
      out.write("\t\t                                    ");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t            <div class=\"imgcontainer\">\n");
      out.write("\t\t\t\t\t\t\t\t\t\t     \t<span onclick=\"document.getElementById('id03').style.display='none'\" class=\"close\" title=\"Cerrar\">&times;</span>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    </div>\n");
      out.write("\n");
      out.write("\t\t\t\t\t\t\t\t\t\t    ");
      out.write("\t\n");
      out.write("\t\t                                    <div class=\"container\">\n");
      out.write("\n");
      out.write("\t\t\t                                    <div class=\"row gtr-uniform gtr-50\">\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                            <input type=\"text\" name=\"nombre\" id=\"nombre\" value=\"\" placeholder=\"nombre\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                            <input type=\"text\" name=\"apellido1\" id=\"apellido1\" value=\"\" placeholder=\"Primer Apellido\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                            <input type=\"text\" name=\"apellido2\" id=\"apellido2\" value=\"\" placeholder=\"Segundo Apellido\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                                <input type=\"email\" name=\"email\" id=\"email\" value=\"\" placeholder=\"Email\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                                <input type=\"password\" name=\"contrasenya\" id=\"contrasenya\" value=\"\" placeholder=\"Contraseña\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                            <input type=\"password\" name=\"contrasenya2\" id=\"contrasenya2\" value=\"\" placeholder=\"Repita contraseña\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                            <input type=\"text\" name=\"usuario\" id=\"usuario\" value=\"\" placeholder=\"Usuario\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                        <div class=\"col-6 col-12-mobilep\">\n");
      out.write("\t\t\t                                            <input type=\"text\" name=\"telefono\" id=\"telefono\" value=\"\" placeholder=\"Telefono\">\n");
      out.write("\t\t\t                                        </div>\n");
      out.write("\t\t\t                                   \n");
      out.write("\t\t\t                                    </div>\n");
      out.write("\n");
      out.write("\t\t                                    <button type=\"submit\" class=\"submitbutton\">Enviar</button>\n");
      out.write("\t\t                                    <button type=\"reset\" class=\"cancelbutton\">Reset</button>\n");
      out.write("\t\t                                   \n");
      out.write("\t\t                                    </div>\n");
      out.write("\t\t                                </form>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\n");
      out.write("</header>");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"box\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <h2>Información acerca de la película</h3>\n");
      out.write("                <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                    <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                    <h3><b>Portada</b></h3>\n");
      out.write("                        ");
      out.write("\n");
      out.write("                        <img src=\"imagen?id_pelicula=");
      out.print(pelicula.getId());
      out.write("\" alt=\"");
      out.print(pelicula.getTitulo());
      out.write("\" width=\"150\"/>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <br/>\n");
      out.write("                        <h3><b>Año: </b>");
      out.print( pelicula.getAnyo());
      out.write("</h3>\n");
      out.write("                        <h3><b>Duracion: </b>");
      out.print( pelicula.getDuracion());
      out.write(" min</h3>\n");
      out.write("                        <h3><b>Director: </b>");
      out.print( pelicula.getDirector());
      out.write("</h3>\n");
      out.write("                        <h3><b>Descripción: </b>");
      out.print( pelicula.getDescripcion());
      out.write("</h3>\n");
      out.write("                        <h3><b>Trailer: </b></h3> <iframe width=\"500\" src=\"");
      out.print(pelicula.getTrailer());
      out.write("\" align=\"middle\" frameborder=\"0\" allowfullscreen ></iframe>\n");
      out.write("\n");
      out.write("                        <p> </p>\n");
      out.write("                        <h3><b>Usuario creador: </b><a href=\"usuario?usuarioid=");
      out.print( usuariocreador.getId());
      out.write("\"> <b>");
      out.print( usuariocreador.getUsuario() );
      out.write("</b></a></h3>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <h2><b>Comentarios</b></h2>\n");
      out.write("        ");
 if(comentarios.size() > 0){ 
      out.write("\n");
      out.write("            ");
 for(Comentario tmp: comentarios) { 
      out.write("\n");
      out.write("                ");
if (mi_usuario.getTipo_usuario().equals("MODERADOR")){ 
      out.write("\n");
      out.write("                        ");
if (tmp.getBloqueado() == 0){
      out.write("\n");
      out.write("                          ");
if (tmp.getComentario_padre() == 0){
      out.write("\n");
      out.write("                              <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                                      ");
      out.write("\n");
      out.write("                                      <h3> <a href=\"usuario?usuarioid=");
      out.print( tmp.getUsuario());
      out.write("\"> <b>");
      out.print( userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() );
      out.write("</a>: ");
      out.print( tmp.getComentario_text());
      out.write("</b></h3>\n");
      out.write("                                          <form id = \"bloquear_comentario\" action = \"bloquear_comentario\" method = \"post\">\n");
      out.write("                                              <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                              <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp.getId());
      out.write("\">\n");
      out.write("                                                  <div class = \"boton\">\n");
      out.write("                                                      <input type = \"submit\" value = \"Bloquear Comentario\">\n");
      out.write("                                                  </div>\n");
      out.write("                                          </form>\n");
      out.write("                                            ");
for(Comentario tmp2: comentarios){
      out.write("\n");
      out.write("                                                ");
if(tmp2.getComentario_padre() == tmp.getId()){
      out.write("\n");
      out.write("                                                  <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                                                          ");
      out.write("\n");
      out.write("                                                          <h4>Respuesta de <a href=\"usuario?usuarioid=");
      out.print( tmp2.getUsuario());
      out.write("\"><b>");
      out.print( userscomentadores.get(comentarios.indexOf(tmp2)).getUsuario() );
      out.write("</b></a>: ");
      out.print( tmp2.getComentario_text());
      out.write("</h4>\n");
      out.write("                                                    ");
if (tmp2.getBloqueado() == 0){
      out.write("\n");
      out.write("                                                      <form id = \"bloquear_comentario\" action = \"bloquear_comentario\" method = \"post\">\n");
      out.write("                                                          <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                                          <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp2.getId());
      out.write("\">\n");
      out.write("                                                              <div class = \"boton\">\n");
      out.write("                                                                  <input type = \"submit\" value = \"Bloquear Comentario\">\n");
      out.write("                                                              </div>\n");
      out.write("                                                      </form>\n");
      out.write("                                                      ");
} else{
      out.write("\n");
      out.write("                                                      <p>El comentario está Bloqueado</p>\n");
      out.write("                                                      <form id = \"desbloquear_comentario\" action = \"desbloquear_comentario\" method = \"post\">\n");
      out.write("                                                      <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                                          <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp2.getId());
      out.write("\">\n");
      out.write("                                                          <div class = \"boton\">\n");
      out.write("                                                              <input type = \"submit\" value = \"Desbloquear Comentario\">\n");
      out.write("                                                          </div>\n");
      out.write("                                                      </form>\n");
      out.write("                                                      ");
}
      out.write("\n");
      out.write("                                                  </div>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                              ");
}
      out.write("\n");
      out.write("                                  ");
if(session.getAttribute("session_id") != null){ 
      out.write("\n");
      out.write("                                      ");
if(mi_usuario.getBloqueado() == 0){
      out.write("\n");
      out.write("                                          <form id = \"creacion_comentario\" action = \"comentario_peli_guardar\" method = \"post\">\n");
      out.write("                                              <input type = \"hidden\" name =\"id_peli\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                              <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp.getId());
      out.write("\">\n");
      out.write("                                              <textarea name = \"comentario_text\" rows=\"1\" cols=\"40\" placeholder=\"Escriba aquí su comentario\"></textarea>\n");
      out.write("                                                <div class = \"boton\">\n");
      out.write("                                                    <input type = \"submit\" value = \"Responder\">\n");
      out.write("                                                </div>\n");
      out.write("                                          </form>\n");
      out.write("                                      ");
}
      out.write("\n");
      out.write("                                  ");
}
      out.write("\n");
      out.write("                              </div>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        ");
}else{
      out.write("\n");
      out.write("                          ");
if (tmp.getComentario_padre() == 0){
      out.write("\n");
      out.write("                            <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                                ");
      out.write("\n");
      out.write("                                <h3> <a href=\"usuario?usuarioid=");
      out.print( tmp.getUsuario());
      out.write("\"> <b>");
      out.print( userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() );
      out.write("</a>: ");
      out.print( tmp.getComentario_text());
      out.write("</h3></b>\n");
      out.write("                                <p>El comentario está Bloqueado</p>\n");
      out.write("                                <form id = \"desbloquear_comentario\" action = \"desbloquear_comentario\" method = \"post\">\n");
      out.write("                                <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                    <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp.getId());
      out.write("\">\n");
      out.write("                                    <div class = \"boton\">\n");
      out.write("                                        <input type = \"submit\" value = \"Desbloquear Comentario\">\n");
      out.write("                                    </div>\n");
      out.write("                                </form>\n");
      out.write("                                ");
for(Comentario tmp2: comentarios){
      out.write("\n");
      out.write("                                    ");
if(tmp2.getComentario_padre() == tmp.getId()){
      out.write("\n");
      out.write("                                      <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                                              ");
      out.write("\n");
      out.write("                                              <h4>Respuesta de <a href=\"usuario?usuarioid=");
      out.print( tmp2.getUsuario());
      out.write("\"><b>");
      out.print( userscomentadores.get(comentarios.indexOf(tmp2)).getUsuario() );
      out.write("</b></a>: ");
      out.print( tmp2.getComentario_text());
      out.write("</h4>\n");
      out.write("                                              ");
if (tmp2.getBloqueado() == 0){
      out.write("\n");
      out.write("                                                <form id = \"bloquear_comentario\" action = \"bloquear_comentario\" method = \"post\">\n");
      out.write("                                                    <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                                    <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp2.getId());
      out.write("\">\n");
      out.write("                                                        <div class = \"boton\">\n");
      out.write("                                                            <input type = \"submit\" value = \"Bloquear Comentario\">\n");
      out.write("                                                        </div>\n");
      out.write("                                                </form>\n");
      out.write("                                                ");
} else{
      out.write("\n");
      out.write("                                                <p>El comentario está Bloqueado</p>\n");
      out.write("                                                <form id = \"desbloquear_comentario\" action = \"desbloquear_comentario\" method = \"post\">\n");
      out.write("                                                <input type = \"hidden\" name =\"pelii_id\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                                    <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp2.getId());
      out.write("\">\n");
      out.write("                                                    <div class = \"boton\">\n");
      out.write("                                                        <input type = \"submit\" value = \"Desbloquear Comentario\">\n");
      out.write("                                                    </div>\n");
      out.write("                                                </form>\n");
      out.write("                                                ");
}
      out.write("\n");
      out.write("                                      </div>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                  ");
}
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                ");
} else {
      out.write(' ');
      out.write("\n");
      out.write("                    ");
if (tmp.getBloqueado() == 0){
      out.write("\n");
      out.write("                      ");
if (tmp.getComentario_padre() == 0){
      out.write("\n");
      out.write("                            <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                            ");
      out.write("\n");
      out.write("                            <h3> <a href=\"usuario?usuarioid=");
      out.print( tmp.getUsuario());
      out.write("\"> <b>");
      out.print( userscomentadores.get(comentarios.indexOf(tmp)).getUsuario() );
      out.write("</b></a>: ");
      out.print( tmp.getComentario_text());
      out.write("</h3>\n");
      out.write("                                ");
for(Comentario tmp2: comentarios){
      out.write("\n");
      out.write("                                    ");
if(tmp2.getComentario_padre() == tmp.getId()){
      out.write("\n");
      out.write("                                      <div class=\"row-6 row-12-mobilep\">\n");
      out.write("                                              ");
      out.write("\n");
      out.write("                                              <h4>Respuesta de <a href=\"usuario?usuarioid=");
      out.print( tmp2.getUsuario());
      out.write("\"> <b>");
      out.print( userscomentadores.get(comentarios.indexOf(tmp2)).getUsuario() );
      out.write("</b></a>: ");
      out.print( tmp2.getComentario_text());
      out.write("</h4>\n");
      out.write("                                      </div>\n");
      out.write("                                    ");
}
      out.write("\n");
      out.write("                                  ");
}
      out.write("\n");
      out.write("                            ");
if(session.getAttribute("session_id") != null){ 
      out.write("\n");
      out.write("                                ");
if(mi_usuario.getBloqueado() == 0){
      out.write("\n");
      out.write("                                    <form id = \"creacion_comentario\" action = \"comentario_peli_guardar\" method = \"post\">\n");
      out.write("                                                <input type = \"hidden\" name =\"id_peli\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                                                <input type = \"hidden\" name =\"comentario_id\" value=\"");
      out.print(tmp.getId());
      out.write("\">\n");
      out.write("                                                <textarea name =\"comentario_text\" rows=\"1\" cols=\"40\" placeholder=\"Escriba aquí su respuesta\"></textarea>\n");
      out.write("                                                  <div class = \"boton\">\n");
      out.write("                                                      <input type = \"submit\" value = \"Responder\">\n");
      out.write("                                                  </div>\n");
      out.write("                                    </form>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            ");
}
      out.write(' ');
      out.write("\n");
      out.write("          ");
}
      out.write("\n");
      out.write("        ");
} else { 
      out.write("\n");
      out.write("            <p>La película no tiene comentarios</p>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
if(session.getAttribute("session_id") != null){ 
      out.write("\n");
      out.write("            ");
if(mi_usuario.getBloqueado() == 0){
      out.write("\n");
      out.write("                <form id = \"creacion_comentario\" action = \"comentario_peli_guardar\" method = \"post\">\n");
      out.write("                    <input type = \"hidden\" name =\"id_peli\" value=\"");
      out.print(pelicula.getId());
      out.write("\">\n");
      out.write("                    <input type = \"hidden\" name =\"comentario_id\" value=\"0\">\n");
      out.write("                    <textarea name =\"comentario_text\" rows=\"10\" cols=\"40\" placeholder=\"Escriba aquí su comentario\"></textarea>\n");
      out.write("                      <div class = \"boton\">\n");
      out.write("                          <input type = \"submit\" value = \"Publicar\">\n");
      out.write("                      </div>\n");
      out.write("                </form>\n");
      out.write("            ");
}else{
      out.write("\n");
      out.write("                <p>No puedes comentar esta película, su usuario está bloqueado. Contacte con Manloo para más ayuda</p>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<!-- Footer -->\n");
      out.write("    <footer id=\"footer\">\n");
      out.write("        <ul class=\"icons\">\n");
      out.write("            <li><a href=\"https://twitter.com/uc3m\" target=\"_blank\" class=\"icon fa-twitter\"><span class=\"label\">Twitter</span></a></li>\n");
      out.write("            <li><a href=\"https://www.facebook.com/uc3m/\" class=\"icon fa-facebook\"><span class=\"label\">Facebook</span></a></li>\n");
      out.write("            <li><a href=\"https://github.com/pdepaz/appweb18_project\" target=\"_blank\" class=\"icon fa-github\"><span class=\"label\">Github</span></a></li>\n");
      out.write("        </ul>\n");
      out.write("        <ul class=\"copyright\">\n");
      out.write("            <li>&copy; Alfonso Albacete, Gonzalo Puy y Pablo de Paz.</li><li>2018</a></li>\n");
      out.write("        </ul>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("<!-- Scripts -->\n");
      out.write("        <script src=\"assets/js/jquery.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.dropotron.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/jquery.scrollex.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/browser.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/breakpoints.min.js\"></script>\n");
      out.write("        <script src=\"assets/js/util.js\"></script>\n");
      out.write("        <script src=\"assets/js/main.js\"></script>\n");
      out.write("        <script src=\"assets/js/login.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("      </body>\n");
      out.write("</section>\n");
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
