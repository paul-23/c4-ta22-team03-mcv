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

public class ModelBDProy {

	Connection connection;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private Date fecha;
	private int horas;
	private int IDSeleccionado;

	/**
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @return the iDSeleccionado
	 */
	public int getIDSeleccionado() {
		return IDSeleccionado;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
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

	public void consultarProyectos(int idParametro) {

		try {
			connect();
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "SELECT nombre,  id, horas from proyecto WHERE id='" + idParametro + "';";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			ResultSet registro = stdb.executeQuery(Query);

			if (registro.next() == true) {
				nombre = (registro.getString("nombre"));
				id = (registro.getInt("idParametro"));
			} else {
				System.out.println("No existe ningún cliente con ese id.");
			}

			System.out.println("Datos obtenidos correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener proyecto");
		}
	}

	public ResultSet consultarTodosProyectos() {
		ResultSet registro = null;
		try {
			String Query = "SELECT id,  nombre, horas FROM pryecto;";
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			registro = stdb.executeQuery(Query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener proyectos");
		}
		return registro;
	}

	public String checkID(String table_name, int IDIntroducido) {
		try {
			connect();
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(Querydb);

			String query = "SELECT ID FROM " + table_name;
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

	public void eliminarProyecto(int idParametro) {
		connect();
		try {
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "DELETE FROM proyecto WHERE id='" + idParametro + "';";

			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Proyecto eliminado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al eliminar proyecto");
		}
	}

	public void consultarproyectos(int idParametro) {

		try {
			connect();
			String Query = "SELECT nombre, horas, id from proyecto WHERE id='" + idParametro + "';";
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			ResultSet registro = stdb.executeQuery(Query);

			if (registro.next() == true) {
				nombre = (registro.getString("nombre"));
				id = (registro.getInt("id"));
				horas = (registro.getInt("horas"));
			} else {
				System.out.println("No existe ningún proyecto con ese id.");
			}
			System.out.println("Datos obtenidos correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener proyecto");
		}
	}

	public void createTable(String db, String query) {
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
	public void insertData(String nombre, int id, int horas) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos insertar datos en la tabla"
				+ "\n-------------------------------------------------------------");
		try {
			connect();
			String Query = "INSERT INTO proyecto (nombre,  id, horas) VALUE (" + "\"" + nombre + "\", '" + id + "', '"+ horas + "');";
			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}

	public void modificarProyecto(int id, String nombre, int horas) {
		
		try {

			String Querydb = "USE Ej3asignacionCientificosProyectos;";
			String Query = "UPDATE Proyecto SET id = "+id+" , Nombre = \""+nombre+"\" , Horas = "+horas+" WHERE Id = "+id+ ";";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Proyecto actualizado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar proyecto");
		}
	}

}
