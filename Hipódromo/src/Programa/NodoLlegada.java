
package Programa;
import App.Configuracion;
import java.io.*;

public class NodoLlegada {
    int tiempo;
    int orden;
    Jockey conc;
    NodoLlegada sig;

    public NodoLlegada(int tiempo, int orden,Jockey jock) {
        this.tiempo = tiempo;
        this.orden = orden;
        this.conc = jock;
        this.sig = null;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getOrden() {
        return orden;
    }

    public Jockey getConc() {
        return conc;
    }
    
    public NodoLlegada getSig() {
        return sig;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public void setConc(Jockey conc) {
        this.conc = conc;
    }

    public void setSig(NodoLlegada sig) {
        this.sig = sig;
    }
    
    
}
