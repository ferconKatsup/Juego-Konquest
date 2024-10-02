/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.planetasYguerrero;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.Posicion;
import com.mycompany.primerproyecto2024.constructores.Tecnico;

/**
 *
 * @author fer
 */
public class PlanetaBiotara extends Planeta {

    public PlanetaBiotara(String nombre, Posicion posicion, String dueño) {
        super(nombre, 0.85, 150, new Tecnico(), posicion, dueño);
    }

    // Producción de recursos específica para Planeta Biotara
    @Override
    public void producirRecursos() {
        aumentarMonedas(90);  // Producen recursos a un ritmo moderado
        if (numGuerreros < guerreros.length) {
            colocarGuerrero(new Rooters("Rooters", 1.85, 3));
        }
    }
}
