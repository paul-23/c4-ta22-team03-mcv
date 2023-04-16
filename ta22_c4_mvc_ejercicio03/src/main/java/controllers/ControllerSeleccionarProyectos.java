package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelBDProy;
import views.vistaSeleccionarProyectos;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerSeleccionarProyectos implements ActionListener {

	vistaSeleccionarProyectos vistaSeleccionar = new vistaSeleccionarProyectos();
	ModelBDProy modelo;

	public ControllerSeleccionarProyectos(ModelBDProy modelo) {
		this.modelo = modelo;
		this.vistaSeleccionar.textFieldIDProyectos.addActionListener(this);
		this.vistaSeleccionar.btnBuscar.addActionListener(this);
	}
	
	public void iniciar() {
		vistaSeleccionar.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaSeleccionar.textFieldIDProyectos == e.getSource() || vistaSeleccionar.btnBuscar == e.getSource()) {
			if (!"".equals(vistaSeleccionar.textFieldIDProyectos.getText())) {
				if (vistaSeleccionar.textFieldIDProyectos.getText().equals(modelo.checkID("Proyectos", Integer.parseInt(vistaSeleccionarProyectos.textFieldIDProyectos.getText())))) {
					ControllerModificarEliminarProyectos me = new ControllerModificarEliminarProyectos(modelo, Integer.parseInt(vistaSeleccionarProyectos.textFieldIDProyectos.getText()));
					me.iniciar();
					vistaSeleccionar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "El Proyecto seleccionado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "No has introducido ningun DNI");
			}
		} 
			
		}
	}

