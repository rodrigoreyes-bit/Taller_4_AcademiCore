package Presentacion;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import Dominio.Estudiante;

public class GuiMenuEstudiante extends JFrame {
	
	
	 public GuiMenuEstudiante(Estudiante estudiante) {
		 
	    setTitle("Menú Estudiante - " + estudiante.getNombre());
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	    setSize(450, 400);
	    setLayout(new GridLayout(5, 1, 10, 10)); 

	    JButton btnPerfilMalla = new JButton("Perfil y Malla Curricular");
	    
	    JButton btnInscripcion = new JButton("Inscripción a Certificaciones");
	    
	    JButton btnProgreso = new JButton("Seguimiento de Progreso");
	    
	    JButton btnCerrar = new JButton("Cerrar Sesión");

	    add(btnPerfilMalla);
	    add(btnInscripcion);
	    add(btnProgreso);
	    add(btnCerrar);
	        
	    btnPerfilMalla.addActionListener(e -> {
	        new GuiPerfil(estudiante).setVisible(true);
	    });
	    
	    btnInscripcion.addActionListener(e -> {
	        new GuiInscripcion(estudiante).setVisible(true);

	    });
	    
	    btnProgreso.addActionListener(e -> {
	        new GuiSeguimiento(estudiante).setVisible(true);

	    });
	    
	    btnCerrar.addActionListener(e -> {
	        dispose(); 
	        new GuiPrincipal().setVisible(true); 
	    });
	    
	    setLocationRelativeTo(null); 
	}
}
