package GUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import BLL.mascota;
import DLL.empleadoController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEmpleado extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel panelMenuPrincipal;
	private JPanel panelRegistrarMascota;
	private JTextField nombreField;
	private JTextField edadField;
	private JTextField razaField;
	private JTextField comportamientoField;
	private JTextField pesoField;
	private JTextField alturaField;
	private JTextField patologiasField;
	private JTextField observacionesField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEmpleado frame = new MenuEmpleado();
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
	public MenuEmpleado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0)); // CardLayout para cambiar de paneles

		cardLayout = (CardLayout) contentPane.getLayout();

		// Panel principal con los botones del menú
		panelMenuPrincipal = new JPanel();
		contentPane.add(panelMenuPrincipal, "MenuPrincipal");
		panelMenuPrincipal.setLayout(null);

		JLabel bienvenidoEmpleado = new JLabel("¡Bienvenido!");
		bienvenidoEmpleado.setForeground(new Color(255, 0, 255));
		bienvenidoEmpleado.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 16));
		bienvenidoEmpleado.setBounds(174, 31, 106, 27);
		panelMenuPrincipal.add(bienvenidoEmpleado);

		// Botón: Registrar Mascota
		JButton buttonRegistrarM = new JButton("Registrar Mascota");
		buttonRegistrarM.setBackground(new Color(0, 255, 255));
		buttonRegistrarM.setForeground(new Color(255, 0, 255));
		buttonRegistrarM.setBounds(39, 83, 176, 27);
		buttonRegistrarM.addActionListener(e -> mostrarPanel("RegistrarMascota"));
		panelMenuPrincipal.add(buttonRegistrarM);

		// Botón: Ver Mascotas
		JButton buttonVerMascotas = new JButton("Ver Mascotas");
		buttonVerMascotas.setBackground(new Color(0, 255, 255));
		buttonVerMascotas.setForeground(new Color(255, 0, 255));
		buttonVerMascotas.setBounds(39, 126, 176, 27);
		buttonVerMascotas.addActionListener(e -> {
			// Crear y mostrar la ventana VerMascotas
			VerMascotas frame = new VerMascotas();
			frame.setVisible(true); // Mostrar la ventana de Ver Mascotas
		});
		panelMenuPrincipal.add(buttonVerMascotas);

		// Botón: Generar Factura
		JButton buttonGenerarFactura = new JButton("Generar Factura");
		buttonGenerarFactura.setForeground(new Color(255, 0, 255)); // Color de texto fucsia
		buttonGenerarFactura.setBackground(new Color(0, 255, 255)); // Fondo cian
		buttonGenerarFactura.setBounds(39, 164, 176, 27); // Establecer la posición y tamaño del botón
		buttonGenerarFactura.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Abrir el JFrame para generar la factura
				new GenerarFactura().setVisible(true);
			}
		});

		panelMenuPrincipal.add(buttonGenerarFactura);

		JButton buttonReservar = new JButton("Dar Alojamiento");
		buttonReservar.setForeground(new Color(255, 0, 255));
		buttonReservar.setBackground(new Color(0, 255, 255));
		buttonReservar.setBounds(39, 204, 176, 27);
		buttonReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aquí abrimos la ventana DarAlojamiento
				new DarAlojamiento().setVisible(true);
			}
		});

		// Agregar el botón al panel principal

		panelMenuPrincipal.add(buttonReservar);

		JButton btnDarTurno = new JButton("Dar Turno");
		btnDarTurno.setForeground(new Color(255, 0, 255)); // Texto color magenta
		btnDarTurno.setBackground(new Color(0, 255, 255)); // Fondo color cian
		btnDarTurno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Abrir la ventana DarTurno
				DarTurno ventanaDarTurno = new DarTurno();
				ventanaDarTurno.setVisible(true);
			}
		});
		btnDarTurno.setBounds(39, 242, 176, 27);
		panelMenuPrincipal.add(btnDarTurno);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\daver\\Downloads\\images (4).jpg"));
		lblNewLabel.setBounds(237, 52, 200, 250);
		panelMenuPrincipal.add(lblNewLabel);

		// Panel de Registrar Mascota
		panelRegistrarMascota = new JPanel();
		contentPane.add(panelRegistrarMascota, "RegistrarMascota");
		panelRegistrarMascota.setLayout(null);

		// Títulos y campos del formulario
		JLabel labelRegistrar = new JLabel("Registrar Mascota");
		labelRegistrar.setForeground(new Color(255, 0, 128));
		labelRegistrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelRegistrar.setBounds(150, 10, 150, 30);
		panelRegistrarMascota.add(labelRegistrar);

		// Añadir los campos de entrada para registrar la mascota
		JLabel labelNombre = new JLabel("Nombre:");
		labelNombre.setBounds(30, 50, 80, 25);
		panelRegistrarMascota.add(labelNombre);
		nombreField = new JTextField();
		nombreField.setBounds(120, 50, 200, 25);
		panelRegistrarMascota.add(nombreField);

		JLabel labelEdad = new JLabel("Edad:");
		labelEdad.setBounds(30, 90, 80, 25);
		panelRegistrarMascota.add(labelEdad);
		edadField = new JTextField();
		edadField.setBounds(120, 90, 200, 25);
		panelRegistrarMascota.add(edadField);

		JLabel labelRaza = new JLabel("Raza:");
		labelRaza.setBounds(30, 130, 80, 25);
		panelRegistrarMascota.add(labelRaza);
		razaField = new JTextField();
		razaField.setBounds(120, 130, 200, 25);
		panelRegistrarMascota.add(razaField);

		JLabel labelComportamiento = new JLabel("Comportamiento:");
		labelComportamiento.setBounds(30, 170, 120, 25);
		panelRegistrarMascota.add(labelComportamiento);
		comportamientoField = new JTextField();
		comportamientoField.setBounds(120, 170, 200, 25);
		panelRegistrarMascota.add(comportamientoField);

		JLabel labelPeso = new JLabel("Peso (kg):");
		labelPeso.setBounds(30, 210, 80, 25);
		panelRegistrarMascota.add(labelPeso);
		pesoField = new JTextField();
		pesoField.setBounds(120, 210, 200, 25);
		panelRegistrarMascota.add(pesoField);

		JLabel labelAltura = new JLabel("Altura (cm):");
		labelAltura.setBounds(30, 250, 80, 25);
		panelRegistrarMascota.add(labelAltura);
		alturaField = new JTextField();
		alturaField.setBounds(120, 250, 200, 25);
		panelRegistrarMascota.add(alturaField);

		JLabel labelPatologias = new JLabel("Patologías:");
		labelPatologias.setBounds(30, 290, 80, 25);
		panelRegistrarMascota.add(labelPatologias);
		patologiasField = new JTextField();
		patologiasField.setBounds(120, 290, 200, 25);
		panelRegistrarMascota.add(patologiasField);

		JLabel labelObservaciones = new JLabel("Observaciones:");
		labelObservaciones.setBounds(30, 330, 100, 25);
		panelRegistrarMascota.add(labelObservaciones);
		observacionesField = new JTextField();
		observacionesField.setBounds(120, 330, 200, 25);
		panelRegistrarMascota.add(observacionesField);

		// Botón para registrar la mascota
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBackground(new Color(0, 255, 255));
		btnRegistrar.setForeground(new Color(255, 0, 255));
		btnRegistrar.setBounds(330, 196, 120, 25);
		btnRegistrar.addActionListener(e -> registrarMascota());
		panelRegistrarMascota.add(btnRegistrar);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(new Color(255, 0, 255));
		btnVolver.setBackground(new Color(0, 255, 255));
		btnVolver.setBounds(330, 233, 120, 25);
		panelRegistrarMascota.add(btnVolver);
		btnVolver.addActionListener(e -> mostrarPanel("MenuPrincipal"));
	}

	// Método para cambiar entre paneles
	private void mostrarPanel(String nombrePanel) {
		cardLayout.show(contentPane, nombrePanel);
	}

	// Este es el método para registrar la mascota
	private void registrarMascota() {
		String nombre = nombreField.getText();
		int edad = Integer.parseInt(edadField.getText());
		String raza = razaField.getText();
		String comportamiento = comportamientoField.getText();
		double peso = Double.parseDouble(pesoField.getText());
		double altura = Double.parseDouble(alturaField.getText());
		String patologias = patologiasField.getText();
		String observaciones = observacionesField.getText();

		// Registrar la mascota
		empleadoController.registrarMascota(nombre, edad, raza, comportamiento, peso, altura, patologias,
				observaciones);
	}
}
