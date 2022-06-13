/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Programa;

import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class Carrera {
    int numero_car;
    String nombre_jock;
    String aux_nombreCab;
    Double distancia;
    Double tiempo_reg;
    
    Caballo cab;
    ArrayList<Caballo>listcaballos;
    
    public void regCaballo(String nombre_cab, Double peso, int edad, String raza){
        cab=new Caballo(nombre_cab, peso, edad, raza);
        listcaballos.add(cab);
    }
    public void regJockey(){
        
    }
    
    public Carrera(String nombre_jock, String aux_nombreCab, Double distancia, Double tiempo_reg) {
        for (int i=0;i<=listcaballos.size();i++) {
            if (listcaballos.get(i).getNombre_cab()==aux_nombreCab) {
                this.nombre_jock = nombre_jock;
                this.aux_nombreCab = aux_nombreCab;
                this.distancia = distancia;
                this.tiempo_reg = tiempo_reg;
            }
        }
    }
    
}

