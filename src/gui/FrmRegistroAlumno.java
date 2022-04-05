package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmRegistroAlumno extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmRegistroAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Alumno");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
	}
}
