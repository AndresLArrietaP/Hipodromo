
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
public class ControladorCaballos {
    private frmCaballos vistaCaballos;
    private int num;
    private boolean editarCaballos;
    private boolean Ultimo=false;
    private boolean editarUltimo=false;
    
    public ControladorCaballos(frmCaballos vistaCaballos,int num){
        this.vistaCaballos = vistaCaballos;
        this.num = num;
        this.vistaCaballos.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.vistaCaballos.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarCaballos == false){
                    caballoGenerico= new Caballo();
                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera ();
                    ControladorCrearCar controlCrearCar= new ControladorCrearCar(vistaCrearCar);
                    vistaCaballos.dispose();
                    controlCrearCar.iniciar();
                }
                else{
                    caballoGenerico = new Caballo();
                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera ();
                    ControladorCrearCar controlCrearCar= new ControladorCrearCar(vistaCrearCar);
                    vistaCaballos.dispose();
                    //controlCrearCar.iniciarEditar();
                }
            }
        });
        
        this.vistaCaballos.btnAgregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(num==carreraGenerica.getNumeroCab()){
                    Ultimo=true;
                }
                if(casillasCompletas()){
                    if(nombresyedadCorrectos()){
                        caballoAuxiliar = new Caballo();
                        caballoAuxiliar = caballoGenerico;
                        caballoGenerico = new Caballo(vistaCaballos.txtNombreC.getText(),Float.parseFloat(vistaCaballos.txtPesoC.getText()), 
                                Integer.parseInt(vistaCaballos.txtEdadC.getText()),vistaCaballos.cmbRazaC.getSelectedItem().toString());
                            if(editarCaballos == false){                               
                                if(Ultimo==false){
                                    carreraGenerica.agregarCaballo(caballoGenerico);
                                    frmCaballos vistaCab = new frmCaballos ();
                                    ControladorCaballos controlCaballo = new ControladorCaballos(vistaCab,num+1);
                                    vistaCaballos.dispose();
                                    controlCaballo.iniciar(num+1);
                                }
                                else {
                                    carreraGenerica.agregarCaballo(caballoGenerico);
                                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                    ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                                    vistaCaballos.dispose();
                                    if(carreraGenerica.getIndiceJ()==0){
                                        controlCrearCar.iniciarB2(true);
                                    }else{
                                        controlCrearCar.iniciarB3(true);
                                    }
                                }                              
                            }
                            else {                             
                                if(editarUltimo==false){
                                    carreraGenerica.eliminarCaballo(caballoAuxiliar);
                                    carreraGenerica.agregarCaballo(caballoGenerico);
                                    caballoAuxiliar = new Caballo();
                                    frmCaballos vistaCab = new frmCaballos ();
                                    ControladorCaballos controlCaballo = new ControladorCaballos(vistaCab,num+1);
                                    vistaCaballos.dispose();
                                    controlCaballo.iniciarEditar(num+1);
                                }
                                else {
                                    carreraGenerica.eliminarJockey(jockeyAuxiliar);
                                    carreraGenerica.agregarJockey(jockeyGenerico);
                                    jockeyAuxiliar = new Jockey();                                   
                                    frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                    ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                                    vistaCaballos.dispose();
                                    //controlCrearCar.iniciarEditar();
                                }                                                          
                            }                                            
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Los datos ingresados no son correctos");
                        limpiarVentana();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Datos incompletos");
                }
            }
        });
        
        
    }
    
    public void iniciar(int i) {
        setDatos(caballoGenerico);
        vistaCaballos.setLocationRelativeTo(null);
        vistaCaballos.lblNumero.setText(String.valueOf(i));
        vistaCaballos.setVisible(true);
        this.editarCaballos = false;
    }
    
    public void iniciarEditar(int i) {
        setDatos(caballoGenerico);
        vistaCaballos.setLocationRelativeTo(null);
        vistaCaballos.lblTitulo.setText("EDITAR JOCKEY Nro");
        vistaCaballos.lblNumero.setText(String.valueOf(i));
        vistaCaballos.btnSalir.setVisible(false);
        vistaCaballos.btnAgregar.setText("GUARDAR");
        vistaCaballos.setVisible(true);
        this.editarCaballos = true;
    }
    public void iniciarUlt(int j) {
        setDatos(caballoGenerico);
        vistaCaballos.setLocationRelativeTo(null);
        vistaCaballos.lblNumero.setText(String.valueOf(j));
        vistaCaballos.btnCancelar.setText("VOLVER");
        vistaCaballos.btnAgregar.setText("TERMINAR");
        vistaCaballos.setVisible(true);
        this.editarCaballos = false;
    }
    public void iniciarEditarUlt(int j) {
        setDatos(caballoGenerico);
        vistaCaballos.setLocationRelativeTo(null);
        vistaCaballos.lblTitulo.setText("EDITAR JOCKEY Nro");
        vistaCaballos.lblNumero.setText(String.valueOf(j));
        vistaCaballos.btnCancelar.setText("VOLVER");
        vistaCaballos.btnSalir.setVisible(false);
        vistaCaballos.btnAgregar.setText("TERMINAR GUARDADO");
        vistaCaballos.setVisible(true);
        this.editarCaballos = true;
    }
    
    public void setDatos(Caballo j){
        vistaCaballos.txtNombreC.setName(j.getNombre_cab());
        vistaCaballos.txtPesoC.setName(Double.toString(j.getPeso()));
        vistaCaballos.txtEdadC.setName(Integer.toString(j.getEdad()));
        vistaCaballos.cmbRazaC.setName(j.getRaza());
        if(j.getRaza().compareTo("Andaluz")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(1);
        }
        else if(j.getRaza().compareTo("Árabe")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(2);
        }
        else if(j.getRaza().compareTo("Pura sangre")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(3);
        }
        else if(j.getRaza().compareTo("Tennesse Walking")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(4);
        }
        else if(j.getRaza().compareTo("Apalusa")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(5);
        }
        else if(j.getRaza().compareTo("Morgan")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(6);
        }
        else if(j.getRaza().compareTo("Paint Horse")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(7);
        }
        else if(j.getRaza().compareTo("Quarter Horse")==0){
            vistaCaballos.cmbRazaC.setSelectedIndex(8);
        }
        else{
            vistaCaballos.cmbRazaC.setSelectedIndex(0);
        }
        //Agregar
    }
    public void limpiarVentana(){
        vistaCaballos.txtNombreC.setText("");
        vistaCaballos.txtPesoC.setText("");
        vistaCaballos.txtEdadC.setText("");
        vistaCaballos.cmbRazaC.setSelectedIndex(0);
    }
    
    public boolean nombresyedadCorrectos(){
        boolean result = false;
        boolean existeNombre = false;
        boolean limiedad = false;
        //boolean limiedad2 = false;
        try{
            String Nombre = vistaCaballos.txtNombreC.getText();
            int EdadC = Integer.valueOf(vistaCaballos.txtEdadC.getText());
            //int EdadJ = Integer.valueOf(vistaJockeyCaballo.txtEdadJ.getText());
            for(int i=0; i<sistemA.getJockeys().getIndiceJock(); i++){
                if(sistemA.getCaballos().getCaballos()[i].getNombre_cab().equals(Nombre)){
                    existeNombre = true;
                }
            }
            if(EdadC > 7){
                limiedad = true;
            }
            /*if(EdadJ > 18  && EdadJ < 60){
                limiedad2 = true;
            }*/
            if((existeNombre==false) && (limiedad == false) /*&& (limiedad2 == false)*/){
                result = true;
            }
        }catch(Exception e){
            System.err.println(e);
        }finally{
            return result;
        }
    }
    
   /* public boolean reemplazarEnSistema(Carrera c){
        //Apuestas
    }*/
    
    public boolean casillasCompletas(){
        boolean result = false;
        if (
            this.vistaCaballos.txtNombreC.getText().length()!=0 &&
            this.vistaCaballos.txtPesoC.getText().length()!=0 &&
            this.vistaCaballos.txtEdadC.getText().length()!=0 &&
            this.vistaCaballos.cmbRazaC.getSelectedItem().toString().compareTo("Seleccione una opción") != 0){
            result = true;
        }
        return result;
    }
}
