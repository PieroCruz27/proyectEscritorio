package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmRegistroProveedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmRegistroProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Proveedor");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
	}
}
