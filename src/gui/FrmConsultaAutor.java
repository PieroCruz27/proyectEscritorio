package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class FrmConsultaAutor extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtNombres;
	private JLabel lblApellido;
	private JTextField txtApellidos;
	private JTextField txtFechaNacimiento;
	private JLabel lblGrado;
	private JLabel lblPais;
	private JButton btnFiltrar;
	private JComboBox<String> cboPais;
	private JComboBox<String> cboGrado;
	private JScrollPane scrollPane;
	private JTable tblAutor;

	public FrmConsultaAutor() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Consulta Autor");
		setBounds(100, 100, 1000, 550);
		getContentPane().setLayout(null);
		
		lblTitulo = new JLabel("Consulta de Autor");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTitulo.setBounds(364, 28, 194, 25);
		getContentPane().add(lblTitulo);
		
		lblNombre = new JLabel("Nombres");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(38, 79, 105, 20);
		getContentPane().add(lblNombre);
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(495, 125, 160, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombres.setBounds(125, 78, 230, 22);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(412, 79, 117, 20);
		getContentPane().add(lblApellido);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(558, 78, 230, 22);
		getContentPane().add(txtApellidos);
		
		txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaNacimiento.setColumns(10);
		txtFechaNacimiento.setBounds(665, 124, 123, 22);
		getContentPane().add(txtFechaNacimiento);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrado.setBounds(269, 126, 61, 19);
		getContentPane().add(lblGrado);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPais.setBounds(38, 125, 61, 20);
		getContentPane().add(lblPais);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFiltrar.setBounds(814, 88, 132, 47);
		getContentPane().add(btnFiltrar);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Per\u00FA", "Chile", "Ecuador", "Colombia", "Argentina"}));
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboPais.setBounds(93, 123, 145, 25);
		getContentPane().add(cboPais);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "T\u00E9cnico", "Licenciado", "Doctor", "Autor"}));
		cboGrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGrado.setBounds(340, 123, 132, 25);
		getContentPane().add(cboGrado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 166, 908, 325);
		getContentPane().add(scrollPane);
		
		tblAutor = new JTable();
		tblAutor.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblAutor.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombres", "Apellidos", "Fecha de nacimiento", "Pa\u00EDs", "Grado"
			}
		));
		scrollPane.setViewportView(tblAutor);
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
}
