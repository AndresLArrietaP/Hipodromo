
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
public class ControladorTablaCar {
    private frmTablaCarreras vistaTabCar;
    
    public ControladorTablaCar(frmTablaCarreras vistaTabCar){
        this.vistaTabCar = vistaTabCar;
        
        this.vistaTabCar.btnVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    carreraGenerica = new Carrera();
                    frmApuesta vistaApuesta = new frmApuesta();
                    ControladorApuesta controlApuesta = new ControladorApuesta(vistaApuesta);
                    vistaTabCar.dispose();
                    controlApuesta.iniciar();

                }            
        });
        
        this.vistaTabCar.btnActualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setTablaCarreras(sistemA);
            }
        });
    
    }
    
    public void iniciar() {
        vistaTabCar.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        vistaTabCar.setVisible(true);
    }
    
    public void setTablaCarreras(ArchivosSistema s){
        String matriz[][] = new String[s.getCarreras().getIndiceCar()][3];
        for(int i=0; i<s.getCarreras().getIndiceCar(); i++){
            matriz[i][0] = Integer.toString(s.getCarreras().getCarreras()[i].getNumero_car());
            matriz[i][1] = Integer.toString(s.getCarreras().getCarreras()[i].getNumeroPart());
            matriz[i][2] = Integer.toString(s.getCarreras().getCarreras()[i].getDistancia());
        }
        String cabecera[] = {"Número", "NroParticipantes", "Distancia"};
        vistaTabCar.tblCarreras.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            cabecera
        ));
    }
}
