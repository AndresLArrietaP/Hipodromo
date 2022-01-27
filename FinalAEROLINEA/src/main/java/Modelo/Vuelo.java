
package Modelo;

public class Vuelo {
    private String codigo;
    private String fecha;
    private String hora;
    private int puertadeembarque;
    private boolean activo;
    private PasajeroArreglo pasajeros = new PasajeroArreglo();

    public Vuelo(String codigo, String fecha, String hora, int puertadeembarque, boolean activo) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.puertadeembarque = puertadeembarque;
        this.activo = activo;
    }
    
    public Vuelo() {
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.puertadeembarque = puertadeembarque;
        this.activo = activo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getPuertadeembarque() {
        return puertadeembarque;
    }

    public boolean isActivo() {
        return activo;
    }

    public PasajeroArreglo getPasajeros() {
        return pasajeros;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setPuertadeembarque(int puertadeembarque) {
        this.puertadeembarque = puertadeembarque;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public void setPasajeros(PasajeroArreglo pasajeros) {
        this.pasajeros = pasajeros;
    }
    
    public boolean venderAsiento(Pasajero p, int nroasiento, char fila){
        boolean result = false;
        
        return result;
    }
    
    public Asiento[] asientosDisponible(){
        Asiento[] asiento = null;
        return asiento;
    }
    
    public boolean reservarAsiento(int nroasiento, char fila){
        boolean result = false;
        
        return result; 
    }
    
    public boolean cancelarAsiento(int nroasiento, char fila){
        boolean result = false;
        
        return result; 
    }
    
    public String getCiudadSalida(){
        String ciudad = null;
        
        return ciudad;
    }
    
    public String getCiudadLlegada(){
        String ciudad = null;
        
        return ciudad;
    }
    
    public String getAeropuertoSalida(){
        String aeropuerto = null;
        
        return aeropuerto;
    }
        
    public String getAeropuertoLlegada(){
        String aeropuerto= null;
        
        return aeropuerto;
    }
    
    public Pasajero[] getListaPasajeros(){
        Pasajero[] pasajero= null;
        
        return pasajero;
    }
    
}
