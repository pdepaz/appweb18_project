package proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


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
        
        String query = "SELECT * FROM Usuarios WHERE Usuarios.usuario=? AND Usuarios.contrasenya=?";
        
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
        
       String query = "SELECT * FROM Usuarios WHERE Usuario.email=? OR Usuario.usuario=?";
        
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
     * Create username in the DB. Compulsory fields to input by user shown below. By default, create a user "no bloqueado"
     *
     * @param usuario 
     * @return 1 if correct, -1 if error (somefields not introduced)
     */
    public int crearUsuario(Usuario usuario) throws SQLException {
    
        //Verificar que los datos que me llegan están bien (de los obligatorios)
        //No va a tener id todavía... el id se le asignará en la base de datos... 
        // int id = usuario.getId();
         String nombre = usuario.getNombre();
         String apellido1 = usuario.getApellido1();
         String apellido2= usuario.getApellido2();
         String email = usuario.getEmail(); 
         int telefono = usuario.getTelefono();
         String nombre_usuario = usuario.getUsuario();
         String contrasenya = usuario.getContrasenya();
         String tipo_usuario = usuario.getTipo_usuario();
         int bloqueado = usuario.getBloqueado();
        
        if (nombre.equals("") || apellido1.equals("") || email.equals("") || contrasenya.equals("") || nombre_usuario.equals("")){
            return -1;
        }
        
        if (verificarExistenciaUsuario(email, nombre_usuario)){
            return -1; //Usuario ya existe
        }
        
        //A partir de aqui, ya sabemos que el usuario NO existe en nuestra base de datos
        if(apellido2.equals("")){
            apellido1 = null;
        }
        /*if(foto.equals("")){
            foto = null;
        }
        if(telefono == null){
            telefono = null;
        }*/
        if(tipo_usuario.equals("")){
            tipo_usuario = null;
        }
        
        

        String query = "INSERT INTO Usuarios (nombre, apellido1, apellido2, email, telefono, contrasenya, usuario, tipo_usuario, bloqueado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, 0)";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, nombre);
            st.setString(2, apellido1);
            st.setString(3, apellido2);
            st.setString(4, email);
            //está dando error porque la foto es un not null... Hay que meterle alguna foto....
            //st.setString(5, foto);
            st.setInt(5, telefono);
            st.setString(6, contrasenya);
            st.setString(7, nombre_usuario);
            st.setString(8, tipo_usuario);

            // execute select SQL stetement
            st.executeUpdate();
            
        }
        return 1;
    } 

     /**
            Actualiza los datos de un usuario     *
     * @param usuario 
     * @return 1 if correct, -1 if error (somefields not introduced)
     */
    public int actualizaUsuario(Usuario usuario) throws SQLException {
        
        String query = "UPDATE Usuarios SET nombre = ?, apellido1 =?, apellido2 = ?, email =?, telefono =?, contrasenya= ? WHERE  Usuarios.id = ?";

        try (PreparedStatement st = connection.prepareStatement(query)) {

            st.setString(1, usuario.getNombre());
            st.setString(2, usuario.getApellido1());
            st.setString(3, usuario.getApellido2());
            st.setString(4, usuario.getEmail());
            st.setInt(5, usuario.getTelefono());
            st.setString(6, usuario.getContrasenya());
            st.setInt(7,usuario.getId());
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
                
                bloqueado = rs.getInt("bloqueado");
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
    public int creaComentario(Comentario comment) throws SQLException {
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
        
        String query = "INSERT INTO Comentarios (comentario_text, tipo_tema, pelicula,serie,libro,usuario,fecha_creacion,comentario_padre,bloqueado) VALUES (?,?,?,?,?,?)";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            
            switch(comment.getTipo_tema()){
            
            case "Pelicula":
                st.setString(1, comment.getComentario_text());
                st.setString(2, "Pelicula");
                st.setInt(3, comment.getPelicula());
                st.setInt(4, 0);
                st.setInt(5, 0);
                st.setInt(6, comment.getUsuario());
                st.setString(7,"2010-10-10 10:10:10");
                st.setInt(8, comment.getComentario_padre());
                st.setInt(9, 0);
                break;
            
            case "Serie":
                st.setString(1, comment.getComentario_text());
                st.setString(2, "Serie");
                st.setInt(3, 0);
                st.setInt(4, comment.getSerie());
                st.setInt(5, 0);
                st.setInt(6, comment.getUsuario());
                st.setString(7, "2010-10-10 10:10:10");
                st.setInt(8, comment.getComentario_padre());
                st.setInt(9, 0);
                break;
            
            case "Libro":             
                st.setString(1, comment.getComentario_text());
                st.setString(2, "Libro");
                st.setInt(3, 0);
                st.setInt(4, 0);
                st.setInt(5, comment.getLibro());
                st.setInt(6, comment.getUsuario());
                st.setString(7,"2010-10-10 10:10:10");
                st.setInt(8, comment.getComentario_padre());
                st.setInt(9, 0);
                break;
            
            case "default":
                return -1;
            }
            
          st.executeUpdate();
          return 1; 
        }
        

    } 

    /*
    Crear Pelicula: Anade una pelicula a la base de datos.
    @param un objeto pelicula

    */
    //PROBLEMA CON PORTADA, BLOB NOT NULL

        public void creaPelicula(Pelicula pelicula) throws SQLException {

                String query_pelicula = "INSERT INTO Peliculas (titulo, anyo, duracion, descripcion, director, genero, trailer, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?)";
                
                try(PreparedStatement st = connection.prepareStatement(query_pelicula)){
                    st.setString(1, pelicula.getTitulo());
                    st.setInt(2, pelicula.getAnyo());
                    st.setInt(3, pelicula.getDuracion());
                    st.setString(4, pelicula.getDescripcion());
                    st.setString(5,pelicula.getDirector());
                    st.setString(6,pelicula.getGenero());                    
                    //st.setString(7,pelicula.getportada());
                    st.setString(7,pelicula.getTrailer());
                    st.setInt(8,pelicula.getCreador()); 
                    st.setInt(9,pelicula.getBloqueado());
                    
                    st.executeUpdate();
                }


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
        if(!isModerador(id)){
            return false;
        }
        
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
        if(!isModerador(id)){
            return false;
        }        

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
        if(!isModerador(id)){
            return false;
        }
        
        switch(tipo){
            case "Peliculas":
                
                String query_bloquear_pelicula = "UPDATE Peliculas SET Peliculas.bloqueado=1 WHERE Peliculas.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_pelicula)){
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
                
                break;
                
            case "Libros":
                
                String query_bloquear_libro = "UPDATE Libros SET Libros.bloqueado=1 WHERE Libros.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_libro)){
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
        if(!isModerador(id)){
            return false;
        }
        
        switch(tipo){
            case "Peliculas":
                
                String query_desbloquear_pelicula = "UPDATE Peliculas SET Peliculas.bloqueado=0 WHERE Peliculas.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_pelicula)){
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
                break;
                
            case "Libros":
            
                String query_desbloquear_libro = "UPDATE Libros SET Libros.bloqueado=0 WHERE Libros.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_libro)){
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
        if(!isModerador(id)){
            return false;
        }
        
        String query_bloquear_usuario = "UPDATE Usuarios SET Usuarios.bloqueado=1 WHERE Usuarios.id=?";
        
        try(PreparedStatement st = connection.prepareStatement(query_bloquear_usuario)){
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
        if(!isModerador(id)){
            return false;
        }
        
        String query_desbloquear_usuario = "UPDATE Usuarios SET Usuarios.bloqueado=0 WHERE Usuarios.id=?";
        
        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_usuario)){
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
                user.setTelefono(rs.getInt("telefono"));
                user.setContrasenya(rs.getString("contrasenya"));
                user.setUsuario(rs.getString("usuario"));
                user.setTipo_usuario(rs.getString("tipo_usuario"));
                user.setBloqueado(rs.getInt("bloqueado"));
            }
            
        }
        return user;
    }
/*
*     
*       Creo una funcion que obtiene el usuario gracias al nombre de usuario
*       Copio la de arriba pero modifico la secuencia sql 
*       Puede no funcionar
*
*/

    //Carga el usuario devolviendo true si lo consigue o false si no lo consigue
    public Usuario cargar_usuario_nombreusuario(String nombreusuario) throws SQLException { 
        Usuario user = new Usuario(); //Objeto de la clase Usuario
        String query_usuario = "SELECT * FROM Usuarios WHERE Usuarios.usuario = ?";
        try(PreparedStatement st = connection.prepareStatement(query_usuario)){
            st.setString(1, nombreusuario);            
            ResultSet rs = st.executeQuery();
            
            while (rs.next()){ //OK, SQL return something
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setApellido1(rs.getString("apellido1"));
                user.setApellido2(rs.getString("apellido2"));
                user.setEmail(rs.getString("email"));
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
                    comment.setFecha_creacion(rs.getString("fecha_creacion"));
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
                    comment.setFecha_creacion(rs.getString("fecha_creacion"));
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
                    comment.setFecha_creacion(rs.getString("fecha_creacion"));
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
        String query = "SELECT * FROM Usuarios WHERE Usuarios.id=? AND Usuarios.contrasenya=?";

        try(PreparedStatement st = connection.prepareStatement(query)){
            
            st.setInt(1, userid);
            st.setString(2, contrasenya);           
            ResultSet rs = st.executeQuery();
            
            if(rs.getInt("id") == userid){ //User found and query OK
                result = true;
            }
        }
        return result;
        
    } 
}
