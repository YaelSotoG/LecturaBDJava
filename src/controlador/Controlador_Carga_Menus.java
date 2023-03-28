package controlador;

import java.awt.event.*;

import modelo.CargaMenus;
import vista.Marco_Aplicacion2;



//lo que hace esta clase es que cuando se crea la ui, manda un evento
//esta clase observa ese evento y dice ya esta la gui asi que 
// llama la clase marco_aplicacion que lee la BD y regresa la columna de secciones
// y se la manda al listview

public class Controlador_Carga_Menus extends WindowAdapter{
	
	public Controlador_Carga_Menus(Marco_Aplicacion2 elmarco) {
		this.elmarco=elmarco;
	}
	
	public void WindowOpened(WindowEvent e) {
		
		obj.ejecutaConsultas();
		
		try {
			
			while(obj.rs.next()) {
				elmarco.secciones.addItem(obj.rs.getString(1));
			}
			while(obj.rs2.next()) {
				elmarco.paises.addItem(obj.rs2.getString(1));
			}
		
			obj.rs.close();
		}catch(Exception e2) {
			System.out.println("fallo en el controlador carga secciones");
			e2.printStackTrace();
		}
		
	}
		
	
	
	CargaMenus obj=new CargaMenus();
	
	private Marco_Aplicacion2 elmarco;
		
	
}
