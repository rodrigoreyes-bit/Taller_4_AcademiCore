import java.util.ArrayList;

public class Factory {

	private static Factory Instancia_Unica;

	private Factory() {
	}

	public static Factory InstanciarFactory() {
		if (Instancia_Unica == null) {
			Instancia_Unica = new Factory();
		}
		return Instancia_Unica;
	}

	public Usuario crear_Usuario(String nombre, String contraseña, String rol, String infoAdicional) {

		Usuario u = new Usuario(nombre, contraseña, rol);

		if (nombre.split(".").length == 2) {
			u.setInforAdicional(infoAdicional);
		}

		return u;

	}

	public Curso crear_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area,
			String requisito) {
		Curso c = new Curso(NCR, nombre, numSemestre, cantCreditos, area);
		if (!(requisito.equals(null))) {
			String[] listaIDS = requisito.split(",");
			for (int i = 0; i < listaIDS.length; i++) {
				c.añadirRequisito(listaIDS[i]);
			}

		}

		return c;

	}

	public Estudiante crear_Estudiante(String rut, String nombre, String carrera, int numSemestre, String correo,
			String contraseña) {
		Estudiante e = new Estudiante(rut, nombre, carrera, numSemestre, correo, contraseña);
		return e;
	}

	public Certificacion crear_Certificacion(String id, String nombre, String descripcion, int requisitos,
			String validez) {
		Certificacion c = new Certificacion(id, nombre, descripcion, requisitos, validez);
		return c;
	}

	public Registro crear_Registro(ArrayList<Estudiante> estudiantes, ArrayList<Certificacion> certificaciones,
			String estudiante, String certificacion, String fecha, String estado, String progreso) {
		Estudiante estudianteBuscado = null;
		Certificacion certificadoBuscado = null;

		for (Estudiante e : estudiantes) {

			if (e.getRut().equals(estudiante)) {
				estudianteBuscado = e;

			}
		}
		for (Certificacion c : certificaciones) {
			if (c.getId().equals(certificacion)) {
				certificadoBuscado = c;
			}
		}

		if (estudianteBuscado == null || certificadoBuscado == null) {
			System.out.println("Error registro");
			return null;
		}

		Registro r = new Registro(estudianteBuscado, certificadoBuscado, fecha, estado, progreso);
		estudianteBuscado.añadirCertificaciones(certificadoBuscado);
		certificadoBuscado.añadirEstudiantes(estudianteBuscado);
		return r;

	}

	public Notas crear_Notas(ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos, String estudiante,
			String curso, double calificacion, String estado, String semestre) {
		Estudiante estudianteBuscado = null;
		Curso cursoBuscado = null;

		for (Estudiante e : estudiantes) {

			if (e.getRut().equals(estudiante)) {
				estudianteBuscado = e;

			}
		}
		for (Curso c : cursos) {
			if (c.getNRC().equals(curso)) {
				cursoBuscado = c;
			}
		}

		if (estudianteBuscado == null || cursoBuscado == null) {
			System.out.println("Error notas");
			return null;
		}
		Notas n = new Notas(estudianteBuscado, cursoBuscado, calificacion, estado, semestre);
		estudianteBuscado.añadirNota(n);
		cursoBuscado.añadirNota(n);
		
		
		return n;
	}

}
