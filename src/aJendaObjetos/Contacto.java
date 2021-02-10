package aJendaObjetos;

public class Contacto {
	private String nombre, apellido;
	private String telefono;

	public Contacto() {
		nombre = "";
		apellido = "";
		telefono = "";
	}

	public Contacto(String nombre, String telefono) {
		this.nombre = nombre;
		this.apellido = "";
		this.telefono = telefono;
	}

	public Contacto(String nombre, String apellido, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		if (apellido != null) {
			if (telefono != null) {
				return nombre + " " + apellido + " - " + telefono;
			} else {
				return nombre + " " + apellido;
			}
		} else {
			if (telefono != null) {
				return nombre + " - " + telefono;
			} else {
				return nombre;
			}
		}
	}

}
