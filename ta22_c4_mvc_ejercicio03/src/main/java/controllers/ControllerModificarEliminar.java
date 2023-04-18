/**
 * 
 */
package controllers;

import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import models.ModelBD;
<<<<<<< HEAD
import views.vistaME;
=======
import views.vistaModificarEliminar;
import views.vistaPrincipal;
>>>>>>> branch 'master' of https://github.com/paul-23/c4-ta22-team03-mcv

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */
<<<<<<< HEAD
public class ControllerModificarEliminar {
	
	vistaME vistaModificarEliminar = new vistaME();
=======
public class ControllerModificarEliminar implements ActionListener {

	LocalDate fecha = LocalDate.now();
	vistaModificarEliminar vistaModificarEliminar = new vistaModificarEliminar();
	vistaPrincipal vp = new vistaPrincipal();
>>>>>>> branch 'master' of https://github.com/paul-23/c4-ta22-team03-mcv
	ModelBD modelo;
	private int IDSeleccionado;

	public ControllerModificarEliminar(ModelBD modelo, int IDParametro) {
		this.modelo = modelo;
		this.IDSeleccionado = IDParametro;
		this.vistaModificarEliminar.btnModificar.addActionListener(this);
		this.vistaModificarEliminar.btnEliminar.addActionListener(this);
		this.vistaModificarEliminar.btnCancelar.addActionListener(this);
	}

	public void iniciar() {
		vistaModificarEliminar.setVisible(true);
		obtenerDatosUsuario();
	}
	/*PRoblema 1*/
	public void obtenerDatosUsuario() {
		modelo.consultarcientificos(IDSeleccionado);
		vistaModificarEliminar.textFieldNombre.setText(modelo.getNombre());
		vistaModificarEliminar.textFieldDNI.setText(Integer.toString(modelo.getDni()));
		//vistaModificarEliminar.textFieldAsignado.setText(modelo.getNombre_Proy());
		
	}

	public void cerrarVentanaVolver() {
		vistaModificarEliminar.setVisible(false);
		ControllerSeleccionar cs = new ControllerSeleccionar(modelo);
		cs.iniciar();
	}

	public void cerrarVentanaVolverInicio() {
		vistaModificarEliminar.setVisible(false);
		ControladorInicio ci = new ControladorInicio(modelo, vp);
		ci.iniciarVista();
		ci.mostrarCientifico();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (vistaModificarEliminar.btnModificar == e.getSource()) {

			modelo.modificarCientifico( vistaModificarEliminar.textFieldNombre.getText(),
					Integer.parseInt(vistaModificarEliminar.textFieldDNI.getText()));
			cerrarVentanaVolverInicio();

		} else if (vistaModificarEliminar.btnEliminar == e.getSource()) {

			JLabel label = new JLabel("<html><h1>¿Eliminar el cientifico " + modelo.getNombre() + " (DNI: "
					+ modelo.getDni() + ")?</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			int input = JOptionPane.showConfirmDialog(vistaModificarEliminar.contentPane, label, "Eliminar Cliente",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (input == 0) {
				modelo.eliminarCientifico(IDSeleccionado);
				cerrarVentanaVolverInicio();
			}

		} else if (vistaModificarEliminar.btnCancelar == e.getSource()) {
			cerrarVentanaVolver();
		}
	}

}
