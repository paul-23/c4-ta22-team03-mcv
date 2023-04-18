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
	public JTextField textFieldIDAsignacion;
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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Selecciona un Proyecto");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 42, 255, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Proyecto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 156, 132, 29);
		contentPane.add(lblNewLabel_1);
		
		 textFieldIDAsignacion = new JTextField();
		textFieldIDAsignacion.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldIDAsignacion.setBounds(164, 147, 197, 46);
		contentPane.add(textFieldIDAsignacion);
		textFieldIDAsignacion.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBuscar.setBounds(38, 249, 150, 46);
		contentPane.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(211, 249, 150, 46);
		contentPane.add(btnCancelar);
	}

}
