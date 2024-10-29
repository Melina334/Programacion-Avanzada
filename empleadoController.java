package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import petPals.conexion;
import petPals.empleado;
import petPals.mascota;
import petPals.reserva;

public class empleadoController {

	private static Connection con = conexion.getInstance().getConection();
	

	 public static void registrarMascota() {
	        try {
	           
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la mascota:");
	            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de la mascota:"));
	            String raza = JOptionPane.showInputDialog("Ingrese la raza de la mascota:");
	            String comportamiento = JOptionPane.showInputDialog("Ingrese el comportamiento de la mascota:");
	            double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el peso de la mascota (kg):"));
	            double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la altura de la mascota (cm):"));
	            String patologias = JOptionPane.showInputDialog("Ingrese las patologías de la mascota (si no tiene, deje en blanco):");
	            String observaciones = JOptionPane.showInputDialog("Ingrese observaciones sobre la mascota:");

	   
	            mascota nuevaMascota = new mascota(0, nombre, edad, raza, comportamiento, peso, altura, patologias, observaciones);

	            // Guardar la mascota en la base de datos
	            if (guardarMascota(nuevaMascota)) {
	                JOptionPane.showMessageDialog(null, "Mascota registrada con éxito.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se pudo registrar la mascota.");
	            }

	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Error en la entrada de datos. Asegúrese de ingresar números donde corresponda.");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
	        }
	    }

	    private static boolean guardarMascota(mascota nuevaMascota) {
	        String sql = "INSERT INTO mascotas (nombre, edad, raza, comportamiento, peso, altura, patologias, observaciones) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setString(1, nuevaMascota.getNombre());
	            statement.setInt(2, nuevaMascota.getEdad());
	            statement.setString(3, nuevaMascota.getRaza());
	            statement.setString(4, nuevaMascota.getComportamiento());
	            statement.setDouble(5, nuevaMascota.getPeso());
	            statement.setDouble(6, nuevaMascota.getAltura());
	            statement.setString(7, nuevaMascota.getPatologias());
	            statement.setString(8, nuevaMascota.getObservaciones());

	            int filas = statement.executeUpdate();
	            return filas > 0; 
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al registrar la mascota: " + e.getMessage());
	            return false;
	        }
	    }
	

	    public static void darAlojamiento() {
	        String idInput = JOptionPane.showInputDialog("Ingrese el ID de la mascota:");
            try {
	            int idMascota = Integer.parseInt(idInput);

	            mascota mascota = buscarMascotaPorId(idMascota); 

	            if (mascota == null) {
	                JOptionPane.showMessageDialog(null, "Mascota no encontrada.");
	                return;
	            }
                String fechaEntrada = JOptionPane.showInputDialog("Ingrese la fecha de entrada (yyyy-MM-dd):");
	            String fechaSalida = JOptionPane.showInputDialog("Ingrese la fecha de salida (yyyy-MM-dd):");
	            
	           
	            if (fechaEntrada.isEmpty() || fechaSalida.isEmpty()) {
	                JOptionPane.showMessageDialog(null, "Las fechas no pueden estar vacías.");
	                return;
	            }
                reserva nuevaReserva = new reserva(mascota.getIdMascota(), fechaEntrada, fechaSalida);
	            
	           
	            if (guardarReserva(nuevaReserva)) {
	                JOptionPane.showMessageDialog(null, "Alojamiento asignado exitosamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "Error al asignar el alojamiento.");
	            }
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "ID inválido. Debe ingresar un número.");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Ocurrió un error: " + e.getMessage());
	        }
	    }

	    
	    private static mascota buscarMascotaPorId(int id) {
	        mascota mascotaEncontrada = null;
	        String sql = "SELECT * FROM mascotas WHERE idMascota = ?";

	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setInt(1, id);

	            try (ResultSet resultSet = statement.executeQuery()) {
	                if (resultSet.next()) {
	                   
	                    mascotaEncontrada = new mascota(id, sql, id, sql, sql, id, id, sql, sql);
	                    mascotaEncontrada.setIdMascota(resultSet.getInt("idMascota"));
	                    mascotaEncontrada.setNombre(resultSet.getString("nombre"));
	                    mascotaEncontrada.setEdad(resultSet.getInt("edad"));
	                    mascotaEncontrada.setRaza(resultSet.getString("raza"));
	                    mascotaEncontrada.setComportamiento(resultSet.getString("comportamiento"));
	                    mascotaEncontrada.setPeso(resultSet.getDouble("peso"));
	                    mascotaEncontrada.setAltura(resultSet.getDouble("altura"));
	                    mascotaEncontrada.setPatologias(resultSet.getString("patologias"));
	                    mascotaEncontrada.setObservaciones(resultSet.getString("observaciones"));
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al buscar la mascota: " + e.getMessage());
	        }

	        return mascotaEncontrada;
	    }

	
	    private static boolean guardarReserva(reserva reserva) {
	        String sql = "INSERT INTO reservas (idMascota, fechaEntrada, fechaSalida) VALUES (?, ?, ?)";
	        try (PreparedStatement statement = con.prepareStatement(sql)) {
	            statement.setInt(1, reserva.getIdMascota());
	            statement.setString(2, reserva.getFechaEntrada());
	            statement.setString(3, reserva.getFechaSalida());

	            int filas = statement.executeUpdate();
	            return filas > 0; // Retorna true si se guardo con exito
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al guardar reserva: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    public static void verMascotasRegistradas() {
	        StringBuilder listado = new StringBuilder("Lista de Mascotas Registradas:\n");

	        String sql = "SELECT idMascota, nombre, edad, raza, comportamiento, peso, altura FROM mascotas";

	        try (PreparedStatement statement = con.prepareStatement(sql); 
	             ResultSet resultSet = statement.executeQuery()) {

	            if (!resultSet.isBeforeFirst()) {
	           
	                JOptionPane.showMessageDialog(null, "No hay mascotas registradas.");
	                return;
	            }

	            
	            while (resultSet.next()) {
	                int id = resultSet.getInt("idMascota");
	                String nombre = resultSet.getString("nombre");
	                int edad = resultSet.getInt("edad");
	                String raza = resultSet.getString("raza");
	                String comportamiento = resultSet.getString("comportamiento");
	                double peso = resultSet.getDouble("peso");
	                double altura = resultSet.getDouble("altura");

	       
	                listado.append("ID: ").append(id).append("\n")
	                       .append("Nombre: ").append(nombre).append("\n")
	                       .append("Edad: ").append(edad).append("\n")
	                       .append("Raza: ").append(raza).append("\n")
	                       .append("Comportamiento: ").append(comportamiento).append("\n")
	                       .append("Peso: ").append(peso).append(" kg\n")
	                       .append("Altura: ").append(altura).append(" m\n")
	                       .append("-------------------------------\n");
	            }

	         
	            JOptionPane.showMessageDialog(null, listado.toString());

	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al obtener la lista de mascotas: " + e.getMessage());
	        }
	    }

    public static boolean generarFactura(String nombreMascota, String monto) {
        String sql = "INSERT INTO factura (nombre_mascota, monto) VALUES (?, ?)";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, nombreMascota);
            statement.setString(2, monto);
            int filas = statement.executeUpdate();
            return filas > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al generar factura: " + e.getMessage());
            return false;
        }
    }
}

