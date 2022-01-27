
package Modelo;

public class AeropuertoArreglo {
    private int indiceA;
    private Aeropuerto aeropuertos[];
    private Aeropuerto aeropuerto;

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

    public Aeropuerto getAeropuerto(Ciudad ciudad) {
        return aeropuerto;
    }
    
    public void setIndiceA(int indiceA) {
        this.indiceA = indiceA;
    }

    public void setAeropuertos(Aeropuerto[] aeropuertos) {
        this.aeropuertos = aeropuertos;
    }
    
    public boolean agregarAeropuerto(Aeropuerto a){
        boolean result = false;
        if(this.estaLlenoAeropuerto()){
            this.crecerAeropuertoArreglo();
        }
        this.aeropuertos[this.indiceA] = a;
        this.indiceA++;
        result = true;
        return result;
    }
    
    private boolean estaLlenoAeropuerto(){
        boolean result = false;
        if(this.aeropuertos.length <= this.indiceA){
            result = true;
        }
        return result;
    }
    
    private boolean crecerAeropuertoArreglo(){
        boolean result = false;
        Aeropuerto aeropuertosPlus[] = new Aeropuerto[this.aeropuertos.length + 1];
        for(int i=0; i<this.aeropuertos.length; i++){
            aeropuertosPlus[i] = this.aeropuertos[i];
            if(i == (this.aeropuertos.length - 1)){
                result = true;
            }
        }
        this.aeropuertos = aeropuertosPlus;
        return result;
    }
    
    
}
