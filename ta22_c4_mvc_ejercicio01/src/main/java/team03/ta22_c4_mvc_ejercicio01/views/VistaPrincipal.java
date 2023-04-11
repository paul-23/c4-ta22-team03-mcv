package team03.ta22_c4_mvc_ejercicio01.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JButton btnAñadirCliente, btnModificarCliente, btnEliminarCliente, btnConsultarCliente;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setResizable(false);
		setBounds(100, 100, 433, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoje una opción");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 36, 268, 52);
		contentPane.add(lblNewLabel);
		
		btnAñadirCliente = new JButton("Añadir Cliente");
		btnAñadirCliente.setBounds(45, 138, 150, 46);
		contentPane.add(btnAñadirCliente);
		
		btnModificarCliente = new JButton("Modificar Cliente");
		btnModificarCliente.setBounds(207, 138, 150, 46);
		contentPane.add(btnModificarCliente);
		
		btnEliminarCliente = new JButton("Eliminar Cliente");
		btnEliminarCliente.setBounds(45, 195, 150, 46);
		contentPane.add(btnEliminarCliente);
		
		btnConsultarCliente = new JButton("Consultar Cliente");
		btnConsultarCliente.setBounds(207, 195, 150, 46);
		contentPane.add(btnConsultarCliente);
	}
}
