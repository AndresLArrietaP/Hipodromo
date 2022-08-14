
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
public class ControladorJockeysCaballos {
    private frmJockeysCaballos vistaJockeyCaballo;
    private int num;
    private boolean editarJockeys;
    private boolean editarUltimo=false;
    private boolean editarJockeysYCarrera;
    private boolean Ultimo=false;
    public ControladorJockeysCaballos(frmJockeysCaballos vistaJockeyCaballo,int num){
        this.vistaJockeyCaballo = vistaJockeyCaballo;
        this.num = num;
        this.vistaJockeyCaballo.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.vistaJockeyCaballo.btnCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                cerrarVentana();
                if(editarJockeysYCarrera==false){
                    controlCrearCar.iniciar();
                }
                else{
                    controlCrearCar.iniciarEditar();
                }
            }
        });
        
        this.vistaJockeyCaballo.btnAgregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(num==carreraGenerica.getNumeroPart()){
                    Ultimo=true;
                }
                if(casillasCompletas()){
                    if(nombresyedadCorrectos()){
                        jockeyAuxiliar = new Jockey();
                        jockeyAuxiliar = jockeyGenerico;
                        jockeyGenerico = new Jockey(vistaJockeyCaballo.txtNombreJ.getText(), Integer.parseInt(vistaJockeyCaballo.txtEdadJ.getText()));
          
                            if(editarJockeys == false){
                                if(editarJockeysYCarrera==false){
                                    if(Ultimo==false){
                                        carreraGenerica.agregarJockey(jockeyGenerico);
                                        frmJockeysCaballos vistaJock = new frmJockeysCaballos();
                                        ControladorJockeysCaballos controlJockeys = new ControladorJockeysCaballos(vistaJock,num+1);
                                        cerrarVentana();
                                        controlJockeys.iniciar(num+1);
                                    }
                                    else {
                                        carreraGenerica.agregarJockey(jockeyGenerico);
                                        frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                        ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                                        cerrarVentana();
                                        if(carreraGenerica.getIndiceC()==0){
                                            controlCrearCar.iniciarB2(false);
                                        }else{
                                            controlCrearCar.iniciarB3(true);
                                        }
                                    } 
                                }
                                else if(editarJockeysYCarrera == true){
                                    if(Ultimo==false){
                                        carreraGenerica.agregarJockey(jockeyGenerico);
                                        frmJockeysCaballos vistaJock = new frmJockeysCaballos();
                                        ControladorJockeysCaballos controlJockeys = new ControladorJockeysCaballos(vistaJock,num+1);
                                        cerrarVentana();
                                        controlJockeys.iniciar(num+1);
                                    }
                                    else {
                                        carreraGenerica.agregarJockey(jockeyGenerico);
                                        frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                        ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                                        cerrarVentana();
                                        if(carreraGenerica.getIndiceC()==0){
                                            controlCrearCar.iniciarEditarB2(false);
                                        }else{
                                            controlCrearCar.iniciarEditarB3(true);
                                        }
                                    }
                                }
                            }
                            else if(editarJockeys==true){
                                if(editarJockeysYCarrera==false){
                                    carreraGenerica.eliminarJockey(jockeyAuxiliar);
                                    carreraGenerica.agregarJockey(jockeyGenerico);
                                    jockeyAuxiliar = new Jockey();
                                    if(Ultimo==false){
                                        frmJockeysCaballos vistaJock = new frmJockeysCaballos();
                                        ControladorJockeysCaballos controlJockeys = new ControladorJockeysCaballos(vistaJock,num+1);
                                        cerrarVentana();
                                        controlJockeys.iniciarEditar(num+1);
                                    }
                                    else {
                                        carreraGenerica.agregarJockey(jockeyGenerico);
                                        frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                        ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                                        cerrarVentana();
                                        if(carreraGenerica.getIndiceC()==0){
                                            controlCrearCar.iniciarB2(true);
                                        }else{
                                            controlCrearCar.iniciarB3(true);
                                        }
                                    }
                                }
                                else if(editarJockeysYCarrera==true){
                                    carreraGenerica.eliminarJockey(jockeyAuxiliar);
                                    carreraGenerica.agregarJockey(jockeyGenerico);
                                    jockeyAuxiliar = new Jockey();
                                    if(Ultimo==false){
                                        frmJockeysCaballos vistaJock = new frmJockeysCaballos();
                                        ControladorJockeysCaballos controlJockeys = new ControladorJockeysCaballos(vistaJock,num+1);
                                        cerrarVentana();
                                        controlJockeys.iniciarEditar(num+1);
                                    }
                                    else {
                                        carreraGenerica.agregarJockey(jockeyGenerico);
                                        frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                                        ControladorCrearCar controlCrearCar = new ControladorCrearCar(vistaCrearCar);
                                        cerrarVentana();
                                        if(carreraGenerica.getIndiceC()==0){
                                            controlCrearCar.iniciarEditarB2(true);
                                        }else{
                                            controlCrearCar.iniciarEditarB3(true);
                                        }
                                    }
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
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(i));
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = false;
        this.editarJockeys = false;
    }
    
    public void iniciarEditar(int i) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblTitulo.setText("EDITAR JOCKEY Nro");
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(i));
        vistaJockeyCaballo.btnSalir.setVisible(false);
        vistaJockeyCaballo.btnAgregar.setText("GUARDAR");
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = false;
        this.editarJockeys = true;
    }
    public void iniciarEditReg(int i) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(i));
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = true;
        this.editarJockeys = false;
    }
    public void iniciarEditRegJock(int i) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblTitulo.setText("EDITAR JOCKEY Nro");
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(i));
        vistaJockeyCaballo.btnSalir.setVisible(false);
        vistaJockeyCaballo.btnAgregar.setText("GUARDAR");
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = true;
        this.editarJockeys = true;
    }
 
    public void iniciarUlt(int j) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(j));
        vistaJockeyCaballo.btnCancelar.setText("VOLVER");
        vistaJockeyCaballo.btnAgregar.setText("TERMINAR");
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = false;
        this.editarJockeys = false;
    }
    public void iniciarEditarUlt(int j) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblTitulo.setText("EDITAR JOCKEY Nro");
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(j));
        vistaJockeyCaballo.btnCancelar.setText("VOLVER");
        vistaJockeyCaballo.btnSalir.setVisible(false);
        vistaJockeyCaballo.btnAgregar.setText("TERMINAR GUARDADO");
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = false;
        this.editarJockeys = true;
    }
    
    public void iniciarEditUltReg(int j) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(j));
        vistaJockeyCaballo.btnCancelar.setText("VOLVER");
        vistaJockeyCaballo.btnAgregar.setText("TERMINAR");
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = true;
        this.editarJockeys = false;
    }
    public void iniciarEditUltRegJock(int j) {
        setDatos(jockeyGenerico);
        vistaJockeyCaballo.setLocationRelativeTo(null);
        vistaJockeyCaballo.lblTitulo.setText("EDITAR JOCKEY Nro");
        vistaJockeyCaballo.lblNumero.setText(String.valueOf(j));
        vistaJockeyCaballo.btnCancelar.setText("VOLVER");
        vistaJockeyCaballo.btnSalir.setVisible(false);
        vistaJockeyCaballo.btnAgregar.setText("TERMINAR GUARDADO");
        vistaJockeyCaballo.setVisible(true);
        this.editarJockeysYCarrera = true;
        this.editarJockeys = true;
    }
    
    public void setDatos(Jockey j){
        vistaJockeyCaballo.txtNombreJ.setText(j.getNombre());
        vistaJockeyCaballo.txtEdadJ.setText(Integer.toString(j.getEdad()));
        /*vistaJockeyCaballo.txtNombreC.setName(j.getCaballo().getNombre_cab());
        vistaJockeyCaballo.txtPesoC.setName(Double.toString(j.getCaballo().getPeso()));
        vistaJockeyCaballo.txtEdadC.setName(Integer.toString(j.getCaballo().getEdad()));
        vistaJockeyCaballo.txtRazaC.setName(j.getCaballo().getRaza());*/
        //Agregar
    }
    public void limpiarVentana(){
        vistaJockeyCaballo.txtNombreJ.setText("");
        vistaJockeyCaballo.txtEdadJ.setText("");
        /*vistaJockeyCaballo.txtNombreC.setText("");
        vistaJockeyCaballo.txtPesoC.setText("");
        vistaJockeyCaballo.txtEdadC.setText("");
        vistaJockeyCaballo.txtRazaC.setText("");*/
    }
   /* public void guardarDatos(Jockey j){
        try{
            j.setNombre(vistaJockeyCaballo.txtNombreJ.getText());
            j.setEdad(Integer.parseInt(vistaJockeyCaballo.txtEdadJ.getText()));
            Caballo cab = new Caballo(vistaJockeyCaballo.txtNombreC.getText(), Double.valueOf(vistaJockeyCaballo.txtPesoC.getText()), 
                    Integer.valueOf(vistaJockeyCaballo.txtEdadC.getText()),vistaJockeyCaballo.txtRazaC.getText());
            j.setCaballo(cab);
        }catch(Exception e){
            Caballo cab = new Caballo(vistaJockeyCaballo.txtNombreC.getText(), Double.valueOf(vistaJockeyCaballo.txtPesoC.getText()), 
                    Integer.valueOf(vistaJockeyCaballo.txtEdadC.getText()),vistaJockeyCaballo.txtRazaC.getText());
            j.setCaballo(cab);
        }
    }*/
    
    public boolean nombresyedadCorrectos(){
        boolean result = false;
        //boolean existeNombre = false;
        //boolean limiedad = false;
        boolean limiedad2 = false;
        try{
            /*String Nombre = vistaJockeyCaballo.txtNombreC.getText();
            int EdadC = Integer.valueOf(vistaJockeyCaballo.txtEdadC.getText());*/
            int EdadJ = Integer.valueOf(vistaJockeyCaballo.txtEdadJ.getText());
            /*for(int i=0; i<sistemA.getJockeys().getIndiceJock(); i++){
                if(sistemA.getJockeys().getJockeys()[i].getCaballo().getNombre_cab().equals(Nombre)){
                    existeNombre = true;
                }
            }*/
            /*if(EdadC > 7){
                limiedad = true;
            }*/
            if(EdadJ < 18  && EdadJ > 60){
                limiedad2 = true;
            }
            if(/*(existeNombre==false) && (limiedad == false) &&*/ (limiedad2 == false)){
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
        if (this.vistaJockeyCaballo.txtNombreJ.getText().length()!=0 &&
            this.vistaJockeyCaballo.txtEdadJ.getText().length()!=0)
            /*this.vistaJockeyCaballo.txtNombreC.getText().length()!=0 &&
            this.vistaJockeyCaballo.txtPesoC.getText().length()!=0 &&
            this.vistaJockeyCaballo.txtEdadC.getText().length()!=0 &&
            this.vistaJockeyCaballo.txtRazaC.getText().length()!=0)*/{
            result = true;
        }
        return result;
    }
    public void cerrarVentana() {
        this.vistaJockeyCaballo.dispose();
    }
}
