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
	
	
	
	//Source
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", contraseña=" + contraseña + ", rol=" + rol + ", infoAdicional="
				+ infoAdicional + ", getNombre()=" + getNombre() + ", getContraseña()=" + getContraseña()
				+ ", getRol()=" + getRol() + ", getInfoAdicional()=" + getInfoAdicional() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

}
