package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;

public class MenuVeterinaria extends JFrame {
	
	

	private JPanel contentPane;

    public MenuVeterinaria() { // Constructor de la clase
        setTitle("Menú Veterinaria");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Botón para generar reporte médico
        JButton btnGenerarReporte = new JButton("Generar Reporte Médico");
        btnGenerarReporte.setForeground(new Color(255, 255, 0));
        btnGenerarReporte.setBackground(new Color(0, 128, 192));
        btnGenerarReporte.setBounds(26, 94, 200, 30);
        btnGenerarReporte.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir interfaz para generar reporte médico
                new GenerarReporteMedico().setVisible(true);
            }
        });
        contentPane.add(btnGenerarReporte);

        // Botón para registrar consulta
        JButton btnRegistrarConsulta = new JButton("Registrar Consulta");
        btnRegistrarConsulta.setForeground(new Color(255, 255, 0));
        btnRegistrarConsulta.setBackground(new Color(0, 128, 192));
        btnRegistrarConsulta.setBounds(26, 135, 200, 30);
        btnRegistrarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Abrir interfaz para registrar consulta
                new RegistrarConsulta().setVisible(true);
            }
        });
        contentPane.add(btnRegistrarConsulta);

        // Botón para salir
        JButton btnSalir = new JButton("Salir");
        btnSalir.setBounds(150, 200, 100, 30);
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el menú actual
            }
        });
        contentPane.add(btnSalir);
        
        JLabel lblNewLabel = new JLabel("Bienvenido!");
        lblNewLabel.setForeground(new Color(0, 0, 255));
        lblNewLabel.setBounds(162, 33, 76, 14);
        contentPane.add(lblNewLabel);
    }

    // Método main para probar la interfaz
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuVeterinaria frame = new MenuVeterinaria();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
