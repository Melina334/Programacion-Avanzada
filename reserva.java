package petPals;

public class reserva {

	 private int idReserva;
	    private String fechaReserva;
	    private String estado;

	    
	    public reserva(int idReserva, String fechaReserva, String estado) {
	        this.idReserva = idReserva;
	        this.fechaReserva = fechaReserva;
	        this.estado = estado;
	    }

	    public int getIdReserva() {
	        return idReserva;
	    }

	    public void setIdReserva(int idReserva) {
	        this.idReserva = idReserva;
	    }

	    public String getFechaReserva() {
	        return fechaReserva;
	    }

	    public void setFechaReserva(String fechaReserva) {
	        this.fechaReserva = fechaReserva;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }

	    // Metodos adicionales
	    public void verDetalleReserva() {
	        
	    }
	
}
