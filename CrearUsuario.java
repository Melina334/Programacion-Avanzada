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

import DLL.usuarioController;
import java.awt.Color;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
    private JTextField txtMail, txtContrasena, txtRol, txtNombre;

    public CrearUsuario() {
        setTitle("Crear Usuario");
        setBounds(100, 100, 400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblMail = new JLabel("Correo:");
        lblMail.setForeground(new Color(128, 0, 255));
        lblMail.setBounds(50, 50, 100, 25);
        contentPane.add(lblMail);

        txtMail = new JTextField();
        txtMail.setBounds(150, 50, 200, 25);
        contentPane.add(txtMail);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(new Color(128, 0, 255));
        lblContrasena.setBounds(50, 90, 100, 25);
        contentPane.add(lblContrasena);

        txtContrasena = new JTextField();
        txtContrasena.setBounds(150, 90, 200, 25);
        contentPane.add(txtContrasena);

        JLabel lblRol = new JLabel("Rol:");
        lblRol.setForeground(new Color(128, 0, 255));
        lblRol.setBounds(50, 130, 100, 25);
        contentPane.add(lblRol);

        txtRol = new JTextField();
        txtRol.setBounds(150, 130, 200, 25);
        contentPane.add(txtRol);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(128, 0, 255));
        lblNombre.setBounds(50, 170, 100, 25);
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 170, 200, 25);
        contentPane.add(txtNombre);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBackground(new Color(0, 255, 255));
        btnGuardar.setForeground(new Color(255, 0, 255));
        btnGuardar.setBounds(150, 220, 100, 30);
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String mail = txtMail.getText();
                String contrasena = txtContrasena.getText();
                String rol = txtRol.getText();
                String nombre = txtNombre.getText();
                if (usuarioController.crearUsuario(new usuario(mail, contrasena, rol, nombre))) {
                    JOptionPane.showMessageDialog(null, "Usuario creado con éxito.");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al crear usuario.");
                }
            }
        });
        contentPane.add(btnGuardar);
    }
}
