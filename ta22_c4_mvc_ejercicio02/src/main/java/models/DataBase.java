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

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

/**
 * @author Team 03 (Alejandro, Arnau y Paul)
 *
 */

public class DataBase {
	Connection conexion;

//-----------------------------------------------------------------
	public Connection openConnection() {
		// Connection conexion = null;
		conexion = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.43:3306", "remote", "-Crocodile123");
			System.out.println("Conectado a la base de datos");

		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(123321);
			// e.printStackTrace();
		}

		return conexion;
	}

	// -----------------------------------------------------------------
	public void createDatabase(String nom) {

		try {
			String Query = "CREATE DATABASE " + nom;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			// closeConnection(conexion);
			// openConnection(conexion);
			System.out.println("DataBase creado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error abriendo la conexion " + e);
		}
	}

	// -----------------------------------------------------------------
	public void closeConnection() {
		// TODO Auto-generated method stub
		try {
			conexion.close();
			System.out.println("Cerrada la conexion");
		} catch (SQLException e) {
			System.out.println("Error cerrando la conexion: " + e);
		}
	}

	// -----------------------------------------------------------------
	public void createTable(String db, String table, String atributos) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// CREATE TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("CREATE TABLE " + table + "(" + atributos + ");");
			System.out.println("Table creada: " + table);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error creando la table: " + e);
		}
	}

	// -----------------------------------------------------------------
	public void insertData(String db, String table, String columnas, String atributos) {
		try {
			// USE database
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			// INSERT INTO TABLE
			Statement st = conexion.createStatement();
			st.executeUpdate("INSERT INTO " + table + "(" + columnas + ")" + " VALUE(" + atributos + ");");
			System.out.println("data insertada: " + atributos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error insertando data: " + e);
		}
	}

	// Modify table
//	public void modify(int idParametro, String nombre, String apellido, String direccion, String dni,
//			String fecha) {
//		try {
//			String Querydb = "USE CLIENTES;";
//			String Query = "UPDATE cliente SET nombre='" + nombre + "', apellido='"+ apellido
//					+ "', direccion='" + direccion + "', fecha='" + fecha + "' WHERE id='"
//					+ idParametro + "';";
//
//			Statement stdb = conexion.createStatement();
//			stdb.executeUpdate(Querydb);
//			stdb.executeUpdate(Query);
//
//			JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//			JOptionPane.showMessageDialog(null, "Error al actualizar cliente");
//		}
//	}

	// -----------------------------------------------------------------
	public java.sql.ResultSet getValues(String db, String table) {
		java.sql.ResultSet resultSet = null;
		try {
			String queryDB = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);

			String querySelect = "SELECT * FROM " + table + ";";
			Statement stsel = conexion.createStatement();

			resultSet = stsel.executeQuery(querySelect);

		} catch (SQLException e) {
			System.out.println("Values no coleccionadas correctamente:" + e);
		}
		return resultSet;
	}

	public void deleteFromDatabase(String db, String table, String ID, String IDValor) {
		try {
//			String queryDB = "USE " + db + ";";
//			Statement stdb = conexion.createStatement();
//			stdb.executeUpdate(queryDB);
//			
			String query = "DELETE FROM " + table + " WHERE " + ID + " = " + IDValor;
			Statement delTable = conexion.createStatement();
			delTable.executeUpdate(query);
			System.out.println(2);

		} catch (SQLException e) {
			System.out.println("Values not deleted correctly");
		}
	}

	public String comprovar(String db, String table, String ID, String IDValor) throws SQLException {
		String queryDB = "USE " + db + ";";
		Statement stdb = conexion.createStatement();
		stdb.executeUpdate(queryDB);

		String result = "";
		try {

			String query = "SELECT " + ID + " FROM " + table + " WHERE " + ID + " = " + IDValor;
			Statement delTable = conexion.createStatement();
			ResultSet rs = delTable.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					
					if (Integer.parseInt(IDValor) == rs.getInt(i)) {
//						System.out.println(rs.getString(i));
						result = rs.getString(i);
					}
				}
			}

		} catch (SQLException e) {
			System.out.println("Values not found");
		}
		return result;
	}

	public void dropDatabase(String db) {
		try {
			String queryDB = "DROP DATABASE IF EXISTS " + db;
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(queryDB);
			System.out.println("Drop complete");

		} catch (SQLException ex) {
			System.out.println("Drop incomplete");
		}

	}
}