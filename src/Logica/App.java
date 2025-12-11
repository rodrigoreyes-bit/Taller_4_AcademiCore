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
import Dominio.Usuario;

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
		
		login();
	}
	
	private static void login() { //////////VER ESTO
		Usuario usuarioLog = null;
		do {
			System.out.println("Ingrese su nombre de usuario.");
			System.out.print(">> ");
			//String usuario = scan.nextLine();
			System.out.println("Ingrese su contraseña.");
			System.out.print(">> ");
			//String contraseña = scan.nextLine();

			//usuarioLog = sistema.CheckDeInformacion(usuario, contraseña);

			if (usuarioLog == null) {
				System.out.println("Usuario o contraseña incorrectos. Intente de nuevo.\n");
			}
		} while (usuarioLog == null);

		switch (usuarioLog.getRol().toLowerCase()) {
		case "administrador":   //COMPLETAR
			menuAdmin();
			break;
		
		}
	}
	
	private static void menuAdmin() {
		// En caso que el usuario ingresado tenga el rol Admin se abre este menú de opciones.
		consola = new Scanner(System.in);
		
		//CREAR BOTONES
		int opcion = -1;
		do {
			System.out.println("\n---- MENÚ ADMINISTRADOR ----");
			System.out.println("\n--- Gestión de Usuarios ---");
			System.out.println("1. Crear cuentas de estudiante o coordinador");
			System.out.println("2. Modificar cuentas de estudiante o coordinador");
			System.out.println("3. Eliminar cuentas de estudiante o coordinador");
			System.out.println("4. Restablecer contraseñas");
			System.out.println("5. Cerrar sesión");
			System.out.print("Seleccione una opción: ");
			opcion = Integer.valueOf(consola.nextLine());

			switch (opcion) {
			case 1:
				break;

			case 2:
				break;
			
			case 3:
				break;
			
			case 4:
				break;
			
			case 5:
				break;

			default:
				System.out.println("Opción inválida.");
				break;
			}
		} while (opcion != 5);
	}

	
	private static void menuCoordinador() {
		//MOSTRAR GUI
		
		consola = new Scanner(System.in);
		int opcion = -1;
		do {
			System.out.println("\n--- MENÚ USUARIO ---");
			System.out.println("1. Ver proyectos disponibles");
			System.out.println("2. Ver tareas asignadas");
			System.out.println("3. Actualizar estado de una tarea");
			System.out.println("4. Checkeo de acciones requeridas sobre una tarea");
			System.out.println("5. Cerrar sesión");
			System.out.println("6. Detener sistema\n");
			System.out.print("Seleccione una opción: ");
			opcion = Integer.valueOf(consola.nextLine());

			switch (opcion) {
			case 1:
				//sistema.MostrarListaDeProyectosBasica();
				break;

			default:
				System.out.println("Opción inválida.");
				break;
			}

		} while (opcion != 6);
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
			String[] lista = archivo.nextLine().split(";");
			
			sistema.lectura_Estudiante(lista[0], lista[1], lista[2], Integer.valueOf(lista[3]), lista[4], lista[5]);

		}
	}

	private static void lecturaUsuarios() throws FileNotFoundException {
		File file = new File("usuarios.txt");
		archivo = new Scanner(file);
		while (archivo.hasNextLine()) {

			String[] lista = archivo.nextLine().split(";");

			switch (lista[0].split("\\.").length) {

			case 1:
				sistema.lectura_Usuario(lista[0], lista[1], lista[2], null);
				break;
			case 2:
				sistema.lectura_Usuario(lista[0], lista[1], lista[2], lista[3]);
				break;

			}

		}

	}

}
