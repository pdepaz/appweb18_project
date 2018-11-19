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
     * @return 1 if correct, 0 if it doesn't exist, -1 if error (nothing introduced...)
     */
    public int iniciarSesion(String usuario, String contrasenya) throws SQLException {
        
        if (usuario.equals("")  || contrasenya.equals("")){
            return -1;
        }
        
        String query = "SELECT Usuarios.usuario FROM Usuarios WHERE Usuario.usuario=? AND Usuario.contrasenya=?";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, usuario);
            st.setString(2, contrasenya);
            // execute select SQL stetement
            ResultSet rs = st.executeQuery();
            
            if (rs != null) { //Existe usuario
                return 1;
            } else { //No existe
                return 0;
            }
        }

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
        
       String query = "SELECT Usuarios.usuario FROM Usuarios WHERE Usuario.email=? OR Usuario.usuario=?";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, email);
            st.setString(2, usuario);
            // execute select SQL stetement
            ResultSet rs = st.executeQuery();
            
            if (rs != null) {
                return false; //Doesn't exists
            } else { 
                return true; //User exists
            }
        }
    }         
        
        if (rs != NULL) {
            return 1;
        } else {
            return 0;

    /**
     * Create username in the DB. Compulsory fields to input by user shown below. By default, create a user "no bloqueado"
     *
     * @param nombre compulsory
     * @param apellido1 compulsory
     * @param apellido2
     * @param email compulsory
     * @param foto
     * @param telefono
     * @param contrasenya compulsory
     * @param usuario compulsory
     * @param tipo_usuario (if nothing clicked by the user, normal user by default)    
     * @return 1 if correct, -1 if error (somefields not introduced)
     */
    public int crearUsuario(String nombre, String apellido1, String apellido2, String email, String foto, int telefono, String contrasenya, String usuario, String tipo_usuario) throws SQLException {
    
        //Verificar que los datos que me llegan están bien (de los obligatorios)
        
        if (nombre.equals("") || apellido1.equals("") || email.equals("") || contrasenya.equals("") || usuario.equals("")){
            return -1;
        }
        
        if (verificarExistenciaUsuario(email, usuario)){
            return -1; //Usuario ya existe
        }
        
        //A partir de aqui, ya sabemos que el usuario NO existe en nuestra base de datos
        if(apellido2.equals("")){
            apellido1 = null;
        }
        if(foto.equals("")){
            foto = null;
        }
        if(telefono.equals("")){
            telefono = null;
        }
        if(tipo_usuario.equals("")){
            tipo_usuario = null;
        }
        
        

        String query = "INSERT INTO Usuarios (nombre, apellido1, apellido2, email, foto, telefono, contrasenya, usuario, tipo_usuario, bloqueado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, nombre);
            st.setString(2, apellido1);
            st.setString(3, apellido2);
            st.setString(4, email);
            st.setString(5, foto);
            st.setInt(6, telefono);
            st.setString(7, contrasenya);
            st.setString(8, usuario);
            st.setString(9, tipo_usuario);
            st.setString(10, 0);

            // execute select SQL stetement
            st.executeUpdate();
            
        }

    } 
/********
isBloqueado checkea si usuario está bloqueado
devuelve bloqueado dentro de usuarios 
1 si bloqueado 0 si no está bloqueado.
@param id de usuario

*******/
public int isBloqueado(int id){

String query = "SELECT bloqueado From Usuarios WHERE Usuarios.id = ?;"

 try (PreparedStatement st = connection.prepareStatement(query)) {
 
        st.setInt(1, id);
        ResultSet rs =  st.executeQuery();
        
        int bloqueado = rs.getInt("bloqueado");
    }
    // 1 si bloqueado 0 si no
return bloqueado;



}



/**
     * Crear Comentario
     *
     * @param TO-DO
     * @return 1 if correct, 0 if not created, -1 if error
     */
    public int creaComentario(String comentario_text, String tipo_tema, int idTema,int usuario, int comentario_padre, int es_respuesta) throws SQLException {
        //El usuario que cree un comentario solo verá el botón de comentar si existe de manera que no verifico si existe porque se hará en otro lado
        //El comentario vendrá a traves de un formulario del que podremos obtener quien es el usuario y su id.

       
        
        //comprobamos si la cadena introducida es espacio vacio o si el usuario está bloqueado
        if(comentario_text.equals("") || isBloqueado(usuario)==1){
            return -1;
        }
        
        if(es_respuesta == 0){
            comentario_padre = 0;
        }
        
        
        //CHECK SECURITY
        if(comentario_text.contains("<") ||comentario_text.contains(">") || comentario_text.contains("SELECT")){
        return -1
        }
        
        String query = "INSERT INTO Comentarios (comentario_text, tipo_tema, pelicula,serie,libro,usuario,fecha_creacion,comentario_padre,bloqueado) VALUES (?,?,?,?,?,?)";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            
            switch(tipo_tema){
            
            case "Pelicula":
                st.setString(1, comentario_text);
                st.setString(2, "Pelicula");
                st.setString(3, idTema);
                st.setString(4, null);
                st.setString(5, null);
                st.setInt(6, usuario);
                st.SetString(7,"2010-10-10 10:10:10");
                st.setInt(8, comentario_padre);
                st.setInt(9, 0);
                break;
            
            case "Serie":
                st.setString(1, comentario_text);
                st.setString(2, "Serie");
                st.setString(3, null);
                st.setString(4, idTema);
                st.setString(5, null);
                st.setInt(6, usuario);
                st.SetString(7, "2010-10-10 10:10:10");
                st.setInt(8, comentario_padre);
                st.setInt(9, 0);
                break;
            
            case "Libro":             
                st.setString(1, comentario_text);
                st.setString(2, "Libro");
                st.setString(3, null);
                st.setString(4, null);
                st.setString(5, idTema);
                st.setInt(6, usuario);
                st.SetString(7,"2010-10-10 10:10:10");
                st.setInt(8, comentario_padre);
                st.setInt(9, 0);
                break;
            
            case Default
                return -1;
                break;
            }
            
          st.executeUpdate();
          return 1; 
        }
        

    } 
     /**
     * Crear Tema
     *  
                Añadimos un tema a la base de datos 
     * @param Tipo_tema
     * @param objeto
     *                     
     * @return 1 if correct, 0 if not created, -1 if error
     */
    public int creaTema(String tipo_tema, Object objeto) throws SQLException {
    
         if(comentario_text.equals("") || isBloqueado(usuario)==1){
            return -1;
        }
                
        switch(tipo_tema){
            case "Peliculas":
                
                Pelicula pelicula = (Pelicula) objeto;
                
                String query_pelicula = "INSERT INTO Peliculas (titulo, anyo, duracion, pais, director, genero, portada, trailer, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?,?)";
                
                try(PreparedStatement st = connection.prepareStatement(query_pelicula)){
                    st.setString(1, pelicula.getTitulo());
                    st.setInt(2, pelicula.getAnyo());
                    st.setInt(3, pelicula.getDuracion());
                    st.setInt(4, pelicula.getPais());
                    st.setString(5,pelicula.getDirector());
                    st.setString(6,pelicula.getGenero());                    st.setString(6,pelicula.getportada());
                    st.setString(7,pelicula.getTrailer());
                    st.setint(8,pelicula.getCreador()); st.setInt(9,pelicula.getBloqueado());
                    
                    st.executeUpdate();
                }
                break;
                
            case "Series":

                Serie serie = (Serie) objeto;

                String query_serie = "INSERT INTO Series (titulo, anyo, temporadas, capitulos, pais, genero, portada, trailer, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?,?)";
                try(PreparedStatement st = connection.prepareStatement(query_serie)){
                    st.setString(1, serie.getTitulo());
                    st.setInt(2, serie.getAnyo());
                    st.setInt(3, serie.getTemporadas());
                    st.setInt(4, serie.getCapitulos());
                    st.setInt(5,serie.getPais());
                    st.setString(6,serie.getGenero());
                    st.setString(7,serie.getPortada());
                    st.setString(6,pelicula.getTrailer());
                    st.setint(8,serie.getCreador()); st.setInt(9,serie.getBloqueado());
                    
                    st.executeUpdate();
                }
                
                break;
                
            case "Libros":
                Libro libro= (Libro) objeto;
                
                String query_libro = "INSERT INTO Libros (titulo, anyo, paginas, escritor, editorial, genero, portada, creador, bloqueado) VALUES (?,?,?,?,?,?,?,?,?,?)";
                try(PreparedStatement st = connection.prepareStatement(query_libro)){
                    st.setString(1, libro.getTitulo());
                    st.setInt(2, libro.getAnyo());
                    st.setInt(3, libro.getPaginas());
                    st.setString(4, libro.getEscritor());
                    st.setString(4, libro.getEditorial());
                    st.setString(6,libro.getGenero());
                    st.setString(7,libro.getPortada());
                    st.setint(8,libro.getCreador()); st.setInt(9,libro.getBloqueado());
                    st.executeUpdate();
                
                }
                break;      
                
            case Default
                return -1;
                break;   
        }
        
          return 1; 
        }
        

    } 
    
    public boolean bloquear_comentario(int id){ //Pasamos el id del comentario que queremos bloquear
        String query_bloquear_comentario = "UPDATE Comentarios SET Comentarios.bloqueado=1 WHERE Comentarios.id=?";
        try(PreparedStatement st = connection.prepareStatement(query_bloquear_comentario)){
            st.setInt(1, 1);
        }
        st.executeUpdate();
        return true;
    }
    
    
    public boolean bloquear_tema(String tipo, int id){//Pasamos el id del tema y el tema que queremos bloquear
        switch(tipo){
            case 'Peliculas':
                String query_bloquear_pelicula = "UPDATE Peliculas SET Peliculas.bloqueado=1 WHERE Peliculas.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_pelicula)){
                    st.setInt(1, 1);
                }
                st.executeUpdate();
                break;
            case 'Series':
                String query_bloquear_serie = "UPDATE Series SET Series.bloqueado=1 WHERE Series.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_serie)){
                    st.setInt(1, 1);
                }
                st.executeUpdate();
                break;
            case 'Libros':
                String query_bloquear_libro = "UPDATE Libros SET Libros.bloqueado=1 WHERE Libros.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_bloquear_libro)){
                    st.setInt(1, 1);
                }
                st.executeUpdate();
                break;
        }
        return true;
    }
    
    
    public boolean bloquear_usuario(int id){//Pasamos el id del usuario que queremos bloquear
        String query_bloquear_usuario = "UPDATE Usuarios SET Usuarios.bloqueado=1 WHERE Usuarios.id=?";
        try(PreparedStatement st = connection.prepareStatement(query_bloquea_usuario)){
            st.setInt(1, 1);
        }
        st.executeUpdate();
        return true;
    }
    
    
    public boolean desbloquear_tema(String tipo, int id){//Pasamos el id del tema y el tema que queremos desbloquear
        switch(tipo){
            case 'Peliculas':
                String query_desbloquear_pelicula = "UPDATE Peliculas SET Peliculas.bloqueado=0 WHERE Peliculas.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_pelicula)){
                    st.setInt(1, 0);
                }
                st.executeUpdate();
                break;
            case 'Series':
                String query_desbloquear_serie = "UPDATE Series SET Series.bloqueado=0 WHERE Series.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_serie)){
                    st.setInt(1, 0);
                }
                st.executeUpdate();
                break;
            case 'Libros':
                String query_desbloquear_libro = "UPDATE Libros SET Libros.bloqueado=0 WHERE Libros.id=?";
                try(PreparedStatement st = connection.prepareStatement(query_desbloquear_libro)){
                    st.setInt(1, 0);
                }
                st.executeUpdate();
                break;
        }
        return true;
    }
    public boolean desbloquear_comentario(int id){//Pasamos el id del comentario que queremos desbloquear
        String query_bloquear_película = "UPDATE Comentarios SET Comentarios.bloqueado=1 WHERE Comentarios.id=?";
        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_comentario)){
            st.setInt(1, 0);
        }
        st.executeUpdate();
        return true;
    }
    public boolean desbloquear_usuario(int id){//Pasamos el id del usuario que queremos desbloquear
        String query_desbloquear_usuario = "UPDATE Usuarios SET Usuarios.bloqueado=1 WHERE Usuarios.id=?";
        try(PreparedStatement st = connection.prepareStatement(query_desbloquear_usuario)){
            st.setInt(1, 0);
=======
    public boolean isModerador(int id){
        
        String query_is = "SELECT tipo_usuario FROM Usuarios WHERE id=?";
        
        try(PreparedStatement st = connection.prepareStatement(query_is)){
            st.setInt(1, id);            
            ResultSet rs = st.executeQuery();
            
            if (!rs.equals("MODERADOR"){
                return false;
            }
            return true;
>>>>>>> 2e1981cf11b0d3c57aedd4b04744bba44ccec499
        }
    }
    
    /**
     * Bloquear un comentario (hecho por moderadores)
     *
     * @param id id del comentario que queremos bloquear
     * @return true = bloqueado
     */
    public boolean bloquear_comentario(int id){ //Pasamos el id del comentario que queremos bloquear
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
    public boolean desbloquear_comentario(int id){//Pasamos el id del comentario que queremos desbloquear
        isModerador(id);
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
    public boolean bloquear_tema(String tipo, int id){
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
    public boolean desbloquear_tema(String tipo, int id){//Pasamos el id del tema y el tema que queremos desbloquear
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
    public boolean bloquear_usuario(int id){
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
    public boolean desbloquear_usuario(int id){
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





//-----------------------------------------------------------------------------------------------------------------------------

    /**
     * Search book by ISBN.
     *
     * @param isbn The ISBN of the book.
     * @return The Book object, or null if not found.
     * @throws SQLException If somthing fails with the DB.
     */
    public Book searchBook(String isbn) throws SQLException {
        // TODO: program this method

	String query = "SELECT Libros.titulo, Libros.isbn, Libros.anyo, Libros.id FROM Libros WHERE Libros.isbn = " + isbn;
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(query);

	Book libro = new Book();
	while(rs.next()){
	    libro.setTitle(rs.getString("titulo"));
	    libro.setIsbn(Integer.toString(rs.getInt("isbn")));
	    libro.setYear(rs.getInt("anyo"));
	    libro.setId(rs.getInt("id"));
	    System.out.println("Nuevo libro: " + libro.getTitle() + ", (" + libro.getIsbn() + "), " + libro.getYear() + ".");
	}

	rs.close();
	stmt.close();
    return libro;
    }

    /**
     * Sell a book.
     *
     * @param book The book.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If somthing fails with the DB.
     */
    public boolean sellBook(Book book, int units) throws SQLException {
        return sellBook(book.getId(), units);
    }

    /**
     * Sell a book.
     *
     * @param book The book's identifier.
     * @param units Number of units that are being sold.
     * @return True if the operation succeeds, or false otherwise
     *         (e.g. when the stock of the book is not big enough).
     * @throws SQLException If something fails with the DB.
     */
    public boolean sellBook(int book, int units) throws SQLException {
        // TODO: program this method
        //boolean success = false;
        //connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
        //connection.setAutoCommit(false);
        
        String query_insertar = "INSERT INTO Ventas (fecha, libro, unidad_vend) VALUES (NOW(), " + book + ", " + units + ")";
        
            int stock_libro = getStock(book);
            if (stock_libro != 0){ //Si hay existencias
                System.out.println("Hay " + stock_libro + " existencias del libro con ID " + book + ".");
                //stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
                try(Statement stmt = connection.createStatement()){
                    stmt.executeUpdate(query_insertar);
                    
                    stmt.close();
                };
                
                //ResultSet rs = stmt.getGeneratedKeys();
                System.out.println("Venta del ibro con ID " + book + ", OK!");
            
                
                
                //Quitar de las existencias
                                
                int nuevo_valor_existencias = stock_libro - units;
                String query_quitar_existencia = "UPDATE Existencias SET Existencias.unidades=" + nuevo_valor_existencias + " WHERE Existencias.libro=" + book;
                
                try(Statement stmt = connection.createStatement()){
                    int rowCount2 = stmt.executeUpdate(query_quitar_existencia);
                    
                    stmt.close();
                };
                               
                            
                return true;
                
            } else { //No hay existencias del libro
                System.out.println("No hay suficientes existencias del libro con ID " + book + ".");
                return false;
            }
    }

    /**
     * Return a list with all the books in the database.
     *
     * @return List with all the books.
     * @throws SQLException If something fails with the DB.
     */
    public List<Book> listBooks() throws SQLException {
        // TODO: program this method
	List<Book> lista = new ArrayList<>(); //Since Java 7, we can remove the right handside parameter.

	String query = "SELECT Libros.titulo, Libros.isbn, Libros.anyo, Libros.id FROM Libros";
	Statement stmt = connection.createStatement();
	ResultSet rs = stmt.executeQuery(query);

	while (rs.next()){
        Book libro = new Book();
	    libro.setTitle(rs.getString("titulo"));
	    libro.setIsbn(Integer.toString(rs.getInt("isbn")));
	    libro.setYear(rs.getInt("anyo"));
	    libro.setId(rs.getInt("id"));
	    System.out.println("Nuevo libro: " + libro.getTitle() + ", (" + libro.getIsbn() + "), " + libro.getYear() + ".");
	    lista.add(libro);
	}

	rs.close();
	stmt.close();

	return lista;
    }
}
