
package Modelo;

public class PasajeroArreglo {
    private int indicePas;
    private Pasajero[] pasajeros;

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

    public void setIndicePas(int indicePas) {
        this.indicePas = indicePas;
    }

    public void setPasajeros(Pasajero[] pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    public boolean agregarPasajero(Pasajero p){
        boolean result = false;
        
        return result;   
    }
    
    public boolean eliminarPasajero(Pasajero p){
        boolean result = false;
        
        return result;   
    }
    
    public boolean eliminarPasajero(String tipoDoc, String nroDoc){
        boolean result = false;
        
        return result;   
    }
}
