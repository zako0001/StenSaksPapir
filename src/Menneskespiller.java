import java.util.Scanner;

public class Menneskespiller extends Spiller {

    // Attribute
    private final Scanner scanner;

    // Constructor
    public Menneskespiller(String navn) {
        super(navn);
        scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
    }

    // Spiller method
    @Override
    public Håndtegn vælgHåndtegn() {

        System.out.print("Skriv 'sten', 'saks' eller 'papir': ");

        try {
            return Håndtegn.valueOf(scanner.next().toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.print("\u001B[91mForkert skrevet.\u001B[0m ");
            return vælgHåndtegn();
        }
    }
}