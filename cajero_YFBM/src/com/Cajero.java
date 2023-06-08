package com;

import java.util.Date;

public class Cajero {
	
		
		String direccion;//Atributo
		
		//simula la base de datos de cuentas del cajero
		cuenta[] db = new cuenta[10];
		int folioOperacion = 0;
		
		public Cajero() {// Metodo Constructor
			
		}
		

		public Cajero(String direccion) {// Metodo contructor con parametros
			this.direccion = direccion;
		}

		

		public cuenta[] getDb() {
			return db;
		}


		public void setDb(cuenta[] db) {
			this.db = db;
		}


		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}


		@Override
		public String toString() {//Metodo toString
			return "Cajero [direccion=" + direccion + "]";
		}
		
		// Comportamiento
		
		/*
		 * consultar: input (numeroCuenta)
		 * depositar: input (numeroCuenta, monto), output (ticket)
		 * retiraar: input (numeroCuenta, monto), output (Dinero,ticket)
		 * transferir: input(numeroCuentaOrigen, numeroCuentaDestino, monto), output(ticket)
		 * 
		 */
		
		public ticket consultarSaldo(String numCuenta) {
			//objeto que voy a devolver
			cuenta cuenta = null;
			
			for (int i = 0; i < db.length; i++) {
				if(db[i].getNumCuenta().equals(numCuenta)) {
					cuenta = db[i];
					
						
					}
				}if(cuenta != null) {
					
					return new ticket(this.getDireccion(),
					          folioOperacion++,
					          "Consulta",
					          cuenta.getNumCuenta(),
					          cuenta.getSaldo(),0,new Date());
					
				}else {
					System.out.println("La cuenta no existe");
					return  null;}
			    }
				
			
		
			
			public ticket depositar(String numCuenta, double monto){
				cuenta cuenta = null;
				for (int i = 0; i < db.length; i++) {
					if(db[i].getNumCuenta().equals(numCuenta)) {
						if(monto > db[i].getSaldoMax() ){
							System.out.println("El monto excede el maximo permitido en la cuenta");
							return null;
						}else if((db[i].getSaldo() + monto) > db[i].getSaldoMax()) {
							System.out.println("El monto excede el maximo permitido en la cuenta");
							return null;
						}else {
							//Altero el saldo de la cuenta
							db[i].setSaldo(db[i].getSaldo() + monto);
							return new ticket(this.getDireccion(), folioOperacion++, "Deposito", numCuenta,
									db[i].getSaldo(), monto, new Date());
						}
					}
			     }
				return null;
			}
			
			
			public Object[] retirar(String numCuenta, double monto){
				
				Object[] objetos = new Object[2];
				for (int i = 0; i < db.length; i++) {
					if(db[i].getNumCuenta().equals(numCuenta)) {
						if(monto > db[i].getSaldo() ){
							System.out.println("Fondos insuficientes");
							return null;
						}else if((db[i].getSaldo() + monto) < db[i].getSaldoMax()) {
							System.out.println("El monto excede el minimo permitido en la cuenta");
							return null;
						}else {
							//Altero el saldo de la cuenta
							db[i].setSaldo(db[i].getSaldo() - monto);
							ticket ticket = new ticket(this.getDireccion(), folioOperacion++, "Retiro", numCuenta,
									db[i].getSaldo(), monto, new Date());
							
							objetos[0] = ticket;
							objetos[1] = monto;
							return objetos;
						}
					}
			     }
				
				
				
				
				return null;
			}
		

		public ticket transferir(String origen, String destino, double monto) {
			
			ticket ticket = null;
			
			int origenIndex = 0;
			int destinoIndex = 0;
			
			//Buscando la cuenta origen
            cuenta cuentaOrigen = null;
            cuenta cuentaDestino = null;
			
			for (int i = 0; i < db.length; i++) {
				if(db[i].getNumCuenta().equals(origen)) {
					cuentaOrigen = db[i];
					origenIndex = i;
				}
				if(db[i].getNumCuenta().equals(destino)) {
					cuentaDestino = db[i];
					destinoIndex = i;
				}
						
					}
			
			//Valido que existamn varias cuentas
			if(cuentaOrigen != null && cuentaDestino != null) {
				if(cuentaOrigen.getSaldo() < monto) {
					System.out.println("Fondos insuficientes");
					return null;
				}else if((cuentaOrigen.getSaldo() - monto) < cuentaOrigen.getSaldoMin()) {
					System.out.println("El retiro excede el minimo permitido en la cuenta");
					return null;
				}else if(cuentaDestino.getSaldoMax() < monto) {
					System.out.println("El monto excede el maximo permitido de la cuenta");
					return null;
				}else if((cuentaDestino.getSaldo() + monto) > cuentaDestino.getSaldoMax()) {
					System.out.println("El deposito excederia el monto maximo permitido de loa cuenta");
					return null;
				}else {
					//Afectacion de los saldos en las cuentas
					cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - monto);
					cuentaDestino.setSaldo(cuentaDestino.getSaldo() + monto);
					
					//Reintegracion de los objetos dentro del array
					db[origenIndex] = cuentaOrigen;
					db[destinoIndex] = cuentaDestino;
					
					ticket = new ticket(this.getDireccion(), folioOperacion++,
							"Transferencia",
							cuentaOrigen.getNumCuenta(), cuentaOrigen.getSaldo(),
							monto, new Date());
					 
				}	

			}
			
			
			return ticket;
			
		}
		
		
		
		
		
		
		
		
		
		
		
}
