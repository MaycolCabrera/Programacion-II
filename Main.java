
public class Main {
    public static void main(String[] args) {
        // Generar 500 dueños
        Dueno[] duenos = Generar_datos_Dueno.GeneradorDatosDueno.generarDuenos(500);

        // Generar 1000 pacientes (2 por dueño)
        Paciente[] pacientes = GenerarPacientes.generarPacientes(1000, duenos);

        // Mostrar verificación: primeros 3 dueños
        System.out.println("=== Primeros 3 Dueños ===");
        for (int i = 0; i < 3; i++) {
            Dueno d = duenos[i];
            System.out.println("ID: " + d.getId()
                    + " | Nombre: " + d.getnombreCompleto()
                    + " | Teléfono: " + d.getTelefono()
                    + " | Email: " + d.getEmail()
                    + " | Dirección: " + d.getDireccion());
        }

        System.out.println("=== Primeros 3 Dueños y sus Mascotas ===");
        for (int i = 0; i < 3; i++) {
            Dueno d = duenos[i];
            System.out.println("Dueño: " + d.getnombreCompleto());
            for (Paciente p : d.getMascotas()) {
                System.out.println("   - Mascota: " + p.getNombre()
                        + " (" + p.getEspecie() + "), Edad: "
                        + p.getEdadMeses() + " meses, Peso: "
                        + p.getpesokg() + " kg");
            }
        }
        System.out.println(); // salto de línea

// Mostrar las primeras 6 mascotas con sus dueños
        System.out.println("=== Primeras 6 Mascotas con Dueño ===");
        for (int i = 0; i < 6; i++) {
            Paciente p = pacientes[i];

            // Buscar dueño de la mascota
            Dueno dueno = null;
            for (Dueno d : duenos) {
                for (Paciente mascota : d.getMascotas()) {
                    if (mascota.getId() == p.getId()) {
                        dueno = d;
                        break;
                    }
                }
                if (dueno != null) break;
            }
            //Imprimir el dueño de la mascota
            System.out.println("Mascota: " + p.getNombre()
                    + " (" + p.getEspecie() + ")"
                    + " ➜ Dueño: " + (dueno != null ? dueno.getnombreCompleto() : "Sin dueño"));
        }

        System.out.println();

        // Conteo de cachorros
        int conteoCachorros = 0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i].esCachorro()) {
                conteoCachorros++;
            }
        }
        System.out.println("Número de cachorros: " + conteoCachorros);

        System.out.println();
// Distribución por especie y peso promedio
        int perros = 0, gatos = 0;
        double pesoPerros = 0.0, pesoGatos = 0.0;
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i].getEspecie().equalsIgnoreCase("perro")) {
                perros++;
                pesoPerros += pacientes[i].getpesokg();
            } else if (pacientes[i].getEspecie().equalsIgnoreCase("gato")) {
                gatos++;
                pesoGatos += pacientes[i].getpesokg();
            }
        }
        System.out.println("Perros: " + perros + " | Gatos: " + gatos);
        System.out.println("Peso promedio perros: " + (pesoPerros / perros));
        System.out.println("Peso promedio gatos: " + (pesoGatos / gatos));

        System.out.println();
        Paciente[] top5 = new Paciente[5];



// Llenar el top 5
        for (int i = 0; i < pacientes.length; i++) {
            Paciente actual = pacientes[i];
            for (int j = 0; j < 5; j++) {
                if (top5[j] == null || actual.getEdadMeses() > top5[j].getEdadMeses()) {
                    // Desplazar menores hacia la derecha
                    for (int k = 4; k > j; k--) {
                        top5[k] = top5[k-1];
                    }
                    top5[j] = actual;
                    break;
                }
            }
        }

// Imprimir después de calcular
        System.out.println("Top 5 mascotas más longevas:");
        for (int i = 0; i < 5; i++) {
            if (top5[i] != null) System.out.println(top5[i].resumen());
        }

        //Gnerar Citas
        Cita[] citas = GenerarCita.GenerarCitas.generarCitas(duenos, pacientes);

        System.out.println("\n=== Resumen de Citas ===");
        for (Cita c : citas) {
            if (c != null) {
                System.out.println(c.resumen());
            }
        }
    }
}

