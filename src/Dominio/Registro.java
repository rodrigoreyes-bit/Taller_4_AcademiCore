package Dominio;
public class Registro {
	protected Estudiante estudiante;
	protected Certificacion certificacion;
	protected String fecha;
	protected String estado;
	protected String progreso;
	
	public Registro(Estudiante estudiante, Certificacion certificacion, String fecha, String estado, String progreso) {
		super();
		this.estudiante = estudiante;
		this.certificacion = certificacion;
		this.fecha = fecha;
		this.estado = estado;
		this.progreso = progreso;
	}
	
	//Source
	
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Certificacion getCertificacion() {
		return certificacion;
	}
	public void setCertificacion(Certificacion certificacion) {
		this.certificacion = certificacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getProgreso() {
		return progreso;
	}
	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}
	@Override
	public String toString() {
		return "Registro [estudiante=" + estudiante + ", certificacion=" + certificacion + ", fecha=" + fecha
				+ ", estado=" + estado + ", progreso=" + progreso + "]";
	}
	
	

}
