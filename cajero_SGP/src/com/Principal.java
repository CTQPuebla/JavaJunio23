package com;

import java.util.Date;

public class Principal {
	
	public static void main(String[] args) {
		
		Cuenta cuentaOrig = new Cuenta("El pepe","6969",10000.0,0000,20000,0);
		Cuenta cuentaDest = new Cuenta("Eso tilin","4897",1000.0,1111,20000,0);
		Cuenta[] cuenta = new Cuenta[2];
		cuenta[0] = cuentaOrig;
		cuenta[1] = cuentaDest;
		Cajero cajero = new Cajero();
		Ticket ticket = new Ticket("Calle Metemelpito, Col. LomasTurbas","01",
				   "CONSULTA","6969",cuentaOrig.getSaldo(),0.0, new Date());
		Cajero cash = new Cajero("chjrddbfhdrbv",0,cuenta,ticket);
		cash.transferir("6969", "4897", 1000);
		cash.consultarSaldo("6969");
		System.out.println(cash);
	}

}
