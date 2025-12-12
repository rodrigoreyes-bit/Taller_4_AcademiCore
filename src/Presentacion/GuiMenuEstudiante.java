package Presentacion;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import Dominio.Estudiante;

/**
 * Interfaz gráfica de usuario para el Menú Principal del Estudiante.
 * Proporciona acceso a las principales funcionalidades: Perfil Académico/Malla,
 * Inscripción a Certificaciones y Seguimiento de Progreso.
 */
public class GuiMenuEstudiante extends JFrame {
	
	
	/**
	 * Constructor para la clase GuiMenuEstudiante.
	 * Configura la ventana principal con los botones de navegación.
	 * * @param estudiante El objeto Estudiante que ha iniciado sesión, cuyos datos se usarán para el título.
	 */
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
	        // Asume que GuiPerfil contiene la lógica de Perfil del Estudiante y Malla Curricular
	        new GuiPerfil(estudiante).setVisible(true);
	    });
	    
	    btnInscripcion.addActionListener(e -> {
	        // Asume que GuiInscripcion contiene la lógica de Inscripción a Certificaciones
	        new GuiInscripcion(estudiante).setVisible(true);

	    });
	    
	    btnProgreso.addActionListener(e -> {
	        // Asume que GuiSeguimiento contiene la lógica de Seguimiento de Progreso
	        new GuiSeguimiento(estudiante).setVisible(true);

	    });
	    
	    btnCerrar.addActionListener(e -> {
	        dispose(); 
	        // Asume que GuiPrincipal es la ventana de inicio de sesión
	        new GuiPrincipal().setVisible(true); 
	    });
	    
	    setLocationRelativeTo(null); 
	}
}