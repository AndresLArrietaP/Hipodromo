
package analexflexx;

import java.io.File;

/**
 *
 * @author acer
 */
public class AnaLEXMain {
    public static void main(String[] args) {
        String Ruta="C:/Users/acer/Pictures/Java POO/ExamenFinal_Arrieta_Andres/AnaLexFLEXX/src/analexflexx/LEXFLEX"; //RUTA DE SOURCE PACKAGES (MODIFICAR)
        generarLexer(Ruta);
    }
    
    public static void generarLexer(String Ruta){
        File Arc = new File(Ruta);
        JFlex.Main.generate(Arc);
    }
   
}