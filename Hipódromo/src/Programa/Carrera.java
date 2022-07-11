
package Programa;
import java.io.*;

/**
 *
 * @author acer
 */
public class Carrera implements Serializable{
    int numero_car;
    int numeroPart;
    int numeroCab;
    int distancia;
    ArregloCaballo caballos;
    ArregloJockey jockeys; 

    public Carrera(int numero_car, int numeroPart, int distancia) {
        this.numero_car = numero_car;
        this.numeroPart = numeroPart;
        this.distancia = distancia;
        this.caballos = new ArregloCaballo();
        this.jockeys = new ArregloJockey();
    }
    
    public Carrera() {
        this.caballos = new ArregloCaballo();
        this.jockeys = new ArregloJockey();
    }

    public int getNumero_car() {
        return numero_car;
    }

    public int getNumeroPart() {
        return numeroPart;
    }

    public int getNumeroCab() {
        return numeroCab;
    }
    
    public int getDistancia() {
        return distancia;
    }

    public ArregloCaballo getCaballos() {
        return caballos;
    }

    public ArregloJockey getJockeys() {
        return jockeys;
    }

    public void setNumero_car(int numero_car) {
        this.numero_car = numero_car;
    }

    public void setNumeroPart(int numeroPart) {
        this.numeroPart = numeroPart;
    }

    public void setNumeroCab(int numeroCab) {
        this.numeroCab = numeroCab;
    }
    
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setCaballos(ArregloCaballo caballos) {
        this.caballos = caballos;
    }

    public void setJockeys(ArregloJockey jockeys) {
        this.jockeys = jockeys;
    }
}

