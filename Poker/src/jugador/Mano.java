/**
 * Poker - jugador : Mano.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package jugador;

import java.util.Arrays;

import baraja.Carta;

//Comienza la clase Mano
public class Mano {
    private static final String[] JUGADAS =
	{"Carta alta", "Pareja", "Doble Pareja", "Trio", "Escalera", "Color", 
	"Full House", "Poquer", "Escalera de color", "Escalera real"};
    private int jugada; //0 Carta alta, 9 Escalera real
    private Carta[] mano; //array de 5 cartas ordenadas
    
    /**
     * Constructor de la clase Mano
     * @param mano
     */
    public Mano(Carta[] mano) {
	Arrays.sort(mano); //ordenamos las cartas
	this.mano = mano; //instanciamos la mano
    }
    
    /**
     * Método obtener : getJugada
     * @return el jugada de la clase
     */
    public int getJugada() {
        return jugada;
    }

    /**
     * Método obtener : getMano
     * @return el mano de la clase
     */
    public Carta[] getMano() {
        return mano;
    }

    public int cartasDistintas() {
	int cartasDistintas = 1;
	int comparada = 1;
	int actual = 0;
	while(actual<mano.length && comparada<mano.length) {
	    if(mano[actual].equals(mano[comparada])) {
		comparada++;
	    } else {
		actual = comparada;
		comparada++;
		cartasDistintas++;
	    }
	}
	
	return cartasDistintas;
    }
    
    
    
    
}
