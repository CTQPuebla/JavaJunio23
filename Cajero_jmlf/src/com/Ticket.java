package com;

import java.util.Date;

public class Ticket {
String direccion;
String folio;
String tipoOperacion;
String numCuenta;
double saldoActual;
double monto;
Date fecha;
	
public Ticket() {
	
}

public Ticket(String direccion, String folio, String numCuenta, String tipoOperacion, double saldoActual, double monto,
		Date fecha) {
	super();
	this.direccion = direccion;
	this.folio = folio;
	this.numCuenta = numCuenta;
	this.tipoOperacion = tipoOperacion;
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

public String getNumCuenta() {
	return numCuenta;
}

public void setNumCuenta(String numCuenta) {
	this.numCuenta = numCuenta;
}

public String getTipoOperacion() {
	return tipoOperacion;
}

public void setTipoOperacion(String tipoOperacion) {
	this.tipoOperacion = tipoOperacion;
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
	return "Ticket [direccion=" + direccion + ", folio=" + folio + ", numCuenta=" + numCuenta + ", tipoOperacion="
			+ tipoOperacion + ", saldoActual=" + saldoActual + ", monto=" + monto + ", fecha=" + fecha + "]";
}
	
	
	
}
