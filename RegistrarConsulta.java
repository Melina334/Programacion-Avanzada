package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class RegistrarConsulta extends JFrame {

	private JPanel contentPane;
    private JTextField idMascotaField;
    private JTextField servicioField;
    private JTextField fechaField;

    public RegistrarConsulta() {
        setTitle("Registrar Consulta");
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

        JLabel lblServicio = new JLabel("Servicio:");
        lblServicio.setForeground(new Color(0, 0, 255));
        lblServicio.setBounds(30, 70, 100, 25);
        contentPane.add(lblServicio);

        servicioField = new JTextField();
        servicioField.setBounds(130, 70, 200, 25);
        contentPane.add(servicioField);

        JLabel lblFecha = new JLabel("Fecha:");
        lblFecha.setForeground(new Color(0, 0, 255));
        lblFecha.setBounds(30, 110, 100, 25);
        contentPane.add(lblFecha);

        fechaField = new JTextField("YYYY-MM-DD");
        fechaField.setBounds(130, 110, 200, 25);
        contentPane.add(fechaField);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(150, 200, 100, 30);
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String idMascota = idMascotaField.getText();
                String servicio = servicioField.getText();
                String fecha = fechaField.getText();

                if (idMascota.isEmpty() || servicio.isEmpty() || fecha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios.");
                    return;
                }

                // Lógica para registrar la consulta (llamar a un controlador)
                boolean exito = registrarConsulta(idMascota, servicio, fecha);
                if (exito) {
                    JOptionPane.showMessageDialog(null, "Consulta registrada con éxito.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al registrar la consulta.");
                }
            }
        });
        contentPane.add(btnGuardar);
    }

    private boolean registrarConsulta(String idMascota, String servicio, String fecha) {
        // Implementar la lógica para registrar la consulta en la base de datos
        return true; // Cambiar por el resultado real
    }
}
