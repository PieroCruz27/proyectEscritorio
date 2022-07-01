package gui;



import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import entidad.Usuario;
import model.UsuarioModel;
import util.Conversiones;
import util.Validaciones;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Font;



public class FrmRegistroUsuario extends JInternalFrame implements ActionListener, KeyListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtDNI;
	private JTextField txtLogin;
	private JTextField txtPasword;
	private JTextField txtCorreo;
	private JTextField txtNacimiento;
	private JTextField txtDireccion;
	private JButton btnRegistrar;
	private JComboBox<String> cboPais;

	public FrmRegistroUsuario() {
		getContentPane().setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		getContentPane().setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Ingreso de Usuario");
		setBounds(100, 100, 900, 550);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(37, 65, 121, 13);
		getContentPane().add(lblNewLabel_1);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(168, 65, 96, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apellidos");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(37, 107, 121, 13);
		getContentPane().add(lblNewLabel_2);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(168, 107, 96, 19);
		getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBounds(37, 151, 121, 13);
		getContentPane().add(lblNewLabel_3);
		
		txtDNI = new JTextField();
		txtDNI.addKeyListener(this);
		txtDNI.setBounds(168, 151, 96, 19);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Login");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(37, 199, 121, 13);
		getContentPane().add(lblNewLabel_4);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(168, 199, 96, 19);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setBounds(37, 253, 121, 13);
		getContentPane().add(lblNewLabel_5);
		
		txtPasword = new JTextField();
		txtPasword.setBounds(168, 253, 96, 19);
		getContentPane().add(txtPasword);
		txtPasword.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Correo");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_6.setBounds(37, 299, 121, 13);
		getContentPane().add(lblNewLabel_6);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(168, 299, 96, 19);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("FechaNacimiento");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_8.setBounds(37, 345, 121, 13);
		getContentPane().add(lblNewLabel_8);
		
		txtNacimiento = new JTextField();
		txtNacimiento.setBounds(168, 345, 96, 19);
		getContentPane().add(txtNacimiento);
		txtNacimiento.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Dirección");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_9.setBounds(37, 394, 121, 13);
		getContentPane().add(lblNewLabel_9);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(168, 394, 96, 19);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("País");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_10.setBounds(37, 433, 121, 13);
		getContentPane().add(lblNewLabel_10);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRegistrar.setBackground(Color.LIGHT_GRAY);
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(432, 162, 158, 53);
		getContentPane().add(btnRegistrar);
		
		cboPais = new JComboBox<String>();
		cboPais.addItem("[Seleccione]");
		cboPais.addItem("Perú");
		cboPais.addItem("Chile");
		cboPais.addItem("Argentina");
		cboPais.addItem("Colombia");
		cboPais.setBounds(168, 432, 113, 21);
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
		String nom = txtNombre.getText().trim();
		String ape = txtApellidos.getText().trim();
		String dni = txtDNI.getText().trim();
		String log = txtLogin.getText().trim();
		String pas = txtPasword.getText().trim();
		String corr = txtCorreo.getText().trim();
		String fechNa = txtNacimiento.getText().trim();
		String direc = txtDireccion.getText().trim();
		String pais = cboPais.getSelectedItem().toString();
		
		//validaciones
		if(!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre es de 3 a 30 caracteres ");
			
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
			
		}else if (!fechNa.matches(Validaciones.FECHA)) {

			mensaje("la fecha es yy-mm-dd");
		}else if (!direc.matches(Validaciones.DIRECCION)) {

			mensaje("complete bien la direccion");
		}else if (cboPais.getSelectedIndex() ==0) {

			mensaje("selecione el pais");
			
		}else {
			
			Usuario obj = new Usuario();
			obj.setNombre(nom);
			obj.setApellido(ape);
			obj.setDni(dni);
			obj.setLogin(log);
			obj.setPassword(pas);
			obj.setCorreo(corr);
			obj.setFechaNacimiento(Conversiones.toFecha(fechNa));
			obj.setDireccion(direc);
			obj.setPais(pais);
			//pasando el model
			UsuarioModel model = new UsuarioModel();
			int salida = model.insertaUsuario(obj);
			if(salida > 0 ) {
				mensaje("Registro exitoso");
			}else {
				mensaje("Error en el registro");
			}
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
 