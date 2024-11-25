package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class GenerarReporteMedico extends JFrame {

	 private JPanel contentPane;
	    private JTextField idMascotaField;
	    private JTextArea reporteField;

	    public GenerarReporteMedico() {
	        setTitle("Generar Reporte Médico");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 400, 300);

	        contentPane = new JPanel();
	        contentPane.setLayout(null);
	        setContentPane(contentPane);

	        JLabel lblIdMascota = new JLabel("ID Mascota:");
	        lblIdMascota.setForeground(new Color(0, 0, 255));
	        lblIdMascota.setBounds(30, 30, 100, 25);
	        contentPane.add(lblIdMascota);

	        idMascotaField = new JTextField();
	        idMascotaField.setBounds(130, 30, 200, 25);
	        contentPane.add(idMascotaField);

	        JLabel lblReporte = new JLabel("Reporte:");
	        lblReporte.setForeground(new Color(0, 0, 255));
	        lblReporte.setBounds(30, 70, 100, 25);
	        contentPane.add(lblReporte);

	        reporteField = new JTextArea();
	        JScrollPane scrollPane = new JScrollPane(reporteField);
	        scrollPane.setBounds(130, 70, 200, 100);
	        contentPane.add(scrollPane);

	        JButton btnGuardar = new JButton("Guardar");
	        btnGuardar.setForeground(new Color(255, 255, 0));
	        btnGuardar.setBackground(new Color(0, 128, 192));
	        btnGuardar.setBounds(150, 200, 100, 30);
	        btnGuardar.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String idMascota = idMascotaField.getText();
	                String reporte = reporteField.getText();

	                if (idMascota.isEmpty() || reporte.isEmpty()) {
	                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
	                    return;
	                }

	                // Lógica para guardar el reporte médico (llamar a un controlador)
	                boolean exito = guardarReporte(idMascota, reporte);
	                if (exito) {
	                    JOptionPane.showMessageDialog(null, "Reporte guardado con éxito.");
	                    dispose();
	                } else {
	                    JOptionPane.showMessageDialog(null, "Error al guardar el reporte.");
	                }
	            }
	        });
	        contentPane.add(btnGuardar);
	    }

	    private boolean guardarReporte(String idMascota, String reporte) {
	        // Implementar la lógica para guardar el reporte médico en la base de datos
	        return true; // Cambiar por el resultado real
	    }
	}
