package conectaBD;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

//import com.mysql.cj.xdevapi.Statement;

public class Conecta_Productos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			// 1  crear la coneccion con la base de datos
			
			Connection base=DriverManager.getConnection("jdbc:mysql://localhost:3306/tabla1","root" ,);
			
			//2 crear objeto statement 
			Statement miStatement=base.createStatement();
			
			//3 ejecutar sql
			ResultSet miResultado=miStatement.executeQuery(" SELECT * FROM productos");
			
			// 4 recorrer o leer el resultado
			while(miResultado.next()) {
				
				System.out.println(miResultado.getString("nombrearticulo"));
				
			}
			
		}catch(Exception e) {
			
			System.out.println("no conecta");
			e.printStackTrace();			
		}

	}

}
