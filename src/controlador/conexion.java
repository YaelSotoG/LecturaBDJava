package controlador;
import java.sql.*;

public class conexion {
	
	Connection miConexion=null;
	public conexion() {
		
	}
	
	public Connection DameConexion() {
		try {
			// se hace la conexion
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tabla1", "root", );
			// se crea el estado
//			Statement miEstado=miConexion.createStatement();
			
		}catch(Exception e) {
			System.out.println("fallo");
			e.printStackTrace();
		}
		
		return miConexion;
	}
}
