
package Modelo;

public class Aeropuerto {
    private String nombre;
    private String direccion;
    private boolean estado;
    private Ciudad ciudad;

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

    public Ciudad getCiudad() {
        return ciudad;
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

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    public boolean activar(){
        boolean result = false;
        this.estado=true;
        result=true;
        return result; 
    }
    
    public boolean suspender(){
        boolean result = false;
        this.estado=false;
        result=true;
        return result; 
    }
    
    
}
