package modelo;

import java.util.Date;

public class EntradaVip extends Entrada{

	protected boolean esVip;

	public EntradaVip(int nroAsiento, int precio, String nroCliente, String nroVendedor, boolean esVendida,
			boolean esUsada, boolean esVip) {
		super(nroAsiento, precio, nroCliente, nroVendedor, esVendida, esUsada);
		this.esVip = esVip;
	}

	public boolean isEsVip() {
		return esVip;
	}

	public void setEsVip(boolean esVip) {
		this.esVip = esVip;
	}
	
	
	
	

}
