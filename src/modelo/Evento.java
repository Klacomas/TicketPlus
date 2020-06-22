package modelo;
import java.util.Scanner;
import java.util.ArrayList;
import modelo.EntradaVip;
public class Evento {
    //DECLARACION DE LAS VARIABLES PRIVADAS
    protected String nombreEvento;
    protected int edadMinima;
    protected int cantTicket;
    
    protected ArrayList<EntradaVip> listEntrada;
    protected Boolean enCurso;
    protected int nroUsadas;
    protected int nroVendidas;
    
    //constructor
    
    public Evento(String nombreEvento, int edadMinima, int cantTicket, ArrayList<EntradaVip> listEntrada,
            Boolean enCurso, int nroUsadas, int nroVendidas) {
        super();
        this.nombreEvento = nombreEvento;
        this.edadMinima = edadMinima;
        this.cantTicket = cantTicket;
        this.listEntrada = listEntrada;
        this.enCurso = enCurso;
        this.nroUsadas = nroUsadas;
        this.nroVendidas = nroVendidas;
    }
    
    //CREACION DE LOS SETTERS Y GETTERS PARA CADA VARIABLE PARA QUE PUEDAN SER LLAMADOS DESDE OTRA CLASE
    //CONJUNTO DEL NOMBRE DEL EVENTO
    public String getNombreEvento() {
        return nombreEvento;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
        
    }
    //CONJUNTO PARA LA EDAD MINIMA REQUERIDA DEL EVENTO
    public int getEdadMinima() {
        return edadMinima;
    }
    public void setEdadMinima(int edadMinima) {
        this.edadMinima = edadMinima;
    }
    public ArrayList<EntradaVip> getListEntrada() {
        return listEntrada;
    }
    public void setListEntrada(ArrayList<EntradaVip> listEntrada) {
        this.listEntrada = listEntrada;
    }
    public Boolean getEnCurso() {
        return enCurso;
    }
    public void setEnCurso(Boolean enCurso) {
        this.enCurso = enCurso;
    }
    public Integer getNroUsadas() {
        return nroUsadas;
    }
    public void setNroUsadas(int nroUsadas) {
        this.nroUsadas = nroUsadas;
    }
    public Integer getNroVendidas() {
        return nroVendidas;
    }
    public void setNroVendidas(int nroVendidas) {
        this.nroVendidas = nroVendidas;
    }
    
    public int getCantTicket() {
        return cantTicket;
    }
    public void setCantTicket(int cantTicket) {
        this.cantTicket = cantTicket;
    }

         
    public void cambiarEstado(boolean enCurso) {
        setEnCurso(enCurso);    
    }

	@Override
	public String toString() {
		return "Evento [nombreEvento=" + nombreEvento + ", edadMinima=" + edadMinima + ", cantTicket=" + cantTicket
				+ ", listEntrada=" + listEntrada + ", enCurso=" + enCurso + ", nroUsadas=" + nroUsadas
				+ ", nroVendidas=" + nroVendidas + "]";
	}
    
    
    
}

