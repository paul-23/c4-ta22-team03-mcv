package team03.ta22_c4_mvc_ejercicio02;

import java.sql.Connection;

import controllers.ControllerPrincipal;
import models.Cliente;
import models.DataBase;
import models.Videos;
import views.VistaPrincipal;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        DataBase db = new DataBase();
        Connection conexion;
        conexion = db.openConnection();
        db.dropDatabase("db");
        db.createDatabase("db");
        Cliente cliente = new Cliente(db);
        Videos video = new Videos(db);

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
		
		ControllerPrincipal controlador = new ControllerPrincipal(db,cliente, video, vistaPrincipal);
		
		controlador.iniciarVista();
    }
}
