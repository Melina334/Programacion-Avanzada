package petPals;

import java.util.List;

public class cliente {

	private String nombre;
	private String contacto;
	private int idCliente;
    private String direccion;
    private String telefono;
    private String correo;
    private List<mascota> listaMascotas;


    public cliente(String nombre, String contacto, int idCliente, String direccion, String telefono, String correo, List<mascota> listaMascotas) {
        super();
        this.idCliente = idCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.listaMascotas = listaMascotas;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    // Metodos adicionales
    public void solicitaServicio() {
       
    }

    public void retiraMascota() {
       
    }

    public void hacePago() {
      
    }

}
