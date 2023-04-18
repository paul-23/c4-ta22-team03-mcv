package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JButton btnAñadirCliente, btnModificarEliminarCliente, btnAñadirVideo, btnModificarEliminarVideo;
	public JLabel label1;

	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setResizable(false);
		setBounds(100, 100, 966, 739);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnAñadirCliente = new JButton("Añadir Cliente");
		btnAñadirCliente.setFont(new Font("Arial", Font.PLAIN, 19));
		btnAñadirCliente.setBounds(116, 111, 177, 46);
		contentPane.add(btnAñadirCliente);
		
		btnModificarEliminarCliente = new JButton("Consultar / Modificar / Eliminar Cliente");
		btnModificarEliminarCliente.setFont(new Font("Arial", Font.PLAIN, 19));
		btnModificarEliminarCliente.setBounds(338, 111, 495, 46);
		contentPane.add(btnModificarEliminarCliente);
		
		btnAñadirVideo = new JButton("Añadir Video");
		btnAñadirVideo.setFont(new Font("Arial", Font.PLAIN, 19));
		btnAñadirVideo.setBounds(116, 180, 177, 46);
		contentPane.add(btnAñadirVideo);
		
		btnModificarEliminarVideo = new JButton("Consultar / Modificar / Eliminar Video");
		btnModificarEliminarVideo.setFont(new Font("Arial", Font.PLAIN, 19));
		btnModificarEliminarVideo.setBounds(338, 180, 495, 46);
		contentPane.add(btnModificarEliminarVideo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 274, 870, 382);
		contentPane.add(scrollPane);
		
		JLabel label1 = new JLabel("New label");
		scrollPane.setViewportView(label1);
	}
}

