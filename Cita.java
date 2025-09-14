public class Cita {
    private Cliente cliente;
    private Mascota mascota;
    private String tipoAtencion;
    private String fecha;
    private double costoBase;

    public Cita(Cliente cliente, Mascota mascota, String tipoAtencion, String fecha, double costoBase) {
        this.cliente = cliente;
        this.mascota = mascota;
        this.tipoAtencion = tipoAtencion;
        this.fecha = fecha;
        this.costoBase = costoBase;
    }

    public double calcularCostoFinal() {
        if (tipoAtencion.equalsIgnoreCase("grooming")) {
            return costoBase * 0.9; // 10% descuento
        }
        if (tipoAtencion.equalsIgnoreCase("emergencia")) {
            return costoBase * 1.2; // 20% recargo
        }
        return costoBase;
    }

    public void mostrarResumen() {
        System.out.println("---- Resumen de Atención Veterinaria ----");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Mascota: " + mascota.getNombre() + " (" + mascota.getEspecie() + ", " + mascota.getEdad() + " años)");
        System.out.println("Atención: " + tipoAtencion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Costo final: Q " + calcularCostoFinal());
        System.out.println("-----------------------------------------");
    }
}

