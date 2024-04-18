public abstract class Spiller {

    // Attributes
    private final String navn;
    private int point;

    // Constructor
    public Spiller(String navn) {
        this.navn = navn;
        point = 0;
    }

    // Getters
    public String getNavn() {
        return navn;
    }

    public int getPoint() {
        return point;
    }

    // Incrementer
    public void incrementPoint() {
        point++;
    }

    // Abstract method
    public abstract Håndtegn vælgHåndtegn();
}