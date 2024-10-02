/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.planetasYguerrero;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.Posicion;
import com.mycompany.primerproyecto2024.constructores.Obrero;

/**
 *
 * @author fer
 */
public class PlanetaFuego extends Planeta {
    public PlanetaFuego(String nombre, Posicion posicion, String dueño) {
        super(nombre, 0.7, 220, new Obrero(), posicion, dueño);
    }

    // Producción de recursos específica para Planeta Fuego
    @Override
    public void producirRecursos() {
        aumentarMonedas(120);  // Produce más monedas y guerreros ofensivos
        if (numGuerreros < guerreros.length) {
            colocarGuerrero(new Ignis("Ignis", 1.75, 2));
        }
    }
}