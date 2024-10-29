package ui;

import javax.swing.JOptionPane;

import controller.usuarioController;
import petPals.usuario;
import petPals.administrador;
import petPals.empleado;
import petPals.veterinario;

public class main {

	public static void main(String[] args) {
		 try {
		        String mail = JOptionPane.showInputDialog("Ingresa el correo electrónico:");
		        String contrasena = JOptionPane.showInputDialog("Ingresa la contraseña:");

		        usuario usuario = usuarioController.buscarUsuario(mail, contrasena);

		        if (usuario == null) {
		            JOptionPane.showMessageDialog(null, "Usuario no encontrado o credenciales incorrectas.");
		        } else {
		            // Verificar que el rol no sea nulo
		            if (usuario.getRol() != null) {
		                JOptionPane.showMessageDialog(null, "Bienvenido: " + usuario.getNombre());
		                mostrarMenuSegunRol(usuario);
		            } else {
		                JOptionPane.showMessageDialog(null, "El usuario no tiene un rol asignado.");
		            }
		        }
		    } catch (Exception e) {
		        JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
		        e.printStackTrace();
		    }
		}
	

	private static void mostrarMenuSegunRol(usuario usuario) {
		switch (usuario.getRol().toLowerCase()) {
		case "administrador":
			administrador administrador = new administrador(usuario.getMail(), usuario.getContraseña(),
					usuario.getRol(), usuario.getNombre());
			administrador.menu(usuario);
			break;

		case "empleado":
			empleado empleado = new empleado(usuario.getMail(), usuario.getContraseña(), usuario.getRol(),
					usuario.getNombre());
			empleado.menu();
			break;

		case "veterinario":
			veterinario veterinario = new veterinario(usuario.getMail(), usuario.getContraseña(), usuario.getRol(),
					usuario.getNombre());
			veterinario.menu();
			break;

		default:
			JOptionPane.showMessageDialog(null, "Rol desconocido.");
			break;
		}
	}
}