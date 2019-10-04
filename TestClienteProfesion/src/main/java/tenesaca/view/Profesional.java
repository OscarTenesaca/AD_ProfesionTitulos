package tenesaca.view;

import java.awt.BorderLayout;
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

public class Profesional extends JFrame {

	private JPanel contentPane;
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profesional frame = new Profesional();
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
	public Profesional() {
		
		GestionProfesiones gp = new GestionProfesiones();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfesionales = new JLabel("Profesionales");
		lblProfesionales.setBounds(163, 6, 149, 32);
		contentPane.add(lblProfesionales);
		
		JLabel lblNewCedula = new JLabel("Nombre");
		lblNewCedula.setBounds(16, 93, 74, 23);
		contentPane.add(lblNewCedula);
		
		JLabel label = new JLabel("Cedula");
		label.setBounds(16, 58, 74, 23);
		contentPane.add(label);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(16, 126, 74, 23);
		contentPane.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(16, 161, 74, 23);
		contentPane.add(lblTelefono);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(103, 56, 130, 26);
		contentPane.add(txtCedula);
		txtCedula.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(102, 91, 130, 26);
		contentPane.add(txtNombre);
		
		txtDireccion = new JTextField();
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(102, 124, 130, 26);
		contentPane.add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(103, 159, 130, 26);
		contentPane.add(txtTelefono);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestionProfesiones gp = new GestionProfesiones();
				String auxCedula=txtCedula.getText();
				String auxNombre= txtNombre.getText();
				String auxDireccion= txtDireccion.getText();
				String auxTelefono= txtTelefono.getText();
				
				
				Respuestas respuesta = gp.saveProfesionales(auxCedula, auxNombre, auxDireccion, auxTelefono);
				System.out.println(respuesta);
				
				
				if(respuesta.getCodigo()==99) {
					System.out.println(respuesta);
					
					JOptionPane.showMessageDialog(null, "Se Guardo Correctamente!");					

					txtCedula.setText("");
					txtNombre.setText("");
					txtDireccion.setText("");
					txtTelefono.setText("");
					
					
				}if (respuesta.getCodigo()==1) {
					
					JOptionPane.showMessageDialog(null, "Error al Guardar","Alerta",JOptionPane.WARNING_MESSAGE);					System.out.println(respuesta);
					System.out.println(respuesta);

				}
				
				
//				
				
				
			}
		});
		btnGuardar.setBounds(131, 213, 117, 29);
		contentPane.add(btnGuardar);
		
		JButton btnListarProfesionales = new JButton("Listar Profesionales");
		btnListarProfesionales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaProfesionales lp = new ListaProfesionales();
				lp.setVisible(true);
				
			}
		});
		btnListarProfesionales.setBounds(302, 99, 142, 39);
		contentPane.add(btnListarProfesionales);
		
		JButton btnAgregarTitulos = new JButton("Agregar Titulos");
		btnAgregarTitulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TitulosVista t = new TitulosVista();
				t.setVisible(true);
				
			}
		});
		btnAgregarTitulos.setBounds(302, 51, 142, 39);
		contentPane.add(btnAgregarTitulos);
		
		JButton btnListarTituloPor = new JButton("Listar Titulos");
		btnListarTituloPor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TitulosProfesionales tp = new TitulosProfesionales();
				tp.setVisible(true);
			}
		});
		btnListarTituloPor.setBounds(302, 150, 142, 39);
		contentPane.add(btnListarTituloPor);
	}
}
