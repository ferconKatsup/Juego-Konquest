/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.constructores;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.naves.Odisea;

/**
 *
 * @author fer
 */
public class Ingeniero extends Constructor {
    
    public Ingeniero() {
        super("Ingeniero", 1, 300, 200);  // Tarda 1 turno en construir una nave Odisea
    }


    public void construirNave(Planeta planeta) {
        if (planeta.getMonedas() >= 700) {  // Ejemplo: nave Odisea cuesta 700 monedas
            planeta.reducirMonedas(700);
            System.out.println("El ingeniero ha comenzado a construir una nave Odisea en el planeta " + planeta.getNombre());
            planeta.colocarNave(new Odisea()); 
            System.out.println("El ingeniero ha construido una nave Odisea en el planeta " + planeta.getNombre());
        } else {
            System.out.println("El planeta " + planeta.getNombre() + " no tiene suficientes recursos para construir una nave Odisea.");
        }
    }
}
