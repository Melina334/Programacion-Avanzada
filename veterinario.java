package petPals;

import javax.swing.JOptionPane;

public class veterinario extends usuario {

	private String nombre;
	private String contacto;
	private int idVeterinario;
    private String especialidad;
    private String sucursal;
    
    public veterinario(String mail, String contraseña, String rol, String nombre, String contacto, int idVeterinario, String especialidad, String sucursal) {
        super(mail, contraseña, rol);  
        this.nombre = nombre;
        this.contacto = contacto;
        this.idVeterinario = idVeterinario;
        this.especialidad = especialidad;
        this.sucursal = sucursal;
    }

    // Getters y setters
    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Veterinario [nombre=" + nombre + ", contacto=" + contacto + ", idVeterinario=" + idVeterinario +
                ", especialidad=" + especialidad + ", sucursal=" + sucursal + "]";
    }

    // Metodo del menu del veterinario
    public void menu() {
        String[] opciones = {"Registrar consulta", "Editar consulta", "Generar reporte médico"};
        String opcion = (String) JOptionPane.showInputDialog(null, "Menú Veterinario",
                "Seleccione una opción", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        
        switch (opcion) {
            case "Atender mascota":
                JOptionPane.showMessageDialog(null, "Registrando consulta médica...");
                
                break;
            case "realizar servicio de peluqueria":
                JOptionPane.showMessageDialog(null, "Editando consulta...");

                break;
            case "Generar reporte medico":
                JOptionPane.showMessageDialog(null, "Generando reporte médico...");
                
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida.");
        }
    }
}
