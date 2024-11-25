package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class MenuAdministrador extends JFrame {

	 private JPanel contentPane;

	    public MenuAdministrador() {
	        // Configuración básica de la ventana
	        setTitle("Menú Administrador");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(100, 100, 457, 353);
	        contentPane = new JPanel();
	        contentPane.setLayout(null);
	        setContentPane(contentPane);

	        // Botón para Crear Usuario
	        JButton btnCrearUsuario = new JButton("Crear Usuario");
	        btnCrearUsuario.setForeground(new Color(255, 0, 255));
	        btnCrearUsuario.setBackground(new Color(0, 255, 255));
	        btnCrearUsuario.setBounds(33, 101, 200, 30);
	        btnCrearUsuario.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Abrir la ventana CrearUsuario
	                new CrearUsuario().setVisible(true);
	            }
	        });
	        contentPane.add(btnCrearUsuario);

	        // Botón para Listar Usuarios
	        JButton btnListarUsuarios = new JButton("Listar Usuarios");
	        btnListarUsuarios.setForeground(new Color(255, 0, 255));
	        btnListarUsuarios.setBackground(new Color(0, 255, 255));
	        btnListarUsuarios.setBounds(33, 142, 200, 30);
	        btnListarUsuarios.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Abrir la ventana ListarUsuarios
	                new ListarUsuario().setVisible(true);
	            }
	        });
	        contentPane.add(btnListarUsuarios);

	        // Botón para Eliminar Usuario
	        JButton btnEliminarUsuario = new JButton("Eliminar Usuario");
	        btnEliminarUsuario.setForeground(new Color(255, 0, 255));
	        btnEliminarUsuario.setBackground(new Color(0, 255, 255));
	        btnEliminarUsuario.setBounds(33, 183, 200, 30);
	        btnEliminarUsuario.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Abrir la ventana EliminarUsuario
	                new EliminarUsuario().setVisible(true);
	            }
	        });
	        contentPane.add(btnEliminarUsuario);

	        // Botón para volver al menú principal
	        JButton btnVolverAdmin = new JButton("Salir");
	        btnVolverAdmin.setForeground(new Color(255, 0, 255));
	        btnVolverAdmin.setBackground(new Color(0, 255, 255));
	        btnVolverAdmin.setBounds(136, 249, 200, 30);
	        btnVolverAdmin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                dispose(); // Cierra la ventana actual
	                // Volver al menú principal
	                PantallaLogin PantallaLogin = new PantallaLogin();
	                PantallaLogin.setVisible(true);
	            }
	        });
	        contentPane.add(btnVolverAdmin);
	        
	        JLabel lblNewLabel = new JLabel("Bienvenido ");
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	        lblNewLabel.setForeground(new Color(255, 0, 255));
	        lblNewLabel.setBounds(188, 47, 111, 14);
	        contentPane.add(lblNewLabel);
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	                MenuAdministrador frame = new MenuAdministrador();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }
	}
