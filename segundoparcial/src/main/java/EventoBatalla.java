public class EventoBatalla {
    private String actor;
    private String accion;
    private String detalles;
    private int turno;

    public EventoBatalla(String actor, String accion, String detalles, int turno) {
        this.actor = actor;
        this.accion = accion;
        this.detalles = detalles;
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Turno " + turno + ": " + actor + " " + accion + " - " + detalles;
    }

    public String getActor() { return actor; }
    public String getAccion() { return accion; }
    public String getDetalles() { return detalles; }
    public int getTurno() { return turno; }
}

