package com;

import java.util.ArrayList;
import java.util.List;

public class Principal {
	public static void main (String[] args) {
		// Alta de cuentas
		int num = 10;
		String[] beneficiarios = {"Val", "Juan", "Paty", "Feli", "Carlos",
				 					"Mova", "Artero",  "Nuria", "Lu",  "Koras"};
		String[] numCuentas = {"123", "456", "879", "135", "246",
								"357", "468", "579", "680", "051"};
		Cuenta[] cuentas = new Cuenta[num];
	 	
		for (int i = 0; i < num; i++) {
			cuentas[i] = new Cuenta(beneficiarios[i], numCuentas[i], 10000, 30000, 1000);
		}
		
		Cajero ATM = new Cajero("Plaza Dorada", cuentas);
		
		Ticket recibo = ATM.consultarSaldo(numCuentas[4]);
		System.out.println(recibo);
		
		Object[] operación = new Object[2];
//		
		operación = ATM.retirar(numCuentas[2], 3000);
		System.out.println(operación[0]);
		System.out.println("Dinero recibido: " + operación[1]);
//		
		recibo = ATM.depositar(numCuentas[8], 5000);
		System.out.println(recibo);
		
		recibo = ATM.transferir(numCuentas[5], numCuentas[7], 8000);
		System.out.println(recibo);
		
//		List<Integer> lista = new ArrayList<>();
	}
}
