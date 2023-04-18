package team03.ta22_c4_mvc_ejercicio03;

import controllers.ControladorInicio;
import controllers.ControladorInicioProyectos;
import controllers.ControllerSelTabla;
import models.ModelBD;
import models.ModelBDProy;
import views.vistaAñadir;
import views.vistaPrincipal;
import views.vistaPrincipalProyectos;
import views.vistaSeleccionTabla;
import views.vistaSeleccionar;

/*
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class App {
	public static void main(String[] args) {
		  java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	            	vistaPrincipal vistaPrincipal = new vistaPrincipal();
	        		vistaPrincipalProyectos vpp = new vistaPrincipalProyectos();
	            	ModelBD modelo = new ModelBD();
	        		ModelBDProy model = new ModelBDProy();
	                //new vistaSeleccionTabla().setVisible(true);
	                ControllerSelTabla cst = new ControllerSelTabla();
	                cst.iniciarvista();
	        		ControladorInicio controlador = new ControladorInicio(modelo, vistaPrincipal);
	        		ControladorInicioProyectos controladorincProy = new ControladorInicioProyectos(model, vpp);
	        		modelo.connect();
	        		modelo.createDB("Ej3asignacionCientificosProyectos");
	        		controlador.iniciarBaseDatos();
	        		//controladorincProy.iniciarBaseDatos();
	            }
	        });

			//vistaSeleccionTabla vSTabla = new vistaSeleccionTabla();
		/*

		ControladorInicio controlador = new ControladorInicio(modelo, vistaPrincipal);
		vistaPrincipalProyectos vpp = new vistaPrincipalProyectos();
		ControladorInicioProyectos controladorincProy = new ControladorInicioProyectos(model, vpp);

		controlador.iniciarVista();
		*/

	}
}