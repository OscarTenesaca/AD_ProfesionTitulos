package tenesaca.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name= "TBL_TITULOS_REC")
public class Titulos {
	

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigo;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private String codRegistro;
	
	@NotNull
	private String fechaObtenido;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "pro_cedula")
	private Profecional profesional;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodRegistro() {
		return codRegistro;
	}


	public void setCodRegistro(String codRegistro) {
		this.codRegistro = codRegistro;
	}


	public String getFechaObtenido() {
		return fechaObtenido;
	}


	public void setFechaObtenido(String fechaObtenido) {
		this.fechaObtenido = fechaObtenido;
	}


	public Profecional getProfesional() {
		return profesional;
	}


	public void setProfesional(Profecional profesional) {
		this.profesional = profesional;
	}
	
		
	
	
	
	

}
