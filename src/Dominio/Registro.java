package Dominio;

/**
 * Representa el registro de la inscripción y el progreso de un estudiante en una certificación específica.
 * Almacena el estado actual de la certificación para el estudiante, la fecha de registro y el avance.
 */
public class Registro {
	protected Usuario estudiante;
	protected Certificacion certificacion;
	protected String fecha;
	protected String estado;
	protected String progreso;
	
	/**
	 * Constructor para la clase Registro.
	 *
	 * @param estudiante El usuario (estudiante) asociado a este registro.
	 * @param certificacion La certificación a la que se refiere este registro.
	 * @param fecha La fecha en que se realizó o actualizó el registro ej: fecha de inscripción).
	 * @param estado El estado actual del estudiante en la certificación.
	 * @param progreso Un indicador del progreso o avance dentro de la certificación.
	 */
	public Registro(Usuario estudiante, Certificacion certificacion, String fecha, String estado, String progreso) {
		super();
		this.estudiante = estudiante;
		this.certificacion = certificacion;
		this.fecha = fecha;
		this.estado = estado;
		this.progreso = progreso;
	}
	
	/**
	 * Establece el estudiante asociado a este registro.
	 *
	 * @param estudiante El nuevo usuario estudiante.
	 */
	public void setEstudiante(Usuario estudiante) {
		this.estudiante = estudiante;
	}
	
	/**
	 * Establece la certificación a la que se refiere este registro.
	 *
	 * @param certificacion La nueva certificación.
	 */
	public void setCertificacion(Certificacion certificacion) {
		this.certificacion = certificacion;
	}
	
	/**
	 * Establece la fecha del registro.
	 *
	 * @param fecha La nueva fecha.
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	/**
	 * Establece el estado actual del estudiante en la certificación.
	 *
	 * @param estado El nuevo estado.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	/**
	 * Establece el indicador de progreso.
	 *
	 * @param progreso El nuevo valor de progreso.
	 */
	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}
}