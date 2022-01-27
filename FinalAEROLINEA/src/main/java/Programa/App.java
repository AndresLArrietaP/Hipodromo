
package Programa;
import Modelo.*;
import static Datos.Repositorio.*;
public class App {

    public static void main(String[] args) {
        //test
        Pais pais = new Pais("ARG","Argentina");
        Pasajero pasajero = new Pasajero ("DNI","71302850","Camilo Luis","Buendia Lopez","Enero 2002");
        Vuelo vuelo= new Vuelo ("H200","Marzo 2003","7 pm",8,true);
        //archivos
        vueloGeneral.recuperar();
        System.out.println(vueloGeneral.getPasajeros().toString());
        vueloGeneral.guardar();
    }
    
}
