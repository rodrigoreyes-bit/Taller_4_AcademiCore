
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Dominio;
import java.util.ArrayList;


/**
 * Representa un usuario con rol de Estudiante, que hereda de la clase Usuario.
 * Almacena la información personal, académica y el historial de notas y certificaciones del estudiante.
 */
public class Estudiante extends Usuario{
	public String nombre;
	protected String carrera;
	protected int numSemestre;
	protected String correo;
	
	protected ArrayList<Certificacion> certificaciones = new ArrayList<>();
	protected ArrayList<Notas> notas = new ArrayList<>();
	
	/**
	 * Constructor para la clase Estudiante.
	 *
	 * @param username El nombre de usuario o identificación.
	 * @param contraseña La contraseña para el acceso al sistema.
	 * @param rol El rol del usuario, que debe ser "Estudiante".
	 * @param nombre El nombre completo del estudiante.
	 * @param carrera La carrera o programa de estudio al que pertenece.
	 * @param numSemestre El número de semestre que está cursando actualmente.
	 * @param correo El correo electrónico institucional del estudiante.
	 */
	public Estudiante(String username, String contraseña, String rol, String nombre, String carrera,
			int numSemestre, String correo) {
		super(username, contraseña, rol);
		this.nombre = nombre;
		this.carrera = carrera;
		this.numSemestre = numSemestre;
		this.correo = correo;
		this.certificaciones = new ArrayList<>();
		this.notas = new ArrayList<>();
	}
	
	/**
	 * Añade una nueva certificación a la lista de certificaciones inscritas o completadas por el estudiante.
	 *
	 * @param c La certificación a añadir.
	 */
	public void añadirCertificaciones(Certificacion c) {
		this.certificaciones.add(c);
		
	}
	
	/**
	 * Añade una nota de una asignatura al historial del estudiante.
	 *
	 * @param n El objeto Notas que contiene la información de la calificación y el curso.
	 */
	public void añadirNota(Notas n) {
		this.notas.add(n);
	}

	/**
	 * Obtiene el nombre completo del estudiante.
	 *
	 * @return El nombre del estudiante.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la carrera o programa de estudio del estudiante.
	 *
	 * @return El nombre de la carrera.
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * Obtiene el número de semestre que el estudiante está cursando actualmente.
	 *
	 * @return El número de semestre.
	 */
	public int getNumSemestre() {
		return numSemestre;
	}

	/**
	 * Obtiene el correo electrónico del estudiante.
	 *
	 * @return El correo electrónico.
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Obtiene la contraseña del estudiante.
	 *
	 * @return La contraseña del usuario.
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * Obtiene la lista de certificaciones a las que el estudiante está inscrito o ha completado.
	 *
	 * @return Un ArrayList de objetos Certificacion.
	 */
	public ArrayList<Certificacion> getCertificaciones() {
		return certificaciones;
	}

	/**
	 * Obtiene el historial completo de notas y cursos del estudiante.
	 *
	 * @return Un ArrayList de objetos Notas.
	 */
	public ArrayList<Notas> getNotas() {
		return notas;
	}

	/**
	 * Verifica si el estudiante ya tiene una certificación específica registrada en su lista.
	 *
	 * @param c La certificación a verificar.
	 * @return true si el estudiante tiene la certificación, false en caso contrario.
	 */
	public boolean tieneCertificacion(Certificacion c) {
	    return certificaciones.contains(c);
	}
}