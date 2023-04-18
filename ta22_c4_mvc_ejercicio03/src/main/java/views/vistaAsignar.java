package views;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class vistaAsignar extends JFrame {

	private JPanel contentPane;
	public JButton btnCancelar;
	public JButton btnModificar;
	public JButton btnEliminar;

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

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnEliminar.setBounds(227, 223, 142, 44);
		contentPane.add(btnEliminar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnCancelar.setBounds(455, 243, 142, 44);
		contentPane.add(btnCancelar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.PLAIN, 20));
		btnModificar.setBounds(10, 243, 142, 44);
		contentPane.add(btnModificar);
	}

}
