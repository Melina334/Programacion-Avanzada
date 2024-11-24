package BLL;

public class tratamiento {

	  private int idTratamiento;
	    private String descripcion;
	    private String medicamentos;
	    private String dosis;
	    private String frecuencia;
	    private String fechaInicio;
	    private String fechaFin;

	    
	    public tratamiento(int idTratamiento, String descripcion, String medicamentos, String dosis, String frecuencia, String fechaInicio, String fechaFin) {
	        this.idTratamiento = idTratamiento;
	        this.descripcion = descripcion;
	        this.medicamentos = medicamentos;
	        this.dosis = dosis;
	        this.frecuencia = frecuencia;
	        this.fechaInicio = fechaInicio;
	        this.fechaFin = fechaFin;
	    }

	    public int getIdTratamiento() {
	        return idTratamiento;
	    }

	    public void setIdTratamiento(int idTratamiento) {
	        this.idTratamiento = idTratamiento;
	    }

	    public String getDescripcion() {
	        return descripcion;
	    }

	    public void setDescripcion(String descripcion) {
	        this.descripcion = descripcion;
	    }

	    public String getMedicamentos() {
	        return medicamentos;
	    }

	    public void setMedicamentos(String medicamentos) {
	        this.medicamentos = medicamentos;
	    }

	    public String getDosis() {
	        return dosis;
	    }

	    public void setDosis(String dosis) {
	        this.dosis = dosis;
	    }

	    public String getFrecuencia() {
	        return frecuencia;
	    }

	    public void setFrecuencia(String frecuencia) {
	        this.frecuencia = frecuencia;
	    }

	    public String getFechaInicio() {
	        return fechaInicio;
	    }

	    public void setFechaInicio(String fechaInicio) {
	        this.fechaInicio = fechaInicio;
	    }

	    public String getFechaFin() {
	        return fechaFin;
	    }

	    public void setFechaFin(String fechaFin) {
	        this.fechaFin = fechaFin;
	    }
	
}
