package modelo;

public class Vendedor extends Persona{

	protected int vendidasENormales;
	protected int vendidasEVip;
	
	public Vendedor(String rut, String nombre, int vendidasENormales, int vendidasEVip) {
		super(rut, nombre);
		this.vendidasENormales = vendidasENormales;
		this.vendidasEVip = vendidasEVip;
	}

	public int getVendidasENormales() {
		return vendidasENormales;
	}

	public void setVendidasENormales(int vendidasENormales) {
		this.vendidasENormales = vendidasENormales;
	}

	public int getVendidasEVip() {
		return vendidasEVip;
	}

	public void setVendidasEVip(int vendidasEVip) {
		this.vendidasEVip = vendidasEVip;
	}

}
