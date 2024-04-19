import java.util.Scanner;

public class Menneskespiller extends Spiller {

    // Attribute
    private final Scanner scanner;

    // Constructor
    public Menneskespiller(String navn) {
        super(navn);
        scanner = new Scanner(System.in);
    }

    // Spiller method
    @Override
    public Håndtegn vælgHåndtegn() {

        System.out.print(STR."\{getNavn()}, skriv 'sten', 'saks' eller 'papir': ");

        try {

            return Håndtegn.valueOf(scanner.nextLine()
                .toUpperCase()
                .replaceAll("[^AEIKNPRST]", "")     // Fjerner irrelevante tegn.
            );

        } catch (IllegalArgumentException iae) {

            System.out.println("\u001B[91mForkert skrevet.\u001B[0m");

            return vælgHåndtegn();                  // Rekursion: Metoden returnerer sig selv og starter derfor forfra.
        }
    }
}