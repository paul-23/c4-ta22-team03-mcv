package team03.ta22_c4_mvc_ejercicio01.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAñadir extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public VistaAñadir() {
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
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(407, 88, 221, 44);
		contentPane.add(textField);
		
		JLabel lblNewLabel_2_1 = new JLabel("Dirección:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(28, 157, 122, 44);
		contentPane.add(lblNewLabel_2_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_1.setColumns(10);
		textField_1.setBounds(125, 157, 747, 44);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("DNI:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(643, 88, 54, 44);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_2.setColumns(10);
		textField_2.setBounds(696, 88, 176, 44);
		contentPane.add(textField_2);
		
		JButton btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAñadir.setBounds(315, 231, 142, 44);
		contentPane.add(btnAñadir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(467, 231, 142, 44);
		contentPane.add(btnCancelar);
	}
}
