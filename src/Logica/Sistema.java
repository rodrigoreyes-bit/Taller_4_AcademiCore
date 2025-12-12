package Logica;

import Dominio.Usuario;

/**
 * Interfaz que define las operaciones centrales y la funcionalidad del sistema de gestión académica.
 * Establece los métodos para la lectura de datos, la asignación de relaciones y la autenticación de usuarios.
 */
public interface Sistema {
	
	/**
	 * Procesa y registra la información de un usuario no estudiante.
	 * @param partes Un arreglo de Strings con los datos del usuario.
	 */
	public void lectura_Usuario(String [] partes);
	
	/**
	 * Procesa y registra la información de un estudiante.
	 * @param partes Un arreglo de Strings con los datos del estudiante.
	 */
	public void lectura_Estudiante(String [] partes);
	
	/**
	 * Procesa y registra la información de un curso en el sistema.
	 * @param NCR El código de referencia del curso.
	 * @param nombre El nombre del curso.
	 * @param numSemestre El número de semestre.
	 * @param cantCreditos La cantidad de créditos.
	 * @param area El área de estudio.
	 * @param requisito El NRC del curso o cursos pre-requisito (puede ser nulo).
	 */
	public void lectura_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area, String requisito);
	
	/**
	 * Procesa y registra la definición de una nueva certificación.
	 * @param id El identificador único de la certificación.
	 * @param nombre El nombre.
	 * @param descripcion La descripción.
	 * @param requisitos El número de requisitos mínimos.
	 * @param validez El periodo de validez.
	 */
	public void lectura_Certificacion(String id, String nombre, String descripcion, int requisitos, String validez);
	
	/**
	 * Procesa y registra un evento de inscripción o seguimiento de un estudiante a una certificación.
	 * @param estudiante El identificador del estudiante.
	 * @param certificacion El identificador de la certificación.
	 * @param fecha La fecha del registro.
	 * @param estado El estado del registro.
	 * @param progreso El indicador de progreso.
	 */
	public void lectura_Registro(String estudiante, String certificacion, String fecha, String estado, String progreso);
	
	/**
	 * Procesa y registra una nota obtenida por un estudiante en un curso.
	 * @param estudiante La identificación del estudiante (RUT).
	 * @param curso El código del curso (NRC).
	 * @param calificacion La calificación obtenida.
	 * @param estado El estado final de la asignatura para el estudiante.
	 * @param semestre El semestre en que se cursó.
	 */
	public void lectura_Notas(String estudiante, String curso, double calificacion, String estado, String semestre);
	
	/**
	 * Asocia una certificación específica a un curso dentro de la malla.
	 * @param id El identificador de la certificación.
	 * @param nrc El NRC del curso al que se asigna la certificación.
	 */
	public void asignacion_Certificacion(String id,String nrc);
	
	/**
	 * Valida las credenciales de un usuario.
	 * @param nombre El nombre de usuario o identificación.
	 * @param contraseña La contraseña.
	 * @return El objeto Usuario si las credenciales son correctas, o null si la validación falla.
	 */
	public Usuario validacion(String nombre, String contraseña);
	
	/**
	 * Inicia la interfaz gráfica de usuario para el inicio de sesión.
	 */
	public void login();
	
}