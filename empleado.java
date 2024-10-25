package petPals;

import javax.swing.JOptionPane;

public class empleado extends usuario{

	private String nombre;
	private String contacto;
	private int idEmpleado;
	private String cargo;
	private String sucursal;

	 public empleado(String mail, String contraseña, String rol, String nombre, String contacto, int idEmpleado, String cargo, String sucursal) {
	        super(mail, contraseña, rol); 
	        this.nombre = nombre;
	        this.contacto = contacto;
	        this.idEmpleado = idEmpleado;
	        this.cargo = cargo;
	        this.sucursal = sucursal;
	    }

	    // Getters y setters
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

	    public int getIdEmpleado() {
	        return idEmpleado;
	    }

	    public void setIdEmpleado(int idEmpleado) {
	        this.idEmpleado = idEmpleado;
	    }

	    public String getCargo() {
	        return cargo;
	    }

	    public void setCargo(String cargo) {
	        this.cargo = cargo;
	    }

	    public String getSucursal() {
	        return sucursal;
	    }

	    public void setSucursal(String sucursal) {
	        this.sucursal = sucursal;
	    }

	    @Override
	    public String toString() {
	        return "Empleado [nombre=" + nombre + ", contacto=" + contacto + ", idEmpleado=" + idEmpleado + 
	               ", cargo=" + cargo + ", sucursal=" + sucursal + "]";
	    }
	    public void menu() {
	        String[] opciones = {"Registrar llegada de mascota", "Generar factura", "Ver reservas"};
	        String opcion = (String) JOptionPane.showInputDialog(null, "Menú Empleado",
	                "Seleccione una opción", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
	        
	        switch (opcion) {
	            case "Registrar llegada de mascota":
	                JOptionPane.showMessageDialog(null, "Registrando llegada de mascota...");
	             
	                break;
	            case "Generar factura":
	                JOptionPane.showMessageDialog(null, "Generando factura...");
	             
	                break;
	            case "Ver reservas":
	                JOptionPane.showMessageDialog(null, "Mostrando reservas...");
	               
	                break;
	            default:
	                JOptionPane.showMessageDialog(null, "Opción no válida.");
	        }
	    }
	}

