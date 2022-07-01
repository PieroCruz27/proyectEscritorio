package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import entidad.Libro;
import model.LibroModel;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;
import util.GeneradorReporte;
import util.Validaciones;

public class FrmReporteLibro extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtAnioInicio;
	private JTextField txtAnioFinal;
	private JButton btnGraficos;
	private JPanel panelReporte;

	public FrmReporteLibro() {
		getContentPane().setBackground(Color.CYAN);
		getContentPane().setForeground(SystemColor.activeCaption);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		setTitle("Reporte de Libro");
		setBounds(100, 100, 1200, 550);
		getContentPane().setLayout(null);
		
		btnGraficos = new JButton("FiltrarGraficos");
		btnGraficos.addActionListener(this);
		btnGraficos.setFont(new Font("Arial Black", Font.ITALIC, 24));
		btnGraficos.setBounds(864, 116, 236, 59);
		getContentPane().add(btnGraficos);
		
		JLabel lblAoInicio = new JLabel("Año inicio");
		lblAoInicio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAoInicio.setBounds(100, 122, 91, 20);
		getContentPane().add(lblAoInicio);
		
		txtAnioInicio = new JTextField();
		txtAnioInicio.setColumns(10);
		txtAnioInicio.setBounds(219, 123, 149, 20);
		getContentPane().add(txtAnioInicio);
		
		JLabel lblAoFinal = new JLabel("Año final");
		lblAoFinal.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblAoFinal.setBounds(490, 125, 85, 14);
		getContentPane().add(lblAoFinal);
		
		txtAnioFinal = new JTextField();
		txtAnioFinal.setColumns(10);
		txtAnioFinal.setBounds(585, 123, 149, 20);
		getContentPane().add(txtAnioFinal);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reportes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(26, 185, 1099, 311);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout());
		
		JLabel lblReportesPorAo = new JLabel("Reportes por a\u00F1o de Libro");
		lblReportesPorAo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblReportesPorAo.setBounds(416, 36, 462, 34);
		getContentPane().add(lblReportesPorAo);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGraficos) {
			actionPerformedBtnGraficosJButton(e);
		}
	}
	//boton
	protected void actionPerformedBtnGraficosJButton(ActionEvent e) {
		String Finicio = txtAnioInicio.getText().trim();
		String Ffin = txtAnioFinal.getText().trim();
		
		if (!Finicio.matches(Validaciones.ANNO)) {
			mensaje("El año es YYYY");
		}else if (!Ffin.matches(Validaciones.ANNO)) {
			mensaje("El año es YYYY");
		}else if ( Integer.parseInt(Finicio) > Integer.parseInt(Ffin) ) {
			mensaje("El año inicio tiene que ser menor");
		}else {
			int anioInicio = Integer.parseInt(Finicio);
			int anioFin = Integer.parseInt(Ffin);
			
			LibroModel model = new LibroModel();
			ArrayList<Libro> lista = model.reporteXAño(anioInicio, anioFin);
			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);
			String jasper = "reporteAño.jasper";		
			JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);	
			JRViewer jRViewer = new JRViewer(print);
			
			panelReporte.removeAll();
			panelReporte.add(jRViewer);
			panelReporte.repaint();
			panelReporte.revalidate();
		}
	}
	
	void mensaje(String me) {
		JOptionPane.showMessageDialog(this, me);
	}
}

