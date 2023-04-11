package team03.ta22_c4_mvc_ejercicio01.controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaAñadir;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;
import team03.ta22_c4_mvc_ejercicio01.views.VistaSeleccionar;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class ControladorInicio implements ActionListener {

	VistaAñadir vistaAñadir = new VistaAñadir();

	ModeloCliente modelo;
	VistaPrincipal vista;

	public ControladorInicio(ModeloCliente modelo, VistaPrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.btnAñadirCliente.addActionListener(this);
		this.vista.btnModificarCliente.addActionListener(this);
		this.vista.btnEliminarCliente.addActionListener(this);
		this.vista.btnConsultarCliente.addActionListener(this);
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
	
	public void crearTablaClientes() {
		String tabla = "CREATE TABLE “cliente” ("
				+ "'id' int(11) NOT NULL AUTO_INCREMENT,"
				+ "'nombre' varchar(250) DEFAULT NULL,"
				+ "'apellido' varchar(250) DEFAULT NULL,"
				+ "'direccion' varchar(250) DEFAULT NULL,"
				+ "'dni' int(11) DEFAULT NULL,"
				+ "'fecha' date DEFAULT NULL,"
				+ "PRIMARY KEY ('id')"
				+ ");";
		modelo.createTable("CLIENTES", tabla);
	}

	public void cerrarBaseDatos() {
		modelo.closeConnection();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vista.btnAñadirCliente == e.getSource()) {
			vista.setVisible(false);
			vistaAñadir.setVisible(true);
		} else if (vista.btnConsultarCliente == e.getSource() || vista.btnEliminarCliente == e.getSource()
				|| vista.btnModificarCliente == e.getSource()) {
			vista.setVisible(false);
			ControllerSeleccionar cs = new ControllerSeleccionar(modelo);
			cs.iniciar();
		}
	}

}
