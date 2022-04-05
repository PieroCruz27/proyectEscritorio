package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmRegistroAutor extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmRegistroAutor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Autor");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
	}
}
