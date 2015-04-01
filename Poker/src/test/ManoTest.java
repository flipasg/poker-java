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
	mano[0] = new Carta(3,3);
	mano[1] = new Carta(11,3);
	mano[2] = new Carta(0,3);
	mano[3] = new Carta(4,3);
	mano[4] = new Carta(5,3);
	
	m = new Mano(mano);
    }
    
    @Test
    public void testManoOrdenadaMismoPalo() {

	
	assertEquals(m.getMano()[0], new Carta(0,3));
	assertEquals(m.getMano()[4], new Carta(11,3));
    }
    
    @Test
    public void testManoOrdenadaPaloDistinto() {
	mano[0] = new Carta(3,3);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(4,0);
	mano[4] = new Carta(5,3);
	
	m = new Mano(mano);
	
	assertEquals(m.getMano()[0], new Carta(0,1));
	assertEquals(m.getMano()[4], new Carta(11,2));
    }
    
    @Test
    public void testManoOrdenadaConIguales() {
	mano[0] = new Carta(3,3);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(4,0);
	mano[4] = new Carta(3,3);
	
	m = new Mano(mano);
	
	assertEquals(m.getMano()[1], new Carta(3,3));
	assertEquals(m.getMano()[2], new Carta(3,3));
    }
    
    @Test
    public void testNumeroDeCartasTodasDistintas() {
	//5 distintas significa que hay una Escalera, un Color o nada
	assertEquals(5, m.cartasDistintas());
    }
    
    @Test
    public void testNumeroDeCartasDistintasPareja() {
	mano[0] = new Carta(4,3);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(4,0);
	mano[4] = new Carta(3,3);
	
	m = new Mano(mano);
	
	//4 distintas significa que hay una pareja
	assertEquals(4, m.cartasDistintas());
    }
    
    @Test
    public void testNumeroDeCartasDistintasTrio() {
	mano[0] = new Carta(3,2);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(3,0);
	mano[4] = new Carta(3,3);
	
	m = new Mano(mano);
	
	//3 distintas significa que hay un trio o una doble pareja
	assertEquals(3, m.cartasDistintas());
    }
    
    @Test
    public void testNumeroDeCartasDistintasDoblePareja() {
	mano[0] = new Carta(0,2);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(3,0);
	mano[4] = new Carta(11,3);
	
	m = new Mano(mano);
	
	//3 distintas significa que hay un trio o una doble pareja
	assertEquals(3, m.cartasDistintas());
    }
    
    @Test
    public void testNumeroDeCartasDistintasPoquer() {
	mano[0] = new Carta(0,2);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(0,0);
	mano[4] = new Carta(0,3);
	
	m = new Mano(mano);
	
	//2 distintas significa que hay un poquer o un full house
	assertEquals(2, m.cartasDistintas());
    }
    
    @Test
    public void testNumeroDeCartasDistintasFullHouse() {
	mano[0] = new Carta(0,2);
	mano[1] = new Carta(11,2);
	mano[2] = new Carta(0,1);
	mano[3] = new Carta(0,0);
	mano[4] = new Carta(11,3);
	
	m = new Mano(mano);
	
	//2 distintas significa que hay un poquer o un full house
	assertEquals(2, m.cartasDistintas());
    }
    
}
