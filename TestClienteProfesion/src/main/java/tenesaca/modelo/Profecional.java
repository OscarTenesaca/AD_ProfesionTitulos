package tenesaca.modelo;

public class Profecional {

	

	private String cedula;
	
	
	private String nombre;
	

	private String direccion;
	
	
	private String telefono;
	

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

	@Override
	public String toString() {
		return "Profecional [cedula=" + cedula + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono="
				+ telefono + "]";
	}

	
	
	
	

}
