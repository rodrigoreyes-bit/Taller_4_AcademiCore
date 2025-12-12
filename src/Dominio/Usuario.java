package Dominio;

public abstract class Usuario {
	public String username;
	protected String contraseña;
	protected String rol;
	
	public Usuario(String username, String contraseña, String rol) {
		super();
		this.username = username;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	public String getIdentificacion() {
		return username;
	}
	public void setIdentificacion(String identificacion) {
		this.username = identificacion;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
