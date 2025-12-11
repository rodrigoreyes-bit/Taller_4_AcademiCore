package Dominio;
public class Notas {
	protected Estudiante estudiante;
	protected Curso curso;
	protected double calificacion;
	protected String estado;
	protected String semestre;
	
	public Notas(Estudiante estudiante, Curso curso, double calificacion, String estado, String semestre) {
		this.estudiante = estudiante;
		this.curso = curso;
		this.calificacion = calificacion;
		this.estado = estado;
		this.semestre = semestre;
	}
	
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
