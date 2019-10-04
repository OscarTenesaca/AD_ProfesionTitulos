package tenesaca.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import tenesaca.modelo.Profecional;
import tenesaca.rest.GestionProfesiones;

import javax.swing.JScrollPane;

import javax.swing.JLabel;

public class ListaProfesionales extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaProfesionales frame = new ListaProfesionales();
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
	public ListaProfesionales() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListaDeProfesionales = new JLabel("Lista de Profesionales");
		lblListaDeProfesionales.setBounds(136, 6, 147, 24);
		contentPane.add(lblListaDeProfesionales);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Cedula", "Nombre", "Direccion", "Telefono "}));
		table.setBounds(6, 34, 438, 238);
		
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 387, 803, 238);
		scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(table);
		contentPane.add(scrollPane);
		
		
		GestionProfesiones gp = new GestionProfesiones();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int filas = 0;
		int cont = 0;
		
		List<Profecional> profesionales = gp.getProfecionales();
		
		for (Profecional p : profesionales) {
			
			model.addRow(new Object[filas]);	
			table.setValueAt(p.getCedula(), cont, 0);
			table.setValueAt(p.getNombre(), cont, 1);
			table.setValueAt(p.getDireccion(), cont, 2);
			table.setValueAt(p.getTelefono(), cont, 3);
			filas++;
			cont++;		
		}
		
		contentPane.add(table);

		
		//scrollPane.setViewportView(table);
		
		
	}
	
	
		
		

}
