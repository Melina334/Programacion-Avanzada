package GUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import DLL.usuarioController;
import GUI.usuario;

public class PantallaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldMail;
    private JPasswordField textFieldPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PantallaLogin frame = new PantallaLogin();
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
    public PantallaLogin() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\daver\\Downloads\\images (1).jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel Titulo = new JLabel("Inicia sesión");
        Titulo.setForeground(new Color(255, 0, 255));
        Titulo.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        Titulo.setBounds(147, 25, 134, 31);
        contentPane.add(Titulo);

        textFieldMail = new JTextField();
        textFieldMail.setBounds(55, 81, 181, 20);
        contentPane.add(textFieldMail);
        textFieldMail.setColumns(10);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
        lblUsuario.setBounds(45, 56, 46, 14);
        contentPane.add(lblUsuario);

        textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(55, 143, 181, 20);
        contentPane.add(textFieldPassword);

        JLabel lblContraseña = new JLabel("Contraseña");
        lblContraseña.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
        lblContraseña.setBounds(45, 118, 82, 14);
        contentPane.add(lblContraseña);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setForeground(new Color(255, 0, 255));
        btnIngresar.addActionListener(e -> autenticarUsuario());
        btnIngresar.setBounds(109, 174, 89, 23);
        contentPane.add(btnIngresar);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\daver\\Downloads\\images (1).jpg"));
        lblNewLabel.setBounds(264, 67, 139, 130);
        contentPane.add(lblNewLabel);
    }

    /**
     * Método para autenticar al usuario.
     */
    private void autenticarUsuario() {
        String mail = textFieldMail.getText();
        String contrasena = new String(textFieldPassword.getPassword());

        usuario usuario = usuarioController.buscarUsuario(mail, contrasena);

        if (usuario == null) {
            JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.");
        } else {
            JOptionPane.showMessageDialog(this, "Bienvenido, " + usuario.getNombre());
            abrirMenuSegunRol(usuario);
        }
    }

    /**
     * Método para abrir el menú según el rol del usuario.
     */
    private void abrirMenuSegunRol(usuario usuario) {
        this.dispose(); // Cierra la ventana de inicio de sesión.
        main.mostrarMenuSegunRol(usuario); // Llama a la función en `main` para manejar el flujo.
    }
}