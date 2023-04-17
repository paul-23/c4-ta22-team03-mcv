package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.ModelBD;
import models.ModelBDProy;
import views.vistaPrincipal;
import views.vistaPrincipalProyectos;
import views.vistaSeleccionTabla;

public class ControllerSelTabla implements ActionListener {

	vistaSeleccionTabla vista = new vistaSeleccionTabla();
	ModelBDProy modelBD = new ModelBDProy();
	ModelBD model = new ModelBD();
	vistaPrincipal vistaP = new vistaPrincipal();
	vistaPrincipalProyectos vistaProy = new vistaPrincipalProyectos();
public void iniciarvista() {
	this.vista.setVisible(true);
}
	public ControllerSelTabla() {
		this.vista.btnCientificos.addActionListener(this);
		this.vista.btnNewButton.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vista.btnCientificos == e.getSource()) {
			// new vistaPrincipal().setVisible(true);
			ControladorInicio ci = new ControladorInicio(model, vistaP);
			ci.iniciarVista();
		} else if (vista.btnNewButton == e.getSource()) {
			ControladorInicioProyectos cip = new ControladorInicioProyectos(modelBD, vistaProy);
			cip.iniciarVista();

		}

	}

}