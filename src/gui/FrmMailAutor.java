package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.AutorModel;
import util.Validaciones;

public class FrmMailAutor extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblDestinario;
	private JLabel lblAsunto;
	private JLabel lblMensaje;
	private JTextField txtCorreoDestino;
	private JTextField txtAsunto;
	private JTextArea txtCuerpoMensaje;
	private JLabel lblClave;
	private JPasswordField txtClave;
	private JButton btnCancelar;
	private JButton btnEmail;
	private JLabel lblOrigen;
	private JTextField txtCorreoOrigen;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		try {
			FrmMailAutor dialog = new FrmMailAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public FrmMailAutor() {
		setTitle("Enviar Reporte Autor  por Email");
		setBounds(100, 100, 456, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTitulo = new JLabel("Enviar Reporte Autor por Email");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTitulo.setBounds(117, 11, 264, 28);
			contentPanel.add(lblTitulo);
		}

		lblDestinario = new JLabel("Destinatario");
		lblDestinario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestinario.setBounds(40, 127, 78, 15);
		contentPanel.add(lblDestinario);

		lblAsunto = new JLabel("Asunto");
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAsunto.setBounds(40, 159, 78, 15);
		contentPanel.add(lblAsunto);

		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensaje.setBounds(40, 189, 78, 15);
		contentPanel.add(lblMensaje);

		txtCorreoDestino = new JTextField();
		txtCorreoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCorreoDestino.setBounds(128, 124, 233, 20);
		contentPanel.add(txtCorreoDestino);
		txtCorreoDestino.setColumns(10);

		txtAsunto = new JTextField();
		txtAsunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(128, 156, 233, 20);
		contentPanel.add(txtAsunto);

		txtCuerpoMensaje = new JTextArea();
		txtCuerpoMensaje.setBounds(128, 185, 233, 85);
		contentPanel.add(txtCuerpoMensaje);

		lblClave = new JLabel("Clave mail");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setBounds(40, 95, 89, 15);
		contentPanel.add(lblClave);

		txtClave = new JPasswordField();
		txtClave.setBounds(128, 93, 233, 20);
		contentPanel.add(txtClave);
		

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(249, 294, 89, 32);
		contentPanel.add(btnCancelar);

		btnEmail = new JButton("Enviar");
		btnEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEmail.addActionListener(this);
		btnEmail.setBounds(128, 293, 89, 32);
		contentPanel.add(btnEmail);
		
		lblOrigen = new JLabel("Usuario mail");
		lblOrigen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrigen.setBounds(40, 63, 89, 15);
		contentPanel.add(lblOrigen);
		
		txtCorreoOrigen = new JTextField();
		txtCorreoOrigen.setEditable(false);
		txtCorreoOrigen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCorreoOrigen.setColumns(10);
		txtCorreoOrigen.setBounds(128, 60, 233, 20);
		contentPanel.add(txtCorreoOrigen);
		txtCorreoOrigen.setText("jr.biblioteca.autor@gmail.com");
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnEmail) {
			actionPerformedBtnEmail(e);
		}
	}

	private void limpiarCasillas() {
		txtCorreoDestino.setText("");
		txtAsunto.setText("");
		txtClave.setText("");
		txtCuerpoMensaje.setText("");
		txtCorreoDestino.requestFocus();
	}

	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}

	protected void actionPerformedBtnEmail(ActionEvent e) {
		String correoOrigen = txtCorreoOrigen.getText();
		String clave = new String(txtClave.getPassword());
		String correoDestino = txtCorreoDestino.getText();
		String asunto = txtAsunto.getText();
		String mensaje = txtCuerpoMensaje.getText();

		if (!correoOrigen.matches(Validaciones.CORREO)) {
			mensaje("El dirección de origen debe tener formato de Email");
		} else if (!correoDestino.matches(Validaciones.CORREO)) {
			mensaje("La dirección del destinatario debe tener formato de Email");
		} else if (asunto.length() == 0) {
			mensaje("El asunto no puede estar vacío");
		} else if (clave.length() == 0) {
			mensaje("La contraseña no puede estar vacía");
		} else if (mensaje.length() == 0) {
			mensaje("El mensaje no puede estar vacío");
		} else {

			AutorModel mAutor = new AutorModel();
			
			String envio = mAutor.AutorMail(correoOrigen, correoDestino, asunto, mensaje, clave);

			if (envio.length() > 0) {
				JOptionPane.showMessageDialog(this, "Email enviado con reporte adjunto");
				limpiarCasillas();
			} else {
				JOptionPane.showMessageDialog(this, "Error al enviar");
				limpiarCasillas();
			}

		}
	}
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		dispose();
	}
}
