import java.util.Scanner;

public class escalera_de_numeros {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de niveles: ");
        int n = scanner.nextInt();

        if (n < 1) {
            System.out.println("Error: El número debe ser mayor o igual a 1");
        } else {
            imprimirEscaleraAscendente(n);
            imprimirEscaleraDescendente(n);
            // Versión alternativa con recursividad:
            // imprimirEscaleraDescendenteRecursiva(n-1);
        }

        scanner.close();
    }

    // Procedimiento para la parte ascendente
    public static void imprimirEscaleraAscendente(int niveles) {
        for (int i = 1; i <= niveles; i++) {
            imprimirLinea(i); // Versión con números
            // Alternativa con símbolos:
            // imprimirLinea(i, '*');
        }
    }

    // Procedimiento para la parte descendente (iterativo)
    public static void imprimirEscaleraDescendente(int niveles) {
        for (int i = niveles - 1; i >= 1; i--) {
            imprimirLinea(i);
        }
    }

    // Versión recursiva para la parte descendente (opcional)
    public static void imprimirEscaleraDescendenteRecursiva(int nivel) {
        if (nivel < 1) return;

        imprimirLinea(nivel);
        imprimirEscaleraDescendenteRecursiva(nivel - 1);
    }

    // Método sobrecargado para imprimir línea con números
    public static void imprimirLinea(int nivel) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(i);
            if (i < nivel) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    // Método sobrecargado para imprimir línea con símbolos
    public static void imprimirLinea(int nivel, char simbolo) {
        for (int i = 1; i <= nivel; i++) {
            System.out.print(simbolo);
            if (i < nivel) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
