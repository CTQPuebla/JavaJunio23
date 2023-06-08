package com;

public class Principal {
public static void main(String[] args) {
	Cuenta cuenta1=new Cuenta("Daniel","001122334455", 10000.0,"1234",20000.0,5000.0);
	Cuenta cuenta2=new Cuenta("ANGEL","554433221100", 12000.0,"1634",20000.0,5000.0);
	Cuenta cuenta3=new Cuenta("ADRIANA","5544336700", 1000.0,"1274",2000.0,500.0);
	Cuenta cuenta4=new Cuenta("JOSSELINE","554433661155", 30000.0,"3234",20000.0,5000.0);
	Cuenta cuenta5=new Cuenta("ISAC","11422221100", 1000000.0,"1254",2000000.0,500000.0);
	Cuenta cuenta6=new Cuenta("GUILLERMO","444433221100", 1000.0,"9234",2000.0,500.0);
	Cuenta cuenta7=new Cuenta("ESTELA","554433227700", 100000.0,"1239",2000000.0,50000.0);
	
	
	
	Cuenta[] cuentas = new Cuenta[7];
	cuentas[0]=cuenta1;
	cuentas[1]=cuenta2;
	cuentas[2]=cuenta3;
	cuentas[3]=cuenta4;
	cuentas[4]=cuenta5;
	cuentas[5]=cuenta6;
	cuentas[6]=cuenta7;

	
	 Cajero cajero = new Cajero("pradera 210, colonia la pradera", cuentas);



     // Consultar saldo
     String numCuenta = "554433221100";
     Ticket ticketConsulta = cajero.consultarSaldo(numCuenta);
     System.out.println(ticketConsulta);

     // Depositar
     numCuenta = "554433227700";
     double montoDeposito = 500.0;
     Ticket ticketDeposito = cajero.depositar(numCuenta, montoDeposito);
     System.out.println(ticketDeposito);

//     // Retirar
     double montoRetiro = 200.0;
     Object[] resultadosRetiro = cajero.retirar(numCuenta, montoRetiro);
     if (resultadosRetiro != null) {
         Ticket ticketRetiro = (Ticket) resultadosRetiro[0];
         double montoRetirado = (double) resultadosRetiro[1];
         System.out.println(ticketRetiro);
         System.out.println("Monto retirado: " + montoRetirado);
     }

     // Transferir
     String cuentaOrigen = "001122334455";
     String cuentaDestino = "11422221100";
     double montoTransferencia = 100.0;
     Ticket ticketTransferencia = cajero.transferir(cuentaOrigen, cuentaDestino, montoTransferencia);
     System.out.println(ticketTransferencia);
	}

}