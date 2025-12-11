package Logica;

public interface Sistema {
	
	public void lectura_Usuario(String nombre, String contraseña, String rol, String infoAdicional);
	public void lectura_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area, String requisito);
	public void lectura_Estudiante(String rut, String nombre, String carrera, int numSemestre, String correo, String contraseña);
	public void lectura_Certificacion(String id, String nombre, String descripcion, int requisitos, String validez);
	public void lectura_Registro(String estudiante, String certificacion, String fecha, String estado, String progreso);
	public void lectura_Notas(String estudiante, String curso, double calificacion, String estado, String semestre);
	public void asignacion_Certificacion(String id,String nrc);
	
	//Admin
	//public String 
	
	
	
	
	
	
	
}
