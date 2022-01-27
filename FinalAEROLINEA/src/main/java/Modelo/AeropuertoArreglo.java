
package Modelo;

public class AeropuertoArreglo {
    private int indiceA;
    private Aeropuerto[] aeropuertos;

    public AeropuertoArreglo() {
        this.indiceA=indiceA;
        this.aeropuertos=aeropuertos;
    }

    public AeropuertoArreglo(int indiceA, Aeropuerto[] aeropuertos) {
        this.indiceA = indiceA;
        this.aeropuertos = aeropuertos;
    }

    public int getIndiceA() {
        return indiceA;
    }

    public Aeropuerto[] getAeropuertos() {
        return aeropuertos;
    }
    
    public Aeropuerto[] getAeropuertos(Pais pais) {
        return aeropuertos;
    }

    public void setIndiceA(int indiceA) {
        this.indiceA = indiceA;
    }

    public void setAeropuertos(Aeropuerto[] aeropuertos) {
        this.aeropuertos = aeropuertos;
    }
    
    public boolean agregarAeropuerto(Aeropuerto a){
        boolean result = false;
        
        return result;
    }
    
    public Aeropuerto getAeropuerto(Ciudad ciudad){
        Aeropuerto aeropuerto = null;
        
        return aeropuerto;
    }
    
    
    
    
}
