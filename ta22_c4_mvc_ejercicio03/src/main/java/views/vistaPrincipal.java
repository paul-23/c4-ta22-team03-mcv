package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class vistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JButton btnAñadirCientifico;
	public JButton btnModificarCientifico; 
	public JButton btnEliminarCientifico;
	public JButton btnConsultarCientifico;
public JTable table;

	/**
	 * Create the frame.
	 */
	public vistaPrincipal() {
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
		
		btnAñadirCientifico = new JButton("Añadir Cientifico");
		btnAñadirCientifico.setBounds(45, 138, 150, 46);
		contentPane.add(btnAñadirCientifico);
		
		btnModificarCientifico = new JButton("Modificar Cientifico");
		btnModificarCientifico.setBounds(207, 138, 150, 46);
		contentPane.add(btnModificarCientifico);
		
		btnEliminarCientifico = new JButton("Eliminar Cientifico");
		btnEliminarCientifico.setBounds(45, 195, 150, 46);
		contentPane.add(btnEliminarCientifico);
		
		btnConsultarCientifico = new JButton("Consultar Cientifico");
		btnConsultarCientifico.setBounds(207, 195, 150, 46);
		contentPane.add(btnConsultarCientifico);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBounds(41, 190, 870, 486);
		contentPane.add(table);
	}
	}

