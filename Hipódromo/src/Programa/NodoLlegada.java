
package Programa;
import App.Configuracion;
import java.io.*;

public class NodoLlegada {
    int tiempo;
    int orden;
    NodoLlegada sig;

    public NodoLlegada(int tiempo, int orden) {
        this.tiempo = tiempo;
        this.orden = orden;
        this.sig = null;
    }

    public int getTiempo() {
        return tiempo;
    }

    public int getOrden() {
        return orden;
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

    public void setSig(NodoLlegada sig) {
        this.sig = sig;
    }
    
    
}
