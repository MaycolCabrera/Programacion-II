public class Pikachu extends Pokemon {

    public Pikachu() {
        super("Pikachu", 75);
    }

    @Override
    protected void inicializarAtaquesUnicos() {
        ataquesUnicos.add(new Ataque("Impactrueno", 90, () -> (int)(Math.random() * 11) + 10));
        ataquesUnicos.add(new Ataque("Rayo", 70, () -> (int)(Math.random() * 11) + 18));
    }
}

