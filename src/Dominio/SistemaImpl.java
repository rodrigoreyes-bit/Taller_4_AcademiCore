package Dominio;
import java.util.ArrayList;

import Logica.Sistema;
import Presentacion.GuiPrincipal;

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
		cursos.add(factory.crear_Curso(NCR, nombre, numSemestre, cantCreditos, area, requisito));
	}

	@Override
	public void lectura_Estudiante(String rut, String nombre, String carrera, int numSemestre, String correo,
			String contraseña) {
		estudiantes.add(factory.crear_Estudiante(rut, nombre, carrera, numSemestre, correo, contraseña));

	}

	@Override
	public void lectura_Certificacion(String id, String nombre, String descripcion, int requisitos, String validez) {
		certificaciones.add(factory.crear_Certificacion(id, nombre, descripcion, requisitos, validez));
	}

	@Override
	public void lectura_Registro(String estudiante, String certificacion, String fecha, String estado,
			String progreso) {
		
		registros.add(factory.crear_Registro(estudiantes, certificaciones, estudiante, certificacion, fecha, estado, progreso));

	}

	@Override
	public void lectura_Notas(String estudiante, String curso, double calificacion, String estado, String semestre) {
		notas.add(factory.crear_Notas(estudiantes, cursos, estudiante, curso, calificacion, estado, semestre));
	}

	@Override
	public void asignacion_Certificacion(String id, String nrc) {
		Certificacion certificadoBuscado = null;
		Curso cursoBuscado = null;
		for (Certificacion c : certificaciones) {
			if (c.getId().equals(id)) {
				certificadoBuscado = c;
			}
		}
		for (Curso c : cursos) {
			if (c.getNRC().equals(nrc)) {
				cursoBuscado = c;
			}
		}
		if (certificadoBuscado == null || cursoBuscado == null) {
			System.out.println("Error asignacion");
			;
		}
		cursoBuscado.setCertificacion(certificadoBuscado);
	}

	@Override
	public Usuario validacion(String nombre, String contraseña) {
		new GuiPrincipal().setVisible(true);
	    for (Usuario u : usuarios) {
	        if (u.nombre.equals(nombre) && u.contraseña.equals(contraseña)) {
	            return u;
	        }
	    }
	    return null;
	}
	

	@Override
	public void login() {
		GuiPrincipal principal = new GuiPrincipal();
		principal.setVisible(true);
		
	}


}
