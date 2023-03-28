package conectaBD;

import java.sql.*;

public class ConsultaPreparada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {

			
			// crear conecion
		Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tabla1","root");
		
			// preparar consulta 
		PreparedStatement miSentencia=miConexion.prepareStatement("select nombrearticulo, seccion, paisorigen from productos where seccion=? and paisorigen=? ");
		
			// establecer parametros de consulta
		miSentencia.setString(1, "LACTEOS");
		miSentencia.setString(2, "MEXICO");
		
			// EJECUTAR Y RECORRER CONSULTA
		ResultSet rs=miSentencia.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getString(1) + rs.getString(2));
		}
		
		rs.close();		
		} catch(Exception e) {
			System.out.println("no conecto");
			e.printStackTrace();
		}
		

	}

}
