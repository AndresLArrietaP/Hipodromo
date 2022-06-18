
package Programa;
import App.Configuracion;
import java.io.*;
/**
 *
 * @author acer
 */
public class ArregloJockey implements Serializable{
    private Jockey jockeys[];
    private int indiceJock;

    public ArregloJockey(Jockey[] jockeys, int indiceJock) {
        this.jockeys = new Jockey[Configuracion.numMinJockeys];
        this.indiceJock = indiceJock;
    }
    
    public ArregloJockey() {
        this.jockeys = new Jockey[Configuracion.numMinJockeys];
        this.indiceJock = indiceJock;
    }

    public Jockey[] getJockeys() {
        return jockeys;
    }

    public int getIndiceJock() {
        return indiceJock;
    }

    public void setJockeys(Jockey[] jockeys) {
        this.jockeys = jockeys;
        this.indiceJock = jockeys.length;
    }

    public void setIndiceJock(int indiceJock) {
        this.indiceJock = indiceJock;
    }
    
    //Métodos:
    public boolean agregarJockey(Jockey jock){
        boolean result = false;
        if(this.estaLlenoJockey()){
            this.crecerArregloJockey();
        }
        this.jockeys[this.indiceJock] = jock;
        this.indiceJock++;
        result = true;
        return result;
    }
    
    /*public boolean eliminarJockeyN(String nombre){
        boolean result = false;
        if(estaVacioJockey() == false){
            for(int i=0; i<this.indiceJock; i++){
                if(this.jockeys[i].getNombre().compareTo(nombre)==0){
                    for(int j=i+1; j<this.indiceJock;j++){
                        this.jockeys[i] = this.jockeys[j];
                        i++;
                    }
                    this.indiceJock--;
                    result = true;
                }
            }
        }
        return result;
    } */
    
    public boolean eliminarJockey(Jockey jock){
        boolean result = false;
        if(estaVacioJockey() == false){
            for(int i=0; i<this.indiceJock; i++){
                if(this.jockeys[i]==jock){
                    for(int j=i+1; j<this.indiceJock;j++){
                        this.jockeys[i] = this.jockeys[j];
                        i++;
                    }
                    this.indiceJock--;
                    result = true;
                }
            }
        }
        return result;
    }
    
    
    
    private boolean estaLlenoJockey(){
        boolean result = false;
        if(this.jockeys.length <= this.indiceJock){
            result = true;
        }
        return result;
    }
    
    private boolean estaVacioJockey(){
        boolean result = false;
        if(this.indiceJock == 0 ) {
            result = true;
        }
        return result;
    }
    
    private boolean crecerArregloJockey(){
        boolean result = false;
        Jockey jockeysPlus[] = new Jockey[this.jockeys.length + 1];
        for(int i=0; i<this.jockeys.length; i++){
            jockeysPlus[i] = this.jockeys[i];
            if(i == (this.jockeys.length - 1)){
                result = true;
            }
        }
        this.jockeys = jockeysPlus;
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<this.indiceJock; i++){
            result += String.format("Jockey %d:\n", (i+1)) + this.jockeys[i];
        }
        return result;
    }
}
    
