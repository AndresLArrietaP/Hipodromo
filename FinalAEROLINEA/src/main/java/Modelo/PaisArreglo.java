
package Modelo;

public class PaisArreglo {
    private int indiceP;
    private Pais[] paises;

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
    
    public Pais[] getPaises(String codigo) {
        return paises;
    }

    public void setIndiceP(int indiceP) {
        this.indiceP = indiceP;
    }

    public void setPaises(Pais[] paises) {
        this.paises = paises;
    }
    
    public boolean agregarPais(Pais p){
        boolean result = false;
        
        return result;   
    }
    
    public boolean eliminarPais(String codigo){
        boolean result = false;
        
        return result;   
    }
    
}
