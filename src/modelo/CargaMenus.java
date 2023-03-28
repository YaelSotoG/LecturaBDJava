package modelo;

import java.sql.*;

import controlador.*;

public class CargaMenus {
	
	public CargaMenus() {
		
		miConexion=new conexion();
		
	}
	
	public String ejecutaConsultas() {
		Productos miProducto=null;
		Connection accesoBD=miConexion.DameConexion();
		try {
			
			Statement secciones=accesoBD.createStatement();
			Statement paises=accesoBD.createStatement();
			//regrese los valores de la columna seccion sin repetir (distinctrow)
			rs=secciones.executeQuery("select distinctrow seccion from productos");
			rs2=paises.executeQuery("select distinctrow paisorigen from productos");
			
			//while(rs.next()) {
			
			
			//aqui encapsula los productos
				miProducto=new Productos();
				miProducto.setSeccion(rs.getString(1));
				miProducto.setpOrigen(rs2.getString(1));
				
				//return miProducto.getSeccion();
			//}
			rs.close();
			rs2.close();
		}catch(Exception e) {
			System.out.println("Fallo en clase cargaSecciones");
		}
		
		
		return miProducto.getSeccion();
	}
	
	
	
	// la clase dentro de controlador
	conexion miConexion;
	
	public ResultSet rs;
	public ResultSet rs2;
}
