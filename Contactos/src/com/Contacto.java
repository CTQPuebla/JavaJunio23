package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacto {

	Map<String, Contacto> tabla = new HashMap<String, Contacto>();

	String nombre;
	String telefono;
	String correo;

	public Contacto() {

	}

	public Contacto(String nombre, String telefono, String correo) {
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

	// AGREGAR
	public Map<String, Contacto> agregar(String nombre, String telefono, String correo) {

		Contacto contacto = new Contacto(nombre, telefono, correo);
		tabla.put(nombre, contacto);

		return tabla;
	}

	// BUSCAR
	public Map<String, Contacto> buscar(String nombre) {

		if (tabla.containsKey(nombre)) {
			for (String key : tabla.keySet()) {
				System.out.println(tabla.get(key));			
			}
			return tabla;
		} else {
			System.out.println("El contacto no existe");
			return null;
		}
	}

	// EDITAR
	public Map<String, Contacto> editar(String nombre) {

		if (tabla.containsKey(nombre) == true) {
			Scanner sc2 = new Scanner(System.in);
			Scanner sc3 = new Scanner(System.in);
			Contacto contacto = new Contacto(nombre, telefono, correo);
			System.out.println("¿Que deseas editar?: \n" + "1.- Telefono\n" + "2.- Correo\n");
			int opc = sc2.nextInt();

			switch (opc) {
			case 1:
				System.out.println("Ingrese el nuevo telefono: ");
				String telefono = sc3.nextLine();
				contacto.telefono = telefono;
				tabla.replace(nombre, contacto);
				break;
			case 2:
				System.out.println("Ingrese el nuevo correo: ");
				String correo = sc3.nextLine();
				contacto.correo = correo;
				tabla.replace(nombre, contacto);
				break;
			default:
				System.out.println("No existe la opcion");
			}
			System.out.println("Edición exitosa");
			return tabla;
		} else {
			System.out.println("El contacto no existe");
			return null;
		}
	}

	// ELIMINAR
	public Map<String, Contacto> eliminar(String nombre) {

		if (tabla.containsKey(nombre) == true) {
			tabla.remove(nombre);
			System.out.println("Contacto eliminado exitosamente");
			return tabla;
		} else {
			System.out.println("El contacto no existe");
			return null;
		}
	}

	// BUSCAR POR CORREO
	public Map<String, Contacto> buscarCorreo(String correo) {
			
		Contacto contacto = null;
		for(String key:tabla.keySet()) {
			contacto = tabla.get(key);
		}

		if(correo.contentEquals(contacto.getCorreo())) {
				System.out.println(contacto);
				return tabla;
		}		
		else {
			System.out.println("No se encuentra el correo");
			return null;
		}
	}

	// MOSTRAR TODOS
	public Map<String, Contacto> mostrarTodos() {
		for (String nombre : tabla.keySet()) {
			System.out.println(tabla.get(nombre));
		}
		return tabla;
	}

	@Override
	public String toString() {
		return "Contacto [nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + "]";
	}

}
