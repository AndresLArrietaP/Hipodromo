
package Programa;
import java.io.*;
/**
 *
 * @author acer
 */
public class Caballo implements Serializable{
    private String nombre_cab;
    private float peso;
    private int edad;
    private String raza;

    public Caballo(String nombre_cab, float peso, int edad, String raza) {
        this.nombre_cab = nombre_cab;
        this.peso = peso;
        this.edad = edad;
        this.raza = raza;
    }
    
    public Caballo() {
        this.raza = "";
    }

    public String getNombre_cab() {
        return nombre_cab;
    }

    public void setNombre_cab(String nombre_cab) {
        this.nombre_cab = nombre_cab;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
    
}