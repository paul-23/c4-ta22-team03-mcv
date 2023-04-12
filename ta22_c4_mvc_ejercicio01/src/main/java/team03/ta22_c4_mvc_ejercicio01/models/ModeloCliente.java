package team03.ta22_c4_mvc_ejercicio01.models;

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
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class ModeloCliente {

	Connection connection;
	private int id;
	private String nombre;
	private String apellido;
	private String direccion;
	private int dni;
	private Date fecha;

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
			Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
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
			System.out.println("Se ha creado la base de datos " + name + " de forma exitosa");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public String checkID(String table_name, int IDIntroducido) {
		try {
			String Querydb = "USE CLIENTES;";
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

	public void createTable(String db, String query) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos crear la tabla" + "\n-------------------------------------------------------------");
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(query);
			System.out.println("Tabla creada con exito!");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la tabla.");
		}
	}

	public ResultSet consultarTodosClientes() {
		ResultSet registro = null;
		try {
			String Query = "SELECT id, nombre, apellido, direccion, dni, fecha FROM cliente;";
			String Querydb = "USE CLIENTES;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			registro = stdb.executeQuery(Query);
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener cliente");
		}
		return registro;
	}

	public void consultarCliente(int idParametro) {

		try {
			String Query = "SELECT nombre, apellido, direccion, dni from cliente WHERE id='" + idParametro + "';";
			String Querydb = "USE CLIENTES;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			ResultSet registro = stdb.executeQuery(Query);

			if (registro.next() == true) {
				nombre = (registro.getString("nombre"));
				apellido = (registro.getString("apellido"));
				direccion = (registro.getString("direccion"));
				dni = (registro.getInt("dni"));
				nombre = (registro.getString("nombre"));
			} else {
				System.out.println("No existe ningún cliente con ese id.");
			}

			System.out.println("Datos obtenidos correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al obtener cliente");
		}
	}

	public void eliminarCliente(int idParametro) {
		try {
			String Querydb = "USE CLIENTES;";
			String Query = "DELETE FROM cliente WHERE id='" + idParametro + "';";

			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al eliminar cliente");
		}
	}

	public void modificarCliente(int idParametro, String nombre, String apellido, String direccion, String dni,
			String fecha) {
		try {
			String Querydb = "USE CLIENTES;";
			String Query = "UPDATE cliente SET nombre='" + nombre + "', apellido='"+ apellido
					+ "', direccion='" + direccion + "', fecha='" + fecha + "' WHERE id='"
					+ idParametro + "';";

			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al actualizar cliente");
		}
	}

	// METODO QUE INSERTA DATOS EN TABLAS MYSQL
	public void insertData(String nombre, String apellido, String direccion, String dni, String fecha) {
		System.out.println("-------------------------------------------------------------\n"
				+ "Intentamos insertar datos en la tabla"
				+ "\n-------------------------------------------------------------");
		try {
			String Query = "INSERT INTO cliente (nombre, apellido, direccion, dni, fecha) VALUE (" + "\"" + nombre
					+ "\", \"" + apellido + "\", \"" + direccion + "\", '" + dni + "', '" + fecha
					+ "');";
			String Querydb = "USE CLIENTES;";
			Statement stdb = getConnection().createStatement();
			stdb.executeUpdate(Querydb);
			stdb.executeUpdate(Query);
			System.out.println("Datos almacenados correctamente");
			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el aleacenamiento");
		}
	}
}
