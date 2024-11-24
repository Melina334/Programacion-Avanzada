package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DLL.empleadoController;
import java.util.List;

public class VerMascotas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JList<String> listMascotas;  // JList para mostrar las mascotas
    private DefaultListModel<String> listModel;  // Modelo de datos para la lista

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VerMascotas frame = new VerMascotas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VerMascotas() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Cambio a DISPOSE_ON_CLOSE para que no cierre toda la app
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout());


        listModel = new DefaultListModel<>();
        
    
        listMascotas = new JList<>(listModel);
        listMascotas.setForeground(new Color(255, 0, 255));
        JScrollPane scrollPane = new JScrollPane(listMascotas);
        contentPane.add(scrollPane, BorderLayout.CENTER);

     
        cargarMascotas();
    }

    /**
     * Cargar las mascotas en la lista.
     * Obtiene las mascotas desde el controlador y las agrega al JList.
     */
    private void cargarMascotas() {
       
        List<String> mascotas = empleadoController.verMascotasRegistradas();

        
        listModel.clear();

        
        for (String mascota : mascotas) {
            listModel.addElement(mascota);
        }
    }
}
