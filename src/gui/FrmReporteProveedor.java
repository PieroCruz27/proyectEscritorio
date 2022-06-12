package gui;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;

public class FrmReporteProveedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblReporteProveedor;
	private JLabel lblNewLabel_1;
	private JTextField txtNombre;
	private JLabel lblNewLabel_2;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_3;
	private JTextField txtFecDesde;
	private JLabel lblNewLabel_4;
	private JTextField txtApellido;
	private JLabel lblNewLabel_5;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_6;
	private JTextField txtFecHasta;
	private JLabel lblNewLabel_7;
	private JTextField txtDni;
	private JComboBox cboPais;
	private JButton btnBuscar;
	private JPanel panelReporte;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;

	public FrmReporteProveedor() {
		getContentPane().setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Proveedor");
		setBounds(100, 100, 1048, 615);
		getContentPane().setLayout(null);
		
		lblReporteProveedor = new JLabel("Reporte Proveedor");
		lblReporteProveedor.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblReporteProveedor.setBounds(399, 11, 207, 37);
		getContentPane().add(lblReporteProveedor);
		
		lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(84, 107, 69, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(163, 104, 86, 20);
		getContentPane().add(txtNombre);
		
		lblNewLabel_2 = new JLabel("Direcci\u00F3n");
		lblNewLabel_2.setBounds(259, 107, 69, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(325, 104, 86, 20);
		getContentPane().add(txtDireccion);
		
		lblNewLabel_3 = new JLabel("Fecha de Inicio");
		lblNewLabel_3.setBounds(429, 107, 110, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtFecDesde = new JTextField();
		txtFecDesde.setColumns(10);
		txtFecDesde.setBounds(537, 104, 86, 20);
		getContentPane().add(txtFecDesde);
		
		lblNewLabel_4 = new JLabel("Apellidos");
		lblNewLabel_4.setBounds(84, 129, 69, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(163, 129, 86, 20);
		getContentPane().add(txtApellido);
		
		lblNewLabel_5 = new JLabel("Tel\u00E9fono");
		lblNewLabel_5.setBounds(259, 132, 59, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(325, 129, 86, 20);
		getContentPane().add(txtTelefono);
		
		lblNewLabel_6 = new JLabel("Fecha de Fin");
		lblNewLabel_6.setBounds(429, 135, 110, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtFecHasta = new JTextField();
		txtFecHasta.setColumns(10);
		txtFecHasta.setBounds(537, 132, 86, 20);
		getContentPane().add(txtFecHasta);
		
		lblNewLabel_7 = new JLabel("DNI");
		lblNewLabel_7.setBounds(84, 157, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(163, 157, 86, 20);
		getContentPane().add(txtDni);
		
		cboPais = new JComboBox();
		cboPais.setBounds(325, 153, 86, 22);
		getContentPane().add(cboPais);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(657, 157, 145, 31);
		getContentPane().add(btnBuscar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 206, 1012, 368);
		getContentPane().add(scrollPane);
		
		panelReporte = new JPanel();
		scrollPane.setViewportView(panelReporte);
		panelReporte.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "Reporte", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		
		lblNewLabel = new JLabel("Pa\u00EDs");
		lblNewLabel.setBounds(259, 157, 46, 14);
		getContentPane().add(lblNewLabel);

	}
}
