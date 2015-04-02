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
    //array con las jugadas posibles
    private static final String[] JUGADAS =
	{"Carta mas alta", "Pareja", "Doble pareja", "Trio", "Escalera", "Color", 
	"Full house", "Poquer", "Escalera de color", "Escalera real"};
    private int jugada; //0 Carta mas alta, 9 Escalera real
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
    
    /**
     * Método : determinarMano
     */
    public void determinarMano() {
	if(escaleraReal()) jugada = 9;
	else if(escaleraDeColor()) jugada = 8;
	else if(poquer()) jugada = 7;
	else if(fullHouse()) jugada = 6;
	else if(color()) jugada = 5;
	else if(escalera()) jugada = 4;
	else if(trio()) jugada = 3;
	else if(doblesParejas()) jugada = 2;
	else if(pareja()) jugada = 1;
	else if(cartaMasAlta()) jugada = 0;
    }
    
    /**
     * Método : mostrarJugada
     * @return String de la jugada
     */
    public String mostrarJugada() {
	return JUGADAS[jugada];
    }
    
    
    ///////////////////////////////////
    //métodos auxiliares de la clase//
    /////////////////////////////////
    
    
    /**
     * Método : cartasDistintas
     * @return int cantidad de cartas distintas
     */
    private int cartasDistintas() {
	int cartasDistintas = 1; //nunca van a poder ser todas las cartas iguales
	int comparada = 1; //empezamos a comparar con la segunda carta
	int actual = 0; //la carta actual a comparar sera la primera
	
	
	//mientras ninguno de los indices sea mayor que 4
	while(actual<mano.length && comparada<mano.length) {
	    
	    //si la carta actual es igual a la comparada
	    if(mano[actual].equals(mano[comparada])) {
		comparada++; //pasamos a la siguiente carta a comparar
	    } else { //si no
		actual = comparada; //pasamos la comparada a la actual a comparar
		comparada++; //incrementamos la carta comparada
		cartasDistintas++; //al no ser iguales incrementamos las cartas distintas
	    }
	}
	
	return cartasDistintas;
    }
    
    /**
     * Método : cartaMasRepetida
     * @return int numero de repeticiones de la carta mas repetida
     */
    private int cartaMasRepetida() {
	//metodo similar al cartasDistintas
	//este determina cuantas veces se repite la carta mas repetida
	int maximoDeRepeticiones = 0; //inicializamos a un valor menor a los posibles
	int numeroDeRepeticiones = 1; //siempre va a haber minimo una carta
	
	int comparada = 1;
	int actual = 0;
	while(actual<mano.length && comparada<mano.length) {
	    if(mano[actual].equals(mano[comparada])) {
		comparada++;
		numeroDeRepeticiones++;
	    } else {
		actual = comparada;
		comparada++;
		
		//si el maximo de repeticiones es menor al
		//numero de repeticiones de la carta actual
		if(maximoDeRepeticiones<numeroDeRepeticiones) 
		    maximoDeRepeticiones = numeroDeRepeticiones; //el numero maximo de repeticiones pasa a ser el actual
		numeroDeRepeticiones = 0; //reinicializamos el numero de repeticiones
	    }
	}
	
	return maximoDeRepeticiones;
    }
    
    /**
     * Método : mismoPalo
     * @return boolean si todos los palos son (o no) iguales
     */
    private boolean mismoPalo() {
	int primerPalo = mano[0].getPalo();
	for (int i = 1; i < mano.length; i++) {
	    if(primerPalo!=mano[i].getPalo()) return false;
	}
	return true;
    }
    
    /**
     * Método : valorCartaMasBaja
     * @return int valor
     */
    private int valorCartaMasBaja() {
	return mano[0].getValor();
    }
    
    /**
     * Método : valorCartaMasAlta
     * @return int valor
     */
    private int valorCartaMasAlta() {
	return mano[4].getValor();
    }
    
    /**
     * Método : seguidas
     * @return boolean si las cartas van (o no) seguidas
     */
    private boolean seguidas() {
	//si hay 4 valores entre la primera y la ultima carta, van seguidas
	int valorMaximo = valorCartaMasBaja()+(mano.length-1);
	if(valorMaximo==valorCartaMasAlta()) return true;
	
	return false;
    }
    
    /**
     * Método : escalera
     * @return boolean si hay (o no) escalera
     */
    private boolean escalera() {
	//5 cartas distintas seguidas
	if(cartasDistintas()==5 && seguidas()) return true;
	
	return false;
    }
    
    /**
     * Método : escaleraDeColor
     * @return boolean si hay (o no) escalera de color
     */
    private boolean escaleraDeColor() {
	//una escalera del mismo palo
	if(escalera() && mismoPalo()) return true;
	
	return false;
    }
    
    /**
     * Método : escaleraReal
     * @returnboolean si hay (o no) escalera real
     */
    private boolean escaleraReal() {
	//una escalera de color con el valor minimo 10
	if(escaleraDeColor() && valorCartaMasBaja()==8 && 
		valorCartaMasAlta()==12) return true;
	
	return false;
    }
    
    /**
     * Método : color
     * @return boolean si hay (o no) color
     */
    private boolean color() {
	//5 cartas distintas del mismo palo sin estar seguidas
	if(cartasDistintas()==5 && mismoPalo() && !seguidas()) return true;
	
	return false;
    }
    
    /**
     * Método : cartaMasAlta
     * @return boolean si hay (o no) carta mas alta
     */
    private boolean cartaMasAlta() {
	//5 cartas distintas sin ser del mismo palo ni estar seguidas
	if(cartasDistintas()==5 && !mismoPalo() && !seguidas()) return true;
	
	return false;
    }
    
    /**
     * Método : pareja
     * @return boolean si hay (o no) pareja
     */
    private boolean pareja() {
	//4 cartas distintas
	if(cartasDistintas()==4) return true;
	
	return false;
    }
    
    /**
     * Método : doblesParejas
     * @return boolean si hay (o no) dobles parejas
     */
    private boolean doblesParejas() {
	//3 cartas distintas y la carta que mas se repite 2 veces
	if(cartasDistintas()==3 && cartaMasRepetida()==2) return true;
	
	return false;
    }
    
    /**
     * Método : trio
     * @return boolean si hay (o no) trio
     */
    private boolean trio() {
	//3 cartas distintas y la carta que mas se repite 3 veces
	if(cartasDistintas()==3 && cartaMasRepetida()==3) return true;
	
	return false;
    }
    
    /**
     * Método : fullHouse
     * @return boolean si hay (o no) full house
     */
    private boolean fullHouse() {
	//2 cartas distintas y la carta que mas se repite 3 veces
	if(cartasDistintas()==2 && cartaMasRepetida()==3) return true;
	
	return false;
    }
    
    /**
     * Método : poquer
     * @return boolean si hay (o no) poquer
     */
    private boolean poquer() {
	//2 cartas distintas y la carta que mas se repite 4 veces
	if(cartasDistintas()==2 && cartaMasRepetida()==4) return true;
	
	return false;
    } 

}
