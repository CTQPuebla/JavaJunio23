package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class principal_menu {
	public static void main(String[] args) {
		Map<String, contacto_menu> tabla = new HashMap<String, contacto_menu>();

		int opcion;
		do {
			

			Scanner sc = new Scanner(System.in);
			System.out.println("por favor elija una de las siguientes opciones(digite el numero) ");
			System.out.println(
					" 1. Agregar un contacto\n 2. Buscar un contacto\n 3. Editar un contacto\n 4. Eliminar un contacto\n 5. Buscar contacto por correo\n 6. Mostrar todos");
			opcion = sc.nextInt();
			System.out.println("eligio la opcion numero " + opcion);

			switch (opcion) {
			case 1:
				System.out.println("digite el nombre");
				String nombre = sc.next();
				System.out.println("digite el telefono");
				String telefono = sc.next();
				System.out.println("digite el correo");
				String correo = sc.next();
				contacto_menu nuevoContacto = new contacto_menu(nombre, telefono, correo);
				tabla.put(nombre, nuevoContacto);
				System.out.println("Contacto agregado correctamente.");

				break;
			case 2:

				System.out.println("digite el nombre");
				nombre = sc.next();
				if (tabla.containsKey(nombre)) {
					System.out.println(tabla.get(nombre));
				} else {
					System.out.println("la persona no se encuentra dentro de la lista");

				}
				break;
			case 3:
				System.out.println("digite el nombre de la persona que quiere editar su contacto");
				nombre = sc.next();
				contacto_menu contactoEditar = tabla.get(nombre);
				System.out.println("Digite el nuevo número: ");
				String nuevoNumero = sc.next();
				System.out.println("Digite el nuevo correo: ");
				String nuevoCorreo = sc.next();

				contactoEditar.setTelefono(nuevoNumero);
				contactoEditar.setCorreo(nuevoCorreo);
				System.out.println("Contacto editado correctamente.");
				break;
			case 4:
				System.out.println("digite el nombre de la persona que que quiere borrar de la lista");
				nombre = sc.next();
				tabla.remove(nombre);
				System.out.println("contacto borrado");
				break;
			case 5:
				System.out.println("Digite el correo del contacto que desea buscar: ");
				String correoBuscar = sc.next();

				for (Map.Entry<String, contacto_menu> entry : tabla.entrySet()) {
					contacto_menu contacto = entry.getValue();
					if (contacto.getCorreo().equals(correoBuscar)) {
						System.out.println("Contacto: " + contacto);
					}
				}
				break;
			case 6:
				System.out.println(tabla);
				break;
			}
		} while (opcion > 0 && opcion <= 6);
	}
}
