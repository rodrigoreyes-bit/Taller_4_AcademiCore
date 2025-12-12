package Dominio;
import java.util.ArrayList;

/**
 * Representa un curso o asignatura dentro de la malla curricular.
 * Almacena información sobre el curso, sus requisitos y las notas asociadas.
 */
public class Curso {
	public String NRC;
	public String nombre;
	public int numSemestre;
	public int cantCreditos;
	public String area;
	protected ArrayList<String> requisitos = new ArrayList<>();
	protected ArrayList<Notas> notas = new ArrayList<>();
	protected Certificacion certificacion;

	/**
	 * Constructor para la clase Curso.
	 *
	 * @param nRC El código de referencia del curso (NRC).
	 * @param nombre El nombre completo del curso.
	 * @param numSemestre El número de semestre en el que se imparte el curso.
	 * @param cantCreditos La cantidad de créditos que otorga el curso.
	 * @param area El área de estudio a la que pertenece el curso.
	 */
	public Curso(String nRC, String nombre, int numSemestre, int cantCreditos, String area) {
		super();
		NRC = nRC;
		this.nombre = nombre;
		this.numSemestre = numSemestre;
		this.cantCreditos = cantCreditos;
		this.area = area;
	}

	/**
	 * Añade el NRC de otro curso como requisito para tomar este curso.
	 *
	 * @param s El NRC del curso pre-requisito.
	 */
	public void añadirRequisito(String s) {
		this.requisitos.add(s);
	}
	
	/**
	 * Asocia una nota específica a este curso.
	 *
	 * @param n El objeto Notas que contiene la calificación obtenida en este curso.
	 */
	public void añadirNota(Notas n) {
		this.notas.add(n);
	}

	/**
	 * Obtiene el código de referencia del curso.
	 *
	 * @return El NRC del curso.
	 */
	public String getNRC() {
		return NRC;
	}

	/**
	 * Establece el código de referencia del curso.
	 *
	 * @param nRC El nuevo NRC del curso.
	 */
	public void setNRC(String nRC) {
		NRC = nRC;
	}

	/**
	 * Obtiene el nombre completo del curso.
	 *
	 * @return El nombre del curso.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre completo del curso.
	 *
	 * @param nombre El nuevo nombre del curso.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el número de semestre en el que se imparte el curso.
	 *
	 * @return El número de semestre.
	 */
	public int getNumSemestre() {
		return numSemestre;
	}

	/**
	 * Establece el número de semestre en el que se imparte el curso.
	 *
	 * @param numSemestre El nuevo número de semestre.
	 */
	public void setNumSemestre(int numSemestre) {
		this.numSemestre = numSemestre;
	}

	/**
	 * Obtiene la cantidad de créditos que otorga el curso.
	 *
	 * @return La cantidad de créditos.
	 */
	public int getCantCreditos() {
		return cantCreditos;
	}

	/**
	 * Establece la cantidad de créditos que otorga el curso.
	 *
	 * @param cantCreditos La nueva cantidad de créditos.
	 */
	public void setCantCreditos(int cantCreditos) {
		this.cantCreditos = cantCreditos;
	}

	/**
	 * Obtiene el área de estudio a la que pertenece el curso.
	 *
	 * @return El área del curso.
	 */
	public String getArea() {
		return area;
	}

	/**
	 * Establece el área de estudio a la que pertenece el curso.
	 *
	 * @param area La nueva área del curso.
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * Obtiene la lista de NRCs de los cursos que son requisitos previos.
	 *
	 * @return Un ArrayList de Strings con los NRCs de los requisitos.
	 */
	public ArrayList<String> getRequisitos() {
		return requisitos;
	}

	/**
	 * Establece la lista completa de requisitos previos (NRCs).
	 *
	 * @param requisitos El nuevo ArrayList de requisitos.
	 */
	public void setRequisitos(ArrayList<String> requisitos) {
		this.requisitos = requisitos;
	}

	/**
	 * Obtiene la certificación a la que está asociado este curso, si existe.
	 *
	 * @return El objeto Certificacion asociado, o null si no está asociado a ninguna.
	 */
	public Certificacion getCertificacion() {
		return certificacion;
	}

	/**
	 * Asocia este curso a una certificación específica.
	 *
	 * @param certificacion La certificación a la que se asocia el curso.
	 */
	public void setCertificacion(Certificacion certificacion) {
		this.certificacion = certificacion;
	}

	/**
	 * Obtiene la lista de objetos Notas asociadas a este curso.
	 *
	 * @return Un ArrayList de objetos Notas.
	 */
	public ArrayList<Notas> getNotas() {
		return notas;
	}
	
	/**
	 * Cuenta el número de veces que el curso ha sido reprobado por los estudiantes que lo han cursado.
	 * Se considera reprobación una calificación menor a 4.0.
	 *
	 * @return El número total de reprobaciones registradas para este curso.
	 */
	public int getNumReprobaciones() {
	    int cont = 0;
	    for (Notas n : notas) {
	        // Asume que 4.0 es la nota mínima de aprobación.
	        if (n.getCalificacion() < 4.0) { 
	            cont++;
	        }
	    }
	    return cont;
	}
}
