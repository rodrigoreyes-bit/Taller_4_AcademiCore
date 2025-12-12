
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Dominio.SistemaImpl;

/**
 * Clase principal de la aplicación que maneja la inicialización, la lectura de datos desde archivos
 * y el inicio de la interfaz de usuario.
 */
public class App {
	public static Scanner consola = new Scanner(System.in);
	public static Scanner archivo;
	public static SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

	/**
	 * Método principal que inicia la aplicación.
	 * Se encarga de la lectura secuencial de todos los archivos de datos
	 * y luego llama al método login para iniciar la GUI.
	 *
	 * @param args Argumentos de la línea de comandos.
	 * @throws FileNotFoundException Si alguno de los archivos de texto requeridos no se encuentra.
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// Lectura de Archivos
		lecturaUsuarios();
		lecturaEstudiantes();
		lecturaCursos();
		lecturaCertificaciones();
		lecturaRegistros();
		lecturaNotas();
		lecturaAsignaturas_Certificaciones();
		
		sistema.login();
	}
	
	/**
	 * Lee el archivo "asignaturas_certificaciones.txt" y asigna las certificaciones
	 * a los cursos correspondientes en el sistema.
	 *
	 * @throws FileNotFoundException Si el archivo "asignaturas_certificaciones.txt" no se encuentra.
	 */
	private static void lecturaAsignaturas_Certificaciones() throws FileNotFoundException {
		File file = new File("asignaturas_certificaciones.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.asignacion_Certificacion(lista[0], lista[1]);
		}
	}

	/**
	 * Lee el archivo "notas.txt" y registra las calificaciones de los estudiantes
	 * en sus respectivos cursos dentro del sistema.
	 *
	 * @throws FileNotFoundException Si el archivo "notas.txt" no se encuentra.
	 */
	private static void lecturaNotas() throws FileNotFoundException {
		File file = new File("notas.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.lectura_Notas(lista[0], lista[1], Double.valueOf(lista[2]), lista[3], lista[4]);
			
			
		}
	}

	/**
	 * Lee el archivo "registros.txt" y crea los registros de inscripción
	 * de estudiantes a certificaciones en el sistema.
	 *
	 * @throws FileNotFoundException Si el archivo "registros.txt" no se encuentra.
	 */
	private static void lecturaRegistros() throws FileNotFoundException {
		File file = new File("registros.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.lectura_Registro(lista[0], lista[1], lista[2], lista[3], lista[4]);
		}
	}

	/**
	 * Lee el archivo "certificaciones.txt" y carga la definición de
	 * las certificaciones disponibles en el sistema.
	 *
	 * @throws FileNotFoundException Si el archivo "certificaciones.txt" no se encuentra.
	 */
	private static void lecturaCertificaciones() throws FileNotFoundException {
		File file = new File("certificaciones.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.lectura_Certificacion(lista[0], lista[1], lista[2], Integer.valueOf(lista[3]), lista[4]);
		}
	}

	/**
	 * Lee el archivo "cursos.txt" y carga la definición de
	 * todos los cursos de la malla curricular en el sistema.
	 * Maneja cursos con y sin pre-requisitos.
	 *
	 * @throws FileNotFoundException Si el archivo "cursos.txt" no se encuentra.
	 */
	private static void lecturaCursos() throws FileNotFoundException {
		File file = new File("cursos.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");

			switch(lista.length) {
			
			case 5:
				sistema.lectura_Curso(lista[0], lista[1], Integer.valueOf(lista[2]), Integer.valueOf(lista[3]), lista[4], null);
				break;
			case 6:
				sistema.lectura_Curso(lista[0], lista[1], Integer.valueOf(lista[2]), Integer.valueOf(lista[3]), lista[4], lista[5]);
				break;
			}
		}
	}

	/**
	 * Lee el archivo "estudiantes.txt" y carga la información de
	 * todos los estudiantes en el sistema.
	 *
	 * @throws FileNotFoundException Si el archivo "estudiantes.txt" no se encuentra.
	 */
	private static void lecturaEstudiantes() throws FileNotFoundException {
		File file = new File("estudiantes.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] partes = archivo.nextLine().split(";");
			sistema.lectura_Estudiante(partes);
		}
	}

	/**
	 * Lee el archivo "usuarios.txt" y carga la información de
	 * los usuarios no estudiantes (Admin, Coordinador) en el sistema.
	 *
	 * @throws FileNotFoundException Si el archivo "usuarios.txt" no se encuentra.
	 */
	private static void lecturaUsuarios() throws FileNotFoundException {
		File file = new File("usuarios.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {

			String[] partes = archivo.nextLine().split(";");
			sistema.lectura_Usuario(partes);
		}
	}
}