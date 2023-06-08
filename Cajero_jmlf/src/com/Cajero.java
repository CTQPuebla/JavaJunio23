package com;

import java.util.Date;

public class Cajero {
	String direccion;

//simula la base de datos de cuenta de un cajero 
	Cuenta[] database = new Cuenta[10];
	int folioOperacion;

	public Cajero() {

	}

	

	public Cajero(String direccion, Cuenta[] database, int folioOperacion) {
		
		this.direccion = direccion;
		this.database = database;
		this.folioOperacion = folioOperacion;
	}



	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cuenta[] getDatabase() {
		return database;
	}

	public void setDatabase(Cuenta[] database) {
		this.database = database;
	}

	@Override
	public String toString() {
		return "Cajero [direccion=" + direccion + "]";
	}
	
//comportamiento 
	/*
	 * cuenta consultar:input: (numeroCuenta) depositar: input (numeroCuenta);ouput
	 * (ticket) retirar: input (numeroCuenta); ouput(dinero,ticket) transferir :
	 * input (numero de cuenta origen, numero de cuenta destino,monto),
	 * ouput(dinero,ticket)
	 */

	public int getFolioOperacion() {
		return folioOperacion;
	}



	public void setFolioOperacion(int folioOperacion) {
		this.folioOperacion = folioOperacion;
	}



	public Ticket consultarSaldo(String munCuenta) {// datos de entrada

		Cuenta cuenta = null;
		for (int i = 0; i < database.length; i++) {

			if (database[i].getNumCuenta().contentEquals(munCuenta)) {
				cuenta = database[i];
				break;

			}
		}
		if (cuenta != null) {
			return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "consulta",
					cuenta.getNumCuenta(), cuenta.getSaldo(), 0, new Date());
		} else {
			System.out.println("la cuenta no existe");
			return null;

		}

	}

	public Ticket depositar(String numCuenta, double monto) {

		Cuenta cuenta = null;
		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numCuenta)) {

				// databasde[i]
				if (monto > database[i].getSaldoMax()) {
					System.out.println("el monto excedeel maximo peromitido de la cuenta");
					return null;

				} else if ((database[i].getSaldo() + monto) > database[i].getSaldoMax()) {
					System.out.println("el monto excede el maximo peromitido de la cuenta");
					return null;

				} else {
					// altero el saldo de la cuenta
					database[i].setSaldo(database[i].getSaldo() + monto);

					return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "deposito", numCuenta,
							database[i].getSaldo(), monto, new Date());

				}

			}
		}
		return null;
	}

	public Object[] retirar(String numCuenta, double monto) {

		Object[] objetos = new Object[2];

		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numCuenta)) {
				if (monto > database[i].getSaldoMax()) {
					System.out.println("fondos insuficientes");
					return null;

				} else if ((database[i].getSaldo() + monto) > database[i].getSaldoMax()) {
					System.out.println("el retiro excede el minimo permitido de la cuenta");
					return null;
				} else {
					database[i].setSaldo(database[i].getSaldo() - monto);
					Ticket ticket= new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "retiro", numCuenta,
							database[i].getSaldo(), monto, new Date());
					objetos[0] = ticket;
					objetos[1] = monto;
					return objetos;
				}
			}
		}
		return null;

	}
public Ticket transferir(String origen, String destino, double monto) {

	Ticket ticket = null;
	
int origenIndex =0;
int destinoIndex=0;
//buscando la cuenta origen 
Cuenta cuentaOrigen = null;
Cuenta cuentaDestino = null;
for (int i = 0; i < database.length; i++) {

	if (database[i].getNumCuenta().equals(origen)) {
		cuentaOrigen = database[i];
		origenIndex = i;
	}
	if (database[i].getNumCuenta().equals(destino)) {
		cuentaDestino = database[i];
		destinoIndex = i;
	}
}
//valido que existan ambas cuentas 
if(cuentaOrigen!=null && cuentaDestino!=null) {
	if (cuentaOrigen.getSaldo()<monto) {
		System.out.println("fondos insuficientes");}
	return null;
}else if((cuentaOrigen.getSaldo()-monto)<cuentaOrigen.getSaldoMin()){
		System.out.println("el retiro excede el minimo peromitido de la cuenta");
		return null;		
	}else if (cuentaDestino.getSaldoMax()<monto) {
		System.out.println("el monto excede el maximo permitido de la cuenta");
		return null; 
	}else if ((cuentaDestino.getSaldo()+monto)>cuentaDestino.getSaldoMax()) {
		System.out.println("el deposito excederia el maximo permitido de la cuenta");
		return null;
	}else {
		//afectacion de los saldos en las cuentas 
		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-monto);
		cuentaDestino.setSaldo(cuentaDestino.getSaldo()+monto);
		
		
		//reintegarcion de los objetos dentro del array
		database[origenIndex] = cuentaOrigen;
		database[origenIndex] = cuentaDestino;
		 ticket =new Ticket(this.getDireccion(),Integer.toString(folioOperacion++),"transferencia",cuentaOrigen.getNumCuenta(),cuentaOrigen.getSaldo(),monto,new Date());
		 
}

return ticket;

	
}
}

