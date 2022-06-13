
package Programa;

/**
 *
 * @author acer
 */
public class Jockey {
    private String nombre;
    private ArregloCaballo caballos;

    public Jockey(String nombre, ArregloCaballo caballos) {
        this.nombre = nombre;
        this.caballos = caballos;
    }
    
    public Jockey() {
        this.nombre = nombre;
        this.caballos = caballos;
    }

    public String getNombre() {
        return nombre;
    }

    public ArregloCaballo getCaballos() {
        return caballos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCaballos(ArregloCaballo caballos) {
        this.caballos = caballos;
    }
    
    
}

