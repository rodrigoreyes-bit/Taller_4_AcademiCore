
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Presentacion;
import Dominio.Certificacion;
import Dominio.Curso;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.SistemaImpl;
import Logica.Visitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


/**
 * Interfaz gráfica de usuario para el Seguimiento de Progreso del Estudiante en las certificaciones.
 * Muestra las certificaciones inscritas (Dashboard), aplica el patrón Visitor para acciones
 * específicas y lista las asignaturas que faltan por aprobar.
 */   
public class GuiSeguimiento extends JFrame {

    private Estudiante estudiante;
    private SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
    private Visitor visitor = new Visitor();
    private JList<String> listaCertificaciones;
    private JTextArea txtProgreso;

    /**
     * Constructor para la clase GuiSeguimiento.
     * Configura la ventana principal con el listado de certificaciones inscritas.
     * @param estudiante El estudiante cuyo progreso se va a seguir.
     */
    public GuiSeguimiento(Estudiante estudiante) {
        this.estudiante = estudiante;
        setTitle("Seguimiento de Progreso");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout(10, 10));

        JPanel panelLista = crearPanelCertificaciones();
        add(panelLista, BorderLayout.WEST);

        txtProgreso = new JTextArea("Seleccione una certificación para ver su progreso y asignaturas pendientes.");
        txtProgreso.setEditable(false);
        txtProgreso.setLineWrap(true);
        txtProgreso.setWrapStyleWord(true);
        add(new JScrollPane(txtProgreso), BorderLayout.CENTER);

        configurarAcciones();
        setLocationRelativeTo(null);
    }

    /**
     * Crea el panel que muestra el dashboard personal con el progreso en certificaciones inscritas.
     * @return El JPanel con la JList de certificaciones.
     */
    private JPanel crearPanelCertificaciones() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Certificaciones Inscritas"));

        DefaultListModel<String> model = new DefaultListModel<>();
        for (Certificacion cert : estudiante.getCertificaciones()) {
            long cursosAprobados = 0;
            for (Notas n : estudiante.getNotas()) {
                if (n.getEstado().equals("Aprobado") && n.getCurso().getCertificacion() != null && n.getCurso().getCertificacion().getId().equals(cert.getId())) {
                    cursosAprobados++;
                }
            }
            
            String progreso = String.format(" (%d/%d cursos) ", cursosAprobados, cert.getRequisitos());
            model.addElement(cert.getNombre() + progreso);
        }

        listaCertificaciones = new JList<>(model);
        listaCertificaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        panel.add(new JScrollPane(listaCertificaciones), BorderLayout.CENTER);
        return panel;
    }
    
    /**
     * Configura el Listener para la JList, que se activa al seleccionar una certificación.
     * Ejecuta el Visitor y muestra las asignaturas pendientes.
     */
    private void configurarAcciones() {
        listaCertificaciones.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && listaCertificaciones.getSelectedIndex() != -1) {
                String nombreProgreso = listaCertificaciones.getSelectedValue();
                String nombreCert = nombreProgreso.split(" \\(")[0]; 
                
                Certificacion cert = null;
                for (Certificacion c : sistema.getCertificaciones()) {
                    if (c.getNombre().equals(nombreCert)) {
                        cert = c;
                        break;
                    }
                }
                
                if (cert != null) {
                    StringBuilder sb = new StringBuilder();
                    
                    String tipo = cert.getId().startsWith("E") ? "Especializada" : "Genérica"; 
                    String visitorResult = (tipo.equals("Especializada")) 
                                            ? visitor.visitarCertificacion2(cert, estudiante)
                                            : visitor.visitarCertificacion1(cert, estudiante);
                    
                    sb.append("Visitor (Tipo ").append(tipo).append(") \n");
                    sb.append(visitorResult).append("\n\n");
                    
                    sb.append("Asignaturas Pendientes \n");
                    ArrayList<Curso> cursosPendientes = new ArrayList<>();
                    
                    ArrayList<Curso> cursosAsociados = new ArrayList<>();
                    for (Curso c : sistema.getCursos()) {
                        if (c.getCertificacion() != null && c.getCertificacion().getId().equals(cert.getId())) {
                            cursosAsociados.add(c);
                        }
                    }
                    
                    for (Curso curso : cursosAsociados) {
                        boolean aprobado = false;
                        for (Notas n : estudiante.getNotas()) {
                            if (n.getCurso().getNRC().equals(curso.getNRC()) && n.getEstado().equals("Aprobado")) {
                                aprobado = true;
                                break;
                            }
                        }
                        
                        if (!aprobado) {
                            cursosPendientes.add(curso);
                        }
                    }

                    if (cursosPendientes.isEmpty()) {
                        sb.append("Ya tiene todos los cursos asociados aprobados");
                    } else {
                        for (Curso curso : cursosPendientes) {
                            sb.append("- ").append(curso.getNombre()).append(" (NRC: ").append(curso.getNRC()).append(")\n");
                        }
                    }
                    
                    txtProgreso.setText(sb.toString());
                }
            }
        });
    }
}