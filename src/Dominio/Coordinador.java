package Dominio;

/**
 * Representa a un usuario con rol de Coordinador.
 * Los coordinadores manejan información adicional específica.
 */
public class Coordinador extends Usuario{
	private String infoAdicional;

    /**
     * Constructor para la clase Coordinador.
     *
     * @param identificacion El identificador único del coordinador.
     * @param contraseña La contraseña para el acceso al sistema.
     * @param rol El rol del usuario, que debe ser "Coordinador".
     * @param infoAdicional Información extra o específica del rol del coordinador.
     */
    public Coordinador(String identificacion, String contraseña, String rol, String infoAdicional) {
        super(identificacion, contraseña, rol);
        this.infoAdicional = infoAdicional;
    }

    /**
     * Obtiene la información adicional específica del coordinador.
     *
     * @return La información adicional.
     */
    public String getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Establece la información adicional específica del coordinador.
     *
     * @param infoAdicional La nueva información adicional.
     */
    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
}
