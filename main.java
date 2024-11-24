package GUI;

import java.awt.EventQueue;
import javax.swing.JOptionPane;
import DLL.usuarioController;
import GUI.usuario;

public class main {

    public static void main(String[] args) {
        // Inicia la ventana de login como punto de entrada
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    PantallaLogin frame = new PantallaLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    
    public static void mostrarMenuSegunRol(usuario usuario) {
        
        switch (usuario.getRol().toLowerCase()) {
            case "administrador":
                // Crear una instancia de administrador y mostrar su menú
                administrador admin = new administrador(
                    usuario.getMail(),
                    usuario.getContraseña(),
                    usuario.getRol(),
                    usuario.getNombre()
                );
                admin.menu(usuario);
                break;

            case "empleado":
                // Si es empleado, abrir el MenuEmpleado
                EventQueue.invokeLater(() -> {
                    try {
                        MenuEmpleado menuEmpleado = new MenuEmpleado(); // Abre el menú gráfico del empleado
                        menuEmpleado.setVisible(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                break;

            case "veterinario":
                // Crear una instancia de veterinario y mostrar su menú
                veterinario vet = new veterinario(
                    usuario.getMail(),
                    usuario.getContraseña(),
                    usuario.getRol(),
                    usuario.getNombre()
                );
                vet.menu();
                break;

            default:
                // Si el rol no es reconocido, mostrar un mensaje de error
                JOptionPane.showMessageDialog(null, "Rol desconocido.");
                break;
        }
    }
}