package com;

import java.util.Date;

public class Cajero {

	String direccion;
	int folioOperacion = 0;

	// Simula la base de datos de cuentas del cajero
	Cuenta[] database = new Cuenta[10];

	public Cajero() {

	}

	public Cajero(String direccion) {
		super();
		this.direccion = direccion;
	}

	public Cajero(String direccion, Cuenta[] database) {
		super();
		this.direccion = direccion;
		this.database = database;
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

	// Comportamiento
	/*
	 * Cuenta consultar: input(numeroCuenta) depositar: input(numeroCuenta, monto),
	 * output(Ticket) retirar: input(numeroCuenta, monto), output(dinero, Ticket)
	 * transferir: input(numeroCuentaOrigen, numeroCuentaDestino, monto),
	 * output(Ticket)
	 */

	// Método que devuelve un objeto del tipo Ticket
	public Ticket consultarSaldo(String numCuenta) {

		Cuenta cuenta = null;

		for (int i = 0; i < database.length; i++) {

			if (database[i].getNumCuenta().equals(numCuenta)) {
				cuenta = database[i];
				break;
			}
		}

		if (cuenta != null) {
			return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "CONSULTA",
					cuenta.getNumCuenta(), cuenta.getSaldo(), 0, new Date());
		} else {
			System.out.println("La cuenta no existe");
			return null;
		}

	}

	public Ticket depositar(String numCuenta, double monto) {

		Cuenta cuenta = null;

		for (int i = 0; i < database.length; i++) {

			if (database[i].getNumCuenta().equals(numCuenta)) {

				if (monto > database[i].getSaldoMax()) {

					System.out.println("El monto ingresado supera al permitido");
					return null;
				} else if (database[i].getSaldo() + monto > database[i].getSaldoMax()) {

					System.out.println("El depósito ingresado supera el saldo permitido en la cuenta");
					return null;
				} else {
					// Altero el saldo de la cuenta
					database[i].setSaldo(database[i].getSaldo() + monto);

					return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "DEPÓSITO", numCuenta,
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

				if (monto > database[i].getSaldo()) {

					System.out.println("El monto requerido supera al saldo actual");
					return null;

				} else if (database[i].getSaldo() - monto < database[i].getSaldoMin()) {

					System.out.println("El retiro excede el mínimo de saldo para la cuenta");
					return null;

				} else {
					// Altero el saldo de la cuenta
					database[i].setSaldo(database[i].getSaldo() + monto);

					Ticket ticket = new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "DEPÓSITO",
							numCuenta, database[i].getSaldo(), monto, new Date());

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
		
		int origenIndex = 0;
		int destinoIndex = 0;

		// Busca las cuentas
		Cuenta cuentaOrigen = null;
		Cuenta cuentaDestino = null;

		for (int i = 0; i < database.length; i++) {

			if (database[i].getNumCuenta().equals(origen)) {

				cuentaOrigen = database[i];
				origenIndex = i;
			}
			if (database[i].getNumCuenta().equals(origen)) {

				cuentaDestino = database[i];
				destinoIndex = i;
			}

		}
		
		if (cuentaOrigen != null && cuentaDestino != null) {
			System.out.println("Fondos insuficientes");
			return null;
		}
		else if( cuentaOrigen.getSaldo() - monto < cuentaOrigen.getSaldo() ) {
			System.out.println( "El retiro excede el mínmo permitido por la cuenta" );
			return null;
		}
		else if( cuentaDestino.getSaldoMax() < monto) {
			System.out.println("El monto excede el máximo permitido en la cuenta");
			return null;
		}
		else if ( cuentaDestino.getSaldo() + monto > cuentaDestino.getSaldoMax()) {
			return null;
		}
		else {
			//Afetación de los saldos en las cuentas
			cuentaOrigen.setSaldo( cuentaOrigen.getSaldo() - monto );
			cuentaDestino.setSaldo( cuentaDestino.getSaldo()  + monto);
			
			//Reintegración de los objetos dentro del array
			database[origenIndex] = cuentaOrigen;
			database[destinoIndex] = cuentaDestino;
			
			return new Ticket(this.getDireccion(),
					Integer.toString(folioOperacion++),
					"TRANSFERENCIA",
					cuentaOrigen.getNumCuenta(),
					cuentaOrigen.getSaldo(),
					monto,
					new Date() );
	
		}

	}

}
