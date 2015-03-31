/**
 * Poker - juego : Baraja.java
 * @author Iker Garcia Ramirez
 * @date 31/3/2015
 */
package baraja;

import java.util.Random;

//Comienza la clase Baraja
public class Baraja {
    private static final int NUMERO_DE_CARTAS = 52;
    private Carta[] baraja;
    private int cartaActual = 0;
    
    public Baraja() {
	baraja = new Carta[NUMERO_DE_CARTAS];
	
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 13; j++) {
		baraja[cartaActual] = new Carta(j, i);
		cartaActual++;
	    }
	}
	
	cartaActual = 0;
    }
    
    /**
     * Método obtener : getBaraja
     * @return el baraja de la clase
     */
    public Carta[] getBaraja() {
        return baraja;
    }
    
    /**
     * Método obtener : getCartaActual
     * @return el cartaActual de la clase
     */
    public int getCartaActual() {
        return cartaActual;
    }

    public void barajar() {
	Random rnd = new Random();
	
	while(cartaActual<52) {
	    int cartaAleatoria = rnd.nextInt(NUMERO_DE_CARTAS);
	    Carta auxiliar = baraja[cartaActual];
	    baraja[cartaActual] = baraja[cartaAleatoria];
	    baraja[cartaAleatoria] = auxiliar;
	    cartaActual++;
	}
	
	cartaActual = 0;
    }

    public Carta repartirCarta() {
	Carta actual = baraja[cartaActual];
	cartaActual++;
	return actual;
    }
}
