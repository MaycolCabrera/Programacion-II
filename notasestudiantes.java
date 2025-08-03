import java.util.Scanner;

public class notasestudiantes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar cantidad de estudiantes (máximo 5)
        int cantidadEstudiantes;
        do {
            System.out.print("¿Cuántos estudiantes desea ingresar? (Máximo 5): ");
            cantidadEstudiantes = scanner.nextInt();
        } while (cantidadEstudiantes < 1 || cantidadEstudiantes > 5);

        // Arreglos para guardar datos
        String[] nombres = new String[cantidadEstudiantes];
        double[] promedios = new double[cantidadEstudiantes];
        String[] estados = new String[cantidadEstudiantes];

        // Ciclo para ingresar datos de cada estudiante
        for (int i = 0; i < cantidadEstudiantes; i++) {
            scanner.nextLine(); // Limpiar el buffer

            System.out.println("\n--- Estudiante #" + (i + 1) + " ---");

            // Pedir nombre
            System.out.print("Nombre: ");
            nombres[i] = scanner.nextLine();

            // Pedir 3 notas
            double[] notas = new double[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[j] = scanner.nextDouble();
            }

            // Calcular promedio y estado
            promedios[i] = calcularPromedio(notas);
            estados[i] = estaAprobado(promedios[i]) ? "Aprobado" : "Reprobado";
        }

        // Mostrar resumen
        mostrarResumen(nombres, promedios, estados);

        scanner.close();
    }

    // Función para calcular promedio
    public static double calcularPromedio(double[] notas) {
        return (notas[0] + notas[1] + notas[2]) / 3;
    }

    // Función booleana para saber si aprueba
    public static boolean estaAprobado(double promedio) {
        return promedio >= 61;
    }

    // Procedimiento para mostrar resumen
    public static void mostrarResumen(String[] nombres, double[] promedios, String[] estados) {
        System.out.println("\n--- RESUMEN DE ESTUDIANTES ---");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("\nEstudiante: " + nombres[i]);
            System.out.println("Promedio: " + promedios[i]);
            System.out.println("Estado: " + estados[i]);
        }
    }
}