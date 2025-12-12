package Dominio;
public class Coordinador extends Usuario{
	private String infoAdicional;

    public Coordinador(String identificacion, String contraseña, String rol, String infoAdicional) {
        super(identificacion, contraseña, rol);
        this.infoAdicional = infoAdicional;
    }

    public String getInfoAdicional() {
        return infoAdicional;
    }

    public void setInfoAdicional(String infoAdicional) {
        this.infoAdicional = infoAdicional;
    }
}
