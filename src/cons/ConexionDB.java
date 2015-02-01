package cons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConexionDB {
	public static Connection GetConnection(){
		Connection conexion = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost/consultorio";
			String usuarioDB = "root";
			String passwordDB = "dev1";
			conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
			
		}
		catch(ClassNotFoundException e){
			 JOptionPane.showMessageDialog(null, e, "Error1 en la Conexión con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
	         conexion=null;
		}
		catch(SQLException e){
			 JOptionPane.showMessageDialog(null, e, "Error2 en la Conexión con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
	         conexion=null;
		}
		catch(Exception e){
			 JOptionPane.showMessageDialog(null, e, "Error3 en la Conexión con la BD "+e.getMessage(), JOptionPane.ERROR_MESSAGE);
	         conexion=null;
		}
		finally{
			return conexion;
		}
	}
}
