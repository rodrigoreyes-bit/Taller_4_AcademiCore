import java.util.ArrayList;

public class Certificacion {
	private String id;
	private String nombre;
	private String descripcion;
	private String requisitos;
	private String validez;
	private ArrayList<Curso> cursosRelacionados = new ArrayList<>();

	public Certificacion(String id, String nombre, String descripcion, String requisitos, String validez) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.validez = validez;
	}

	// Source

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public String getValidez() {
		return validez;
	}

	public void setValidez(String validez) {
		this.validez = validez;
	}

	public ArrayList<Curso> getCursosRelacionados() {
		return cursosRelacionados;
	}

	public void setCursosRelacionados(ArrayList<Curso> cursosRelacionados) {
		this.cursosRelacionados = cursosRelacionados;
	}

	@Override
	public String toString() {
		return "Certificacion [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", requisitos="
				+ requisitos + ", validez=" + validez + "]";
	}

}
