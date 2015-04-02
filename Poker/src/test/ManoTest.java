/**
 * Poker - test : ManoTest.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package test;

import org.junit.Before;
import org.junit.Test;

import baraja.Carta;
import jugador.Mano;
import junit.framework.TestCase;

//Comienza la clase ManoTest
public class ManoTest extends TestCase{
    private Carta[] mano;
    private Mano m;
    
    @Before
    public void setUp() {
	mano = new Carta[5];
    }
    
    @Test
    public void testManoCartaMasAlta() {
	mano[0] = new Carta(10,3);
	mano[1] = new Carta(5,0);
	mano[2] = new Carta(3,1);
	mano[3] = new Carta(1,2);
	mano[4] = new Carta(8,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Carta mas alta", m.mostrarJugada());
    }
    
    @Test
    public void testManoPareja() {
	mano[0] = new Carta(10,3);
	mano[1] = new Carta(2,0);
	mano[2] = new Carta(3,1);
	mano[3] = new Carta(2,2);
	mano[4] = new Carta(8,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Pareja", m.mostrarJugada());
    }
    
    @Test
    public void testManoDoblePareja() {
	mano[0] = new Carta(10,3);
	mano[1] = new Carta(2,0);
	mano[2] = new Carta(3,1);
	mano[3] = new Carta(2,2);
	mano[4] = new Carta(10,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Doble pareja", m.mostrarJugada());
    }
    
    @Test
    public void testManoTrio() {
	mano[0] = new Carta(7,3);
	mano[1] = new Carta(2,0);
	mano[2] = new Carta(2,1);
	mano[3] = new Carta(2,2);
	mano[4] = new Carta(10,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Trio", m.mostrarJugada());
    }
    
    @Test
    public void testManoEscalera() {
	mano[0] = new Carta(5,3);
	mano[1] = new Carta(1,0);
	mano[2] = new Carta(4,1);
	mano[3] = new Carta(2,2);
	mano[4] = new Carta(3,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Escalera", m.mostrarJugada());
    }
    
    @Test
    public void testManoColor() {
	mano[0] = new Carta(11,0);
	mano[1] = new Carta(1,0);
	mano[2] = new Carta(4,0);
	mano[3] = new Carta(7,0);
	mano[4] = new Carta(3,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Color", m.mostrarJugada());
    }
    
    @Test
    public void testManoFullHouse() {
	mano[0] = new Carta(7,3);
	mano[1] = new Carta(2,0);
	mano[2] = new Carta(7,1);
	mano[3] = new Carta(2,2);
	mano[4] = new Carta(2,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Full house", m.mostrarJugada());
    }
    
    @Test
    public void testManoPoquer() {
	mano[0] = new Carta(7,3);
	mano[1] = new Carta(2,0);
	mano[2] = new Carta(2,1);
	mano[3] = new Carta(2,2);
	mano[4] = new Carta(2,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Poquer", m.mostrarJugada());
    }
    
    @Test
    public void testManoEscaleraDeColor() {
	mano[0] = new Carta(5,0);
	mano[1] = new Carta(1,0);
	mano[2] = new Carta(4,0);
	mano[3] = new Carta(2,0);
	mano[4] = new Carta(3,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Escalera de color", m.mostrarJugada());
    }
    
    @Test
    public void testManoEscaleraReal() {
	mano[0] = new Carta(9,0);
	mano[1] = new Carta(10,0);
	mano[2] = new Carta(8,0);
	mano[3] = new Carta(11,0);
	mano[4] = new Carta(12,0);
	
	m = new Mano(mano);
	m.determinarMano();
	
	assertEquals("Escalera real", m.mostrarJugada());
    }
    

    
}
