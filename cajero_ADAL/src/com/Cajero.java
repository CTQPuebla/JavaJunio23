package com;

import java.util.Arrays;
import java.util.Date;

public class Cajero {

	String direccion;
	// Simula la base de datos de cuentas del cajero
	Cuenta[] database = new Cuenta[10];
	int folioOperacion = 0;

	public Cajero() {

	}

	public Cajero(String direccion) {
		this.direccion = direccion;
	}

	public Cajero(Cuenta[] database) {
		super();
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

	// Comportamiento
	/*
	 * Cuenta Consultar:(input(numCuenta) Depositar :Input (numeroCuenta, monto),
	 * output (ticket) Retirar:Input (numeroCuenta, monto),output (dinero,ticket)
	 * Transferir: (numeroCuentaOrigen, numCuentaDestino monto),output(Ticket)
	 */

	@Override
	public String toString() {
		return "Cajero [direccion=" + direccion + ", database=" + Arrays.toString(database) + ", folioOperacion="
				+ folioOperacion + "]";
	}

	public Ticket consultarSaldo(String numCuenta) {

		// Objeto que voy a devolver
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

		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numCuenta)) {
				if (monto > database[i].saldoMax) {
					System.out.println("El monto excede el maximo permitido de la cuenta");
					return null;

				} else if ((database[i].getSaldo() + monto) > database[i].getSaldoMax()) {
					System.out.println("El deposito excede el maximo permitido de la cuenta");
					return null;
				} else {
					database[i].setSaldo(database[i].getSaldo() + monto);
					return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "DEPOSITO", numCuenta,
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
					System.out.println("Fondos insuficientes");
					return null;

				} else if ((database[i].getSaldo() - monto) < database[i].getSaldoMin()) {
					System.out.println("El retiro excede el minimo permitido de la cuenta");
					return null;
				} else {
					database[i].setSaldo(database[i].getSaldo() - monto);
					Ticket ticket = new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "RETIRO",
							numCuenta, database[i].getSaldo(), monto, new Date());
					objetos[0] = ticket;
					objetos[1] = monto;
					return objetos;
				}

			}
		}

		return null;

	}

	public Ticket transferencia(String origen, String destino, double monto) {
		int origenIndex = 0;
		int destinoIndex = 0;
		Ticket ticket = null;

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

		if (cuentaOrigen != null && cuentaDestino != null) {
			if (cuentaOrigen.getSaldo() < monto) {
				System.out.println("Fondos insufcientes");
				return null;
			} else if (cuentaOrigen.getSaldo() - monto < cuentaOrigen.getSaldoMin()) {
				System.out.println("El retiro excede el minimo permitido de l cuenta");
				return null;
			} else if (cuentaDestino.getSaldoMax() < monto) {
				System.out.println("El monto excede el maximo permitidp de la cuenta");
				return null;

			} else if ((cuentaDestino.getSaldo() + monto) > cuentaDestino.getSaldoMax()) {
				System.out.println("El deposito excederia el maximo permitido de la cuenta");
				return null;
			} else {
				cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
				cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
				// Reintegracion de los objetos dentro de array
				database[origenIndex] = cuentaOrigen;
				database[destinoIndex] = cuentaDestino;

				ticket = new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "TRANSFERENCIA",
						cuentaOrigen.getNumCuenta(), cuentaDestino.getSaldo(), monto, new Date());
			}

		}

		return ticket;
	}

}
