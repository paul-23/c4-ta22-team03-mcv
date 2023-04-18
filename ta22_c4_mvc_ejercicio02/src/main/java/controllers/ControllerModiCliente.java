package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import models.Cliente;
import models.DataBase;
import views.VistaModificarEliminarCliente;
import views.VistaPrincipal;

public class ControllerModiCliente implements ActionListener {
	LocalDate fecha = LocalDate.now();
	VistaModificarEliminarCliente vistaME = new VistaModificarEliminarCliente();
	VistaPrincipal vp = new VistaPrincipal();
	Cliente modelo;
	DataBase db;
	private int IDSeleccionado;

	public ControllerModiCliente(DataBase db, Cliente cliente, int id) {
		this.modelo = modelo;
		this.IDSeleccionado = id;
		this.db = db;
		this.vistaME.btnModificar.addActionListener(this);
		this.vistaME.btnEliminar.addActionListener(this);
		this.vistaME.btnCancelar.addActionListener(this);
	}

	public void iniciar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
