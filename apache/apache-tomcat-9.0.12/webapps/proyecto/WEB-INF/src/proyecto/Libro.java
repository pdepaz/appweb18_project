package proyecto;

public class Libro {
	private int id;
	private String titulo;
	private int anyo;
<<<<<<< HEAD
    	private int paginas;
    	private String escritor;
    	private String editorial;
    	private String genero;
    	//Array de bytes String portada;
    	private int creador;
    	private int bloqueado;
    
    
    
=======
    private int paginas;
    private String escritor;
    private String editorial;
    private String genero;
    //private String portada;
    private int creador;
    private int bloqueado; 
>>>>>>> 2b74dfaa40482d3bd5a59e7b625147eb96cda8cf
    
    
	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", escritor=" + escritor + ", editorial=" + editorial + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getEscritor() {
		return escritor;
	}
	public void setEscritor(String escritor) {
		this.escritor = escritor;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getCreador() {
		return creador;
	}
	public void setCreador(int creador) {
		this.creador = creador;
	}
	public int getBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(int bloqueado) {
		this.bloqueado = bloqueado;
	}
    
   
}

