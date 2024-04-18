import java.util.Random;

public class Computerspiller extends Spiller {

    // Attribute
    private final Random random;

    // Constructor
    public Computerspiller(String navn) {
        super(navn);
        random = new Random();
    }

    // Spiller method
    @Override
    public Håndtegn vælgHåndtegn() {

        return Håndtegn.values()[random.nextInt(Håndtegn.values().length)];
    }
}