
package Modelo;

public class Aerolinea {
    private String nombre;
    private String RUC;

    public Aerolinea(String nombre, String RUC) {
        this.nombre = nombre;
        this.RUC = RUC;
    }
    
    public Aerolinea() {
        this.nombre = nombre;
        this.RUC = RUC;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRUC() {
        return RUC;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }
    
    public Vuelo[] getVuelosActivos(){
        Vuelo[] vuelo = null;
        
        return vuelo;
    }
}
