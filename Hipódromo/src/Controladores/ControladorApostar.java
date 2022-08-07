
package Controladores;
import java.io.*;
import Programa.*;
import Ventanas.*;
import App.*;
import static Datos.Repositorio.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author acer
 */
public class ControladorApostar {
    private frmApostar vistaApostar;
    
    public ControladorApostar(frmApostar vistaApostar){
        this.vistaApostar = vistaApostar;
        
        
        this.vistaApostar.btnVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    carreraGenerica = new Carrera();
                    frmApuesta vistaApuesta = new frmApuesta();
                    ControladorApuesta controlApuesta = new ControladorApuesta(vistaApuesta);
                    sistemA.guardar();
                    vistaApostar.dispose();
                    controlApuesta.iniciar();

                }            
        });
        
        this.vistaApostar.btnGenerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
              //
            }
        });
    }
    
    public void iniciar() {
        vistaApostar.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        apuestaGenerica = new NodoApuesta();
        vistaApostar.setVisible(true);
    }
    
}
