package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
	public static void main (String[] args) {
		// LISTS
		
//		List<Integer> lista = new ArrayList<>();
		
		/*
		 * Métodos más comunes
		 * 
		 * .clear()
		 * .add()
		 * .remake()
		 * .size()
		 * .set()
		 * .get()
		 * .contains()
		 * .indexOf()
		 * .isEmpty()
		 * lastIndexOf()
		 * .toArray()
		 */
		
//		for (int i = 0; i < 10; i++) lista.add(i*i);
//		System.out.println("Creación de lista\n" + lista);
//		System.out.println("Tamaño de lista\n" + lista.size());
//		lista.add(4, 123);
//		System.out.println("Sustitución de un número\n" + lista);
//		lista.remove(8);
//		System.out.println("Remueve un número\n" + lista);
//		
//		System.out.println("Seleccionar un número\n" + lista.get(8));
//		lista.clear();
//		System.out.println("Limpiar lista\n" + lista);
		
		//-------------------------------------------------------------
		// MAPS
		
		Scanner sc = new Scanner(System.in);
		Map<String, Contacto> tabla = new HashMap<String, Contacto>();
		
		Contacto[] contactos = {new Contacto("Pepe", "1234567890", "pepe@gmail.com"),
				new Contacto("LuRod", "0987654321", "littlebambu@gmail.com"),
				new Contacto("Pable", "6789054321", "pablomeco@gmail.com"),
				new Contacto("Cuba", "5432167890", "cubireño@gmail.com"),
				new Contacto("Zeta", "4567812390", "zetadora@gmail.com"),
				new Contacto("Leia", "0912873465", "princessleia@gmail.com"),
				new Contacto("Arty", "1278349056","ora@gmail.com"),
				new Contacto("Mova", "0011992288", "chavalo@gmail.com"),
				new Contacto("Bois", "6655992200", "bolas@gmail.com"),
		};
		
		for(int i = 0; i < 9; i++)
			tabla.put(contactos[i].getNombre(),contactos[i]);
		
		//Variables de control
		String name = "", number = "", email = "";
		
		do {
			System.out.println("1- Agregar un contacto\r\n" + 
								"2- Buscar un contacto\r\n" + 
								"3- Editar un contacto\r\n" + 
								"4- Eliminar un contacto\r\n" + 
								"5- Buscar por el correo\r\n" + 
								"6- Mostrar todos");
			System.out.println("Introduzca el número de la operación que desee realizar:");
			int opción = sc.nextInt();
			
			switch (opción) {
			case 1: // Agregar un contacto
				sc.nextLine();
				System.out.println("Escriba el nombre del contacto:");
				name = sc.nextLine();
				System.out.println("Escriba el número de teléfono:");
				number = sc.nextLine();
				System.out.println("Escriba el correo:");
				email = sc.nextLine();
				
				Contacto contact = new Contacto(name, number, email);
				tabla.put(contact.getNombre(), contact);
				
				System.out.println("Contacto creado con éxito.");
				System.out.println(contact);
				break;
			case 2: // Buscar un contacto
				sc.nextLine();
				System.out.println("Escriba el nombre del contacto que desea buscar:");
				name = sc.nextLine();
				
				if (tabla.get(name) != null)
					System.out.println("Contacto encontrado: " + tabla.get(name));
				else 
					System.out.println("Contacto no encontrado");
				break;
			case 3: // Editar un contacto
				sc.nextLine();
				System.out.println("Escriba el nombre del contacto que desea editar:");
				name = sc.nextLine();
				
				Contacto temp = tabla.get(name);
				if (temp != null) {
					System.out.println("Contacto encontrado");
					System.out.println("Introduzca los datos como se le piden");
					System.out.println("Si no desea modificar el dato mostrado, ingrese SKIP");
					System.out.println("\tNuevo número:");
					number = sc.nextLine();
					System.out.println("\tNuevo correo:");
					email = sc.nextLine();
					
					if (!number.equals("SKIP")) temp.setTeléfono(number);
					if (!email.contentEquals("SKIP")) temp.setCorreo(email);
					
					tabla.replace(name, temp);
					System.out.println("El correo actualizado es: " + tabla.get(name));
					
				} else 
					System.out.println("Contacto no encontrado");
				break;
			case 4: // Eliminar un contacto
				sc.nextLine();
				System.out.println("Escriba el nombre del contacto que desea eliminar:");
				name = sc.nextLine();
				
				if(tabla.remove(name) != null) System.out.println("Contacto eliminado.");
				else System.out.println("No existe un contacto con ese nombre.");
				
				break;
			case 5: // Buscar por correo
				sc.nextLine();
				System.out.println("Escriba el correo del contacto que desea buscar:");
				email = sc.nextLine();
				
				Contacto temp1 = null;
				for(String key:tabla.keySet()) {
					temp1 = tabla.get(key);
					if (email.contentEquals(temp1.getCorreo())) break;
					temp1 = null;
				}
				if (temp1 != null)
					System.out.println("Contacto encontrado: " + temp1);
				else 
					System.out.println("Contacto no encontrado");
				break;
			case 6: // Mostrar todos
				System.out.println("Mostrando los contactos en la base de datos...");
				for(String key:tabla.keySet()) System.out.println(tabla.get(key));
				break;
				
			default:
				break;
			}
		} while (true);
		
		//do-while
		/*
		 * Menú
		 * 1- Agregar un contacto
		 * 2- Buscar un contacto
		 * 3- Editar un contacto
		 * 4- Eliminar un contacto
		 * 5- uscar por el correo
		 * 6- Mostrar todos
		 */
//		tabla.put("Foli", "orange@gmail.com");
//		System.out.println("Foli");
//		
//		// Ver el tamaño
//		System.out.println(tabla.size());
//		// contiene una llava?
//		System.out.println(tabla.containsValue("ora@gmail.com"));
//		// contiene un valor?
//		System.out.println(tabla.containsKey("Bois"));
//		// obtener un valor en una llave
//		System.out.println(tabla.get("Mova"));
//		// Elimina un objeto
//		tabla.remove("Zeta");
//		System.out.println(tabla);
//		// Elimina solo si ambos valores están pareados
//		tabla.remove("Leia", "princessleia@gmail.com");
//		System.out.println(tabla);
//		// Reemplaza el valor solo si está actualmente
//		tabla.replace("LuRod", "saludo");
//		System.out.println(tabla);
	}
}