package Presentacion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import Dominio.*;

/**
 * Interfaz gráfica de usuario para el Menú del Coordinador.
 * Proporciona funcionalidades para la gestión de certificaciones, generación de reportes,
 * validación de avance académico y análisis de asignaturas críticas.
 */
public class GuiMenuCoordinador extends JFrame {

    SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

    /**
     * Constructor para la clase GuiMenuCoordinador.
     * Configura la ventana principal con las opciones de gestión.
     * @param coordinador El usuario Coordinador que ha iniciado sesión.
     */
    public GuiMenuCoordinador(Usuario coordinador) {

        setTitle("Menú Coordinador");
        setSize(450, 700);
        setLayout(new GridLayout(8, 1, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton btnModificarLinea = new JButton("Modificar línea de certificación");
        JButton btnGenerarCertificados = new JButton("Generar certificados para estudiantes");
        
        JButton btnEstadisticas = new JButton("Estadísticas de inscripciones");
        JButton btnAnalisisCriticas = new JButton("Análisis de asignaturas críticas");

        JButton btnPerfilEstudiante = new JButton("Consultar perfiles completos");
        JButton btnValidarAvance = new JButton("Validar avances académicos");

        JButton btnCerrar = new JButton("Cerrar sesión");

        add(btnModificarLinea);
        add(btnGenerarCertificados);
        add(btnEstadisticas);
        add(btnAnalisisCriticas);
        add(btnPerfilEstudiante);
        add(btnValidarAvance);
        add(btnCerrar);

        btnModificarLinea.addActionListener(e -> modificarLineaCertificacion());
        btnGenerarCertificados.addActionListener(e -> generarCertificados());
        btnEstadisticas.addActionListener(e -> estadisticasInscripciones());
        btnAnalisisCriticas.addActionListener(e -> analisisAsignaturasCriticas());
        btnPerfilEstudiante.addActionListener(e -> perfilEstudiante());
        btnValidarAvance.addActionListener(e -> validarAvances());
        btnCerrar.addActionListener(e -> { new GuiPrincipal().setVisible(true);
        });
    }
    
    /**
     * Abre una ventana para validar el avance académico de un estudiante seleccionado.
     * Muestra los cursos aprobados y reprobados, y verifica si completó la línea de certificación.
     */
    private void validarAvances() {
    	JFrame frame = new JFrame();
    	frame.setTitle("Validar Avances Académicos");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(2, 1));

        JComboBox<String> combo = new JComboBox<>();
        JTextArea info = new JTextArea();
        info.setEditable(false);

        for (Estudiante e : sistema.getEstudiantes()) {
            combo.addItem(e.getIdentificacion());
        }

        frame.add(combo);
        frame.add(new JScrollPane(info));

        combo.addActionListener(e -> {
            Estudiante est = sistema.buscarEstudiante((String) combo.getSelectedItem());

            if (est != null) {
                StringBuilder s = new StringBuilder();

                s.append("Avance académico de: ").append(est.getNombre()).append("\n\n");

                s.append("Cursos aprobados:\n");
                for (Notas n : est.getNotas()) {
                    if (n.getCalificacion() >= 4.0) {
                        s.append(" - ").append(n.getCurso().nombre).append("\n");
                    }
                }

                s.append("\nCursos reprobados:\n");
                for (Notas n : est.getNotas()) {
                    if (n.getCalificacion() < 4.0) {
                        s.append(" x ").append(n.getCurso().nombre).append("\n");
                    }
                }

                s.append("\n¿Completó la línea de certificación?: ");
                if (sistema.estudianteCompletoLinea(est)) {
                	s.append("SÍ");
                } else {
                	s.append("NO");
                }

                info.setText(s.toString());
            }
        });
        frame.setVisible(true);
    }

    /**
     * Abre una ventana para consultar el perfil completo de un estudiante seleccionado,
     * incluyendo información personal, certificaciones inscritas y notas detalladas.
     */
	private void perfilEstudiante() {
		JFrame frame = new JFrame();
		frame.setTitle("Perfil de Estudiante");
        frame.setSize(500, 500);
        frame.setLayout(new GridLayout(2, 1));
        frame.setLocationRelativeTo(null);

        JComboBox<String> combo = new JComboBox<>();
        JTextArea info = new JTextArea();
        info.setEditable(false);

        for (Estudiante e : sistema.getEstudiantes()) {
            combo.addItem(e.getIdentificacion());
        }

        frame.add(combo);
        frame.add(new JScrollPane(info));

        combo.addActionListener(e -> {
            Estudiante est = sistema.buscarEstudiante((String) combo.getSelectedItem());
            if (est != null) {
                StringBuilder s = new StringBuilder();
                s.append("Nombre: ").append(est.getNombre()).append("\n");
                s.append("Carrera: ").append(est.getCarrera()).append("\n");
                s.append("Semestre: ").append(est.getNumSemestre()).append("\n\n");

                s.append("CERTIFICACIONES:\n");
                for (Certificacion c : est.getCertificaciones()) {
                    s.append(" - ").append(c.nombre).append("\n");
                }

                s.append("\nNOTAS:\n");
                for (Notas n : est.getNotas()) {
                    s.append(n.getCurso().nombre)
                     .append(" : ")
                     .append(n.getCalificacion())
                     .append(" (")
                     .append(n.getEstado())
                     .append(")\n");
                }

                info.setText(s.toString());
            }
        });
        frame.setVisible(true);
    }

    /**
     * Abre una ventana que muestra un análisis de asignaturas críticas.
     * Lista todos los cursos y el número de veces que han sido reprobados.
     */
	private void analisisAsignaturasCriticas() {
		JFrame frame = new JFrame();
		frame.setTitle("Análisis de Asignaturas Críticas");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        String[] columnas = {"NRC", "Asignatura", "Reprobaciones"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Curso c : sistema.getCursos()) {
            modelo.addRow(new Object[]{
                c.NRC,
                c.nombre,
                c.getNumReprobaciones()
            });
        }

        JTable tabla = new JTable(modelo);
        frame.add(new JScrollPane(tabla), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Abre una ventana que muestra estadísticas de inscripción por certificación.
     * Muestra el nombre de la certificación y la cantidad de estudiantes inscritos.
     */
	private void estadisticasInscripciones() {
		JFrame frame = new JFrame();
		frame.setTitle("Estadísticas de Inscripciones");
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);

        String[] columnas = {"Certificación", "Inscritos"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        for (Certificacion c : sistema.getCertificaciones()) {
            modelo.addRow(new Object[]{
                c.nombre,
                c.getEstudiantesInscritos().size()
            });
        }

        JTable tabla = new JTable(modelo);
        frame.add(new JScrollPane(tabla), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    /**
     * Abre una ventana que permite generar certificados para todos los estudiantes
     * que han cumplido con los requisitos de la línea de certificación en la que están inscritos.
     */
	private void generarCertificados() {
	    JFrame frame = new JFrame();
	    frame.setTitle("Generar Certificados");
	    frame.setSize(400, 200);
	    frame.setLayout(new GridLayout(2, 1, 10, 10));
	    frame.setLocationRelativeTo(null);

	    JButton btnGenerar = new JButton("Generar certificados");
	    JTextArea resultado = new JTextArea();
	    resultado.setEditable(false);

	    frame.add(btnGenerar);
	    frame.add(new JScrollPane(resultado));

	    btnGenerar.addActionListener(e -> {
	        resultado.setText("");
	        boolean alguno = false;

	        for (Estudiante est : sistema.getEstudiantes()) {
	            if (sistema.estudianteCompletoLinea(est)) {
	                resultado.append("Certificado generado para: " + est.getNombre() + "\n");
	                alguno = true;
	            }
	        }

	        if (alguno) {
	            JOptionPane.showMessageDialog(null, "Certificados generados con éxito!!");
	        } else {
	            JOptionPane.showMessageDialog(null, "No hay estudiantes que cumplan la línea.");
	        }
	    });

	    frame.setVisible(true);
	}

    /**
     * Abre una ventana que permite modificar los atributos principales de una línea de certificación
     * seleccionada (nombre, descripción, requisitos y validez).
     */
	public void modificarLineaCertificacion() {
    	
    	JFrame frame = new JFrame();
        frame.setTitle("Modificar Línea de Certificación");
        frame.setSize(400, 350);
        frame.setLayout(new GridLayout(6, 2, 5, 5));
        frame.setLocationRelativeTo(null);

        JLabel lblId = new JLabel("ID:");
        JComboBox<String> comboId = new JComboBox<>();

        for (Certificacion c : sistema.getCertificaciones()) {
            comboId.addItem(c.getId());
        }

        JLabel lblNombre = new JLabel("Nuevo nombre:");
        JTextField txtNombre = new JTextField();

        JLabel lblDesc = new JLabel("Nueva descripción:");
        JTextField txtDesc = new JTextField();

        JLabel lblReq = new JLabel("Nuevos requisitos (número):");
        JTextField txtReq = new JTextField();

        JLabel lblValidez = new JLabel("Validez:");
        JTextField txtValidez = new JTextField();

        JButton btnGuardar = new JButton("Guardar Cambios");

        frame.add(lblId); 
        frame.add(comboId);
        
        frame.add(lblNombre); 
        frame.add(txtNombre);
        
        frame.add(lblDesc); 
        frame.add(txtDesc);
        
        frame.add(lblReq); 
        frame.add(txtReq);
        
        frame.add(lblValidez); 
        frame.add(txtValidez);
        
        frame.add(new JLabel()); 
        frame.add(btnGuardar);

        btnGuardar.addActionListener(e -> {
            String id = (String) comboId.getSelectedItem();
            Certificacion c = sistema.buscarCertificacion(id);

            if (c != null) {
                if (!txtNombre.getText().isEmpty()) c.nombre = txtNombre.getText();
                if (!txtDesc.getText().isEmpty()) c.descripcion = txtDesc.getText();
                if (!txtReq.getText().isEmpty()) {
                    try {
                        c.requisitos = Integer.parseInt(txtReq.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "El requisito debe ser un número entero.");
                        return;
                    }
                }
                if (!txtValidez.getText().isEmpty()) c.validez = txtValidez.getText();

                JOptionPane.showMessageDialog(null, "Certificación actualizada con éxito!!");
                frame.setVisible(false);
            }
        });
        frame.setVisible(true);
    }
}