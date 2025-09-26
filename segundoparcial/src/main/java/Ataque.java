public class Ataque {
    private String nombre;      // Nombre del ataque
    private int precision;      // Precisión del ataque (0-100)
    private ReglaDanio regla;   // Regla que calcula el daño

    public Ataque(String nombre, int precision, ReglaDanio regla) {
        this.nombre = nombre;
        this.precision = precision;
        this.regla = regla;
    }

    public boolean acierta() {
        int numeroAleatorio = (int)(Math.random() * 100) + 1;
        return numeroAleatorio <= precision;
    }

    public int calcularDano() {
        return regla.calcularDano();
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecision() {
        return precision;
    }
}

