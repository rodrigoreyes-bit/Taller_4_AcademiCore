package Presentacion;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Dominio.Coordinador;
import Dominio.Estudiante;
import Dominio.SistemaImpl;
import Dominio.Usuario;

public class GuiMenuAdmin extends JFrame {
	SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();

	public GuiMenuAdmin() {
		setTitle("Menú Administrador");
		setTitle("Gestión de Usuarios");
		setSize(600, 400);
		setLocationRelativeTo(null);
		setLayout(new GridLayout(6, 1, 10, 10));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JButton btnCrear = new JButton("Crear cuenta");
		JButton btnModificar = new JButton("Modificar cuenta");
		JButton btnEliminar = new JButton("Eliminar cuenta");
		JButton btnResetContra = new JButton("Restablecer Contraseña");
		JButton btnVolver = new JButton("Volver");

		add(btnCrear);
		add(btnModificar);
		add(btnEliminar);
		add(btnResetContra);
		add(btnVolver);

		btnCrear.addActionListener(e -> crearCuenta());
		btnModificar.addActionListener(e -> modificarCuenta());
		btnEliminar.addActionListener(e -> eliminarCuenta());
		btnResetContra.addActionListener(e -> resetContraseña());

		btnVolver.addActionListener(e -> dispose());
	}

	private void crearCuenta() {
	    JFrame frame = new JFrame("Crear Cuenta");
	    frame.setSize(450, 450);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(new GridLayout(2, 1, 10, 10));

	    JPanel panelTop = new JPanel(new GridLayout(2, 2, 5, 5));
	    JPanel panelForm = new JPanel(new GridLayout(10, 2, 5, 5));

	    JLabel lblTipo = new JLabel("Tipo de cuenta:");
	    JComboBox<String> cbTipo = new JComboBox<>(new String[] {"Estudiante", "Coordinador"});

	    panelTop.add(lblTipo);
	    panelTop.add(cbTipo);

	    JTextField txtUser = new JTextField();
	    JTextField txtPass = new JTextField();
	    JTextField txtNombre = new JTextField();
	    JTextField txtCarrera = new JTextField();
	    JTextField txtSemestre = new JTextField();
	    JTextField txtCorreo = new JTextField();
	    JTextField txtInfoExtra = new JTextField();

	    JButton btnCrear = new JButton("Crear Cuenta");

	    panelForm.add(new JLabel("Usuario / RUT:"));
	    panelForm.add(txtUser);

	    panelForm.add(new JLabel("Contraseña:"));
	    panelForm.add(txtPass);

	    panelForm.add(new JLabel("Nombre:"));
	    panelForm.add(txtNombre);

	    panelForm.add(new JLabel("Carrera (Estudiante):"));
	    panelForm.add(txtCarrera);

	    panelForm.add(new JLabel("Semestre (Estudiante):"));
	    panelForm.add(txtSemestre);

	    panelForm.add(new JLabel("Correo (Estudiante):"));
	    panelForm.add(txtCorreo);

	    panelForm.add(new JLabel("Info adicional (Coordinador):"));
	    panelForm.add(txtInfoExtra);

	    panelForm.add(btnCrear);

	    Runnable actualizarVisibilidad = () -> {
	        boolean esEst = cbTipo.getSelectedItem().equals("Estudiante");

	        txtCarrera.setEnabled(esEst);
	        txtSemestre.setEnabled(esEst);
	        txtCorreo.setEnabled(esEst);

	        txtInfoExtra.setEnabled(!esEst);
	    };

	    cbTipo.addActionListener(e -> actualizarVisibilidad.run());
	    actualizarVisibilidad.run();

	    btnCrear.addActionListener(e -> {
	        try {
	            String tipo = (String) cbTipo.getSelectedItem();
	            String user = txtUser.getText();
	            String pass = txtPass.getText();

	            if (user.isEmpty() || pass.isEmpty()) {
	                JOptionPane.showMessageDialog(frame, "Faltan campos obligatorios");
	                return;
	            }

	            if (tipo.equals("Estudiante")) {
	                String nombre = txtNombre.getText();
	                String carrera = txtCarrera.getText();
	                int semestre = Integer.parseInt(txtSemestre.getText());
	                String correo = txtCorreo.getText();

	                String[] partes = {user, nombre, carrera, String.valueOf(semestre), correo, pass};
	                sistema.lectura_Estudiante(partes);
	            } else {
	                String nombre = txtNombre.getText();
	                String info = txtInfoExtra.getText();

	                String[] partes = {user, pass, nombre, info};
	                sistema.lectura_Usuario(partes);
	            }

	            JOptionPane.showMessageDialog(frame, "Cuenta creada con éxito!");
	            frame.dispose();

	        } catch (Exception ex) {
	            JOptionPane.showMessageDialog(frame, "Error en los datos ingresados");
	        }
	    });

	    frame.add(panelTop);
	    frame.add(panelForm);

	    frame.setVisible(true);
	}


	private void modificarCuenta() {
	    JFrame frame = new JFrame("Modificar Cuenta");
	    frame.setSize(450, 400);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(new GridLayout(2, 1, 10, 10));

	    JPanel panelBuscar = new JPanel(new GridLayout(3, 1, 5, 5));
	    JPanel panelForm = new JPanel(new GridLayout(8, 2, 5, 5));

	    JTextField txtUser = new JTextField();
	    JButton btnBuscar = new JButton("Buscar Usuario");

	    panelBuscar.add(new JLabel("Ingrese usuario/RUT a modificar:"));
	    panelBuscar.add(txtUser);
	    panelBuscar.add(btnBuscar);

	    JTextField txtPass = new JTextField();
	    JTextField txtNombre = new JTextField();
	    JTextField txtInfo = new JTextField();

	    JButton btnGuardar = new JButton("Guardar Cambios");
	    btnGuardar.setEnabled(false);

	    panelForm.add(new JLabel("Nueva contraseña:"));
	    panelForm.add(txtPass);

	    panelForm.add(new JLabel("Nuevo nombre (Estudiante):"));
	    panelForm.add(txtNombre);

	    panelForm.add(new JLabel("Info adicional (Coordinador):"));
	    panelForm.add(txtInfo);

	    panelForm.add(new JLabel()); // espacio vacío
	    panelForm.add(btnGuardar);

	    final Usuario[] encontrado = {null};

	    btnBuscar.addActionListener(e -> {
	        encontrado[0] = null;

	        for (Usuario u : sistema.usuarios) {
	            if (u.getIdentificacion().equals(txtUser.getText())) {
	                encontrado[0] = u;
	                break;
	            }
	        }

	        if (encontrado[0] == null) {
	            JOptionPane.showMessageDialog(frame, "No existe ese usuario.");
	            btnGuardar.setEnabled(false);
	            return;
	        }

	        JOptionPane.showMessageDialog(frame, "Usuario encontrado.");

	        btnGuardar.setEnabled(true);
	        txtPass.setEnabled(true);

	        if (encontrado[0] instanceof Estudiante) {
	            txtNombre.setEnabled(true);
	            txtInfo.setEnabled(false);
	        } else {
	            txtNombre.setEnabled(false);
	            txtInfo.setEnabled(true);
	        }
	    });
	    btnGuardar.addActionListener(e -> {
	        if (encontrado[0] == null) {
	            JOptionPane.showMessageDialog(frame, "Debe buscar un usuario primero.");
	            return;
	        }

	        if (!txtPass.getText().isEmpty())
	            encontrado[0].setContraseña(txtPass.getText());

	        if (encontrado[0] instanceof Estudiante && !txtNombre.getText().isEmpty())
	            ((Estudiante) encontrado[0]).nombre = txtNombre.getText();

	        if (encontrado[0] instanceof Coordinador && !txtInfo.getText().isEmpty())
	            ((Coordinador) encontrado[0]).setInfoAdicional(txtInfo.getText());

	        JOptionPane.showMessageDialog(frame, "Cambios guardados.");
	        frame.dispose();
	    });

	    frame.add(panelBuscar);
	    frame.add(panelForm);
	    frame.setVisible(true);
	}


	private void eliminarCuenta() {
	    JFrame frame = new JFrame("Eliminar Cuenta");
	    frame.setSize(350, 180);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(new GridLayout(3, 1, 5, 5));

	    JTextField txtUser = new JTextField();
	    JButton btnEliminar = new JButton("Eliminar");

	    frame.add(new JLabel("Ingrese usuario/RUT a eliminar:"));
	    frame.add(txtUser);
	    frame.add(btnEliminar);

	    btnEliminar.addActionListener(e -> {
	        String id = txtUser.getText();

	        Usuario encontrado = null;

	        for (Usuario u : sistema.usuarios) {
	            if (u.getIdentificacion().equals(id)) {
	                encontrado = u;
	                break;
	            }
	        }

	        if (encontrado == null) {
	            JOptionPane.showMessageDialog(frame, "Usuario no encontrado.");
	            return;
	        }
	        sistema.usuarios.remove(encontrado);

	        if (encontrado instanceof Estudiante)
	            sistema.estudiantes.remove(encontrado);

	        JOptionPane.showMessageDialog(frame, "Usuario eliminado con éxito.");
	        frame.dispose();
	    });

	    frame.setVisible(true);
	}

	private void resetContraseña() {
	    JFrame frame = new JFrame("Restablecer Contraseña");
	    frame.setSize(350, 200);
	    frame.setLocationRelativeTo(null);
	    frame.setLayout(new GridLayout(4, 1, 5, 5));

	    JTextField txtUser = new JTextField();
	    JPasswordField txtNuevaPass = new JPasswordField();
	    JButton btnReset = new JButton("Actualizar Contraseña");

	    frame.add(new JLabel("Ingrese usuario/RUT:"));
	    frame.add(txtUser);

	    frame.add(new JLabel("Nueva contraseña:"));
	    frame.add(txtNuevaPass);

	    frame.add(btnReset);

	    btnReset.addActionListener(e -> {
	        String user = txtUser.getText();
	        String nuevaPass = new String(txtNuevaPass.getPassword());

	        if (user.isEmpty() || nuevaPass.isEmpty()) {
	            JOptionPane.showMessageDialog(frame, "Debe llenar ambos campos.");
	            return;
	        }
	        Usuario objetivo = null;
	        for (Usuario u : sistema.usuarios) {
	            if (u.getIdentificacion().equals(user)) {
	                objetivo = u;
	                break;
	            }
	        }

	        if (objetivo == null) {
	            JOptionPane.showMessageDialog(frame, "Usuario no encontrado.");
	            return;
	        }

	        objetivo.setContraseña(nuevaPass);
	        JOptionPane.showMessageDialog(frame,
	                "Contraseña actualizada con éxito.");
	        frame.dispose();
	    });

	    frame.setVisible(true);
	}


}
