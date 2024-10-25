package petPals;

public class usuario {

	 private String mail;
	    private String contraseña;
	    private String rol;

	  
	    public usuario(String mail, String contraseña, String rol) {
	        this.mail = mail;
	        this.contraseña = contraseña;
	        this.rol = rol;
	    }

	  
	    public String getMail() {
	        return mail;
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

	    @Override
	    public String toString() {
	        return "Usuario: " + mail + ", Rol: " + rol;
	    }
}
