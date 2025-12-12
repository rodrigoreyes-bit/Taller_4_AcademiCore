/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Logica;

import Dominio.Usuario;

public interface Sistema {
	
	public void lectura_Usuario(String [] partes);
	public void lectura_Estudiante(String [] partes);
	public void lectura_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area, String requisito);
	public void lectura_Certificacion(String id, String nombre, String descripcion, int requisitos, String validez);
	public void lectura_Registro(String estudiante, String certificacion, String fecha, String estado, String progreso);
	public void lectura_Notas(String estudiante, String curso, double calificacion, String estado, String semestre);
	public void asignacion_Certificacion(String id,String nrc);
	
	public Usuario validacion(String nombre, String contraseña);
	public void login();
	
}
