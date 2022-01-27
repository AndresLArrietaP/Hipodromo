
package Modelo;

public class Aeropuerto {
    private String nombre;
    private String direccion;
    private boolean estado;

    public Aeropuerto(String nombre, String direccion, boolean estado) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
    }
    
    public Aeropuerto() {
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean activar(){
        boolean result = false;
        
        return result; 
    }
    
    public boolean suspender(){
        boolean result = false;
        
        return result; 
    }
    
    
}
