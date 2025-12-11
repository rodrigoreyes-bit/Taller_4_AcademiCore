package Dominio;
public class Usuario {
	protected String nombre;
	protected String contraseña;
	protected String rol;
	protected String infoAdicional;
	
	public Usuario(String nombre, String contraseña, String rol) {
		super();
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	
	public void setInforAdicional(String info) {
		this.infoAdicional = info;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public String getRol() {
		return rol;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	
	
}
