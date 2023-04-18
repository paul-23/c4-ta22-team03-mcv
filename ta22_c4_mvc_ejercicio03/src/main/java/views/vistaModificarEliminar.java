package views;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class vistaModificarEliminar extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public JTextField textFieldNombre;
	public JTextField textFieldDNI;
	public JPanel contentPane;
	public JButton btnModificar;
	public JButton btnCancelar;
	public JButton btnEliminar;
	private JLabel lblAsignadoa;
	public JTextField textFieldAsignado;
	
	public vistaModificarEliminar() {
		setTitle("Modificar / Eliminar Cientifico");
		setBounds(100, 100, 907, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(28, 88, 122, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Modificar / Eliminar Cientifico");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(277, 11, 338, 44);
		contentPane.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldNombre.setBounds(125, 88, 176, 44);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
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
		
		lblAsignadoa = new JLabel("Asignado_a:");
		lblAsignadoa.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAsignadoa.setBounds(28, 180, 122, 44);
		contentPane.add(lblAsignadoa);
		
		textFieldAsignado = new JTextField();
		textFieldAsignado.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldAsignado.setColumns(10);
		textFieldAsignado.setBounds(160, 180, 176, 44);
		contentPane.add(textFieldAsignado);
	}

}
