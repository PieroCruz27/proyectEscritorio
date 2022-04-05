package gui;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class FrmReporteProveedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	public FrmReporteProveedor() {
		getContentPane().setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Proveedor");
		setBounds(100, 100, 1200, 550);
		getContentPane().setLayout(null);

	}
}
