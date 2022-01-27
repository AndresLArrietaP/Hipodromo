
package Modelo;

public class PaisArreglo {
    private int indiceP;
    private Pais paises[];
    private Pais pais;

    public PaisArreglo() {
        this.indiceP=indiceP;
        this.paises=paises;
    }

    public PaisArreglo(int indiceP, Pais[] paises) {
        this.indiceP = indiceP;
        this.paises = paises;
    }

    public int getIndiceP() {
        return indiceP;
    }

    public Pais[] getPaises() {
        return paises;
    }
    
    public Pais getPaises(String codigo) {
        return pais;
    }

    public void setIndiceP(int indiceP) {
        this.indiceP = indiceP;
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }
    
    public boolean agregarPais(Pais p){
        boolean result = false;
        if(this.estaLlenoPais()){
            this.crecerPaisArreglo();
        }
        this.paises[this.indiceP] = p;
        this.indiceP++;
        result = true;
        return result;   
    }
    
    public boolean eliminarPais(String codigo){
        boolean result = false;
        if(estaVacioPais() == false){
            for(int i=0; i<this.indiceP; i++){
                if(this.paises[i].getCodigo().compareTo(codigo)==0){
                    for(int j=i+1; j<this.indiceP;j++){
                        this.paises[i] = this.paises[j];
                        i++;
                    }
                    this.indiceP--;
                    result = true;
                }
            }
        }
        return result;   
    }
    
    public boolean eliminarPais(Pais p){
        boolean result = false;
        if(estaVacioPais() == false){
            for(int i=0; i<this.indiceP; i++){
                if(this.paises[i] == p){
                    for(int j=i+1; j<this.indiceP; j++){
                        this.paises[i] = this.paises[j];
                        i++;
                    }
                    this.indiceP--;
                    result = true;
                }
            }
        }
        return result;   
    }
    
    private boolean estaLlenoPais(){
        boolean result = false;
        if(this.paises.length <= this.indiceP){
            result = true;
        }
        return result;
    }
    
    private boolean crecerPaisArreglo(){
        boolean result = false;
        Pais paisesPlus[] = new Pais[this.paises.length + 1];
        for(int i=0; i<this.paises.length; i++){
            paisesPlus[i] = this.paises[i];
            if(i == (this.paises.length - 1)){
                result = true;
            }
        }
        this.paises = paisesPlus;
        return result;
    }
    
    private boolean estaVacioPais(){
        boolean result = false;
        if(this.indiceP == 0 ) {
            result = true;
        }
        return result;
    }
}
