/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.primerproyecto2024;

import com.mycompany.primerproyecto2024.constructores.Obrero;
import com.mycompany.primerproyecto2024.constructores.Operador;
import com.mycompany.primerproyecto2024.planetasYguerrero.PlanetaAgua;
import com.mycompany.primerproyecto2024.planetasYguerrero.PlanetaBiotara;
import com.mycompany.primerproyecto2024.planetasYguerrero.PlanetaFuego;
import com.mycompany.primerproyecto2024.planetasYguerrero.PlanetaRadioactivo;
import com.mycompany.primerproyecto2024.planetasYguerrero.PlanetaTierra;
import java.util.Scanner;
import javax.xml.transform.Source;

/**
 *
 * @author fer
 */

public class PrimerProyecto2024 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a Konquest!");
        System.out.println("1. Diseñar un nuevo mapa");
        System.out.println("2. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();

        if (opcion == 1) {
            // Crear mapa
            System.out.print("Ingrese el número de filas para el mapa: ");
            int filas = sc.nextInt();
            System.out.print("Ingrese el número de columnas para el mapa: ");
            int columnas = sc.nextInt();

            Mapa mapa = new Mapa(filas, columnas);

            sc.nextLine();  // Limpiar buffer
            System.out.print("Ingrese el nombre del Jugador 1: ");
            String nombre1 = sc.nextLine();
            System.out.print("Ingrese el nombre del Jugador 2: ");
            String nombre2 = sc.nextLine();

            // Permitir que los jugadores seleccionen el tipo de planeta inicial
            Planeta planeta1 = seleccionarTipoDePlaneta(sc, nombre1, new Posicion(0, 0));
            Planeta planeta2 = seleccionarTipoDePlaneta(sc, nombre2, new Posicion(filas - 1, columnas - 1));

            Jugador jugador1 = new Jugador(nombre1, planeta1);
            Jugador jugador2 = new Jugador(nombre2, planeta2);

            mapa.colocarPlaneta(planeta1);
            mapa.colocarPlaneta(planeta2);

            // Generar planetas neutrales
            System.out.print("Ingrese el número de planetas neutrales: ");
            int numNeutrales = sc.nextInt();
            generarPlanetasNeutrales(mapa, numNeutrales);

            MenuPrincipal juego = new MenuPrincipal(jugador1, jugador2, mapa);
            juego.primerJuego();
        } else {
            System.out.println("¡Gracias por jugar Konquest!");
        }
    }

    // Método para que los jugadores seleccionen el tipo de planeta inicial
    public static Planeta seleccionarTipoDePlaneta(Scanner sc, String dueño, Posicion posicion) {
        System.out.println("Seleccione el tipo de planeta para " + dueño + ": ");
        System.out.println("1. Planeta Tierra");
        System.out.println("2. Planeta Agua");
        System.out.println("3. Planeta Fuego");
        System.out.println("4. Planeta Biotara");
        System.out.println("5. Planeta Radioactivo");
        System.out.print("Ingrese una opción: ");
        int tipo = sc.nextInt();

        switch (tipo) {
            case 1:
                return new PlanetaTierra("Tierra", posicion, dueño);
            case 2:
                return new PlanetaAgua("Agua", posicion, dueño);
            case 3:
                return new PlanetaFuego("Fuego", posicion, dueño);
            case 4:
                return new PlanetaBiotara("Biotara", posicion, dueño);
            case 5:
                return new PlanetaRadioactivo("Radioactivo", posicion, dueño);
            default:
                System.out.println("Opción no válida. Seleccionando Planeta Tierra por defecto.");
                return new PlanetaTierra("Tierra", posicion, dueño);
        }
    }

    // Método para generar planetas neutrales aleatorios con tipos de planetas
    public static void generarPlanetasNeutrales(Mapa mapa, int numNeutrales) {
        for (int i = 0; i < numNeutrales; i++) {
            Posicion posicion;
            do {
                int fila = (int) (Math.random() * mapa.getFilas());
                int columna = (int) (Math.random() * mapa.getColumnas());
                posicion = new Posicion(fila, columna);
            } while (mapa.obtenerPlaneta(posicion) != null);

            // Seleccionar tipo de planeta neutral de manera aleatoria
            int tipo = (int) (Math.random() * 5) + 1;
            Planeta planetaNeutral;
            switch (tipo) {
                case 1:
                    planetaNeutral = new PlanetaTierra("Neutral Tierra" + (i + 1), posicion, "Neutral");
                    break;
                case 2:
                    planetaNeutral = new PlanetaAgua("Neutral Agua" + (i + 1), posicion, "Neutral");
                    break;
                case 3:
                    planetaNeutral = new PlanetaFuego("Neutral Fuego" + (i + 1), posicion, "Neutral");
                    break;
                case 4:
                    planetaNeutral = new PlanetaBiotara("Neutral Biotara" + (i + 1), posicion, "Neutral");
                    break;
                case 5:
                    planetaNeutral = new PlanetaRadioactivo("Neutral Radioactivo" + (i + 1), posicion, "Neutral");
                    break;
                default:
                    planetaNeutral = new PlanetaTierra("Neutral Tierra" + (i + 1), posicion, "Neutral");
            }

            mapa.colocarPlaneta(planetaNeutral);
        }
    }
}