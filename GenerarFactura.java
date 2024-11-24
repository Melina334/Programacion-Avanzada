package GUI;

import BLL.mascota;
import DLL.empleadoController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GenerarFactura extends JFrame {
    private static final long serialVersionUID = 1L;

    private JComboBox<Integer> comboBoxMascotas; // ComboBox que muestra solo IDs de las mascotas
    private JTextField servicioField; // Campo de texto para ingresar el servicio
    private JTextField montoField; // Campo de texto para ingresar el monto

    public GenerarFactura() {
        setTitle("Generar Factura");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);

        // Configurar el panel principal
        JPanel contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // Etiqueta para seleccionar la mascota
        JLabel labelSeleccionarMascota = new JLabel("Seleccionar Mascota (ID):");
        labelSeleccionarMascota.setBounds(30, 50, 150, 25);
        contentPane.add(labelSeleccionarMascota);

        // ComboBox para seleccionar la mascota
        comboBoxMascotas = new JComboBox<>();
        comboBoxMascotas.setBounds(180, 50, 200, 25);
        contentPane.add(comboBoxMascotas);

        // Cargar las mascotas en el ComboBox
        cargarMascotas();

        // Campo para ingresar el servicio realizado
        JLabel labelServicio = new JLabel("Servicio Realizado:");
        labelServicio.setBounds(30, 100, 150, 25);
        contentPane.add(labelServicio);

        servicioField = new JTextField();
        servicioField.setBounds(180, 100, 200, 25);
        contentPane.add(servicioField);

        // Campo para ingresar el monto de la factura
        JLabel labelMonto = new JLabel("Monto:");
        labelMonto.setBounds(30, 150, 150, 25);
        contentPane.add(labelMonto);

        montoField = new JTextField();
        montoField.setBounds(180, 150, 200, 25);
        contentPane.add(montoField);

        // Botón para generar la factura
        JButton btnGenerarFactura = new JButton("Generar Factura");
        btnGenerarFactura.setBounds(150, 200, 150, 30);
        btnGenerarFactura.addActionListener(e -> generarFactura());
        contentPane.add(btnGenerarFactura);
    }

    /**
     * Método para cargar los IDs de las mascotas en el ComboBox desde la base de datos.
     */
    private void cargarMascotas() {
        try {
            List<mascota> listaMascotas = empleadoController.obtenerMascotas(); // Obtener lista de mascotas
            comboBoxMascotas.removeAllItems(); // Limpiar el ComboBox antes de cargar los datos

            for (mascota m : listaMascotas) {
                comboBoxMascotas.addItem(m.getIdMascota()); // Agregar solo el ID de la mascota
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar las mascotas: " + e.getMessage());
        }
    }

    /**
     * Método para generar una factura con los datos ingresados por el usuario.
     */
    private void generarFactura() {
        Integer idMascota = (Integer) comboBoxMascotas.getSelectedItem(); // Obtener el ID de la mascota seleccionada
        if (idMascota == null) {
            JOptionPane.showMessageDialog(this, "Por favor selecciona una mascota.");
            return;
        }

        String servicio = servicioField.getText().trim(); // Obtener y limpiar el servicio ingresado
        if (servicio.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un servicio.");
            return;
        }

        double monto;
        try {
            monto = Double.parseDouble(montoField.getText().trim()); // Validar y convertir el monto
            if (monto <= 0) {
                throw new NumberFormatException("El monto debe ser mayor a cero.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor ingresa un monto válido.");
            return;
        }

        // Llamar al método del controlador para generar la factura
        boolean facturaGenerada = empleadoController.generarFactura(idMascota, servicio, monto);
        if (facturaGenerada) {
            JOptionPane.showMessageDialog(this, "Factura generada con éxito.");
            servicioField.setText("");
            montoField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error al generar la factura.");
        }
    }

    /**
     * Método principal para ejecutar la aplicación.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                GenerarFactura frame = new GenerarFactura();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}

