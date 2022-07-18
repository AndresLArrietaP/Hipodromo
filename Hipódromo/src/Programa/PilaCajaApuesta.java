
package Programa;
import App.*;
import java.io.*;
import static Datos.Repositorio.*;

public class PilaCajaApuesta {
    NodoApuesta tope,encontradoP;
    
    public PilaCajaApuesta(){
            tope=null; //Pila vacía
    }
    
    public PilaCajaApuesta(int nro,float monto, Jockey apo){
            tope.nro=nro;
            tope.monto=monto;
            tope.apostado=apo;//Para botones
    }

    public NodoApuesta getTope() {
        return tope;
    }

    public NodoApuesta getEncontradoP() {
        return encontradoP;
    }

    public void setTope(NodoApuesta tope) {
        this.tope = tope;
    }

    public void setEncontradoP(NodoApuesta encontradoP) {
        this.encontradoP = encontradoP;
    }
    
    //OPERACIONES CON LA PILA
    public void push(int nro, float mon, Jockey apo){
            NodoApuesta nuevo = new NodoApuesta(nro,mon,apo);
            //Enlaces
            if(tope==null){
                nuevo.sigP=null;
            }else{
                nuevo.sigP=tope;
            }
            tope=nuevo;
        }
        public String pop(){
            String eliminado="";
            NodoApuesta aux=tope;
        
            String n=Integer.toString(aux.nro);
            String m=Float.toString(aux.monto);
            String a=jockeyGenerico.toString();
         
            eliminado=n+","+m+","+a;
            tope=tope.sigP;
            aux.sigP=null;
            return eliminado;
        }
}
