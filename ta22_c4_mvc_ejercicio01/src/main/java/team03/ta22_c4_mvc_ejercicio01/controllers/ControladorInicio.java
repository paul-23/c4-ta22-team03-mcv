package team03.ta22_c4_mvc_ejercicio01.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaAñadir;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;

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
		this.vista.btnModificarEliminarCliente.addActionListener(this);
	}

	public void iniciarVista() {
		vista.setTitle("Cliente");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);
	}

	public void iniciarBaseDatos() {
		modelo.connect();
		modelo.createDB("CLIENTES");
		crearTablaClientes();
		mostrarClientes();
	}

	public void crearTablaVideos() {
		String tabla = "CREATE TABLE video (" + "id int NOT NULL AUTO_INCREMENT,"
				+ "nombre varchar(250) DEFAULT NULL," + "apellido varchar(250) DEFAULT NULL,"
				+ "direccion varchar(250) DEFAULT NULL," + "dni int DEFAULT NULL," + "fecha date DEFAULT NULL,"
				+ "PRIMARY KEY (id)" + ");";

		modelo.createTable("CLIENTES", tabla);

		modelo.insertData("Alejandro", "Jimenez", "Calle Mayor Nr,7 Reus", "123456789", "2023-04-11");
		modelo.insertData("Arnau", "Leinster", "Calle Diagonal Nr,27 Tarragona", "456789456", "2023-04-11");
		modelo.insertData("Paul", "Stanescu", "Calle Sant Joan Nr,10 Vinyols i els Arcs", "234561234", "2023-04-11");
	}
	
	public void crearTablaClientes() {
		String tabla = "CREATE TABLE cliente (" + "id int NOT NULL AUTO_INCREMENT,"
				+ "nombre varchar(250) DEFAULT NULL," + "apellido varchar(250) DEFAULT NULL,"
				+ "direccion varchar(250) DEFAULT NULL," + "dni int DEFAULT NULL," + "fecha date DEFAULT NULL,"
				+ "PRIMARY KEY (id)" + ");";

		modelo.createTable("CLIENTES", tabla);

		modelo.insertData("Alejandro", "Jimenez", "Calle Mayor Nr,7 Reus", "123456789", "2023-04-11");
		modelo.insertData("Arnau", "Leinster", "Calle Diagonal Nr,27 Tarragona", "456789456", "2023-04-11");
		modelo.insertData("Paul", "Stanescu", "Calle Sant Joan Nr,10 Vinyols i els Arcs", "234561234", "2023-04-11");
	}

	public void mostrarClientes() {
		ResultSet registro = modelo.consultarTodosClientes();
		String[] columnNames = { "id", "Nombre", "Apellido", "Dirección", "DNI", "Fecha" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		try {

			while (registro.next()) {

				String id1 = Integer.toString(registro.getInt("id"));
				String nombre1 = registro.getString("nombre");
				String apellido1 = registro.getString("apellido");
				String direccion1 = registro.getString("direccion");
				String dni1 = Integer.toString(registro.getInt("dni"));
				String fecha1 = registro.getDate("fecha").toString();

				Object data[] = { id1, nombre1, apellido1, direccion1, dni1, fecha1 };

				tableModel.addRow(data);

			}

			vista.table.setModel(tableModel);

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener clientes");
		}
		;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vista.btnAñadirCliente == e.getSource()) {
			vista.setVisible(false);
			ControladorAñadir ca = new ControladorAñadir(modelo);
			ca.iniciar();
		} else if (vista.btnModificarEliminarCliente == e.getSource()) {
			vista.setVisible(false);
			ControladorSeleccionar cs = new ControladorSeleccionar(modelo);
			cs.iniciarModificarEliminar();
		}
	}

}
