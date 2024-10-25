package petPals;

public class alojamientoAlHotel {

	
	private int idAlojamiento;
    private String tipo;
    private boolean disponible;
    private int duracionEstancia; 
    private double precioPorNoche;
    private mascota mascotaAlojada; 

 
    public alojamientoAlHotel(int idAlojamiento, String tipo, boolean disponible, int duracionEstancia, double precioPorNoche) {
        this.idAlojamiento = idAlojamiento;
        this.tipo = tipo;
        this.disponible = disponible;
        this.duracionEstancia = duracionEstancia;
        this.precioPorNoche = precioPorNoche;
        this.mascotaAlojada = null; // Inicialmente no hay mascota alojada
    }

    
    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getDuracionEstancia() {
        return duracionEstancia;
    }

    public void setDuracionEstancia(int duracionEstancia) {
        this.duracionEstancia = duracionEstancia;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    public mascota getMascotaAlojada() {
        return mascotaAlojada;
    }

    public void setMascotaAlojada(mascota mascotaAlojada) {
        this.mascotaAlojada = mascotaAlojada;
        this.disponible = (mascotaAlojada == null); // Si hay mascota, no está disponible
    }

    // Metodos adicionales
    public void liberarAlojamiento() {
        this.mascotaAlojada = null;
        this.disponible = true;
    }

    @Override
    public String toString() {
        return "Alojamiento [ID=" + idAlojamiento + ", Tipo=" + tipo + ", Disponible=" + disponible + ", Duración Estancia=" + duracionEstancia + " días, Precio por noche=" + precioPorNoche + " USD, Mascota Alojada=" + (mascotaAlojada != null ? mascotaAlojada.getNombre() : "Ninguna") + "]";
    }

}
