package ui;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import petPals.empleado;
import petPals.usuario;
import petPals.veterinario;

public class main {

	public static void main(String[] args) {
	        
	      LinkedList<usuario> usuarios = new LinkedList<>();
	       usuarios.add(new usuario("empleado@gmail.com", "1234", "empleado"));
	       usuarios.add(new usuario("veterinario@gmail.com", "4321", "veterinario"));

	        
	        String mail = JOptionPane.showInputDialog("Ingresa el correo electrónico:");
	        String contrasena = JOptionPane.showInputDialog("Ingresa la contraseña:");

	   
	       usuario usuario = login(usuarios, mail, contrasena);
	        
	        if (usuario == null) {
	          JOptionPane.showMessageDialog(null, "Usuario no encontrado o credenciales incorrectas.");
	      } else {
	          JOptionPane.showMessageDialog(null, "Bienvenido: " + usuario);
	            
	            // Dependiendo del rol, mostrar el menu correspondiente
	            if (usuario.getRol().equals("empleado")) {
	                empleado empleado = new empleado(usuario.getMail(), usuario.getContraseña(), usuario.getRol(), contrasena, contrasena, 0, contrasena, contrasena);
	                empleado.menu();
	          } else if (usuario.getRol().equals("veterinario")) {
	               veterinario veterinario = new veterinario(usuario.getMail(), usuario.getContraseña(), usuario.getRol(), contrasena, contrasena, 0, contrasena, contrasena);
	               veterinario.menu();
	            } else {
	                JOptionPane.showMessageDialog(null, "Rol desconocido.");
	           }
	        }
	   }

	public static usuario login(LinkedList<usuario> usuarios, String mail, String contrasena) {
		for (usuario usuario : usuarios) {
			if (usuario.getMail().equals(mail) && usuario.getContraseña().equals(contrasena)) {
				return usuario;
			}
		}
		return null;
	}

}
