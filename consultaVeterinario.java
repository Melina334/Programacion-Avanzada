package petPals;

public class consultaVeterinario {

	    private int idConsulta;
	    private String fecha;
	    private String motivo;
	    private String diagnostico;
	    private String tratamiento;
	    private String observaciones;

	    // Constructor, getters y setters
	    public consultaVeterinario(int idConsulta, String fecha, String motivo, String diagnostico, String tratamiento, String observaciones) {
	        this.idConsulta = idConsulta;
	        this.fecha = fecha;
	        this.motivo = motivo;
	        this.diagnostico = diagnostico;
	        this.tratamiento = tratamiento;
	        this.observaciones = observaciones;
	    }

	    public int getIdConsulta() {
	        return idConsulta;
	    }

	    public void setIdConsulta(int idConsulta) {
	        this.idConsulta = idConsulta;
	    }

	    public String getFecha() {
	        return fecha;
	    }

	    public void setFecha(String fecha) {
	        this.fecha = fecha;
	    }

	    public String getMotivo() {
	        return motivo;
	    }

	    public void setMotivo(String motivo) {
	        this.motivo = motivo;
	    }

	    public String getDiagnostico() {
	        return diagnostico;
	    }

	    public void setDiagnostico(String diagnostico) {
	        this.diagnostico = diagnostico;
	    }

	    public String getTratamiento() {
	        return tratamiento;
	    }

	    public void setTratamiento(String tratamiento) {
	        this.tratamiento = tratamiento;
	    }

	    public String getObservaciones() {
	        return observaciones;
	    }

	    public void setObservaciones(String observaciones) {
	        this.observaciones = observaciones;
	    }
	
}
