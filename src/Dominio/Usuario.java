package Dominio;
public abstract class Usuario {
	protected String identificacion;
	protected String contraseña;
	protected String rol;
	
	public Usuario(String identificacion, String contraseña, String rol) {
		super();
		this.identificacion = identificacion;
		this.contraseña = contraseña;
		this.rol = rol;
	}
	public String getIdentificacion() {
		return identificacion;
	}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
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
