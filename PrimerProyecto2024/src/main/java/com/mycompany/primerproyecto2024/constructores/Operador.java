/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.constructores;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.naves.GalaxiaPrime;
import com.mycompany.primerproyecto2024.naves.Nave;

/**
 *
 * @author fer
 */
public class Operador extends Constructor {

    public Operador() {
        super("Operador", 2, 100, 70);  // Tarda 2 turnos en construir una nave Galaxia Prime
    }

    public void construirNave(Planeta planeta) {
        if (planeta.getMonedas() >= 200) {
            planeta.reducirMonedas(200);
            System.out.println("Operador ha construido una nave Galaxia Prime en el planeta " + planeta.getNombre());
        } else {
            System.out.println("No hay suficientes recursos para construir una nave en el planeta " + planeta.getNombre());
        }
    }
}
