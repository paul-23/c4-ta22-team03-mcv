package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelBD;
import models.ModelBDProy;
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
		this.vistaSeleccionar.textFieldIDCientifico.addActionListener(this);
		this.vistaSeleccionar.btnBuscar.addActionListener(this);
	}
	
	public void iniciar() {
		vistaSeleccionar.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaSeleccionar.textFieldIDCientifico == e.getSource() || vistaSeleccionar.btnBuscar == e.getSource()) {
			if (!"".equals(vistaSeleccionar.textFieldIDCientifico.getText())) {
				if (vistaSeleccionar.textFieldIDCientifico.getText().equals(modelo.checkDNI("Cientificos", Integer.parseInt(vistaSeleccionar.textFieldIDCientifico.getText())))) {
					ControllerModificarEliminar me = new ControllerModificarEliminar(modelo, Integer.parseInt(vistaSeleccionar.textFieldIDCientifico.getText()));
					me.iniciar();
					vistaSeleccionar.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "El Cientifico seleccionado no existe");
				}
			} else {
				JOptionPane.showMessageDialog(vistaSeleccionar.getContentPane(), "No has introducido ningun DNI");
			}
		} 
			
		}
	}

