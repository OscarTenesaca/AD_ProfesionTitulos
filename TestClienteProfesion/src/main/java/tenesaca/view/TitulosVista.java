package tenesaca.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tenesaca.modelo.Respuestas;
import tenesaca.rest.GestionProfesiones;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TitulosVista extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtTitulo;
	private JTextField txtCodRegistro;
	private JTextField txtFechaObtenido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitulosVista frame = new TitulosVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TitulosVista() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulos = new JLabel("Titulos");
		lblTitulos.setBounds(181, 6, 61, 16);
		contentPane.add(lblTitulos);
		
		JLabel lblNewLabel = new JLabel("Cedula");
		lblNewLabel.setBounds(50, 53, 73, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(50, 88, 73, 23);
		contentPane.add(lblTitulo);
		
		JLabel lblCodigoRegistro = new JLabel("Codigo Registro");
		lblCodigoRegistro.setBounds(50, 123, 114, 23);
		contentPane.add(lblCodigoRegistro);
		
		JLabel lblFechaObtenida = new JLabel("Fecha Obtenida");
		lblFechaObtenida.setBounds(50, 162, 114, 23);
		contentPane.add(lblFechaObtenida);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(168, 51, 130, 26);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtTitulo = new JTextField();
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(168, 86, 130, 26);
		contentPane.add(txtTitulo);
		
		txtCodRegistro = new JTextField();
		txtCodRegistro.setColumns(10);
		txtCodRegistro.setBounds(168, 121, 130, 26);
		contentPane.add(txtCodRegistro);
		
		txtFechaObtenido = new JTextField();
		txtFechaObtenido.setColumns(10);
		txtFechaObtenido.setBounds(168, 160, 130, 26);
		contentPane.add(txtFechaObtenido);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String auxCedula= txtCedula.getText();
				String auxTitulo= txtTitulo.getText();
				String auxcod = txtCodRegistro.getText();
				String auxfechaO= txtFechaObtenido.getText();
				
				GestionProfesiones gp = new GestionProfesiones();
				
				Respuestas respuestas = gp.saveTitulos(auxCedula, auxTitulo, auxcod, auxfechaO);
				
				
				if(respuestas.getCodigo()==99) {
					System.out.println(respuestas);
					
					JOptionPane.showMessageDialog(null, "Se Guardo Correctamente!");					
					
					txtCedula.setText("");
					txtTitulo.setText("");
					txtCodRegistro.setText("");
					txtFechaObtenido.setText("");
					
					
				}if (respuestas.getCodigo()==1) {
					
					JOptionPane.showMessageDialog(null, "Error al Guardar","Alerta",JOptionPane.WARNING_MESSAGE);					
					System.out.println(respuestas);
					
				}
				
				
//				
//				
			}
		});
		btnGuardar.setBounds(162, 212, 122, 37);
		contentPane.add(btnGuardar);
	}

}
