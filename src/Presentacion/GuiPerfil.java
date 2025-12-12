package Presentacion;

import Dominio.Curso;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.SistemaImpl;

import java.awt.GridLayout;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class GuiPerfil extends JFrame {

    private SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

    public GuiPerfil(Estudiante estudiante) {
        setTitle("Perfil y Malla Curricular");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new BorderLayout(10, 10));

        JPanel panelPerfil = crearPanelPerfil(estudiante);
        add(panelPerfil, BorderLayout.NORTH);

        JPanel panelMalla = crearPanelMallaMejorado(estudiante);
        add(new JScrollPane(panelMalla), BorderLayout.CENTER); 

        pack(); 
        setLocationRelativeTo(null);
    }
    
    private static class PromedioSemestre {
        String semestre;
        double promedio;
        
        public PromedioSemestre(String semestre, double promedio) {
            this.semestre = semestre;
            this.promedio = promedio;
        }
    }
    
    private Notas buscarNota(Estudiante estudiante, String nrc) {
        for (Notas n : estudiante.getNotas()) {
            if (n.getCurso().getNRC().equals(nrc)) {
                return n;
            }
        }
        return null;
    }


    // 1. CORRECCIÓN DEL PROMEDIO GENERAL
    private ArrayList<PromedioSemestre> calcularPromedios(Estudiante estudiante) {
        ArrayList<PromedioSemestre> resultados = new ArrayList<>();
        
        double sumTotal = 0;
        int countTotal = 0;
        
        ArrayList<String> semestresUnicos = new ArrayList<>();
        
        for (Notas n : estudiante.getNotas()) {
            if (n.getEstado().equals("Aprobado") || n.getEstado().equals("Reprobado")) {
                sumTotal += n.getCalificacion();
                countTotal++;
                
                if (!semestresUnicos.contains(n.getSemestre())) {
                    semestresUnicos.add(n.getSemestre());
                }
            }
        }
        
        resultados.add(new PromedioSemestre("General", countTotal > 0 ? sumTotal / countTotal : 0.0));
        
        for (String semestre : semestresUnicos) {
            double sumSemestre = 0;
            int countSemestre = 0;
            
            for (Notas n : estudiante.getNotas()) {
                if (n.getSemestre().equals(semestre) && (n.getEstado().equals("Aprobado") || n.getEstado().equals("Reprobado"))) {
                    sumSemestre += n.getCalificacion();
                    countSemestre++;
                }
            }
            if (countSemestre > 0) {
                resultados.add(new PromedioSemestre(semestre, sumSemestre / countSemestre));
            }
        }

        return resultados;
    }


    private JPanel crearPanelPerfil(Estudiante estudiante) {
        JPanel panelInfo = new JPanel(new GridLayout(2, 4, 5, 5));
        panelInfo.setBorder(BorderFactory.createTitledBorder("Información Personal"));
        
        panelInfo.add(new JLabel("Nombre:"));
        panelInfo.add(new JLabel(estudiante.getNombre()));
        panelInfo.add(new JLabel("RUT:"));
        panelInfo.add(new JLabel(estudiante.getIdentificacion()));
        panelInfo.add(new JLabel("Carrera:"));
        panelInfo.add(new JLabel(estudiante.getCarrera()));
        panelInfo.add(new JLabel("Correo:"));
        panelInfo.add(new JLabel(estudiante.getCorreo()));
        
        ArrayList<PromedioSemestre> promedios = calcularPromedios(estudiante);
        
        JPanel panelPromedios = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelPromedios.setBorder(BorderFactory.createTitledBorder("Promedios"));
        
        for(PromedioSemestre p : promedios) {
            if (p.semestre.equals("General")) {
                panelPromedios.add(new JLabel("Promedio General: " + String.format("%.2f", p.promedio)));
            } else {
                panelPromedios.add(new JLabel(" | Semestre " + p.semestre + ": " + String.format("%.2f", p.promedio)));
            }
        }
        
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(panelInfo, BorderLayout.NORTH);
        panelSuperior.add(panelPromedios, BorderLayout.SOUTH);

        return panelSuperior;
    }

    private JPanel crearPanelMallaMejorado(Estudiante estudiante) {
        JPanel panelMalla = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10)); 
        panelMalla.setBorder(BorderFactory.createTitledBorder("Malla Curricular Mejorada"));
        
        ArrayList<Curso> cursos = sistema.getCursos();
        
        int maxSemestre = 0;
        for (Curso curso : cursos) {
            if (curso.getNumSemestre() > maxSemestre) {
                maxSemestre = curso.getNumSemestre();
            }
        }

        for (int i = 1; i <= maxSemestre; i++) {
            final int semestreActual = i;
            
            JPanel panelSemestre = new JPanel();
            panelSemestre.setLayout(new GridLayout(0, 1, 3, 3)); 
            panelSemestre.setBorder(BorderFactory.createTitledBorder("SEMESTRE " + semestreActual));
            
            boolean tieneCursos = false;
            
            for (Curso curso : cursos) {
                if (curso.getNumSemestre() == semestreActual) {
                    tieneCursos = true;
                    
                    Notas nota = buscarNota(estudiante, curso.getNRC());
                    String estado = (nota != null) ? nota.getEstado() : "Pendiente";
                    String calificacion = (nota != null) ? String.format("%.1f", nota.getCalificacion()) : "-";
                    
                    JLabel lblAsignatura = new JLabel(
                        String.format(" %s (%s) | Nota: %s | Créditos: %d", 
                                        curso.getNombre(), estado, calificacion, curso.getCantCreditos())
                    );
                    lblAsignatura.setOpaque(true);
                    lblAsignatura.setBorder(BorderFactory.createLineBorder(Color.GRAY));
                    
                    if (estado.equals("Aprobado")) {
                        lblAsignatura.setBackground(new Color(144, 238, 144));
                    } else if (estado.equals("Reprobado")) {
                        lblAsignatura.setBackground(new Color(255, 160, 122));
                    } else {
                        lblAsignatura.setBackground(Color.WHITE); 
                    }
                    
                    lblAsignatura.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                            mostrarDetallesCurso(curso.getNRC());
                        }
                    });
                    
                    panelSemestre.add(lblAsignatura);
                }
            }
            
            if (tieneCursos) {
                panelMalla.add(panelSemestre); 
            }
        }
        
        return panelMalla;
    }
    
    private void mostrarDetallesCurso(String nrc) {
        Curso curso = sistema.getCursos().stream().filter(c -> c.getNRC().equals(nrc)).findFirst().orElse(null);
        
        if (curso != null) {
            StringBuilder requisitosStr = new StringBuilder();
            if (curso.getRequisitos().isEmpty()) {
                requisitosStr.append("Ninguno");
            } else {
                for (String req : curso.getRequisitos()) {
                    Curso reqCurso = sistema.getCursos().stream().filter(c -> c.getNRC().equals(req)).findFirst().orElse(null);
                    requisitosStr.append(reqCurso != null ? reqCurso.getNombre() : req).append(", ");
                }
                if (requisitosStr.length() > 0) {
                    requisitosStr.setLength(requisitosStr.length() - 2); 
                }
            }

            String mensaje = String.format(
                "<html><b>NRC:</b> %s<br>" +
                "<b>Nombre:</b> %s<br>" +
                "<b>Área:</b> %s<br>" +
                "<b>Créditos:</b> %d<br>" +
                "<b>Requisitos:</b> %s<br>" +
                "<b>Certificación Asociada:</b> %s</html>",
                curso.getNRC(),
                curso.getNombre(),
                curso.getArea(),
                curso.getCantCreditos(),
                requisitosStr.toString(),
                curso.getCertificacion() != null ? curso.getCertificacion().getNombre() : "N/A"
            );
            
            JOptionPane.showMessageDialog(this, mensaje, "Detalles de Asignatura: " + curso.getNombre(), JOptionPane.INFORMATION_MESSAGE);
        }
    }
}