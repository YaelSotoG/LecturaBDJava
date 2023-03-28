package conectaBD;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Aplicacion_Consulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

JFrame mimarco=new Marco_Aplicacion();
		
		mimarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mimarco.setVisible(true);

	}

}

class Marco_Aplicacion extends JFrame{
	
	public Marco_Aplicacion(){
		
		setTitle ("Consulta BBDD");
		
		setBounds(500,300,400,400);
		
		setLayout(new BorderLayout());
		
		JPanel menus=new JPanel();
		
		menus.setLayout(new FlowLayout());
		
		secciones=new JComboBox();
		
		secciones.setEditable(false);
		
		secciones.addItem("Todos");
		
		paises=new JComboBox();
		
		paises.setEditable(false);
		
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		
		resultado.setEditable(false);
		
		add(resultado);
		
		menus.add(secciones);
		
		menus.add(paises);	
		
		add(menus, BorderLayout.NORTH);
		
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		
		//consulta del boton
		
		botonConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ejecutaConsulta();
			}
		});
		
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
		
		// ----------- CONEXION DB-----------
		try {
			
//			//conexion con la base
			miConexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/tabla1", "root", );
//			
			//se crea el statement
			
			Statement miEstado=miConexion.createStatement();
			
			// se hace la peticion
			
			//la instruccion distinctrow solo carga una linea por seccion
			String consulta="select distinctrow seccion from productos";
			
			ResultSet rs=miEstado.executeQuery(consulta);
			
			
			// agrega las secciones a la lista
			while(rs.next()) {
				secciones.addItem(rs.getString(1));
			}
			
			rs.close();
			
			
			// se hace la peticion
			consulta="select distinctrow paisorigen from productos";
			rs=miEstado.executeQuery(consulta);
			
			
			// agrega los paises a la lista
			while(rs.next()) {
				paises.addItem(rs.getString(1));
			}
			
			rs.close();
			
			
			
			
			
		} catch(Exception e) {
			
		}
		
		
		
		
		
	}	
		
	private void ejecutaConsulta() {
			ResultSet rs=null;	
		
		try {
			//resetea el cuadro
			resultado.setText("");
			// el getSelectedItem() regresa un objeto y con el (String) lo convertimos
			String seccion=(String)secciones.getSelectedItem();
			
			String pais=(String)paises.getSelectedItem();
			if(!seccion.equals("Todos") && pais.equals("Todos")) {
				//se agrega el comando en mysql
				enviaConsultasSeccion=miConexion.prepareStatement(consultaSeleccion);
				enviaConsultasSeccion.setString(1, seccion);	
				rs=enviaConsultasSeccion.executeQuery();
			}else if(seccion.equals("Todos") && !pais.equals("Todos")) {
				//se agrega el comando en mysql
				enviaConsultasPais=miConexion.prepareStatement(consultaPais);
				enviaConsultasPais.setString(1, pais);	
				rs=enviaConsultasPais.executeQuery();
			}else if(!seccion.equals("Todos") && !pais.equals("Todos")){
				//se agrega el comando en mysql
				enviaConsultasTodo=miConexion.prepareStatement(consultaTodo);
				enviaConsultasTodo.setString(1, pais);	
				enviaConsultasTodo.setString(2, seccion);	
				rs=enviaConsultasTodo.executeQuery();
				
			}
			
			while(rs.next()) {
				resultado.append(rs.getString(1));
				resultado.append(", ");
				resultado.append(rs.getString(2));
				resultado.append(", ");
				resultado.append(rs.getString(3));
				resultado.append(", ");
				resultado.append(rs.getString(4));
				resultado.append("\n");
				
			}
			
			
		}catch(Exception e) {
			System.out.println("fallo");
		}
		
	}
	
	private Connection miConexion;

	private PreparedStatement enviaConsultasSeccion;
	private PreparedStatement enviaConsultasPais;
	private PreparedStatement enviaConsultasTodo;
	
	private final String consultaSeleccion="SELECT nombrearticulo, seccion, paisorigen from productos where seccion=?";
	private final String consultaPais="SELECT nombrearticulo, seccion, paisorigen from productos where paisorigen=?";
	private final String consultaTodo="SELECT nombrearticulo, seccion, paisorigen from productos where paisorigen=? and seccion=?";
	private JComboBox secciones;
	
	private JComboBox paises;
	
	private JTextArea resultado;	
	

}
