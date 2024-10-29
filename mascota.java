package petPals;

public class mascota {

	 private int idMascota;
	    private String nombre;
	    private int edad;
	    private String raza;
	    private String comportamiento;
	    private double peso;
	    private double altura;
	    private String patologias;
	    private String observaciones;

	   
	    public mascota(int idMascota, String nombre, int edad, String raza, String comportamiento, double peso, double altura, String patologias, String observaciones) {
	        this.idMascota = idMascota;
	        this.nombre = nombre;
	        this.edad = edad;
	        this.raza = raza;
	        this.comportamiento = comportamiento;
	        this.peso = peso;
	        this.altura = altura;
	        this.patologias = patologias;
	        this.observaciones = observaciones;
	    }

	    
	    public int getIdMascota() {
	        return idMascota;
	    }

	    public void setIdMascota(int idMascota) {
	        this.idMascota = idMascota;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public int getEdad() {
	        return edad;
	    }

	    public void setEdad(int edad) {
	        this.edad = edad;
	    }

	    public String getRaza() {
	        return raza;
	    }

	    public void setRaza(String raza) {
	        this.raza = raza;
	    }

	    public String getComportamiento() {
	        return comportamiento;
	    }

	    public void setComportamiento(String comportamiento) {
	        this.comportamiento = comportamiento;
	    }

	    public double getPeso() {
	        return peso;
	    }

	    public void setPeso(double peso) {
	        this.peso = peso;
	    }

	    public double getAltura() {
	        return altura;
	    }

	    public void setAltura(double altura) {
	        this.altura = altura;
	    }

	    public String getPatologias() {
	        return patologias;
	    }

	    public void setPatologias(String patologias) {
	        this.patologias = patologias;
	    }

	    public String getObservaciones() {
	        return observaciones;
	    }

	    public void setObservaciones(String observaciones) {
	        this.observaciones = observaciones;
	    }
	
}
