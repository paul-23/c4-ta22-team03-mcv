package team03.ta22_c4_mvc_ejercicio01.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JButton btnAñadirCliente, btnModificarEliminarCliente;
	public JTable table;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setResizable(false);
		setBounds(100, 100, 966, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoje una opción");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(218, 36, 516, 52);
		contentPane.add(lblNewLabel);
		
		btnAñadirCliente = new JButton("Añadir Cliente");
		btnAñadirCliente.setFont(new Font("Arial", Font.PLAIN, 19));
		btnAñadirCliente.setBounds(116, 111, 177, 46);
		contentPane.add(btnAñadirCliente);
		
		btnModificarEliminarCliente = new JButton("Consultar / Modificar / Eliminar Cliente");
		btnModificarEliminarCliente.setFont(new Font("Arial", Font.PLAIN, 19));
		btnModificarEliminarCliente.setBounds(338, 111, 495, 46);
		contentPane.add(btnModificarEliminarCliente);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBounds(41, 190, 870, 486);
		contentPane.add(table);
	}
}
