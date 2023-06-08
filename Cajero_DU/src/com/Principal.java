package com;

import java.util.*;

public class Principal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

//		System.out.println("Ingrese el numero de cuenta");
//		String numCuenta = sc.nextLine();
//
//		System.out.println("Ingrese monto");
//		double monto = sc.nextDouble();

		System.out.println("Ingrese el tipo operacion");
		System.out.println("1. Consultar Saldo");
		System.out.println("2. Retirar");
		System.out.println("3. Depositar");
		System.out.println("4. Transferir");
		int tipoOperacion = sc.nextInt();

		switch (tipoOperacion) {

		case 1: // consulta

			System.out.println("Ingrese numero de cuenta");
			String numCuenta = sc.nextLine();

			Cuenta[] cue = new Cuenta[3];

			Cuenta c1 = new Cuenta("Daniel U", "123456", 10000, "0000", 100000, 5000);
			Cuenta c2 = new Cuenta("Miguel L", "678910", 20000, "1234", 120000, 10000);
			Cuenta c3 = new Cuenta("Alberto M", "169170", 30000, "4567", 200000, 15000);
			// Cuenta c4 = new Cuenta(beneficioario, numCuenta, saldo, nip, saldoMax,
			// saldoMin)

			cue[0] = c1;
			cue[1] = c2;
			cue[2] = c3;

			Cajero ca = new Cajero();
			
			
			

			ca.setFolioOperacion(ca.folioOperacion);
			ca.setDireccion("Boulebard 22");

			ca.setDatabase(cue);

			Ticket ti = new Ticket();

			ti.setDireccion(ca.getDireccion());
			ti.setFecha(new Date());
			ti.setFolio(Integer.toString(ca.getFolioOperacion()));
			ti.setNumCuenta(numCuenta);
			// ti.setSaldoActual();
			ti.setTipoOperacion(Integer.toString(tipoOperacion));

			System.out.println(ti);

			break;

		case 2: // retiro

			System.out.println("Ingrese el numero de cuenta");
			String numCuenta1 = sc.nextLine();

			Cajero ca1 = new Cajero();

			Cuenta[] cue1 = new Cuenta[3];

			Cuenta c11 = new Cuenta("Daniel U", "123456", 10000, "0000", 100000, 5000);
			Cuenta c22 = new Cuenta("Miguel L", "678910", 20000, "1234", 120000, 10000);
			Cuenta c33 = new Cuenta("Alberto M", "169170", 30000, "4567", 200000, 15000);

			ca1.setDatabase(cue1);
			ca1.setFolioOperacion(ca1.getFolioOperacion());
			ca1.setDireccion("Boulebard 22");

			System.out.println("Ingrese monto");
			double monto1 = sc.nextDouble();

			// ca1.retirar(numCuenta1, monto1);

			Ticket ti1 = new Ticket();

			ti1.setDireccion(ca1.getDireccion());
			ti1.setFecha(new Date());
			ti1.setFolio(Integer.toString(ca1.getFolioOperacion()));
			ti1.setMonto(monto1);
			ti1.setNumCuenta(numCuenta1);
			// ti1.setSaldoActual(cu.getSaldo());
			ti1.setTipoOperacion(Integer.toString(tipoOperacion));

			System.out.println(ti1);

			break;

		case 3: // depositar

			System.out.println("Ingrese el numero de cuenta");
			String numCuenta2 = sc.nextLine();

			System.out.println("Ingrese el monto");
			double monto2 = sc.nextDouble();

			Cajero ca2 = new Cajero();

			ca2.setFolioOperacion(ca2.folioOperacion);
			ca2.setDireccion("Boulebard 22");

			Cuenta[] cue2 = new Cuenta[3];

			Cuenta c111 = new Cuenta("Daniel U", "123456", 10000, "0000", 100000, 5000);
			Cuenta c222 = new Cuenta("Miguel L", "678910", 20000, "1234", 120000, 10000);
			Cuenta c333 = new Cuenta("Alberto M", "169170", 30000, "4567", 200000, 15000);

			ca2.setDatabase(cue2);

			ca2.depositar(numCuenta2, monto2);

			Ticket ti2 = new Ticket();

			ti2.setDireccion(ca2.getDireccion());
			ti2.setFecha(new Date());
			ti2.setFolio(Integer.toString(ca2.getFolioOperacion()));
			ti2.setMonto(monto2);
			ti2.setNumCuenta(numCuenta2);
			// ti2.setSaldoActual(cu.getSaldo());
			ti2.setTipoOperacion(Integer.toString(tipoOperacion));

			System.out.println(ti2);

			break;

		case 4: // Transferir

			System.out.println("Ingrese el numero de cuenta origen");
			String numCuentaO3 = sc.nextLine();

			System.out.println("Ingrese el numero de cuenta destino");
			String numCuentaD3 = sc.nextLine();

			System.out.println("Ingrese monto");
			double monto3 = sc.nextDouble();

			Cajero ca3 = new Cajero();

			ca3.setFolioOperacion(0);
			ca3.setDireccion("Boulebard 22");

			Cuenta[] cue3 = new Cuenta[3];

			Cuenta c1111 = new Cuenta("Daniel U", "123456", 10000, "0000", 100000, 5000);
			Cuenta c2222 = new Cuenta("Miguel L", "678910", 20000, "1234", 120000, 10000);
			Cuenta c3333 = new Cuenta("Alberto M", "169170", 30000, "4567", 200000, 15000);

			ca3.setDatabase(cue3);

			ca3.transferir(numCuentaO3, numCuentaD3, monto3);

			Ticket ti3 = new Ticket();

			ti3.setDireccion(ca3.getDireccion());
			ti3.setFecha(new Date());
			ti3.setFolio(Integer.toString(ca3.getFolioOperacion()));
			ti3.setMonto(monto3);
			ti3.setNumCuenta(numCuentaD3);
			// ti3.setSaldoActual(cu.getSaldo());
			ti3.setTipoOperacion(Integer.toString(tipoOperacion));

			System.out.println(ti3);

			break;

		}

	}

}
