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

public class App {
	public static Scanner consola = new Scanner(System.in);
	public static Scanner archivo;
	public static SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

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
	
	private static void lecturaAsignaturas_Certificaciones() throws FileNotFoundException {
		File file = new File("asignaturas_certificaciones.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.asignacion_Certificacion(lista[0], lista[1]);
		}
	}

	private static void lecturaNotas() throws FileNotFoundException {
		File file = new File("notas.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.lectura_Notas(lista[0], lista[1], Double.valueOf(lista[2]), lista[3], lista[4]);
			
			
		}
	}

	private static void lecturaRegistros() throws FileNotFoundException {
		File file = new File("registros.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.lectura_Registro(lista[0], lista[1], lista[2], lista[3], lista[4]);
		}
	}

	private static void lecturaCertificaciones() throws FileNotFoundException {
		File file = new File("certificaciones.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] lista = archivo.nextLine().split(";");
			sistema.lectura_Certificacion(lista[0], lista[1], lista[2], Integer.valueOf(lista[3]), lista[4]);
		}
	}

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

	private static void lecturaEstudiantes() throws FileNotFoundException {
		File file = new File("estudiantes.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {
			String[] partes = archivo.nextLine().split(";");
			sistema.lectura_Estudiante(partes);
		}
	}

	private static void lecturaUsuarios() throws FileNotFoundException {
		File file = new File("usuarios.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {

			String[] partes = archivo.nextLine().split(";");
			sistema.lectura_Usuario(partes);
		}
	}
}
