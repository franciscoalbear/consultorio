package cons;

import java.awt.BorderLayout;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TablaDatos extends JFrame{
	private ResultSet resultados;
	private JTable tabla;
	DefaultTableModel modelo;
	JScrollPane desplazamiento;
	
	public TablaDatos(){
		String [] columnas = {"Id","Nombre","Apellido Paterno","Apellido Materno","Correo","Telefono"};
		tabla = new JTable();
		modelo = new DefaultTableModel();
		desplazamiento = new JScrollPane(tabla);
		
		int id,telefono;
		String nombre,ap,am,correo;
		
		this.setLayout(new BorderLayout());
		
		 modelo.setColumnIdentifiers(columnas);
		 
		 desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 
		 tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	     tabla.setFillsViewportHeight(true);
	     
	     tabla.setModel(modelo);
	     
	     this.getContentPane().add(desplazamiento, BorderLayout.NORTH);    
	     this.pack();
	     
	     try{
	    	 CRUD fill = new CRUD();
		     resultados = fill.consulta();
		     
		     while(resultados.next()==true){
		    	 id = resultados.getInt("ID");
		    	 nombre = resultados.getString("NOMBRE");
		    	 ap = resultados.getString("APELLIDOPAT");
		    	 am = resultados.getString("APELLIDOMAT");
		    	 correo = resultados.getString("CORREO");
		    	 telefono = resultados.getInt("TELEFONO");
		    	 
		    	 modelo.addRow(new Object[] {id,nombre,ap,am,correo,telefono});
		     }
	     }catch(Exception e){
	    	 System.out.println("error");
	    	 e.printStackTrace();
	     }
	}
}
