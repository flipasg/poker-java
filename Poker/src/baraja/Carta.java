/**
 * Poker - juego : Carta.java
 * @author Iker Garcia Ramirez
 * @date 31/3/2015
 */
package baraja;

//Comienza la clase Carta
public class Carta implements Comparable<Carta>{
    private static final String[] PALOS = 
	{"Picas", "Corazones", "Treboles", "Diamantes"};
    private static final String[] VALORES =
	{"Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez", 
	"Jota", "Reina", "Rey", "As"};
    //0 picas, 1 corazones, 2 treboles, 3 diamantes
    private int palo;
    //9 Jota, 10 Reina, 11 Rey, 12 As
    private int valor;
    
    /**
     * Constructor de la clase Carta
     * @param palo
     * @param valor
     */
    public Carta(int valor, int palo) {
	this.palo = palo;
	this.valor = valor;
    }
    
    /**
     * Metodo obtener : getPalo
     * @return el palo de la clase
     */
    public int getPalo() {
        return palo;
    }

    /**
     * Metodo obtener : getValor
     * @return el valor de la clase
     */
    public int getValor() {
        return valor;
    }

    /**
     * Metodo : verCarta
     * @return
     */
    public String verCarta() {
	return VALORES[valor] + " de " + PALOS[palo];
    }
    
    /* Metodo sobreescrito : equals
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Carta other = (Carta) obj;
	if (valor != other.valor)
	    return false;
	return true;
    }

    /* Metodo sobreescrito : compareTo
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(Carta o) {
	if(valor<o.valor) return -1;
	else if(valor>o.valor) return 1;
	else {
	    if(palo<o.palo) return -1;
	    else if(palo>o.palo) return 1;
	    else return 0;
	}
    }
    
    
}
