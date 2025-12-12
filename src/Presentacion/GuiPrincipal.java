package Presentacion;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dominio.Estudiante;
import Dominio.SistemaImpl;
import Dominio.Usuario;

/**
 * Interfaz gráfica de usuario para el inicio de sesión (Login) principal del sistema AcademiCore.
 * Valida las credenciales y dirige al usuario al menú correspondiente a su rol.
 */
public class GuiPrincipal extends JFrame{
	private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;

    /**
     * Constructor para la clase GuiPrincipal.
     * Configura la ventana y los campos para el ingreso de usuario y contraseña.
     */
    public GuiPrincipal() {
        setTitle("AcademiCore - Login");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        panel.add(new JLabel("Usuario:"));
        txtUser = new JTextField();
        panel.add(txtUser);

        panel.add(new JLabel("Contraseña:"));
        txtPass = new JPasswordField();
        panel.add(txtPass);

        btnLogin = new JButton("Ingresar");
        panel.add(btnLogin);

        add(panel);
        
        btnLogin.addActionListener(e -> login());
        
    }

    /**
     * Procesa la solicitud de inicio de sesión.
     * Valida las credenciales del usuario y lanza la interfaz de menú
     * correspondiente a su rol.
     */
    private void login() {
	    String user = txtUser.getText();
	    String pass = new String(txtPass.getPassword());

	    SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
	    Usuario u = sistema.validacion(user, pass);
	    
	    if (u == null) {
	        JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
	        return;
	    }
	    
	    dispose(); 
	    
	    switch(u.getRol()) {
	    case "Admin":
	        new GuiMenuAdmin().setVisible(true);
	        break;
	    case "Coordinador":
	        new GuiMenuCoordinador(u).setVisible(true);
	        break;
	    case "Estudiante":
		    new GuiMenuEstudiante((Estudiante) u).setVisible(true);
	    	break;
	    default:
	        JOptionPane.showMessageDialog(this, "Rol de usuario no reconocido.");
	    }
	}
}