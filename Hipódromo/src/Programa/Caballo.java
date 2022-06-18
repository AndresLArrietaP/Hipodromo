
package Programa;
import java.io.*;
/**
 *
 * @author acer
 */
public class Caballo implements Serializable{
    private String nombre_cab;
    private Double peso;
    private int edad;
    private String raza;

    public Caballo(String nombre_cab, Double peso, int edad, String raza) {
        this.nombre_cab = nombre_cab;
        this.peso = peso;
        this.edad = edad;
        this.raza = raza;
    }
    
    public Caballo() {
        this.nombre_cab = nombre_cab;
        this.peso = peso;
        this.edad = edad;
        this.raza = raza;
    }

    public String getNombre_cab() {
        return nombre_cab;
    }

    public void setNombre_cab(String nombre_cab) {
        this.nombre_cab = nombre_cab;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
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