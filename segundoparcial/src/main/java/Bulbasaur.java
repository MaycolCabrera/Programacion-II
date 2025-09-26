public class Bulbasaur extends Pokemon {

    public Bulbasaur() {
        super("Bulbasaur", 90);
    }

    @Override
    protected void inicializarAtaquesUnicos() {
        ataquesUnicos.add(new Ataque("Hoja Afilada", 80, () -> (int)(Math.random() * 11) + 13));
        ataquesUnicos.add(new Ataque("Latigo Cepa", 88, () -> 18));
    }
}

