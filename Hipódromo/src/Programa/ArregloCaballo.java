
package Programa;
import App.Configuracion;
/**
 *
 * @author acer
 */
public class ArregloCaballo {
    private Caballo caballos[];
    private int indiceCab;
    
    public ArregloCaballo() {
        this.caballos = new Caballo[Configuracion.numMinCaballos];
        this.indiceCab = 0;
    }

    public Caballo[] getCaballos() {
        return caballos;
    }

    public int getIndiceCab() {
        return indiceCab;
    }

    public void setCaballos(Caballo[] caballos) {
        this.caballos = caballos;
        this.indiceCab = caballos.length;
    }

    public void setIndiceCab(int indiceCab) {
        this.indiceCab = indiceCab;
    }
    
    //Métodos:
    public boolean agregarCaballo(Caballo cab){
        boolean result = false;
        if(this.estaLlenoCaballo()){
            this.crecerArregloCaballo();
        }
        this.caballos[this.indiceCab] = cab;
        this.indiceCab++;
        result = true;
        return result;
    }
    
    /*public boolean eliminarCaballoN(String nombre){
        boolean result = false;
        if(estaVacioCaballo() == false){
            for(int i=0; i<this.indiceCab; i++){
                if(this.caballos[i].getNombre_cab().compareTo(nombre)==0){
                    for(int j=i+1; j<this.indiceCab;j++){
                        this.caballos[i] = this.caballos[j];
                        i++;
                    }
                    this.indiceCab--;
                    result = true;
                }
            }
        }
        return result;
    } */
    
    public boolean eliminarCaballo(Caballo cab){
        boolean result = false;
        if(estaVacioCaballo() == false){
            for(int i=0; i<this.indiceCab; i++){
                if(this.caballos[i]==cab){
                    for(int j=i+1; j<this.indiceCab;j++){
                        this.caballos[i] = this.caballos[j];
                        i++;
                    }
                    this.indiceCab--;
                    result = true;
                }
            }
        }
        return result;
    }
    
    
    
    private boolean estaLlenoCaballo(){
        boolean result = false;
        if(this.caballos.length <= this.indiceCab){
            result = true;
        }
        return result;
    }
    
    private boolean estaVacioCaballo(){
        boolean result = false;
        if(this.indiceCab == 0 ) {
            result = true;
        }
        return result;
    }
    
    private boolean crecerArregloCaballo(){
        boolean result = false;
        Caballo caballosPlus[] = new Caballo[this.caballos.length + 1];
        for(int i=0; i<this.caballos.length; i++){
            caballosPlus[i] = this.caballos[i];
            if(i == (this.caballos.length - 1)){
                result = true;
            }
        }
        this.caballos = caballosPlus;
        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for(int i=0; i<this.indiceCab; i++){
            result += String.format("Caballo %d:\n", (i+1)) + this.caballos[i];
        }
        return result;
    }
}
