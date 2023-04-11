/**
 * 
 */
package team03.ta22_c4_mvc_ejercicio01.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import team03.ta22_c4_mvc_ejercicio01.models.ModeloCliente;
import team03.ta22_c4_mvc_ejercicio01.views.VistaAñadir;
import team03.ta22_c4_mvc_ejercicio01.views.VistaPrincipal;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
public class ControladorAñadir implements ActionListener {
	
	LocalDate fecha = LocalDate.now();
	
	VistaAñadir vistaAñadir = new VistaAñadir();
	VistaPrincipal vistaPrincipal = new VistaPrincipal();
	ModeloCliente modelo;
	
	public ControladorAñadir (ModeloCliente modelo) {
		this.modelo = modelo;
		this.vistaAñadir.btnAñadir.addActionListener(this);
		this.vistaAñadir.btnCancelar.addActionListener(this);
	}
	
	public void iniciar() {
		vistaAñadir.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaAñadir.btnAñadir == e.getSource()) {
			System.out.println("btnañadir");
			modelo.insertData(vistaAñadir.textFieldNombre.getText(), vistaAñadir.textFieldApellido.getText(), vistaAñadir.textFieldDireccion.getText(), vistaAñadir.textFieldDNI.getText(), fecha.toString());
			vistaAñadir.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarClientes();
		} else if (vistaAñadir.btnCancelar == e.getSource()) {
			vistaAñadir.setVisible(false);
			ControladorInicio ci = new ControladorInicio(modelo, vistaPrincipal);
			ci.iniciarVista();
			ci.mostrarClientes();
		}
	}
	
	
}
