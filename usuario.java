package GUI;

public class usuario {

	private String mail;
	private String contraseña;
	private String rol;
	private String nombre;

	
	

	public String getMail() {
		return mail;
	}

	public usuario(String mail, String contraseña, String rol, String nombre) {
		super();
		this.mail = mail;
		this.contraseña = contraseña;
		this.rol = rol;
		this.nombre = nombre;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "usuario [mail=" + mail + ", contraseña=" + contraseña + ", rol=" + rol + ", nombre=" + nombre + "]";
	}

}