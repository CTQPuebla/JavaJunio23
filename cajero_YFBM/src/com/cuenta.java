package com;

public class cuenta {
	
	String beneficiario;
	String numCuenta;
	double saldo;
	int nip;
	double saldoMax;
	double saldoMin;
	
	
	public cuenta() {
		
	}

	public cuenta(String beneficiario, String numCuenta, double saldo, int nip, double saldoMax, double saldoMin) {
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

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
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
		return "cuenta [beneficiario=" + beneficiario + ", numCuenta=" + numCuenta + ", saldo=" + saldo + ", nip=" + nip
				+ ", saldoMax=" + saldoMax + ", saldoMin=" + saldoMin + "]";
	}
	
	
	
	
	
	
	

}
