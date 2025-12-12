
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Dominio;
import java.util.ArrayList;

import Logica.Factory;
import Logica.Sistema;
import Presentacion.GuiPrincipal;

/**
 * Implementación de la interfaz Sistema que gestiona todos los datos y la lógica central de la aplicación.
 * Utiliza el patrón Singleton (Instancia_Unica) para asegurar una única fuente de verdad para el sistema.
 */
public class SistemaImpl implements Sistema {
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	public ArrayList<Curso> cursos = new ArrayList<>();
	public ArrayList<Estudiante> estudiantes = new ArrayList<>();
	public ArrayList<Certificacion> certificaciones = new ArrayList<>();
	public ArrayList<Registro> registros = new ArrayList<>();
	public ArrayList<Notas> notas = new ArrayList<>();
	public Factory factory = Factory.InstanciarFactory();
	
	private static SistemaImpl Instancia_Unica;
	
	/**
	 * Constructor privado para implementar el patrón Singleton.
	 */
	private SistemaImpl() {
	}

	/**
	 * Obtiene la única instancia de SistemaImpl.
	 * * @return La instancia única de SistemaImpl.
	 */
	public static SistemaImpl InstanciarSistemaImpl() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new SistemaImpl();
		}
		return Instancia_Unica;
	}
	

	/**
	 * Procesa los datos de un usuario leído y lo agrega a la lista de usuarios.
	 * * @param partes Un arreglo de Strings con la información del usuario.
	 */
	public void lectura_Usuario(String [] partes) {
		usuarios.add(factory.crear_Usuario(partes));
	}

	/**
	 * Procesa los datos de un curso leído y lo agrega a la lista de cursos.
	 * * @param NCR El código de referencia del curso.
	 * @param nombre El nombre del curso.
	 * @param numSemestre El número de semestre.
	 * @param cantCreditos La cantidad de créditos.
	 * @param area El área a la que pertenece el curso.
	 * @param requisito El NRC del curso o cursos pre-requisito.
	 */
	public void lectura_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area,
			String requisito) {
		cursos.add(factory.crear_Curso(NCR, nombre, numSemestre, cantCreditos, area, requisito));
	}

	/**
	 * Procesa los datos de un estudiante leído y lo agrega a las listas de estudiantes y usuarios.
	 * * @param partes Un arreglo de Strings con la información del estudiante.
	 */
	public void lectura_Estudiante(String [] partes) {
		Estudiante u = factory.crear_Estudiante(partes);
		estudiantes.add(u);
		usuarios.add(u);
	}

	/**
	 * Procesa los datos de una certificación leída y la agrega a la lista de certificaciones.
	 * * @param id El identificador de la certificación.
	 * @param nombre El nombre de la certificación.
	 * @param descripcion La descripción de la certificación.
	 * @param requisitos El número de requisitos mínimos.
	 * @param validez El periodo de validez.
	 */
	public void lectura_Certificacion(String id, String nombre, String descripcion, int requisitos, String validez) {
		certificaciones.add(factory.crear_Certificacion(id, nombre, descripcion, requisitos, validez));
	}

	/**
	 * Procesa un registro de inscripción leído y lo agrega a la lista de registros.
	 * Asocia la certificación con el estudiante.
	 * * @param estudiante El identificador del estudiante.
	 * @param certificacion El identificador de la certificación.
	 * @param fecha La fecha del registro.
	 * @param estado El estado de la certificación para el estudiante.
	 * @param progreso El progreso actual.
	 */
	public void lectura_Registro(String estudiante, String certificacion, String fecha, String estado,
			String progreso) {
		registros.add(factory.crear_Registro(estudiantes, certificaciones, estudiante, certificacion, fecha, estado, progreso));
	}

	/**
	 * Procesa una nota leída y la agrega a la lista de notas.
	 * Asocia la nota al estudiante y al curso correspondiente.
	 * * @param rut El RUT del estudiante.
	 * @param codigoAsignatura El NRC de la asignatura.
	 * @param calificacion La calificación obtenida.
	 * @param estado El estado final de la asignatura para el estudiante.
	 * @param semestre El semestre en que se cursó.
	 */
	public void lectura_Notas(String rut, String codigoAsignatura, double calificacion, String estado, String semestre) {
		notas.add(factory.crear_Notas(estudiantes, cursos, rut, codigoAsignatura, calificacion, estado, semestre));
	}

	/**
	 * Asigna una certificación a un curso específico.
	 * * @param id El identificador de la certificación.
	 * @param nrc El NRC del curso.
	 */
	public void asignacion_Certificacion(String id, String nrc) {
		Certificacion certificadoBuscado = null;
		Curso cursoBuscado = null;
		for (Certificacion c : certificaciones) {
			if (c.getId().equals(id)) {
				certificadoBuscado = c;
			}
		}
		for (Curso c : cursos) {
			if (c.getNRC().equals(nrc)) {
				cursoBuscado = c;
			}
		}
		cursoBuscado.setCertificacion(certificadoBuscado);
	}

	/**
	 * Valida las credenciales de un usuario para permitir el inicio de sesión.
	 * * @param nombre El nombre de usuario o identificación.
	 * @param contraseña La contraseña proporcionada.
	 * @return El objeto Usuario si las credenciales son correctas, o null si fallan.
	 */
	public Usuario validacion(String nombre, String contraseña) {
	    for (Usuario u : usuarios) {
	        if (u.username.equals(nombre) && u.contraseña.equals(contraseña)) {
	            return u;
	        }
	    }
	    return null;
	}
	
	/**
	 * Inicia la interfaz gráfica principal de la aplicación.
	 */
	public void login() {
		GuiPrincipal principal = new GuiPrincipal();
		principal.setVisible(true);
	}

	/**
	 * Obtiene la lista completa de cursos.
	 * * @return Un ArrayList de objetos Curso.
	 */
	public ArrayList<Curso> getCursos() {
		return cursos;
	}

	/**
	 * Obtiene la lista completa de certificaciones.
	 * * @return Un ArrayList de objetos Certificacion.
	 */
	public ArrayList<Certificacion> getCertificaciones() {
		return certificaciones;
	}
	
	/**
	 * Busca una certificación por su identificador único.
	 * * @param id El identificador de la certificación a buscar.
	 * @return El objeto Certificacion encontrado, o null si no existe.
	 */
	public Certificacion buscarCertificacion(String id) {
	    for (Certificacion c : certificaciones) {
	        if (c.id.equals(id)) {
	            return c;
	        }
	    }
	    return null;
	}
	
	/**
	 * Verifica si un estudiante ha completado todos los cursos relacionados con una línea de certificación en la que está inscrito.
	 * Se considera completado si la calificación es mayor o igual a 4.0.
	 * * @param est El estudiante a verificar.
	 * @return true si el estudiante ha aprobado todos los cursos de la certificación inscrita, false en caso contrario.
	 */
	public boolean estudianteCompletoLinea(Estudiante est) {
	    Certificacion cert = null;
	    for (Certificacion c : certificaciones) {
	        if (c.getEstudiantesInscritos().contains(est)) {
	            cert = c;
	            break;
	        }
	    }

	    if (cert == null) return false;

	    for (Curso cursoLinea : cert.getCursosRelacionados()) {
	        boolean aprobado = false;
	        for (Notas n : notas) {

	            if (n.getEstudiante().equals(est) && n.getCurso().equals(cursoLinea) && n.getCalificacion() >= 4.0) {
	                aprobado = true;
	                break;
	            }
	        }
	        if (!aprobado) return false; 
	    }

	    return true;
	}
	
	/**
	 * Busca un estudiante por su identificación.
	 * * @param id La identificación (RUT) del estudiante a buscar.
	 * @return El objeto Estudiante encontrado, o null si no existe.
	 */
	public Estudiante buscarEstudiante(String id) {
	    for (Estudiante e : estudiantes) {
	        if (e.username.equals(id)) { //el username es el rut
	            return e;
	        }
	    }
	    return null;
	}

	/**
	 * Obtiene la lista completa de usuarios.
	 * * @return Un ArrayList de objetos Usuario.
	 */
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Obtiene la lista completa de estudiantes.
	 * * @return Un ArrayList de objetos Estudiante.
	 */
	public ArrayList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	/**
	 * Obtiene la lista completa de registros de certificación.
	 * * @return Un ArrayList de objetos Registro.
	 */
	public ArrayList<Registro> getRegistros() {
		return registros;
	}

	/**
	 * Obtiene la lista completa de notas registradas en el sistema.
	 * * @return Un ArrayList de objetos Notas.
	 */
	public ArrayList<Notas> getNotas() {
		return notas;
	}
}