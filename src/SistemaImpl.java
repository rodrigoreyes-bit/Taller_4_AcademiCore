import java.util.ArrayList;

public class SistemaImpl implements Sistema {
	public ArrayList<Usuario> usuarios = new ArrayList<>();
	public ArrayList<Curso> cursos = new ArrayList<>();
	public ArrayList<Estudiante> estudiantes = new ArrayList<>();
	public ArrayList<Certificacion> certificaciones = new ArrayList<>();
	public ArrayList<Registro> registros = new ArrayList<>();
	public ArrayList<Notas> notas = new ArrayList<>();
	public Factory factory = Factory.InstanciarFactory();
	private static SistemaImpl Instancia_Unica;
	
	private SistemaImpl() {
	}

	public static SistemaImpl InstanciarSistemaImpl() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new SistemaImpl();
		}
		return Instancia_Unica;
	}
	

	@Override
	public void lectura_Usuario(String nombre, String contraseña, String rol, String infoAdicional) {
		usuarios.add(factory.crear_Usuario(nombre, contraseña, rol, infoAdicional));
	}

	@Override
	public void lectura_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area,
			String requisito) {

	}

	@Override
	public void lectura_Estudiante(String rut, String nombre, String carrera, int numSemestre, String correo,
			String contraseña) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lectura_Certificacion(String id, String nombre, String descripcion, String requisitos, String validez) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lectura_Registro(String estudiante, String certificacion, String fecha, String estado,
			String progreso) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lectura_Notas(String estudiante, String curso, double calificacion, String estado, String semestre) {
		// TODO Auto-generated method stub

	}

	@Override
	public void asignacion_Certificacion(String id, String nrc) {
		// TODO Auto-generated method stub

	}

}
