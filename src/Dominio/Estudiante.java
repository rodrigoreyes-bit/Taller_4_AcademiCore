package Dominio;
import java.util.ArrayList;


public class Estudiante extends Usuario{
	protected String nombre;
	protected String carrera;
	protected int numSemestre;
	protected String correo;
	
	protected ArrayList<Certificacion> certificaciones = new ArrayList<>();
	protected ArrayList<Notas> notas = new ArrayList<>();
	
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
	public void añadirCertificaciones(Certificacion c) {
		this.certificaciones.add(c);
		
	}
	public void añadirNota(Notas n) {
		this.notas.add(n);
		
	}


	public String getNombre() {
		return nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public int getNumSemestre() {
		return numSemestre;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public ArrayList<Certificacion> getCertificaciones() {
		return certificaciones;
	}

	public ArrayList<Notas> getNotas() {
		return notas;
	}
}
