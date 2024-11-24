package GUI;

public class reserva {

	private int idMascota;
    private String fechaEntrada;
    private String fechaSalida;

    

    public reserva(int idMascota, String fechaEntrada, String fechaSalida) {
		super();
		this.idMascota = idMascota;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
	}

	public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
