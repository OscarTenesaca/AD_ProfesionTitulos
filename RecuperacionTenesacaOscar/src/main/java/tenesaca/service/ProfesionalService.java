package tenesaca.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import tenesaca.modelo.ListProfesionalNom;
import tenesaca.modelo.Profecional;
import tenesaca.modelo.Respuestas;
import tenesaca.modelo.Titulos;
import tenesaca.on.TitulosON;



@Path("/operaciones")
public class ProfesionalService {
	
	@Inject
	private TitulosON tON;
	
	
	@POST
	@Path("/insertarProfecional")
	@Consumes("application/json")
	@Produces("application/json")
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
	
	@GET
	@Path("/insertarTitulo")
	@Produces("application/json")
	public Respuestas insertarTitulo(@QueryParam("cedula")String cedula, @QueryParam("nombre")String nombre, @QueryParam("codRegistro")String codRegistro, @QueryParam("fechaObtenido")String fechaObtenido) {
	
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
	
	
	@GET
	@Path("listadoProfesionales")
	@Produces("application/json")
	public List<Profecional> getProfesional(){
		List<Profecional> listado = tON.getProfesionales();
		for (Profecional p : listado) {
			p.setTitulos(null);
		}
		
		
		return listado;
		
	}
	
	
	
	@GET
	@Path("/ListarTitulosdeProfesional")
	@Produces("application/json")
	public List<ListProfesionalNom> getTitulos(@QueryParam("cedula")String cedula){
		
		
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
