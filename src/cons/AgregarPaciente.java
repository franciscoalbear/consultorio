package cons;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class AgregarPaciente extends JFrame implements ActionListener{
	private JTextField nombre,apellidopat,apellidomat,correo,telefono;
	private JLabel welcome,op,namelabel,aplabel,amlabel,maillabel,phonelabel;
	private JButton registrar;
	private JPanel mainpanel;
	private JPanel centro,superior,inferior,izquierda,derecha;
	
	public AgregarPaciente(){
		
		nombre = new JTextField();
		apellidopat = new JTextField();
		apellidomat = new JTextField();
		correo = new JTextField();
		telefono = new JTextField();
		
		registrar = new JButton("Registrar");
		registrar.addActionListener(this);
		
		welcome = new JLabel("Bienvenidos al sistema de datos de pacientes");
		op = new JLabel("Elige la opción a realizar: ");
		namelabel = new JLabel("Nombre:");
		aplabel = new JLabel("Apellido paterno:");
		amlabel = new JLabel("Apellido materno:");
		maillabel = new JLabel("Correo:");
		phonelabel = new JLabel("telefono:");
		
		Container window = getContentPane();
		window.setLayout(new BorderLayout());
		
		centro = new JPanel();
		centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
		centro.setPreferredSize(new Dimension(300,200));
		centro.add(namelabel);
		centro.add(nombre);
		centro.add(aplabel);
		centro.add(apellidopat);
		centro.add(amlabel);
		centro.add(apellidomat);
		centro.add(maillabel);
		centro.add(correo);
		centro.add(phonelabel);
		centro.add(telefono);
		window.add(centro,BorderLayout.CENTER);
		
		superior = new JPanel();
		superior.setLayout(new FlowLayout());
		superior.setPreferredSize(new Dimension(150,150));
		superior.add(welcome);
		superior.add(op);
		window.add(superior,BorderLayout.NORTH);
		
		inferior = new JPanel();
		inferior.setLayout(new FlowLayout());
		inferior.setPreferredSize(new Dimension(150,150));
		inferior.add(registrar);
		window.add(inferior,BorderLayout.SOUTH);
		
		izquierda = new JPanel();
		izquierda.setLayout(new FlowLayout());
		izquierda.setPreferredSize(new Dimension(250,150));
		window.add(izquierda,BorderLayout.EAST);
		
		derecha = new JPanel();
		derecha.setLayout(new FlowLayout());
		derecha.setPreferredSize(new Dimension(50,150));
		window.add(derecha,BorderLayout.WEST);
		
						
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		   String name = nombre.getText();
		   String appat = apellidopat.getText();
		   String apmat = apellidomat.getText();
		   String mail = correo.getText();
		   int phone = Integer.parseInt(telefono.getText());
			
		
		CRUD crud = new CRUD(name,appat,apmat,mail,phone);
		int reg = crud.registrar();
		
		if(reg == 1){
			JOptionPane.showMessageDialog(this, "Datos ingresados correctamente");
		}
		else{
			JOptionPane.showMessageDialog(this, "Error al ingresar los datos");
		}
		
	}

}
