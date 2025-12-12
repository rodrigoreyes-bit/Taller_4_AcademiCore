
/* Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 * Nombre: Ninibeth Pérez Cortés, RUT: 21.787.686-9, Carrera: ICCI | Nombre: Rodrigo Reyes Alfaro, RUT: 22.123.808-7, Carrera: ICCI
 */
package Dominio;


/**
 * Representa a un usuario con rol de Administrador.
 * Los administradores tienen acceso a funciones de gestión del sistema.
 */
public class Admin extends Usuario{

	/**
	 * Constructor para la clase Admin.
	 *
	 * @param identificacion El identificador único del administrador.
	 * @param contraseña La contraseña para el acceso al sistema.
	 * @param rol El rol del usuario, que debe ser "Admin".
	 */
	public Admin(String identificacion, String contraseña, String rol) {
		super(identificacion, contraseña, rol);
	}
}
