package models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import models.DataBase;

public class Cliente {
	Connection conexion;
	public DataBase db;

	public Cliente(DataBase db) {
		this.db = db;
		createTableCliente();
	}

	public void createTableCliente() {
		db.createTable("db", "Clientes",
				"id int NOT NULL AUTO_INCREMENT PRIMARY KEY," + "nombre varchar(250) DEFAULT NULL,"
						+ "apellido varchar(250) DEFAULT NULL," + "direccion varchar(250) DEFAULT NULL,"
						+ "dni int  DEFAULT NULL");
		db.insertData("db", "Clientes", "nombre, apellido, direccion, dni",
				"'Arnau', 'Leinster', 'Direccion 1', 11111111");
		db.insertData("db", "Clientes", "nombre, apellido, direccion, dni",
				"'Alejandro', 'Jimenez', 'Direccion 2', 22222222");
		db.insertData("db", "Clientes", "nombre, apellido, direccion, dni",
				"'Paul', 'Stanescu', 'Direccion 3', 33333333");
	}

	public void insertCliente(String db, String table, String columnas, String atributos) {
		this.db.insertData(db, table, columnas, atributos);
	}

	public java.sql.ResultSet getValuesCliente(String db, String table) {
		return this.db.getValues("db", "Cliente");
	}

	public void deleteFromDatabaseCliente(String db, String table, String ID, String IDValor) {

		this.db.deleteFromDatabase("db", "Videos", ID, IDValor);
	}
}
