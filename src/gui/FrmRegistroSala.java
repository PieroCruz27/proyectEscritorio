package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmRegistroSala extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmRegistroSala() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Sala");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
	}
}
