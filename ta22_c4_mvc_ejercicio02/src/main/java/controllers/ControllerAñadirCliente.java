package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JFrame;

import models.Cliente;
import models.DataBase;
import models.Videos;
import views.VistaAñadirCliente;
import views.VistaPrincipal;

public class ControllerAñadirCliente implements ActionListener {

	VistaAñadirCliente vista;
	LocalDate fecha = LocalDate.now();

	VistaAñadirCliente vistaAñadir = new VistaAñadirCliente();
	VistaPrincipal vistaPrincipal = new VistaPrincipal();
	Cliente cliente;
	Videos video;
	DataBase db;

	public ControllerAñadirCliente(Cliente cliente, DataBase db) {
		vista = new VistaAñadirCliente();
		this.cliente = cliente;
		this.db = db;
		this.vistaAñadir.btnAñadir.addActionListener(this);
		this.vistaAñadir.btnCancelar.addActionListener(this);
	}

	public void iniciar(Cliente cliente, DataBase db) {
		vista.setVisible(true);
		vista.setTitle("Añadir Cliente");
		this.vista.btnAñadir.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (vista.btnAñadir == e.getSource()) {
			String entr = "'" + vista.textFieldNombre.getText() + "','" + vista.textFieldApellido.getText() + "','"
					+ vista.textFieldDireccion.getText() + "'," + Integer.parseInt(vista.textFieldDNI.getText());
			db.insertData("db", "Clientes", "nombre, apellido, direccion, dni", entr);

		} else if (vista.btnCancelar == e.getSource()) {
			vista.setVisible(false);
			vistaPrincipal.setVisible(true);
		}

	}

}
