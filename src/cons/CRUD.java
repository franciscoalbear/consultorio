package cons;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class CRUD {
	private String nombre,apat,amat,correo;
	private int telefono;
	Connection miConexion = (Connection)ConexionDB.GetConnection();
	private ResultSet resultado;
	
	public CRUD(){}
	
	public CRUD(String nombre,String apat,String amat,String correo,int telefono){
		this.nombre = nombre;
		this.apat = apat;
		this.amat = amat;
		this.correo = correo;
		this.telefono = telefono;
	}
	public CRUD(String nombre,String apat,String amat){
		this.nombre = nombre;
		this.apat = apat;
		this.amat = amat;
	}
	public int registrar(){
		int success;
		
		//Connection miConexion = (Connection)ConexionDB.GetConnection();
		try{
			Statement statement = (Statement)miConexion.createStatement();
			statement.executeUpdate("insert into pacientes(NOMBRE,APELLIDOPAT,APELLIDOMAT,CORREO,TELEFONO) values('"+nombre+"','"+apat+"','"+amat+"','"+correo+"','"+telefono+"')");
			
			System.out.println("Datos ingresados correctamente");
			success = 1;
			
			statement.close();
			//miConexion.close();
		}
		catch(Exception e){
			System.out.print("error");
			success = 0;
			e.printStackTrace();
		}
		return success;
	}
	public int eliminar(){
		int success;
		
		//Connection miConexion = (Connection)ConexionDB.GetConnection();
		try{
			Statement statement = (Statement)miConexion.createStatement();
			statement.executeUpdate("DELETE FROM pacientes WHERE NOMBRE = '"+nombre+"' AND APELLIDOPAT = '"+apat+"' AND APELLIDOMAT = '"+amat+"'");
			
			success = 1;
			
			statement.close();
			//miConexion.close();
		}catch(Exception e){
			success = 0;
			e.printStackTrace();
		}
		return success;
	}
	public ResultSet consulta(){
		String instruccion = "SELECT * FROM pacientes";
		
		try{
			Statement statement = (Statement)miConexion.createStatement();
			resultado = statement.executeQuery(instruccion);
			
		}catch(Exception e){
			System.out.print("error");
			e.printStackTrace();
		}
		return resultado;
	}
	public ResultSet busqueda(int id){
		String sql = "SELECT * FROM pacientes WHERE ID = '"+id+"'";
		
		try{
			Statement statement = (Statement)miConexion.createStatement();
			resultado = statement.executeQuery(sql);
			
		}catch(Exception e){
			System.out.print("error");
			e.printStackTrace();
		}
		return resultado;
	}
	public int actualizar(int id, String nombre, String ap, String am, String correo, int tel, int ref){
		int success = 0;
		String sql = "UPDATE pacientes SET ID = '"+id+"', NOMBRE = '"+nombre+"', APELLIDOPAT = '"+ap+"', APELLIDOMAT = '"+am+"', CORREO = '"+correo+"', TELEFONO = '"+tel+"' WHERE ID = '"+ref+"'";
		try{
			Statement statement = (Statement)miConexion.createStatement();
			success = statement.executeUpdate(sql);
			
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
			success = 0;
		}
		return success;
	}
	public void closesql(){
		try{
			miConexion.close();
		}catch(Exception e){
			System.out.print("error");
		}
	}
	
}

