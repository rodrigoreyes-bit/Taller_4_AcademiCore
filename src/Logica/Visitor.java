package Logica;

import Dominio.Certificacion;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.SistemaImpl;

/**
 * Implementa el patrón Visitor para ejecutar operaciones específicas sobre el progreso
 * del estudiante en diferentes tipos de certificaciones.
 * Centraliza la lógica de cálculo de requisitos y promedios por tipo de certificación.
 */
public class Visitor {
	
	 private SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

	    /**
	     * Realiza una acción de conteo, típicamente usada para certificaciones genéricas.
	     * Calcula cuántos cursos asociados a la certificación le faltan por aprobar al estudiante.
	     *
	     * @param cert La certificación que se está visitando.
	     * @param est El estudiante cuyo progreso se está evaluando.
	     * @return Una cadena de texto indicando el número de cursos pendientes.
	     */
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

	    /**
	     * Realiza una acción de cálculo, típicamente usada para certificaciones especializadas.
	     * Calcula el promedio de las notas de los cursos aprobados asociados a la certificación.
	     *
	     * @param cert La certificación que se está visitando.
	     * @param est El estudiante cuyo progreso se está evaluando.
	     * @return Una cadena de texto indicando el promedio de notas de los cursos asociados.
	     */
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