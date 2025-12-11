
public class Estudiante {
	private String rut;
	private String nombre;
	private String carrera;
	private int numSemestre;
	private String correo;
	private String contraseña;
	
	public Estudiante(String rut, String nombre, String carrera, int numSemestre, String correo, String contraseña) {
		super();
		this.rut = rut;
		this.nombre = nombre;
		this.carrera = carrera;
		this.numSemestre = numSemestre;
		this.correo = correo;
		this.contraseña = contraseña;
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
