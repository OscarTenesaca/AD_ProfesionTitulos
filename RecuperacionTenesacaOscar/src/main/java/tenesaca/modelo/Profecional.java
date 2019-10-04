package tenesaca.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name= "TBL_PROFESIONALES_REC")
public class Profecional {

	
	@Id
	@NotNull
	private String cedula;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String direccion;
	
	@NotNull
	private String telefono;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="pro_cedula")
	private List<Titulos> titulos;
	
	
	

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Titulos> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulos> titulos) {
		this.titulos = titulos;
	}
	
	//content-type=application/json
	//{"cedula":"0302618251","nombre":"oscar","direccion":"UPS","telefono":"0995641727"}
	
	//{"cedula":"0302618251","nombre":"oscar","direccion":"UPS","telefono":"0995641727","titulos":[{"nombre":"Ing Sistemas","codRegistro":"12345","fechaObtenido":"12-12-2017"}]}

	
	
	

}
