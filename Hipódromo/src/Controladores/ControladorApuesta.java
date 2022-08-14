
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
public class ControladorApuesta extends Thread{
    private frmApuesta vistaVerApuesta;
    private JLabel ticket;
    
    public ControladorApuesta(frmApuesta vistaVerApuesta , JLabel ticket){
        this.vistaVerApuesta = vistaVerApuesta;
        this.ticket = ticket;
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
                    sistemA.guardar();
                    vistaVerApuesta.dispose();
                    controlInicio.iniciar();

                }            
        });
        
        this.vistaVerApuesta.btnVerCarrera.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String part = "";
                for(int i=0; i<carreraActiva.getIndiceJ(); i++){
                    if(i==0){
                        part += "\n    Participantes:";
                    }
                    part += "\n      Participante " + (i+1) + ":";
                    part += "\n            Nombre:  " + carreraActiva.getJockeys()[i].getNombre() +
                            "\n            Edad:  " + carreraActiva.getJockeys()[i].getNombre() +
                            "\n            Caballo:  " +
                            "\n                 Nombre :  " + carreraActiva.getJockeys()[i].getCaballo().getNombre_cab() +
                            "\n                 Edad :  " + carreraActiva.getJockeys()[i].getCaballo().getEdad() +
                            "\n                 Peso :  " + carreraActiva.getJockeys()[i].getCaballo().getPeso() +
                            "\n                 Raza :  " + carreraActiva.getJockeys()[i].getCaballo().getRaza();
                }
                JOptionPane.showMessageDialog(null, "DATOS DE LA CARRERA:" + 
                        "\n    ID:  " + carreraActiva.getNumero_car() +
                        "\n    Nro participantes:  " + carreraActiva.getNumeroPart() +
                        "\n    Distancia:  " + carreraActiva.getDistancia() +
                        "\n" + part);

                }            
        });
        
        this.vistaVerApuesta.btnEditarCar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                carreraGenerica = new Carrera();
                frmTablaCarreras vistaTabCar = new frmTablaCarreras();
                ControladorTablaCar controlTabCar = new ControladorTablaCar(vistaTabCar);
                carreraGenerica = new Carrera();
                carreraGenerica = carreraActiva;
                vistaVerApuesta.dispose();
                controlTabCar.iniciarPart();
            }
        });
        
        this.vistaVerApuesta.btnApostar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                carreraGenerica = new Carrera();
                frmApostar vistaApostar = new frmApostar();
                ControladorApostar controlApostar = new ControladorApostar(vistaApostar);
                carreraGenerica = new Carrera();
                carreraGenerica = carreraActiva;
                vistaVerApuesta.dispose();
                controlApostar.iniciar();
            }
        });
        this.vistaVerApuesta.btnEmpezar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                vistaVerApuesta.lblJin1.setLocation(0,vistaVerApuesta.lblJin1.getLocation().y);
                vistaVerApuesta.lblJin2.setLocation(0,vistaVerApuesta.lblJin2.getLocation().y);
                vistaVerApuesta.lblJin3.setLocation(0,vistaVerApuesta.lblJin3.getLocation().y);
                vistaVerApuesta.lblJin4.setLocation(0,vistaVerApuesta.lblJin4.getLocation().y);
                vistaVerApuesta.lblJin5.setLocation(0,vistaVerApuesta.lblJin5.getLocation().y);
                vistaVerApuesta.lblJin6.setLocation(0,vistaVerApuesta.lblJin6.getLocation().y);
                
                ControladorApuesta jine1  = new ControladorApuesta(vistaVerApuesta,ticket);
                ControladorApuesta jine2  = new ControladorApuesta(vistaVerApuesta,ticket);
                ControladorApuesta jine3  = new ControladorApuesta(vistaVerApuesta,ticket);
                ControladorApuesta jine4  = new ControladorApuesta(vistaVerApuesta,ticket);
                ControladorApuesta jine5  = new ControladorApuesta(vistaVerApuesta,ticket);
                ControladorApuesta jine6  = new ControladorApuesta(vistaVerApuesta,ticket);
                
                jine1.start();
                jine2.start();
                jine3.start();
                jine4.start();
                jine5.start();
                jine6.start();
            }
        });
    }
    
    public void iniciar() {
        vistaVerApuesta.setLocationRelativeTo(null);
        carreraGenerica = new Carrera();
        apuestaGenerica = new NodoApuesta();
        int id = carreraActiva.getNumero_car();
        vistaVerApuesta.lblid.setText(String.valueOf(id));
        vistaVerApuesta.setVisible(true);
    }
    
    @Override
    public void run(){
        int jin1=0,jin2=0,jin3=0,jin4=0,jin5=0,jin6=0;
        while(true){
            try{
                sleep((int)(Math.random()*1000));
                jin1=vistaVerApuesta.lblJin1.getLocation().x;
                jin2=vistaVerApuesta.lblJin2.getLocation().x;
                jin3=vistaVerApuesta.lblJin3.getLocation().x;
                jin4=vistaVerApuesta.lblJin4.getLocation().x;
                jin5=vistaVerApuesta.lblJin5.getLocation().x;
                jin6=vistaVerApuesta.lblJin6.getLocation().x;
                
                if(jin1<vistaVerApuesta.pnMeta.getLocation().x-125 && jin2<vistaVerApuesta.pnMeta.getLocation().x-125 &&
                        jin3<vistaVerApuesta.pnMeta.getLocation().x-125 && jin4<vistaVerApuesta.pnMeta.getLocation().x-125 &&
                        jin5<vistaVerApuesta.pnMeta.getLocation().x-125 && jin6<vistaVerApuesta.pnMeta.getLocation().x-125)
                {
                    ticket.setLocation(ticket.getLocation().x+10,ticket.getLocation().y);
                    vistaVerApuesta.repaint();
                }else{
                    break;
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
            
            if(ticket.getLocation().x>=vistaVerApuesta.pnMeta.getLocation().x-125){
                if(jin1>jin2 &&jin1>jin3 &&jin1>jin4 && jin1>jin5 && jin1>jin6){                
                    JOptionPane.showMessageDialog(null, "Gana el 1er jinete");
                }else if(jin2>jin1 &&jin1>jin3 &&jin1>jin4 && jin1>jin5 && jin1>jin6){
                    JOptionPane.showMessageDialog(null, "Gana el 2do jinete");
                }else if(jin3>jin1 &&jin3>jin2 &&jin3>jin4 && jin3>jin5 && jin3>jin6){
                    JOptionPane.showMessageDialog(null, "Gana el 3er jinete");
                }else if(jin4>jin1 &&jin4>jin2 &&jin4>jin3 && jin4>jin5 && jin4>jin6){
                    JOptionPane.showMessageDialog(null, "Gana el 4to jinete");
                }else if(jin5>jin1 &&jin5>jin2 &&jin5>jin4 && jin5>jin3 && jin5>jin6){
                    JOptionPane.showMessageDialog(null, "Gana el 5to jinete");
                }else if(jin6>jin1 &&jin6>jin2 &&jin6>jin4 && jin6>jin3 && jin6>jin5){
                    JOptionPane.showMessageDialog(null, "Gana el 6to jinete");
                }else {
                    JOptionPane.showMessageDialog(null, "Empate");
                }
                
            }
        
        }
    }
    
    
}
