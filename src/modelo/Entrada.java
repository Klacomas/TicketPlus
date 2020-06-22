package modelo;

import java.time.LocalDate;
import java.util.Date;

import modelo.Evento;
public class Entrada {
	protected int nroAsiento;
	protected int precio;
	protected String nroCliente;
	protected String nroVendedor;
	protected boolean esVendida;
	protected boolean esUsada;
	
	public Entrada(int nroAsiento, int precio, String nroCliente, String nroVendedor, boolean esVendida,
			boolean esUsada) {
		super();
		this.nroAsiento = nroAsiento;
		this.precio = precio;
		this.nroCliente = nroCliente;
		this.nroVendedor = nroVendedor;
		this.esVendida = esVendida;
		this.esUsada = esUsada;
	}
	public int getNroAsiento() {
		return nroAsiento;
	}
	public void setNroAsiento(int nroAsiento) {
		this.nroAsiento = nroAsiento;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getNroCliente() {
		return nroCliente;
	}
	public void setNroCliente(String nroCliente) {
		this.nroCliente = nroCliente;
	}
	public String getNroVendedor() {
		return nroVendedor;
	}
	public void setNroVendedor(String nroVendedor) {
		this.nroVendedor = nroVendedor;
	}
	public boolean isEsVendida() {
		return esVendida;
	}
	public void setEsVendida(boolean esVendida) {
		this.esVendida = esVendida;
	}
	public boolean isEsUsada() {
		return esUsada;
	}
	public void setEsUsada(boolean esUsada) {
		this.esUsada = esUsada;
	}
	
	public boolean validarEdadCliente(Evento evento, LocalDate fechaNacimiento) {
		int edadCliente = Cliente.calcularEdad(fechaNacimiento);
		return (edadCliente >= evento.getEdadMinima())?true:false; 
	}
	@Override
	public String toString() {
		return "Entrada [nroAsiento=" + nroAsiento + ", precio=" + precio + ", nroCliente=" + nroCliente
				+ ", nroVendedor=" + nroVendedor + ", esVendida=" + esVendida + ", esUsada=" + esUsada + "]";
	}

}
