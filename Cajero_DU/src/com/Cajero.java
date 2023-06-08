package com;

import java.util.*;

public class Cajero {

	String direccion;
	// Simula la base sde datos de cuentas del cajero
	Cuenta[] database = new Cuenta[3];
	int folioOperacion = 0;

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
	

	public int getFolioOperacion() {
		return folioOperacion;
	}


	public void setFolioOperacion(int folioOperacion) {
		this.folioOperacion = folioOperacion;
	}
	
	// Comportamiento
	/*
	 * Cuenta Consultar: input(NumeroCuenta) Depositar: input(NumeroCuenta, monto),
	 * output(Ticket) Retirar: input(NumeroCuenta, monto), output(Dinero,Ticket)
	 * Transferir: input(NumCuentaOrigen, NumCuentaDestino, monto), output(Ticket)
	 * 
	 */


	public Ticket consultarSaldo(String numCuenta) {
		// objeto que voy a devolver
		Cuenta cuenta = null;

		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numCuenta)) {
				cuenta = database[i];
				break;
			}
		}
		if (cuenta != null) {
			return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "Consulta",
					cuenta.getNumCuenta(), cuenta.getSaldo(), 0, new Date());
		} else {
			System.out.println("La cuenta no existe");
			return null;
		}

	}

	public Ticket depositar(String numCuenta, double monto) {

		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numCuenta)) {

				if (monto > database[i].getSaldoMax()) {
					System.out.println("El monto excede el maximo permitido de la cuenta");

					return null;
				} else if ((database[i].getSaldo() + monto) > database[i].getSaldoMax()) {
					System.out.println("El deposito excede el maximo permitido de la cuenta");

					return null;
				} else {
					database[i].setSaldo(database[i].getSaldo() + monto);

					return new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "Deposito", numCuenta,
							database[i].getSaldo(), monto, new Date());
				}

			}
		}

		return null;
	}

	public Object[] retirar(String numCuenta, double monto) {

		Object[] objeto = new Object[2];

		for (int i = 0; i < database.length; i++) {
			if (database[i].getNumCuenta().equals(numCuenta)) {

				if (monto > database[i].getSaldo()) {
					System.out.println("Fondos insuficientes");

					return null;
				} else if ((database[i].getSaldo() - monto) < database[i].getSaldoMax()) {
					System.out.println("El retiro excede el minimo permitido de la cuenta");

					return null;
				} else {
					database[i].setSaldo(database[i].getSaldo() - monto);

					Ticket ticket = new Ticket(this.getDireccion(), Integer.toString(folioOperacion++), "Retiro",
							numCuenta, database[i].getSaldo(), monto, new Date());

					objeto[0] = ticket;
					objeto[1] = monto;
					return objeto;
				}

			}
		}
		return null;
	}

	public Ticket transferir(String origen, String destino, double monto) {

		Ticket ticket = null;

		int origenIndex = 0;
		int destinoIndex = 0;

		// Buscando las cuentaas
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
				System.out.println("Fondos insuficientes");
				return null;
			} else if ((cuentaOrigen.getSaldo() - monto) < cuentaOrigen.getSaldoMin()) {
				System.out.println("El retiro excede el minimo permitido de la cuenta");
				return null;
			} else if (cuentaDestino.getSaldoMax() < monto) {
				System.out.println("El monto excede el maximo permitido de la cuenta");
				return null;
			} else if ((cuentaDestino.getSaldoMax() + monto) > cuentaDestino.getSaldoMax()) {
				System.out.println("El deposito excederia el maximo permitido de la cuenta");
				return null;
			} else {
				// afectacion de los saldos de las cuentas
				cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
				cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);

				// rein tegracion de los objestos dentro del array
				database[origenIndex] = cuentaOrigen;
				database[destinoIndex] = cuentaDestino;

				ticket = new Ticket(this.getDireccion(), Integer.toString(folioOperacion), "Transferencia",
						cuentaOrigen.getNumCuenta(), cuentaOrigen.getSaldo(), monto, new Date());
			}
		}

		return ticket;
	}


	
	
	@Override
	public String toString() {
		return "Cajero [direccion=" + direccion + ", database=" + Arrays.toString(database) + ", folioOperacion="
				+ folioOperacion + "]";
	}


	

	
	

}
