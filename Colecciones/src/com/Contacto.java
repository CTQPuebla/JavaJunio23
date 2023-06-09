package com;

public class Contacto {
	
	String nombre;
	String tel�fono;
	String correo;
	
	public Contacto() {}
	
	public Contacto(String nombre, String tel�fono, String correo) {
		super();
		this.nombre = nombre;
		this.tel�fono = tel�fono;
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTel�fono() {
		return tel�fono;
	}
	public void setTel�fono(String tel�fono) {
		this.tel�fono = tel�fono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", tel�fono=" + tel�fono + ", correo=" + correo + "]";
	}
}
