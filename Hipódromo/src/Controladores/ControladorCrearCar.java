
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
                    int i=0;
                        if(i==carreraGenerica.getNumeroPart()-1){
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            Botones2(false);
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
                else{
                    guardarDatos(carreraGenerica);
                    for(int i=0; i<carreraGenerica.getNumeroPart()-1;i++){
                        if(i==carreraGenerica.getNumeroPart()-1){
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            Botones2(false);
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
        this.vistaCarrera.btnCab.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarRegistro == false){
                    guardarDatos(carreraGenerica);
                    int i=0;
                        if(i==carreraGenerica.getNumeroCab()-1){
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            Botones2(true);
                            vistaCarrera.dispose();
                            controlCab.iniciarUlt(i);
                        }else{
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            Botones2(true);
                            vistaCarrera.dispose();
                            controlCab.iniciar(i);
                        }
                    
                }
                else{
                    guardarDatos(carreraGenerica);
                    for(int i=0; i<carreraGenerica.getNumeroCab()-1;i++){
                        if(i==carreraGenerica.getNumeroCab()-1){
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            vistaCarrera.dispose();
                            controlCab.iniciarEditarUlt(i);
                        }else{
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            vistaCarrera.dispose();
                            controlCab.iniciarEditar(i);
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
                            BotonesR(true);
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
                                BotonesR(true);
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
                                JOptionPane.showMessageDialog(null, "No se pudo concretar el guardado porque el número de carrera ya está en\nuso o no está dentro del rango 1000-9999");
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
        Botones(false);

    }
    public void iniciarB2(boolean estado) {
        setDatos(carreraGenerica);
        vistaCarrera.setLocationRelativeTo(null);
        vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        Botones2(estado);
    }
    public void iniciarBR() {
        setDatos(carreraGenerica);
        vistaCarrera.setLocationRelativeTo(null);
        vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        BotonesR(false);
    }
    public void iniciarB3(boolean estado) {
        setDatos(carreraGenerica);
        vistaCarrera.setLocationRelativeTo(null);
        vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        Botones3(estado);
    }
    public void iniciarEditar() {
        setDatos(carreraGenerica);
        vistaCarrera.setLocationRelativeTo(null);
        vistaCarrera.lblTitulo.setText("EDITAR CARRERA");
        vistaCarrera.btnSalir.setVisible(false);
        vistaCarrera.btnPart.setText("EDITAR PARTICIPANTES");
        vistaCarrera.btnCab.setText("EDITAR CABALLOS");
        vistaCarrera.btnRegistrar.setText("GUARDAR");
        vistaCarrera.setVisible(true);
        this.editarRegistro = true;
    }
    
    public void limpiarVentana(){
        vistaCarrera.txtNumero.setText("");
        vistaCarrera.txtPart.setText("");
        vistaCarrera.txtCab.setText("");
        carreraGenerica = new Carrera();
        jockeyGenerico = new Jockey();
    }
    
    public void setDatos(Carrera c){
        vistaCarrera.txtNumero.setText(Integer.toString(c.getNumero_car()));
        vistaCarrera.txtPart.setText(Integer.toString(c.getNumeroPart()));
        vistaCarrera.txtCab.setText(Integer.toString(c.getNumeroCab()));
        vistaCarrera.cobDist.setName(Integer.toString(c.getDistancia()));
        //Agregar
    }
    
    public void guardarDatos(Carrera c){
        try{
            c.setNumero_car(Integer.parseInt(vistaCarrera.txtNumero.getText()));
            c.setNumeroPart(Integer.parseInt(vistaCarrera.txtPart.getText()));
            c.setNumeroCab(Integer.parseInt(vistaCarrera.txtCab.getText()));
            c.setDistancia(Integer.parseInt((String)vistaCarrera.cobDist.getSelectedItem()));
        }catch(Exception e){       
        }
    }
    public void Botones(boolean estado){
        vistaCarrera.btnPart.setEnabled(estado);
        vistaCarrera.btnCab.setEnabled(estado);
        vistaCarrera.btnCompe.setEnabled(estado);
        
    }
    public void BotonesR(boolean estado){
        vistaCarrera.btnPart.setEnabled(estado);
        vistaCarrera.btnCab.setEnabled(estado);
        vistaCarrera.btnCompe.setEnabled(!estado);
        
    }
    public void Botones2(boolean estado){
        vistaCarrera.btnPart.setEnabled(estado);
        vistaCarrera.btnCab.setEnabled(!estado);
        vistaCarrera.btnCompe.setEnabled(false);
    }
    public void Botones3(boolean estado){
        vistaCarrera.btnPart.setEnabled(!estado);
        vistaCarrera.btnCab.setEnabled(!estado);
        vistaCarrera.btnCompe.setEnabled(estado);
    }
    public boolean numerosCorrectos(){
        boolean result = false;
        boolean existeNumero = false;
        boolean limitnum = false;
        try{
            int Numero = Integer.parseInt(vistaCarrera.txtNumero.getText());
            for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                if(sistemA.getCarreras().getCarreras()[i].getNumero_car()==Numero){
                    existeNumero = true;
                }
            }
            if(Numero>9999 || Numero<1000){
                limitnum = true;
            }
            if((existeNumero==false)&&(limitnum==false)){
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
