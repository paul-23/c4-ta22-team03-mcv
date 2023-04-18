/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ModelBDProy;
import views.vistaAñadirProy;
import views.vistaPrincipalProyectos;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerAñadirProyectos implements ActionListener {
	
	
	vistaAñadirProy vistaAñadir = new vistaAñadirProy();
	vistaPrincipalProyectos vistaPrincipalProy = new vistaPrincipalProyectos();
	vistaAñadirProy vistaAñadirProy = new vistaAñadirProy();
	ModelBDProy modelo = new ModelBDProy();
	
	public ControllerAñadirProyectos (ModelBDProy modelo) {
		this.modelo = modelo;
		this.vistaAñadirProy.btnAñadir.addActionListener(this);
		this.vistaAñadirProy.btnCancelar.addActionListener(this);
	}
	
	public void iniciar() {
		vistaAñadirProy.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String nombre = vistaAñadirProy.textFieldNombre.getText();
		int id =  Integer.parseInt(vistaAñadirProy.textFieldID.getText());
		int horas = Integer.parseInt(vistaAñadirProy.textFieldHoras.getText());
		if (vistaAñadirProy.btnAñadir == e.getSource()) {
			System.out.println("btnañadir");
			modelo.insertData(nombre, id,horas);
			vistaAñadirProy.setVisible(false);
			/*ControladorInicioProyectos ci = new ControladorInicioProyectos(modelo, vistaPrincipalProy);
			ci.iniciarVista();
			ci.mostrarProyecto();*/
		} else if (vistaAñadirProy.btnCancelar == e.getSource()) {
			vistaAñadirProy.setVisible(false);
			ControladorInicioProyectos ci = new ControladorInicioProyectos(modelo, vistaPrincipalProy);
			ci.iniciarVista();
			ci.mostrarProyecto();
		}
	}
	
	
}
