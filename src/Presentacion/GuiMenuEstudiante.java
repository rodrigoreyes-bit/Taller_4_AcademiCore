package Presentacion;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import Dominio.Estudiante;
import Dominio.SistemaImpl;

public class GuiMenuEstudiante extends JFrame{
	
	SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
	
	 public GuiMenuEstudiante(Estudiante estudiante) {
	        setTitle("Menú Estudiante");
	        setSize(400, 300);
	        setLayout(new GridLayout(3, 1));

	        JButton btnProgreso = new JButton("Ver progreso en certificaciones");
	        JButton btnCursos = new JButton("Ver cursos aprobados");
	        JButton btnCerrar = new JButton("Cerrar sesión");

	        add(btnProgreso);
	        add(btnCursos);
	        add(btnCerrar);
	        
	        //btnProgreso.addActionListener(e -> sistema.);
	        //btnCursos.addActionListener(e -> sistema.);
	        
	        btnCerrar.addActionListener(e -> {
	        new GuiPrincipal().setVisible(true);
	        });
	    }
}
