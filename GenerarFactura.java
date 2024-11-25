package GUI;

import BLL.mascota;
import DLL.empleadoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class GenerarFactura extends JFrame {

    private JComboBox<String> comboMascotas;
    private JTextField fechaField;
    private JTextField totalField;
    private JComboBox<String> estadoCombo;
    private JTextField servicioField;  // Campo para ingresar el servicio

    public GenerarFactura() {
        // Configuración básica del JFrame
        setTitle("Generar Factura");
        setSize(444, 345);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(6, 2));  // Cambiar a 6 filas para incluir el servicio

        // Obtener la lista de mascotas
        List<mascota> mascotas = empleadoController.obtenerMascotas();
        DefaultComboBoxModel<String> mascotaModel = new DefaultComboBoxModel<>();
        for (mascota m : mascotas) {
            mascotaModel.addElement(m.getNombre());
        }

        // Crear los componentes del formulario
        comboMascotas = new JComboBox<>(mascotaModel);
        fechaField = new JTextField("YYYY-MM-DD");  // Formato de fecha
        totalField = new JTextField();
        estadoCombo = new JComboBox<>(new String[]{"pendiente", "pagado", "anulado"});
        servicioField = new JTextField();  // Campo para ingresar el servicio

        // Crear botón para generar la factura
        JButton generarButton = new JButton("Generar Factura");
        generarButton.setBackground(new Color(0, 255, 255));
        generarButton.setForeground(new Color(255, 0, 255));
        generarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarFactura();
            }
        });

        // Agregar los componentes al JFrame
        JLabel label = new JLabel("Seleccionar Mascota:");
        label.setForeground(new Color(255, 0, 255));
        getContentPane().add(label);
        getContentPane().add(comboMascotas);
        JLabel label_1 = new JLabel("Fecha (YYYY-MM-DD):");
        label_1.setForeground(new Color(255, 0, 255));
        getContentPane().add(label_1);
        getContentPane().add(fechaField);
        JLabel label_2 = new JLabel("Total:");
        label_2.setForeground(new Color(255, 0, 255));
        getContentPane().add(label_2);
        getContentPane().add(totalField);
        JLabel label_3 = new JLabel("Estado:");
        label_3.setForeground(new Color(255, 0, 255));
        getContentPane().add(label_3);
        getContentPane().add(estadoCombo);
        JLabel label_4 = new JLabel("Servicio:");
        label_4.setForeground(new Color(255, 0, 255));
        getContentPane().add(label_4);  // Etiqueta para el servicio
        getContentPane().add(servicioField);  // Campo para ingresar el servicio
        
        getContentPane().add(generarButton);
    }

    private void generarFactura() {
        // Validación de los datos del formulario
        if (comboMascotas.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una mascota.");
            return;
        }

        String mascotaSeleccionada = (String) comboMascotas.getSelectedItem();
        String fechaString = fechaField.getText();
        String servicio = servicioField.getText();
        
        // Validar que la fecha tiene el formato correcto (YYYY-MM-DD)
        if (!fechaString.matches("\\d{4}-\\d{2}-\\d{2}")) {
            JOptionPane.showMessageDialog(this, "Fecha inválida. El formato debe ser YYYY-MM-DD.");
            return;
        }

        double total = 0;
        try {
            total = Double.parseDouble(totalField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El total debe ser un número válido.");
            return;
        }

        String estado = (String) estadoCombo.getSelectedItem();

        // Validar que el campo servicio no esté vacío
        if (servicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo 'Servicio' no puede estar vacío.");
            return;
        }

        // Convertir fecha a tipo Date
        java.sql.Date fecha = java.sql.Date.valueOf(fechaString);

        // Obtener el ID de la mascota seleccionada
        List<mascota> mascotas = empleadoController.obtenerMascotas();
        int idMascota = 0;
        for (mascota m : mascotas) {
            if (m.getNombre().equals(mascotaSeleccionada)) {
                idMascota = m.getIdMascota();
                break;
            }
        }

        // Llamar al método generarFactura de empleadoController, ahora incluyendo el servicio
        boolean exito = empleadoController.generarFactura(idMascota, fecha, total, estado, servicio);
        if (exito) {
            JOptionPane.showMessageDialog(this, "Factura generada con éxito.");
            dispose();  // Cerrar la ventana de generar factura
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar la factura.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GenerarFactura().setVisible(true));
    }
}