package Dominio;
public class Registro {
	protected Usuario estudiante;
	protected Certificacion certificacion;
	protected String fecha;
	protected String estado;
	protected String progreso;
	
	public Registro(Usuario estudiante, Certificacion certificacion, String fecha, String estado, String progreso) {
		super();
		this.estudiante = estudiante;
		this.certificacion = certificacion;
		this.fecha = fecha;
		this.estado = estado;
		this.progreso = progreso;
	}
	
	public void setEstudiante(Usuario estudiante) {
		this.estudiante = estudiante;
	}
	public void setCertificacion(Certificacion certificacion) {
		this.certificacion = certificacion;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}
}
