
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
public class ControladorApuesta {
    private frmApuesta vistaVerApuesta;
    
    public ControladorApuesta(frmApuesta vistaVerApuesta){
        this.vistaVerApuesta = vistaVerApuesta;
        
        this.vistaVerApuesta.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.vistaVerApuesta.btnVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                    carreraGenerica = new Carrera();
                    frmInicio vistaInicio = new frmInicio();
                    ControladorInicio controlInicio = new ControladorInicio(vistaInicio);
                    vistaVerApuesta.dispose();
                    controlInicio.iniciar();

                }            
        });
        
        this.vistaVerApuesta.btnEditarCar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                frmCrearCarrera vistaCrearCar = new frmCrearCarrera();
                ControladorCrearCar controlCrearCar= new ControladorCrearCar(vistaCrearCar);
                carreraGenerica = new Carrera();
                carreraGenerica = carreraActiva;
                vistaVerApuesta.dispose();
                controlCrearCar.iniciarEditar();
            }
        });
    }
    
    public void iniciar() {
        vistaVerApuesta.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        vistaVerApuesta.setVisible(true);
    }
}
