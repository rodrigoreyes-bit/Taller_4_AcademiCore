package Logica;
import java.util.ArrayList;

import Dominio.Admin;
import Dominio.Certificacion;
import Dominio.Coordinador;
import Dominio.Curso;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.Registro;
import Dominio.Usuario;


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

	public Usuario crear_Usuario(String [] partes) {
		String username = partes[0];
		String contraseña = partes[1];
		String rol = partes[2];
		
		
		switch(rol) {
		case "Admin":
			Admin a = new Admin(username, contraseña, rol);
			return a;
			
		case "Coordinador":
			String infoExtra = partes[3];
			Coordinador c = new Coordinador(username, contraseña, rol, infoExtra);
			return c;
		}
		return null;
	}

	public Curso crear_Curso(String NCR, String nombre, int numSemestre, int cantCreditos, String area,
			String requisito) {
		Curso c = new Curso(NCR, nombre, numSemestre, cantCreditos, area);
		if (requisito != null) {
			
			String[] listaIDS = requisito.split(",");
			for (int i = 0; i < listaIDS.length; i++) {
				c.añadirRequisito(listaIDS[i]);
			}
		}
		return c;
	}

	public Estudiante crear_Estudiante(String [] partes) {
		String rut = partes[0];
		String nombre = partes[1];
		String carrera = partes[2];
		int semestre = Integer.valueOf(partes[3]);
		String correo = partes[4];
		String contraseña = partes[5];
		
		Estudiante e = new Estudiante(rut, contraseña, "Estudiante", nombre, carrera, semestre, correo);
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

			if (e.username.equals(estudiante)) {
				estudianteBuscado = e;
			}
		}
		for (Certificacion c : certificaciones) {
			if (c.id.equals(certificacion)) {
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

	public Notas crear_Notas(ArrayList<Estudiante> estudiantes, ArrayList<Curso> cursos, String rut,
			String codigoAsignatura, double calificacion, String estado, String semestre) {
		
		Estudiante estudianteBuscado = null;
		Curso cursoBuscado = null;

		for (Estudiante e : estudiantes) {

			if (e.username.equals(rut)) {
				estudianteBuscado = e;
			}
		}
		for (Curso c : cursos) {
			if (c.NRC.equals(codigoAsignatura)) {
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
