
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
public class ControladorInicio {
    private frmInicio vistaInicio;
    private frmTablaCarreras vistaTabCar;
    
    public ControladorInicio(frmInicio vistaInicio){
        this.vistaInicio = vistaInicio;
        
        this.vistaInicio.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.vistaInicio.btnCrearCar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                carreraGenerica = new Carrera();
                frmCrearCarrera vistaCarrera = new frmCrearCarrera();
                ControladorCrearCar controlCrear = new ControladorCrearCar(vistaCarrera);
                vistaInicio.dispose();
                controlCrear.iniciar();
            }
        });
        
        this.vistaInicio.btnVerApostar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                boolean encontrado = false;
                for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                    
                            encontrado = true;
                            frmTablaCarreras vistaTabCar= new frmTablaCarreras();
                            ControladorTablaCar controlTabCar = new ControladorTablaCar(vistaTabCar);
                            vistaInicio.dispose();
                            controlTabCar.iniciar();                     
                    
                }
                if(encontrado == false){
                    JOptionPane.showMessageDialog(null, "No se ha creado ninguna carrera");
                }
            }
        });
    }
    
    public void iniciar(){
        sistemA.recuperar();
        carreraActiva = new Carrera();
        carreraGenerica = new Carrera();
        jockeyGenerico = new Jockey();
        jockeyAuxiliar = new Jockey();
        vistaInicio.setLocationRelativeTo(null);
        vistaInicio.setVisible(true);
        System.out.println(sistemA.getCarreras());
    }
    
}
