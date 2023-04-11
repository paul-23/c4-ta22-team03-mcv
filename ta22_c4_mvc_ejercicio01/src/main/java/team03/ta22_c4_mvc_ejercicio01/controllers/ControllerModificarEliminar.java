/**
 * 
 */
package team03.ta22_c4_mvc_ejercicio01.controllers;

import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaModificarEliminar;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerModificarEliminar {
	
	VistaModificarEliminar vistaModificarEliminar = new VistaModificarEliminar();
	ModeloCliente modelo;
	private int IDSeleccionado;
	
	public ControllerModificarEliminar(ModeloCliente modelo, int IDParametro) {
		this.modelo = modelo;
		this.IDSeleccionado = IDParametro;
	}
	
	public void iniciar() {
		vistaModificarEliminar.setVisible(true);
	}
	
}
