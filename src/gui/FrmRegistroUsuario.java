package gui;



import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import util.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;



public class FrmRegistroUsuario extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtUsuario;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtLogin;
	private JTextField txtPasword;
	private JTextField txtCorreo;
	private JTextField txtFecha;
	private JTextField txtNacimiento;
	private JTextField txtDireccion;
	private JButton btnRegistrar;
	private JComboBox<String> cboPais;

	public FrmRegistroUsuario() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Usuario");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id  Usuario");
		lblNewLabel.setBounds(65, 24, 73, 13);
		getContentPane().add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(168, 21, 96, 19);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(65, 68, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(168, 65, 96, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setBounds(65, 110, 73, 13);
		getContentPane().add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(168, 107, 96, 19);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(65, 154, 45, 13);
		getContentPane().add(lblNewLabel_3);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(168, 151, 96, 19);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setBounds(65, 202, 45, 13);
		getContentPane().add(lblNewLabel_4);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(168, 199, 96, 19);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(65, 256, 45, 13);
		getContentPane().add(lblNewLabel_5);
		
		txtPasword = new JTextField();
		txtPasword.setBounds(168, 253, 96, 19);
		getContentPane().add(txtPasword);
		txtPasword.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Correo");
		lblNewLabel_6.setBounds(65, 302, 45, 13);
		getContentPane().add(lblNewLabel_6);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(168, 299, 96, 19);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel(" FechaRegistro");
		lblNewLabel_7.setBounds(54, 345, 73, 13);
		getContentPane().add(lblNewLabel_7);
		
		txtFecha = new JTextField();
		txtFecha.setBounds(168, 342, 96, 19);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nacimiento");
		lblNewLabel_8.setBounds(65, 384, 55, 13);
		getContentPane().add(lblNewLabel_8);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setBounds(168, 381, 96, 19);
		getContentPane().add(txtNacimiento);
		txtNacimiento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Direccion");
		lblNewLabel_9.setBounds(65, 424, 55, 13);
		getContentPane().add(lblNewLabel_9);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(168, 421, 96, 19);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Pais");
		lblNewLabel_10.setBounds(65, 458, 45, 13);
		getContentPane().add(lblNewLabel_10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(378, 150, 108, 53);
		getContentPane().add(btnRegistrar);
		
		cboPais = new JComboBox<String>();
		cboPais.addItem("[Seleccione]");
		cboPais.addItem("[Chile]");
		cboPais.addItem("[Argentina]");
		cboPais.addItem("Colombia");
		cboPais.setBounds(168, 450, 113, 21);
		getContentPane().add(cboPais);
		
	
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String id= txtUsuario.getText().trim();
		String nom = txtNombre.getText().trim();
		String ape = txtApellidos.getText().trim();
		String dni = txtDNI.getText().trim();
		String log = txtLogin.getText().trim();
		String pas = txtPasword.getText().trim();
		String corr = txtCorreo.getText().trim();
		String fechReg = txtFecha.getText().trim();
		String fechNa = txtNacimiento.getText().trim();
		String direc = txtDireccion.getText().trim();
		

		if (!id.matches(Validaciones.ID)) {
			mensaje("complete bien el id");
		
		}else if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 3 a 30 caracteres ");
			
		}else if(!ape.matches(Validaciones.TEXTO)) {
			mensaje("El apellido es de 3 a 30 caracteres ");
			
		}else if(!dni.matches(Validaciones.DNI)) {
		mensaje("El dni es de 8 dígitos");
		
		}else if(!log.matches(Validaciones.LOGIN)) {
			mensaje("El login es de mas de 3 caracteres ");
		
		}else if(!pas.matches(Validaciones.PAS)) {
			mensaje("ingrese un pasword con mas de 5 caracter o digitos ");	
			
		}else if(!corr.matches(Validaciones.CORREO)) {
			mensaje("El correo esta incorrecto ");	
			
		}else if (!fechReg.matches(Validaciones.FECHAREGISTRO)) {

			mensaje("la fecha es yy-mm-dd");
			
		}else if (!fechNa.matches(Validaciones.FECHA)) {

			mensaje("la fecha es yy-mm-dd");
		}else if (!direc.matches(Validaciones.DIRECCION)) {

			mensaje("todos los datos son correctos");
		}
	}

	
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtDNI) {
			do_txtDNI_keyTyped(e);
		}
	}
	protected void do_txtDNI_keyTyped(KeyEvent e) {
		if (!Character.isDigit(e.getKeyChar())) {
			e.consume();
		}
		String textoQueVaGenerarse = txtDNI.getText().trim() + e.getKeyChar();
		if (textoQueVaGenerarse.length()>8) {
			e.consume();
		}
	}
}
 