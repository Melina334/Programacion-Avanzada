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

public class EliminarUsuario extends JFrame {

	private JTextField txtId;

    public EliminarUsuario() {
        setTitle("Eliminar Usuario");
        setBounds(100, 100, 400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        JLabel lblId = new JLabel("ID del Usuario:");
        lblId.setForeground(new Color(255, 0, 255));
        lblId.setBounds(50, 50, 100, 25);
        contentPane.add(lblId);

        txtId = new JTextField();
        txtId.setBounds(150, 50, 200, 25);
        contentPane.add(txtId);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(255, 255, 0));
        btnEliminar.setForeground(new Color(255, 0, 255));
        btnEliminar.setBounds(150, 100, 100, 30);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(txtId.getText());
                    if (usuarioController.eliminarUsuario(id)) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado con éxito.");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el usuario.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "ID inválido.");
                }
            }
        });
        contentPane.add(btnEliminar);
    }
}
