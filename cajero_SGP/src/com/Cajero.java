package com;

import java.util.Arrays;
import java.util.Date;

public class Cajero {

	String direccion;
	int folioOpera = 0;

	Cuenta[] db = new Cuenta[2];
	Ticket ticket;

	public Cajero() {

	}

	public Cajero(String direccion, int folioOpera, Cuenta[] db, Ticket ticket) {
		super();
		this.direccion = direccion;
		this.folioOpera = folioOpera;
		this.db = db;
		this.ticket = ticket;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getFolioOpera() {
		return folioOpera;
	}

	public void setFolioOpera(int folioOpera) {
		this.folioOpera = folioOpera;
	}

	public Cuenta[] getDb() {
		return db;
	}

	public void setDb(Cuenta[] db) {
		this.db = db;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Override
	public String toString() {
		return "Cajero [direccion=" + direccion + ", folioOpera=" + folioOpera + ", db=" + Arrays.toString(db)
				+ ", ticket=" + ticket + "]";
	}

	// Comportamiento
	/* Cuenta
	 * consultar: 	input numCuenta 
	 * depositar: 	input numCuenta 							output ticket
	 * retirar: 	input numCuenta 							output dinero,ticket 
	 * transferir: 	input numCuentaOrig, numCuentaDest, monto 	output ticket
	 */

	//CONSULTAR
	public Ticket consultarSaldo(String numCuenta) {
		Cuenta cuenta = null;

		for (int i = 0; i <= db.length - 1; i++) {
			if (db[i].getNumCuenta().equals(numCuenta)) {
				cuenta = db[i];
				break;
			}
		}

		if (cuenta != null) {
			return new Ticket(this.getDireccion(), Integer.toString(folioOpera++), "CONSULTA", cuenta.getNumCuenta(),
					cuenta.getSaldo(), 0, new Date());
		} else {
			System.out.println("La cuenta no existe");
			return null;
		}
	}
	
	//DEPOSITAR
	public Ticket depositar(String numCuenta, double monto) {

		for (int i = 0; i <= db.length - 1; i++) {
			if (db[i].getNumCuenta().equals(numCuenta)) {
				
				if(monto > db[i].getSaldoMax()) {
					System.out.println("El monto excede el máximo permitido de la cuenta");
					return null;
				} else if((db[i].getSaldo()+monto) >= db[i].getSaldoMax()) {
					System.out.println("El deposito excede el máximo permitido de la cuenta");
					return null;
				} else {
					db[i].setSaldo(db[i].getSaldo()+monto);
					
					return new Ticket(this.getDireccion(), Integer.toString(folioOpera++), "DEPOSITO", numCuenta,
							db[i].getSaldo(), monto, new Date());
					
				}
			}
		}
		
			System.out.println("La cuenta no existe");
			return null;
	}

	//RETIRAR
	public Object[] retirar(String numCuenta, double monto) {
		
		Object[] obj = new Object[2];

		for (int i = 0; i <= db.length - 1; i++) {
			if (db[i].getNumCuenta().equals(numCuenta)) {
				
				if(monto > db[i].getSaldo()) {
					System.out.println("El monto a retirar excede el saldo actual");
					return null;
				} else if((db[i].getSaldo()-monto) < db[i].getSaldoMin()) {
					System.out.println("El monto a retirar excede el mínimo permitido de la cuenta");
					return null;
				} else {
					db[i].setSaldo(db[i].getSaldo()-monto);
					
					Ticket ticket = new Ticket(this.getDireccion(), Integer.toString(folioOpera++), "RETIRO", numCuenta,
							db[i].getSaldo(), monto, new Date());
					
					obj[0] = ticket;
					obj[1] = monto;
					
					return obj;
					
				}
			}
		}
			System.out.println("La cuenta no existe");
			return null;
	}
	
	//TRANSFERIR
//	public Ticket transferir(String numCuentaOrig, String numCuentaDest, double monto) {
//		
//		for (int i = 0; i <= db.length - 1; i++) {
//			if (db[i].getNumCuenta().equals(numCuentaDest)) {
//				
//				if(monto > db[i].getSaldoMax()) {
//					System.out.println("El monto a transferir excede el saldo actual");
//					return null;
//				} else if((db[i].getSaldo()-monto) < db[i].getSaldoMin()) {
//					System.out.println("El monto a transferir excede el mínimo permitido de la cuenta");
//					return null;
//				} else {
//					
//					for (int j = 0; j <= db.length - 1; j++) {
//						if (db[j].getNumCuenta().equals(numCuentaOrig)) {
//							
//							if(monto > db[j].getSaldo()) {
//								System.out.println("El monto a transferir excede el saldo actual");
//								return null;
//							} else if((db[j].getSaldo()-monto) < db[j].getSaldoMin()) {
//								System.out.println("El monto a transferir excede el mínimo permitido de la cuenta");
//								return null;
//							} else {
//								db[j].setSaldo(db[j].getSaldo()-monto);
//												
//								return new Ticket(this.getDireccion(), Integer.toString(folioOpera++), "TRANSFERENCIA", numCuentaOrig,
//										db[j].getSaldo(), monto, new Date());
//							}
//						}
//					}	
//					db[i].setSaldo(db[i].getSaldo()+monto);
//				}
//			}	
//		}
//			System.out.println("La cuenta no existe");
//			return null;
//	}
	
	public Ticket transferir(String numCuentaOrig, String numCuentaDest, double monto) {
		
		Ticket ticket = null;
		int origIndex = 0;
		int destIndex = 0;
		Cuenta cuentaOrig = null;
		Cuenta cuentaDest = null;
		
		//Buscando la cuenta de origen
		for (int i = 0; i <= db.length - 1; i++) {
			if (db[i].getNumCuenta().equals(numCuentaOrig)) {
				cuentaOrig = db[i];
				origIndex = i;
			}
			if (db[i].getNumCuenta().equals(numCuentaDest)) {
				cuentaDest = db[i];
				destIndex = i;
			}
		}
		
		if(cuentaOrig != null && cuentaDest != null) {
			if(cuentaOrig.getSaldo() < monto) {
				System.out.println("Fondos insuficientes");
				return null;
			} else if((cuentaOrig.getSaldo()-monto) < cuentaOrig.getSaldoMin()) {
				System.out.println("El monto a transferir excede el mínimo permitido de la cuenta");
				return null;
			} else if(cuentaDest.getSaldoMax() < monto) {
				System.out.println("El monto excede el saldo máximo");
				return null;
			} else if((cuentaDest.getSaldo()+monto) > cuentaDest.getSaldoMax()) {
				System.out.println("El deposito excede el máximo permitido de la cuenta");
				return null;
			}else {
				//Modificación de los saldos de la cuenta
				cuentaOrig.setSaldo(cuentaOrig.getSaldo()-monto);
				cuentaDest.setSaldo(cuentaDest.getSaldo()+monto);
				db[origIndex] = cuentaOrig;
				db[destIndex] = cuentaDest;
				
				ticket = new Ticket(this.getDireccion(), Integer.toString(folioOpera++), "TRANSFERENCIA", cuentaOrig.getNumCuenta(),
						cuentaOrig.getSaldo(), monto, new Date());
			}	
		}
					
		return ticket;
		
	}
}
