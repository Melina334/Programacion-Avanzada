package petPals;

public class factura {

	 private int idFactura;
	    private String fecha;
	    private double total;
	    private String estado;

	  
	    public factura(int idFactura, String fecha, double total, String estado) {
	        this.idFactura = idFactura;
	        this.fecha = fecha;
	        this.total = total;
	        this.estado = estado;
	    }

	    public int getIdFactura() {
	        return idFactura;
	    }

	    public void setIdFactura(int idFactura) {
	        this.idFactura = idFactura;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }

	    public double getTotal() {
	        return total;
	    }

	    public void setTotal(double total) {
	        this.total = total;
	    }

	    public String getEstado() {
	        return estado;
	    }

	    public void setEstado(String estado) {
	        this.estado = estado;
	    }
	
}
