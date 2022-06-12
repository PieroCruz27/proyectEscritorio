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
	private JTextField txtFechaDesde;
	private JLabel lblReporteDeAutor;
	private JButton btnFiltrar;
	private JPanel panel;
	private JLabel lblFechaNacimientoHasta;
	private JTextField txtFechaHasta;

	public FrmReporteAutor() {
		getContentPane().setForeground(SystemColor.activeCaption);
		getContentPane().setLayout(null);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPais.setBounds(622, 78, 61, 20);
		getContentPane().add(lblPais);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Per\u00FA", "Chile", "Ecuador", "Colombia", "Argentina"}));
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboPais.setBounds(675, 76, 165, 25);
		getContentPane().add(cboPais);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombres.setColumns(10);
		txtNombres.setBounds(156, 78, 150, 22);
		getContentPane().add(txtNombres);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(72, 80, 84, 20);
		getContentPane().add(lblNombre);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrado.setBounds(867, 76, 61, 19);
		getContentPane().add(lblGrado);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(362, 80, 90, 20);
		getContentPane().add(lblApellido);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "T\u00E9cnico", "Licenciado", "Doctor", "Autor"}));
		cboGrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGrado.setBounds(938, 73, 165, 25);
		getContentPane().add(cboGrado);
		
		lblFechaDeNacimiento = new JLabel("Fecha de  nacimiento desde");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(72, 126, 209, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(450, 79, 150, 22);
		getContentPane().add(txtApellidos);
		
		txtFechaDesde = new JTextField();
		txtFechaDesde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaDesde.setColumns(10);
		txtFechaDesde.setBounds(299, 125, 123, 22);
		getContentPane().add(txtFechaDesde);
		
		lblReporteDeAutor = new JLabel("Reporte de Autor");
		lblReporteDeAutor.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReporteDeAutor.setBounds(423, 26, 194, 25);
		getContentPane().add(lblReporteDeAutor);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFiltrar.setBounds(906, 117, 132, 38);
		getContentPane().add(btnFiltrar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Reporte", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		panel.setBounds(69, 175, 1051, 317);
		getContentPane().add(panel);
		
		lblFechaNacimientoHasta = new JLabel("Fecha de nacimiento hasta");
		lblFechaNacimientoHasta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaNacimientoHasta.setBounds(467, 126, 205, 20);
		getContentPane().add(lblFechaNacimientoHasta);
		
		txtFechaHasta = new JTextField();
		txtFechaHasta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaHasta.setColumns(10);
		txtFechaHasta.setBounds(700, 125, 123, 22);
		getContentPane().add(txtFechaHasta);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Autor");
		setBounds(100, 100, 1200, 550);

	}
}
