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

	vistaSeleccionarProyectos vistaSeleccionarProyectos = new vistaSeleccionarProyectos();
	ModelBDProy modelo  = new ModelBDProy();

	public ControllerSeleccionarProyectos(ModelBDProy modelo) {
		this.modelo = modelo;
		this.vistaSeleccionarProyectos.textFieldIDProyectos.addActionListener(this);
		this.vistaSeleccionarProyectos.btnBuscar.addActionListener(this);
	}

	

	public void iniciar() {
		vistaSeleccionarProyectos.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaSeleccionarProyectos.textFieldIDProyectos == e.getSource() || vistaSeleccionarProyectos.btnBuscar == e.getSource()) {
			if (!"".equals(vistaSeleccionarProyectos.textFieldIDProyectos.getText())) {
				if (vistaSeleccionarProyectos.textFieldIDProyectos.getText().equals(modelo.checkID("Proyectos", Integer.parseInt(vistaSeleccionarProyectos.textFieldIDProyectos.getText())))) {
					ControllerModificarEliminarProyectos me = new ControllerModificarEliminarProyectos(modelo, Integer.parseInt(vistaSeleccionarProyectos.textFieldIDProyectos.getText()));
					me.iniciar();
					vistaSeleccionarProyectos.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(vistaSeleccionarProyectos.getContentPane(), "El Proyecto seleccionado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(vistaSeleccionarProyectos.getContentPane(), "No has introducido ningun ID");
			}
		} 
			
		}
	}

