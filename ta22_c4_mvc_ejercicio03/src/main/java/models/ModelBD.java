package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * 
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class ModelBD {

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
	 * @return the iDSeleccionado
	 */
	public int getIDSeleccionado() {
		return IDSeleccionado;
	}

	/**
	 * @param iDSeleccionado the iDSeleccionado to set
	 */
	public void setIDSeleccionado(int iDSeleccionado) {
		IDSeleccionado = iDSeleccionado;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre_Proy
	 */
	public String getNombre_Proy() {
		return nombre_Proy;
	}

	/**
	 * @param nombre_Proy the nombre_Proy to set
	 */
	public void setNombre_Proy(String nombre_Proy) {
		this.nombre_Proy = nombre_Proy;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the dni
	 */
	public int getDni() {
		return dni;
	}

	/**
	 * @param dni the dni to set
	 */
	public void setDni(int dni) {
		this.dni = dni;
	}

	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * @param connection the connection to set
	 */
	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection getConnection() {
		return connection;
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

	public void consultarCinetificos(int idParametro) {

		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "SELECT nombre,  dni from cientificos WHERE dni='" + idParametro + "';";
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

	public void modificarCientifico(String nombre, int dni ) {
		System.out.print(nombre);
		System.out.print(dni);
		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "UPDATE cientificos SET nombre='" + nombre + "' WHERE DNI='" + dni + "';";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Cientifico actualizado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar cientifico");
		}
	}

	public ResultSet consultarTodosCientificos() {
		ResultSet registro = null;
		try {
			connect();
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "SELECT  dni, nombre FROM cientificos;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			registro = stdb.executeQuery(Query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener cientificos");
		}
		return registro;
	}

	public String checkDNI(String table_name, int IDIntroducido) {
		try {
			connect();
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(Querydb);

			String query = "SELECT DNI FROM " + table_name;
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();

			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					if (IDIntroducido == rs.getInt(i)) {
						return rs.getString(i);
					}
				}
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");

		}
		return "";
	}

	public void eliminarCientifico(int idParametro) {
		connect();
		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "DELETE FROM cientificos WHERE dni='" + idParametro + "';";

			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Cientifico eliminado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al eliminar cientifico");
		}
	}

	public void consultarcientificos(int idParametro) {
connect();
		try {
			String Query = "SELECT nombre,DNI FROM cientificos c";

			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			ResultSet registro = stdb.executeQuery(Query);
			if (registro.next() == true) {
				nombre = (registro.getString("nombre"));
			//	nombre_Proy = (registro.getString("p.nombre"));
				dni = (registro.getInt("DNI"));
			} else {
				System.out.println("No existe ningún cientifico con ese dni.");
			}

			System.out.println("Datos obtenidos correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener cientifico");
		}

	}

	public void createTable(String db, String query) {
		connect();
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos crear la tabla" + "\n-------------------------------------------------------------");
		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(query);
			System.out.println("Tabla creada con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	// METODO QUE INSERTA DATOS EN TABLAS MYSQL
	public void insertData(String nombre, int dni) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos insertar datos en la tabla"
				+ "\n-------------------------------------------------------------");
		connect();
		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
		String	 Query = "INSERT INTO cientificos (nombre,dni) values(\""+nombre+"\","+dni+")";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el aleacenamiento");
		}
	}

	
}
