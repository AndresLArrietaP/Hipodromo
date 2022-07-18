
package Programa;
import App.Configuracion;
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
    int indiceC;
    int indiceJ;
    Caballo caballos[];
    Jockey jockeys[]; 

    public Carrera(int numero_car, int numeroPart,int numeroCab, int distancia) {
        this.numero_car = numero_car;
        this.numeroPart = numeroPart;
        this.numeroCab = numeroCab;
        this.distancia = distancia;
        this.indiceC=0;
        this.indiceJ=0;
        this.caballos = new Caballo[Configuracion.numMinCaballos];
        this.jockeys = new Jockey[Configuracion.numMinJockeys];
    }
    
    public Carrera() {
        this.caballos = new Caballo[Configuracion.numMinCaballos];
        this.jockeys = new Jockey[Configuracion.numMinJockeys];
        this.indiceC=0;
        this.indiceJ=0;
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

    public Caballo[] getCaballos() {
        return caballos;
    }

    public Jockey[] getJockeys() {
        return jockeys;
    }

    public int getIndiceC() {
        return indiceC;
    }

    public int getIndiceJ() {
        return indiceJ;
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

    public void setCaballos(Caballo[] caballos) {
        this.caballos = caballos;
    }

    public void setJockeys(Jockey[] jockeys) {
        this.jockeys = jockeys;
    }

    public void setIndiceC(int indiceC) {
        this.indiceC = indiceC;
    }

    public void setIndiceJ(int indiceJ) {
        this.indiceJ = indiceJ;
    }
    
    

    //Métodos:
    public Carrera estaCarrera(){
        Carrera carrera;
        carrera = new Carrera(this.numero_car, this.numeroPart, this.numeroCab, this.distancia);
        carrera.setCaballos(this.caballos);
        carrera.setJockeys(this.jockeys);
        return carrera;
    }
    public Carrera estaCarreraJ(){
        Carrera carrera;
        carrera = new Carrera(this.numero_car, this.numeroPart, this.numeroCab, this.distancia);
        carrera.setJockeys(this.jockeys);
        return carrera;
    }
    public Carrera estaCarreraC(){
        Carrera carrera;
        carrera = new Carrera(this.numero_car, this.numeroPart, this.numeroCab, this.distancia);
        carrera.setCaballos(this.caballos);
        return carrera;
    }
    //  Arreglos
    public boolean agregarJockey(Jockey j){
        boolean result = false;
        if(this.estaLleno()){
            this.agrandarArreglo();
        }
        this.jockeys[this.indiceJ] = j;
        this.indiceJ++;
        result = true;
        return result;
    }
    
    public boolean eliminarJockey(Jockey jo){
        boolean result = false;
        if(estaVacio()==false){
            for(int i=0; i<this.indiceJ; i++){
                if(this.getJockeys()[i] == jo){
                    for(int j=i+1; j<this.indiceJ; j++){
                        this.getJockeys()[i] = this.getJockeys()[j]; 
                    }
                    this.indiceJ--;
                    result = true;
                }
            }
        }
        return result;
    }
    
    public boolean estaVacio(){
        boolean result = false;
        if(indiceJ<=0){
            result = true;
        }
        return result;
    }
    
    private boolean agrandarArreglo(){
        boolean result = false;
        Jockey jockeysPlus[] = new Jockey[this.indiceJ + 1];
        for(int i=0; i<this.indiceJ; i++){
            jockeysPlus[i] = this.jockeys[i];
            if(i == (this.indiceJ - 1)){
                result = true;
            }
        }
        this.jockeys = jockeysPlus;
        return result;
    }
    
    private boolean estaLleno(){
        boolean result = false;
        if(this.jockeys.length>=this.indiceJ){
            result = true;
        }
        return result;
    }
    
    public boolean agregarCaballo(Caballo c){
        boolean result = false;
        if(this.estaLlenoC()){
            this.agrandarArregloC();
        }
        this.caballos[this.indiceC] = c;
        this.indiceC++;
        result = true;
        return result;
    }
    
    public boolean eliminarCaballo(Caballo c){
        boolean result = false;
        if(estaVacioC()==false){
            for(int i=0; i<this.indiceC; i++){
                if(this.getCaballos()[i] == c){
                    for(int j=i+1; j<this.indiceC; j++){
                        this.getCaballos()[i] = this.getCaballos()[j]; 
                    }
                    this.indiceC--;
                    result = true;
                }
            }
        }
        return result;
    }
    
    public boolean estaVacioC(){
        boolean result = false;
        if(indiceC<=0){
            result = true;
        }
        return result;
    }
    
    private boolean agrandarArregloC(){
        boolean result = false;
        Caballo caballosPlus[] = new Caballo[this.indiceC + 1];
        for(int i=0; i<this.indiceC; i++){
            caballosPlus[i] = this.caballos[i];
            if(i == (this.indiceC - 1)){
                result = true;
            }
        }
        this.caballos = caballosPlus;
        return result;
    }
    
    private boolean estaLlenoC(){
        boolean result = false;
        if(this.caballos.length>=this.indiceC){
            result = true;
        }
        return result;
    }
}

