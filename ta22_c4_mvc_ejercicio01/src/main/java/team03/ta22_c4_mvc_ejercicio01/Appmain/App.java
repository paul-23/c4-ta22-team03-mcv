package team03.ta22_c4_mvc_ejercicio01.Appmain;

import team03.ta22_c4_mvc_ejercicio01.controllers.ControladorInicio;
import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class App {
	public static void main(String[] args) {
		
		ModeloCliente modelo = new ModeloCliente();
		
		VistaPrincipal vistaPrincipal = new VistaPrincipal();
		
		ControladorInicio controlador = new ControladorInicio(modelo, vistaPrincipal);
		
		controlador.iniciarVista();
		controlador.iniciarBaseDatos();
	}
}