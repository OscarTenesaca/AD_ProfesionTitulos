package tenesaca.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import tenesaca.modelo.Profecional;
import tenesaca.modelo.Titulos;
import tenesaca.rest.GestionProfesiones;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TitulosProfesionales extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitulosProfesionales frame = new TitulosProfesionales();
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
	public TitulosProfesionales() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProfesionalesYSus = new JLabel("Profesionales y sus Titulos");
		lblProfesionalesYSus.setBounds(106, 6, 206, 16);
		contentPane.add(lblProfesionalesYSus);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(6, 39, 61, 16);
		contentPane.add(lblCedula);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Titulo", "Codigo Registro", "Fecha Obtenida"}));
		table.setBounds(6, 72, 438, 200);
		contentPane.add(table);
		
		
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(58, 34, 130, 26);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String auxcedula= txtBuscar.getText();
				System.out.println(auxcedula);
				
				GestionProfesiones gp = new GestionProfesiones();
					
					List<Titulos> titulos= gp.getTitulosProfesionales(auxcedula);
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					int filas = 0;
					int cont = 0;
					
					for (Titulos t: titulos) {
						model.addRow(new Object[filas]);
						table.setValueAt(t.getNombre(), cont, 0);
						table.setValueAt(t.getCodigoRegistro(), cont, 1);
						table.setValueAt(t.getFechaRegistro(), cont, 2);
						filas++;
						cont++;	
						
						
					}	
					
				}
		});
		btnBuscar.setBounds(195, 34, 117, 29);
		contentPane.add(btnBuscar);
		
	
		
		
		
		
		
		
		
	}
}
