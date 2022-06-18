
package App;
import Ventanas.*;
import Programa.*;
import Controladores.*;
import static Datos.Repositorio.*;
/**
 *
 * @author acer
 */
public class Hipódromo {
 
    public static void main(String[] args) {
        sistemA.recuperar();
        frmInicio vistaInicio = new frmInicio();
        ControladorInicio controlInicio = new ControladorInicio(vistaInicio);
        controlInicio.iniciar();
        sistemA.guardar();
    }
    
}
