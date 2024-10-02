 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.planetasYguerrero;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.Posicion;
import com.mycompany.primerproyecto2024.constructores.Constructor;
import com.mycompany.primerproyecto2024.constructores.Ingeniero;

/**
 *
 * @author fer
 */
public class PlanetaTierra extends Planeta {
    public PlanetaTierra(String nombre, Posicion posicion, String dueño) {
        super(nombre, 0.8, 200, new Ingeniero(), posicion, dueño);
    }

   // Producción de recursos específica para Planeta Tierra
    @Override
    public void producirRecursos() {
        aumentarMonedas(100);  // El Planeta Tierra produce más monedas por turno
        if (numGuerreros < guerreros.length) {
            colocarGuerrero(new Terradiente("Terradiente", 1.5, 1));
        }
    }
}