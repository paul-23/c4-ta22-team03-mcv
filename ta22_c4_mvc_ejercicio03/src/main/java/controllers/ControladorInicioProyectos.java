package controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.ModelBDProy;
import views.vistaAñadirProy;
import views.vistaPrincipalProyectos;
import views.vistaSeleccionarProyectos;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class ControladorInicioProyectos implements ActionListener {

	vistaAñadirProy vistaAñadirProy = new vistaAñadirProy();
	ModelBDProy modelo = new ModelBDProy();
	vistaPrincipalProyectos vista = new vistaPrincipalProyectos();

	public ControladorInicioProyectos(ModelBDProy modelo, vistaPrincipalProyectos vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.btnAñadirProyecto.addActionListener(this);
		this.vista.btnModificarProyecto.addActionListener(this);
		this.vista.btnEliminarProyecto.addActionListener(this);
		this.vista.btnConsultarProyecto.addActionListener(this);
	}
	
	public void iniciarVista() {
		vista.setTitle("Asignacion de proyectos a Proyectos");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
	}

	public void iniciarBaseDatos() {
		modelo.connect();
		modelo.createDB("Ej3asignacioProyectosProyectos");
	}

	public void mostrarProyecto() {
		ResultSet registro = modelo.consultarTodosProyectos();
		String[] columnNames = { "Nombre", "ID","Horas" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {

			while (registro.next()) {

				String nombre = registro.getString("nombre");
				String id = Integer.toString(registro.getInt("id"));
				String horas = Integer.toString(registro.getInt("horas"));

				Object data[] = {  nombre, id,horas};

				tableModel.addRow(data);

			}

			vista.table.setModel(tableModel);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener proyectos");
		}
		;
	}


	public void cearTablaAsignado_a() {
		String tabla = "CREATE TABLE ASIGNADO_A (" + " cientifico varchar(8) NOT NULL," + "Proyecto char(4),"
				+ "FOREIGN KEY (Proyecto) references Proyecto (id)"
				+ "FOREIGN KEY (CIENTIFICO) references CIENTIFICO(DNI);";
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

	public void actionPerformed(ActionEvent e) {
		if (vista.btnAñadirProyecto == e.getSource()) {
			vista.setVisible(false);
			vistaAñadirProy.setVisible(true);
		} else if (vista.btnConsultarProyecto == e.getSource() || vista.btnEliminarProyecto == e.getSource()
				|| vista.btnModificarProyecto == e.getSource()) {
			vista.setVisible(false);
			ControllerSeleccionarProyectos cs = new ControllerSeleccionarProyectos(modelo);
			cs.iniciar();
		}
	}

		
		

}
