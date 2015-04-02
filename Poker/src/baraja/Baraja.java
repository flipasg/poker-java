/**
 * Poker - juego : Baraja.java
 * @author Iker Garcia Ramirez
 * @date 31/3/2015
 */
package baraja;

import java.util.Random;

//Comienza la clase Baraja
public class Baraja {
    private static final int NUMERO_DE_CARTAS = 52; //m�ximo de cartas en una baraja
    private Carta[] baraja; //baraja de cartas, array de objetos Carta
    private int cartaActual = 0; //indice de la carta actual
    
    /**
     * Constructor de la clase Baraja
     */
    public Baraja() {
	//instanciamos la baraja
	baraja = new Carta[NUMERO_DE_CARTAS];
	
	//llenamos la baraja en orden
	for (int i = 0; i < 4; i++) {
	    for (int j = 0; j < 13; j++) {
		baraja[cartaActual] = new Carta(j, i);
		cartaActual++;
	    }
	}
	
	//colocamos el �ndice de la carta actual sobre la primera
	cartaActual = 0;
    }
    
    /**
     * M�todo obtener : getBaraja
     * @return el baraja de la clase
     */
    public Carta[] getBaraja() {
        return baraja;
    }
    
    /**
     * M�todo obtener : getCartaActual
     * @return el cartaActual de la clase
     */
    public int getCartaActual() {
        return cartaActual;
    }

    /**
     * M�todo : barajar
     */
    public void barajar() {
	Random rnd = new Random();
	
	//mientras la carta no llegue a 52
	while(cartaActual<52) {
	    
	    //seleccionamos una carta aleatoria
	    int cartaAleatoria = rnd.nextInt(NUMERO_DE_CARTAS);
	    
	    //vamos intercambiando cartas aletoriamente (52 veces)
	    Carta auxiliar = baraja[cartaActual];
	    baraja[cartaActual] = baraja[cartaAleatoria];
	    baraja[cartaAleatoria] = auxiliar;
	    cartaActual++;
	}
	
	cartaActual = 0; //volvemos a colocarnos en el inicio de la baraja
    }

    /**
     * M�todo : repartirCarta
     * @return
     */
    public Carta repartirCarta() {
	//guardamos la carta actual
	Carta actual = baraja[cartaActual];
	cartaActual++; //pasamos a la carta siguiente
	return actual; //devolvemos la carta guardada
    }
}
