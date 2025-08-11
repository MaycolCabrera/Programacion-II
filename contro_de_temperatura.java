import java.util.Scanner;

public class contro_de_temperatura {
    static double[] temperaturas = new double[7];
    static String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    static boolean datosIngresados = false;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }

    // Menú principal
    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- REGISTRO DE TEMPERATURAS ---");
            System.out.println("1. Ingresar temperaturas");
            System.out.println("2. Mostrar todas las temperaturas");
            System.out.println("3. Mostrar temperatura máxima");
            System.out.println("4. Suma total de temperaturas (recursivo)");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarTemperaturas();
                    break;
                case 2:
                    mostrarTemperaturas();
                    break;
                case 3:
                    mostrarTemperaturaMaxima();
                    break;
                case 4:
                    if (datosIngresados) {
                        double suma = sumaTemperaturasRecursiva(temperaturas, temperaturas.length - 1);
                        System.out.printf("Suma total de temperaturas: %.2f°C\n", suma);
                    } else {
                        System.out.println("Primero debe ingresar temperaturas");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    // Opción 1: Ingresar temperaturas
    public static void ingresarTemperaturas() {
        System.out.println("\nINGRESO DE TEMPERATURAS");
        for (int i = 0; i < 7; i++) {
            System.out.print("Ingrese temperatura para el " + dias[i] + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
        datosIngresados = true;
        System.out.println("Temperaturas registradas exitosamente!");
    }

    // Opción 2: Mostrar todas las temperaturas
    public static void mostrarTemperaturas() {
        if (!datosIngresados) {
            System.out.println("Primero debe ingresar temperaturas");
            return;
        }

        System.out.println("\nTEMPERATURAS REGISTRADAS");
        for (int i = 0; i < 7; i++) {
            System.out.println(dias[i] + ": " + temperaturas[i] + "°C");
        }
    }

    // Opción 3: Mostrar temperatura máxima
    public static void mostrarTemperaturaMaxima() {
        if (!datosIngresados) {
            System.out.println("Primero debe ingresar temperaturas");
            return;
        }

        double maxima = obtenerTemperaturaMaxima(temperaturas);
        int indiceMax = encontrarIndiceMaximo(temperaturas);

        // Métodos sobrecargados
        mostrarMaxima(maxima); // Sin día
        mostrarMaxima(maxima, dias[indiceMax]); // Con día
    }

    // Función para encontrar la temperatura máxima
    public static double obtenerTemperaturaMaxima(double[] temps) {
        double max = temps[0];
        for (double temp : temps) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    // Función auxiliar para encontrar el índice de la temperatura máxima
    public static int encontrarIndiceMaximo(double[] temps) {
        int indice = 0;
        for (int i = 1; i < temps.length; i++) {
            if (temps[i] > temps[indice]) {
                indice = i;
            }
        }
        return indice;
    }

    // Métodos sobrecargados para mostrar la máxima
    public static void mostrarMaxima(double temperatura) {
        System.out.printf("\nTemperatura máxima: %.2f°C\n", temperatura);
    }

    public static void mostrarMaxima(double temperatura, String dia) {
        System.out.printf("Temperatura máxima: %.2f°C (registrada el %s)\n", temperatura, dia);
    }

    // Función recursiva para sumar temperaturas (opcional)
    public static double sumaTemperaturasRecursiva(double[] temps, int indice) {
        if (indice == 0) {
            return temps[0];
        }
        return temps[indice] + sumaTemperaturasRecursiva(temps, indice - 1);
    }
}
