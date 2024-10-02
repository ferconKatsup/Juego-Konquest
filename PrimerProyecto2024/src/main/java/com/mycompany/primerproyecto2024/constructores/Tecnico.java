/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.constructores;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.naves.Nebulon;

/**
 *
 * @author fer
 */
public class Tecnico extends Constructor{
    
    public Tecnico() {
        super("Técnico", 1, 250, 175);  // Tarda 1 turno en construir una nave Nebulon
    }

 
    public void construirNave(Planeta planeta) {
        if (planeta.getMonedas() >= 500) {  // Ejemplo: nave Nebulon cuesta 500 monedas
            planeta.reducirMonedas(500);
            System.out.println("El técnico ha comenzado a construir una nave Nebulon en el planeta " + planeta.getNombre());
            planeta.colocarNave(new Nebulon()); 
            System.out.println("El técnico ha construido una nave Nebulon en el planeta " + planeta.getNombre());
        } else {
            System.out.println("El planeta " + planeta.getNombre() + " no tiene suficientes recursos para construir una nave Nebulon.");
        }
    }
}
