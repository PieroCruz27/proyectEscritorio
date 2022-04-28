package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmRegistroProveedor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblNombres;
	private JTextField txtNombres;
	private JLabel lblApellidos;
	private JTextField txtApellidos;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblDireccion;
	private JTextField txtDireccion;
	private JLabel lblTelefono;
	private JTextField txtTelefono;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JLabel lblPais;
	private JTextField txtPais;
	private JButton btnNewButton;
	private JButton btnLimpiar;

	public FrmRegistroProveedor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Proveedor");
		setBounds(100, 100, 362, 436);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Registro de Proveedor");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTitulo.setBounds(86, 11, 194, 35);
		getContentPane().add(lblTitulo);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(49, 110, 46, 14);
		getContentPane().add(lblNombres);
		
		txtNombres = new JTextField();
		txtNombres.setColumns(10);
		txtNombres.setBounds(132, 107, 86, 20);
		getContentPane().add(txtNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(49, 138, 46, 14);
		getContentPane().add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(132, 135, 86, 20);
		getContentPane().add(txtApellidos);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(49, 166, 46, 14);
		getContentPane().add(lblDni);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(132, 163, 86, 20);
		getContentPane().add(txtDni);
		
		lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(49, 194, 46, 14);
		getContentPane().add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(132, 191, 86, 20);
		getContentPane().add(txtDireccion);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(49, 222, 46, 14);
		getContentPane().add(lblTelefono);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(132, 219, 86, 20);
		getContentPane().add(txtTelefono);
		
		lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(49, 250, 46, 14);
		getContentPane().add(lblCorreo);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(132, 247, 86, 20);
		getContentPane().add(txtCorreo);
		
		lblPais = new JLabel("Pais");
		lblPais.setBounds(49, 278, 46, 14);
		getContentPane().add(lblPais);
		
		txtPais = new JTextField();
		txtPais.setColumns(10);
		txtPais.setBounds(132, 275, 86, 20);
		getContentPane().add(txtPais);
		
		btnNewButton = new JButton("Enviar");
		btnNewButton.setBounds(129, 306, 89, 23);
		getContentPane().add(btnNewButton);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBounds(129, 340, 89, 23);
		getContentPane().add(btnLimpiar);
	}
}
