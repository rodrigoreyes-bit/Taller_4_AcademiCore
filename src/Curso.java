
public class Curso {
	private String NRC;
	private String nombre;
	private int numSemestre;
	private int cantCreditos;
	private String area;
	private String requisito;
	public Curso(String nRC, String nombre, int numSemestre, int cantCreditos, String area) {
		super();
		NRC = nRC;
		this.nombre = nombre;
		this.numSemestre = numSemestre;
		this.cantCreditos = cantCreditos;
		this.area = area;
	}
	
	
	
	
	//Source
	
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
	public String getRequisito() {
		return requisito;
	}
	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}
	@Override
	public String toString() {
		return "Curso [NRC=" + NRC + ", nombre=" + nombre + ", numSemestre=" + numSemestre + ", cantCreditos="
				+ cantCreditos + ", area=" + area + ", requisito=" + requisito + "]";
	}
	
	

}
