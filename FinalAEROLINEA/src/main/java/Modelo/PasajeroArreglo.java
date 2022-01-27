
package Modelo;

public class PasajeroArreglo {
    private int indicePas;
    private Pasajero pasajeros[];
    private Pasajero pasajero;

    public PasajeroArreglo() {
        this.indicePas = indicePas;
        this.pasajeros = pasajeros;
    }

    public PasajeroArreglo(int indicePas, Pasajero[] pasajeros) {
        this.indicePas = indicePas;
        this.pasajeros = pasajeros;
    }

    public int getIndicePas() {
        return indicePas;
    }

    public Pasajero[] getPasajeros() {
        return pasajeros;
    }
    
    public Pasajero getPasajero(String tipoDoc, String nroDoc) {
        return pasajero;
    }

    public void setIndicePas(int indicePas) {
        this.indicePas = indicePas;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    public boolean agregarPasajero(Pasajero p){
        boolean result = false;
        if(this.estaLlenoPasajero()){
            this.crecerPasajeroArreglo();
        }
        this.pasajeros[this.indicePas] = p;
        this.indicePas++;
        result = true;
        return result;   
    }
    
    public boolean eliminarPasajero(Pasajero p){
        boolean result = false;
        if(estaVacioPasajero() == false){
            for(int i=0; i<this.indicePas; i++){
                if(this.pasajeros[i] == p){
                    for(int j=i+1; j<this.indicePas; j++){
                        this.pasajeros[i] = this.pasajeros[j];
                        i++;
                    }
                    this.indicePas--;
                    result = true;
                }
            }
        }
        return result;   
    }
    
    public boolean eliminarPasajero(String tipoDoc, String nroDoc){
        boolean result = false;
        if(estaVacioPasajero() == false){
            for(int i=0; i<this.indicePas; i++){
                if((this.pasajeros[i].getTipodocumento().compareTo(tipoDoc)==0)&&(this.pasajeros[i].getNrodocumento().compareTo(nroDoc)==0)){
                    for(int j=i+1; j<this.indicePas;j++){
                        this.pasajeros[i] = this.pasajeros[j];
                        i++;
                    }
                    this.indicePas--;
                    result = true;
                }
            }
        }
        return result;   
    }
    
    private boolean estaLlenoPasajero(){
        boolean result = false;
        if(this.pasajeros.length <= this.indicePas){
            result = true;
        }
        return result;
    }
    
    private boolean crecerPasajeroArreglo(){
        boolean result = false;
        Pasajero pasajerosPlus[] = new Pasajero[this.pasajeros.length + 1];
        for(int i=0; i<this.pasajeros.length; i++){
            pasajerosPlus[i] = this.pasajeros[i];
            if(i == (this.pasajeros.length - 1)){
                result = true;
            }
        }
        this.pasajeros = pasajerosPlus;
        return result;
    }
    
    private boolean estaVacioPasajero(){
        boolean result = false;
        if(this.indicePas == 0 ) {
            result = true;
        }
        return result;
    }
    
    
}
