package Presentacion;

import javax.swing.*;
import java.awt.*;
import Dominio.*;

public class GuiMenuCoordinador extends JFrame {

    SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

    public GuiMenuCoordinador(Usuario coordinador) {

        setTitle("Menú Coordinador");
        setSize(450, 500);
        setLayout(new GridLayout(8, 1, 5, 5));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // ---- BLOQUE 1: Gestión de Certificaciones ----
        JButton btnModificarLinea = new JButton("Modificar línea de certificación");
        JButton btnGenerarCertificados = new JButton("Generar certificados para estudiantes");

        // ---- BLOQUE 2: Panel de Métricas y Análisis ----
        JButton btnEstadisticas = new JButton("Estadísticas de inscripciones");
        JButton btnAnalisisCriticas = new JButton("Análisis de asignaturas críticas");

        // ---- BLOQUE 3: Gestión de Estudiantes ----
        JButton btnPerfilEstudiante = new JButton("Consultar perfiles completos");
        JButton btnValidarAvance = new JButton("Validar avances académicos");

        // ---- Cerrar sesión ----
        JButton btnCerrar = new JButton("Cerrar sesión");

        add(btnModificarLinea);
        add(btnGenerarCertificados);
        add(btnEstadisticas);
        add(btnAnalisisCriticas);
        add(btnPerfilEstudiante);
        add(btnValidarAvance);
        add(btnCerrar);

        // ---------------------------
        // ACCIONES DE LOS BOTONES
        // ---------------------------

        btnModificarLinea.addActionListener(e -> modificarLineaCertificacion());

        /*
         * btnGenerarCertificados.addActionListener(e -> generarCertificados());

        btnEstadisticas.addActionListener(e -> estadisticasInscripciones());

        btnAnalisisCriticas.addActionListener(e -> analisisAsignaturasCriticas());

        btnPerfilEstudiante.addActionListener(e -> perfilEstudiante());

        btnValidarAvance.addActionListener(e -> validarAvances().);

        btnCerrar.addActionListener(e -> { new GuiPrincipal().setVisible(true);
        });
         */
        
    }
    
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
                if (!txtReq.getText().isEmpty()) c.requisitos = Integer.parseInt(txtReq.getText());
                if (!txtValidez.getText().isEmpty()) c.validez = txtValidez.getText();

                JOptionPane.showMessageDialog(null, "Certificación actualizada con éxito");
                frame.setVisible(false);
            }
        });
        frame.setVisible(true);
    }
}
