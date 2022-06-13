
package Programa;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Carrera {
    int numero_car;
    String nombre_jock;
    String aux_nombreCab;
    Double distancia;
    Double tiempo_reg;
    ArregloCaballo caballos;
    ArregloJockey jockeys; 
    Caballo cab;

    
    public void regCaballo(String nombre_cab, Double peso, int edad, String raza){
        cab=new Caballo(nombre_cab, peso, edad, raza);
        caballos.agregarCaballo(cab);
    }
    public void regJockey(){
        
    }
    
    public Carrera(String nombre_jock, String aux_nombreCab, Double distancia, Double tiempo_reg) {
        for (int i=0;i<=caballos.getCaballos().length;i++) {
            if (caballos.getCaballos()[i].getNombre_cab()==aux_nombreCab) {
                this.nombre_jock = nombre_jock;
                this.aux_nombreCab = aux_nombreCab;
                this.distancia = distancia;
                this.tiempo_reg = tiempo_reg;
            }
        }
    }

    public int getNumero_car() {
        return numero_car;
    }

    public String getNombre_jock() {
        return nombre_jock;
    }

    public String getAux_nombreCab() {
        return aux_nombreCab;
    }

    public Double getDistancia() {
        return distancia;
    }

    public Double getTiempo_reg() {
        return tiempo_reg;
    }

    public ArregloCaballo getCaballos() {
        return caballos;
    }

    public ArregloJockey getJockeys() {
        return jockeys;
    }

    public Caballo getCab() {
        return cab;
    }

    public void setNumero_car(int numero_car) {
        this.numero_car = numero_car;
    }

    public void setNombre_jock(String nombre_jock) {
        this.nombre_jock = nombre_jock;
    }

    public void setAux_nombreCab(String aux_nombreCab) {
        this.aux_nombreCab = aux_nombreCab;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public void setTiempo_reg(Double tiempo_reg) {
        this.tiempo_reg = tiempo_reg;
    }

    public void setCaballos(ArregloCaballo caballos) {
        this.caballos = caballos;
    }

    public void setJockeys(ArregloJockey jockeys) {
        this.jockeys = jockeys;
    }

    public void setCab(Caballo cab) {
        this.cab = cab;
    }
    
    
    
}

