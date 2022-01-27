
package Modelo;

import java.io.*;
import static Datos.Repositorio.*;
public class Vuelo {
    private String codigo;
    private String fecha;
    private String hora;
    private int puertadeembarque;
    private boolean activo;
    private PasajeroArreglo pasajeros = new PasajeroArreglo();
    private PaisArreglo paises =  new PaisArreglo();
    private AeropuertoArreglo aeropuertos = new AeropuertoArreglo();
    private Aerolinea aerolinea;

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

    public PaisArreglo getPaises() {
        return paises;
    }

    public AeropuertoArreglo getAeropuertos() {
        return aeropuertos;
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
        for(int i=0; i<pasajero.length;i++){
            this.getPasajeros();
        }
        
        return pasajero;
    }
    
    public void guardar(){
        File f = new File("DatosDelSistema");
        try{
            f.delete();
            File fos = new File("DatosDelSistema");
            FileOutputStream archivo = new FileOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(vueloGeneral);
        }catch(Exception e){
            System.out.println("ERROR: ");
            System.err.println(e);
        }
    }
    
    public void recuperar(){
        try{
            FileInputStream archivo = new FileInputStream("DatosDelSistema");
            ObjectInputStream ois = new ObjectInputStream(archivo);
            vueloGeneral = (Vuelo)ois.readObject();
            archivo.close();
        }catch(FileNotFoundException e){
            System.out.println("Se ha creado un archivo");
            File fos = new File("DatosDelSistema");
            System.err.println(e);
            try{
                FileOutputStream archivoA = new FileOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(archivoA);
                oos.writeObject(vueloGeneral);
            }catch(FileNotFoundException h){
                System.err.println(e);
            }catch(IOException h){
                System.err.println(e);
            }
        }catch(IOException e){
            System.err.println(e);
        }catch(Exception e){
            System.err.println(e);
        }
    }
    @Override
    public String toString() {
        return "Vuelo: \t" + "\nCodigo: \t" + this.codigo + "\nFecha: \t" + this.fecha + "\nHora: \t" + this.hora + "\nPuertadeembarque: \t" + this.puertadeembarque + "\nActivo: \t" + this.activo 
                + "\nPasajeros: \t" + this.pasajeros ;
    }
    
}
