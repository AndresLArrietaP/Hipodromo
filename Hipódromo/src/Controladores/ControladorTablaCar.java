
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
                    JLabel tick = new JLabel();
                    ControladorApuesta controlApuesta = new ControladorApuesta(vistaApuesta,tick);
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
        
        this.vistaTabCar.btnverPart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //int pos=0;        
                int fila = vistaTabCar.tblCarreras.getSelectedRow();
                int columna = vistaTabCar.tblCarreras.getSelectedColumn();
                if(fila>=0){
                        String numero = vistaTabCar.tblCarreras.getValueAt(fila, 0).toString();
                        for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                            if(String.valueOf(sistemA.getCarreras().getCarreras()[i].getNumero_car()).compareTo(numero) == 0){
                                    
                                    //encontrado = true;
                                    frmApuesta vistaPagCar = new frmApuesta();
                                    JLabel tick = new JLabel();
                                    ControladorApuesta controlPagCar = new ControladorApuesta(vistaPagCar,tick);
                                    carreraActiva = new Carrera();
                                    carreraActiva = sistemA.getCarreras().getCarreras()[i];
                                    cerrarVentana();
                                    controlPagCar.iniciar();
                            }
                        }
                }
                           
              
                    else{                  
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado una carrera para ver");                   
                    }
                               
                //setTablaCarreras(sistemA);
            }
        });
    
    }
    
    public void iniciar() {
        vistaTabCar.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        vistaTabCar.setVisible(true);
    }
    public void iniciarPart() {
        vistaTabCar.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        vistaTabCar.setVisible(true);
        vistaTabCar.btnverPart.setText("EDITAR");
        //vistaTabCar.btnActualizar.setVisible(false);
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
    public void cerrarVentana() {
        this.vistaTabCar.dispose();
    }
}
