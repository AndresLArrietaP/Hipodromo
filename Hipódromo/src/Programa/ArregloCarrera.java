
package Programa;
import App.Configuracion;
import java.io.*;
/**
 *
 * @author acer
 */
public class ArregloCarrera implements Serializable{
    private Carrera carreras[];
    private int indiceCar;
    
    public ArregloCarrera() {
        this.carreras = new Carrera[Configuracion.numMinCarreras];
        this.indiceCar= 0;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public int getIndiceCar() {
        return indiceCar;
    }

    public void setCarreras(Carrera[] carreras) {
        this.carreras = carreras;
        this.indiceCar = carreras.length;
    }

    public void setIndiceCar(int indiceCar) {
        this.indiceCar = indiceCar;
    }
    
     //Métodos:
    public boolean agregarCarrera(Carrera car){
        boolean result = false;
        if(this.estaLlenoCarrera()){
            this.crecerArregloCarrera();
        }
        this.carreras[this.indiceCar] = car;
        this.indiceCar++;
        result = true;
        return result;
    }
    
    public boolean eliminarCarreraN(int numero){
        boolean result = false;
        if(estaVacioCarrera() == false){
            for(int i=0; i<this.indiceCar; i++){
                if(this.carreras[i].getNumero_car()==numero){
                    for(int j=i+1; j<this.indiceCar;j++){
                        this.carreras[i] = this.carreras[j];
                        i++;
                    }
                    this.indiceCar--;
                    result = true;
                }
            }
        }
        return result;
    } 
    
    public boolean eliminarCarrera(Carrera car){
        boolean result = false;
        if(estaVacioCarrera() == false){
            for(int i=0; i<this.indiceCar; i++){
                if(this.carreras[i]==car){
                    for(int j=i+1; j<this.indiceCar;j++){
                        this.carreras[i] = this.carreras[j];
                        i++;
                    }
                    this.indiceCar--;
                    result = true;
                }
            }
        }
        return result;
    }
    
    
    
    private boolean estaLlenoCarrera(){
        boolean result = false;
        if(this.carreras.length <= this.indiceCar){
            result = true;
        }
        return result;
    }
    
    private boolean estaVacioCarrera(){
        boolean result = false;
        if(this.indiceCar == 0 ) {
            result = true;
        }
        return result;
    }
    
    private boolean crecerArregloCarrera(){
        boolean result = false;
        Carrera carrerasPlus[] = new Carrera[this.carreras.length + 1];
        for(int i=0; i<this.carreras.length; i++){
            carrerasPlus[i] = this.carreras[i];
            if(i == (this.carreras.length - 1)){
                result = true;
            }
        }
        this.carreras = carrerasPlus;
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<this.indiceCar; i++){
            result += String.format("Carrera %d:\n", (i+1)) + this.carreras[i];
        }
        return result;
    }
    
}
