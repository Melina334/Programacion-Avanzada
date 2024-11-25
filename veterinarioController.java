package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BLL.conexion;
import GUI.veterinario;

public class veterinarioController {

	private static Connection con = conexion.getInstance().getConection();

	public static boolean registrarConsulta(String idMascota, String servicio, String fecha) {
        String sql = "INSERT INTO consulta (idMascota, servicio, fecha) VALUES (?, ?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(idMascota)); // ID de la mascota
            statement.setString(2, servicio); // Servicio realizado
            statement.setString(3, fecha); // Fecha de la consulta

            int filas = statement.executeUpdate();
            return filas > 0; // Verificar si se insertó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar la consulta: " + e.getMessage());
            return false;
        }
    }

    // Método para generar un reporte médico
    public static boolean generarReporteMedico(String idMascota, String reporte) {
        String sql = "INSERT INTO reporte_medico (idmascota, descripcion) VALUES (?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(idMascota)); // ID de la mascota
            statement.setString(2, reporte); // Descripción del reporte médico

            int filas = statement.executeUpdate();
            return filas > 0; // Verificar si se insertó al menos una fila
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar el reporte médico: " + e.getMessage());
            return false;
        }
    }

    // Método para verificar si una mascota existe por ID
    public static boolean existeMascota(String idMascota) {
        String sql = "SELECT id FROM mascota WHERE id = ?";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(idMascota));
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // Retorna true si encuentra un registro
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la mascota: " + e.getMessage());
            return false;
        
    }
}
	
}