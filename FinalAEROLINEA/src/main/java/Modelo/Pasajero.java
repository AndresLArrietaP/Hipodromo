
package Modelo;

public class Pasajero {
    private String tipodocumento;
    private String nrodocumento;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private Asiento asientos[];

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

    public Asiento[] getAsientos() {
        return asientos;
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

    public void setAsientos(Asiento[] asientos) {
        this.asientos = asientos;
    }
    
    public boolean comprar(Vuelo vuelo,char fila , int nroasiento){
        boolean result=false;
        
        if(this.getAsientos()[this.asientos.length].reservarAsiento()==false){
            for(int i=0; i<this.asientos.length;i++){
                Pasajero p=vuelo.getPasajeros().getPasajeros()[this.asientos.length];
            vuelo.reservarAsiento(nroasiento, fila);
            vuelo.venderAsiento(p, nroasiento, fila);
                }
        }
        return result;
    }
    
    @Override
    public String toString() {
        return "\tTipo documento: \t" + this.tipodocumento + "\n\tNro documento: \t" + this.nrodocumento+ "\n\tNombres: \t" + this.nombres + "\n\tApellidos: \t" + this.apellidos
                + "\n\tFecha de nacimiento: \t"+ this.fechaNacimiento + "\n\tAsientos: \t" + this.asientos.toString();
    }
    
}
