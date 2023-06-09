/**
 * 
 */
package controllers;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.ModelBDProy;
import views.vistaModificarEliminarProyectos;
import views.vistaPrincipal;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerModificarEliminarProyectos implements ActionListener {

	vistaModificarEliminarProyectos vistaModificarEliminarProyectos = new vistaModificarEliminarProyectos();
	vistaPrincipal vp = new vistaPrincipal();
	ModelBDProy modelo = new ModelBDProy();
	private int IDSeleccionado;

	public ControllerModificarEliminarProyectos(ModelBDProy modelo, int IDParametro) {
		this.modelo = modelo;
		this.IDSeleccionado = IDParametro;
		this.vistaModificarEliminarProyectos.btnModificar.addActionListener(this);
		this.vistaModificarEliminarProyectos.btnEliminar.addActionListener(this);
		this.vistaModificarEliminarProyectos.btnCancelar.addActionListener(this);
	}

	public void iniciar() {
		vistaModificarEliminarProyectos.setVisible(true);
		obtenerDatosUsuario();
	}

	public void obtenerDatosUsuario() {
		modelo.consultarproyectos(IDSeleccionado);
		vistaModificarEliminarProyectos.textFieldNombre.setText(modelo.getNombre());
		vistaModificarEliminarProyectos.textFieldID.setText(Integer.toString(modelo.getId()));
		vistaModificarEliminarProyectos.textField.setText(Integer.toString(modelo.getHoras()));

	}

	public void cerrarVentanaVolver() {
		vistaModificarEliminarProyectos.setVisible(false);
		ControllerSeleccionarProyectos cs = new ControllerSeleccionarProyectos(modelo);
		cs.iniciar();
	}
	
	public void cerrarVentanaVolverInicio() {
		vistaModificarEliminarProyectos.setVisible(false);
		ControladorInicio ci = new ControladorInicio(modelo, vp);
		ci.iniciarVista();
		ci.mostrarCientifico();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaModificarEliminarProyectos.btnModificar == e.getSource()) {

			modelo.modificarProyecto(Integer.parseInt(vistaModificarEliminarProyectos.textFieldID.getText()),
					vistaModificarEliminarProyectos.textFieldNombre.getText(),Integer.parseInt(vistaModificarEliminarProyectos.textField.getText()));

		} else if (vistaModificarEliminarProyectos.btnEliminar == e.getSource()) {

			JLabel label = new JLabel("<html><h1>¿Eliminar el proyecto " + modelo.getNombre() + " (ID: " + modelo.getId()
					+ ")?</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			int input = JOptionPane.showConfirmDialog(vistaModificarEliminarProyectos.contentPane, label, "Eliminar Proyecto",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (input == 0) {
				modelo.eliminarProyecto(IDSeleccionado);
				vistaModificarEliminarProyectos.setVisible(false);
			}

		} else if (vistaModificarEliminarProyectos.btnCancelar == e.getSource()) {
			cerrarVentanaVolver();
		}
	}

}
