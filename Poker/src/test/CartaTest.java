/**
 * Poker - test : CartaTest.java
 * @author Iker Garcia Ramirez
 * @date 31/3/2015
 */
package test;

import org.junit.Before;
import org.junit.Test;

import baraja.Carta;
import junit.framework.TestCase;

//Comienza la clase CartaTest
public class CartaTest extends TestCase{
    private Carta c;

    @Before
    public void setUp() {
	//dos de picas
	c = new Carta(0, 0);
    }
    
    @Test
    public void testGetAtributosCarta() {
	assertEquals(0, c.getPalo());
	assertEquals(0, c.getValor());
    }
    
    @Test
    public void testVerCarta() {
	assertEquals("Dos de Picas", c.verCarta());
    }
    
    @Test
    public void testVerCartaDistinta() {
	Carta c2 = new Carta(1, 1);
	assertEquals("Tres de Corazones", c2.verCarta());
    }
    
    @Test
    public void testCartasIguales() {
	Carta c2 = new Carta(0, 0);
	assertEquals(c, c2);
    }
    
    @Test
    public void testCartasDistintas() {
	Carta c2 = new Carta(0,1);
	assertFalse(c.equals(c2));
    }
}
