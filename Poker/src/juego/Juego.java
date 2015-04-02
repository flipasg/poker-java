package juego;

import java.util.ArrayList;
import java.util.Iterator;

import baraja.Baraja;
import baraja.Carta;
import jugador.Jugador;
import jugador.Mano;

public class Juego {
	private int jugadoresSentados;
	private ArrayList<Jugador> jugadores;
	private Baraja baraja;
	private Jugador ganador;
	
	public Juego(int numeroDeJugadores) {
		jugadores = new ArrayList<Jugador>(numeroDeJugadores);
		baraja = new Baraja();
		ganador = null; //no hay ganador aun
		jugadoresSentados = 0;
	}
	
	public boolean anadirJugador(Jugador j) {
			jugadores.add(j);
			return true;
	}
	
	public void repartir() {
		baraja.barajar();
		int cartasMaximas = Mano.getCartasMaximas();
		for (Iterator<Jugador> it = jugadores.iterator(); it.hasNext();) {
			Jugador jugadorActual = (Jugador) it.next();
			for (int i = 0; i < cartasMaximas; i++) {
				Carta cartaActual = baraja.repartirCarta();
				jugadorActual.recibirCarta(cartaActual);
			}
			jugadorActual.getManoJugador().determinarMano();
		}
		
		
	}
	
	public Jugador evaluarGanador() {
		Jugador j1 = jugadores.get(0);
		Jugador j2 = jugadores.get(1);
		
		return j1.determinarGanador(j2);
	}
	
	/**
	 * @return the jugadores
	 */
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public static void main(String[] args) {
		Juego j = new Juego(2);
		j.anadirJugador(new Jugador("Iker"));
		j.anadirJugador(new Jugador("Patri"));
		j.repartir();
		
		for (Iterator<Jugador> it= j.jugadores.iterator(); it.hasNext();) {
			Jugador jgu = (Jugador) it.next();
			System.out.println(jgu.verJugador());
		}
		
		if(j.evaluarGanador()!=null)
			System.out.println("Ha ganado " + j.evaluarGanador().getNombre());
		else System.out.println("Empate");
	}
}
