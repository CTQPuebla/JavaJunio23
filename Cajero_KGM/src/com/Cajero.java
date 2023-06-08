package com;

import java.util.Date;

public class Cajero {

	String direccion;
	// Simula la base de datos de cuentas del cajero
	Cuenta[] database = new Cuenta[10];
	int folioOperación = 0;
	
	public Cajero() {}

	public Cajero(String direccion, Cuenta[] database) {
		super();
		this.direccion = direccion;
		this.database = database;
	}

	public Cajero(String direccion) {
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
	
	//Comportamiento
	/* Cuenta
	 * consultar: input (númeroCuenta)
	 * depositar: input (númeroCuenta, monto), output (ticket)
	 * retirar: input (númeroCuenta, monto), output (dinero, ticket)
	 * transferir: input (númeroCuentaOrigen, númeroCuentaDestino, monto), output (ticket)
	 */
	
	// 		void
	public Ticket consultarSaldo(String numCuenta) {
		
		Cuenta cuenta = null;
		
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuenta)) {
				cuenta = database[i];
				break;
			}
		}
		
		if (cuenta != null) {
			return new Ticket(this.getDireccion(),
					Integer.toString(folioOperación++), "CONSULTA",
					numCuenta, cuenta.getSaldo(), 0,
					new Date());
		} else {
			System.out.println("La cuenta no existe");
			return null;
		}
	}
	
	public Ticket depositar(String numCuenta, double monto) {		
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuenta)) {
				if (database[i].getSaldo() + monto <= database[i].getSaldoMax()) {
					database[i].setSaldo(database[i].getSaldo() + monto);
					
					return new Ticket(this.getDireccion(),
							Integer.toString(folioOperación++), "DEPÓSITO",
							numCuenta, database[i].getSaldo(), monto,
							new Date());
				} else {
					System.out.println("Este depósito excede su límite de cuenta");
					return null;
				} 
			}
		}
		
		System.out.println("La cuenta no existe");
		return null;
	}
	
	public Object[] retirar(String numCuenta, double monto) {
	Object[] op = new Object[2];
	
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuenta)) {
				if (database[i].getSaldo() - monto >= database[i].getSaldoMin()) {
					database[i].setSaldo(database[i].getSaldo() - monto);
					
					op[0] = new Ticket(this.getDireccion(),
							Integer.toString(folioOperación++), "RETIRO",
							numCuenta, database[i].getSaldo(), monto,
							new Date());
					op[1] = monto;
					
					return op;
				} else {
					System.out.println("Este retiro excede el mínimo de cuenta");
					return null;
				} 
			}
		}
		
		System.out.println("La cuenta no existe");
		return null;
	}
	
	public Ticket transferir(String numCuentaOrigen, String numCuentaDestino, double monto) {
		int origenIndex = 11, destinoIndex = 11;
		boolean exO = false, exD = false, existencia = false;
		
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuentaOrigen)) {
//				System.out.println("La cuenta origen existe");
				origenIndex = i;
				exO = true;
			} else if (database[i].getNumCuenta().equals(numCuentaDestino)) {
//				System.out.println("La cuenta destino existe");
				destinoIndex = i;
				exD = true;
			}
			
			if (exO && exD && (origenIndex != destinoIndex)) {
				existencia = true;
				break;
			}
		}
		
		
		if (existencia == true) {
			if ((database[destinoIndex].getSaldo() + monto <= database[destinoIndex].getSaldoMax())
					&& (database[origenIndex].getSaldo() - monto >= database[origenIndex].getSaldoMin())) {
				
				database[origenIndex].setSaldo(database[origenIndex].getSaldo() - monto);
				database[destinoIndex].setSaldo(database[destinoIndex].getSaldo() + monto);
				
				return new Ticket(this.getDireccion(),
						Integer.toString(folioOperación++), "TRANSERFENCIA",
						numCuentaOrigen, database[origenIndex].getSaldo(), monto,
						new Date());
				
			} else if (database[origenIndex].getSaldo() - monto < database[origenIndex].getSaldoMin()) {
				System.out.println("Este retiro excede el mínimo de cuenta");
				return null;
			} else if (database[destinoIndex].getSaldo() + monto > database[destinoIndex].getSaldoMax()) {
				System.out.println("El depósito excede el límite de la cuenta destino");
				return null;
			} else {
				System.out.println("Esta operación no se logró realizar");
				return null;
			}
		}
		
		return null;
		
//		Cuenta cuenta = null;
//		
//		retirar(numCuentaOrigen, monto);
//		depositar(numCuentaDestino, monto);
//		
//		for (int i = 0; i < database.length; i++) {
//			if(database[i].getNumCuenta().equals(numCuentaOrigen)) {
//				cuenta = database[i];
//				break;
//			}
//		}
//		
//		return new Ticket(this.getDireccion(),
//				Integer.toString(folioOperación++), "TRANSERFENCIA",
//				numCuentaOrigen, cuenta.getSaldo(), monto,
//				new Date());
	}
}
