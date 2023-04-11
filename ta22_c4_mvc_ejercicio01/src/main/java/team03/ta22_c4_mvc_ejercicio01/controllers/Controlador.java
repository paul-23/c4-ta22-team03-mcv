package team03.ta22_c4_mvc_ejercicio01.controllers;

import javax.swing.JFrame;

import team03.ta22_c4_mvc_ejercicio01.models.Cliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;

public class Controlador {

	Cliente modelo;
	VistaPrincipal vista;

	public Controlador(Cliente modelo, VistaPrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;
	}

	public void iniciarVista() {
		vista.setTitle("Cliente");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
	}
	
	public void iniciarBaseDatos() {
		modelo.connect();
		modelo.createDB("CLIENTES");
	}
	
	public void cerrarBaseDatos() {
		modelo.closeConnection();
	}

}
