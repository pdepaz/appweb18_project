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

    private void connect() throws NamingException, SQLException {
        // TODO: program this method
        Context initCtx = new InitialContext();
        Context envCtx = (Context) initCtx.lookup("java:comp/env");
        DataSource ds = (DataSource) envCtx.lookup("jdbc/proyecto");
        connection = ds.getConnection();
    }

    
    /**
     * Close the connection to the database if it is still open.
     *
     */
    public void close() throws SQLException{ //Se va a llamar automaticamente por el hecho de usar un servlet como se ha explicado en clase...
        if (connection != null) {
            connection.close();
        }
        connection = null;
    }


    
    /**
     * Check in the database if the user and password given by arguments exist in the DB
     *
     * @param usuario username.
     * @return 1 if correct, 0 if it doesn't exist, -1 if error (nothing introduced...)
     */
    public int iniciarSesion(String usuario, String contrasenya) throws SQLException {
        
        if (usuario = "" || contrasenya = ""){
            return -1;
        }
        
        String query = "SELECT Usuarios.usuario FROM Usuarios WHERE Usuario.usuario=? AND Usuario.contrasenya=?";
        
        try (PreparedStatement st = connection.prepareStatement(query)) {
        // Se insertan los valores en la consulta :
            st.setString(1, usuario);
            st.setString(2, contrasenya);
            // execute select SQL stetement
            ResultSet rs = st.executeQuery();
        }
        
    
        if (rs != NULL) {
            return 1;
        } else {
            return 0;
        }

    } 
        
        

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
