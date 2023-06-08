package com;

import java.util.Date;
import java.util.Objects;

public class Cajero {
	String direccion;
	Cuenta[] database = new Cuenta[3];
	int folioOperacion;

	public Cajero() {

	}

	public Cajero(String direccion, Cuenta[] database) {
		this.direccion = direccion;
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
	 * Depositar : input (numeroCuenta, monto), output (Ticket) Retirar : inputo
	 * (numeroCuenta), output (dinero y ticket) Transferir : input
	 * (numeroCuentaOrigen,numeroCuentaDestino, monto), output (ticket) Consulta ;
	 * input (numeroCuenta)
	 */

	// void
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
			return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), " Consulta",
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
				// database[i]
				if (monto > database[i].getSaldo()) {
					System.out.println("Fondos insuficientes");
					return null;

				} else if ((database[i].getSaldo() - monto) < database[i].getSaldoMin()) {
					System.out.println("El retiro excede el minimo permitido por la cuenta");
					return null;
				} else {
					// Aqui es donde realmente se altera el saldo de la cuenta.
					database[i].setSaldo(database[i].getSaldo() - monto);

					return new Ticket(this.getDireccion(), Integer.toString(i), "DEPOSITO", cuenta.getNumCuenta(),
							cuenta.getSaldo(), monto, new Date());
				}

			}

		}

		return null;

	}

	public Object[] retirar(String numcuenta, double monto) {
		Object[] objetos = new Object[2];
		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numcuenta)) {
				// database[i]
				if (monto > database[i].getSaldoMax()) {
					System.out.println("El monto excede el maximo permitido de la cuenta");
					return null;

				} else if ((database[i].getSaldo() + monto) > database[i].getSaldoMax()) {
					System.out.println("El deposito excede el maximo permitido de la cuenta");
					return null;
				} else {
					// Aqui es donde realmente se altera el saldo de la cuenta.
					database[i].setSaldo(database[i].getSaldo() + monto);
					Cuenta cuenta = null;
					Ticket ticket = new Ticket(this.getDireccion(), Integer.toString(i), "RETIRO",
							cuenta.getNumCuenta(), cuenta.getSaldo(), monto, new Date());

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

		// Buscando la cuenta origen

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
		// Validar que ambas cuentas extistan
		if (cuentaOrigen != null && cuentaDestino != null) {
			if (cuentaOrigen.getSaldo() < monto) {
				System.out.println("Fondos insuficientes");
				return null;

			} else if ((cuentaOrigen.getSaldo() - monto) < cuentaOrigen.getSaldoMin()) {
				System.out.println("La transferencia excede el minomo permitido por la cuenta");
				return null;

			} else if (cuentaDestino.getSaldoMax() < monto) {
				System.out.println("No se puede realizar la transferencia");
				return null;

			} else if ((cuentaDestino.getSaldo() + monto) > cuentaDestino.getSaldoMax()) {
				System.out.println(
						"No se puede realizar la transferencia, el deposito excede el saldo maximo permitido por la cuenta");
				return null;

			} else {
				// afectacion de los saldos en las cuentas.
				cuentaOrigen.setSaldo(cuentaDestino.getSaldo() + monto);
				cuentaOrigen.setSaldo(cuentaDestino.getSaldo() + monto);
				// reintegracon de los objetos dentro del array
				database[origenIndex] = cuentaOrigen;
				database[destinoIndex] = cuentaDestino;

				ticket = new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "Transferencia",
						cuentaOrigen.getNumCuenta(), cuentaOrigen.getSaldo(), monto, new Date());

			}

		}
		return ticket;
	}

}