package cons;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JFrame implements ActionListener{
	
	private JTextField id0,id1,nombre,appat,apmat,tel,correo;
	private JLabel encabezado,id2;
	private JButton buscar,actualizar;
	private JPanel superior,inferior,centro;
    private ResultSet res; 
	
	public Update(){
		
		this.setBounds(500, 150, 500, 150);
		
		id0 = new JTextField();
		id0.setPreferredSize(new Dimension(30,20));
		id0.setBounds(100, 100, 100, 100);
		
		id1 = new JTextField();
		nombre = new JTextField();
		appat = new JTextField();
		apmat = new JTextField();
		correo = new JTextField();
		tel = new JTextField();
		
		encabezado = new JLabel("Actualizar paciente");
		encabezado.setBounds(100,50, 400, 20);
		
		id2 = new JLabel("Escriba el id del paciente a actualizar:");
		
		buscar = new JButton("Buscar");
		buscar.addActionListener(this);
		
		actualizar = new JButton("Actualizar");
		actualizar.addActionListener(this);
		
		Container window = getContentPane();
		window.setLayout(new BorderLayout());
		
		superior = new JPanel();
		superior.setLayout(null);
		superior.setPreferredSize(new Dimension(250,100));
		superior.add(encabezado);
		window.add(superior,BorderLayout.NORTH);
		
		centro = new JPanel();
		centro.setLayout(new FlowLayout());
		centro.setPreferredSize(new Dimension(450,200));
		centro.add(id2);
		centro.add(id0);
		centro.add(buscar);
		window.add(centro,BorderLayout.CENTER);
		
		inferior = new JPanel();
		inferior.setPreferredSize(new Dimension(450,200));
		inferior.setLayout(new BoxLayout(inferior,BoxLayout.Y_AXIS));
		inferior.add(id1);
		inferior.add(nombre);
		inferior.add(appat);
		inferior.add(apmat);
		inferior.add(correo);
		inferior.add(tel);
		inferior.add(actualizar);
		window.add(inferior,BorderLayout.SOUTH);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int id = Integer.parseInt(id0.getText());
		int i = 0,t = 0,success;
		String n = null,ap = null,am = null,c = null,parseid,parset;
		
		if(e.getSource() == buscar){
			CRUD busqueda = new CRUD();
			res = busqueda.busqueda(id);
			
			try {
				while(res.next()==true){
					i = res.getInt("ID");
					n = res.getString("NOMBRE");
					ap = res.getString("APELLIDOPAT");
					am = res.getString("APELLIDOMAT");
					c = res.getString("CORREO");
					t = res.getInt("TELEFONO");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			parseid = Integer.toString(i);
			parset = Integer.toString(t);
			
			id1.setText(parseid);
			nombre.setText(n);
			appat.setText(ap);
			apmat.setText(am);
			correo.setText(c);
			tel.setText(parset);
			
		}
		if(e.getSource() == actualizar){
			CRUD update = new CRUD();
			success = update.actualizar(Integer.parseInt(id1.getText()), nombre.getText(), appat.getText(), apmat.getText(), correo.getText(), Integer.parseInt(tel.getText()), Integer.parseInt(id0.getText()));
			if(success == 1){
				JOptionPane.showMessageDialog(this, "Datos actualizados exitosamente");
			}else{
				JOptionPane.showMessageDialog(this, "No se pudieron actualizar los datos");
			}
		}
		
	}
	
}
