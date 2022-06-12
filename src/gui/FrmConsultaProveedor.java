package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import entidad.Proveedor;
import model.ProveedorModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class FrmConsultaProveedor extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField txtNombre;
	private JLabel lblNewLabel_2;
	private JTextField txtApellido;
	private JLabel lblNewLabel_3;
	private JTextField txtDni;
	private JLabel lblNewLabel_4;
	private JTextField txtTelefono;
	private JLabel lblNewLabel_5;
	private JTextField txtDireccion;
	private JLabel lblNewLabel_6;
	private JComboBox cboPais;
	private JLabel lblNewLabel_7;
	private JTextField txtFecDesde;
	private JLabel lblNewLabel_8;
	private JTextField txtFecHasta;
	private JScrollPane scrollPane;
	private JTable tblConsulta;
	private JButton btnBuscar;
	private JLabel lblNewLabel_9;
	private JTextField txtCorreo;

	public FrmConsultaProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Proveedor");
		setBounds(100, 100, 1040, 550);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Consulta Proveedor");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNewLabel.setBounds(354, 22, 207, 37);
		getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nombres");
		lblNewLabel_1.setBounds(39, 118, 69, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(118, 115, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(39, 140, 69, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(118, 140, 86, 20);
		getContentPane().add(txtApellido);
		
		lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(39, 168, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(118, 168, 86, 20);
		getContentPane().add(txtDni);
		
		lblNewLabel_4 = new JLabel("Tel\u00E9fono");
		lblNewLabel_4.setBounds(214, 143, 59, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(283, 140, 118, 20);
		getContentPane().add(txtTelefono);
		
		lblNewLabel_5 = new JLabel("Direcci\u00F3n");
		lblNewLabel_5.setBounds(214, 118, 69, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(283, 115, 118, 20);
		getContentPane().add(txtDireccion);
		
		lblNewLabel_6 = new JLabel("Pa\u00EDs");
		lblNewLabel_6.setBounds(214, 168, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		cboPais = new JComboBox();
		cboPais.setModel(new DefaultComboBoxModel(new String[] {"", "Per\u00FA", "Chile", "Colombia", "Brazil"}));
		cboPais.setBounds(283, 164, 118, 22);
		getContentPane().add(cboPais);
		
		lblNewLabel_7 = new JLabel("Fecha de Inicio");
		lblNewLabel_7.setBounds(440, 121, 110, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtFecDesde = new JTextField();
		txtFecDesde.setColumns(10);
		txtFecDesde.setBounds(548, 118, 86, 20);
		getContentPane().add(txtFecDesde);
		
		lblNewLabel_8 = new JLabel("Fecha de Fin");
		lblNewLabel_8.setBounds(440, 149, 110, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtFecHasta = new JTextField();
		txtFecHasta.setColumns(10);
		txtFecHasta.setBounds(548, 146, 86, 20);
		getContentPane().add(txtFecHasta);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 210, 1004, 299);
		getContentPane().add(scrollPane);
		
		tblConsulta = new JTable();
		tblConsulta.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Proveedor", "Nombres", "Apellidos", "DNI", "Direcci\u00F3n", "Tel\u00E9fono", "Correo", "Pa\u00EDs", "Fecha Registro"
			}
		));
		tblConsulta.getColumnModel().getColumn(1).setPreferredWidth(110);
		tblConsulta.getColumnModel().getColumn(2).setPreferredWidth(110);
		tblConsulta.getColumnModel().getColumn(6).setPreferredWidth(100);
		tblConsulta.getColumnModel().getColumn(8).setPreferredWidth(88);
		scrollPane.setViewportView(tblConsulta);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(799, 168, 145, 31);
		getContentPane().add(btnBuscar);
		
		lblNewLabel_9 = new JLabel("Correo");
		lblNewLabel_9.setBounds(440, 174, 110, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(548, 171, 86, 20);
		getContentPane().add(txtCorreo);
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
	}
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		String nom=txtNombre.getText();
		String ape=txtApellido.getText();
		String dni=txtDni.getText();
		String dir=txtDireccion.getText();
		String tel=txtTelefono.getText();
		String cor=txtCorreo.getText();
		String pais=cboPais.getSelectedItem().toString();
		String fecIni=txtFecDesde.getText();
		String fecFin=txtFecHasta.getText();
		
		DefaultTableModel dtm=(DefaultTableModel)tblConsulta.getModel();
		dtm.setRowCount(0);
		ProveedorModel model= new ProveedorModel();
		List<Proveedor>lstProveedor = model.consultaValores(nom, ape, dni, dir, tel, cor, pais, fecIni, fecFin);
		Object[]fila = null;
		for(Proveedor x:lstProveedor) {
			fila=new Object[] {x.getIdProveedor(),x.getNombre(),x.getApellido(),x.getDni()
					,x.getDireccion(),x.getTelefono(),x.getCorreo(),x.getPais(),x.getFechaRegistro()};
			dtm.addRow(fila);
		}
		
	
	
	
	}
}
