
package Programa;
import java.io.*;
/**
 *
 * @author acer
 */
public class Jockey implements Serializable{
    private String nombre;
    private int edad;
    private Caballo caballo;

    public Jockey(String nombre,int edad,String nombrec,int edadc,float pesoc,String raza) {
        this.nombre = nombre;
        this.edad= edad;
        this.caballo = new Caballo();
        this.caballo.setNombre_cab(nombrec);
        this.caballo.setEdad(edadc);
        this.caballo.setPeso(pesoc);
        this.caballo.setRaza(raza);
    }
    
    public Jockey(String nombre,int edad) {
        this.nombre = nombre;
        this.edad= edad;
        this.caballo = new Caballo();
    }
    
    public Jockey() {
        this.caballo = new Caballo();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    public Caballo getCaballo() {
        return caballo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void setCaballo(Caballo caballo) {
        this.caballo = caballo;
    }
    
    
    
}

