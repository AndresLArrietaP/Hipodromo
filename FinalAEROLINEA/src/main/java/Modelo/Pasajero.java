
package Modelo;

public class Pasajero {
    private String tipodocumento;
    private String nrodocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;

    public Pasajero(String tipodocumento, String nrodocumento, String nombres, String apellidos, String fechaNacimiento) {
        this.tipodocumento = tipodocumento;
        this.nrodocumento = nrodocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Pasajero() {
        this.tipodocumento = tipodocumento;
        this.nrodocumento = nrodocumento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public boolean comprar(Vuelo vuelo,char fila , int nroasiento){
        boolean result=false;
        
        return result;
    }
    
    
}
