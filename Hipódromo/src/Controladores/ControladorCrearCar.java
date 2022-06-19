
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
public class ControladorCrearCar {
    private frmCrearCarrera vistaCarrera;
    private boolean editarRegistro;
    
    public ControladorCrearCar(frmCrearCarrera vistaCarrera){
        this.vistaCarrera = vistaCarrera;
        
        this.vistaCarrera.btnLimpiar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                limpiarVentana();
            }
        });
        
        this.vistaCarrera.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.vistaCarrera.btnVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarRegistro == false){
                    carreraGenerica = new Carrera();
                    frmInicio vistaInicio = new frmInicio();
                    ControladorInicio controlInicio = new ControladorInicio(vistaInicio);
                    vistaCarrera.dispose();
                    controlInicio.iniciar();
                }
                else{
                    carreraGenerica = new Carrera();
                    frmApuesta vistaVerApuesta = new frmApuesta();
                    ControladorApuesta controlApuesta = new ControladorApuesta(vistaVerApuesta);
                    vistaCarrera.dispose();
                    controlApuesta.iniciar();
                }
            }
        });
        
        this.vistaCarrera.btnPart.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarRegistro == false){
                    guardarDatos(carreraGenerica);
                    for(int i=0; i<carreraGenerica.getNumeroPart();i++){
                        if(i==carreraGenerica.getNumeroPart()-1){
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciarUlt(i);
                        }else{
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciar(i);
                        }
                    }
                }
                else{
                    guardarDatos(carreraGenerica);
                    for(int i=0; i<carreraGenerica.getNumeroPart()-1;i++){
                        if(i==carreraGenerica.getNumeroPart()-1){
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciarEditarUlt(i);
                        }else{
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciarEditar(i);
                        }
                    }
                }
            }
        });
        
        this.vistaCarrera.btnRegistrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                guardarDatos(carreraGenerica);
                if(casillasCompletas()){
                    if(editarRegistro == false){
                        if(numerosCorrectos()){
                            sistemA.getCarreras().agregarCarrera(carreraGenerica);
                            carreraGenerica = new Carrera();
                            sistemA.guardar();
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "El número de carrera ya está en\nuso o ha sido ingresado incorrectamente");
                        }
                    }
                    else{
                        if(sistemA.getCarreras().eliminarCarreraN(carreraActiva.getNumero_car())){
                            if(numerosCorrectos() == true){
                                /*if()){
                                    //Apuestas
                                }*/
                                sistemA.getCarreras().agregarCarrera(carreraGenerica);
                                frmApuesta vistaApuesta = new frmApuesta();
                                ControladorApuesta controlApuesta = new ControladorApuesta(vistaApuesta);
                                sistemA.guardar();
                                carreraActiva = carreraGenerica;
                                vistaCarrera.dispose();
                                controlApuesta.iniciar();
                            }
                            else{
                                sistemA.getCarreras().agregarCarrera(carreraActiva);
                                /*if(){
                                    //Apuesta
                                }*/
                                JOptionPane.showMessageDialog(null, "No se pudo concretar el guardado porque el número de carrera ya está en\nuso o ha sido ingresado incorrectamente");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "No se pudieron guardar los datos");
                        }
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se han completado todos los recuadros necesarios");
                }
            }
        });
        
    
    }
    public void iniciar() {
        setDatos(carreraGenerica);
        vistaCarrera.setLocationRelativeTo(null);
        vistaCarrera.setVisible(true);
        this.editarRegistro = false;
    }
    
    public void iniciarEditar() {
        setDatos(carreraGenerica);
        vistaCarrera.setLocationRelativeTo(null);
        vistaCarrera.lblTitulo.setText("EDITAR CARRERA");
        vistaCarrera.btnSalir.setVisible(false);
        vistaCarrera.btnPart.setText("EDITAR PARTICIPANTES");
        vistaCarrera.btnRegistrar.setText("GUARDAR");
        vistaCarrera.setVisible(true);
        this.editarRegistro = true;
    }
    
    public void limpiarVentana(){
        vistaCarrera.txtNumero.setText("");
        vistaCarrera.txtPart.setText("");
        carreraGenerica = new Carrera();
        jockeyGenerico = new Jockey();
    }
    
    public void setDatos(Carrera c){
        vistaCarrera.txtNumero.setText(Integer.toString(c.getNumero_car()));
        vistaCarrera.txtPart.setText(Integer.toString(c.getNumeroPart()));
        vistaCarrera.cobDist.setName(Integer.toString(c.getDistancia()));
        //Agregar
    }
    
    public void guardarDatos(Carrera c){
        try{
            c.setNumero_car(Integer.parseInt(vistaCarrera.txtNumero.getText()));
            c.setNumeroPart(Integer.parseInt(vistaCarrera.txtPart.getText()));
            
        }catch(Exception e){       
        }
    }
    
    public boolean numerosCorrectos(){
        boolean result = false;
        boolean existeNumero = false;
        try{
            int Numero = Integer.parseInt(vistaCarrera.txtNumero.getText());
            for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                if(sistemA.getCarreras().getCarreras()[i].getNumero_car()==Numero){
                    existeNumero = true;
                }
            }
            if(existeNumero==false){
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
        if (this.vistaCarrera.txtNumero.getText().length()!=0 &&
            this.vistaCarrera.txtPart.getText().length()!=0){
            result = true;
        }
        return result;
    }
}
