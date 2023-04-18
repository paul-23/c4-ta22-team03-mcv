package models;

import java.sql.Connection;

public class Videos {
	Connection conexion;
	public DataBase db;

	public Videos(DataBase db) {
		this.db = db;
		createVideos();
	}

	public void createVideos() {
		db.createTable("db", "Videos",
				"id int NOT NULL AUTO_INCREMENT PRIMARY KEY,"
				+ "title varchar(250) DEFAULT NULL,"
				+ "director varchar(250) DEFAULT NULL,"
				+ "cli_id int  DEFAULT NULL,"
				+ "CONSTRAINT videos_fk FOREIGN KEY (cli_id)"
				+ "REFERENCES Clientes (id)");
		db.insertData("db", "Videos", "title, director, cli_id","'Video1', 'Director1', 3");
		db.insertData("db", "Videos", "title, director, cli_id","'Video2', 'Director2', 2");
		db.insertData("db", "Videos", "title, director, cli_id","'Video3', 'Director3', 1");
	}

	public void insertVideos(String db, String table, String columnas, String atributos) {
		this.db.insertData(db, table, columnas, atributos);
	}

	public java.sql.ResultSet getValuesVideos(String db, String table) {
		return this.db.getValues("db", "Videos");
	}

	public void deleteFromDatabaseVideos(String db, String table, String ID, String IDValor) {

		this.db.deleteFromDatabase("db", "Videos", ID, IDValor);
	}
}
