/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024;

import com.mycompany.primerproyecto2024.Planeta;
import com.mycompany.primerproyecto2024.Posicion;
import com.mycompany.primerproyecto2024.constructores.Obrero;
import com.mycompany.primerproyecto2024.constructores.Operador;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class Mapa {

    private Planeta[] planetas;  // Arreglo de planetas en el mapa
    private int filas;
    private int columnas;
    private int numPlanetas;  // Contador de planetas

    public Mapa(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.planetas = new Planeta[50];  // Limitar a 50 planetas en el mapa
        this.numPlanetas = 0;
    }

    // Método para colocar un planeta en el mapa
    public void colocarPlaneta(Planeta planeta) {
        if (numPlanetas >= planetas.length) {
            System.out.println("No se pueden colocar más planetas.");
            return;
        }
        Posicion pos = planeta.getPosicion();
        if (obtenerPlaneta(pos) == null) {
            planetas[numPlanetas++] = planeta;  // Añadir el planeta y aumentar el contador
            System.out.println("Planeta " + planeta.getNombre() + " colocado en (" + pos.getX() + ", " + pos.getY() + ")");
        } else {
            System.out.println("La posición (" + pos.getX() + ", " + pos.getY() + ") ya está ocupada.");
        }
    }

    // Obtener un planeta por su posición
    public Planeta obtenerPlaneta(Posicion posicion) {
        for (int i = 0; i < numPlanetas; i++) {
            if (planetas[i].getPosicion().getX() == posicion.getX() && planetas[i].getPosicion().getY() == posicion.getY()) {
                return planetas[i];
            }
        }
        return null;
    }

    // Método para obtener el número total de planetas en el mapa
    public int getNumPlanetas() {
        return numPlanetas;
    }

    // Método para obtener un planeta por índice
    public Planeta getPlaneta(int index) {
        if (index >= 0 && index < numPlanetas) {
            return planetas[index];
        }
        return null;
    }

    // Método para calcular la distancia entre dos planetas
    public double calcularDistancia(Planeta p1, Planeta p2) {
        if (p1 == null || p2 == null) {
            System.out.println("Uno de los planetas es nulo.");
            return 0;
        }
        Posicion pos1 = p1.getPosicion();
        Posicion pos2 = p2.getPosicion();
        return Math.sqrt(Math.pow(pos2.getX() - pos1.getX(), 2) + Math.pow(pos2.getY() - pos1.getY(), 2));
    }

    // Mostrar el mapa visualmente con más detalles
   public void mostrarMapa() {
    String[][] tablero = new String[filas][columnas];
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            tablero[i][j] = "[   ]";  // Celda vacía
        }
    }

    // Colocar los planetas en el tablero
    for (int i = 0; i < numPlanetas; i++) {
        Planeta planeta = planetas[i];
        int x = planeta.getPosicion().getX();
        int y = planeta.getPosicion().getY();

        String dueño = planeta.getDueño().equals("Neutral") ? "N" : planeta.getDueño().substring(0, 1);
        tablero[x][y] = "[" + planeta.getNombre().charAt(0) + "-" + dueño + "]";
    }

    // Mostrar el mapa con detalles de los planetas
    System.out.println("MAPA DE KONQUEST:");
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            System.out.print(tablero[i][j] + "  ");
        }
        System.out.println();
    }
}


    // Obtener el número de filas del mapa
    public int getFilas() {
        return filas;
    }

    // Obtener el número de columnas del mapa
    public int getColumnas() {
        return columnas;
    }
}//finmapa