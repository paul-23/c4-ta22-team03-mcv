package controllers;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import models.Cliente;
import models.Videos;
import models.DataBase;
import views.VistaModificarEliminarCliente;
import views.VistaPrincipal;
import views.VistaSeleccionarCliente;

public class ControllerSeleccionarCliente implements ActionListener {

	LocalDate fecha = LocalDate.now();
	VistaModificarEliminarCliente vistaModificarEliminar = new VistaModificarEliminarCliente();
	VistaPrincipal vp = new VistaPrincipal();
	Cliente cliente;
	Videos video;
	DataBase db;
	VistaSeleccionarCliente visCli = new VistaSeleccionarCliente();
	private int IDSeleccionado;

	public ControllerSeleccionarCliente(DataBase db) {
		super();
		this.db = db;
	}

	public void iniciar() {
		// TODO Auto-generated method stub
		visCli.setVisible(true);
		this.visCli.btnBuscar.addActionListener(this);
		this.visCli.btnCancelar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (visCli.textFieldIDCliente == e.getSource() || visCli.btnBuscar == e.getSource()) {
			if (!"".equals(visCli.textFieldIDCliente.getText())) {
				try {
					if (visCli.textFieldIDCliente.getText().equals(
							(db.comprovar("db", "Clientes", "id", visCli.textFieldIDCliente.getText().toString())))) {
						ControllerModiCliente me = new ControllerModiCliente(db, cliente,
								Integer.parseInt(visCli.textFieldIDCliente.getText()));

						me.iniciar();
						visCli.setVisible(false);
					} else {
						JOptionPane.showMessageDialog(visCli.getContentPane(), "El cliente seleccionado no existe");
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(visCli.getContentPane(), "No has introducido ninguna ID");
			}
		} else if (visCli.btnCancelar == e.getSource()) {
			visCli.setVisible(false);
			ControllerPrincipal ci = new ControllerPrincipal(db, cliente, video, vp);
			ci.iniciarVista();
		}
	}

}
