package com;

import java.util.Date;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese su numero de cuenta");

		Cuenta cu = new Cuenta();
		cu.setBeneficiario("Israel Gonzalez Davila");
		cu.setNip("1234");
		cu.setNumCuenta("12211221");
		cu.setSaldo(5000);
		cu.setSaldoMax(20000);
		cu.setSaldoMin(100);

		Cajero ca = new Cajero();

		Cuenta[] database1 = new Cuenta[3];
		Cuenta db1 = new Cuenta("Israel Gonzalez Davila", "12211221", 5000, "1234", 20000, 100);
		Cuenta db2 = new Cuenta("Daniel Tapia", "13311331", 3000, "2345", 20000, 1000);
		Cuenta db3 = new Cuenta("Miguel Angel LP", "14411441", 5000, "3456", 20000, 100);

		ca.setDatabase(database1);
		ca.setDireccion("Villa Carmel 5111 50200");

		Ticket ti = new Ticket();

		ti.setDireccion(ca.getDireccion());
		ti.setFolio("0001");
		ti.setTipoOperacion(sc.next());
		ti.setNumCuenta(sc.next());
		ti.setSaldoActual(cu.saldo);
		ti.setMonto(sc.nextDouble());
		ti.setFecha(new Date());
		System.out.println(ti);

	}

}
