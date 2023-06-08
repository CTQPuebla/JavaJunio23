package com;

import java.util.Arrays;

public class Principal {
	public static void main(String[] args) {

		Cuenta[] database = new Cuenta[2];
		Cuenta cu0 = new Cuenta("Fernando", "1994", 4000.0, "1207", 10000.0, 1000);
		Cuenta cu1 = new Cuenta("Gabriel", "2002", 3000.0, "2405,", 20000.0, 2000);
		database[0] = cu0;
		database[1] = cu1;

		Cajero cajero = new Cajero(database);
//		Ticket depositar = new Ticket(cu0,300.0);

		System.out.println(cajero.consultarSaldo("1994"));
		System.out.println(cajero.depositar("1994", 200));
		System.out.println(Arrays.toString(cajero.retirar("2002", 300.0)));
		System.out.println(cajero.transferencia("1994", "2002", 1500));
	}
}
