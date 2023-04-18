/**
 * 
 */
package team03.ta22_c4_mvc_ejercicio01.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;
import team03.ta22_c4_mvc_ejercicio01.views.VistaSeleccionar;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControladorSeleccionar implements ActionListener {

	VistaSeleccionar vistaSeleccionar = new VistaSeleccionar();
	VistaPrincipal vistaPrincipal = new VistaPrincipal();
	ModeloCliente modelo;

	public ControladorSeleccionar(ModeloCliente modelo) {
		this.modelo = modelo;
		this.vistaSeleccionar.textFieldIDCliente.addActionListener(this);
		this.vistaSeleccionar.btnBuscar.addActionListener(this);
		this.vistaSeleccionar.btnCancelar.addActionListener(this);
	}

	public void iniciar() {
		vistaSeleccionar.setVisible(true);
	}

	public void iniciarModificarEliminar() {
		vistaSeleccionar.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaSeleccionar.textFieldIDCliente == e.getSource() || vistaSeleccionar.btnBuscar == e.getSource()) {
			if (!"".equals(vistaSeleccionar.textFieldIDCliente.getText())) {
				if (vistaSeleccionar.textFieldIDCliente.getText().equals(
						modelo.checkID("cliente", Integer.parseInt(vistaSeleccionar.textFieldIDCliente.getText())))) {
					ControladorModificarEliminar me = new ControladorModificarEliminar(modelo,
							Integer.parseInt(vistaSeleccionar.textFieldIDCliente.getText()));
					me.iniciar();
					vistaSeleccionar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(),
							"El cliente seleccionado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "No has introducido ninguna ID");
			}
		} else if (vistaSeleccionar.btnCancelar == e.getSource()) {
			vistaSeleccionar.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarClientes();
		}
	}
}
