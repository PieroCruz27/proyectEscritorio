package gui;

import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FrmReporteAutor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblPais;
	private JComboBox<String> cboPais;
	private JTextField txtNombres;
	private JLabel lblNombre;
	private JLabel lblGrado;
	private JLabel lblApellido;
	private JComboBox<String> cboGrado;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtApellidos;
	private JTextField txtFechaNacimiento;
	private JLabel lblReporteDeAutor;
	private JButton btnFiltrar;
	private JPanel panel;

	public FrmReporteAutor() {
		getContentPane().setForeground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPais.setBounds(69, 126, 61, 20);
		getContentPane().add(lblPais);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Per\u00FA", "Chile", "Ecuador", "Colombia", "Argentina"}));
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboPais.setBounds(122, 124, 165, 25);
		getContentPane().add(cboPais);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombres.setColumns(10);
		txtNombres.setBounds(169, 79, 248, 22);
		getContentPane().add(txtNombres);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(72, 80, 84, 20);
		getContentPane().add(lblNombre);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrado.setBounds(313, 127, 61, 19);
		getContentPane().add(lblGrado);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(500, 80, 90, 20);
		getContentPane().add(lblApellido);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "T\u00E9cnico", "Licenciado", "Doctor", "Autor"}));
		cboGrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGrado.setBounds(384, 124, 165, 25);
		getContentPane().add(cboGrado);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(581, 126, 160, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(626, 79, 248, 22);
		getContentPane().add(txtApellidos);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(751, 125, 123, 22);
		getContentPane().add(txtFechaNacimiento);
		
		lblReporteDeAutor = new JLabel("Reporte de Autor");
		lblReporteDeAutor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReporteDeAutor.setBounds(423, 26, 194, 25);
		getContentPane().add(lblReporteDeAutor);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFiltrar.setBounds(959, 85, 132, 47);
		getContentPane().add(btnFiltrar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reporte", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(69, 175, 1051, 317);
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Autor");
		setBounds(100, 100, 1200, 550);

	}
}
