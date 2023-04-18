package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import models.ModelBDProy;
import views.vistaSeleccionAsignacion;

public class ControllerSeleccionAsignacion implements ActionListener{

	vistaSeleccionAsignacion vistaSeleccionAsignacion = new vistaSeleccionAsignacion();
	ModelBDProy modelo  = new ModelBDProy();

	public ControllerSeleccionAsignacion(ModelBDProy modelo) {
		this.modelo = modelo;
		this.vistaSeleccionAsignacion.textFieldIDAsignacion.addActionListener(this);
		this.vistaSeleccionAsignacion.btnBuscar.addActionListener(this);
	}


	public void iniciar() {
		vistaSeleccionAsignacion.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (views.vistaSeleccionAsignacion.textFieldIDAsignacion == e.getSource() || vistaSeleccionAsignacion.btnBuscar == e.getSource()) {
			if (!"".equals(views.vistaSeleccionAsignacion.textFieldIDAsignacion.getText())) {
				if (vistaSeleccionAsignacion.textFieldIDAsignacion.getText().equals(modelo.checkID("proyecto", Integer.parseInt(views.vistaSeleccionAsignacion.textFieldIDAsignacion.getText())))) {
					ControllerModificarEliminarProyectos me = new ControllerModificarEliminarProyectos(modelo, Integer.parseInt(vistaSeleccionAsignacion.textFieldIDAsignacion.getText()));
					me.iniciar();
					vistaSeleccionAsignacion.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(vistaSeleccionAsignacion.getContentPane(), "El Proyecto seleccionado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(vistaSeleccionAsignacion.getContentPane(), "No has introducido ningun ID");
			}
		} 
			
		}
	
}
