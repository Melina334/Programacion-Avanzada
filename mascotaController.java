package DLL;

import java.util.ArrayList;
import java.util.List;

import BLL.conexion;
import BLL.mascota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mascotaController {

	 private static Connection con = conexion.getInstance().getConection();
	
	 public static void crearMascota(mascota mascota) throws SQLException {
	        String sql = "INSERT INTO mascotas (nombre, edad, raza, comportamiento, peso, altura, patologias, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, mascota.getNombre());
	            statement.setInt(2, mascota.getEdad());
	            statement.setString(3, mascota.getRaza());
	            statement.setString(4, mascota.getComportamiento());
	            statement.setDouble(5, mascota.getPeso());
	            statement.setDouble(6, mascota.getAltura());
	            statement.setString(7, mascota.getPatologias());
	            statement.setString(8, mascota.getObservaciones());
	            statement.executeUpdate();
	            System.out.println("Mascota creada correctamente.");
	        }
	    }

	    public static List<mascota> obtenerMascotas() throws SQLException {
	        List<mascota> mascotas = new ArrayList<>();
	        String sql = "SELECT * FROM mascotas";
	        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
	            while (rs.next()) {
	                mascotas.add(new mascota(
	                        rs.getInt("idMascota"),
	                        rs.getString("nombre"),
	                        rs.getInt("edad"),
	                        rs.getString("raza"),
	                        rs.getString("comportamiento"),
	                        rs.getDouble("peso"),
	                        rs.getDouble("altura"),
	                        rs.getString("patologias"),
	                        rs.getString("observaciones")));
	            }
	        }
	        return mascotas;
	    }

	    public static void actualizarMascota(int id, String nuevoNombre) throws SQLException {
	        String sql = "UPDATE mascotas SET nombre = ? WHERE idMascota = ?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setString(1, nuevoNombre);
	            stmt.setInt(2, id);
	            int filas = stmt.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Mascota actualizada.");
	            } else {
	                System.out.println("Mascota no encontrada.");
	            }
	        }
	    }

	    public static void eliminarMascota(int id) throws SQLException {
	        String sql = "DELETE FROM mascotas WHERE idMascota = ?";
	        try (PreparedStatement stmt = con.prepareStatement(sql)) {
	            stmt.setInt(1, id);
	            int filas = stmt.executeUpdate();
	            if (filas > 0) {
	                System.out.println("Mascota eliminada.");
	            } else {
	                System.out.println("Mascota no encontrada.");
	            }
	        }
	    }
	}

