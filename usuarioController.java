package petPals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;

public class usuarioController {

      
	 private static Connection con = conexion.getInstance().getConection();

	   
	    public static boolean agregarUsuario(usuario usuario) {
	        String sql = "INSERT INTO usuarios (mail, contraseña, rol) VALUES (?, ?, ?)";

	        try (PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql)) {
	            statement.setString(1, usuario.getMail());
	            statement.setString(2, usuario.getContraseña());
	            statement.setString(3, usuario.getRol());

	            System.out.println("Ejecutando consulta: " + statement);
	            int filas = statement.executeUpdate();

	            if (filas > 0) {
	                JOptionPane.showMessageDialog(null, "Usuario agregado exitosamente");
	                return true;
	            } else {
	                System.out.println("No se agregaron filas.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al agregar usuario: " + e.getMessage());
	        }
	        return false;
	    }

	    // 2. Buscar usuario por mail (SELECT)
	    public static usuario buscarUsuarioPorMail(String mail) {
	        usuario usuarioEncontrado = null;
	        String sql = "SELECT * FROM usuarios WHERE mail = ?";

	        try (PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql)) {
	            statement.setString(1, mail);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                    usuarioEncontrado = new usuario(
	                        resultSet.getString("mail"),
	                        resultSet.getString("contraseña"),
	                        resultSet.getString("rol")
	                    );
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al buscar usuario");
	        }
	        return usuarioEncontrado;
	    }

	    // 3. Actualizar un usuario (UPDATE)
	    public static boolean actualizarUsuario(usuario usuario) {
	        String sql = "UPDATE usuarios SET contraseña = ?, rol = ? WHERE mail = ?";

	        try (PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql)) {
	            statement.setString(1, usuario.getContraseña());
	            statement.setString(2, usuario.getRol());
	            statement.setString(3, usuario.getMail());

	            System.out.println("Ejecutando consulta: " + statement);
	            int filas = statement.executeUpdate();

	            if (filas > 0) {
	                JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente");
	                return true;
	            } else {
	                System.out.println("No se actualizó ninguna fila.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al actualizar usuario: " + e.getMessage());
	        }
	        return false;
	    }

	    // 4. Eliminar usuario (DELETE)
	    public static boolean eliminarUsuario(String mail) {
	        String sql = "DELETE FROM usuarios WHERE mail = ?";

	        try (PreparedStatement statement = (PreparedStatement) con.prepareStatement(sql)) {
	            statement.setString(1, mail);

	            System.out.println("Ejecutando consulta: " + statement);
	            int filas = statement.executeUpdate();

	            if (filas > 0) {
	                JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente");
	                return true;
	            } else {
	                System.out.println("No se eliminó ninguna fila.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al eliminar usuario: " + e.getMessage());
	        }
	        return false;
	    }
	}
