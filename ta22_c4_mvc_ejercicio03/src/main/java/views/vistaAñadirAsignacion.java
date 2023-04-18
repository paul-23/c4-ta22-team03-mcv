package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class vistaAñadirAsignacion extends JFrame {

	private static final long serialVersionUID = 1L;
	public JButton btnAñadir;
	public JButton btnCancelar;
	public JPanel contentPane;
	public static JTextField textField_DNI_C;
	public static JTextField textField_ID_P;

	public vistaAñadirAsignacion() {
		setTitle("Añadir Proyectos");
		setBounds(100, 100, 907, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl_DNI_cientifico = new JLabel("DNI Cientifico:");
		lbl_DNI_cientifico.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_DNI_cientifico.setBounds(43, 102, 142, 44);
		contentPane.add(lbl_DNI_cientifico);
		
		
		textField_DNI_C = new JTextField();
		textField_DNI_C.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_DNI_C.setBounds(195, 102, 232, 44);
		contentPane.add(textField_DNI_C);
		textField_DNI_C.setColumns(10);
		
		JLabel lbl_ID_proyecto = new JLabel("ID Proyecto:");
		lbl_ID_proyecto.setFont(new Font("Arial", Font.PLAIN, 20));
		lbl_ID_proyecto.setBounds(505, 102, 132, 44);
		contentPane.add(lbl_ID_proyecto);

		
		textField_ID_P = new JTextField();
		textField_ID_P.setFont(new Font("Arial", Font.PLAIN, 20));
		textField_ID_P.setColumns(10);
		textField_ID_P.setBounds(637, 102, 232, 44);
		contentPane.add(textField_ID_P);
		
		
		 btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Arial", Font.PLAIN, 20));
		btnAñadir.setBounds(313, 181, 142, 44);
		contentPane.add(btnAñadir);
		
		
		 btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(465, 181, 142, 44);
		contentPane.add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Asigna un cientifico a un proyecto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblNewLabel.setBounds(164, 28, 564, 44);
		contentPane.add(lblNewLabel);
	}
}
