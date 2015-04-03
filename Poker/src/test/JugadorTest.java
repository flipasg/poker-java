/**
 * Poker - test : JugadorTest.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package test;

import jugador.Jugador;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import baraja.Carta;

//Comienza la clase JugadorTest
public class JugadorTest extends TestCase{
    //se han eliminado los test de los Getters y Setters y "toStrings"
    private Jugador j1;
    private Jugador j2;
    private Carta[] m1 = {new Carta(0,3), new Carta(0,3), new Carta(10,3),
	    new Carta(10,3), new Carta(10,3)};
    
    @Before
    public void setUp() {
	j1 = new Jugador("I");
	j2 = new Jugador("P");
	
    }
    
    @Test
    public void testDeterminarGanadorEmpate() {
	for (int i = 0; i < m1.length; i++) {
	    j1.getManoJugador().anadirCarta(m1[i]);
	    j2.getManoJugador().anadirCarta(m1[i]);
	}
	
	assertEquals(j1, j1.determinarGanador(j2));
    }
    
    @Test
    public void testDeterminarGanadorOtro() {
	Carta[] m2 =  {new Carta(0,3), new Carta(1,3), new Carta(2,3), new Carta(3,3), new Carta(4,3)};
	
	for (int i = 0; i < m1.length; i++) {
	    j1.getManoJugador().anadirCarta(m1[i]);
	    j2.getManoJugador().anadirCarta(m2[i]);
	}
	
	assertEquals(j2, j1.determinarGanador(j2));
    }
}
