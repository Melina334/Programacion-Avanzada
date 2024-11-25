package GUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import DLL.empleadoController;

public class DarAlojamiento extends JFrame {

	  private JTextField idMascotaField;  // Campo para ingresar el ID de la mascota
	    private JTextField fechaEntradaField;  // Campo para ingresar la fecha de entrada
	    private JTextField fechaSalidaField;  // Campo para ingresar la fecha de salida
	    private JButton asignarButton;  // Botón para asignar el alojamiento

	    public DarAlojamiento() {
	        // Configuración básica de la ventana
	        setTitle("Dar Alojamiento");
	        setSize(514, 349);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        fechaSalidaField = new JTextField(20);  // Campo de texto para la fecha de salida
	        fechaSalidaField.setBounds(184, 141, 166, 20);
	        asignarButton = new JButton("Asignar Alojamiento");
	        asignarButton.setForeground(new Color(255, 0, 255));
	        asignarButton.setBackground(new Color(0, 255, 255));
	        asignarButton.setBounds(184, 209, 166, 23);
	        getContentPane().setLayout(null);

	        // Agregar los componentes a la ventana
	        JLabel label_1 = new JLabel("ID de la Mascota:");
	        label_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        label_1.setForeground(new Color(255, 0, 255));
	        label_1.setBackground(new Color(255, 0, 255));
	        label_1.setBounds(5, 69, 132, 14);
	        getContentPane().add(label_1);
	        	        
	        	        	        // Inicializar los componentes
	        	        	        idMascotaField = new JTextField(20);  // Crear el campo de texto para el ID de la mascota
	        	        	        idMascotaField.setBounds(184, 66, 166, 20);
	        	        	        getContentPane().add(idMascotaField);
	        	        JLabel label = new JLabel("Fecha de Entrada (yyyy-MM-dd):");
	        	        label.setForeground(new Color(255, 0, 255));
	        	        label.setBackground(new Color(255, 0, 255));
	        	        label.setBounds(5, 100, 160, 14);
	        	        getContentPane().add(label);
	        	        fechaEntradaField = new JTextField(20);  // Campo de texto para la fecha de entrada
	        	        fechaEntradaField.setBounds(184, 97, 166, 20);
	        	        getContentPane().add(fechaEntradaField);
	        JLabel label_2 = new JLabel("Fecha de Salida (yyyy-MM-dd):");
	        label_2.setForeground(new Color(255, 0, 255));
	        label_2.setBounds(5, 144, 150, 14);
	        getContentPane().add(label_2);
	        getContentPane().add(fechaSalidaField);
	        getContentPane().add(asignarButton);
	        
	        JLabel lblNewLabel = new JLabel("Reservar Alojamiento");
	        lblNewLabel.setForeground(new Color(255, 0, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(161, 23, 189, 32);
	        getContentPane().add(lblNewLabel);
	        
	   

	        // Acción del botón para asignar alojamiento
	        asignarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                asignarAlojamiento();  // Llamar al método de asignación
	            }
	        });
	    }

	    private void asignarAlojamiento() {
	        try {
	            int idMascota = Integer.parseInt(idMascotaField.getText());
	            String fechaEntrada = fechaEntradaField.getText();
	            String fechaSalida = fechaSalidaField.getText();

	            System.out.println("Intentando guardar la reserva...");
	            reserva nuevaReserva = new reserva(idMascota, fechaEntrada, fechaSalida);

	            if (empleadoController.guardarReserva(nuevaReserva)) {
	                JOptionPane.showMessageDialog(this, "Alojamiento asignado con éxito.");
	            } else {
	                JOptionPane.showMessageDialog(this, "Error al asignar el alojamiento.");
	            }
	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "El ID de la mascota debe ser un número.");
	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage());
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new DarAlojamiento().setVisible(true);
	            }
	        });
	    }
	}
