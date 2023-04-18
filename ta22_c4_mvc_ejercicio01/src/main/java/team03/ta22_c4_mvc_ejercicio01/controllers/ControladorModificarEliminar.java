/**
 * 
 */
package team03.ta22_c4_mvc_ejercicio01.controllers;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaModificarEliminar;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControladorModificarEliminar implements ActionListener {

	LocalDate fecha = LocalDate.now();
	VistaModificarEliminar vistaModificarEliminar = new VistaModificarEliminar();
	VistaPrincipal vp = new VistaPrincipal();
	ModeloCliente modelo;
	private int IDSeleccionado;

	public ControladorModificarEliminar(ModeloCliente modelo, int IDParametro) {
		this.modelo = modelo;
		this.IDSeleccionado = IDParametro;
		this.vistaModificarEliminar.btnModificar.addActionListener(this);
		this.vistaModificarEliminar.btnEliminar.addActionListener(this);
		this.vistaModificarEliminar.btnCancelar.addActionListener(this);
	}

	public void iniciar() {
		vistaModificarEliminar.setVisible(true);
		obtenerDatosUsuario();
	}

	public void obtenerDatosUsuario() {
		modelo.consultarCliente(IDSeleccionado);
		vistaModificarEliminar.textFieldNombre.setText(modelo.getNombre());
		vistaModificarEliminar.textFieldApellido.setText(modelo.getApellido());
		vistaModificarEliminar.textFieldDNI.setText(Integer.toString(modelo.getDni()));
		vistaModificarEliminar.textFieldDireccion.setText(modelo.getDireccion());
	}

	public void cerrarVentanaVolver() {
		vistaModificarEliminar.setVisible(false);
		ControladorSeleccionar cs = new ControladorSeleccionar(modelo);
		cs.iniciarModificarEliminar();
	}

	public void cerrarVentanaVolverInicio() {
		vistaModificarEliminar.setVisible(false);
		ControladorInicio ci = new ControladorInicio(modelo, vp);
		ci.iniciarVista();
		ci.mostrarClientes();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (vistaModificarEliminar.btnModificar == e.getSource()) {

			modelo.modificarCliente(IDSeleccionado, vistaModificarEliminar.textFieldNombre.getText(),
					vistaModificarEliminar.textFieldApellido.getText(),
					vistaModificarEliminar.textFieldDireccion.getText(), vistaModificarEliminar.textFieldDNI.getText(),
					fecha.toString());
			cerrarVentanaVolverInicio();

		} else if (vistaModificarEliminar.btnEliminar == e.getSource()) {

			JLabel label = new JLabel("<html><h1>¿Eliminar el cliente " + modelo.getNombre() + " (id: " + IDSeleccionado
					+ ")?</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			int input = JOptionPane.showConfirmDialog(vistaModificarEliminar.contentPane, label, "Eliminar Cliente",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (input == 0) {
				modelo.eliminarCliente(IDSeleccionado);
				cerrarVentanaVolverInicio();
			}

		} else if (vistaModificarEliminar.btnCancelar == e.getSource()) {
			cerrarVentanaVolver();
		}
	}

}
