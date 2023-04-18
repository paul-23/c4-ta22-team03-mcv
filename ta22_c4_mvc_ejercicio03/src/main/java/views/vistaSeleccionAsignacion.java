package views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class vistaSeleccionAsignacion extends JFrame {

	private JPanel contentPane;
	public static JTextField textFieldIDAsignacion;
	public static  JTextField textFieldDNIAsignacion;
	public JButton btnBuscar;
	public JButton btnCancelar;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public vistaSeleccionAsignacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecciona un Proyecto");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 11, 259, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Proyecto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(34, 65, 121, 24);
		contentPane.add(lblNewLabel_1);
		
		textFieldIDAsignacion = new JTextField();
		textFieldIDAsignacion.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldIDAsignacion.setBounds(165, 62, 176, 30);
		contentPane.add(textFieldIDAsignacion);
		textFieldIDAsignacion.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("DNI Cientifico");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(34, 103, 121, 24);
		contentPane.add(lblNewLabel_11);
		
		textFieldDNIAsignacion = new JTextField();
		textFieldDNIAsignacion.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldDNIAsignacion.setBounds(165, 100, 176, 30);
		contentPane.add(textFieldDNIAsignacion);
		textFieldDNIAsignacion.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBuscar.setBounds(69, 153, 95, 33);
		contentPane.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(169, 153, 111, 33);
		contentPane.add(btnCancelar);
	}

}
