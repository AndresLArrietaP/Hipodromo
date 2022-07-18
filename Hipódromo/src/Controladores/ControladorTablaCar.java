
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
    private boolean editpart;
    
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
        
        this.vistaTabCar.btnverPart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //int pos=0;        
                int fila = vistaTabCar.tblCarreras.getSelectedRow();
                int columna = vistaTabCar.tblCarreras.getSelectedColumn();
                if(editpart==false){
                    if(fila>=0){
                        String numero = vistaTabCar.tblCarreras.getValueAt(fila, 0).toString();
                        for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                            //if(sistem.getObjetos().getProducs()[i].getUsuario() == usuarioActivo){
                                if(sistemA.getCarreras().getCarreras()[i].getNumero_car()==Integer.parseInt(numero)){
                                    //pos=i;
                                    //carreraGenerica = new Carrera();
                              
                                    /*frmTablaParticipantes vistaTabPart = new frmTablaParticipantes();
                                    ControladorTablaPart controlTabPart = new ControladorTablaPart(vistaTabPart,pos);
                                    vistaTabCar.dispose();
                                    controlTabPart.iniciar(); */
                                    
                                    String compe = "";
                                for(int j=0; j<carreraGenerica.getNumeroPart(); j++){
                                compe += "\n      Competidor " + (j+1) + ":";
                                    compe += "\n    Nombre:  " + sistemA.getCarreras().getCarreras()[i].getJockeys()[j].getNombre() +
                                             "\n    Edad:  " + sistemA.getCarreras().getCarreras()[i].getJockeys()[j].getEdad() +
                                             "\n    Caballo:" +
                                             "\n          Nombre:  " + sistemA.getCarreras().getCarreras()[i].getJockeys()[j].getCaballo().getNombre_cab()+
                                             "\n          Edad:  " + sistemA.getCarreras().getCarreras()[i].getJockeys()[j].getCaballo().getEdad() +
                                             "\n          Peso:  " + sistemA.getCarreras().getCarreras()[i].getJockeys()[j].getCaballo().getPeso() +
                                             "\n          Raza:  " + sistemA.getCarreras().getCarreras()[i].getJockeys()[j].getCaballo().getRaza();
                                }
                                   JOptionPane.showMessageDialog(null, "DATOS DE CONCURSANTES:"+compe);
                                }
                            //}
                        }
                    }
                    else{                  
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado un producto para editar");                   
                    }
                }else{
                    if(fila>=0){
                        String numero = vistaTabCar.tblCarreras.getValueAt(fila, 0).toString();
                        for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                            //if(sistem.getObjetos().getProducs()[i].getUsuario() == usuarioActivo){
                                if(sistemA.getCarreras().getCarreras()[i].getNumero_car()==Integer.parseInt(numero)){
                                    //pos=i;
                                    //carreraGenerica = new Carrera();

                                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                    ControladorCrearCar controlCrearCar= new ControladorCrearCar(vistaCrearCar);
                                    vistaTabCar.dispose();
                                    controlCrearCar.iniciarEditar();                          
                                }
                            //}
                        }
                    }
                    else{                  
                        JOptionPane.showMessageDialog(null, "No se ha seleccionado un producto para editar");                   
                    }
                }
                //setTablaCarreras(sistemA);
            }
        });
    
    }
    
    public void iniciar() {
        vistaTabCar.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        vistaTabCar.setVisible(true);
        this.editpart = false;
    }
    public void iniciarPart() {
        vistaTabCar.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        vistaTabCar.setVisible(true);
        vistaTabCar.btnverPart.setText("EDITAR");
        //vistaTabCar.btnActualizar.setVisible(false);
        this.editpart = true;
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
