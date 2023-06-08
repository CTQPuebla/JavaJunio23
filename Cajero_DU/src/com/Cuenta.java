package com;

public class Cuenta {
	
	String beneficioario;
	String numCuenta;
	double saldo;
	String nip;
	double saldoMax;
	double saldoMin;
	
	public Cuenta() {
		
	}

	public Cuenta(String beneficioario, String numCuenta, double saldo, String nip, double saldoMax, double saldoMin) {
		this.beneficioario = beneficioario;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.nip = nip;
		this.saldoMax = saldoMax;
		this.saldoMin = saldoMin;
	}

	public String getBeneficioario() {
		return beneficioario;
	}

	public void setBeneficioario(String beneficioario) {
		this.beneficioario = beneficioario;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public double getSaldoMax() {
		return saldoMax;
	}

	public void setSaldoMax(double saldoMax) {
		this.saldoMax = saldoMax;
	}

	public double getSaldoMin() {
		return saldoMin;
	}

	public void setSaldoMin(double saldoMin) {
		this.saldoMin = saldoMin;
	}
	
	

	@Override
	public String toString() {
		return "Cuenta [beneficioario=" + beneficioario + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", nip="
				+ nip + ", saldoMax=" + saldoMax + ", saldoMin=" + saldoMin + "]";
	}
	
	
	
	

}
