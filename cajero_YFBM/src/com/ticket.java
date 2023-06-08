package com;

import java.util.Date;

public class ticket {
	
	String direccion;
	int folio;
	String tipoOpredacion;
	String numeroCuenta;
	double saldoActual;
	double monto;
	Date fecha;
	
	public ticket() {
		
	}

	public ticket(String direccion, int folio, String tipoOpredacion, String numeroCuenta, double saldoActual,
			double monto, Date fecha) {
		this.direccion = direccion;
		this.folio = folio;
		this.tipoOpredacion = tipoOpredacion;
		this.numeroCuenta = numeroCuenta;
		this.saldoActual = saldoActual;
		this.monto = monto;
		this.fecha = fecha;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getFolio() {
		return folio;
	}

	public void setFolio(int folio) {
		this.folio = folio;
	}

	public String getTipoOpredacion() {
		return tipoOpredacion;
	}

	public void setTipoOpredacion(String tipoOpredacion) {
		this.tipoOpredacion = tipoOpredacion;
	}

	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "ticket [direccion=" + direccion + ", folio=" + folio + ", tipoOpredacion=" + tipoOpredacion
				+ ", numeroCuenta=" + numeroCuenta + ", saldoActual=" + saldoActual + ", monto=" + monto + ", fecha="
				+ fecha + "]";
	}
	
	
	
	

}
