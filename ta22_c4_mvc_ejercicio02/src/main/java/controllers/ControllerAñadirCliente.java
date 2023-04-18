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

	VistaAñadirCliente vista = new VistaAñadirCliente();
	LocalDate fecha = LocalDate.now();

	VistaPrincipal vistaPrincipal;
	Cliente cliente;
	Videos video;
	DataBase db;
	VistaAñadirCliente ca;

	public ControllerAñadirCliente(Cliente cliente, DataBase db) {
		vista = new VistaAñadirCliente();
		this.cliente = cliente;
		this.db = db;
	}

	public void iniciar(Cliente cliente, DataBase db, ControllerAñadirCliente ca) {
		this.ca = ca;
		vista.setVisible(true);
		vista.setTitle("Añadir Cliente");
		this.vista.btnAñadir.addActionListener(this);
		this.vista.btnCancelar.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (vista.btnAñadir == e.getSource()) {
			String entr = "'" + vista.textFieldNombre.getText() + "','" + vista.textFieldApellido.getText() + "','"
					+ vista.textFieldDireccion.getText() + "'," + Integer.parseInt(vista.textFieldDNI.getText());
			db.insertData("db", "Clientes", "nombre, apellido, direccion, dni", entr);

		} else if (vista.btnCancelar == e.getSource()) {
			System.out.println(3);
			ControllerPrincipal ci = new ControllerPrincipal(db, cliente, video, vistaPrincipal);
			ci.iniciarVista();
			vista.setVisible(false);

		}

	}

}
