/**
 * 
 */
package controllers;

import models.ModelBD;
import views.vistaModificarEliminar;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerModificarEliminar {
	
	vistaModificarEliminar vistaModificarEliminar = new vistaModificarEliminar();
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
