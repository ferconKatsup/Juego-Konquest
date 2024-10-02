/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024;

import com.mycompany.primerproyecto2024.constructores.Constructor;

/**
 *
 * @author fer
 */
class Jugador {

    private String nombre;
    private Planeta planetaInicial;
    private Planeta[] planetas;
    private int numPlanetas;
    private Constructor[] constructores;
    private int numConstructores;

    public Jugador(String nombre, Planeta planetaInicial) {
        this.nombre = nombre;
        this.planetaInicial = planetaInicial;
        this.planetas = new Planeta[10];  // El jugador puede tener un máximo de 10 planetas
        this.planetas[0] = planetaInicial;  // El planeta inicial se agrega automáticamente
        this.numPlanetas = 1;  // El jugador empieza con un planeta
        this.constructores = new Constructor[10];
        this.numConstructores = 0;
    }

     public String getNombre() {
        return nombre;
    }

    public Planeta getPlanetaInicial() {
        return planetaInicial;
    }

    // Método para devolver el arreglo de planetas
    public Planeta[] getPlanetas() {
        return planetas;
    }

    // Método para agregar un nuevo planeta al jugador
    public void agregarPlaneta(Planeta planeta) {
        if (numPlanetas < planetas.length) {
            planetas[numPlanetas++] = planeta;
            System.out.println("El planeta " + planeta.getNombre() + " ha sido conquistado por " + nombre);
        } else {
            System.out.println("No puedes controlar más de " + planetas.length + " planetas.");
        }
    }

  
    public void agregarConstructor(Constructor constructor){
        if (numConstructores < constructores.length) {
            constructores[numConstructores++] = constructor;
            System.out.println("Constructor " + constructor.getTipo() + " agregado.");
        } else {
            System.out.println("No puedes tener más de " + constructores.length + " constructores.");
        }
    }

    public void vender(String tipoConstructor, int precioVenta) {
        for (int i = 0; i < numConstructores; i++) {
            if (constructores[i].getTipo().equals(tipoConstructor)) {
                // Vender el constructor, desplazando los elementos del arreglo
                for (int j = i; j < numConstructores - 1; j++) {
                    constructores[j] = constructores[j + 1];
                }
                constructores[--numConstructores] = null; // Elimina la referencia
                planetaInicial.aumentarMonedas(precioVenta); // Aumenta el dinero del jugador
                System.out.println("Has vendido un " + tipoConstructor + " por " + precioVenta + " estelares.");
                return;
            }
        }
        System.out.println("No tienes ningún " + tipoConstructor + " para vender.");
    }

    public Constructor[] getConstructores() {
        return constructores; // Devuelve el arreglo de constructores
    }

}// fin clase jugador 
