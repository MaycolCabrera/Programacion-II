public class Charmander extends Pokemon {

    public Charmander() {
        super("Charmander", 80);
    }

    @Override
    protected void inicializarAtaquesUnicos() {
        ataquesUnicos.add(new Ataque("Ascuas", 75, () -> (int)(Math.random() * 11) + 15));
        ataquesUnicos.add(new Ataque("Lanzallamas", 60, () -> (int)(Math.random() * 11) + 20));
    }
}

