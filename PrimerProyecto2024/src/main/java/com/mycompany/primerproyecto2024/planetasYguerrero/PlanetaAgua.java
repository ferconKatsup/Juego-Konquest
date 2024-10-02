/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.planetasYguerrero;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.Posicion;
import com.mycompany.primerproyecto2024.constructores.Operador;

/**
 *
 * @author fer
 */
public class PlanetaAgua extends Planeta {
    public PlanetaAgua(String nombre, Posicion posicion, String dueño) {
        super(nombre, 0.9, 180, new Operador(), posicion, dueño);
    }

    // Producción de recursos específica para Planeta Agua
    @Override
    public void producirRecursos() {
        aumentarMonedas(80);  // Produce menos monedas, pero tiene guerreros especializados
        if (numGuerreros < guerreros.length) {
            colocarGuerrero(new Aquaris("Aquaris", 1.6, 1));
        }
    }
    }