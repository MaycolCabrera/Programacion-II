import java.util.Scanner;
import java.util.ArrayList;

public class cajero_automatico_simulado extends javax.swing.JFrame {
    public static void main(String[] args) {
        iniciarSesion();
    }

    static double saldo = 1000.00; // Saldo inicial
    static ArrayList<String> historial = new ArrayList<>(); // Para guardar transacciones
    static Scanner scanner = new Scanner(System.in);

    // Procedimiento para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\nBienvenido al Cajero Automático");
        System.out.println("1. Consultar saldo");
        System.out.println("2. Depositar dinero");
        System.out.println("3. Retirar dinero");
        System.out.println("4. Salir");
        System.out.print("\nOpción: ");
    }

    // Procedimiento para consultar saldo
    public static void consultarSaldo(double saldo) {
        System.out.printf("Su saldo actual es: Q%.2f\n", saldo);
        historial.add("Consulta de saldo"); // Registro en historial
    }

    // Procedimiento para depositar dinero
    public static void depositarDinero(double[] saldo) {
        System.out.print("Ingrese monto a depositar: Q");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        if (monto > 0) {
            saldo[0] += monto;
            System.out.printf("Depósito exitoso. Nuevo saldo: Q%.2f\n", saldo[0]);
            historial.add("Depósito de Q" + String.format("%.2f", monto)); // Registro
        } else {
            System.out.println("Error: Monto inválido");
        }
    }

    // Procedimiento para retirar dinero
    public static void retirarDinero(double[] saldo) {
        System.out.print("Ingrese monto a retirar: Q");
        double monto = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        if (monto > 0 && monto <= saldo[0]) {
            saldo[0] -= monto;
            System.out.printf("Retiro exitoso. Nuevo saldo: Q%.2f\n", saldo[0]);
            historial.add("Retiro de Q" + String.format("%.2f", monto)); // Registro
        } else {
            System.out.println("Error: Fondos insuficientes o monto inválido");
        }
    }

    // Procedimiento principal que controla el flujo
    public static void iniciarSesion() {
        double[] saldoArray = {saldo}; // Usamos array para simular paso por referencia
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    consultarSaldo(saldoArray[0]);
                    break;
                case 2:
                    depositarDinero(saldoArray);
                    break;
                case 3:
                    retirarDinero(saldoArray);
                    break;
                case 4:
                    System.out.println("Gracias por usar nuestro cajero");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (opcion != 4);

        // Mostrar historial al salir
        System.out.println("\nHistorial de transacciones:");
        for (String transaccion : historial) {
            System.out.println(transaccion);
        }
    }
}
