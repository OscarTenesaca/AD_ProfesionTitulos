package tenesaca.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;


import tenesaca.modelo.ListProfesionalNom;
import tenesaca.modelo.Profecional;
import tenesaca.modelo.Respuestas;
import tenesaca.modelo.Titulos;
import tenesaca.on.TitulosON;


@WebService
public class ProfesionalServiceSOAP {

	
	
	@Inject
	private TitulosON tON;
	
	
	@WebMethod
	public Respuestas insertar (Profecional profesional) {
		Respuestas r = new Respuestas();
		
		
		try {
			
			r.setCodigo(99);
			r.setMensaje("OK");
			tON.createProfesional(profesional);
			
		} catch (Exception e) {
			r.setCodigo(1);
			r.setMensaje("error");
			e.printStackTrace();
			
			
		}

		return r;

	}
	
	@WebMethod
	public Respuestas insertarTitulo(String cedula, String nombre, String codRegistro, String fechaObtenido) {
	
		Respuestas r = new Respuestas();
		
		try {
			r.setCodigo(99);
			r.setMensaje("OK");
			tON.insertarTitulo(cedula, nombre, codRegistro, fechaObtenido);
			

		}catch (Exception e) {
			r.setCodigo(1);
			r.setMensaje("error");
			e.printStackTrace();
		}
		return r;
	
	}
	
	
	@WebMethod
	public List<Profecional> getProfesional(){
		List<Profecional> listado = tON.getProfesionales();
		for (Profecional p : listado) {
			p.setTitulos(null);
		}
		
		
		return listado;
		
	}
	
	
	
	@WebMethod
	public List<ListProfesionalNom> getTitulos(String cedula){
		
		
		List<Titulos> tit = tON.getTitulos(cedula);
		List<ListProfesionalNom> titulos = new ArrayList<>();
		
		ListProfesionalNom lista = new ListProfesionalNom();
		
		for(int i=0; i<tit.size() ; i++) {
			lista = new ListProfesionalNom();
			lista.setCodigo(tit.get(i).getCodigo());
			lista.setNombre(tit.get(i).getNombre());
			lista.setCodigoRegistro(tit.get(i).getCodRegistro());
			lista.setFechaRegistro(tit.get(i).getFechaObtenido());
			
			titulos.add(lista);
		
		}
		
		return titulos;
	}
	
	
	
	
	
}
