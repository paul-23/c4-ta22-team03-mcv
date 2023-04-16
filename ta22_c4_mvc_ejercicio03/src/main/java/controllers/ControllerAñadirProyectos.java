/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import models.ModelBDProy;
import views.vistaAñadirProy;
import views.vistaPrincipal;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerAñadirProyectos implements ActionListener {
	
	LocalDate fecha = LocalDate.now();
	
	vistaAñadirProy vistaAñadir = new vistaAñadirProy();
	vistaPrincipal vistaPrincipal = new vistaPrincipal();
	ModelBDProy modelo;
	
	public ControllerAñadirProyectos () {
		this.modelo = modelo;
		this.vistaAñadir.btnAñadir.addActionListener(this);
		this.vistaAñadir.btnCancelar.addActionListener(this);
	}
	
	public void iniciar() {
		vistaAñadir.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaAñadir.btnAñadir == e.getSource()) {
			System.out.println("btnañadir");
			modelo.insertData(vistaAñadirProy.textFieldNombre.getText(), vistaAñadirProy.textField_2.getText());
			vistaAñadir.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarProyecto();
		} else if (vistaAñadir.btnCancelar == e.getSource()) {
			vistaAñadir.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarProyecto();
		}
	}
	
	
}
