
package Modelo;

public class Pais {
    private String codigo;
    private String nombre;

    public Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public Pais() {
        this.codigo = codigo;
        this.nombre = nombre;
    }   

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Ciudad[] getCiudades(String codPais){
        Ciudad[] ciudades = null;
        
        return ciudades;
    }
}
