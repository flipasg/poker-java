/**
 * Poker - jugador : Jugador.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package jugador;

import baraja.Carta;

//Comienza la clase Jugador
public class Jugador {
    private String nombre;
    private Mano manoJugador;
    
    public Jugador(String nombre) {
    	this.nombre = nombre;
    	manoJugador = new Mano();
    }
    
    public void recibirCarta(Carta c) {
    	manoJugador.anadirCarta(c);
    }
    
    /**
	 * @return the manoJugador
	 */
	public Mano getManoJugador() {
		return manoJugador;
	}

	public void descartasCarta(int numeroDeCarta) {
    	manoJugador.quitarCarta(numeroDeCarta);
    }
	
	public Jugador determinarGanador(Jugador j) {
		
		if(manoJugador.getJugada()>j.manoJugador.getJugada()) return this;
		else if (manoJugador.getJugada()<j.manoJugador.getJugada()) return j;
		else {
			if(manoJugador.valorCartaMasAlta()>j.manoJugador.valorCartaMasAlta())
				return this;
			else if(manoJugador.valorCartaMasAlta()<j.manoJugador.valorCartaMasAlta())
				return j;
			else return null;
		}
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	public String verJugador() {
		return nombre + "\n" + manoJugador.verMano();
		
	}
}
