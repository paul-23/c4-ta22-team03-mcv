package team03.ta22_c4_mvc_ejercicio01.Appmain;

import team03.ta22_c4_mvc_ejercicio01.controllers.Controlador;
import team03.ta22_c4_mvc_ejercicio01.models.Cliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;

public class App {
	public static void main(String[] args) {
		Cliente modelo = new Cliente();
		VistaPrincipal vista = new VistaPrincipal();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.iniciarVista();
		controlador.iniciarBaseDatos();
	}
}