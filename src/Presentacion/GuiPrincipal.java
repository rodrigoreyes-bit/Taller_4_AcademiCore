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

public class GuiPrincipal extends JFrame{
	private JTextField txtUser;
    private JPasswordField txtPass;
    private JButton btnLogin;

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

    private void login() {
	    String user = txtUser.getText();
	    String pass = new String(txtPass.getPassword());

	    SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
	    Usuario u = sistema.validacion(user, pass);

	    if (u == null) {
	        JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
	        return;
	    }

	    // si es admin
	    if (u.getRol().equalsIgnoreCase("Aministrador")) {
	        new GuiMenuAdmin().setVisible(true);
	        return;
	    }
	    
	    if (u.getRol().equals("Coordinador")) {
	    	//gui coordinador
	    }

	    // hacer la logica si es estudiante
	    //if 
	    //new GuiMenuEstudiante(e).setVisible(true);
	    // return
	}
}
