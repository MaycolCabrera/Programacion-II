import java.util.Random;

public class Generar_datos_Dueno {
    public class GeneradorDatosDueno {

        public static Dueno[] generarDuenos(int cantidad){
            Dueno[] duenos = new Dueno[cantidad];
            Random random = new Random();

            // Cree arreglos para poder usar los nombres de forma aleatoria y pueda dar 500 Dueños con nombres diferentes es decir se asignaran nombres aleatoriamente

            String[] nombres = {"Maycol", "Gerardo", "Jose", "Andres", "Guillermo", "Sebastian", "Evelin", "Elisabet", "Bladimir", "Alexander"};
            String[] apellidos = {"Cabrera", "Cruz", "Orozco", "Lopez", "Mayen ", "Gómez", "Rivera", "Orellana", "Cruz", "Calderon"};

            // For que recorre los arreglos antes creados y asi con el random asginar nombres al azar.
            for (int i = 0; i < cantidad; i++) {
                long id = i + 1;

                // Seleccionar nombre y apellido al azar
                String nombre = nombres[random.nextInt(nombres.length)];
                String apellido = apellidos[random.nextInt(apellidos.length)];
                String nombreCompleto = nombre + " " + apellido;

                // Teléfono aleatorio (8 dígitos) %08d es para poder asignar siempre 8 digitos al numero de telefono
                String telefono = "502-" + String.format("%08d", random.nextInt(100_000_000));

                // Email aleatorio y con un metodo de toLowercase para convertir a minuscula los nombres y apellidos para los emails aleatorios
                String email = nombre.toLowerCase() + apellido.toLowerCase() + (random.nextInt(1000) + 1) + "@correo.com";

                // Dirección aleatoria
                String direccion = "Calle " + (random.nextInt(50) + 1) + ", Zona " + (random.nextInt(25) + 1);

                duenos[i] = new Dueno(id, nombreCompleto, telefono, email, direccion);
            }

            return duenos;
        }
    }

}
