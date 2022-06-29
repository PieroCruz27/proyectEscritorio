package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmMailAutor dialog = new FrmMailAutor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmMailAutor() {
		setTitle("Enviar Reporte Autor  por Email");
		setBounds(100, 100, 450, 343);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblTitulo = new JLabel("Enviar Reporte Autor por Email");
			lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblTitulo.setBounds(117, 11, 221, 28);
			contentPanel.add(lblTitulo);
		}
		
		lblDestinario = new JLabel("Destinatario");
		lblDestinario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDestinario.setBounds(40, 67, 78, 15);
		contentPanel.add(lblDestinario);
		
		lblAsunto = new JLabel("Asunto");
		lblAsunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAsunto.setBounds(40, 99, 78, 15);
		contentPanel.add(lblAsunto);
		
		lblMensaje = new JLabel("Mensaje");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensaje.setBounds(40, 169, 78, 15);
		contentPanel.add(lblMensaje);
		
		txtCorreoDestino = new JTextField();
		txtCorreoDestino.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCorreoDestino.setBounds(128, 64, 233, 20);
		contentPanel.add(txtCorreoDestino);
		txtCorreoDestino.setColumns(10);
		
		txtAsunto = new JTextField();
		txtAsunto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsunto.setColumns(10);
		txtAsunto.setBounds(128, 96, 233, 20);
		contentPanel.add(txtAsunto);
		
		txtCuerpoMensaje = new JTextArea();
		txtCuerpoMensaje.setBounds(128, 165, 233, 85);
		contentPanel.add(txtCuerpoMensaje);
		
		lblClave = new JLabel("Clave");
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClave.setBounds(40, 136, 78, 15);
		contentPanel.add(lblClave);
		
		txtClave = new JPasswordField();
		txtClave.setBounds(128, 134, 159, 20);
		contentPanel.add(txtClave);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setBounds(249, 262, 89, 32);
		contentPanel.add(btnCancelar);
		
		btnEmail = new JButton("Enviar");
		btnEmail.addActionListener(this);
		btnEmail.setBounds(128, 261, 89, 32);
		contentPanel.add(btnEmail);
	}
	public void actionPerformed(ActionEvent e) {
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
	
	protected void actionPerformedBtnEmail(ActionEvent e) {
		String correoOrigen = "code.test.xd@gmail.com";
		String correoDestino = txtCorreoDestino.getText();
		String asunto = txtAsunto.getText();
		String clave = new String(txtClave.getPassword());
		String mensaje = txtCuerpoMensaje.getText();
		
		String archivo = "reportes/reporteAutor.pdf";
		
		
		
		Properties prpt = new Properties();
		prpt.put("mail.smtp.host", "smtp.gmail.com");
		prpt.setProperty("mail.smtp.starttls.enable","true");
		prpt.setProperty("mail.smtp.port","587");
		prpt.setProperty("mail.smtp.auth","true");
		
		Session sson = Session.getDefaultInstance(prpt);
		
		MimeMessage mssg = new MimeMessage(sson);
		
		
		try {
			mssg.setFrom(new InternetAddress(correoOrigen));
			mssg.addRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
			mssg.setSubject(asunto);
			
						
			MimeBodyPart adjunto = new MimeBodyPart();
	        MimeBodyPart texto = new MimeBodyPart();
	            
	         
	         File file = new File(archivo);
	         adjunto.attachFile(file);
	            
	         
	         texto.setText(mensaje);
	         Multipart mlpt = new MimeMultipart();
	         mlpt.addBodyPart(texto);
	         mlpt.addBodyPart(adjunto);
	          
	         mssg.setContent(mlpt);
	         
	         Transport trsp = sson.getTransport("smtp");
			 trsp.connect(correoOrigen, clave);
			 trsp.sendMessage(mssg, mssg.getRecipients(Message.RecipientType.TO));
			 trsp.close();
				
									
			JOptionPane.showMessageDialog(this,"Email enviado");
			
		} catch (AddressException e1) {
			e1.printStackTrace();
		} catch(MessagingException | IOException e2) {
			e2.printStackTrace();
		}
		
		
		limpiarCasillas();
	}
}
