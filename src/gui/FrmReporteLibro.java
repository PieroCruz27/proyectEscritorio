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
		btnGraficos.setBounds(355, 119, 236, 59);
		getContentPane().add(btnGraficos);
		
		JLabel lblAoInicio = new JLabel("Año inicio");
		lblAoInicio.setBounds(140, 38, 91, 20);
		getContentPane().add(lblAoInicio);
		
		txtAnioInicio = new JTextField();
		txtAnioInicio.setColumns(10);
		txtAnioInicio.setBounds(238, 39, 149, 20);
		getContentPane().add(txtAnioInicio);
		
		JLabel lblAoFinal = new JLabel("Año final");
		lblAoFinal.setBounds(484, 42, 85, 14);
		getContentPane().add(lblAoFinal);
		
		txtAnioFinal = new JTextField();
		txtAnioFinal.setColumns(10);
		txtAnioFinal.setBounds(593, 39, 149, 20);
		getContentPane().add(txtAnioFinal);
		
		panelReporte = new JPanel();
		panelReporte.setBorder(new TitledBorder(null, "Reportes", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelReporte.setBounds(26, 237, 1099, 259);
		getContentPane().add(panelReporte);
		panelReporte.setLayout(new BorderLayout());

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
			mensaje("El año inicio tiene forma YYYY");
		}else if (!Ffin.matches(Validaciones.ANNO)) {
			mensaje("El año fin tiene forma YYYY");
		}else if ( Integer.parseInt(Finicio) > Integer.parseInt(Ffin) ) {
			mensaje("El año inicio es menor que el año fin");
		}else {
		
			LibroModel model = new LibroModel();
			ArrayList<Libro> lista = model.reporteXAño(Integer.parseInt(Finicio), Integer.parseInt(Ffin));
			
			JRBeanCollectionDataSource dataSource = new  JRBeanCollectionDataSource(lista);
			
			String jasper = "reporteGraficoAño.jasper";
			
			JasperPrint print = GeneradorReporte.genera(jasper, dataSource, null);
			
			JRViewer JRViewer = new JRViewer(print);
			
			panelReporte.removeAll();
			panelReporte.add(JRViewer);
			panelReporte.repaint();
			panelReporte.revalidate();
		}
	}
		void mensaje(String me) {
			JOptionPane.showMessageDialog(this, me);
}
	}
