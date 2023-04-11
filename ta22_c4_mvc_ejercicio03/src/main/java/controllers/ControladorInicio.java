package controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import models.ModelBD;
import views.vistaAñadir;
import views.vistaPrincipal;
import views.vistaSeleccionar;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class ControladorInicio implements ActionListener {

	vistaAñadir vistaAñadir = new vistaAñadir();
	ModelBD modelo;
	vistaPrincipal vista;

	public ControladorInicio(ModelBD modelo, vistaPrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.btnAñadirCliente.addActionListener(this);
		this.vista.btnModificarCliente.addActionListener(this);
		this.vista.btnEliminarCliente.addActionListener(this);
		this.vista.btnConsultarCliente.addActionListener(this);
	}
	
	public void iniciarVista() {
		vista.setTitle("Asignacion de proyectos a cientificos");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
	}

	public void iniciarBaseDatos() {
		modelo.connect();
		modelo.createDB("Ej3asignacioCientificosProyectos");
	}

	public void crearTablaCientificos() {
		String tabla = "CREATE TABLE CIENTIFICOS (" + "dni int(11) NOT NULL ," + "nombre nvarchar(250) DEFAULT NULL,"
				+ "PRIMARY KEY (dni)" + ");";
		modelo.createTable("CIENTIFICOS", tabla);
	}

	public void cearTablaAsignado_a() {
		String tabla = "CREATE TABLE ASIGNADO_A (" + "cientifico varcahr(8) NOT NULL," + "proyecto char(4),"
				+ "FOREIGN KEY (cientifico) references CIENTIFICOS (dni)"
				+ "FOREIGN KEY (PROYECTO) references PROYECTO(DNI);";
		modelo.createTable("ASIGNADO_A", tabla);

	}

	public void crearProyecto() {
		String tabla = "CREATE TABLE PROYECTO(" + "id int(10)NOT NULL AUTO_INCREMENT,"
				+ "Nombre nvarcahr(250) NOT NULL," + "Horas int(5) NOT NULL," + "PRIMARY KEY(id);";
		modelo.createTable("PROYECTO", tabla);

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
