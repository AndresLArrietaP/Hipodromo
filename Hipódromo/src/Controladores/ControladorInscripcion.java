
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
public class ControladorInscripcion {
     private frmInscripcion vistaInscripcion;
     private boolean editarInscritos;

     public ControladorInscripcion(frmInscripcion vistaInscripcion){
         this.vistaInscripcion = vistaInscripcion;
         
         this.vistaInscripcion.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarInscritos == false){
                    caballoGenerico= new Caballo();
                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera ();
                    ControladorCrearCar controlCrearCar= new ControladorCrearCar(vistaCrearCar);
                    vistaInscripcion.dispose();
                    controlCrearCar.iniciar();
                }
                else{
                    caballoGenerico = new Caballo();
                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera ();
                    ControladorCrearCar controlCrearCar= new ControladorCrearCar(vistaCrearCar);
                    vistaInscripcion.dispose();
                    controlCrearCar.iniciarEditar();
                }
            }
        });
         
        this.vistaInscripcion.btnInscribir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int due=0;
                int cab=0;

                if(vistaInscripcion.cmbJockeys.getSelectedItem().toString().compareTo("Seleccione una opción")!=0 && 
                        vistaInscripcion.cmbCaballos.getSelectedItem().toString().compareTo("Seleccione una opción")!=0){
                    due=jockeyDueño();
                    cab=caballoAsig();
                    for(int i=0; i<carreraGenerica.getCaballos().getIndiceCab(); i++){
                        //if(sistemA.getCaballos().getCaballos()[i].getNombre_cab().compareTo(vistaInscripcion.cmbCaballos.getSelectedItem().toString())==0){                            
                        if(JockoCabEnUso(carreraGenerica.getCaballos().getCaballos()[cab])){
                                JOptionPane.showMessageDialog(null, "El caballo ya cuenta con Jockey");
                                vistaInscripcion.cmbCaballos.setSelectedIndex(0);
                                vistaInscripcion.cmbJockeys.setSelectedIndex(0);
                                //sistemA.guardar();
                            }
                            else{
                                carreraGenerica.getJockeys().getJockeys()[due].setCaballo(carreraGenerica.getCaballos().getCaballos()[cab]);
                                vistaInscripcion.cmbJockeys.removeItemAt(vistaInscripcion.cmbJockeys.getSelectedIndex());
                                vistaInscripcion.cmbCaballos.removeItemAt(vistaInscripcion.cmbCaballos.getSelectedIndex());
                                vistaInscripcion.cmbJockeys.setSelectedIndex(0);
                                vistaInscripcion.cmbCaballos.setSelectedIndex(0);
                                //sistemA.guardar();
                            }
                        //}
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Ningun caballo o jinete seleccionado.\nNo se puede agregar.");
                }
            }
        });
         
         
     }
     public void iniciar(){
        vistaInscripcion.setLocationRelativeTo(null);
        //jockeyGenerico = new Jockey();
        this.editarInscritos = false;
        llenarCategorias();
        vistaInscripcion.setVisible(true);
    }
    
    public void iniciarEditar(){
        vistaInscripcion.setLocationRelativeTo(null);
        this.editarInscritos= true;
        setDatos(carreraActiva);
        vistaInscripcion.lblTitulo.setText("EDITAR INS.");
        llenarCategorias();
        vistaInscripcion.btnInscribir.setText("Guardar");
        vistaInscripcion.setVisible(true);
    }
    
    /*public boolean agregarJockeyProv(Jockey jock){
        boolean result = false;
        if(this.estaLlenoJockey()){
            this.crecerArregloJockey();
        }
        provisionJockey.getJockeys()[provisionJockey.getIndiceJock()] = jock;
        provisionJockey.setIndiceJock(provisionJockey.getIndiceJock()+1);
        result = true;
        return result;
    }
    public boolean eliminarJockeyProv(Jockey jock){
        boolean result = false;
        if(estaVacioJockey() == false){
            for(int i=0; i<provisionJockey.getIndiceJock(); i++){
                if(provisionJockey.getJockeys()[i]==jock){
                    for(int j=i+1; j<provisionJockey.getIndiceJock();j++){
                        provisionJockey.getJockeys()[i] = provisionJockey.getJockeys()[j];
                        i++;
                    }
                    provisionJockey.setIndiceJock(provisionJockey.getIndiceJock()-1);
                    result = true;
                }
            }
        }
        return result;
    }
    private boolean estaLlenoJockey(){
        boolean result = false;
        if(provisionJockey.getJockeys().length <= provisionJockey.getIndiceJock()){
            result = true;
        }
        return result;
    }
    
    private boolean estaVacioJockey(){
        boolean result = false;
        if(provisionJockey.getIndiceJock() == 0 ) {
            result = true;
        }
        return result;
    }
    
    private boolean crecerArregloJockey(){
        boolean result = false;
        Jockey jockeysPlus[] = new Jockey[provisionJockey.getJockeys().length + 1];
        for(int i=0; i<provisionJockey.getJockeys().length; i++){
            jockeysPlus[i] = provisionJockey.getJockeys()[i];
            if(i == (provisionJockey.getJockeys().length - 1)){
                result = true;
            }
        }
        provisionJockey.setJockeys(jockeysPlus);
        return result;
    }*/
    public void setDatos(Carrera c){
        for(int i=0; i<sistemA.getJockeys().getIndiceJock(); i++){
            vistaInscripcion.cmbJockeys.addItem(c.getJockeys().getJockeys()[i].getNombre()+" "+c.getJockeys().getJockeys()[i].getEdad());
        }
        for(int i=0; i<sistemA.getCaballos().getIndiceCab(); i++){
            vistaInscripcion.cmbCaballos.addItem(c.getJockeys().getJockeys()[i].getNombre()+" "+c.getJockeys().getJockeys()[i].getEdad());
        }
    }
    public int jockeyDueño(){
        int pos = 0;

        String nom= vistaInscripcion.cmbJockeys.getSelectedItem().toString();
        for(int i=0; i<carreraGenerica.getJockeys().getIndiceJock(); i++){
            if(carreraGenerica.getJockeys().getJockeys()[i].getNombre().compareTo(nom) ==0){
                pos=i;
            }
        }        
        return pos;   
    }
    public int caballoAsig(){
        int pos = 0;

        String nom= vistaInscripcion.cmbCaballos.getSelectedItem().toString();
        for(int i=0; i<carreraGenerica.getCaballos().getIndiceCab(); i++){
            if(carreraGenerica.getCaballos().getCaballos()[i].getNombre_cab().compareTo(nom) ==0){
                pos=i;
            }
        }  
        
        return pos;   
    }
     public boolean casillasLlenas() {
        boolean result = false;
        if (
                this.vistaInscripcion.cmbJockeys.getSelectedItem().toString().compareTo("Seleccione una opción") != 0 &&
                this.vistaInscripcion.cmbCaballos.getSelectedItem().toString().compareTo("Seleccione una opción") != 0 
            ){
            result = true;
        }
        return result;
    }
     public void llenarCategorias() {
        vistaInscripcion.cmbJockeys.removeAllItems();
        vistaInscripcion.cmbCaballos.removeAllItems();
        
        vistaInscripcion.cmbJockeys.addItem("Seleccione una opción");
        vistaInscripcion.cmbCaballos.addItem("Seleccione una opción");
        for(int i=0; i<carreraGenerica.getJockeys().getIndiceJock(); i++){
            vistaInscripcion.cmbJockeys.addItem(carreraGenerica.getJockeys().getJockeys()[i].getNombre());
        }
        for(int i=0; i<carreraGenerica.getCaballos().getIndiceCab(); i++){
            vistaInscripcion.cmbCaballos.addItem(carreraGenerica.getCaballos().getCaballos()[i].getNombre_cab());
        } 

    }
    
    public boolean JockoCabEnUso(Caballo c){
        boolean result = false;
        for(int i=0; i<carreraGenerica.getJockeys().getIndiceJock(); i++){
            if(carreraGenerica.getJockeys().getJockeys()[i].getCaballo()==c){
                result = true;
            }
        }
        return result;
    }
}
