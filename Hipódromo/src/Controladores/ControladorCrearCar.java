
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
}
