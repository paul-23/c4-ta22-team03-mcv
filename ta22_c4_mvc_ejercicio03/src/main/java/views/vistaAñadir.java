package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class vistaAñadir extends JFrame {

	private static final long serialVersionUID = 1L;

	public JPanel contentPane;
	public JTextField textFieldNombre;
	public JButton btnAñadir;
	public JButton btnCancelar;

	public JTextField textField_2;


	public vistaAñadir() {
		setTitle("Añadir Cientifico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 88, 122, 44);
		contentPane.add(lblNewLabel);

		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNombre.setBounds(125, 88, 176, 44);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNewLabel_2_1_1 = new JLabel("DNI:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(643, 88, 54, 44);
		contentPane.add(lblNewLabel_2_1_1);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(696, 88, 176, 44);
		contentPane.add(textField_2);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAñadir.setBounds(315, 231, 142, 44);
		contentPane.add(btnAñadir);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(467, 231, 142, 44);
		contentPane.add(btnCancelar);
	}
}
