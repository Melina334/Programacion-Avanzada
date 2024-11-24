package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import BLL.conexion;
import BLL.mascota;
import GUI.empleado;
import GUI.reserva;

public class empleadoController {

	private static Connection con = conexion.getInstance().getConection();
	

	public static void registrarMascota(String nombre, int edad, String raza, String comportamiento, double peso, double altura, String patologias, String observaciones) {
	    try {
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

	    
	    public static mascota buscarMascotaPorId(int id) {
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
	    
	    public static List<String> verMascotasRegistradas() {
	        List<String> listado = new ArrayList<>();

	        String sql = "SELECT idMascota, nombre, edad, raza, comportamiento, peso, altura FROM mascotas";

	        try (PreparedStatement statement = con.prepareStatement(sql); 
	             ResultSet resultSet = statement.executeQuery()) {

	            if (!resultSet.isBeforeFirst()) {
	                listado.add("No hay mascotas registradas.");
	                return listado;
	            }

	            while (resultSet.next()) {
	                int id = resultSet.getInt("idMascota");
	                String nombre = resultSet.getString("nombre");
	                int edad = resultSet.getInt("edad");
	                String raza = resultSet.getString("raza");
	                String comportamiento = resultSet.getString("comportamiento");
	                double peso = resultSet.getDouble("peso");
	                double altura = resultSet.getDouble("altura");

	                // Formato de la mascota
	                listado.add("ID: " + id);
	                listado.add("Nombre: " + nombre);
	                listado.add("Edad: " + edad);
	                listado.add("Raza: " + raza);
	                listado.add("Comportamiento: " + comportamiento);
	                listado.add("Peso: " + peso + " kg");
	                listado.add("Altura: " + altura + " m");
	                listado.add("-------------------------------");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            listado.add("Error al obtener la lista de mascotas: " + e.getMessage());
	        }

	        return listado;  // Devuelve la lista de mascotas
	    }
	
	   
	    
	
	   

	     public static List<mascota> obtenerMascotas() {
	        List<mascota> listaMascotas = new ArrayList<>();
	        String sql = "SELECT idMascota, nombre FROM mascotas";

	        try (PreparedStatement statement = con.prepareStatement(sql);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                mascota m = new mascota(0, sql, 0, sql, sql, 0, 0, sql, sql);
	                m.setIdMascota(resultSet.getInt("idMascota"));
	                m.setNombre(resultSet.getString("nombre"));
	                listaMascotas.add(m);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error al obtener mascotas: " + e.getMessage());
	        }

	        return listaMascotas;
	    }

	     public static boolean generarFactura(int idMascota, String servicio, double monto) {
	    	    String sql = "INSERT INTO facturas (idMascota, servicio, monto) VALUES (?, ?, ?)";
	    	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	    	        statement.setInt(1, idMascota);
	    	        statement.setString(2, servicio);
	    	        statement.setDouble(3, monto);
	    	        int filas = statement.executeUpdate();
	    	        return filas > 0;
	    	    } catch (SQLException e) {
	    	        e.printStackTrace();
	    	        JOptionPane.showMessageDialog(null, "Error al generar factura: " + e.getMessage());
	    	        return false;
	    	    }
	    	}
	
}
    


