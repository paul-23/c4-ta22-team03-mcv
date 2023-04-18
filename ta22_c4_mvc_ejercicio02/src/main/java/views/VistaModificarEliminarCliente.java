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

public class VistaModificarEliminarCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JTextField textFieldNombre, textFieldApellido, textFieldDireccion, textFieldDNI;
	public JButton btnEliminar, btnCancelar, btnModificar;
	public JPanel contentPane;

	public VistaModificarEliminarCliente() {
		setTitle("Modificar / Eliminar Cliente");
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
		
		JLabel lblNewLabel_1 = new JLabel("Modificar / Eliminar Cliente");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(277, 11, 338, 44);
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
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEliminar.setBounds(403, 228, 142, 44);
		contentPane.add(btnEliminar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(555, 228, 142, 44);
		contentPane.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnModificar.setBounds(250, 228, 142, 44);
		contentPane.add(btnModificar);
	}

}
