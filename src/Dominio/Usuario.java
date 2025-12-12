
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Dominio;

/**
 * Clase base abstracta para todos los usuarios del sistema (Admin, Coordinador, Estudiante).
 * Contiene las propiedades básicas de identificación, autenticación y rol.
 */
public abstract class Usuario {
	public String username;
	protected String contraseña;
	protected String rol;
	
	/**
	 * Constructor para la clase Usuario.
	 * * @param username El nombre de usuario o identificación única del usuario.
	 * @param contraseña La contraseña del usuario para la autenticación.
	 * @param rol El rol o tipo de usuario.
	 */
	public Usuario(String username, String contraseña, String rol) {
		super();
		this.username = username;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	
	/**
	 * Obtiene la identificación única del usuario.
	 * * @return La identificación del usuario.
	 */
	public String getIdentificacion() {
		return username;
	}
	
	/**
	 * Establece la identificación única del usuario.
	 * * @param identificacion La nueva identificación.
	 */
	public void setIdentificacion(String identificacion) {
		this.username = identificacion;
	}
	
	/**
	 * Obtiene la contraseña del usuario.
	 * * @return La contraseña del usuario.
	 */
	public String getContraseña() {
		return contraseña;
	}
	
	/**
	 * Establece la contraseña del usuario.
	 * * @param contraseña La nueva contraseña.
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	/**
	 * Obtiene el rol del usuario en el sistema.
	 * * @return El rol del usuario.
	 */
	public String getRol() {
		return rol;
	}
	
	/**
	 * Establece el rol del usuario en el sistema.
	 * * @param rol El nuevo rol.
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}
}