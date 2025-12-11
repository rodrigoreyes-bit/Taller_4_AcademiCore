package Presentacion;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GuiMenuAdmin extends JFrame{
	
	 public GuiMenuAdmin() {
	        setTitle("Menú Administrador");
	        setSize(500, 400);
	        setLayout(new GridLayout(4, 2));
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        
	        JButton btnCursos = new JButton("Gestionar Cursos");
	        JButton btnEstudiantes = new JButton("Gestionar Estudiantes");
	        JButton btnCertificaciones = new JButton("Gestionar Certificaciones");
	        JButton btnRegistros = new JButton("Gestionar Registros");
	        JButton btnNotas = new JButton("Gestionar Notas");
	        JButton btnUsuarios = new JButton("Gestionar Usuarios");
	        JButton btnVolver = new JButton("Cerrar Sesión");

	        add(btnCursos);
	        add(btnEstudiantes);
	        add(btnCertificaciones);
	        add(btnRegistros);
	        add(btnNotas);
	        add(btnUsuarios);
	        add(btnVolver);

	        btnVolver.addActionListener(e -> {
	            new GuiPrincipal().setVisible(true);
	        });
	    }
}
