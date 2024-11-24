package BLL;

public class servicio {

	
	 private int idServicio;
	    private String tipo;
	    private String descripcion;
	    private double precio;
	    private String duracion;
	    private String fecha;
	    private String hora;


	    public servicio(int idServicio, String tipo, String descripcion, double precio, String duracion, String fecha, String hora) {
	        this.idServicio = idServicio;
	        this.tipo = tipo;
	        this.descripcion = descripcion;
	        this.precio = precio;
	        this.duracion = duracion;
	        this.fecha = fecha;
	        this.hora = hora;
	    }

	    public int getIdServicio() {
	        return idServicio;
	    }

	    public void setIdServicio(int idServicio) {
	        this.idServicio = idServicio;
	    }

	    public String getTipo() {
	        return tipo;
	    }

	    public void setTipo(String tipo) {
	        this.tipo = tipo;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public double getPrecio() {
	        return precio;
	    }

	    public void setPrecio(double precio) {
	        this.precio = precio;
	    }

	    public String getDuracion() {
	        return duracion;
	    }

	    public void setDuracion(String duracion) {
	        this.duracion = duracion;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }

	    public String getHora() {
	        return hora;
	    }

	    public void setHora(String hora) {
	        this.hora = hora;
	    }
	
}
