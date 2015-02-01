package cons;

public class Principal{

	public static void main(String[] args) {
		Pantalla1 consultorio = new Pantalla1();
		consultorio.setBounds(20, 20, 1000, 2000);
		consultorio.setSize(500, 500);
		consultorio.setResizable(true);
		consultorio.pack();
		consultorio.setVisible(true);
		consultorio.setTitle("Consultorio medico");

	}


}
