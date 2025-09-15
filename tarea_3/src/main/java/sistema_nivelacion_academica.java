import java.util.Scanner;

public class sistema_nivelacion_academica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de estudiantes: ");
        int cantidadEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        String[] nombres = new String[cantidadEstudiantes];
        double[][] notasEstudiantes = new double[cantidadEstudiantes][];

        // Leer datos de cada estudiante
        for (int i = 0; i < cantidadEstudiantes; i++) {
            System.out.print("\nIngrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = scanner.nextLine();

            System.out.print("Ingrese la cantidad de notas para " + nombres[i] + ": ");
            int cantidadNotas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            double[] notas = new double[cantidadNotas];
            for (int j = 0; j < cantidadNotas; j++) {
                System.out.print("Ingrese la nota " + (j + 1) + ": ");
                notas[j] = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer
            }

            notasEstudiantes[i] = notas;
        }

        // Mostrar resultados para cada estudiante
        System.out.println("\n=== RESULTADOS ===");
        for (int i = 0; i < cantidadEstudiantes; i++) {
            mostrarResultado(nombres[i], notasEstudiantes[i]);
        }

        scanner.close();
    }

    // Función para calcular el promedio
    public static double calcularPromedio(double[] notas) {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.length;
    }

    // Función para obtener la calificación literal
    public static char obtenerLiteral(double promedio) {
        if (promedio >= 90) return 'A';
        if (promedio >= 80) return 'B';
        if (promedio >= 70) return 'C';
        if (promedio >= 60) return 'D';
        return 'F';
    }

    // Función para determinar si está aprobado
    public static boolean estaAprobado(char literal) {
        return literal == 'A' || literal == 'B' || literal == 'C';
    }

    // Procedimiento para mostrar los resultados
    public static void mostrarResultado(String nombre, double[] notas) {
        System.out.println("\nEstudiante: " + nombre);
        System.out.print("Notas: [");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]);
            if (i < notas.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        double promedio = calcularPromedio(notas);
        System.out.printf("Promedio: %.2f\n", promedio);

        char literal = obtenerLiteral(promedio);
        System.out.println("Literal: " + literal);

        System.out.println("Resultado: " + (estaAprobado(literal) ? "Aprobado ✅" : "Reprobado ❌"));
    }
}
