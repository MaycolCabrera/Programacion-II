import java.util.*;
import java.util.stream.Collectors;

public class Juego {
    private Scanner scanner;
    private Pokemon pokemonJugador;
    private Pokemon pokemonCPU;
    private String nombreJugador;
    private List<EventoBatalla> eventos;
    private int turnoActual;

    public Juego() {
        scanner = new Scanner(System.in);
        eventos = new ArrayList<>();
        turnoActual = 0;
    }

    public void iniciarJuego() {
        mostrarBienvenida();
        pedirNombreJugador();
        seleccionarPokemon();
        iniciarBatalla();
        mostrarResumen();
        scanner.close();
    }

    private void mostrarBienvenida() {
        System.out.println("========================================");
        System.out.println("    ¡Bienvenido al juego Pokémon!      ");
        System.out.println("========================================\n");
    }

    private void pedirNombreJugador() {
        System.out.print("Por favor, ingresa tu nombre: ");
        nombreJugador = scanner.nextLine();
        System.out.println("¡Hola " + nombreJugador + "!\n");
    }

    private void seleccionarPokemon() {
        Pokemon[] pokemonsDisponibles = { new Charmander(), new Squirtle(), new Bulbasaur(), new Pikachu() };
        System.out.println("Selecciona tu Pokémon:");
        for (int i = 0; i < pokemonsDisponibles.length; i++)
            System.out.println((i+1) + ". " + pokemonsDisponibles[i].getNombre() +
                    " (HP: " + pokemonsDisponibles[i].getHpMaximo() + ")");
        boolean seleccionValida = false;
        while (!seleccionValida) {
            try {
                System.out.print("Tu elección (1-4): ");
                int eleccion = Integer.parseInt(scanner.nextLine());
                if (eleccion < 1 || eleccion > 4)
                    throw new Expresiones.InvalidChoiceException("Debes elegir un número entre 1 y 4");
                pokemonJugador = pokemonsDisponibles[eleccion - 1];

                // CPU elige diferente Pokémon
                int eleccionCPU;
                do {
                    eleccionCPU = (int)(Math.random() * 4);
                } while (eleccionCPU == eleccion - 1);
                pokemonCPU = pokemonsDisponibles[eleccionCPU];

                seleccionValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            } catch (Expresiones.InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("\nHas elegido a " + pokemonJugador.getNombre());
        System.out.println("La CPU ha elegido a " + pokemonCPU.getNombre() + "\n");
    }

    private void iniciarBatalla() {
        System.out.println("¡Comienza la batalla!");
        System.out.println(pokemonJugador.getNombre() + " vs " + pokemonCPU.getNombre() + "\n");

        while (!pokemonJugador.estaDerrotado() && !pokemonCPU.estaDerrotado()) {
            turnoActual++;
            System.out.println("--- Turno " + turnoActual + " ---");

            if (!pokemonJugador.estaDerrotado()) turnoJugador();
            if (!pokemonCPU.estaDerrotado() && !pokemonJugador.estaDerrotado()) turnoCPU();
            mostrarEstadoActual();
            System.out.println();
        }

        if (pokemonJugador.estaDerrotado())
            System.out.println("¡La CPU ha ganado! " + pokemonCPU.getNombre() + " es el campeón.");
        else
            System.out.println("¡Felicidades " + nombreJugador + "! " + pokemonJugador.getNombre() + " ha ganado.");
    }

    private void turnoJugador() {
        List<Ataque> ataquesOrdenados = pokemonJugador.obtenerTodosLosAtaques().stream()
                .sorted((a1, a2) -> Integer.compare(a2.getPrecision(), a1.getPrecision()))
                .collect(Collectors.toList());

        System.out.println("Ataques de " + pokemonJugador.getNombre() + ":");
        for (int i = 0; i < ataquesOrdenados.size(); i++)
            System.out.println((i+1) + ". " + ataquesOrdenados.get(i).getNombre() +
                    " (Precisión: " + ataquesOrdenados.get(i).getPrecision() + "%)");

        boolean ataqueValido = false;
        while (!ataqueValido) {
            try {
                System.out.print("Elige tu ataque (1-" + ataquesOrdenados.size() + "): ");
                int eleccion = Integer.parseInt(scanner.nextLine());
                if (eleccion < 1 || eleccion > ataquesOrdenados.size())
                    throw new Expresiones.InvalidChoiceException("Debes elegir un número entre 1 y " + ataquesOrdenados.size());

                ejecutarAtaque(pokemonJugador, pokemonCPU, ataquesOrdenados.get(eleccion - 1), "Jugador");
                ataqueValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingresa un número válido.");
            } catch (Expresiones.InvalidChoiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void turnoCPU() {
        System.out.println("Turno de la CPU...");
        List<Ataque> ataques = pokemonCPU.obtenerTodosLosAtaques();
        Ataque ataqueElegido = ataques.stream()
                .filter(a -> a.getPrecision() >= 70)
                .max(Comparator.comparingInt(Ataque::getPrecision))
                .orElse(ataques.get(0));

        System.out.println(pokemonCPU.getNombre() + " usará " + ataqueElegido.getNombre());
        ejecutarAtaque(pokemonCPU, pokemonJugador, ataqueElegido, "CPU");
    }

    private void ejecutarAtaque(Pokemon atacante, Pokemon defensor, Ataque ataque, String actor) {
        try {
            if (!ataque.acierta())
                throw new Expresiones.AttackMissedException(atacante.getNombre() + " usó " + ataque.getNombre() + " pero falló!");

            int dano = ataque.calcularDano();
            defensor.recibirDano(dano);

            String mensaje = atacante.getNombre() + " usó " + ataque.getNombre() +
                    " e hizo " + dano + " puntos de daño a " + defensor.getNombre();
            System.out.println(mensaje);

            eventos.add(new EventoBatalla(actor, "atacó con " + ataque.getNombre(), "Daño: " + dano, turnoActual));
        } catch (Expresiones.AttackMissedException e) {
            System.out.println(e.getMessage());
            eventos.add(new EventoBatalla(actor, "falló el ataque " + ataque.getNombre(), "Sin daño", turnoActual));
        }
    }

    private void mostrarEstadoActual() {
        System.out.println("Estado actual:");
        System.out.println(pokemonJugador.getNombre() + ": " + pokemonJugador.getHpActual() + "/" + pokemonJugador.getHpMaximo() + " HP");
        System.out.println(pokemonCPU.getNombre() + ": " + pokemonCPU.getHpActual() + "/" + pokemonCPU.getHpMaximo() + " HP");
    }

    private void mostrarResumen() {
        System.out.println("\n========================================");
        System.out.println("           RESUMEN DE BATALLA           ");
        System.out.println("========================================");

        System.out.println("Eventos clave:");
        eventos.stream().skip(Math.max(0, eventos.size() - 5)).forEach(System.out::println);

        System.out.println("\nESTADÍSTICAS:");
        System.out.println("Total de turnos: " + turnoActual);

        Map<String, Long> eventosPorActor = eventos.stream()
                .collect(Collectors.groupingBy(EventoBatalla::getActor, Collectors.counting()));
        eventosPorActor.forEach((actor, cantidad) -> System.out.println("Acciones de " + actor + ": " + cantidad));

        System.out.println("\nTop 3 ataques más utilizados:");
        eventos.stream()
                .filter(e -> e.getAccion().contains("atacó con"))
                .map(e -> e.getAccion().replace("atacó con ", ""))
                .collect(Collectors.groupingBy(a -> a, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " veces"));

        long ataquesFallidos = eventos.stream().filter(e -> e.getDetalles().equals("Sin daño")).count();
        long ataquesExitosos = eventos.stream().filter(e -> e.getDetalles().startsWith("Daño:")).count();
        if (ataquesExitosos + ataquesFallidos > 0) {
            System.out.println("\nPrecisión general: " +
                    String.format("%.1f", (double)ataquesExitosos / (ataquesExitosos + ataquesFallidos) * 100) + "%");
        } else {
            System.out.println("\nPrecisión general: 0.0%");
        }

        System.out.println("Ataques exitosos: " + ataquesExitosos);
        System.out.println("Ataques fallidos: " + ataquesFallidos);

        System.out.println("\n¡Gracias por jugar!");
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciarJuego();
    }
}

