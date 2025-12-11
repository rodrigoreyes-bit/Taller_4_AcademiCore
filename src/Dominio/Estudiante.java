package Dominio;
import java.util.ArrayList;
public class Estudiante {
	protected String rut;
	protected String nombre;
	protected String carrera;
	protected int numSemestre;
	protected String correo;
	protected String contraseña;
	protected ArrayList<Certificacion> certificaciones = new ArrayList<>();
	protected ArrayList<Notas> notas = new ArrayList<>();
	
	public Estudiante(String rut, String nombre, String carrera, int numSemestre, String correo, String contraseña) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.numSemestre = numSemestre;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	
	public void añadirCertificaciones(Certificacion c) {
		this.certificaciones.add(c);
		
	}
	public void añadirNota(Notas n) {
		this.notas.add(n);
		
	}
	//Source

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public int getNumSemestre() {
		return numSemestre;
	}

	public void setNumSemestre(int numSemestre) {
		this.numSemestre = numSemestre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Estudiante [rut=" + rut + ", nombre=" + nombre + ", carrera=" + carrera + ", numSemestre=" + numSemestre
				+ ", correo=" + correo + ", contraseña=" + contraseña + "]";
	}
	
	
	
	
	
	
}
