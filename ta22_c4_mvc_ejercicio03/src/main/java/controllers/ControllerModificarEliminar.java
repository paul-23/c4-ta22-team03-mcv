/**
 * 
 */
package controllers;

import models.ModelBD;
import views.vistaME;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerModificarEliminar {
	
	vistaME vistaModificarEliminar = new vistaME();
	ModelBD modelo;
	private int IDSeleccionado;

	public ControllerModificarEliminar(ModelBD modelo, int IDParametro) {
		this.modelo = modelo;
		this.IDSeleccionado = IDParametro;
	}
	
	public void iniciar() {
		vistaModificarEliminar.setVisible(true);
	}
	
}
