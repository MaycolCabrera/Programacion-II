public class Squirtle extends Pokemon {

    public Squirtle() {
        super("Squirtle", 85);
    }

    @Override
    protected void inicializarAtaquesUnicos() {
        ataquesUnicos.add(new Ataque("Pistola Agua", 85, () -> (int)(Math.random() * 11) + 12));
        ataquesUnicos.add(new Ataque("Burbuja", 95, () -> (int)(Math.random() * 11) + 8));
    }
}

