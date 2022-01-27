
package Modelo;
import static Datos.Repositorio.*;

public class Asiento {
    private int nroasiento;
    private char fila;
    private String estado;
    private PasajeroArreglo pasajeros = new PasajeroArreglo();

    public Asiento(int nroasiento, char fila, String estado) {
        this.nroasiento = nroasiento;
        this.fila = fila;
        this.estado = estado;
    }
    
    public Asiento() {
        this.nroasiento = nroasiento;
        this.fila = fila;
        this.estado = estado;
    }

    public int getNroasiento() {
        return nroasiento;
    }

    public char getFila() {
        return fila;
    }

    public String getEstado() {
        return estado;
    }

    public PasajeroArreglo getPasajeros() {
        return pasajeros;
    }

    
    public void setNroasiento(int nroasiento) {
        this.nroasiento = nroasiento;
    }

    public void setFila(char fila) {
        this.fila = fila;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPasajeros(PasajeroArreglo pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    public boolean reservarAsiento(){
        boolean result=false;
        Pasajero p = null;
        if(estaOcupado()==false){
            for(int i=0; i<pasajeros.getIndicePas(); i++){
                if(this.pasajeros.getPasajeros()[i] == p){
                    pasajeros.getPasajeros()[pasajeros.getIndicePas()].getAsientos()[pasajeros.getIndicePas()].setNroasiento(nroasiento);
                    result = true;
                }
            }
        }
        
        return result;  
    }
    
    public boolean cancelarAsiento(){
        boolean result=false;
        if(this.reservarAsiento()==false){
        result=true;
        }
        return result;  
    }
    
    public boolean venderAsiento(){
        boolean result=false;
        
        return result;  
    }   
    
    public boolean estaOcupado(){
        boolean result=false;
        if(this.nroasiento==pasajeros.getPasajeros()[pasajeros.getIndicePas()].getAsientos()[pasajeros.getIndicePas()].getNroasiento()){
            result=true;
        }
        return result;
    }
    
    
}
