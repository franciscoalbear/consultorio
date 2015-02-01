package cons;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pantalla1 extends JFrame implements ActionListener{
	private JButton boton1,boton2,boton3,boton4,boton5,salir;
	private JLabel welcome,op;
	private JPanel mainpanel;
	private JPanel centro,superior,inferior,izquierda,derecha;
	
	public Pantalla1(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		boton1 = new JButton("Registrar Paciente");
		boton1.addActionListener(this);
		
		boton2 = new JButton("Mostrar registros");
		boton2.addActionListener(this);
		
		boton3 = new JButton("Borrar paciente");
		boton3.addActionListener(this);
		
		boton4 = new JButton("Actualizar paciente");
		boton4.addActionListener(this);
		
		boton5 = new JButton("Acerca de");
		boton5.addActionListener(this);
		
		salir = new JButton("Salir");
		salir.addActionListener(this);
		
		welcome = new JLabel("Bienvenidos al sistema de datos de pacientes");
		op = new JLabel("Elige la opción a realizar: ");
		
		Container window = getContentPane();
		window.setLayout(new BorderLayout());
		
		centro = new JPanel();
		centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
		//centro.setPreferredSize(new Dimension(200,200));
		centro.add(boton1);
		centro.add(boton2);
		centro.add(boton3);
		centro.add(boton4);
		centro.add(boton5);
		centro.add(salir);
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
		window.add(inferior,BorderLayout.SOUTH);
		
		izquierda = new JPanel();
		izquierda.setLayout(new FlowLayout());
		izquierda.setPreferredSize(new Dimension(150,150));
		window.add(izquierda,BorderLayout.EAST);
		
		derecha = new JPanel();
		derecha.setLayout(new FlowLayout());
		derecha.setPreferredSize(new Dimension(150,150));
		window.add(derecha,BorderLayout.WEST);
		
						
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1){
			AgregarPaciente agregar = new AgregarPaciente();
			agregar.pack();
			agregar.setVisible(true);
			
		}
		if(e.getSource() == boton2){
			TablaDatos tabla = new TablaDatos();
			tabla.pack();
			tabla.setVisible(true);
			
		}
        if(e.getSource() == boton3){
			BorrarPaciente borrar = new BorrarPaciente();
			borrar.pack();
			borrar.setVisible(true);
			
		}
        if(e.getSource() == boton4){
			Update update = new Update();
			update.pack();
			update.setVisible(true);
			
		}
		if(e.getSource() == boton5){
			JOptionPane.showMessageDialog(this, "Software creado para proporcionar a los empleados de un consultorio \n" +
					"médico la facilidad de manipular y llevar registro de todos sus\n pacientes.\n\n Desarrollador: Francisco Albear Cardenas.\n\n");
		}
		if(e.getSource() == salir){
			CRUD close = new CRUD();
			close.closesql();
			System.exit(0);
		}
		
	}

}
