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

import entidad.Autor;
import model.AutorModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FrmConsultaAutor extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblTitulo;
	private JLabel lblNombre;
	private JLabel lblFechaDeNacimiento;
	private JTextField txtNombres;
	private JLabel lblApellido;
	private JTextField txtApellidos;
	private JTextField txtFechaDesde;
	private JLabel lblGrado;
	private JLabel lblPais;
	private JButton btnFiltrar;
	private JComboBox<String> cboPais;
	private JComboBox<String> cboGrado;
	private JScrollPane scrollPane;
	private JTable tblAutor;
	private JLabel lblFechaNacimientoHasta;
	private JTextField txtFechaHasta;

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
		
		lblFechaDeNacimiento = new JLabel("Fecha de nacimiento desde");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaDeNacimiento.setBounds(252, 125, 215, 20);
		getContentPane().add(lblFechaDeNacimiento);
		
		txtNombres = new JTextField();
		txtNombres.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNombres.setBounds(125, 78, 150, 22);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		lblApellido = new JLabel("Apellidos");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(307, 79, 91, 20);
		getContentPane().add(lblApellido);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(408, 78, 150, 22);
		getContentPane().add(txtApellidos);
		
		txtFechaDesde = new JTextField();
		txtFechaDesde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaDesde.setColumns(10);
		txtFechaDesde.setBounds(465, 124, 123, 22);
		getContentPane().add(txtFechaDesde);
		
		lblGrado = new JLabel("Grado");
		lblGrado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGrado.setBounds(38, 126, 61, 19);
		getContentPane().add(lblGrado);
		
		lblPais = new JLabel("Pa\u00EDs");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPais.setBounds(587, 79, 61, 20);
		getContentPane().add(lblPais);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFiltrar.setBounds(814, 66, 132, 47);
		getContentPane().add(btnFiltrar);
		
		cboPais = new JComboBox<String>();
		cboPais.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "Per\u00FA", "Chile", "Ecuador", "Colombia", "Argentina"}));
		cboPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboPais.setBounds(658, 74, 145, 25);
		getContentPane().add(cboPais);
		
		cboGrado = new JComboBox<String>();
		cboGrado.setModel(new DefaultComboBoxModel<String>(new String[] {"[Seleccione]", "T\u00E9cnico", "Licenciado", "Doctor", "Autor"}));
		cboGrado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cboGrado.setBounds(97, 123, 132, 25);
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
		
		lblFechaNacimientoHasta = new JLabel("Fecha de nacimiento hasta");
		lblFechaNacimientoHasta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFechaNacimientoHasta.setBounds(609, 125, 204, 20);
		getContentPane().add(lblFechaNacimientoHasta);
		
		txtFechaHasta = new JTextField();
		txtFechaHasta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFechaHasta.setColumns(10);
		txtFechaHasta.setBounds(823, 124, 123, 22);
		getContentPane().add(txtFechaHasta);
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(e);
		}
	}
	protected void actionPerformedBtnFiltrar(ActionEvent e) {
		String nombres = txtNombres.getText();
		String apellidos = txtApellidos.getText();
		String fechaDesde = txtFechaDesde.getText();
		String fechaHasta = txtFechaHasta.getText();
		
		AutorModel mAutor = new AutorModel();
		List<Autor> listAutor = mAutor.ConsultaReporteAutor(nombres, apellidos, fechaDesde, fechaHasta);
		
		DefaultTableModel dt = (DefaultTableModel) tblAutor.getModel();
		dt.setRowCount(0);
		Object[] fila = null;
		for(Autor autor: listAutor) {
			fila = new Object[] {
				autor.getIdAutor(), autor.getNombres(), autor.getApellidos(), autor.getFechaNacimiento(), autor.getPais(), autor.getGrado() 	
			};
			dt.addRow(fila);
						
		}
	}
}
