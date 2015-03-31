/**
 * Poker - test : Teses.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package test;

import java.util.Arrays;

import baraja.Carta;

//Comienza la clase Teses
public class Teses {
    public static void main(String[] args) {
	Carta[] mano1 = {new Carta(0,0)};
	Carta[] mano2 = {new Carta(0,0)};
	System.out.println(Arrays.equals(mano1, mano2));
    }
}
