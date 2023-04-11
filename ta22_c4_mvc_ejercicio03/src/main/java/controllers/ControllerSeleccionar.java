package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelBD;
import views.vistaSeleccionar;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControllerSeleccionar implements ActionListener {

	vistaSeleccionar vistaSeleccionar = new vistaSeleccionar();
	ModelBD modelo;

	public ControllerSeleccionar(ModelBD modelo) {
		this.modelo = modelo;
		this.vistaSeleccionar.textFieldIDCliente.addActionListener(this);
		this.vistaSeleccionar.btnBuscar.addActionListener(this);
	}
	
	public void iniciar() {
		vistaSeleccionar.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaSeleccionar.textFieldIDCliente == e.getSource() || vistaSeleccionar.btnBuscar == e.getSource()) {
			if (!"".equals(vistaSeleccionar.textFieldIDCliente.getText())) {
				if (vistaSeleccionar.textFieldIDCliente.getText().equals(modelo.checkID("Clientes", Integer.parseInt(vistaSeleccionar.textFieldIDCliente.getText())))) {
					ControllerModificarEliminar me = new ControllerModificarEliminar(modelo, Integer.parseInt(vistaSeleccionar.textFieldIDCliente.getText()));
					me.iniciar();
					vistaSeleccionar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "El cliente seleccionado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "No has introducido ninguna ID");
			}
		} 
			
		}
	}

