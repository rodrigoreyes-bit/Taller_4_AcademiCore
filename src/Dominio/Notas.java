
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Dominio;
public class Notas {
	protected Estudiante estudiante;
	public Curso curso;
	public double calificacion;
	public String estado;
	protected String semestre;
	
	/**
	 * Constructor para la clase Notas.
	 *
	 * @param estudiante El estudiante que obtuvo la calificación.
	 * @param curso El curso o asignatura a la que corresponde la calificación.
	 * @param calificacion El valor numérico de la nota obtenida.
	 * @param estado El estado final de la asignatura para el estudiante (ej: "Aprobado", "Reprobado", "Cursando").
	 * @param semestre El semestre académico en el que se cursó la asignatura.
	 */
	public Notas(Estudiante estudiante, Curso curso, double calificacion, String estado, String semestre) {
		this.estudiante = estudiante;
		this.curso = curso;
		this.calificacion = calificacion;
		this.estado = estado;
		this.semestre = semestre;
	}
	
	/**
	 * Establece el estudiante asociado a esta nota.
	 *
	 * @param estudiante El nuevo estudiante.
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	
	/**
	 * Establece el curso asociado a esta nota.
	 *
	 * @param curso El nuevo curso.
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	/**
	 * Establece el valor numérico de la calificación.
	 *
	 * @param calificacion La nueva calificación.
	 */
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	/**
	 * Establece el estado final de la asignatura.
	 *
	 * @param estado El nuevo estado.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Obtiene el semestre académico en el que se cursó la asignatura.
	 *
	 * @return El semestre académico.
	 */
	public String getSemestre() {
		return semestre;
	}
	
	/**
	 * Establece el semestre académico en el que se cursó la asignatura.
	 *
	 * @param semestre El nuevo semestre.
	 */
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	/**
	 * Obtiene el estudiante asociado a esta nota.
	 *
	 * @return El estudiante.
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}
	
	/**
	 * Obtiene el curso asociado a esta nota.
	 *
	 * @return El curso.
	 */
	public Curso getCurso() {
		return curso;
	}
	
	/**
	 * Obtiene el valor numérico de la calificación.
	 *
	 * @return La calificación.
	 */
	public double getCalificacion() {
		return calificacion;
	}
	
	/**
	 * Obtiene el estado final de la asignatura.
	 *
	 * @return El estado.
	 */
	public String getEstado() {
		return estado;
	}
}