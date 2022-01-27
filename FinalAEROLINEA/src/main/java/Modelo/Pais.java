
package Modelo;

public class Pais {
    private String codigo;
    private String nombre;
    private Ciudad ciudades[];

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

    public Ciudad[] getCiudades() {
        return ciudades;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudades(Ciudad[] ciudades) {
        this.ciudades = ciudades;
    }
    
    public Ciudad[] getCiudades(String codPais){
        Ciudad[] ciudades = null;
        for(int i=0; i<ciudades.length; i++){
        ciudades[ciudades.length].getPais().getCodigo().equals(codPais);
        }
        return ciudades;
    }
}
