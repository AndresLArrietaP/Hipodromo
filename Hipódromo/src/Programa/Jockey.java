
package Programa;
import java.io.*;
/**
 *
 * @author acer
 */
public class Jockey implements Serializable{
    private String nombre;
    private Caballo caballo;

    public Jockey(String nombre, Caballo caballo) {
        this.nombre = nombre;
        this.caballo = caballo;
    }
    
    public Jockey() {
        this.nombre = nombre;
        this.caballo = caballo;
    }

    public String getNombre() {
        return nombre;
    }

    public Caballo getCaballo() {
        return caballo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }
    
    
}

