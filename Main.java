import java.util.Scanner;

public class Main {
    public static void saludarIA() {
        System.out.println("Hola, soy la IA Maycol");
    }

    public static void main(String[] args) {
        saludarIA();

        Scanner sc = new Scanner(System.in);

        // Registrar cliente
        System.out.print("Ingrese nombre del dueño: ");
        String nombreCliente = sc.nextLine();
        System.out.print("Ingrese teléfono del dueño: ");
        String telCliente = sc.nextLine();
        Cliente cliente = new Cliente(nombreCliente, telCliente);

        // Registrar mascota
        System.out.print("Ingrese nombre de la mascota: ");
        String nombreMascota = sc.nextLine();
        System.out.print("Ingrese especie de la mascota (perro, gato, etc.): ");
        String especieMascota = sc.nextLine();
        System.out.print("Ingrese edad de la mascota: ");
        int edadMascota = sc.nextInt();
        sc.nextLine(); // limpiar buffer
        Mascota mascota = new Mascota(nombreMascota, especieMascota, edadMascota);

        // Agendar cita
        System.out.print("Tipo de atención (consulta/procedimiento/emergencia/grooming): ");
        String tipo = sc.nextLine();
        System.out.print("Fecha de la cita: ");
        String fecha = sc.nextLine();
        System.out.print("Costo base: ");
        double costo = sc.nextDouble();

        Cita cita = new Cita(cliente, mascota, tipo, fecha, costo);

        // Mostrar resumen
        cita.mostrarResumen();
        sc.close();
    }
}
