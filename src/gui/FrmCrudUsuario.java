package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmCrudUsuario extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmCrudUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Usuario");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);

	}

}
