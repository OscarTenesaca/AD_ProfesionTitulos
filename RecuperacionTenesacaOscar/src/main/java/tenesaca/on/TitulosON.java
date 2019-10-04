package tenesaca.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import tenesaca.dao.TitulosDAO;
import tenesaca.modelo.Profecional;
import tenesaca.modelo.Titulos;

@Stateless
public class TitulosON {
	
	
	@Inject
	private TitulosDAO tDAO;
	
	public void createProfesional(Profecional p) {
		tDAO.insertarProfecional(p);
		
	}
	
	
	public void createTitulos(Titulos t) {
		tDAO.insertarTitulos(t);
		
	}
	
	
	public boolean insertarTitulo(String cedula,String nombre,String codRegistro, String fechaObtenido ) {
		boolean estado;
		
		Profecional c = tDAO.readProfecional(cedula);
		Titulos t = new Titulos();
		
		t.setNombre(nombre);
		t.setCodRegistro(codRegistro);
		t.setFechaObtenido(fechaObtenido);
		t.setProfesional(c);
		
		tDAO.insertarTitulos(t);
		estado = true;
		
		try {
			
			
		}catch (Exception e) {
			estado = false;
			e.printStackTrace();
		
		}
		return estado;
		
	} 
	
	
	public List<Profecional> getProfesionales(){
		return tDAO.getProfecionales();
		
	}
	

	public List<Titulos> getTitulos(String cedula){
			System.out.println("llegoon");	
		return tDAO.getTitulos(cedula);
		
	}
	
	public List<Titulos> getTodosTitulosON(){
		
		return tDAO.getTodosTitulos();
	}
	
	
	

}
