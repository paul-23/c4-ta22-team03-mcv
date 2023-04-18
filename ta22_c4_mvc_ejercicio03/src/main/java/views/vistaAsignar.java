package views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class vistaAsignar extends JFrame {

	private JPanel contentPane;
	public JButton btnAñadirAsignacion;
	public JButton btnConsultarAsignacion;
	public JButton btnModificarCientifico;
	public JButton btnEliminarAsignacion;
	public JTable table;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public vistaAsignar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
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
		
		btnAñadirAsignacion = new JButton("Añadir Asignación");
		btnAñadirAsignacion.setBounds(45, 138, 150, 46);
		contentPane.add(btnAñadirAsignacion);
		
		btnConsultarAsignacion = new JButton("Consultar Asignación");
		btnConsultarAsignacion.setBounds(207, 195, 150, 46);
		contentPane.add(btnConsultarAsignacion);
		
		table = new JTable();
		table.setEnabled(false);
		table.setBounds(41, 190, 870, 486);
		contentPane.add(table);

}}
