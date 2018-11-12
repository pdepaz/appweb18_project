package proyecto;

public class Usuario {
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
    private String email;
	//private String foto;
	private int telefono;
    private String usuario;
    private String contrasenya;
    private String tipo_usuario;
    private int bloqueado;
	

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido1() {
		return apellido1;
	}


	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}


	public String getApellido2() {
		return apellido2;
	}


	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getContrasenya() {
		return contrasenya;
	}


	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
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
}

