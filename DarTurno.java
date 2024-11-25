package GUI;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import BLL.mascota;
import DLL.empleadoController;
import java.awt.Font;
import java.awt.Color;

public class DarTurno extends JFrame {

	 private JTextField idMascotaField;
	    private JTextField nombreMascotaField;
	    private JTextField fechaTurnoField;
	    private JComboBox<String> servicioCombo;

	    public DarTurno() {
	        // Configuración básica de la ventana
	        setTitle("Dar Turno");
	        setSize(434, 332);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        getContentPane().setLayout(new GridLayout(5, 2));

	        // Crear los componentes del formulario
	        idMascotaField = new JTextField();
	        nombreMascotaField = new JTextField();
	        fechaTurnoField = new JTextField("yyyy-MM-dd"); // Formato de fecha
	        servicioCombo = new JComboBox<>(new String[]{"Consulta General", "Vacunación", "Revisión", "Peluqueria"});

	        // Crear botones
	        JButton darTurnoButton = new JButton("Asignar Turno");
	        darTurnoButton.setBackground(new Color(0, 255, 255));
	        darTurnoButton.setForeground(new Color(255, 0, 255));
	        darTurnoButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        darTurnoButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                asignarTurno();
	            }
	        });

	        JButton volverButton = new JButton("Volver");
	        volverButton.setBackground(new Color(0, 255, 255));
	        volverButton.setForeground(new Color(255, 0, 255));
	        volverButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        volverButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                dispose(); // Cierra la ventana actual
	            }
	        });

	        // Agregar los componentes al JFrame
	        JLabel label_3 = new JLabel("ID Mascota :");
	        label_3.setForeground(new Color(255, 0, 255));
	        getContentPane().add(label_3);
	        getContentPane().add(idMascotaField);
	        JLabel label_2 = new JLabel("Nombre Mascota (opcional):");
	        label_2.setForeground(new Color(255, 0, 255));
	        getContentPane().add(label_2);
	        getContentPane().add(nombreMascotaField);
	        JLabel label_1 = new JLabel("Fecha Turno (YYYY-MM-DD):");
	        label_1.setForeground(new Color(255, 0, 255));
	        getContentPane().add(label_1);
	        getContentPane().add(fechaTurnoField);
	        JLabel label = new JLabel("Servicio:");
	        label.setForeground(new Color(255, 0, 255));
	        getContentPane().add(label);
	        getContentPane().add(servicioCombo);
	        getContentPane().add(darTurnoButton);
	        getContentPane().add(volverButton);
	    }

	    private void asignarTurno() {
	        String idMascotaInput = idMascotaField.getText().trim();
	        String nombreMascotaInput = nombreMascotaField.getText().trim();
	        String fechaString = fechaTurnoField.getText().trim();
	        String servicio = (String) servicioCombo.getSelectedItem();

	        // Validar que haya ingresado el ID o nombre
	        if (idMascotaInput.isEmpty() && nombreMascotaInput.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe ingresar el ID o el nombre de la mascota.");
	            return;
	        }

	        // Validar la fecha
	        if (fechaString.isEmpty()) {
	            JOptionPane.showMessageDialog(this, "Debe ingresar una fecha válida.");
	            return;
	        }

	        // Buscar la mascota
	        mascota m = null;
	        if (!idMascotaInput.isEmpty()) {
	            try {
	                int idMascota = Integer.parseInt(idMascotaInput);
	                m = empleadoController.buscarMascotaPorId(idMascota);
	            } catch (NumberFormatException e) {
	                JOptionPane.showMessageDialog(this, "El ID debe ser un número.");
	                return;
	            }
	        } else if (!nombreMascotaInput.isEmpty()) {
	            m = empleadoController.buscarMascotaPorNombre(nombreMascotaInput);
	        }

	        if (m == null) {
	            JOptionPane.showMessageDialog(this, "Mascota no encontrada.");
	            return;
	        }

	        // Guardar el turno en la base de datos
	        java.sql.Date fechaTurno = java.sql.Date.valueOf(fechaString); // Convertir a formato SQL
	        boolean exito = empleadoController.darTurno(m.getIdMascota(), fechaTurno, servicio);
	        if (exito) {
	            JOptionPane.showMessageDialog(this, "Turno asignado exitosamente.");
	        } else {
	            JOptionPane.showMessageDialog(this, "Error al asignar el turno.");
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> new DarTurno().setVisible(true));
	    }
	}
