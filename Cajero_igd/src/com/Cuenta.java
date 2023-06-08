package com;

public class Cuenta {
	String beneficiario;
	String numCuenta;
	double saldo;
	String nip;
	double saldoMax;
	double saldoMin;
	
	
	public Cuenta() {
		
	}


	public Cuenta(String beneficiario, String numCuenta, double saldo, String nip, double saldoMax, double saldoMin) {
		super();
		this.beneficiario = beneficiario;
		this.numCuenta = numCuenta;
		this.saldo = saldo;
		this.nip = nip;
		this.saldoMax = saldoMax;
		this.saldoMin = saldoMin;
	}


	public String getBeneficiario() {
		return beneficiario;
	}


	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
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
		return "Cuenta [beneficiario=" + beneficiario + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", nip=" + nip
				+ ", saldoMax=" + saldoMax + ", saldoMin=" + saldoMin + "]";
	}
	

}
