package controllers;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.Cliente;
import models.DataBase;
import models.Videos;
import views.VistaModificarEliminarCliente;
import views.VistaPrincipal;

public class ControllerModiCliente implements ActionListener {
	LocalDate fecha = LocalDate.now();
	VistaModificarEliminarCliente vistaME = new VistaModificarEliminarCliente();
	VistaPrincipal vp = new VistaPrincipal();
	Cliente cliente;
	DataBase db;
	Videos video;
	private int IDSeleccionado;

	public ControllerModiCliente(DataBase db, Cliente cliente, int id) {
		this.cliente = cliente;
		this.IDSeleccionado = id;
		this.db = db;
		this.vistaME.btnModificar.addActionListener(this);
		this.vistaME.btnEliminar.addActionListener(this);
		this.vistaME.btnCancelar.addActionListener(this);
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		vistaME.setVisible(true);
	}
	
	public void cerrarVentanaVolverInicio() {
		vistaME.setVisible(false);
		ControllerPrincipal ci = new ControllerPrincipal(db,cliente,video, vp);
		ci.iniciarVista();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaME.btnModificar == e.getSource()) {

			cliente.modificarCliente(IDSeleccionado, vistaME.textFieldNombre.getText(),
					vistaME.textFieldApellido.getText(),
					vistaME.textFieldDireccion.getText(), vistaME.textFieldDNI.getText(),
					fecha.toString());
			cerrarVentanaVolverInicio();

		} else if (vistaME.btnEliminar == e.getSource()) {

			JLabel label = new JLabel("<html><h1>¿Eliminar el cliente " + "Jose" + " (id: " + IDSeleccionado
					+ ")?</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			int input = JOptionPane.showConfirmDialog(vistaME.contentPane, label, "Eliminar Cliente",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (input == 0) {
//				cliente.eliminarCliente(IDSeleccionado);
				cerrarVentanaVolverInicio();
			}

		} else if (vistaME.btnCancelar == e.getSource()) {
//			cerrarVentanaVolver();
			cerrarVentanaVolverInicio();
		}
	}

}
