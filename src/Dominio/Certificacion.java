package Dominio;
import java.util.ArrayList;

public class Certificacion {
	public String id;
	public String nombre;
	public String descripcion;
	public int requisitos;
	public String validez;
	public ArrayList<Curso> cursosRelacionados = new ArrayList<>();
	public ArrayList<Estudiante> estudiantesInscritos = new ArrayList<>();

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
	
	public ArrayList<Estudiante> getEstudiantesInscritos() {
		return estudiantesInscritos;
	}
	
	public void agregarEstudiante(Estudiante e) {
	    if (!estudiantesInscritos.contains(e)) {
	        estudiantesInscritos.add(e);
	    }
	}
}
