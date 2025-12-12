
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Dominio;
import java.util.ArrayList;

/**
 * Representa una certificación académica.
 * Incluye información sobre los requisitos, la validez, y las relaciones con cursos y estudiantes.
 */
public class Certificacion {
	public String id;
	public String nombre;
	public String descripcion;
	public int requisitos;
	public String validez;
	public ArrayList<Curso> cursosRelacionados = new ArrayList<>();
	public ArrayList<Estudiante> estudiantesInscritos = new ArrayList<>();

	/**
	 * Constructor para la clase Certificacion.
	 * * @param id El identificador único de la certificación.
	 * @param nombre El nombre oficial de la certificación.
	 * @param descripcion Una descripción detallada de lo que cubre la certificación.
	 * @param requisitos El número mínimo de cursos o créditos requeridos para optar a la certificación.
	 * @param validez El periodo de validez de la certificación.
	 */
	public Certificacion(String id, String nombre, String descripcion, int requisitos, String validez) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.requisitos = requisitos;
		this.validez = validez;
	}
	
	/**
	 * Añade un estudiante a la lista de inscritos.
	 * * @param e El estudiante que se está inscribiendo a la certificación.
	 */
	public void añadirEstudiantes(Estudiante e) {
		this.estudiantesInscritos.add(e);
	}

	/**
	 * Obtiene el identificador único de la certificación.
	 * * @return El ID de la certificación.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece el identificador único de la certificación.
	 * * @param id El nuevo ID de la certificación.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Obtiene el nombre de la certificación.
	 * * @return El nombre de la certificación.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre de la certificación.
	 * * @param nombre El nuevo nombre de la certificación.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene la descripción detallada de la certificación.
	 * * @return La descripción de la certificación.
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece la descripción detallada de la certificación.
	 * * @param descripcion La nueva descripción de la certificación.
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene el número mínimo de requisitos para obtener la certificación.
	 * * @return La cantidad de requisitos.
	 */
	public int getRequisitos() {
		return requisitos;
	}

	/**
	 * Establece el número mínimo de requisitos para obtener la certificación.
	 * * @param requisitos La nueva cantidad de requisitos.
	 */
	public void setRequisitos(int requisitos) {
		this.requisitos = requisitos;
	}

	/**
	 * Obtiene el periodo de validez de la certificación.
	 * * @return La validez de la certificación.
	 */
	public String getValidez() {
		return validez;
	}

	/**
	 * Establece el periodo de validez de la certificación.
	 * * @param validez La nueva validez de la certificación.
	 */
	public void setValidez(String validez) {
		this.validez = validez;
	}

	/**
	 * Obtiene la lista de cursos que están relacionados con esta certificación.
	 * * @return Un ArrayList de objetos Curso.
	 */
	public ArrayList<Curso> getCursosRelacionados() {
		return cursosRelacionados;
	}

	/**
	 * Establece la lista de cursos relacionados con esta certificación.
	 * * @param cursosRelacionados El nuevo ArrayList de cursos.
	 */
	public void setCursosRelacionados(ArrayList<Curso> cursosRelacionados) {
		this.cursosRelacionados = cursosRelacionados;
	}
	
	/**
	 * Obtiene la lista de estudiantes inscritos en esta certificación.
	 * * @return Un ArrayList de objetos Estudiante.
	 */
	public ArrayList<Estudiante> getEstudiantesInscritos() {
		return estudiantesInscritos;
	}
	
	/**
	 * Agrega un estudiante a la lista de inscritos, asegurando que no esté ya presente.
	 * * @param e El estudiante a agregar.
	 */
	public void agregarEstudiante(Estudiante e) {

	    if (!estudiantesInscritos.contains(e)) {

	        estudiantesInscritos.add(e);

	    }

	}

	}
