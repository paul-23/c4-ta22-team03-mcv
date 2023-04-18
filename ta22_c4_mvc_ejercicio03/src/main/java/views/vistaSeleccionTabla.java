package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.ControladorInicio;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vistaSeleccionTabla extends JFrame {
	public JButton btnCientificos;
	private JPanel contentPane;
	public JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public vistaSeleccionTabla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sobre que tabla quieres actuar");
		lblNewLabel.setBounds(105, 11, 202, 14);
		contentPane.add(lblNewLabel);

		 btnNewButton = new JButton("Proyectos");
		btnNewButton.setBounds(105, 60, 117, 34);
		contentPane.add(btnNewButton);

		 btnCientificos = new JButton("Cientificos");
		btnCientificos.setBounds(105, 121, 117, 34);
		contentPane.add(btnCientificos);
		
	}
}
