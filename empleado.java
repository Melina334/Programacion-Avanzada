package petPals;

import javax.swing.JOptionPane;

import controller.empleadoController;

public class empleado extends usuario {

	public empleado(String string, String string2, String string3, String string4) {
		super(string, string2, string3, string4);
		// TODO Auto-generated constructor stub
	}

	public void menu() {
		String[] opciones = { "Registrar mascota", "Ver mascotas registradas", "Generar factura",
				"Reservar alojamiento", "Dar turno a mascota" };
		String opcion = (String) JOptionPane.showInputDialog(null, "Menú Empleado", "Seleccione una opción",
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

		switch (opcion) {
		case "Registrar mascota":
			empleadoController.registrarMascota();
			 break;

		case "Ver mascotas registradas":
            empleadoController.verMascotasRegistradas();
			break;

		case "Generar factura":
			JOptionPane.showMessageDialog(null, "Generando factura...");
			break;

		case "Reservar alojamiento":
            empleadoController.darAlojamiento();
			break;

		case "Dar turno a mascota":
			JOptionPane.showMessageDialog(null, "Generando factura...");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opción no válida.");
		}
	}
}
