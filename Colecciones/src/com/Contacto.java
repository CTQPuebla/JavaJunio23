package com;

public class Contacto {
	
	String nombre;
	String teléfono;
	String correo;
	
	public Contacto() {}
	
	public Contacto(String nombre, String teléfono, String correo) {
		super();
		this.nombre = nombre;
		this.teléfono = teléfono;
		this.correo = correo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTeléfono() {
		return teléfono;
	}
	public void setTeléfono(String teléfono) {
		this.teléfono = teléfono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", teléfono=" + teléfono + ", correo=" + correo + "]";
	}
}
