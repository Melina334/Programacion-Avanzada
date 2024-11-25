package GUI;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DLL.usuarioController;

public class ListarUsuario extends JFrame {

	 private JPanel contentPane;
	    private JTable table;

	    public ListarUsuario() {
	        setTitle("Listar Usuarios");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 600, 400);

	        // Panel principal
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        contentPane.setLayout(null);
	        setContentPane(contentPane);

	        // Crear la tabla y modelo
	        String[] columnNames = {"Correo", "Contraseña", "Rol", "Nombre"};
	        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0); // Modelo vacío
	        table = new JTable(tableModel);

	        // Agregar datos a la tabla
	        llenarTabla(tableModel);

	        // Agregar la tabla a un JScrollPane
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(20, 20, 550, 300); // Tamaño y posición del panel con scroll
	        contentPane.add(scrollPane);

	        // Botón para cerrar la ventana
	        JButton btnCerrar = new JButton("Cerrar");
	        btnCerrar.setBounds(250, 330, 100, 30);
	        btnCerrar.addActionListener(e -> dispose()); // Cierra la ventana actual
	        contentPane.add(btnCerrar);
	    }

	    private void llenarTabla(DefaultTableModel tableModel) {
	        try {
	            // Llamar al método de usuarioController para obtener la lista de usuarios
	            ArrayList<usuario> usuarios = usuarioController.obtenerUsuarios();

	            // Llenar el modelo de la tabla con los datos
	            for (usuario u : usuarios) {
	                Object[] rowData = {
	                
	                    u.getMail(), // Correo
	                    u.getContraseña(), // Contraseña
	                    u.getRol(), // Rol
	                    u.getNombre() // Nombre
	                };
	                tableModel.addRow(rowData);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(this, "Error al listar usuarios: " + e.getMessage());
	        }
	    }
	}