import java.util.ArrayList;

public class Curso {
	private String NRC;
	private String nombre;
	private int numSemestre;
	private int cantCreditos;
	private String area;
	private ArrayList<String> requisitos = new ArrayList<>();
	private ArrayList<Notas> notas = new ArrayList<>();
	private Certificacion certificacion;

	public Curso(String nRC, String nombre, int numSemestre, int cantCreditos, String area) {
		super();
		NRC = nRC;
		this.nombre = nombre;
		this.numSemestre = numSemestre;
		this.cantCreditos = cantCreditos;
		this.area = area;
	}

	public void añadirRequisito(String s) {
		this.requisitos.add(s);
	}
	public void añadirNota(Notas n) {
		this.notas.add(n);
		
	}

	// Source

	public String getNRC() {
		return NRC;
	}

	public void setNRC(String nRC) {
		NRC = nRC;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumSemestre() {
		return numSemestre;
	}

	public void setNumSemestre(int numSemestre) {
		this.numSemestre = numSemestre;
	}

	public int getCantCreditos() {
		return cantCreditos;
	}

	public void setCantCreditos(int cantCreditos) {
		this.cantCreditos = cantCreditos;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public ArrayList<String> getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(ArrayList<String> requisitos) {
		this.requisitos = requisitos;
	}

	public Certificacion getCertificacion() {
		return certificacion;
	}

	public void setCertificacion(Certificacion certificacion) {
		this.certificacion = certificacion;
	}

}
