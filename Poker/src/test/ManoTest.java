/**
 * Poker - test : ManoTest.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package test;

import jugador.Mano;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import baraja.Carta;

//Comienza la clase ManoTest
public class ManoTest extends TestCase{
    private Mano m;
    private Carta carta1, carta2, carta3, carta4, carta5;
    
    @Before
    public void setUp() {
    	m = new Mano();
    }
    
    @Test
    public void testAnadirUnaCarta() {
    	carta1 = new Carta(0, 0);
    	
    	assertTrue(m.anadirCarta(carta1));
    	assertEquals(m.getMano()[0], carta1);
    }
    
    @Test
    public void testAnadirUnaCartaManoCompleta() {
    	carta1 = new Carta(0, 0);
    	for (int i = 0; i < m.getMano().length; i++) {
			m.anadirCarta(carta1);
		}
    	
    	assertFalse(m.anadirCarta(carta1));
    }
    
    @Test
    public void testDescartarUnaCarta() {
    	carta1 = new Carta(0, 0);
    	m.anadirCarta(carta1);
    	
    	assertTrue(m.quitarCarta(0));
    }
    
    @Test
    public void testDescartarUnaCartaImposible() {
    	carta1 = new Carta(0, 0);
    	m.anadirCarta(carta1);
    	
    	assertFalse(m.quitarCarta(1));
    	assertFalse(m.quitarCarta(7));
    }
    
    @Test
    public void testMejorManoIgualCMA() {
	carta1 = new Carta(10,3);
	carta2 = new Carta(5,0);
	carta3 = new Carta(3,1);
	carta4 = new Carta(1,2);
	carta5 = new Carta(8,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	Mano m2 = new Mano();
	
	m2.anadirCarta(carta1);
	m2.anadirCarta(carta2);
	m2.anadirCarta(carta3);
	m2.anadirCarta(carta4);
	m2.anadirCarta(carta5);
	
	assertNull(m.mejorMano(m2));
    }
    
    @Test
    public void testMejorManoIgualESC() {
	carta1 = new Carta(5,3);
	carta2 = new Carta(1,0);
	carta3 = new Carta(4,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(3,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	carta1 = new Carta(5,2);
	carta2 = new Carta(1,1);
	carta3 = new Carta(4,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(3,0);
	
	Mano m2 = new Mano();
	
	m2.anadirCarta(carta1);
	m2.anadirCarta(carta2);
	m2.anadirCarta(carta3);
	m2.anadirCarta(carta4);
	m2.anadirCarta(carta5);
	
	assertNull(m.mejorMano(m2));
    }
    
    public void testMejorManoIgualPAREJA() {
	carta1 = new Carta(10,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(3,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(8,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	Mano m2 = new Mano();
	
	m2.anadirCarta(carta1);
	m2.anadirCarta(carta2);
	m2.anadirCarta(carta3);
	m2.anadirCarta(carta4);
	m2.anadirCarta(carta5);
	
	assertNull(m.mejorMano(m2));
    }
    
    @Test
    public void testMejorManoDistintas() {
	carta1 = new Carta(10,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(3,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(8,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	carta1 = new Carta(5,3);
	carta2 = new Carta(1,0);
	carta3 = new Carta(4,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(3,0);
	
	Mano m2 = new Mano();
	
	m2.anadirCarta(carta1);
	m2.anadirCarta(carta2);
	m2.anadirCarta(carta3);
	m2.anadirCarta(carta4);
	m2.anadirCarta(carta5);
	
	assertEquals(m2, m.mejorMano(m2));
    }
    
    @Test
    public void testMejorManoParejaDistintas() {
	carta1 = new Carta(3,3);
	carta2 = new Carta(5,0);
	carta3 = new Carta(9,1);
	carta4 = new Carta(9,2);
	carta5 = new Carta(11,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	carta1 = new Carta(6,3);
	carta2 = new Carta(7,0);
	carta3 = new Carta(10,1);
	carta4 = new Carta(7,2);
	carta5 = new Carta(11,0);
	
	Mano m2 = new Mano();
	
	m2.anadirCarta(carta1);
	m2.anadirCarta(carta2);
	m2.anadirCarta(carta3);
	m2.anadirCarta(carta4);
	m2.anadirCarta(carta5);
	
	assertEquals(m, m.mejorMano(m2));
    }
    
    @Test
    public void testMejorTrioDistinto() {
	carta1 = new Carta(9,3);
	carta2 = new Carta(5,0);
	carta3 = new Carta(9,1);
	carta4 = new Carta(9,2);
	carta5 = new Carta(11,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	carta1 = new Carta(6,3);
	carta2 = new Carta(7,0);
	carta3 = new Carta(7,1);
	carta4 = new Carta(7,2);
	carta5 = new Carta(11,0);
	
	Mano m2 = new Mano();
	
	m2.anadirCarta(carta1);
	m2.anadirCarta(carta2);
	m2.anadirCarta(carta3);
	m2.anadirCarta(carta4);
	m2.anadirCarta(carta5);
	
	assertEquals(m, m.mejorMano(m2));
    }
    
    
    @Test
    public void testManoCartaMasAlta() {
	carta1 = new Carta(10,3);
	carta2 = new Carta(5,0);
	carta3 = new Carta(3,1);
	carta4 = new Carta(1,2);
	carta5 = new Carta(8,0);
		
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
		
	m.determinarMano();
		
	assertEquals("Carta mas alta", m.verJugada());
    }
    
    @Test
    public void testManoPareja() {
	carta1 = new Carta(10,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(3,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(8,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	m.determinarMano();
	
	assertEquals("Pareja", m.verJugada());
    }
    
    @Test
    public void testManoDoblePareja() {
	carta1 = new Carta(10,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(3,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(10,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);
	
	m.determinarMano();
	
	assertEquals("Doble pareja", m.verJugada());
    }
    
    @Test
    public void testManoTrio() {
	carta1 = new Carta(7,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(2,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(10,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Trio", m.verJugada());
    }
    
    @Test
    public void testManoEscalera() {
	carta1 = new Carta(5,3);
	carta2 = new Carta(1,0);
	carta3 = new Carta(4,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(3,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Escalera", m.verJugada());
    }
    
    @Test
    public void testManoColor() {
	carta1 = new Carta(11,0);
	carta2 = new Carta(1,0);
	carta3 = new Carta(4,0);
	carta4 = new Carta(7,0);
	carta5 = new Carta(3,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Color", m.verJugada());
    }
    
    @Test
    public void testManoFullHouse() {
	carta1 = new Carta(7,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(7,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(2,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Full house", m.verJugada());
    }
    
    @Test
    public void testManoPoquer() {
	carta1 = new Carta(7,3);
	carta2 = new Carta(2,0);
	carta3 = new Carta(2,1);
	carta4 = new Carta(2,2);
	carta5 = new Carta(2,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Poquer", m.verJugada());
    }
    
    @Test
    public void testManoEscaleraDeColor() {
	carta1 = new Carta(5,0);
	carta2 = new Carta(1,0);
	carta3 = new Carta(4,0);
	carta4 = new Carta(2,0);
	carta5 = new Carta(3,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Escalera de color", m.verJugada());
    }
    
    @Test
    public void testManoEscaleraReal() {
	carta1 = new Carta(9,0);
	carta2 = new Carta(10,0);
	carta3 = new Carta(8,0);
	carta4 = new Carta(11,0);
	carta5 = new Carta(12,0);
	
	m.anadirCarta(carta1);
	m.anadirCarta(carta2);
	m.anadirCarta(carta3);
	m.anadirCarta(carta4);
	m.anadirCarta(carta5);

	m.determinarMano();
	
	assertEquals("Escalera real", m.verJugada());
    }
	
    
}
