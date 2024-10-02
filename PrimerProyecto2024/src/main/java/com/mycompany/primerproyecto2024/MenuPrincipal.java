/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primerproyecto2024;

import com.mycompany.primerproyecto2024.naves.Nave;
import com.mycompany.primerproyecto2024.planetasYguerrero.Guerrero;
import java.util.Scanner;

/**
 *
 * @author fer
 */
public class MenuPrincipal {

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa mapa;
    private Tienda tienda;
    private int turno;
    private Scanner sc;  // Única instancia de Scanner para evitar problemas de entrada/salida

    public MenuPrincipal(Jugador jugador1, Jugador jugador2, Mapa mapa) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.mapa = mapa;
        this.turno = 1;
        this.tienda = new Tienda();
        this.sc = new Scanner(System.in);  // Iniciar el scanner
    }
// Método para verificar si un jugador ha ganado

    public void primerJuego() {
        System.out.println("KONQUEST - El objetivo del juego es conquistar todos los planetas.");
        System.out.println("¡El jugador que conquiste todos los planetas gana!");
        mapa.mostrarMapa();

        while (true) {
            System.out.println("Es el turno: " + turno);
            if (turno % 2 != 0) {
                jugarTurno(jugador1);
                if (verificarVictoria(jugador1)) {
                    break;  // Terminar el juego si jugador1 ha ganado
                }
            } else {
                jugarTurno(jugador2);
                if (verificarVictoria(jugador2)) {
                    break;  // Terminar el juego si jugador2 ha ganado
                }
            }

            // Al final de cada turno, se ejecuta la producción de recursos
            producirRecursos();  // Actualiza recursos en cada turno
            mapa.mostrarMapa();  // Muestra el mapa actualizado
            turno++;
        }

        System.out.println("¡Fin del juego!");
    }
// Método para gestionar las opciones del turno

    public void jugarTurno(Jugador jugador) {
        System.out.println("\n------------------------------------------");
        System.out.println("Turno actual: " + jugador.getNombre());
        System.out.println("------------------------------------------");
        System.out.println("1. Consultar planeta");
        System.out.println("2. Simular envío de flota");
        System.out.println("3. Enviar flota");
        System.out.println("4. Construir nave");
        System.out.println("5. Ir a la tienda");
        System.out.println("6. Ver recursos actuales");
        System.out.println("7. Terminar turno");
        System.out.println("8. Rendirse");
        System.out.println("==========================================");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();  // Limpiar buffer

        switch (opcion) {
            case 1:
                consultarPlaneta();
                break;
            case 2:
                simularEnviarFlota(jugador);
                break;
            case 3:
                enviarFlota(jugador);
                break;
            case 4:
                construirNave(jugador);
                break;
            case 5:
                tienda.mostrarMenu(jugador);
                break;
            case 6:
                mostrarRecursosJugador(jugador);
                break;
            case 7:
                System.out.println("Turno terminado.");
                break;
            case 8:
                System.out.println(jugador.getNombre() + " se ha rendido.");
                System.exit(0);  // Termina el juego
                break;
            default:
                System.out.println("Opción no válida.");
                jugarTurno(jugador);  // Repetir si la opción es incorrecta
        }
        System.out.println("------------------------------------------");
    }
// Mostrar los recursos y planetas del jugador

    public void mostrarRecursosJugador(Jugador jugador) {
        System.out.println("\n---- RECURSOS DE " + jugador.getNombre() + " ----");
        System.out.println("Monedas: " + jugador.getPlanetaInicial().getMonedas());
        System.out.println("Planetas:");
        for (int i = 0; i < jugador.getPlanetas().length; i++) {
            if (jugador.getPlanetas()[i] != null) {
                Planeta planeta = jugador.getPlanetas()[i];
                System.out.println("- " + planeta.getNombre() + " (Coordenadas: "
                        + planeta.getPosicion().getX() + "," + planeta.getPosicion().getY() + ")");
            }
        }
        System.out.println("------------------------------------------");
    }
// Método para gestionar la producción de recursos al final del turno

    public void producirRecursos() {
        System.out.println("\n--- PRODUCCIÓN DE RECURSOS ---");
        for (int i = 0; i < mapa.getNumPlanetas(); i++) {
            Planeta planeta = mapa.getPlaneta(i);
            if (planeta != null) {
                System.out.println("Produciendo recursos en el planeta " + planeta.getNombre());
                int recursosPrevios = planeta.getMonedas();
                planeta.producirRecursos();
                System.out.println("Recursos producidos: " + (planeta.getMonedas() - recursosPrevios) + " estelares.");
            }
        }
    }

// Mejorado para inicio de turno
    public void mostrarInicioDeTurno(int turno, Jugador jugador) {
        System.out.println("\n************ INICIO DEL TURNO " + turno + " ************");
        System.out.println("Jugador actual: " + jugador.getNombre());
        System.out.println("Es tu turno para realizar acciones. ¿Qué deseas hacer?");
        System.out.println("*****************************************************\n");
    }

    // Método para consultar un planeta
    public void consultarPlaneta() {

        System.out.println("---- CONSULTA DE PLANETA ----");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese las coordenadas del planeta (formato: x,y): ");
        String[] coordenadas = sc.nextLine().split(",");
        int x = Integer.parseInt(coordenadas[0]);
        int y = Integer.parseInt(coordenadas[1]);

        Planeta planeta = mapa.obtenerPlaneta(new Posicion(x, y));

        if (planeta != null) {
            planeta.mostrarInfo();
        } else {
            System.out.println("El planeta no existe en esa posición.");
        }

        System.out.println("----------------------------------");
    }

    public void construirNave(Jugador jugador) {
        Scanner sc = new Scanner(System.in);
        Planeta planeta;

        // Bucle para validar coordenadas
        while (true) {
            System.out.println("Ingrese las coordenadas del planeta donde desea construir la nave (formato: x,y): ");
            String[] coords = sc.nextLine().split(",");

            try {
                int x = Integer.parseInt(coords[0].trim());
                int y = Integer.parseInt(coords[1].trim());
                planeta = mapa.obtenerPlaneta(new Posicion(x, y));

                // Validar que el planeta exista y pertenezca al jugador
                if (planeta != null && planeta.getDueño().equals(jugador.getNombre())) {
                    break;  // Salir del bucle si las coordenadas son válidas
                } else {
                    System.out.println("El planeta no te pertenece o no existe. Intenta de nuevo.");
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Coordenadas no válidas. Inténtalo de nuevo.");
            }
        }

        // Mostrar las opciones de naves
        System.out.println("¿Qué tipo de nave desea construir?");
        System.out.println("1. Helios (Costo: 100 estelares)");
        System.out.println("2. Galaxia Prime (Costo: 200 estelares)");
        System.out.println("3. Nebulon (Costo: 500 estelares)");
        System.out.println("4. Odisea (Costo: 700 estelares)");

        int opcionNave = sc.nextInt();
        switch (opcionNave) {
            case 1:
                planeta.construirNave("Helios");
                break;
            case 2:
                planeta.construirNave("Galaxia Prime");
                break;
            case 3:
                planeta.construirNave("Nebulon");
                break;
            case 4:
                planeta.construirNave("Odisea");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Método para simular el envío de flotas (sin realizar el ataque real)
    public void simularEnviarFlota(Jugador jugador) {
        Scanner sc = new Scanner(System.in);

        // Ingresar las coordenadas del planeta de origen
        System.out.println("Ingrese las coordenadas del planeta de origen (formato: x,y): ");
        String[] origenCoords = sc.nextLine().split(",");
        int origenX = Integer.parseInt(origenCoords[0].trim());
        int origenY = Integer.parseInt(origenCoords[1].trim());
        Planeta origen = mapa.obtenerPlaneta(new Posicion(origenX, origenY));

        if (origen == null || !origen.getDueño().equals(jugador.getNombre())) {
            System.out.println("El planeta de origen no te pertenece o no existe.");
            return;
        }

        // Verificar si hay naves disponibles
        if (origen.getNumNaves() == 0) {
            System.out.println("No hay naves disponibles en el planeta " + origen.getNombre() + ".");
            return;
        }

        // Mostrar las naves disponibles y pedir al jugador que seleccione una
        System.out.println("Seleccione la nave que desea enviar:");
        Nave[] navesDisponibles = origen.getNaves();
        for (int i = 0; i < navesDisponibles.length; i++) {
            if (navesDisponibles[i] != null) {
                System.out.println((i + 1) + ". " + navesDisponibles[i].getNombre());
            }
        }
        int opcionNave = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer

        // Validar que la opción seleccionada sea válida
        if (opcionNave <= 0 || opcionNave > navesDisponibles.length || navesDisponibles[opcionNave - 1] == null) {
            System.out.println("Selección de nave inválida.");
            return;
        }

        Nave naveSeleccionada = navesDisponibles[opcionNave - 1];

        // Mostrar los tipos de guerreros disponibles
        System.out.println("Seleccione el tipo de guerrero a enviar:");
        Guerrero[] guerrerosDisponibles = origen.getGuerreros();
        for (int i = 0; i < guerrerosDisponibles.length; i++) {
            if (guerrerosDisponibles[i] != null) {
                System.out.println((i + 1) + ". " + guerrerosDisponibles[i].getTipo());
            }
        }
        int opcionGuerrero = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer

        // Validar que la opción seleccionada sea válida
        if (opcionGuerrero <= 0 || opcionGuerrero > guerrerosDisponibles.length || guerrerosDisponibles[opcionGuerrero - 1] == null) {
            System.out.println("Selección de guerrero inválida.");
            return;
        }

        Guerrero guerreroSeleccionado = guerrerosDisponibles[opcionGuerrero - 1];

        // Ingresar la cantidad de guerreros
        System.out.println("Ingrese la cantidad de guerreros a enviar: ");
        int cantidadGuerreros = sc.nextInt();
        if (cantidadGuerreros > origen.numGuerreros) {
            System.out.println("No tienes suficientes guerreros.");
            return;
        }

        // Ingresar la cantidad de estelares para mejorar la tasa de supervivencia
    System.out.println("Ingrese la cantidad de estelares para mejorar la tasa de supervivencia: ");
    int estelaresSupervivencia = sc.nextInt();
    sc.nextLine();  // Limpiar el buffer

    // Declarar la variable Planeta destino fuera del bloque while
    Planeta destino = null;
    boolean entradaValida = false;

    // Ingresar las coordenadas del planeta de destino y validarlas
    while (!entradaValida) {
        try {
            System.out.println("Ingrese las coordenadas del planeta de destino (formato: x,y): ");
            String[] destinoCoords = sc.nextLine().split(",");
            if (destinoCoords.length != 2) {
                throw new NumberFormatException("Formato incorrecto.");
            }

            // Convertir las coordenadas ingresadas a enteros
            int destinoX = Integer.parseInt(destinoCoords[0].trim());
            int destinoY = Integer.parseInt(destinoCoords[1].trim());

            // Crear la posición destino correctamente
            Posicion posicionDestino = new Posicion(destinoX, destinoY);

            // Obtener el planeta de destino usando la posición
            destino = mapa.obtenerPlaneta(posicionDestino);

            if (destino == null) {
                System.out.println("El planeta de destino no existe. Intente de nuevo.");
            } else {
                entradaValida = true;  // Las coordenadas son válidas, salimos del bucle
            }

        } catch (NumberFormatException e) {
            System.out.println("Error en el formato de las coordenadas. Asegúrese de ingresar el formato correcto (x,y).");
        }
    }

     
        // Calcular distancia y tasa de supervivencia
        double distancia = mapa.calcularDistancia(origen, destino);
        double tasaSupervivencia = naveSeleccionada.calculoDeTasaDeSupervivencia(distancia, estelaresSupervivencia);

        System.out.println("Distancia a recorrer: " + distancia + " años luz.");
        System.out.println("Tasa de supervivencia estimada: " + tasaSupervivencia + "%.");
    }

    // Método para enviar una flota y realizar el ataque real
    public void enviarFlota(Jugador jugador) {
        Scanner sc = new Scanner(System.in);

        // Ingresar las coordenadas del planeta de origen
        System.out.println("Ingrese las coordenadas del planeta de origen (formato: x,y): ");
        String[] origenCoords = sc.nextLine().split(",");
        int origenX = Integer.parseInt(origenCoords[0].trim());
        int origenY = Integer.parseInt(origenCoords[1].trim());
        Planeta origen = mapa.obtenerPlaneta(new Posicion(origenX, origenY));

        // Verificar que el planeta de origen pertenezca al jugador
        if (origen == null || !origen.getDueño().equals(jugador.getNombre())) {
            System.out.println("El planeta de origen no te pertenece o no existe.");
            return;
        }

        // Verificar si hay naves disponibles en el planeta de origen
        if (origen.getNumNaves() == 0) {
            System.out.println("No hay naves disponibles en el planeta " + origen.getNombre() + ".");
            return;
        }

        // Mostrar las naves disponibles y pedir al jugador que seleccione una
        System.out.println("Seleccione la nave que desea enviar:");
        Nave[] navesDisponibles = origen.getNaves();
        for (int i = 0; i < navesDisponibles.length; i++) {
            if (navesDisponibles[i] != null) {
                System.out.println((i + 1) + ". " + navesDisponibles[i].getNombre());
            }
        }
        int opcionNave = sc.nextInt();
        sc.nextLine();  // Limpiar el buffer
        Nave naveSeleccionada = navesDisponibles[opcionNave - 1];

        // Mostrar los guerreros disponibles y pedir al jugador que seleccione uno
        System.out.println("Ingrese la cantidad de guerreros a enviar: ");
        int cantidadGuerreros = sc.nextInt();
        if (cantidadGuerreros > origen.numGuerreros) {
            System.out.println("No tienes suficientes guerreros.");
            return;
        }
        Guerrero[] guerrerosAtacantes = new Guerrero[cantidadGuerreros];
        for (int i = 0; i < cantidadGuerreros; i++) {
            guerrerosAtacantes[i] = origen.guerreros[i];  // Copiar guerreros desde el origen
        }

        // Ingresar las coordenadas del planeta de destino
        System.out.println("Ingrese las coordenadas del planeta de destino (formato: x,y): ");
        String[] destinoCoords = sc.nextLine().split(",");
        int destinoX = Integer.parseInt(destinoCoords[0].trim());
        int destinoY = Integer.parseInt(destinoCoords[1].trim());
        Planeta destino = mapa.obtenerPlaneta(new Posicion(destinoX, destinoY));

        // Verificar que el planeta de destino exista
        if (destino == null) {
            System.out.println("El planeta de destino no existe.");
            return;
        }

        // Lógica de batalla o refuerzo
        System.out.println("Enviando flota con la nave " + naveSeleccionada.getNombre() + " y " + cantidadGuerreros + " guerreros.");
        if (destino.getDueño().equals("Neutral") || !destino.getDueño().equals(jugador.getNombre())) {
            // Si es un planeta neutral o enemigo, inicia la batalla
            boolean conquista = destino.batalla(guerrerosAtacantes, origen);
            if (conquista) {
                System.out.println("El planeta " + destino.getNombre() + " ha sido conquistado por " + jugador.getNombre() + "!");
                destino.setDueño(jugador.getNombre());
            } else {
                System.out.println("Los defensores han repelido el ataque en " + destino.getNombre() + ".");
            }
        } else {
            // Si es un planeta aliado, simplemente se refuerzan los guerreros
            destino.reforzarGuerreros(guerrerosAtacantes);
            System.out.println("Los guerreros han sido enviados para reforzar el planeta " + destino.getNombre() + ".");
        }

        // Actualizar los guerreros en el planeta de origen
        origen.numGuerreros -= cantidadGuerreros;

        // Eliminar la nave usada (se puede ajustar si queremos reutilizar naves)
        origen.eliminarNave();
    }

    // Verificar victoria del jugador
    private boolean verificarVictoria(Jugador jugador) {
        for (int i = 0; i < mapa.getNumPlanetas(); i++) {
            Planeta planeta = mapa.getPlaneta(i);
            if (!planeta.getDueño().equals(jugador.getNombre())) {
                return false;  // Si hay algún planeta que no es del jugador, no ha ganado
            }
        }
        System.out.println(jugador.getNombre() + " ha ganado al conquistar todos los planetas!");
        return true;
    }

}//finclaseMenuP
