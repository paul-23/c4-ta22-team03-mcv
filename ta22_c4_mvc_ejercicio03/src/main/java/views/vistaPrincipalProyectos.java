package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class vistaPrincipalProyectos extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JButton btnAñadirProyecto;
	public JButton btnModificarProyecto; 
	public JButton btnEliminarProyecto;
	public JButton btnConsultarProyecto;

	/**
	 * Create the frame.
	 */
	public vistaPrincipalProyectos() {
		setResizable(false);
		setBounds(100, 100, 433, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoje una opción");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(61, 36, 268, 52);
		contentPane.add(lblNewLabel);
		
		btnAñadirProyecto = new JButton("Añadir Proyecto");
		btnAñadirProyecto.setBounds(45, 138, 150, 46);
		contentPane.add(btnAñadirProyecto);
		
		btnModificarProyecto = new JButton("Modificar Proyecto");
		btnModificarProyecto.setBounds(207, 138, 150, 46);
		contentPane.add(btnModificarProyecto);
		
		btnEliminarProyecto = new JButton("Eliminar Proyecto");
		btnEliminarProyecto.setBounds(45, 195, 150, 46);
		contentPane.add(btnEliminarProyecto);
		
		btnConsultarProyecto = new JButton("Consultar Proyecto");
		btnConsultarProyecto.setBounds(207, 195, 150, 46);
		contentPane.add(btnConsultarProyecto);
	}
}
