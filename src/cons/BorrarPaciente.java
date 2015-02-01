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

public class BorrarPaciente extends JFrame implements ActionListener{
	private JTextField nombre,apellidop,apellidom;
	private JLabel encabezado,namelabel,aplabel,amlabel;
	private JButton borrar;
	private JPanel centro,superior,inferior,izquierda,derecha;
	
	public BorrarPaciente(){
		
		nombre = new JTextField();
		apellidop = new JTextField();
		apellidom = new JTextField();
		
		borrar = new JButton("Borrar");
		borrar.addActionListener(this);
		
		encabezado = new JLabel("Elimina un paciente de la base de datos:");
		namelabel = new JLabel("Nombre:");
		aplabel = new JLabel("Apellido paterno:");
		amlabel = new JLabel("Apellido materno:");
		
		Container window = getContentPane();
		window.setLayout(new BorderLayout());
		
		centro = new JPanel();
		centro.setLayout(new BoxLayout(centro,BoxLayout.Y_AXIS));
		centro.setPreferredSize(new Dimension(300,200));
		centro.add(namelabel);
		centro.add(nombre);
		centro.add(aplabel);
		centro.add(apellidop);
		centro.add(amlabel);
		centro.add(apellidom);
		window.add(centro,BorderLayout.CENTER);
		
		superior = new JPanel();
		superior.setLayout(new FlowLayout());
		superior.setPreferredSize(new Dimension(150,150));
		superior.add(encabezado);
		window.add(superior,BorderLayout.NORTH);
		
		inferior = new JPanel();
		inferior.setLayout(new FlowLayout());
		inferior.setPreferredSize(new Dimension(150,150));
		inferior.add(borrar);
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
	public void actionPerformed(ActionEvent arg0) {
		
		String name = nombre.getText();
		String appat = apellidop.getText();
		String apmat = apellidom.getText();
		
		CRUD crud = new CRUD(name,appat,apmat);
		int eliminar = crud.eliminar();
		
		if(eliminar == 1){
			JOptionPane.showMessageDialog(this, "Paciente eliminado correctamente");
		}
		else{
			JOptionPane.showMessageDialog(this, "Error al eliminar el paciente");
		}
		
	}
	

}
