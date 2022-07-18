
package Programa;
import java.io.*;
/**
 *
 * @author acer
 */
public class NodoApuesta implements Serializable{
    int nro;
    float monto;
    Jockey apostado;
    NodoApuesta sigP;

    public NodoApuesta(int nro, float monto, Jockey apostado) {
        this.nro = nro;
        this.monto = monto;
        this.apostado = apostado;
        this.sigP = null;
    }
    
    public NodoApuesta(int nro, float monto) {
        this.nro = nro;
        this.monto = monto;
        this.apostado = new Jockey();
        this.sigP = null;
    }
    
    public NodoApuesta() {
        this.apostado = new Jockey();
        this.sigP = null;
    }

    public int getNro() {
        return nro;
    }

    public float getMonto() {
        return monto;
    }

    public Jockey getApostado() {
        return apostado;
    }

    public NodoApuesta getSigP() {
        return sigP;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public void setApostado(Jockey apostado) {
        this.apostado = apostado;
    }

    public void setSigP(NodoApuesta sigP) {
        this.sigP = sigP;
    }
    
 
}
