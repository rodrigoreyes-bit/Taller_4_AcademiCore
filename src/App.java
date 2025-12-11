import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	public static Scanner Consola = new Scanner(System.in);
	public static Scanner archivo;
	public static SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
	
	public static void main(String[] args) throws FileNotFoundException {
		//Lectura de Archivos
		lecturaUsuarios();
		lecturaEstudiantes();
		lecturaCursos();
		lecturaCertificaciones();
		lecturaRegistros();
		lecturaNotas();
		lecturaAsignaturas_Certificaciones();
		
		
		

	}

	private static void lecturaAsignaturas_Certificaciones() {
		// TODO Auto-generated method stub
		
	}

	private static void lecturaCertificaciones() {
		// TODO Auto-generated method stub
		
	}

	private static void lecturaCursos() {
		// TODO Auto-generated method stub
		
	}

	private static void lecturaEstudiantes() {
		// TODO Auto-generated method stub
		
	}

	private static void lecturaNotas() {
		// TODO Auto-generated method stub
		
	}

	private static void lecturaRegistros() {
		// TODO Auto-generated method stub
		
	}

	private static void lecturaUsuarios() throws FileNotFoundException {
		File file = new File("usuarios");
		archivo = new Scanner(file);
		
		while(archivo.hasNextLine()) {
			
			String[] lista = archivo.nextLine().split(";");
			
			switch(lista[0].split("\\.").length){
			
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
