package com;

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
			cuentas[i] = new Cuenta(beneficiarios[i], numCuentas[i], 10000, 1000, 30000);
		}
	}
}
