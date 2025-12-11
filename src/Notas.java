
public class Notas {
	private Estudiante estudiante;
	private Curso curso;
	private double calificacion;
	private String estado;
	private String semestre;
	public Notas(Estudiante estudiante, Curso curso, double calificacion, String estado, String semestre) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
		this.calificacion = calificacion;
		this.estado = estado;
		this.semestre = semestre;
	}
	
	//Source
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	@Override
	public String toString() {
		return "Notas [estudiante=" + estudiante + ", curso=" + curso + ", calificacion=" + calificacion + ", estado="
				+ estado + ", semestre=" + semestre + "]";
	}
	

}
