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
    private Carta[] mano;
    
    /**
     * Constructor de la clase Mano
     * @param mano
     */
    public Mano(Carta[] mano) {
	this.mano = mano;
    }

    
    
    
    
}
