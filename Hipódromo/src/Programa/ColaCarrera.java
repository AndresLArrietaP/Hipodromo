
package Programa;
import App.Configuracion;
import java.io.*;

public class ColaCarrera {
    NodoLlegada prim,ultim,encontradoc;
    NodoLlegada actual;
    int tamX;
    
    public ColaCarrera(){
            prim=ultim=null;
            tamX=0;
    }

    public NodoLlegada getPrim() {
        return prim;
    }

    public NodoLlegada getUltim() {
        return ultim;
    }

    public NodoLlegada getEncontradoc() {
        return encontradoc;
    }

    public NodoLlegada getActual() {
        return actual;
    }

    public int getTamX() {
        return tamX;
    }

    public void setPrim(NodoLlegada prim) {
        this.prim = prim;
    }

    public void setUltim(NodoLlegada ultim) {
        this.ultim = ultim;
    }

    public void setEncontradoc(NodoLlegada encontradoc) {
        this.encontradoc = encontradoc;
    }

    public void setActual(NodoLlegada actual) {
        this.actual = actual;
    }

    public void setTamX(int tamX) {
        this.tamX = tamX;
    }
    
    //Métodos
    private void encolar(int tim, int ord){
            NodoLlegada nuevo= new NodoLlegada(tim,ord);
            if(prim==null){
                prim=nuevo; //vacio
            }else{
                ultim.sig=nuevo;
            }
            ultim=nuevo;
            ultim.sig=null;
        }
    
    private String primero(){
            String eliminado=" ";
            NodoLlegada aux=prim;
        
            String t=Integer.toString(aux.tiempo);
            String o=Integer.toString(aux.orden);
            eliminado = t+" "+o;
     
            prim=prim.sig;
            return eliminado; 
    }
    
    
}
