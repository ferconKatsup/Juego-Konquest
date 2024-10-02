/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024;

import com.mycompany.primerproyecto2024.constructores.Constructor;
import com.mycompany.primerproyecto2024.constructores.Ingeniero;
import com.mycompany.primerproyecto2024.constructores.Obrero;
import com.mycompany.primerproyecto2024.constructores.Operador;
import com.mycompany.primerproyecto2024.constructores.Tecnico;
import com.mycompany.primerproyecto2024.naves.Nave;
import java.util.Scanner;

/**
 *
 * @author fer
 */
import java.util.Scanner;

public class Tienda {
    private static final int PRECIO_OBRERO = 50;
    private static final int PRECIO_OPERADOR = 100;
    private static final int PRECIO_TECNICO = 250;
    private static final int PRECIO_INGENIERO = 300;

    private Scanner scanner;

    public Tienda() {
        scanner = new Scanner(System.in);
    }

    public void mostrarMenu(Jugador jugador) {
        System.out.println("---- TIENDA ----");
        System.out.println("1. Comprar");
        System.out.println("2. Vender");
        System.out.println("3. Salir de la tienda");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1:
                comprar(jugador);
                break;
            case 2:
                vender(jugador);
                break;
            case 3:
                System.out.println("Saliendo de la tienda.");
                break;
            default:
                System.out.println("Opción no válida. Intenta de nuevo.");
                mostrarMenu(jugador);
                break;
        }
    }

    private void comprar(Jugador jugador) {
        System.out.println("Seleccione el tipo de constructor a comprar:");
        System.out.println("1. Obrero - Precio: " + PRECIO_OBRERO + " estelares");
        System.out.println("2. Operador - Precio: " + PRECIO_OPERADOR + " estelares");
        System.out.println("3. Técnico - Precio: " + PRECIO_TECNICO + " estelares");
        System.out.println("4. Ingeniero - Precio: " + PRECIO_INGENIERO + " estelares");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1:
                procesarCompra(jugador, new Obrero(), PRECIO_OBRERO);
                break;
            case 2:
                procesarCompra(jugador, new Operador(), PRECIO_OPERADOR);
                break;
            case 3:
                procesarCompra(jugador, new Tecnico(), PRECIO_TECNICO);
                break;
            case 4:
                procesarCompra(jugador, new Ingeniero(), PRECIO_INGENIERO);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void procesarCompra(Jugador jugador, Constructor constructor, int precio) {
        if (jugador.getPlanetaInicial().getMonedas() >= precio) {
            jugador.getPlanetaInicial().reducirMonedas(precio);
            jugador.agregarConstructor(constructor);  // Agregar el constructor al jugador
            System.out.println("Has comprado un " + constructor.getTipo() + ".");
        } else {
            System.out.println("No tienes suficiente dinero.");
        }
    }

    private void vender(Jugador jugador) {
        System.out.println("Seleccione qué desea vender:");
        // Aquí puedes incluir la lógica para mostrar lo que el jugador tiene y los precios de venta
        System.out.println("1. Obrero - Precio de venta: 0 estelares");
        System.out.println("2. Operador - Precio de venta: 70 estelares");
        System.out.println("3. Técnico - Precio de venta: 175 estelares");
        System.out.println("4. Ingeniero - Precio de venta: 200 estelares");
        // Para vender naves, puedes agregar otra opción aquí

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        switch (opcion) {
            case 1:
                jugador.vender("Obrero", 0);  // Lógica de venta para el Obrero
                break;
            case 2:
                jugador.vender("Operador", 70);
                break;
            case 3:
                jugador.vender("Técnico", 175);
                break;
            case 4:
                jugador.vender("Ingeniero", 200);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
