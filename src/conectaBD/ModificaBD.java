package conectaBD;

import java.sql.*;

public class ModificaBD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//1 ruta a la base de datos
		Connection miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tabla1", "root", );
		
		//2 se crea el estado
		Statement miEstado=miConexion.createStatement();
		
		// agregar informacion a la base de datos
		
		//se crea la instruccion
//		String instruccionSQL="insert into productos (seccion, nombrearticulo,precio,fecha,importado,paisorigen) values('LACTEOS','QUESO OAXACA',120.50,'2023-03-10',FALSE,'MEXICO')";
		
		//se manda la peticion a la base de datos
//		miEstado.executeUpdate(instruccionSQL);
		
		
		
		// actualizar informacion (editar informacion
		String instruccionSQL="UPDATE productos set precio=precio*2 WHERE id=3 ";
		
		//se manda la peticion a la base de datos
		miEstado.executeUpdate(instruccionSQL);
		
		
		//borrar datos
		
//		String instruccionSQL="delete from productos WHERE id=3 ";
		
		//se manda la peticion a la base de datos
//				miEstado.executeUpdate(instruccionSQL);
				
		
		System.out.println("datos enviados");
		
		}
		catch(Exception e) {
			System.out.println("no conecto");
		}

	}

}
