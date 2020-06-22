package Main;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;
import modelo.EntradaVip;
import modelo.Evento;
import modelo.Vendedor;

public class MainClass {

		static ArrayList<Evento> lstEventos=obtenerListaEvento();
		static ArrayList<Cliente> lstClientes=obtenerListaClientes();
		static ArrayList<Vendedor> lstVendedores=obtenerListaVendedores();
		
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String opcion = "salir";
		while(!opcion.equals("9")) {
		
			System.out.println("1--Crear evento\n");
			System.out.println("2--Vender entrada\n");
			System.out.println("3--Ingresar a evento\n");
			System.out.println("4--Cambiar estado de evento\n");
			System.out.println("5--Entradas vendidas por vendedor\n"); //listo
			System.out.println("9--salir");
			
			opcion = sc.nextLine();
		
			if(opcion.equals("1")) {
				crearEvento();
			}
			else if(opcion.equals("2")) {
				venderEntrada();
			}
			else if(opcion.equals("3")) {
				ingresoDeEvento();
			}
			else if(opcion.equals("4")) {
				System.out.printf("Cambio de estado seleccionado\n"); 
				cambioDeEstado();
			}
			else if(opcion.equals("5")) {
				System.out.printf("Entradas vendidas por vendedor\n");
				entradasVendidas();
			}
			else if(opcion.equals("9")) {
				System.out.printf("Salir\n");
			}
			else  {
				System.out.printf("numero no ingresado correctamente\n");
			}

		}
		//sc.close();
	}
	

	private static void entradasVendidas() {
		
		int vendidasENormales = 0;
		int vendidasEVip = 0;
		String nombreDelVendedor = null;
		
		//este metodo es para calcular la cantidad de entradas vendidas por el vendedor
		System.out.println("---Calculo entrada vendida por vendedor---");
		System.out.println("Ingrese rut del vendedor");
		Scanner sc = new Scanner (System.in); //se declara una variable sc de tipo scanner y se instancia con la clase scanner
		String rutVendedor ;        // se declara la variable rutvendedor del tipo string
		rutVendedor = sc.nextLine(); //se asigna el valor ingresado por teclado a la variable rutvendedor
		
		//ArrayList<Vendedor>lstVendedores = new ArrayList<Vendedor>();
		//lstVendedores = obtenerListaVendedores();

		for (Vendedor vendedortmp :lstVendedores) {
						
			if (rutVendedor.equals(vendedortmp.getRut())) {
				 vendidasENormales = vendedortmp.getVendidasENormales();
				
				 vendidasEVip = vendedortmp.getVendidasEVip();
				
				 nombreDelVendedor = vendedortmp.getNombre(); //se crea la variable nombre del vendedor y se muestra
				
				
				break;
			}
			
		}
		System.out.println("las entradas vendidas por el vendedor :" + nombreDelVendedor  + " son : " +
		vendidasENormales + " entradas normmales y "+ vendidasEVip + " entradas vip" );
		//sc.close();
	}

	private static ArrayList<Vendedor> obtenerListaVendedores() {
		
		ArrayList<Vendedor> listaVendedores = new ArrayList <Vendedor> ();
		
		Vendedor vendedor = null ;
		
		
		 try {
		 vendedor = new Vendedor("19" , "luis"  , 20 , 30);//instanciar objeto del tipo vendedor 
		 listaVendedores.add (vendedor);
		 vendedor = new Vendedor("20" , "juan" ,  21 , 32);//instanciar objeto del tipo vendedor 
		 listaVendedores.add (vendedor);
		 vendedor = new Vendedor("21" , "pepe" ,  21 , 32);//instanciar objeto del tipo vendedor 
		 listaVendedores.add (vendedor);
	
		}	catch (Exception e) {
			e.printStackTrace();
		}

		return listaVendedores;
	}
	

	private static void cambioDeEstado() {
		Scanner sc = new Scanner(System.in);
		String nombreEvento="";
		String strEstado="";
		boolean enCurso=false;
		System.out.println("---Cambiar estado de evento---");
		System.out.println("Nombre de evento a modificar");
		nombreEvento=sc.nextLine();
		System.out.println("Ingrese nuevo estado");
		strEstado=sc.nextLine();
		if(strEstado.equals("En Curso")) {
			enCurso=true;
		}
		Evento evento=buscarEvento(nombreEvento);
		if(evento!=null) {
			evento.setEnCurso(enCurso);
			System.out.println("El evento " + evento.getNombreEvento() + " se ha cambiado. En curso=" + enCurso);
		}else {
			System.out.println("Evento no encontrado");
		}
//		sc.close();
	}

	private static void ingresoDeEvento() {
		//valida el ingresadas al evento/usos de entradas
		Scanner sc=new Scanner(System.in);
		System.out.println("---Ingreso a evento---");
		System.out.println("Ingrese nombre evento");
		String nombreEvento=sc.nextLine();
		System.out.println("Ingrese numero de entrada");
		int nroEntrada=Integer.parseInt(sc.nextLine());
		System.out.println("Ingrese rut cliente");
		String rutCliente=sc.nextLine();
		Cliente cliente = buscarCliente(rutCliente, obtenerListaClientes());
		if(cliente!=null) {
			Evento evento=buscarEvento(nombreEvento);
			if(evento!=null) {
				System.out.println("Usando entrada con cliente " + cliente.getNombre() +" - "+ cliente.getRut() + " para evento " + evento.getNombreEvento());
				if(evento.getEnCurso()) {
					EntradaVip entrada=buscarEntrada(nroEntrada,evento);
					if(entrada!=null) {
						if(!entrada.isEsUsada()) {
							if (validaRutEntrada(rutCliente,entrada)) {
								System.out.println("Entrada encontrada. " + cliente.getNombre() + " puede pasar.");
								if(entrada.isEsVip()) {
									System.out.println("Entrada Vip. Entregar regalo");
								}
								entrada.setEsUsada(true);
							}else {
								System.out.println("Rut cliente no corresponde");
							}
						}else {
							System.out.println("Entrada para rut "+ cliente.getRut() +" ya fue usada. No puede pasar.");
						}
					}else {
						System.out.println("Entrada no encontrada");
					}
				}else {
					System.out.println("No se puede usar la entrada porque el evento "  + evento.getNombreEvento() + " no está en curso.");
				}
				
			}else {
				System.out.println("Evento no encontrado");
			}
		}else {
			System.out.println("Cliente no encontrado");
		}
//		sc.close();
	}
	
	private static ArrayList<Cliente> obtenerListaClientes() {
		ArrayList<Cliente> lstCliente = new ArrayList<Cliente>();
		Cliente cliente = null;
		
        cliente=new Cliente("19","Luis",convertirAFecha("15-01-1998"));
        lstCliente.add(cliente);
        cliente=new Cliente("20","Paula",convertirAFecha("15-01-1999"));
        lstCliente.add(cliente);
        cliente=new Cliente("21","Yael",convertirAFecha("15-01-2000"));
        lstCliente.add(cliente);
        
		return lstCliente;
	}

	private static LocalDate convertirAFecha(String strFecha) {
		LocalDate date=null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        date = LocalDate.parse(strFecha, formatter);
	    return date;
	}

	private static boolean validaRutEntrada(String rutCliente, EntradaVip entrada) {
		boolean validaRut=false;
		if(entrada.getNroCliente().equals(rutCliente)) {
			validaRut=true;
		}
		
		
		return validaRut;
	}


	private static EntradaVip buscarEntrada(int nroEntrada, Evento evento) {
		ArrayList <EntradaVip> lstEntrada= evento.getListEntrada();
		EntradaVip entradaOut = null;
		for(EntradaVip entrada:lstEntrada) {
			if(entrada.getNroAsiento()==nroEntrada) {
				entradaOut=entrada;
			}
		}
		return entradaOut;
	}


	private static Evento buscarEvento(String nombreEvento) {
		Evento eventoOut = null;
		for(Evento evento:lstEventos) {
			if(evento.getNombreEvento().equals(nombreEvento)) {
				eventoOut=evento;
			}
		}
		return eventoOut;
	}


	private static Cliente buscarCliente(String rutCliente, ArrayList<Cliente> lstCliente) {
		Cliente clienteOut = null;
		for(Cliente cliente:lstCliente) {
			if(cliente.getRut().equals(rutCliente)) {
				clienteOut=cliente;
			}
		}
		return clienteOut;
	}


	private static ArrayList<Evento> venderEntrada() {
		Scanner sc = new Scanner (System.in);
		boolean esVip=false;
		boolean eventoEncontrado=false;
		boolean quedanEntradas=false;

		//		Solicita datos de entrada
		System.out.println("---Venta de entradas---");
		System.out.println("Ingrese nombre evento:");
		String nombreEvento= sc.nextLine();
		System.out.println("Ingrese rut cliente:");
		String rutCliente= sc.nextLine();
		System.out.println("Ingrese rut vendedor:");
		String rutVendedor=sc.nextLine();
		System.out.println("Ingrese tipo entrada:");
		System.out.println("1.- Entrada Vip");
		System.out.println("2.- Entrada Normal");
		int tipoEntrada=sc.nextInt();
		if(tipoEntrada==1) {
			esVip=true;
		}
		
		//valida el vendedor
		if(validaVendedor(rutVendedor)) {
			for(Evento evento:lstEventos) {
				if(evento.getNombreEvento().equals(nombreEvento)) {
					eventoEncontrado=true;
					Cliente cliente=buscarCliente(rutCliente,lstClientes);
					if(cliente!=null) {
							if(calcularEdad(cliente.getFechaNacimiento())>evento.getEdadMinima()) {	
							ArrayList<EntradaVip> lstEntradas = evento.getListEntrada();
							for(EntradaVip entrada:lstEntradas) {
								if(!entrada.isEsVendida()) {
									quedanEntradas=true;
									entrada.setNroCliente(rutCliente);
									entrada.setNroVendedor(rutVendedor);
									entrada.setEsVendida(true);
									evento.setNroVendidas(evento.getNroVendidas()+1);
									entrada.setEsVip(esVip);
									evento.setListEntrada(lstEntradas);
									lstEventos.add(evento);
									System.out.println("Entrada vendida " + entrada.getNroAsiento()+", detalle de la entrada:"+ entrada.toString());
									actualizaVendidas(rutVendedor, esVip);
									break;
								}
							}
							if(!quedanEntradas) {
								System.out.println("Todas las entradas vendidas");
							}
						}else {
							System.out.println("Cliente no cumple edad mínima");
						}
					}else {
						System.out.println("Cliente no encontrado");
					}
					break;					
				}
			}
			if(!eventoEncontrado) {
				System.out.println("Evento no encontrado");
			}
				
		}else {
			System.out.println("Vendedor no existe");
		}
		//sc.close();
		return lstEventos;
	}

	private static boolean validaVendedor(String rutVendedor) {
		
		boolean vendedorEncontrado= false;
		for(Vendedor vendedor:lstVendedores) {
			if(vendedor.getRut().equals(rutVendedor)) {
				vendedorEncontrado=true;
				break;
			}
		}

		
		return vendedorEncontrado;
	}


	private static ArrayList<Vendedor> actualizaVendidas(String rutVendedor, boolean esVip) {
		boolean existeVendedor=false;
		for(Vendedor vendedor:lstVendedores) {
			if(vendedor.getRut().equals(rutVendedor)) {
				if(esVip) {
					vendedor.setVendidasEVip(vendedor.getVendidasEVip()+1);
					
				}else {
					vendedor.setVendidasENormales(vendedor.getVendidasENormales()+1);
				}
				existeVendedor=true;
				System.out.println("Se actualizan las entradas del vendedor " + vendedor.getNombre());
				break;
			}
		}
		if(!existeVendedor) {
			System.out.println("Vendedor no encontrado");
		}
		return lstVendedores;
	}


	private static ArrayList<Evento> obtenerListaEvento() {
		
		ArrayList<EntradaVip> lstEntrada = crearListaEntradas(15,1200);
		ArrayList<Evento> lstEvento=new ArrayList<Evento>();
		Evento evento = new Evento("Lollapaloza", 18, 15,lstEntrada,false,0,0);
		lstEvento.add(evento);
		lstEntrada = crearListaEntradas(20,1500);
		evento=new Evento("Festigame",20,20,lstEntrada, false,0,0);
		lstEvento.add(evento);

		return lstEvento;
	}


	private static void crearEvento() {
		//crear evento
		
		String nombreDelEvento  ;    //declaracion de variable de tipo string nombre del evento
		int edadMinima  ;      //declarando variable de tipo int edad minima
		int canTicket ; //variable de tipo int cantidad de ticket
		int  precioTicket;  //variable tipo int precio de ticket
		Scanner sc = new Scanner (System.in);
		
		System.out.println("---Crear evento---"); //pedir al usuario los datos del evento
		System.out.println("Nombre del evento");
		nombreDelEvento = sc.nextLine();
		
		System.out.println("Edad mínima de ingreso");
		
		edadMinima = sc.nextInt();
		
		System.out.println("Ingresar cantidad de ticket a generar");
		canTicket = sc.nextInt ();
		
		
		System.out.println("precio del ticket");
		 precioTicket = sc.nextInt ();
		 
		 ArrayList<EntradaVip> lstEntradas = crearListaEntradas(canTicket,precioTicket);
		 
		 		 
		 Evento evento =  new Evento(nombreDelEvento,edadMinima,canTicket, lstEntradas,false,0,0);
		 lstEventos.add(evento);
		 System.out.println("Evento " + evento.getNombreEvento() + " creado ");
		 System.out.println("Detalles del evento " + evento.toString());
		 
	}

	
   public static ArrayList<EntradaVip> crearListaEntradas (int cantTicket, int precio) {//retorna cantTicket, precio, devuelve el aarray
       ArrayList<EntradaVip> entradasEvento = new ArrayList<EntradaVip>();
        int i;
        for(i=0;i<cantTicket;i++) {
        	EntradaVip entrada = new EntradaVip(i+1,precio,"19","",false,false,true); 
            entradasEvento.add(entrada);
        }
        return entradasEvento;
    }

   public static int calcularEdad(LocalDate fechaNacimiento) {

		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, hoy);
		return periodo.getYears();
	}

}
