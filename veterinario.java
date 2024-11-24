package GUI;

import javax.swing.JOptionPane;

public class veterinario extends usuario {

	

    
	
    public veterinario(String string, String string2, String string3, String string4) {
		super(string, string2, string3, string4);
		// TODO Auto-generated constructor stub
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
