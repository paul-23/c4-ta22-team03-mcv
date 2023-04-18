package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class VistaAñadirVideo extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JTextField textFieldNombre, textFieldApellido, textFieldDireccion, textFieldDNI;
	public JButton btnAñadir, btnCancelar;

	public VistaAñadirVideo() {
		setTitle("Añadir Usuario");
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
		
		JLabel lblNewLabel_1 = new JLabel("Añadir Clientes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(323, 11, 250, 44);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNombre.setBounds(125, 88, 176, 44);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		lblApellido.setBounds(323, 88, 84, 44);
		contentPane.add(lblApellido);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(407, 88, 221, 44);
		contentPane.add(textFieldApellido);
		
		JLabel lblNewLabel_2_1 = new JLabel("Dirección:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(28, 157, 122, 44);
		contentPane.add(lblNewLabel_2_1);
		
		textFieldDireccion = new JTextField();
		textFieldDireccion.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldDireccion.setColumns(10);
		textFieldDireccion.setBounds(125, 157, 747, 44);
		contentPane.add(textFieldDireccion);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DNI:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(643, 88, 54, 44);
		contentPane.add(lblNewLabel_2_1_1);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldDNI.setColumns(10);
		textFieldDNI.setBounds(696, 88, 176, 44);
		contentPane.add(textFieldDNI);
		
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
