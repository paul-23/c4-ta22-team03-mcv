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

public class vistaAñadirProy extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton btnAñadir;
	public JButton btnCancelar;
	public JPanel contentPane;
	public static JTextField textFieldNombre;
	public static JTextField textFieldHoras;
	public static JTextField textFieldID;

	public vistaAñadirProy() {
		setTitle("Añadir Proyectos");
		setBounds(100, 100, 907, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 21, 122, 44);
		contentPane.add(lblNewLabel);
		
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNombre.setBounds(125, 21, 176, 44);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("ID:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(641, 144, 54, 44);
		contentPane.add(lblNewLabel_2_1_1);

		
		textFieldID = new JTextField();
		textFieldID.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldID.setColumns(10);
		textFieldID.setBounds(705, 144, 176, 44);
		contentPane.add(textFieldID);
		
		JLabel lblNewLabelhors = new JLabel("Horas:");
		lblNewLabelhors.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabelhors.setBounds(28, 144, 122, 44);
		contentPane.add(lblNewLabelhors);
		
		
		textFieldHoras = new JTextField();
		textFieldHoras.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldHoras.setBounds(125, 144, 176, 44);
		contentPane.add(textFieldHoras);
		textFieldHoras.setColumns(10);
		
		
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
