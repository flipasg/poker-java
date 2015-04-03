package juego;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import jugador.Jugador;
import jugador.Mano;
import baraja.Baraja;
import baraja.Carta;

public class Juego {
    private int numeroDeJugadores;
    private int jugadoresSentados;
    private ArrayList<Jugador> jugadores;
    private Baraja baraja;
    
    /**
     * Constructor de la clase Juego
     */
    public Juego() {
	jugadores = new ArrayList<Jugador>();
	baraja = new Baraja();
	jugadoresSentados = 0;
	numeroDeJugadores = 0;
    }
    
    /**
     * Metodo obtener : getJugadores
     * @return el jugadores de la clase
     */
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    /**
     * Metodo : anadirJugador
     * @param j
     * @return boolean si pudo aniadirse (o no) el jugador
     */
    public boolean anadirJugador(Jugador j) {
	if(jugadoresSentados>=numeroDeJugadores) return false;
	else {
	    jugadores.add(j);
	    jugadoresSentados++;
	    return true;
	}
    }
    
    /**
     * Metodo : repartir
     */
    public void repartir() {
	baraja.barajar(); //barajamos la baraja
	int cartasMaximas = Mano.getCartasMaximas(); //obtenemos las cartas maximas en cada mano
	for (Iterator<Jugador> it = jugadores.iterator(); it.hasNext();) {
	    Jugador jugadorActual = (Jugador) it.next();
	    Mano manoJugadorActual = jugadorActual.getManoJugador();
	    for (int i = 0; i < cartasMaximas; i++) {
		Carta cartaActual = baraja.repartirCarta(); //obtenemos la carta
		manoJugadorActual.anadirCarta(cartaActual); //aniadimos la carta a la mano
	    }
	    jugadorActual.getManoJugador().determinarMano(); //determinamos la jugada de la mano
	}
    }
    
    /**
     * Metodo : descartar
     */
    public void descartar(){ //se puede modular mas
	int cartasMaximas = Mano.getCartasMaximas();
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	for (Iterator<Jugador> it = jugadores.iterator(); it.hasNext();) {
	    Jugador jugadorActual = (Jugador) it.next();
	    Mano manoJugadorActual = jugadorActual.getManoJugador();
	    System.out.println(jugadorActual.getNombre().toUpperCase());
	    Carta[] listaCartas = manoJugadorActual.getMano();
	    
	    for (int i = 0; i < listaCartas.length; i++) {
		System.out.println(i + " - "+ listaCartas[i].verCarta());
	    }
	    
	    System.out.println("\nDesea descartar alguna carta? S/N");
	    String respuesta = "";
	    
	    try {
		respuesta = bf.readLine();
	    } catch (IOException e2) {
		System.err.println("Error de entrada/salida");
	    }
	    
	    if (respuesta.toUpperCase().startsWith("S")) {
		
		int cartasADescartar = 0;
		try {
		    do {
			System.out.println("Cuantas cartas desea descartar (MAXIMO 5)");
			cartasADescartar = Integer.parseInt(bf.readLine());
		    } while (cartasADescartar>5 || cartasADescartar<0);
		    
		} catch (NumberFormatException | IOException e) {
		    System.err.println("Debe ser un numero entero");
		    System.out.println("Cuantas cartas desea descartar ");
		    try {
			cartasADescartar = Integer.parseInt(bf.readLine());
		    } catch (NumberFormatException | IOException e1) {
			System.err.println("No se descarta ninguna carta");
		    }
		}
		
		for (int i = 0; i < cartasADescartar; i++) {
		    int indiceCarta = -1;
		    do {
			
			System.out.println("Dime la " + (i+1) + " carta a descartar");
			
			try {
			    indiceCarta = Integer.parseInt(bf.readLine());
			} catch (NumberFormatException | IOException e) {
			    System.err.println("Debe ser un numero entero");
			    System.out.println("Cuantas cartas desea descartar ");
			    try {
				cartasADescartar = Integer.parseInt(bf.readLine());
			    } catch (NumberFormatException | IOException e1) {
				System.err.println("Debe ser un numero valido");
			    }
			}
			
		    } while (indiceCarta<0 && indiceCarta>cartasMaximas);
		    
		    //quitamos la carta y repartimos otra
		    manoJugadorActual.quitarCarta(indiceCarta);
		    manoJugadorActual.anadirCarta(baraja.repartirCarta(), indiceCarta);
		}
	    }
	    jugadorActual.getManoJugador().determinarMano(); //determinamos la jugada de la mano
	}
    }
    
    /**
     * Metodo : inicio
     */
    public void inicio() {
	BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Dime el numero de jugadores ");
	
	try {
	    numeroDeJugadores = Integer.parseInt(bf.readLine());
	} catch (NumberFormatException | IOException e) {
	    System.err.println("Debe ser un numero entero");
	    try {
		numeroDeJugadores = Integer.parseInt(bf.readLine());
	    } catch (NumberFormatException | IOException e1) {
		System.err.println("La partida sera de dos jugadores");
		numeroDeJugadores = 2;
	    }
	}
	
	for (int i = 0; i < numeroDeJugadores; i++) {
	    System.out.println("Dime el nombre del jugador "+(i+1));
	    String nombre = "";
	    
	    try {
		nombre = bf.readLine();
	    } catch (IOException e) {
		System.err.println("El jugador sera " + nombre);
	    }
	    
	    if(nombre.equals("")) {
		nombre = "USER"+(i+1);
		System.out.println("El jugador sera " + nombre);
	    }
	    
	    //aniadimos el jugador
	    anadirJugador(new Jugador(nombre));
	}
    }
    
    /**
     * Metodo : evaluarGanador
     * @return Jugador ganador
     */
    public Jugador evaluarGanador() {
	Iterator<Jugador> it = jugadores.iterator(); 
	Jugador j1 = it.next();
	while (it.hasNext()) {
	    Jugador jug = (Jugador) it.next();
	    j1 = j1.determinarGanador(jug); //el mejor jugador se compara al siguiente
	}
	
	return j1;
    }
    
    /**
     * Metodo : verMesa
     */
    public void verMesa() {
	for (Iterator<Jugador> it= jugadores.iterator(); it.hasNext();) {
	    Jugador jgu = (Jugador) it.next();
	    System.out.println(jgu.verJugador());
	}
    }
    
    /**
     * Metodo : resolucion
     */
    public void resolucion() {
	if(evaluarGanador()!=null)
	    System.out.println("Ha ganado " + evaluarGanador().getNombre());
	else System.out.println("Empate");
    }
    
    /**
     * Metodo : jugar
     */
    public void jugar() {
	inicio();
	repartir();
	descartar();
	verMesa();
	resolucion();
    }
    
}
