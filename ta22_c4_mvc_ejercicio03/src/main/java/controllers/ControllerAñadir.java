/**
 * 
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import models.ModelBD;
import views.vistaAñadir;
import views.vistaPrincipal;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerAñadir implements ActionListener {
	
	LocalDate fecha = LocalDate.now();
	
	vistaAñadir vistaAñadir = new vistaAñadir();
	vistaPrincipal vistaPrincipal = new vistaPrincipal();
	ModelBD modelo;
	
	public ControllerAñadir (ModelBD modelo) {
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
			modelo.insertData(vistaAñadir.textFieldNombre.getText(), vistaAñadir.textFieldDNI.getText());
			vistaAñadir.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarCientificos();
		} else if (vistaAñadir.btnCancelar == e.getSource()) {
			vistaAñadir.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarCientificos();
		}
	}
	
	
}
