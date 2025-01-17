package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Blob;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.*;

import java.nio.*;
import java.net.*;

import javax.mail.*;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import java.net.URLConnection;


public class DBManager implements AutoCloseable { //Se llama a "close" automaticamente

    private Connection connection;

    public DBManager() throws NamingException, SQLException {
        connect();
    }

    /**
     * Inicia la conexión de la DataBase
     */
    private void connect() throws NamingException, SQLException {
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/proyecto");
        connection = ds.getConnection();
    }



    /**
     * Cierra la conexión (si sigue abierta)
     */
    public void close() throws SQLException{ //Se va a llamar automaticamente por el hecho de usar un servlet como se ha explicado en clase...
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }
    /**
     * Checkea en la DB si el usuario y la contraseña dados por argumentos existen
     *
     * @param usuario username
     * @param contrasenya password of the user
     * @return devuelve el ID del usuario (si existe). Si no, -1.
     */
    public int iniciarSesion(String usuario, String contrasenya) throws SQLException {

        /*if (usuario.equals("")){
            return -1;
        }

        if (contrasenya.equals("")){
            return -1;
        }*/

        int id_user = -1;

        String query = "SELECT * FROM Usuarios WHERE BINARY Usuarios.usuario=? AND BINARY Usuarios.contrasenya=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, usuario);
            st.setString(2, contrasenya);
            // execute select SQL stetement
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                id_user = rs.getInt("id");
			}
        }

        return id_user;
    }



    /**
     * Checkea si el usuario existe en la DB. Para checkear: email y/o usuario.
     *
     * @param email
     * @param usuario nombre de usuario
     * @return true if error (already exists), false if OK (doesn't exists)
     */
    public boolean verificarExistenciaUsuario(String email, String usuario) throws SQLException {

        //Verificar que los datos que me llegan están bien (de los obligatorios)

       String query = "SELECT * FROM Usuarios WHERE Usuarios.email=? OR BINARY Usuarios.usuario=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, email);
            st.setString(2, usuario);
            // execute select SQL stetement
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true; //Doesn't exists
            } else {
                return false; //User exists
            }
        }
    }

    /**
     * Checkea si el usuario existe en la DB. por id
     *
     * @param id
     * @return true si existe, false si no existe
     */
    public boolean existeUsuarioId(int id) throws SQLException {

        //Verificar que los datos que me llegan están bien (de los obligatorios)

       String query = "SELECT * FROM Usuarios WHERE Usuarios.id=?";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setInt(1, id);

            // execute select SQL stetement
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                return true; //Exist
            } else {
                return false; //no existe
            }
        }
    }

    /**
     * Create username in the DB. Compulsory fields to input by user shown below. By default, create a user "no bloqueado"
     *
     * @param usuario
     * @return 1 if correct, -1 if error
     */
    public int crearUsuario(Usuario usuario) throws SQLException {

        //Verificar que los datos que me llegan están bien (de los obligatorios)
        String email = usuario.getEmail();
        String nombre_usuario = usuario.getUsuario();

        if (verificarExistenciaUsuario(email, nombre_usuario)){
            return -1; //Usuario ya existe
        }

        String query = "INSERT INTO Usuarios (nombre, apellido1, apellido2, email, foto, telefono, contrasenya, usuario, tipo_usuario, bloqueado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta
            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellido1());
            st.setString(3, usuario.getApellido2());
            st.setString(4, email);
            st.setBlob(5, new ByteArrayInputStream(usuario.getFoto()));
            st.setInt(6, usuario.getTelefono());
            st.setString(7, usuario.getContrasenya());
            st.setString(8, nombre_usuario);
            st.setString(9, usuario.getTipo_usuario());

            // execute select SQL stetement
            st.executeUpdate();

        }
        return 1;
    }


     /**
     * Actualiza los datos de un usuario
     * @param usuario
     * @return 1 if correct
     */
    public int actualizaUsuario(Usuario usuario) throws SQLException {

        String query = "UPDATE Usuarios SET nombre = ?, apellido1 =?, apellido2 = ?, email = ?, foto = ?, telefono = ?, contrasenya= ? WHERE  Usuarios.id = ?";

        try (PreparedStatement st = connection.prepareStatement(query)) {

            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellido1());
            st.setString(3, usuario.getApellido2());
            st.setString(4, usuario.getEmail());
            st.setBlob(5, new ByteArrayInputStream(usuario.getFoto()));
            st.setInt(6, usuario.getTelefono());
            st.setString(7, usuario.getContrasenya());
            st.setInt(8,usuario.getId());

            // execute select SQL stetement
            st.executeUpdate();
        }
        return 1;
    }



/********
isBloqueado checkea si usuario está bloqueado
devuelve bloqueado dentro de usuarios
1 si bloqueado 0 si no está bloqueado.
@param id de usuario

*******/
    public int isBloqueado(int id) throws SQLException {

        int bloqueado = 0;

        String query = "SELECT bloqueado From Usuarios WHERE Usuarios.id = ?";

         try (PreparedStatement st = connection.prepareStatement(query)) {

                st.setInt(1, id);
                ResultSet rs =  st.executeQuery();
                while(rs.next()){
                  bloqueado = rs.getInt("bloqueado");
                }
        }
        // 1 si bloqueado 0 si no
        return bloqueado;

    }



/**
     * Crear Comentario
     *
     * @param comentario
     * @return 1 if correct, 0 if not created, -1 if error
     */
    public int creaComentarioPeli(Comentario comment) throws SQLException {
        //El usuario que cree un comentario solo verá el botón de comentar si existe de manera que no verifico si existe porque se hará en otro lado
        //El comentario vendrá a traves de un formulario del que podremos obtener quien es el usuario y su id.

        //comprobamos si la cadena introducida es espacio vacio o si el usuario está bloqueado
        if(comment.getComentario_text().equals("") || isBloqueado(comment.getUsuario()) == 1 || comment.getBloqueado() == 1){
            return -1;
        }

        /*if(comment.getComentario_padre() == 0){
            comment.setComentario_padre(0);
        }*/


        //CHECK SECURITY
        if(comment.getComentario_text().contains("<") || comment.getComentario_text().contains(">") || comment.getComentario_text().contains("SELECT")){
            return -1;
        }

        String query = "INSERT INTO Comentarios (comentario_text, tipo_tema, pelicula,usuario,fecha_creacion,comentario_padre,bloqueado) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
                st.setString(1, comment.getComentario_text());
                st.setString(2, "Pelicula");
                st.setInt(3, comment.getPelicula());
                //st.setInt(4, 0);
                //st.setInt(5, 0);
                st.setInt(4, comment.getUsuario());
                st.setDate(5,comment.getFecha_creacion());
                st.setInt(6, comment.getComentario_padre());
                st.setInt(7, 0);

          st.executeUpdate();
          return 1;
        }
    }
    public int creaComentarioSerie(Comentario comment) throws SQLException {
        //El usuario que cree un comentario solo verá el botón de comentar si existe de manera que no verifico si existe porque se hará en otro lado
        //El comentario vendrá a traves de un formulario del que podremos obtener quien es el usuario y su id.

        //comprobamos si la cadena introducida es espacio vacio o si el usuario está bloqueado
        if(comment.getComentario_text().equals("") || isBloqueado(comment.getUsuario()) == 1){
            return -1;
        }

        /*if(comment.getComentario_padre() == 0){
            comment.setComentario_padre(0);
        }*/


        //CHECK SECURITY
        if(comment.getComentario_text().contains("<") || comment.getComentario_text().contains(">") || comment.getComentario_text().contains("SELECT")){
            return -1;
        }

        String query = "INSERT INTO Comentarios (comentario_text, tipo_tema, serie,usuario,fecha_creacion,comentario_padre,bloqueado) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :

                st.setString(1, comment.getComentario_text());
                st.setString(2, "Serie");
                //st.setInt(3, 0);
                st.setInt(4, comment.getSerie());
                //st.setInt(5, 0);
                st.setInt(6, comment.getUsuario());
                st.setString(7, "2010-10-10 10:10:10");
                st.setInt(8, comment.getComentario_padre());
                st.setInt(9, 0);

          st.executeUpdate();
          return 1;
        }
    }
    public int creaComentarioLibro(Comentario comment) throws SQLException {
        //El usuario que cree un comentario solo verá el botón de comentar si existe de manera que no verifico si existe porque se hará en otro lado
        //El comentario vendrá a traves de un formulario del que podremos obtener quien es el usuario y su id.

        //comprobamos si la cadena introducida es espacio vacio o si el usuario está bloqueado
        if(comment.getComentario_text().equals("") || isBloqueado(comment.getUsuario()) == 1){
            return -1;
        }

        /*if(comment.getComentario_padre() == 0){
            comment.setComentario_padre(0);
        }*/


        //CHECK SECURITY
        if(comment.getComentario_text().contains("<") || comment.getComentario_text().contains(">") || comment.getComentario_text().contains("SELECT")){
            return -1;
        }

        String query = "INSERT INTO Comentarios (comentario_text, tipo_tema, libro,usuario,fecha_creacion,comentario_padre,bloqueado) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :

                st.setString(1, comment.getComentario_text());
                st.setString(2, "Libro");
                //st.setInt(3, 0);
                //st.setInt(4, 0);
                st.setInt(5, comment.getLibro());
                st.setInt(6, comment.getUsuario());
                st.setString(7,"2010-10-10 10:10:10");
                st.setInt(8, comment.getComentario_padre());
                st.setInt(9, 0);

          st.executeUpdate();
          return 1;
        }


    }

/**
     * Crear Pelicula. Anade una pelicula a la base de datos.
     *
     * @param Pelicula object
     * @return
     */
        public int creaPelicula(Pelicula pelicula) throws SQLException {

                if(isBloqueado(pelicula.getCreador()) == 1 || pelicula.getBloqueado() == 1){
                    return -1;
                }

                String query_pelicula = "INSERT INTO Peliculas (titulo, anyo, duracion, descripcion, director, genero, portada, trailer, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?,?)";
                //String query_pelicula = "INSERT INTO Peliculas (titulo, anyo, duracion, descripcion, director, genero, trailer, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?)";

                try(PreparedStatement st = connection.prepareStatement(query_pelicula)){
                    st.setString(1, pelicula.getTitulo());
                    st.setInt(2, pelicula.getAnyo());
                    st.setInt(3, pelicula.getDuracion());
                    st.setString(4, pelicula.getDescripcion());
                    st.setString(5,pelicula.getDirector());
                    st.setString(6,pelicula.getGenero());
                    st.setBlob(7, new ByteArrayInputStream(pelicula.getPortada()));
                    st.setString(8,pelicula.getTrailer());
                    st.setInt(9,pelicula.getCreador());
                    st.setInt(10,pelicula.getBloqueado());

                    st.executeUpdate();
                }
                return 1;
        }
/*
*
* Comprueba si la pelicula tiene algun parametro introducido en el formulario invalido
*     TRUE cuando no tiene FALSE si tiene algun parametro no valido
*/
public boolean checkPelicula(Pelicula pelicula){
  //Anado una comprobacion podemos anadir mas
      if(pelicula.getTrailer().contains("proyecto")){
        return false;
      }

      return true;

}
//CExiste la peliculaen la base de datos
/**
 * Compruebasi existe la peli en la base de datos
 *
 * @param id de la pelicula
 * @return Pelicula object
 */
 public boolean existePelicula(int id) throws SQLException {
     //Objeto de la clase Pelicula
    String query_pelicula = "SELECT * FROM Peliculas WHERE id =?";
    try(PreparedStatement st = connection.prepareStatement(query_pelicula)){
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();
        if(rs.next()){ //OK, SQL return something
          return true;
        }


    }
    return false;
}

/**
     * Carga la pelicula en funcion de un nombre de pelicula
     *
     * @param String nombre de usuario
     * @return Pelicula
     */
    public Pelicula cargar_pelicula_nombrepeli(String nombre_pelicula) throws SQLException {

        Pelicula movie = new Pelicula(); //Objeto de la clase Usuario
        String query = "SELECT * FROM Peliculas WHERE Peliculas.titulo = ?";

        try(PreparedStatement st = connection.prepareStatement(query)){
            st.setString(1, nombre_pelicula);

            ResultSet rs = st.executeQuery();

            while (rs.next()){ //OK, SQL return something
                movie.setId(rs.getInt("id"));
                movie.setTitulo(rs.getString("titulo"));
                movie.setAnyo(rs.getInt("anyo"));
                movie.setDuracion(rs.getInt("duracion"));
                movie.setDescripcion(rs.getString("descripcion"));
                movie.setDirector(rs.getString("director"));
                movie.setGenero(rs.getString("genero"));
                movie.setTrailer(rs.getString("trailer"));
                movie.setCreador(rs.getInt("creador"));
                movie.setBloqueado(rs.getInt("bloqueado"));
            }
        }
        return movie;
}

public int getIdByUsuario(String usuario) throws SQLException{

    int id = -1;

    String query_user = "SELECT * FROM Usuarios WHERE Usuarios.usuario=?";
    try (PreparedStatement st = connection.prepareStatement(query_user)) {
    // Se insertan los valores en la consulta :
        st.setString(1, usuario);
        // execute select SQL stetement
        ResultSet rs = st.executeQuery();
        //OK, SQL return something
        while (rs.next()){ //OK, SQL return something
          id = rs.getInt("id");
        }
    }
    return id;
}

public int getIdByPelicula(String pelicula) throws SQLException{

    int id = -1;

    String query_peliculita = "SELECT * FROM Peliculas WHERE Peliculas.titulo=?";
    try (PreparedStatement st = connection.prepareStatement(query_peliculita)) {
    // Se insertan los valores en la consulta :
        st.setString(1, pelicula);
        // execute select SQL stetement
        ResultSet rs = st.executeQuery();
        //OK, SQL return something
        while (rs.next()){ //OK, SQL return something
          id = rs.getInt("id");
        }
    }
    return id;
}

    /*
    Crear Serie: Anade una serie a la base de datos
    @param un objeto serie

    */

        public void creaSerie(Serie serie) throws SQLException {


                String query_serie = "INSERT INTO Series (titulo, anyo, temporadas, capitulos, descripcion, genero, trailer, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?)";

                try(PreparedStatement st = connection.prepareStatement(query_serie)){
                    st.setString(1, serie.getTitulo());
                    st.setInt(2, serie.getAnyo());
                    st.setInt(3, serie.getTemporadas());
                    st.setInt(4, serie.getCapitulos());
                    st.setString(5, serie.getDescripcion());
                    st.setString(6, serie.getGenero());
                    //st.setString(7,serie.getPortada());
                    st.setString(7,serie.getTrailer());
                    st.setInt(8,serie.getCreador());
                    st.setInt(9,serie.getBloqueado());

                    st.executeUpdate();
                }

        }


    /*
    Crear Serie: Anade una serie a la base de datos
    @param un objeto serie

    */

        public void creaLibro(Libro libro) throws SQLException {

                String query_libro = "INSERT INTO Libros (titulo, anyo, paginas, escritor, editorial, genero, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?)";
                try(PreparedStatement st = connection.prepareStatement(query_libro)){

                    st.setString(1, libro.getTitulo());
                    st.setInt(2, libro.getAnyo());
                    st.setInt(3, libro.getPaginas());
                    st.setString(4, libro.getEscritor());
                    st.setString(5, libro.getEditorial());
                    st.setString(6,libro.getGenero());
                    //st.setString(7,libro.getPortada());
                    st.setInt(7,libro.getCreador());
                    st.setInt(8,libro.getBloqueado());

                    st.executeUpdate();

                }

        }




    public boolean isModerador(int id) throws SQLException {

        String query_is = "SELECT tipo_usuario FROM Usuarios WHERE id=?";

        try(PreparedStatement st = connection.prepareStatement(query_is)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (!rs.equals("MODERADOR")){
                return false;
            }
            return true;
        }
    }

    /**
     * Bloquear un comentario (hecho por moderadores)
     *
     * @param id id del comentario que queremos bloquear
     * @return true = bloqueado
     */
    public boolean bloquear_comentario(int id) throws SQLException { //Pasamos el id del comentario que queremos bloquear

        String query_bloquear_comentario = "UPDATE Comentarios SET Comentarios.bloqueado=1 WHERE Comentarios.id=?";

        try(PreparedStatement st = connection.prepareStatement(query_bloquear_comentario)){
            st.setInt(1, id);
            st.executeUpdate();
        }
        return true;
    }


     /**
     * Desbloquear un comentario (hecho por moderadores)
     *
     * @param id id del comentario que queremos bloquear
     * @return true = desbloqueado
     */
    public boolean desbloquear_comentario(int id) throws SQLException {//Pasamos el id del comentario que queremos desbloquear

        String query_desbloquear_comentario = "UPDATE Comentarios SET Comentarios.bloqueado=0 WHERE Comentarios.id=?";

        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_comentario)){
            st.setInt(1, id);
            st.executeUpdate();
        }
        return true;
    }

    /**
     * Bloquear un tema (hecho por moderadores)
     *
     * @param tipo tipo de tema que queremos bloquear
     * @param id id del tema
     * @return true = bloqueado
     */
    public boolean bloquear_tema(String tipo, int id) throws SQLException {

      //comprobar si el usuario es moderador en otro lado yo creo mejor
        //if(!isModerador(id)){
        //    return false;
      //  }

        switch(tipo){
            case "Peliculas":

                String query_bloquear_pelicula = "UPDATE Peliculas SET Peliculas.bloqueado=1 WHERE Peliculas.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_pelicula)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                String query_bloquear_pelicula2 = "UPDATE Comentarios SET Comentarios.bloqueado=1 WHERE Comentarios.pelicula=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_pelicula2)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                break;

            case "Series":

                String query_bloquear_serie = "UPDATE Series SET Series.bloqueado=1 WHERE Series.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_serie)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                String query_bloquear_serie2 = "UPDATE Comentarios SET bloqueado=1 WHERE serie=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_serie2)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }

                break;

            case "Libros":

                String query_bloquear_libro = "UPDATE Libros SET Libros.bloqueado=1 WHERE Libros.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_libro)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                String query_bloquear_libro2 = "UPDATE Comentarios SET bloqueado=1 WHERE libro=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_libro2)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                break;
        }
        return true;
    }


   /**
     * Desbloquear un tema (hecho por moderadores)
     *
     * @param tipo tipo de tema que queremos bloquear
     * @param id id del tema
     * @return true = desbloqueado
     */
    public boolean desbloquear_tema(String tipo, int id) throws SQLException {//Pasamos el id del tema y el tema que queremos desbloquear

        switch(tipo){
            case "Peliculas":

                String query_desbloquear_pelicula = "UPDATE Peliculas SET Peliculas.bloqueado=0 WHERE Peliculas.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_pelicula)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                String query_desbloquear_pelicula2 = "UPDATE Comentarios SET bloqueado=0 WHERE pelicula=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_pelicula2)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                break;

            case "Series":

                String query_desbloquear_serie = "UPDATE Series SET Series.bloqueado=0 WHERE Series.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_serie)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                String query_desbloquear_serie2 = "UPDATE Comentarios SET bloqueado=0 WHERE serie=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_serie2)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                break;

            case "Libros":

                String query_desbloquear_libro = "UPDATE Libros SET Libros.bloqueado=0 WHERE Libros.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_libro)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                String query_desbloquear_libro2 = "UPDATE Comentarios SET bloqueado=0 WHERE libro=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_libro2)){
                    st.setInt(1, id);
                    st.executeUpdate();
                }
                break;
        }
        return true;
    }


    /**
     * Bloquear un usuario (hecho por moderadores)
     *
     * @param id id del usuario
     * @return true = bloqueado
     */
    public boolean bloquear_usuario(int id) throws SQLException {

        String query_bloquear_usuario = "UPDATE Usuarios SET bloqueado=1 WHERE id=?";

        try(PreparedStatement st = connection.prepareStatement(query_bloquear_usuario)){
            st.setInt(1, id);

            st.executeUpdate();
        }

        String query_bloquear_usuario2 = "UPDATE Comentarios SET bloqueado=1 WHERE usuario=?";

        try(PreparedStatement st = connection.prepareStatement(query_bloquear_usuario2)){
            st.setInt(1, id);

            st.executeUpdate();
        }

        String query_bloquear_usuario3 = "UPDATE Peliculas SET bloqueado=1 WHERE creador=?";

        try(PreparedStatement st = connection.prepareStatement(query_bloquear_usuario3)){
            st.setInt(1, id);

            st.executeUpdate();
        }

        return true;
    }


    /**
     * Desbloquear un usuario (hecho por moderadores)
     *
     * @param id id del usuario
     * @return true = bloqueado
     */
    public boolean desbloquear_usuario(int id) throws SQLException {

        String query_desbloquear_usuario = "UPDATE Usuarios SET Usuarios.bloqueado=0 WHERE Usuarios.id=?";

        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_usuario)){
            st.setInt(1, id);

            st.executeUpdate();
        }
        String query_desbloquear_usuario2 = "UPDATE Comentarios SET bloqueado=0 WHERE usuario=?";

        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_usuario2)){
            st.setInt(1, id);

            st.executeUpdate();
        }

        String query_desbloquear_usuario3 = "UPDATE Peliculas SET bloqueado=0 WHERE creador=?";

        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_usuario3)){
            st.setInt(1, id);

            st.executeUpdate();
        }

        return true;
    }



    //Carga el usuario devolviendo true si lo consigue o false si no lo consigue
    public Usuario cargar_usuario(int id) throws SQLException {
        Usuario user = new Usuario(); //Objeto de la clase Usuario
        String query_usuario = "SELECT * FROM Usuarios WHERE Usuarios.id = ?";
        try(PreparedStatement st = connection.prepareStatement(query_usuario)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()){ //OK, SQL return something
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido1(rs.getString("apellido1"));
                user.setApellido2(rs.getString("apellido2"));
                user.setEmail(rs.getString("email"));
                user.setFoto(rs.getBytes("foto"));
                user.setTelefono(rs.getInt("telefono"));
                user.setContrasenya(rs.getString("contrasenya"));
                user.setUsuario(rs.getString("usuario"));
                user.setTipo_usuario(rs.getString("tipo_usuario"));
                user.setBloqueado(rs.getInt("bloqueado"));
            }

        }
        return user;
    }


    //Carga el usuario devolviendo true si lo consigue o false si no lo consigue
    public Usuario cargar_usuario_nombreusuario(String nombreusuario) throws SQLException {
        Usuario user = new Usuario(); //Objeto de la clase Usuario
        String query_usuario = "SELECT * FROM Usuarios WHERE BINARY Usuarios.usuario = ?";
        try(PreparedStatement st = connection.prepareStatement(query_usuario)){
            st.setString(1, nombreusuario);
            ResultSet rs = st.executeQuery();

            while (rs.next()){ //OK, SQL return something
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido1(rs.getString("apellido1"));
                user.setApellido2(rs.getString("apellido2"));
                user.setEmail(rs.getString("email"));
                user.setFoto(rs.getBytes("foto"));
                user.setTelefono(rs.getInt("telefono"));
                user.setContrasenya(rs.getString("contrasenya"));
                user.setUsuario(rs.getString("usuario"));
                user.setTipo_usuario(rs.getString("tipo_usuario"));
                user.setBloqueado(rs.getInt("bloqueado"));
            }

        }
        return user;
    }



    /**
     * Carga los comentarios de un tema
     *
     * @param id id del tema
     * @param tipo_tema string que define el tema (pelicula, serie, libro)
     * @return Lista de Comentarios de un mismo tema
     */
    public List<Comentario> cargar_comentarios_list(int id, String tipo_tema) throws SQLException {

        if(tipo_tema.equals("Pelicula")){
            String query_comentario = "SELECT * FROM Comentarios WHERE pelicula=? AND tipo_tema=?";
            List<Comentario> lista_comentarios = new ArrayList<>();

            try(PreparedStatement st = connection.prepareStatement(query_comentario)){
                st.setInt(1, id);
                st.setString(2, tipo_tema);

                // execute select SQL stetement
                ResultSet rs = st.executeQuery();

                while (rs.next()){ //OK, SQL return something
                    Comentario comment = new Comentario();
                    comment.setId(rs.getInt("id"));
                    comment.setComentario_text(rs.getString("comentario_text"));
                    comment.setTipo_tema(rs.getString("tipo_tema"));
                    comment.setPelicula(rs.getInt("pelicula"));
                    comment.setSerie(rs.getInt("serie"));
                    comment.setLibro(rs.getInt("libro"));
                    comment.setUsuario(rs.getInt("usuario"));
                    comment.setFecha_creacion(rs.getDate("fecha_creacion"));
                    comment.setComentario_padre(rs.getInt("comentario_padre"));
                    comment.setBloqueado(rs.getInt("bloqueado"));

                    lista_comentarios.add(comment);
                }
            }
            return lista_comentarios;
        }
        if(tipo_tema.equals("Libro")){
            String query_comentario = "SELECT * FROM Comentarios WHERE libro=? AND tipo_tema=?";
            List<Comentario> lista_comentarios = new ArrayList<>();

            try(PreparedStatement st = connection.prepareStatement(query_comentario)){
                st.setInt(1, id);
                st.setString(2, tipo_tema);

                // execute select SQL stetement
                ResultSet rs = st.executeQuery();

                while (rs.next()){ //OK, SQL return something
                    Comentario comment = new Comentario();
                    comment.setId(rs.getInt("id"));
                    comment.setComentario_text(rs.getString("comentario_text"));
                    comment.setTipo_tema(rs.getString("tipo_tema"));
                    comment.setPelicula(rs.getInt("pelicula"));
                    comment.setSerie(rs.getInt("serie"));
                    comment.setLibro(rs.getInt("libro"));
                    comment.setUsuario(rs.getInt("usuario"));
                    comment.setFecha_creacion(rs.getDate("fecha_creacion"));
                    comment.setComentario_padre(rs.getInt("comentario_padre"));
                    comment.setBloqueado(rs.getInt("bloqueado"));

                    lista_comentarios.add(comment);
                }
            }
            return lista_comentarios;
        }
        if(tipo_tema.equals("Serie")){
            String query_comentario = "SELECT * FROM Comentarios WHERE serie=? AND tipo_tema=?";
            List<Comentario> lista_comentarios = new ArrayList<>();

            try(PreparedStatement st = connection.prepareStatement(query_comentario)){
                st.setInt(1, id);
                st.setString(2, tipo_tema);

                // execute select SQL stetement
                ResultSet rs = st.executeQuery();

                while (rs.next()){ //OK, SQL return something
                    Comentario comment = new Comentario();
                    comment.setId(rs.getInt("id"));
                    comment.setComentario_text(rs.getString("comentario_text"));
                    comment.setTipo_tema(rs.getString("tipo_tema"));
                    comment.setPelicula(rs.getInt("pelicula"));
                    comment.setSerie(rs.getInt("serie"));
                    comment.setLibro(rs.getInt("libro"));
                    comment.setUsuario(rs.getInt("usuario"));
                    comment.setFecha_creacion(rs.getDate("fecha_creacion"));
                    comment.setComentario_padre(rs.getInt("comentario_padre"));
                    comment.setBloqueado(rs.getInt("bloqueado"));

                    lista_comentarios.add(comment);
                }
            }
            return lista_comentarios;
        }
        return null;
    }


    //Carga pelicula para la vista
    /**
     * Carga pelicula (para la vista individual de cada pelicula)
     *
     * @param id de la pelicula
     * @return Pelicula object
     */
     public Pelicula cargarPelicula(int id) throws SQLException {
        Pelicula movie = new Pelicula(); //Objeto de la clase Pelicula
        String query_pelicula = "SELECT * FROM Peliculas WHERE id =?";
        try(PreparedStatement st = connection.prepareStatement(query_pelicula)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            while (rs.next()){ //OK, SQL return something
                movie.setId(rs.getInt("id"));
                movie.setTitulo(rs.getString("titulo"));
                movie.setAnyo(rs.getInt("anyo"));
                movie.setDuracion(rs.getInt("duracion"));
                movie.setDescripcion(rs.getString("descripcion"));
                movie.setDirector(rs.getString("director"));
                movie.setGenero(rs.getString("genero"));
                movie.setPortada(rs.getBytes("portada"));
                movie.setTrailer(rs.getString("trailer"));
                movie.setCreador(rs.getInt("creador"));
                movie.setBloqueado(rs.getInt("bloqueado"));
            }


        }
        return movie;
    }


    //Carga serie para la vista
    public Serie cargarSerie(int id) throws SQLException {
        Serie serie = new Serie(); //Objeto de la clase Pelicula
        String query_serie = "SELECT * FROM Series WHERE id =?";
        try(PreparedStatement st = connection.prepareStatement(query_serie)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            serie.setId(id);
            serie.setTitulo(rs.getString("titulo"));
            serie.setAnyo(rs.getInt("anyo"));
            serie.setTemporadas(rs.getInt("temporadas"));
            serie.setCapitulos(rs.getInt("capitulos"));
            serie.setDescripcion(rs.getString("descripcion"));
            serie.setGenero(rs.getString("genero"));
            serie.setTrailer(rs.getString("trailer"));
            serie.setCreador(rs.getInt("creador"));
            serie.setBloqueado(rs.getInt("bloqueado"));
        }
        return serie;
    }


        //Carga libro para la vista
    public Libro cargarLibro(int id) throws SQLException {
        Libro book = new Libro(); //Objeto de la clase Libro
        String query_libro = "SELECT * FROM Libros WHERE id =?";
        try(PreparedStatement st = connection.prepareStatement(query_libro)){
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            book.setId(id);
            book.setTitulo(rs.getString("titulo"));
            book.setAnyo(rs.getInt("anyo"));
            book.setPaginas(rs.getInt("paginas"));
            book.setEscritor(rs.getString("escritor"));
            book.setEditorial(rs.getString("editorial"));
            book.setGenero(rs.getString("genero"));
            book.setCreador(rs.getInt("creador"));
            book.setBloqueado(rs.getInt("bloqueado"));
        }
        return book;
    }



    /**
     * En la Home, carga las películas más nuevas
     *
     * @param NONE
     * @return lista de películas más nuevas (hasta 10)
     */
    public List<Pelicula> cargar_pelis_mas_nuevas() throws SQLException {

        String query = "SELECT * FROM Peliculas ORDER BY anyo DESC LIMIT 10";
        List<Pelicula> movies = new ArrayList<>();

        try(PreparedStatement st = connection.prepareStatement(query)){

            // execute select SQL stetement
            ResultSet rs = st.executeQuery();

            while (rs.next()){ //OK, SQL return something
                Pelicula pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setAnyo(rs.getInt("anyo"));
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setDescripcion(rs.getString("descripcion"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setTrailer(rs.getString("trailer"));
                pelicula.setCreador(rs.getInt("creador"));
                pelicula.setBloqueado(rs.getInt("bloqueado"));

                movies.add(pelicula);
            }

        }
        return movies;
    }


    /**
     * En la Home, carga las películas recomendadas para el usuario (solo si login)
     *
     * @param NONE
     * @return lista de películas recomendadas (max 10)
     */
    public List<Pelicula> cargar_pelis_recomendadas() throws SQLException {

        String query_recommended = "SELECT * FROM Peliculas ORDER BY RAND() LIMIT 10";
        List<Pelicula> movies_recommended = new ArrayList<>();

        try(PreparedStatement st = connection.prepareStatement(query_recommended)){

            // execute select SQL stetement
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setAnyo(rs.getInt("anyo"));
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setDescripcion(rs.getString("descripcion"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setTrailer(rs.getString("trailer"));
                pelicula.setCreador(rs.getInt("creador"));
                pelicula.setBloqueado(rs.getInt("bloqueado"));

                movies_recommended.add(pelicula);
            }

        }
        return movies_recommended;
    }


    /**
     * En la Home, carga las películas más comentadas
     *
     * @param NONE
     * @return lista de películas más comentadas (max 10)
     */
    public List<Pelicula> cargar_pelis_mas_comentadas() throws SQLException {

        String query_commented = "SELECT * FROM Peliculas INNER JOIN Comentarios ON Peliculas.id=Comentarios.pelicula GROUP BY Comentarios.pelicula ORDER BY COUNT(Comentarios.pelicula) DESC LIMIT 10;";
        List<Pelicula> movies_commented = new ArrayList<>();

        try(PreparedStatement st = connection.prepareStatement(query_commented)){

            // execute select SQL stetement
            ResultSet rs = st.executeQuery();

            while (rs.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setAnyo(rs.getInt("anyo"));
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setDescripcion(rs.getString("descripcion"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setGenero(rs.getString("genero"));
                pelicula.setTrailer(rs.getString("trailer"));
                pelicula.setCreador(rs.getInt("creador"));
                pelicula.setBloqueado(rs.getInt("bloqueado"));

                movies_commented.add(pelicula);
            }

        }
        return movies_commented;
    }





    /**
     * Checkea en la DB si el usuario y la contraseña coinciden en la base de datos
     *
     * @param id de usuario userid
     * @param contrasenya OLD password of the user
     * @return devuelve true si existe, false si no
     */
    public boolean check_cambio_password(int userid, String contrasenya) throws SQLException {

        boolean result = false;
        String query = "SELECT * FROM Usuarios WHERE BINARY Usuarios.id=? AND BINARY Usuarios.contrasenya=?";

        try(PreparedStatement st = connection.prepareStatement(query)){

            st.setInt(1, userid);
            st.setString(2, contrasenya);
            ResultSet rs = st.executeQuery();

            while(rs.next()){ //User found and query OK
                result = true;
            }
        }
        return result;

    }


    public static int GetImageFormat(int[] array){
        int[] png = new int[] { 137, 80, 78, 71 };    // PNG
        //int[] tiff = new int[] { 73, 73, 42 };         // TIFF
        //int[] tiff2 = new int[] { 77, 77, 42 };         // TIFF
        int[] jpeg = new int[] { 255, 216, 255, 224 }; // jpeg
        int[] jpeg2 = new int[] { 255, 216, 255, 225 }; // jpeg canon

        for(int i = 0; i < 4; i++){
            if(array[i] != png[i]){
                break;
            }
            if (i==3){
              return 3; //PNG
            }
        }

        for(int i = 0; i < 4; i++){
            if(array[i] != jpeg[i]){
                break;
            }
            if (i==3){
              return 5; //JPEG
            }
        }

        for(int i = 0; i < 4; i++){
            if(array[i] != jpeg2[i]){
                break;
            }
            if (i==3){
              return 5; //JPEG
            }

        }

        return 0; //UNKNOWN
    }


    public String getMimeType(byte data[]) throws IOException {
    		InputStream is = new BufferedInputStream(new ByteArrayInputStream(data));
    		String mimeType = URLConnection.guessContentTypeFromStream(is);
    		return mimeType;
    }



  public static void enviarConGMail(String destinatario) {
    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente tambiÃ©n.
    String remitente = "manlooAW";  //Para la direcciÃ³n nomcuenta@gmail.com
    String asunto="Bienvenido a Manloo";
    String cuerpo="Saludos Usuario, muchas gracias por registrarte en nuestra plataforma";
    String clave = "manloo123";
    try {
    Properties props = new Properties();
    props.setProperty("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
    props.setProperty("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
    props.setProperty("mail.smtp.port", "587"); //El puerto SMTP seguro de Google
    props.setProperty("mail.smtp.user", remitente);
    //props.setProperty("mail.smtp.clave", clave);    //La clave de la cuenta
    props.setProperty("mail.smtp.auth", "true");    //Usar autenticaciÃ³n mediante usuario y clave



    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);


        message.setFrom(new InternetAddress(remitente));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrÃ­an aÃ±adir varios de la misma manera
        message.setSubject(asunto);
        message.setText(cuerpo);
//
        Transport transport = session.getTransport("smtp");
        transport.connect(remitente, clave);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    catch (MessagingException me) {
        me.printStackTrace();   //Si se produce un error
    }
}

}
