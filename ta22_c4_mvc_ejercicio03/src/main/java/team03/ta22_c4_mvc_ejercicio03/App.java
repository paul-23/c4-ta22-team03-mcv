package team03.ta22_c4_mvc_ejercicio03;

import controllers.ControladorInicio;
import models.ModelBD;
import views.vistaAñadir;
import views.vistaME;
import views.vistaPrincipal;
import views.vistaSeleccionar;


/*
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class App {
	public static void main(String[] args) {
		
		ModelBD modelo = new ModelBD();
		
		vistaPrincipal vistaPrincipal = new vistaPrincipal();
		
		ControladorInicio controlador = new ControladorInicio(modelo, vistaPrincipal);
		
		controlador.iniciarVista();
		controlador.iniciarBaseDatos();
	}
}