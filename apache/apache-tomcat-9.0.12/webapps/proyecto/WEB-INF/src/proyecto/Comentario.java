package proyecto;
import java.sql.*;


public class Comentario {
	private int id;
	private String comentario_text;
	private String tipo_tema;
	private int pelicula;
    private int serie;
    private int libro;
	//private String foto;
	private int usuario;
	//Establecer esto como java date y hacer lo comentado en comentario guardar
    private java.sql.Date fecha_creacion;
    private int comentario_padre;
    private String tipo_usuario;
    private int bloqueado;
	
    public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getComentario_text() {
		return comentario_text;
	}
	
	public void setComentario_text(String comentario_text) {
		this.comentario_text = comentario_text;
	}
	
	public String getTipo_tema() {
		return tipo_tema;
	}
	
	public void setTipo_tema(String tipo_tema) {
		this.tipo_tema = tipo_tema;
	}
	
	public int getPelicula() {
		return pelicula;
	}
	
	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}
	
	public int getSerie() {
		return serie;
	}
	
	public void setSerie(int serie) {
		this.serie = serie;
	}
	
	public int getLibro() {
		return libro;
	}
	
	public void setLibro(int libro) {
		this.libro = libro;
	}
	
	public int getUsuario() {
		return usuario;
	}
	
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
	public java.sql.Date getFecha_creacion() {
		return fecha_creacion;
	}
	
	public void setFecha_creacion(java.sql.Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	public int getComentario_padre() {
		return comentario_padre;
	}
	
	public void setComentario_padre(int comentario_padre) {
		this.comentario_padre = comentario_padre;
	}
	
	public String getTipo_usuario() {
		return tipo_usuario;
	}
	
	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}
	
	public int getBloqueado() {
		return bloqueado;
	}
	
	public void setBloqueado(int bloqueado) {
		this.bloqueado = bloqueado;
	}
	
	 @Override
	public String toString() {
		return "Comentario [comentario_text=" + comentario_text + ", tipo_tema=" + tipo_tema +"]";
	}

}

