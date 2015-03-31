/**
 * Poker - test : BarajaTest.java
 * @author Iker Garcia Ramirez
 * @date 31/3/2015
 */
package test;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import baraja.Baraja;
import baraja.Carta;
import junit.framework.TestCase;

//Comienza la clase BarajaTest
public class BarajaTest extends TestCase{
    private Baraja b;

    @Before
    public void setUp() {
	b = new Baraja();
    }
    
    @Test
    public void testLongitudBaraja() {
	assertEquals(52, b.getBaraja().length);
    }
    
    @Test
    public void testOrdenBaraja() {
	assertEquals(new Carta(0,0), b.getBaraja()[0]);
	assertEquals(new Carta(12,3), b.getBaraja()[51]);
    }
    
    @Test
    public void testDesordenBaraja() {
	Carta[] barajaOrdenada = new Carta[52];
	for (int i = 0; i < barajaOrdenada.length; i++) {
	    barajaOrdenada[i] = b.getBaraja()[i];
	}
	
	b.barajar();
	
	assertFalse(Arrays.equals(barajaOrdenada, b.getBaraja()));
    }
    
    @Test
    public void testRepartirCarta() {
	assertEquals(new Carta(0,0), b.repartirCarta());
	assertEquals(1, b.getCartaActual());
    }
    
    @Test
    public void testRepartirMasDeUnaCarta() {
	assertEquals(new Carta(0,0), b.repartirCarta());
	assertEquals(new Carta(1,0), b.repartirCarta());
	assertEquals(new Carta(2,0), b.repartirCarta());
	assertEquals(new Carta(3,0), b.repartirCarta());
	assertEquals(new Carta(4,0), b.repartirCarta());
	assertEquals(new Carta(5,0), b.repartirCarta());
	assertEquals(new Carta(6,0), b.repartirCarta());
	assertEquals(7, b.getCartaActual());
    }
    
}
