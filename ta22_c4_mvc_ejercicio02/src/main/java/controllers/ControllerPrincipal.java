package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Label;

import models.Cliente;
import models.DataBase;
import models.Videos;
import views.VistaAñadirCliente;
import views.VistaPrincipal;

public class ControllerPrincipal implements ActionListener {

	VistaAñadirCliente vistaAñadir = new VistaAñadirCliente();
	DataBase db;
	Cliente cliente;
	Videos video;
	VistaPrincipal vista;

	public ControllerPrincipal(DataBase db, Cliente cliente, Videos video, VistaPrincipal vista) {
		this.db = db;
		this.cliente = cliente;
		this.video = video;
		this.vista = vista;
	}

	public void iniciarVista() {
		vista.setTitle("Clientes y sus Videos");
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setVisible(true);

		this.vista.btnAñadirCliente.addActionListener(this);
		this.vista.btnModificarEliminarCliente.addActionListener(this);
		this.vista.btnAñadirVideo.addActionListener(this);
		this.vista.btnModificarEliminarVideo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vista.btnAñadirCliente == e.getSource()) {

			vista.setVisible(false);
			ControllerAñadirCliente ca = new ControllerAñadirCliente(cliente, db);
			ca.iniciar(cliente, db);

		} else if (vista.btnModificarEliminarCliente == e.getSource()) {

			vista.setVisible(false);
			ControllerSeleccionarCliente cb = new ControllerSeleccionarCliente(db);
			cb.iniciar();

		} else if (vista.btnAñadirVideo == e.getSource()) {

			vista.setVisible(false);
			ControllerAñadirVideo cc = new ControllerAñadirVideo();
			cc.iniciar();

		} else if (vista.btnModificarEliminarVideo == e.getSource()) {

			vista.setVisible(false);
			ControllerModiVideo cd = new ControllerModiVideo();
			cd.iniciar();
		}
	}

}
