package controller;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import petPals.conexion;

import javax.swing.JOptionPane;

import petPals.usuario;

public class usuarioController {

	private static Connection con = conexion.getInstance().getConection();

	 public static void solicitarDatosUsuario() {
	        String mail = JOptionPane.showInputDialog(null, "Ingrese el correo electrónico:");
	        String contraseña = JOptionPane.showInputDialog(null, "Ingrese la contraseña:");
	        String rol = JOptionPane.showInputDialog(null, "Ingrese el rol:");
	        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre:");

	        // Crear un nuevo objeto usuario con los datos ingresados
	        usuario nuevoUsuario = new usuario(mail, contraseña, rol, nombre);

	        // Llamar al metodo para crear el usuario en la base de datos
	        boolean exito = crearUsuario(nuevoUsuario);
	        if (exito) {
	            JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
	        } else {
	            JOptionPane.showMessageDialog(null, "No se pudo crear el usuario.");
	        }
	    }

	    public static boolean crearUsuario(usuario usuario) {
	        String sql = "INSERT INTO usuario (mail, contraseña, rol, nombre) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, usuario.getMail());
	            statement.setString(2, usuario.getContraseña());
	            statement.setString(3, usuario.getRol());
	            statement.setString(4, usuario.getNombre());

	            int filas = statement.executeUpdate();
	            return filas > 0; // Verificar si se inserto al menos una fila
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al crear usuario: " + e.getMessage());
	            return false;
	        }
	    }




	// Actualizar usuario
	public static boolean actualizarUsuario(usuario usuario) {
		String sql = "UPDATE usuarios SET mail = ?, contraseña = ?, rol = ? WHERE id = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setString(1, usuario.getMail());
			statement.setString(2, usuario.getContraseña());
			statement.setString(3, usuario.getRol());

			int filas = statement.executeUpdate();
			return filas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
			return false;
		}
	}

	// Eliminar usuario por ID
	public static boolean eliminarUsuario(int id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setInt(1, id);

			int filas = statement.executeUpdate();
			return filas > 0; // Retorna true si se eliminó con éxito
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
			return false;
		}
	}

	public static void eliminarUsuario() {
		try {
			int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del usuario a eliminar:"));

			if (id <= 0) {
				JOptionPane.showMessageDialog(null, "ID no válido. Debe ser mayor que 0.");
				return;
			}

			// Llame al metodo eliminarUsuario(int id)
			if (usuarioController.eliminarUsuario(id)) {
				JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.");
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró un usuario con ese ID.");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID inválido. Debe ingresar un número.");
		}
	}

	// Listar todos los usuarios
	public static void listarUsuarios() {
		ArrayList<usuario> lista = new ArrayList<>();
	    String sql = "SELECT * FROM usuario";

	    try (PreparedStatement statement = con.prepareStatement(sql); ResultSet resultSet = statement.executeQuery()) {
	        while (resultSet.next()) {
	            usuario usuario = new usuario(
	                resultSet.getString("mail"),
	                resultSet.getString("contraseña"),
	                resultSet.getString("rol"),
	                resultSet.getString("nombre")
	            );
	            lista.add(usuario);
	        }

	        // Mostrar la lista de usuarios en un JOptionPane
	        if (lista.isEmpty()) {
	            JOptionPane.showMessageDialog(null, "No hay usuarios registrados.");
	        } else {
	            StringBuilder sb = new StringBuilder("Lista de Usuarios:\n\n");
	            for (usuario u : lista) {
	                sb.append("Correo: ").append(u.getMail())
	                  .append(", Nombre: ").append(u.getNombre())
	                  .append(", Rol: ").append(u.getRol())
	                  .append("\n");
	            }
	            JOptionPane.showMessageDialog(null, sb.toString());
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al listar usuarios: " + e.getMessage());
	    }
	}

	public static usuario buscarUsuario(String mail, String contrasena) {
	    usuario usuarioEncontrado = null;
	    String sql = "SELECT * FROM usuario WHERE mail = ? AND contraseña = ?";

	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setString(1, mail);
	        statement.setString(2, contrasena);

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                usuarioEncontrado = new usuario(
	                    resultSet.getString("mail"),
	                    resultSet.getString("contraseña"),
	                    resultSet.getString("rol"),
	                    resultSet.getString("nombre")
	                );
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al buscar el usuario: " + e.getMessage());
	    }

	    return usuarioEncontrado;
	}
}
