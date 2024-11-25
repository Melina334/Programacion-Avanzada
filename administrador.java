package GUI;

import javax.swing.JOptionPane;

import DLL.usuarioController;

public class administrador extends usuario {

	
	public administrador(String string, String string2, String string3, String string4) {
		super(string, string2, string3, string4);
	}

	/*
	public void menu(usuario usuario) {
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"Menú Administrador\n1. Crear Usuario\n2. Eliminar Usuario\n3. Listar Usuarios\n0. Salir"));
			switch (opcion) {
			case 1:
				usuarioController.solicitarDatosUsuario();
				usuarioController.crearUsuario(usuario);
				break;
			case 2:
				usuarioController.eliminarUsuario();
				break;
			case 3:
				usuarioController.listarUsuarios();
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Cerrando sesión...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no válida.");
			}
		} while (opcion != 0);
	}
*/
}
