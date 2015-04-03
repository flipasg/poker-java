/**
 * Poker - jugador : Jugador.java
 * @author Iker Garcia Ramirez
 * @date 1/4/2015
 */
package jugador;


//Comienza la clase Jugador
public class Jugador {
    private String nombre;
    private Mano manoJugador;
    
    /**
     * Constructor de la clase Jugador
     * @param nombre
     */
    public Jugador(String nombre) {
    	this.nombre = nombre;
    	manoJugador = new Mano();
    }
    
    /**
     * Metodo obtener : getNombre
     * @return el nombre de la clase
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo obtener : getManoJugador
     * @return el manoJugador de la clase
     */
    public Mano getManoJugador() {
        return manoJugador;
    }
    
    /**
     * Metodo : verJugador
     * @return elJugador
     */
    public String verJugador() {
	return nombre + "\n" + manoJugador.verMano() + "\nJUGADA: " + manoJugador.verJugada() + "\n";
    }
    
    /**
     * Metodo : determinarGanador
     * @param j
     * @return el JugadorGanador
     */
    public Jugador determinarGanador(Jugador j) {
	if(manoJugador.equals(manoJugador.mejorMano(j.manoJugador))) return this;
	else if(j.manoJugador.equals(manoJugador.mejorMano(j.manoJugador))) return j;
	else return this; //el jugador mas cercano a la "mano" gana
    }


    
}
