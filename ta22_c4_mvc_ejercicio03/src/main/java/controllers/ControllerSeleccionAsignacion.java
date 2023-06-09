package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.ModelAsignacion;
import views.vistaSeleccionAsignacion;

public class ControllerSeleccionAsignacion implements ActionListener {

	vistaSeleccionAsignacion vistaSeleccionAsignacion = new vistaSeleccionAsignacion();
	ModelAsignacion modelo = new ModelAsignacion();

	public ControllerSeleccionAsignacion(ModelAsignacion modelo) {
		this.modelo = modelo;
		this.vistaSeleccionAsignacion.textFieldIDAsignacion.addActionListener(this);
		this.vistaSeleccionAsignacion.btnBuscar.addActionListener(this);
	}

	public void iniciar() {
		vistaSeleccionAsignacion.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (vistaSeleccionAsignacion.textFieldIDAsignacion.getText() == null
				|| vistaSeleccionAsignacion.textFieldDNIAsignacion.getText() != null) {
			modelo.consultarAsignacionProyectos(
					Integer.parseInt(vistaSeleccionAsignacion.textFieldIDAsignacion.getText()));

		} else
			modelo.consultarAsignacionProyectos(
					Integer.parseInt(vistaSeleccionAsignacion.textFieldDNIAsignacion.getText()));

	}
	/*
	 * if (views.vistaSeleccionAsignacion.textFieldIDAsignacion == e.getSource() ||
	 * vistaSeleccionAsignacion.btnBuscar == e.getSource()) { if
	 * (!"".equals(views.vistaSeleccionAsignacion.textFieldIDAsignacion.getText()))
	 * { if (vistaSeleccionAsignacion.textFieldIDAsignacion.getText().equals(modelo.
	 * checkID("asignacion",
	 * Integer.parseInt(views.vistaSeleccionAsignacion.textFieldIDAsignacion.getText
	 * ())))) {
	 * 
	 * vistaSeleccionAsignacion.setVisible(false); } else {
	 * JOptionPane.showMessageDialog(vistaSeleccionAsignacion.getContentPane(),
	 * "El Asignacion seleccionado no existe"); } } else {
	 * JOptionPane.showMessageDialog(vistaSeleccionAsignacion.getContentPane(),
	 * "No has introducido ningun ID"); } }
	 */

}
