/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.constructores;

import com.mycompany.primerproyecto2024.naves.Nave;
import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.naves.Helios;

/**
 *
 * @author fer
 */
public class Obrero extends Constructor {

    public Obrero() {
        super("Obrero", 3, 50, 40); // Tarda 3 turnos en construir una nave Helios
    }

    public void construirNave(Planeta planeta) {
        if (planeta.getMonedas() >= 100) {  // Verifica si el planeta tiene suficiente dinero
            planeta.reducirMonedas(100);
            planeta.colocarNave(new Helios());  // Crea y coloca una nave Helios en el planeta
            System.out.println("Obrero ha construido una nave Helios en el planeta " + planeta.getNombre());
        } else {
            System.out.println("El planeta " + planeta.getNombre() + " no tiene suficientes recursos para construir una nave.");
        }
    }
}
