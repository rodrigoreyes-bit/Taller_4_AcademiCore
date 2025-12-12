package Presentacion;

import Dominio.Certificacion;
import Dominio.Estudiante;
import Dominio.Notas;
import Dominio.SistemaImpl;
import Dominio.Usuario;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GuiInscripcion extends JFrame {

	private final Estudiante estudiante;
	private final SistemaImpl sistema = SistemaImpl.InstanciarSistemaImpl();
	private JComboBox<String> cmbCertificaciones;
	private JTextArea txtDescripcion;
	private JButton btnInscribir;
	private List<Certificacion> certificacionesDisponibles;

	public GuiInscripcion(Estudiante estudiante) {
		this.estudiante = estudiante;
		setTitle("Inscripción a Certificaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 400);
		setLayout(new BorderLayout(10, 10));

		JPanel panelLista = crearPanelLista();
		add(panelLista, BorderLayout.NORTH);

		txtDescripcion = new JTextArea("Seleccione una certificación para ver su descripción y requisitos.");
		txtDescripcion.setEditable(false);
		txtDescripcion.setLineWrap(true);
		txtDescripcion.setWrapStyleWord(true);
		add(new JScrollPane(txtDescripcion), BorderLayout.CENTER);

		btnInscribir = new JButton("Inscribirse");
		btnInscribir.setEnabled(false);
		JPanel panelBoton = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBoton.add(btnInscribir);
		add(panelBoton, BorderLayout.SOUTH);

		configurarAcciones();
		setLocationRelativeTo(null);
		cargarCertificaciones();
	}

	private JPanel crearPanelLista() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel.add(new JLabel("Certificaciones Disponibles:"));
		cmbCertificaciones = new JComboBox<>();
		panel.add(cmbCertificaciones);
		return panel;
	}

	private void cargarCertificaciones() {
		certificacionesDisponibles = sistema.getCertificaciones();
		cmbCertificaciones.removeAllItems();
		cmbCertificaciones.addItem("Seleccionar");
		for (Certificacion c : certificacionesDisponibles) {
			cmbCertificaciones.addItem(c.getNombre());
		}
	}

	private void configurarAcciones() {
		cmbCertificaciones.addActionListener(e -> {
			String nombreSeleccionado = (String) cmbCertificaciones.getSelectedItem();
			if (nombreSeleccionado != null && !nombreSeleccionado.equals("Seleccionar")) {
				Certificacion cert = null;
				for (Certificacion c : certificacionesDisponibles) {
					if (c.getNombre().equals(nombreSeleccionado)) {
						cert = c;
						break;
					}
				}

				if (cert != null) {
					int numCursosCompletados = 0;
					for (Notas n : estudiante.getNotas()) {
						if (n.getEstado().equals("Aprobado") && n.getCurso().getCertificacion() != null
								&& n.getCurso().getCertificacion().getId().equals(cert.getId())) {
							numCursosCompletados++;
						}
					}

					String mensaje = String.format(
							"Descripción: %s\n" + "Cursos Requeridos: %d\n"
									+ "Cursos Completados (Asociados a esta certificación): %d\n" + "Validez: %s",
							cert.getDescripcion(), cert.getRequisitos(), numCursosCompletados, cert.getValidez());
					txtDescripcion.setText(mensaje);
					btnInscribir.setEnabled(true);
				}
			} else {
				txtDescripcion.setText("Seleccione una certificación para ver su descripción y requisitos.");
				btnInscribir.setEnabled(false);
			}
		});

		btnInscribir.addActionListener(e -> {
			String nombreSeleccionado = (String) cmbCertificaciones.getSelectedItem();
			Certificacion cert = null;
			for (Certificacion c : certificacionesDisponibles) {
				if (c.getNombre().equals(nombreSeleccionado)) {
					cert = c;
					break;
				}
			}

			if (cert == null)
				return;

			boolean yaInscrito = false;
			for (Certificacion c : estudiante.getCertificaciones()) {
				if (c.getId().equals(cert.getId())) {
					yaInscrito = true;
					break;
				}
			}

			if (yaInscrito) {
				JOptionPane.showMessageDialog(this, "Ya estás inscrito en la certificación: " + cert.getNombre());
				return;
			}

			int cursosAprobadosAsociados = 0;
			for (Notas n : estudiante.getNotas()) {
				if (n.getEstado().equals("Aprobado") && n.getCurso().getCertificacion() != null
						&& n.getCurso().getCertificacion().getId().equals(cert.getId())) {
					cursosAprobadosAsociados++;
				}
			}

			if (cursosAprobadosAsociados < cert.getRequisitos()) {
				JOptionPane.showMessageDialog(this, String.format(
						"No cumple los prerrequisitos académicos.\nSe requieren %d cursos aprobados y tiene %d.",
						cert.getRequisitos(), cursosAprobadosAsociados));
				return;
			}

			estudiante.añadirCertificaciones(cert);
			cert.añadirEstudiantes(estudiante);

			JOptionPane.showMessageDialog(this, "Inscripción exitosa a la certificación: " + cert.getNombre(),
					"Inscripción Completada", JOptionPane.INFORMATION_MESSAGE);

			dispose();
		});
	}
}
