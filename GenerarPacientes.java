import java.util.Random;

public class GenerarPacientes {

    public static Paciente[] generarPacientes(int cantidad, Dueno[] duenos) {
        Paciente[] pacientes = new Paciente[cantidad];
        Random random = new Random();

        String[] nombres = {"Luna", "Max", "Tati", "Bella", "Toby", "Nala", "Coco", "Tomas", "Milo", "Kira"};
        String[] especies = {"Perro", "Gato"};

        for (int i = 0; i < cantidad; i++) {
            long id = i + 1;
            String nombre = nombres[i % nombres.length];
            String especie = especies[i % especies.length];

            int edadMeses = 1 + random.nextInt(120);// Edad aleatoria entre 1 y 120
            double pesoKg = 1.0 + (i % 30);// Peso entre 1.0 y 30.0
            String raza = "mestizo"; // Raza mestizo por defecto

            Paciente nuevoPaciente = new Paciente(id, nombre, especie, raza, edadMeses, pesoKg);
            pacientes[i] = nuevoPaciente;

            // Asignar al dueño correspondiente
            Dueno duenoAsignado = duenos[i / 2];             // Cada 2 pacientes -> 1 dueño
            if (duenoAsignado.getMascotas() == null) {
                duenoAsignado.setMascotas(new Paciente[2]); // Crear arreglo de 2 solo una vez
            }
            duenoAsignado.agregarMascota(nuevoPaciente, i % 2); // Posición 0 o 1
        }

        return pacientes;
    }
}
