
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
                    for(int i=0; i<sistemA.getCarreras().getIndiceCar(); i++){
                        if(carreraGenerica.getIndiceJ()==0 || carreraGenerica.getIndiceJ()==0){
                            JOptionPane.showMessageDialog(null, "No olvide ingresar caballos o jockeys.");
                        }else{
                        frmInicio vistaInicio = new frmInicio();
                        ControladorInicio controlInicio = new ControladorInicio(vistaInicio);
                        carreraActiva = new Carrera();
                        carreraActiva = sistemA.getCarreras().getCarreras()[i];
                        vistaCarrera.dispose();
                        controlInicio.iniciar();
                        }
                    }
                }
                else{
                    carreraGenerica = new Carrera();
                    frmApuesta vistaVerApuesta = new frmApuesta();
                    JLabel tick = new JLabel();
                    ControladorApuesta controlApuesta = new ControladorApuesta(vistaVerApuesta,tick);
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
                    int i=1;
                        if(i==carreraGenerica.getNumeroPart()){
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            //Botones2(false);
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciarUlt(i);
                        }else{
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            Botones2(false);
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciar(i);
                        }
                    
                }
                else{
                    guardarDatos(carreraGenerica);
                        int i=1;
                        if(i==carreraGenerica.getNumeroPart()){
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            sistemA.guardar();
                            vistaCarrera.dispose();
                            controlJockeyCab.iniciarEditUltReg(i);
                        }else{
                            jockeyGenerico = new Jockey();
                            frmJockeysCaballos vistaJockeyCaballo = new frmJockeysCaballos();
                            ControladorJockeysCaballos controlJockeyCab = new ControladorJockeysCaballos(vistaJockeyCaballo,i);
                            vistaCarrera.dispose();
                            sistemA.guardar();
                            controlJockeyCab.iniciarEditReg(i);
                        }
                    }
                
            }
        });
        this.vistaCarrera.btnCab.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarRegistro == false){
                    guardarDatos(carreraGenerica);
                    int i=1;
                        if(i==carreraGenerica.getNumeroCab()){
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            //Botones2(true);
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
                    int i=1;
                        if(i==carreraGenerica.getNumeroCab()){
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            sistemA.guardar();
                            vistaCarrera.dispose();
                            controlCab.iniciarEditUltReg(i);
                        }else{
                            caballoGenerico = new Caballo();
                            frmCaballos vistaCaballos = new frmCaballos();
                            ControladorCaballos controlCab = new ControladorCaballos(vistaCaballos,i);
                            sistemA.guardar();
                            vistaCarrera.dispose();
                            controlCab.iniciarEditReg(i);
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
                                JLabel tick = new JLabel();
                                ControladorApuesta controlApuesta = new ControladorApuesta(vistaApuesta,tick);
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
        this.vistaCarrera.btnCompe.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(editarRegistro == false){
                    //carreraGenerica = new Carrera();
                    frmInscripcion vistaInscripcion = new frmInscripcion();
                    ControladorInscripcion controlInscripcion = new ControladorInscripcion(vistaInscripcion);
                    vistaCarrera.dispose();
                    controlInscripcion.iniciar();
                }
                else{
                    //carreraGenerica = new Carrera();
                    frmInscripcion vistaInscripcion = new frmInscripcion();
                    ControladorInscripcion controlInscripcion = new ControladorInscripcion(vistaInscripcion);
                    vistaCarrera.dispose();
                    controlInscripcion.iniciarEditar();
                }
            }
        });
        
    
    }
    public void iniciar() {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        Botones(false);

    }
    public void iniciarB2(boolean estado) {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        Botones2(estado);
    }
    public void iniciarBR() {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        BotonesR(false);
    }
    public void iniciarB3(boolean estado) {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = false;
        Botones3(estado);
    }
    public void iniciarEditar() {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.lblTitulo.setText("EDITAR CARRERA");
        this.vistaCarrera.btnSalir.setVisible(false);
        this.vistaCarrera.btnPart.setText("EDITAR PARTICIPANTES");
        this.vistaCarrera.btnCab.setText("EDITAR CABALLOS");
        this.vistaCarrera.btnRegistrar.setText("GUARDAR");
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = true;
    }
    public void iniciarEditarB2(boolean estado) {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.lblTitulo.setText("EDITAR CARRERA");
        this.vistaCarrera.btnSalir.setVisible(false);
        this.vistaCarrera.btnPart.setText("EDITAR PARTICIPANTES");
        this.vistaCarrera.btnCab.setText("EDITAR CABALLOS");
        this.vistaCarrera.btnRegistrar.setText("GUARDAR");
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = true;
        Botones2(estado);
    }
    public void iniciarEditarB3(boolean estado) {
        setDatos(carreraGenerica);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.lblTitulo.setText("EDITAR CARRERA");
        this.vistaCarrera.btnSalir.setVisible(false);
        this.vistaCarrera.btnPart.setText("EDITAR PARTICIPANTES");
        this.vistaCarrera.btnCab.setText("EDITAR CABALLOS");
        this.vistaCarrera.btnRegistrar.setText("GUARDAR");
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = true;
        Botones3(estado);
    }
    public void iniciarEditar2(int n) {
        setDatos2(n);
        this.vistaCarrera.setLocationRelativeTo(null);
        this.vistaCarrera.lblTitulo.setText("EDITAR CARRERA");
        this.vistaCarrera.btnSalir.setVisible(false);
        this.vistaCarrera.btnPart.setText("EDITAR PARTICIPANTES");
        this.vistaCarrera.btnCab.setText("EDITAR CABALLOS");
        this.vistaCarrera.btnRegistrar.setText("GUARDAR");
        this.vistaCarrera.setVisible(true);
        this.editarRegistro = true;
    }
    
    public void limpiarVentana(){
        this.vistaCarrera.txtNumero.setText("");
        this.vistaCarrera.txtPart.setText("");
        this.vistaCarrera.txtCab.setText("");
        carreraGenerica = new Carrera();
        jockeyGenerico = new Jockey();
    }
    
    public void setDatos(Carrera c){
        this.vistaCarrera.txtNumero.setText(Integer.toString(c.getNumero_car()));
        this.vistaCarrera.txtPart.setText(Integer.toString(c.getNumeroPart()));
        this.vistaCarrera.txtCab.setText(Integer.toString(c.getNumeroCab()));
        this.vistaCarrera.cobDist.setName(Integer.toString(c.getDistancia()));
        //Agregar
    }
    public void setDatos2(int n){
        this.vistaCarrera.txtNumero.setText(Integer.toString(sistemA.getCarreras().getCarreras()[n].getNumero_car()));
        this.vistaCarrera.txtPart.setText(Integer.toString(sistemA.getCarreras().getCarreras()[n].getNumeroPart()));
        this.vistaCarrera.txtCab.setText(Integer.toString(sistemA.getCarreras().getCarreras()[n].getNumeroCab()));
        this.vistaCarrera.cobDist.setName(Integer.toString(sistemA.getCarreras().getCarreras()[n].getDistancia()));
        //Agregar
    }
    
    public void guardarDatos(Carrera c){
        try{
            c.setNumero_car(Integer.parseInt(this.vistaCarrera.txtNumero.getText()));
            c.setNumeroPart(Integer.parseInt(this.vistaCarrera.txtPart.getText()));
            c.setNumeroCab(Integer.parseInt(this.vistaCarrera.txtCab.getText()));
            c.setDistancia(Integer.parseInt((String)this.vistaCarrera.cobDist.getSelectedItem()));
        }catch(Exception e){       
        }
    }
    public void Botones(boolean estado){
        this.vistaCarrera.btnPart.setEnabled(estado);
        this.vistaCarrera.btnCab.setEnabled(estado);
        this.vistaCarrera.btnCompe.setEnabled(estado);
        
    }
    public void BotonesR(boolean estado){
        this.vistaCarrera.btnPart.setEnabled(estado);
        this.vistaCarrera.btnCab.setEnabled(estado);
        this.vistaCarrera.btnCompe.setEnabled(!estado);
        
    }
    public void Botones2(boolean estado){
        this.vistaCarrera.btnPart.setEnabled(estado);
        this.vistaCarrera.btnCab.setEnabled(!estado);
        this.vistaCarrera.btnCompe.setEnabled(false);
    }
    public void Botones3(boolean estado){
        this.vistaCarrera.btnPart.setEnabled(!estado);
        this.vistaCarrera.btnCab.setEnabled(!estado);
        this.vistaCarrera.btnCompe.setEnabled(estado);
    }
    public boolean numerosCorrectos(){
        boolean result = false;
        boolean existeNumero = false;
        boolean limitnum = false;
        try{
            int Numero = Integer.parseInt(this.vistaCarrera.txtNumero.getText());
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
