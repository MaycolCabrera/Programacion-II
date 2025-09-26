import java.util.*;

public abstract class Pokemon {
    protected String nombre;
    protected int hpMaximo;
    protected int hpActual;
    protected List<Ataque> ataquesBasicos;
    protected List<Ataque> ataquesUnicos;

    public Pokemon(String nombre, int hp) {
        this.nombre = nombre;
        this.hpMaximo = hp;
        this.hpActual = hp;
        this.ataquesBasicos = new ArrayList<>();
        this.ataquesUnicos = new ArrayList<>();

        inicializarAtaquesBasicos();
        inicializarAtaquesUnicos();
    }

    private void inicializarAtaquesBasicos() {
        ataquesBasicos.add(new Ataque("Placaje", 95, () -> 10));
        ataquesBasicos.add(new Ataque("Arañazo", 90, () -> (int)(Math.random() * 11) + 5));
    }

    protected abstract void inicializarAtaquesUnicos();

    public List<Ataque> obtenerTodosLosAtaques() {
        List<Ataque> todos = new ArrayList<>();
        todos.addAll(ataquesBasicos);
        todos.addAll(ataquesUnicos);
        return todos;
    }

    public void recibirDano(int dano) {
        hpActual -= dano;
        if (hpActual < 0) hpActual = 0;
    }

    public boolean estaDerrotado() {
        return hpActual <= 0;
    }

    public String getNombre() { return nombre; }
    public int getHpActual() { return hpActual; }
    public int getHpMaximo() { return hpMaximo; }
}

