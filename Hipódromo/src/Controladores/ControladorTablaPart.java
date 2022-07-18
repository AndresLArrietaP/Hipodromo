
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
public class ControladorTablaPart {
    private frmTablaParticipantes vistaTabPart;

    
    public ControladorTablaPart(frmTablaParticipantes vistaTabPart,int n){
        this.vistaTabPart = vistaTabPart;
        
        this.vistaTabPart.btnVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
               
                    carreraGenerica = new Carrera();
                    frmTablaCarreras vistaTabCar = new frmTablaCarreras();
                    ControladorTablaCar controlTabCar = new ControladorTablaCar(vistaTabCar);
                    vistaTabPart.dispose();
                    controlTabCar.iniciar();               
                
            }            
        });
        
        this.vistaTabPart.btnActualizar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                setTablaParticipantes(sistemA.getCarreras().getCarreras()[n]);
            }
        });
        
    
    }
    
    public void iniciar() {
        vistaTabPart.setLocationRelativeTo(null);
        //carreraGenerica = new Carrera();
        vistaTabPart.setVisible(true);
        this.vistaTabPart.btnverPart.setVisible(false);

    }
    
    public void setTablaParticipantes(Carrera c){
        String matriz[][] = new String[c.getNumeroPart()][6];
        for(int i=0; i<c.getNumeroPart(); i++){
            matriz[i][0] = c.getJockeys()[i].getNombre();
            matriz[i][1] = Integer.toString(c.getJockeys()[i].getEdad());
            matriz[i][2] = c.getJockeys()[i].getCaballo().getNombre_cab();
            matriz[i][3] = Integer.toString(c.getJockeys()[i].getCaballo().getEdad());
            matriz[i][4] = Float.toString(c.getJockeys()[i].getCaballo().getPeso());
            matriz[i][5] = c.getJockeys()[i].getCaballo().getRaza();
        }
        String cabecera[] = {"Nombre ", "Edad ", "Nombre Caballo","Edad Caballo","Peso Caballo","Raza Caballo"};
        vistaTabPart.tblParticipantes.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            cabecera
        ));
    }
}
