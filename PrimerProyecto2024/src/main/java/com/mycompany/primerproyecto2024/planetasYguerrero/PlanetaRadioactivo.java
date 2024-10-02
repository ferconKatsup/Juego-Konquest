/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.planetasYguerrero;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.Posicion;
import com.mycompany.primerproyecto2024.constructores.Ingeniero;

/**
 *
 * @author fer
 */
public class PlanetaRadioactivo extends Planeta {
    public PlanetaRadioactivo(String nombre, Posicion posicion, String dueño) {
        super(nombre, 0.95, 130, new Ingeniero(), posicion, dueño);
    }

    // Producción de recursos específica para Planeta Radioactivo
    @Override
    public void producirRecursos() {
        aumentarMonedas(70);  // Produce menos monedas, pero guerreros más fuertes
        if (numGuerreros < guerreros.length) {
            colocarGuerrero(new Rdonix("Rdonix", 1.90, 3));
        }
    }
    }