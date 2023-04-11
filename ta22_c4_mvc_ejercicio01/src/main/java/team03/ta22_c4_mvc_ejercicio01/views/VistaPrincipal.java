package team03.ta22_c4_mvc_ejercicio01.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setBounds(100, 100, 417, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoje una opción");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 36, 268, 52);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Añadir Cliente");
		btnNewButton.setBounds(45, 138, 150, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1_1_1 = new JButton("Consultar Cliente");
		btnNewButton_1_1_1.setBounds(207, 138, 150, 46);
		contentPane.add(btnNewButton_1_1_1);
	}
}
