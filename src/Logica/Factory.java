
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Logica;
import java.util.ArrayList;

import Dominio.Admin;
import Dominio.Certificacion;
import Dominio.Coordinador;
import Dominio.Curso;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.Registro;
import Dominio.Usuario;

/**
 * Clase Factory que implementa el patrón de diseño Singleton y Factory Method.
 * Es responsable de crear instancias de los objetos del dominio.
 * a partir de datos crudos o parámetros específicos, centralizando la lógica de instanciación.
 */
public class Factory {

	private static Factory Instancia_Unica;

	/**
	 * Constructor privado para implementar el patrón Singleton.
	 */
	private Factory() {
	}

	/**
	 * Obtiene la única instancia de la clase Factory (Singleton).
	 * @return La instancia única de Factory.
	 */
	public static Factory InstanciarFactory() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new Factory();
		}
		return Instancia_Unica;
	}

	/**
	 * Crea una instancia de un Usuario basándose en los datos proporcionados.
	 * Utiliza un switch en el rol para determinar la subclase correcta.
	 * @param partes Arreglo de Strings que contiene username, contraseña, rol, y posiblemente infoExtra.
	 * @return Una instancia de Admin o Coordinador, o null si el rol no es reconocido.
	 */
	public Usuario crear_Usuario(String [] partes) {
		String username = partes[0];
		String contraseña = partes[1];
		String rol = partes[2];
		
		
		switch(rol) {
		case "Admin":
			Admin a = new Admin(username, contraseña, rol);
			return a;
			
		case "Coordinador":
			String infoExtra = partes[3];
			Coordinador c = new Coordinador(username, contraseña, rol, infoExtra);
			return c;
		}
		return null;
	}

	/**
	 * Crea una instancia de Curso e inicializa su lista de requisitos si se proporcionan.
	 * @param NCR El código de referencia del curso.
	 * @param nombre El nombre del curso.
	 * @param numSemestre El número de semestre.
	 * @param cantCreditos La cantidad de créditos.
	 * @param area El área de estudio.
	 * @param requisito Una cadena de NRCs separados por comas que son pre-requisitos, o null.
	 * @return Una nueva instancia de Curso.
	 */
	public Curso crear_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area,
			String requisito) {
		Curso c = new Curso(NCR, nombre, numSemestre, cantCreditos, area);
		if (requisito != null) {
			
			String[] listaIDS = requisito.split(",");
			for (int i = 0; i < listaIDS.length; i++) {
				c.añadirRequisito(listaIDS[i]);
			}
		}
		return c;
	}

	/**
	 * Crea una instancia de Estudiante a partir de un arreglo de datos.
	 * El rol se establece por defecto como "Estudiante".
	 * @param partes Arreglo de Strings que contiene rut, nombre, carrera, semestre, correo y contraseña.
	 * @return Una nueva instancia de Estudiante.
	 */
	public Estudiante crear_Estudiante(String [] partes) {
		String rut = partes[0];
		String nombre = partes[1];
		String carrera = partes[2];
		int semestre = Integer.valueOf(partes[3]);
		String correo = partes[4];
		String contraseña = partes[5];
		
		Estudiante e = new Estudiante(rut, contraseña, "Estudiante", nombre, carrera, semestre, correo);
		return e;
	}

	/**
	 * Crea una nueva instancia de Certificacion.
	 * @param id El identificador único de la certificación.
	 * @param nombre El nombre.
	 * @param descripcion La descripción.
	 * @param requisitos El número mínimo de requisitos.
	 * @param validez El periodo de validez.
	 * @return Una nueva instancia de Certificacion.
	 */
	public Certificacion crear_Certificacion(String id, String nombre, String descripcion, int requisitos,
			String validez) {
		Certificacion c = new Certificacion(id, nombre, descripcion, requisitos, validez);
		return c;
	}

	/**
	 * Crea un registro de inscripción de un estudiante a una certificación.
	 * Se encarga de buscar las entidades correspondientes y enlazarlas, además de actualizar
	 * las listas internas de Estudiante y Certificacion.
	 * @param estudiantes Lista completa de estudiantes del sistema para la búsqueda.
	 * @param certificaciones Lista completa de certificaciones del sistema para la búsqueda.
	 * @param estudiante Identificador (username) del estudiante.
	 * @param certificacion Identificador (id) de la certificación.
	 * @param fecha La fecha del registro.
	 * @param estado El estado de la certificación para el estudiante.
	 * @param progreso El progreso actual.
	 * @return Una nueva instancia de Registro, o null si el estudiante o la certificación no se encuentran.
	 */
	public Registro crear_Registro(ArrayList<Estudiante> estudiantes, ArrayList<Certificacion> certificaciones,
			String estudiante, String certificacion, String fecha, String estado, String progreso) {
		
		Estudiante estudianteBuscado = null;
		Certificacion certificadoBuscado = null;

		for (Estudiante e : estudiantes) {

			if (e.username.equals(estudiante)) {
				estudianteBuscado = e;
				break;
			}
		}
		for (Certificacion c : certificaciones) {
			if (c.id.equals(certificacion)) {
				certificadoBuscado = c;
				break;
			}
		}

		if (estudianteBuscado == null || certificadoBuscado == null) {
			System.out.println("Error registro");
			return null;
		}

		Registro r = new Registro(estudianteBuscado, certificadoBuscado, fecha, estado, progreso);
		estudianteBuscado.añadirCertificaciones(certificadoBuscado);
		certificadoBuscado.añadirEstudiantes(estudianteBuscado);
		return r;

	}

	/**
	 * Crea un registro de Notas para un estudiante en un curso específico.
	 * Se encarga de buscar las entidades correspondientes y enlazarlas.
	 * @param estudiantes Lista completa de estudiantes del sistema para la búsqueda.
	 * @param cursos Lista completa de cursos del sistema para la búsqueda.
	 * @param rut RUT del estudiante.
	 * @param codigoAsignatura NRC del curso.
	 * @param calificacion La calificación obtenida.
	 * @param estado El estado de la nota.
	 * @param semestre El semestre en que se cursó.
	 * @return Una nueva instancia de Notas, o null si el estudiante o el curso no se encuentran.
	 */
	public Notas crear_Notas(ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos, String rut,
			String codigoAsignatura, double calificacion, String estado, String semestre) {
		
		Estudiante estudianteBuscado = null;
		Curso cursoBuscado = null;

		for (Estudiante e : estudiantes) {

			if (e.username.equals(rut)) {
				estudianteBuscado = e;
				break;
			}
		}
		for (Curso c : cursos) {
			if (c.NRC.equals(codigoAsignatura)) {
				cursoBuscado = c;
				break;
			}
		}

		if (estudianteBuscado == null || cursoBuscado == null) {
			System.out.println("Error notas");
			return null;
		}
		Notas n = new Notas(estudianteBuscado, cursoBuscado, calificacion, estado, semestre);
		estudianteBuscado.añadirNota(n);
		cursoBuscado.añadirNota(n);
		return n;
	}

}