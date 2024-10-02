/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024.planetasYguerrero;

/**
 *
 * @author fer
 */
public class Guerrero {

    protected String tipo;
    protected double factorDeMuerte;
    protected int espacio;

    public Guerrero(String tipo, double factorDeMuerte, int espacio) {
        this.tipo = tipo;
        this.factorDeMuerte = factorDeMuerte;

        this.espacio = espacio;

    }//finConstructor

    public String getTipo() {
        return tipo;
    }

    public double getFactorDeMuerte() {
        return factorDeMuerte;

    }

    public int getEspacio() {
        return espacio;
    }
}//fin clase guerrero