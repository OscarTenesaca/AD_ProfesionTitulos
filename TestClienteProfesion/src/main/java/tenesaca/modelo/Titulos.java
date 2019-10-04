package tenesaca.modelo;

/**
 * 
 * @author oscartenesaca
 * 
 * OJO esta clase hace refencia al ListProfesionalNom por son los datos que se recupera 
 * y las variables tienen que tener el mismo nombre
 *
 */
public class Titulos {
	
	
	private int codigo;
	private String nombre;
	private String codigoRegistro;
	private String fechaRegistro;
	
	

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


	

	public String getCodigoRegistro() {
		return codigoRegistro;
	}


	public void setCodigoRegistro(String codigoRegistro) {
		this.codigoRegistro = codigoRegistro;
	}


	public String getFechaRegistro() {
		return fechaRegistro;
	}


	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}


	@Override
	public String toString() {
		return "Titulos [codigo=" + codigo + ", nombre=" + nombre + ", codigoRegistro=" + codigoRegistro
				+ ", fechaRegistro=" + fechaRegistro + "]";
	}


}
