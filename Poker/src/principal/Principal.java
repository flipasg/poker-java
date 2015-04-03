/**
 * Poker - principal : Principal.java
 * @author Iker Garcia Ramirez
 * @date 3/4/2015
 */
package principal;

import juego.Juego;

//Comienza la clase Principal
public class Principal {
    
    /**
     * Metodo : main
     * @param args
     */
    public static void main(String[] args) {
	Juego j = new Juego();
	j.jugar();
    }
}
