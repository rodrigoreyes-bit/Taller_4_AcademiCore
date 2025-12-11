package Dominio;
import java.util.ArrayList;

public class Certificacion {
	protected String id;
	protected String nombre;
	protected String descripcion;
	protected int requisitos;
	protected String validez;
	protected ArrayList<Curso> cursosRelacionados = new ArrayList<>();
	protected ArrayList<Estudiante> estudiantesInscritos = new ArrayList<>();

	public Certificacion(String id, String nombre, String descripcion, int requisitos, String validez) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.validez = validez;
	}
	public void añadirEstudiantes(Estudiante e) {
		this.estudiantesInscritos.add(e);
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

	public int getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(int requisitos) {
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
