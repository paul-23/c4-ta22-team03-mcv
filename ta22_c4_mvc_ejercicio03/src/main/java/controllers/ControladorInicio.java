package controllers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import models.ModelBD;
import models.ModelBDProy;
//import models.ModelBDProy;
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
	ModelBDProy modeloProy;

	vistaPrincipal vista;

	public ControladorInicio(ModelBD modelo, vistaPrincipal vista) {
		this.modelo = modelo;
		this.vista = vista;
		this.vista.btnAñadirCientifico.addActionListener(this);
		this.vista.btnModificarCientifico.addActionListener(this);
		this.vista.btnEliminarCientifico.addActionListener(this);
		this.vista.btnConsultarCientifico.addActionListener(this);
	}
	
	public ControladorInicio(ModelBDProy modelo, vistaPrincipal vistaPrincipal) {
		// TODO Auto-generated constructor stub
	}

	public void iniciarVista() {
		vista.setTitle("Asignacion de proyectos a cientificos");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
	}

	public void iniciarBaseDatos() {
		modelo.connect();
		modelo.createDB("Ej3asignacioCientificosProyectos");
		crearTablaCientificos();
		cearTablaAsignado_a();
		crearProyecto();
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
		if (vista.btnAñadirCientifico == e.getSource()) {
			vista.setVisible(false);
			vistaAñadir.setVisible(true);
		} else if (vista.btnConsultarCientifico == e.getSource() || vista.btnEliminarCientifico == e.getSource()
				|| vista.btnModificarCientifico == e.getSource()) {
			vista.setVisible(false);
			ControllerSeleccionar cs = new ControllerSeleccionar(modelo);
			cs.iniciar();
		}
	}

		public void mostrarCientifico() {
		ResultSet registro = modelo.consultarTodosCientificos();
		String[] columnNames = { "Nombre", "DNI" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {

			while (registro.next()) {

				String nombre = registro.getString("nombre");
				String dni = Integer.toString(registro.getInt("dni"));

				Object data[] = {  nombre, dni};

				tableModel.addRow(data);

			}

			vista.table.setModel(tableModel);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener clientes");
		};
	}
		
}
