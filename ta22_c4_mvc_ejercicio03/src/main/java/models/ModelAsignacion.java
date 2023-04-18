package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ModelAsignacion {
	private Connection connection;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private Date fecha;
	private String nombre_Proy;
	private int IDSeleccionado;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @return the nombre_Proy
	 */
	public String getNombre_Proy() {
		return nombre_Proy;
	}

	/**
	 * @return the iDSeleccionado
	 */
	public int getIDSeleccionado() {
		return IDSeleccionado;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @param nombre_Proy the nombre_Proy to set
	 */
	public void setNombre_Proy(String nombre_Proy) {
		this.nombre_Proy = nombre_Proy;
	}

	/**
	 * @param iDSeleccionado the iDSeleccionado to set
	 */
	public void setIDSeleccionado(int iDSeleccionado) {
		IDSeleccionado = iDSeleccionado;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return getConnection();
	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost?useTimezone=true&server=UTC", "root",
					"root");
			System.out.println("Connected!");
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Cannot connect to DB");
			System.out.println(ex);
		}
	}

	public void closeConnection() {
		try {
			connection.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexión con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(ModelBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void createDB(String name) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Nos intentamos conectar a las base de datos: " + name
				+ "\n-------------------------------------------------------------");
		try {
			String QueryDrop = "DROP DATABASE IF EXISTS " + name + ";";
			String Query = "CREATE DATABASE " + name + ";";
			Statement st = connection.createStatement();
			st.executeUpdate(QueryDrop);
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exito");
		} catch (SQLException ex) {
			Logger.getLogger(ModelBD.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	public void consultarAsignacion(int idParametro) {

		
		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "SELECT id,  dni from ASIGNADO_A WHERE dni='" + idParametro + "';";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			ResultSet registro = stdb.executeQuery(Query);

			if (registro.next() == true) {
				nombre = (registro.getString("nombre"));
				dni = (registro.getInt("dni"));
			} else {
				System.out.println("No existe ningún cliente con ese id.");
			}

			System.out.println("Datos obtenidos correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener cientifico");
		}
	}
}
