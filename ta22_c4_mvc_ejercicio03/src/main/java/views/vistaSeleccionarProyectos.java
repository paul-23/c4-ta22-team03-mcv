package views;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class vistaSeleccionarProyectos extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public static JTextField textFieldIDProyectos;
	public JButton btnBuscar;
	private JButton btnCancelar;

	public vistaSeleccionarProyectos() {
		setBounds(100, 100, 409, 381);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona un Proyecto");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(70, 42, 255, 57);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID Proyecto");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 156, 132, 29);
		contentPane.add(lblNewLabel_1);
		
		textFieldIDProyectos = new JTextField();
		textFieldIDProyectos.setFont(new Font("Arial", Font.PLAIN, 20));
		textFieldIDProyectos.setBounds(164, 147, 197, 46);
		contentPane.add(textFieldIDProyectos);
		textFieldIDProyectos.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnBuscar.setBounds(38, 249, 150, 46);
		contentPane.add(btnBuscar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(211, 249, 150, 46);
		contentPane.add(btnCancelar);
	}
}
