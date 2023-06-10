package com;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Contacto contacto = new Contacto();
		Scanner sc = new Scanner(System.in);
		int menu = 0;

		do {
			System.out.println("----------------Menú----------------");
			System.out.println("1.- Agregar contacto\n" + "2.- Buscar contacto\n" + "3.- Editar contacto\n"
					+ "4.- Eliminar contacto\n" + "5.- Buscar correo\n" + "6.- Mostrar todos");
			menu = sc.nextInt();

			Scanner sc1 = new Scanner(System.in);

			switch (menu) {
			case 1:
				System.out.println("Ingrese los datos del contacto a agregar");
				System.out.println("Nombre: ");
				String nombre = sc1.nextLine();
				System.out.println("Telefono: ");
				String telefono = sc1.nextLine();
				System.out.println("Correo: ");
				String correo = sc1.nextLine();
				contacto.agregar(nombre, telefono, correo);
				break;
			case 2:
				System.out.println("Ingrese el nombre del contacto a buscar");
				System.out.println("Nombre: ");
				nombre = sc1.nextLine();
				contacto.buscar(nombre);
				break;
			case 3:
				System.out.println("Ingrese el nombre del contacto a editar");
				System.out.println("Nombre: ");
				nombre = sc1.nextLine();
				contacto.editar(nombre);
				break;
			case 4:
				System.out.println("Ingrese el nombre del contacto a eliminar");
				System.out.println("Nombre: ");
				nombre = sc1.nextLine();
				contacto.eliminar(nombre);
				break;
			case 5:
				System.out.println("Ingrese el correo a buscar");
				System.out.println("Correo: ");
				correo = sc1.nextLine();
				contacto.buscarCorreo(correo);
				break;
			case 6:
				System.out.println("Todos los contactos existentes:");
				contacto.mostrarTodos();
				break;
			default:
				System.out.println("Ingrese una opción válida del menú");
			}
			
			System.out.println("----------------------------------");
		} while (menu != 0);

	}

}