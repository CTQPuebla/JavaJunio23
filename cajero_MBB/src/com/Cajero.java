package com;

import java.util.Arrays;
import java.util.Date;

public class Cajero {
	
	String direccion;
	//Simula la base de datos de cuenta del cajero
	Cuenta[] database = new Cuenta[10];
	int folioOperacion = 0;
	public Cajero() {
		
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
		return "Cajero [direccion=" + direccion + ", database=" + Arrays.toString(database) + "]";
	}
	
	


	
	//Comportamiento
	
	/*
	 * Cuenta
	 * Consultar: input (NumeroCuenta)
	 * Depositar: input (NumeroCuenta, Monto), output (Ticket)
	 * Retirar: input (NumeroCuenta, Monto), output (Ticket,Dinero)
	 * Transferir: input (NumeroCuentaOrigen, NumeroCuentaDestino, Monto), output (Ticket)
	 */
	
	
	public Ticket consultarSaldo(String numCuenta) {
		//Objeto a devolver
		Cuenta cuenta = null;
		
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuenta)) {
				cuenta = database[i];
				break;
				
				
			}
			
		}
		
		if(cuenta!=null) {
		return new Ticket(this.getDireccion(), 
	    Integer.toString(folioOperacion++), "Consulta", 
	    numCuenta, cuenta.getSaldo(), 0, new Date());
		}else {
			System.out.println("La cuenta no existe");
			return null;
		}
		
	
	}
	
	public Ticket depositar(String numCuenta, double monto) {
       Cuenta cuenta = null;
		
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuenta)) {
				// iffcuenta = database[i];
				
				if(monto>database[i].getSaldoMax()) {
					System.out.println("El monto excede el maximo permitido de la cuenta");
				return null;
				}else if((database[i].getSaldo()+monto)>database[i].getSaldoMax()){
					System.out.println("El depostio exccede el maximo permitido de la cuenta");
					return null;
				}else {
					//Alteral saldo de la cuenta
					database[i].setSaldo(database[i].getSaldo()+monto);
					return new Ticket(this.getDireccion(),
							Integer.toString(folioOperacion++),
							"Deposito",numCuenta,
							database[i].getSaldo(), monto, new Date());
				
}
 }
  }
	return null;
   }
		
	//Retirar
	
	public Object[] retirar(String numCuenta, double monto) {
		
		Object[] objetos = new Object[2];
		
		
		for (int i = 0; i < database.length; i++) {
			if(database[i].getNumCuenta().equals(numCuenta)) {
				// iffcuenta = database[i];
				
				if(monto>database[i].getSaldo()) {
					System.out.println("Fondos Insuficientes");
				return null;
				}else if((database[i].getSaldo()-monto)<database[i].getSaldoMin()){
					System.out.println("El retiro exccede el maximo permitido de la cuenta");
					return null;
				}else {
					//Alteral saldo de la cuenta
					database[i].setSaldo(database[i].getSaldo()-monto);
				    
					Ticket ticket = new Ticket(this.getDireccion(),
							Integer.toString(folioOperacion++),
							"Retiro",numCuenta,
							database[i].getSaldo(), monto, new Date());
					
				    objetos[0] = ticket;
				    objetos[1] = monto;
				    
				    return objetos;
					
						
}
 }
  }
	
	return null;
	}
	
	//Transferir
	
	public Ticket Transferir(String origen, String destino, double monto) {
		
		Ticket ticket = null;
		
		int origenIndex=0;
		int destinoIndex= 0;
		
		Cuenta cuentaOrigen= null;
		Cuenta cuentaDestino= null;
		for (int i = 0; i < database.length; i++) {
			
			if(database[i].getNumCuenta().equals(origen)) {
				cuentaOrigen = database[i];
				origenIndex = i;
			}
			
			if(database[i].getNumCuenta().equals(destino)) {
				cuentaDestino = database[i];
				destinoIndex = i;
			}
			
				
		}		
	if(cuentaOrigen!=null && cuentaDestino!=null) {
		
		if(cuentaOrigen.getSaldo()<monto) {
			System.out.println("Fondos insuficientes");
			return null;
			}else if((cuentaOrigen.getSaldo()-monto)<cuentaOrigen.getSaldoMin()) {
				System.out.println("La transferencia excede el minimo permitido de la cuenta");
				return null;
			}else if(cuentaDestino.getSaldoMax()<monto) {
				System.out.println("El monto excede el maximo permitido de la cuenta");
				return null;
			}else if((cuentaDestino.getSaldo()+monto)>cuentaDestino.getSaldoMax()) {
				System.out.println("El deposito excederia el maximo permitido de la cuenta");
				return null;
			}else {
				//Afectacion de los saldos en las cuentas
				cuentaOrigen.setSaldo(cuentaOrigen.getSaldo()-monto);
				cuentaDestino.setSaldo(cuentaDestino.getSaldo()+monto);
			
				//Reintegracion de los saldos en los arrays
				database[origenIndex] = cuentaOrigen;
				database[destinoIndex] = cuentaDestino;
				
				 ticket = new Ticket(this.getDireccion(),
						Integer.toString(folioOperacion++),
						"Transferencia",cuentaOrigen.getNumCuenta(),
						cuentaOrigen.getSaldo(),
						 monto, new Date());
			
 }
}
	return ticket;
}
 }

