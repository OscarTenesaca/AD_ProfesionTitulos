package tenesaca.rest;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import tenesaca.modelo.Profecional;
import tenesaca.modelo.Respuestas;
import tenesaca.modelo.Titulos;


public class GestionProfesiones {
	
	private String WS_SAVE_GUARDARPROFESIONALES="http://0.0.0.0:8080/RecuperacionTenesacaOscar/srv/operaciones/insertarProfecional";
	private String WS_GET_PROFESIONALES = "http://0.0.0.0:8080/RecuperacionTenesacaOscar/srv/operaciones/listadoProfesionales";
	private String WS_SAVE_GUARDARTITULOS="http://0.0.0.0:8080/RecuperacionTenesacaOscar/srv/operaciones/insertarTitulo?";
	private String WS_GET_PROFESIONALTITULO = "http://0.0.0.0:8080/RecuperacionTenesacaOscar/srv/operaciones/ListarTitulosdeProfesional?cedula=";
	
	
	public List<Profecional> getProfecionales() {
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_GET_PROFESIONALES);
		List<Profecional> profesionales = target.request().get(new GenericType<List<Profecional>>() {});
		client.close();
		return profesionales;		
	}
	
	
	
	public Respuestas saveProfesionales(String cedula, String nombre,String direccion, String telefono) {
		
		Profecional pro = new Profecional();
		pro.setCedula(cedula);
		pro.setNombre(nombre);
		pro.setDireccion(direccion);
		pro.setTelefono(telefono);
		
	
		Client client = ClientBuilder.newClient();		
		WebTarget target = client.target(WS_SAVE_GUARDARPROFESIONALES);
		Respuestas respuesta = target.request().post(Entity.json(pro), Respuestas.class);
			
		return respuesta;
	}
	
	public Respuestas saveTitulos(String cedula, String nombre, String codRegistro, String fechaObtenido) {
		Client client = ClientBuilder.newClient();
		System.out.println("cedula="+cedula+"&nombre"+nombre+"&codRegistro"+codRegistro+"&fechaObtenido"+fechaObtenido);
		System.out.println("");
		
		WebTarget target = client.target(WS_SAVE_GUARDARTITULOS+"&cedula="+cedula+"&nombre="+nombre+"&codRegistro="+codRegistro+"&fechaObtenido="+fechaObtenido);

		Respuestas respuesta = target.request().get(Respuestas.class);
		System.out.println(respuesta);
		return respuesta;
		
		
	}
	
	public List<Titulos> getTitulosProfesionales(String cedula){
		Client client = ClientBuilder.newClient();
		System.out.println(cedula+"llega" );
		WebTarget target = client.target(WS_GET_PROFESIONALTITULO+cedula);
		//System.out.println(WS_GET_PROFESIONALTITULO+cedula);
		//System.out.println("");
		List<Titulos> titulo = target.request().get(new GenericType<List<Titulos>>() {});
		client.close();
		return titulo;
		
	}

	
	
	
	
	
	
	
}
