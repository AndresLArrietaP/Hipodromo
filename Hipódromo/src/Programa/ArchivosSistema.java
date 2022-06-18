
package Programa;
import static Datos.Repositorio.sistemA;
import java.io.*;
/**
 *
 * @author acer
 */
public class ArchivosSistema implements Serializable{
    private ArregloCaballo caballos = new ArregloCaballo();
    private ArregloJockey jockeys = new ArregloJockey();
    private ArregloCarrera carreras = new ArregloCarrera();
    
    public ArchivosSistema() {
        
    }

    public ArregloCaballo getCaballos() {
        return caballos;
    }

    public ArregloJockey getJockeys() {
        return jockeys;
    }

    public ArregloCarrera getCarreras() {
        return carreras;
    }
    
    private String noEncontrado(){
        String result = "No encontrado";
        return result;
    }
    
    public void guardar(){
        File f = new File("DatosHIPÓDROMO");
        try{
            f.delete();
            File fos = new File("DatosHIPÓDROMO");
            FileOutputStream archivo = new FileOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(archivo);
            oos.writeObject(sistemA);
        }catch(Exception e){
            System.out.println("ERROR: ");
            System.err.println(e);
        }
    }
    
    public void recuperar(){
        try{
            FileInputStream archivo = new FileInputStream("DatosHIPÓDROMO");
            ObjectInputStream ois = new ObjectInputStream(archivo);
            sistemA = (ArchivosSistema)ois.readObject();
            archivo.close();
        }catch(FileNotFoundException e){
            System.out.println("Se ha creado un archivo");
            File fos = new File("DatosHIPÓDROMO");
            System.err.println(e);
            try{
                FileOutputStream archivoA = new FileOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(archivoA);
                //Estandar
                oos.writeObject(sistemA);
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
        guardar();
    }
}
