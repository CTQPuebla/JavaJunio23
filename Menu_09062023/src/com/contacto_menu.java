package com;

public class contacto_menu {
String nombre;
String telefono;
String correo;
public contacto_menu(String nombre, String telefono, String correo) {
	super();
	this.nombre = nombre;
	this.telefono = telefono;
	this.correo = correo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
@Override
public String toString() {
	return "contacto_menu [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "]";
}


}
