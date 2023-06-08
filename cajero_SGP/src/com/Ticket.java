package com;

import java.util.Date;

public class Ticket {
	
	String direccion;
	String folio;
	String tipoOper;
	String numCuenta;
	double saldoActual;
	double monto;
	Date fecha;

	public Ticket() {
		
	}

	public Ticket(String direccion, String folio, String tipoOper, String numCuenta, double saldoActual, double monto,
			Date fecha) {
		super();
		this.direccion = direccion;
		this.folio = folio;
		this.tipoOper = tipoOper;
		this.numCuenta = numCuenta;
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

	public String getFolio() {
		return folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getTipoOper() {
		return tipoOper;
	}

	public void setTipoOper(String tipoOper) {
		this.tipoOper = tipoOper;
	}

	public String getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(String numCuenta) {
		this.numCuenta = numCuenta;
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
		return "Ticket [direccion=" + direccion + ", folio=" + folio + ", tipoOper=" + tipoOper + ", numCuenta="
				+ numCuenta + ", saldoActual=" + saldoActual + ", monto=" + monto + ", fecha=" + fecha + "]";
	}
		
}
