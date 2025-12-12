package Logica;

import Dominio.Certificacion;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.SistemaImpl;

public class Visitor {
	
	 private final SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

	    public String visitarCertificacion1(Certificacion cert, Estudiante est) {
	        long pendientes = 0;
	        for (Notas n : est.getNotas()) {
	            if (n.curso.getCertificacion() != null && n.curso.getCertificacion().getId().equals(cert.getId())) {
	                if (!n.estado.equals("Aprobado")) {
	                    pendientes++;
	                }
	            }
	        }
	        
	        return String.format("Visitor: Faltan %d cursos para completar los requisito.", pendientes);
	    }

	    public String visitarCertificacion2(Certificacion cert, Estudiante est) {
	        double sumNotas = 0.0;
	        int countNotas = 0;
	        
	        for (Notas n : est.getNotas()) {
	            if (n.curso.getCertificacion() != null && n.curso.getCertificacion().getId().equals(cert.getId())) {
	                if (n.estado.equals("Aprobado")) {
	                    sumNotas += n.calificacion;
	                    countNotas++;
	                }
	            }
	        }
	        
	        double promedio = countNotas > 0 ? sumNotas / countNotas : 0.0;
	        
	        return String.format("Visitor: Promedio de cursos asociados: %.2f. Requisito adicional: Promedio 4.0", promedio);
	    }
	}


