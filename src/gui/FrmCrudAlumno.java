package gui;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import entidad.Alumno;
import model.AlumnoModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.MouseMotionListener;

public class FrmCrudAlumno extends JInternalFrame implements ActionListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblDni;
	private JLabel lblCorreo;
	private JLabel lblFechaDeNac;
	private JLabel lblPas;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtDNI;
	private JTextField txtCorreo;
	private JTextField txtFecha;
	private JComboBox<String> cboPais;
	private JButton btnAdd;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JScrollPane scrollPane;
	private JTable table;
	private JPanel panel;

	public FrmCrudAlumno() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Mantenimiento de Alumno");
		setBounds(100, 100, 900, 625);
		getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Mantenimiento Alumno");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 30));
		lblNewLabel.setBounds(254, 10, 364, 37);
		getContentPane().add(lblNewLabel);
		
		lblNombres = new JLabel("Nombres:");
		lblNombres.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNombres.setBounds(28, 77, 104, 13);
		getContentPane().add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 12));
		lblApellidos.setBounds(28, 124, 104, 13);
		getContentPane().add(lblApellidos);
		
		lblDni = new JLabel("DNI:");
		lblDni.setFont(new Font("Dialog", Font.BOLD, 12));
		lblDni.setBounds(28, 182, 104, 13);
		getContentPane().add(lblDni);
		
		lblCorreo = new JLabel("Correo:");
		lblCorreo.setFont(new Font("Dialog", Font.BOLD, 12));
		lblCorreo.setBounds(471, 77, 115, 13);
		getContentPane().add(lblCorreo);
		
		lblFechaDeNac = new JLabel("Fecha de nac. :");
		lblFechaDeNac.setFont(new Font("Dialog", Font.BOLD, 12));
		lblFechaDeNac.setBounds(471, 124, 115, 13);
		getContentPane().add(lblFechaDeNac);
		
		lblPas = new JLabel("Pa\u00EDs:");
		lblPas.setFont(new Font("Dialog", Font.BOLD, 12));
		lblPas.setBounds(471, 182, 115, 13);
		getContentPane().add(lblPas);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(151, 75, 292, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(151, 122, 292, 19);
		getContentPane().add(txtApellido);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(151, 180, 115, 19);
		getContentPane().add(txtDNI);
		
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(596, 75, 259, 19);
		getContentPane().add(txtCorreo);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(596, 122, 124, 19);
		getContentPane().add(txtFecha);
		
		cboPais = new JComboBox<String>();
		cboPais.addItem("Seleccione:");
		cboPais.addItem("Perú");
		cboPais.addItem("Chile");
		cboPais.addItem("Ecuador");
		cboPais.addItem("Colombia");
		cboPais.addItem("Venezuela");
		cboPais.setBounds(599, 179, 121, 21);
		getContentPane().add(cboPais);
		
		btnAdd = new JButton("A\u00F1adir");
		btnAdd.addActionListener(this);
		btnAdd.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAdd.setBounds(117, 234, 149, 32);
		getContentPane().add(btnAdd);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnModificar.setBounds(373, 234, 149, 32);
		getContentPane().add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addMouseListener(this);
		btnEliminar.addActionListener(this);
		btnEliminar.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnEliminar.setBounds(627, 234, 149, 32);
		getContentPane().add(btnEliminar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 285, 827, 290);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseMotionListener(this);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Nombres", "Apellidos", "DNI", "Correo", "Fecha Nac.", "Pa\u00EDs", "Fecha Act."
			}
		));
		table.setSurrendersFocusOnKeystroke(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(99, 10, 677, 37);
		getContentPane().add(panel);
		
		lista();

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnAdd) {
			actionPerformedBtnAdd(e);
		}
	}
	protected void actionPerformedBtnAdd(ActionEvent e) {
		agrega();
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		modifica();
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		elimina();
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == table) {
			mouseClickedTable(e);
		}
		if (e.getSource() == btnEliminar) {
			mouseClickedBtnEliminar(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedBtnEliminar(MouseEvent e) {
	}
	
	private void lista() {
		AlumnoModel almd = new AlumnoModel();
		List<Alumno> lista = almd.listaAlumno();
		
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		Object[] fila = null;
		for (Alumno x : lista) {
			fila = new Object[] {x.getIdAlumno(), x.getNombre(), x.getApellido(), x.getDni(), x.getCorreo(), x.getFechanac(), x.getPais(), x.getFechareg()};
			dtm.addRow(fila);
			}
		}
			
			
	private void agrega() {}
	private void elimina() {}
	private void modifica() {}
	private void busca() {}
	protected void mouseClickedTable(MouseEvent e) {
		busca();
	}
	public void mouseDragged(MouseEvent e) {
		if (e.getSource() == table) {
			mouseDraggedTable(e);
		}
	}
	public void mouseMoved(MouseEvent e) {
	}
	protected void mouseDraggedTable(MouseEvent e) {
	}
}
