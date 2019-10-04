package tenesaca.vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import tenesaca.modelo.Titulos;
import tenesaca.on.TitulosON;

@ManagedBean
@ViewScoped
public class TitulosControl {
	
	private String cedula= null;
	
	@Inject
	private TitulosON tON;
	
	Titulos titulo = new Titulos();
	private List<Titulos> listadoTitulos;
	
	
	@PostConstruct
	public void init() {
	titulo = new Titulos();	
	listadoTitulos= tON.getTodosTitulosON();
	}


	public TitulosON gettON() {
		return tON;
	}


	public void settON(TitulosON tON) {
		this.tON = tON;
	}


	public Titulos getTitulo() {
		return titulo;
	}


	public void setTitulo(Titulos titulo) {
		this.titulo = titulo;
	}


	public List<Titulos> getListadoTitulos() {
		return listadoTitulos;
	}


	public void setListadoTitulos(List<Titulos> listadoTitulos) {
		this.listadoTitulos = listadoTitulos;
	}
	
	
	
	
	
	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}




	public String cedula() {	
		System.out.println(cedula);	
		listadoTitulos = tON.getTitulos(cedula);
		return cedula;	}

}
