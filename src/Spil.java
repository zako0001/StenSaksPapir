public class Spil {

    // Attributes
    private final Spiller s1;
    private final Spiller s2;
    private final int bedstAf;

    // Constructor
    public Spil(Spiller s1, Spiller s2, int bedstAf) {

        if (bedstAf < 1 || bedstAf % 2 == 0) {
            throw new IllegalArgumentException(STR."bedstAf var \{bedstAf} men skal være et positivt ulige tal.");
        }

        this.s1 = s1;
        this.s2 = s2;
        this.bedstAf = bedstAf;
    }

    // Method
    public void start() {

        System.out.println(STR."""
            
            Velkommen til sten-saks-papir!
            Spillet afgøres ud fra bedst-af-\{talord(bedstAf)}."""
        );

        int nokPoint = bedstAf / 2 + 1;     // Udnytter heltalsdivision.
        int runde = 0;

        while (s1.getPoint() != nokPoint && s2.getPoint() != nokPoint) {

            System.out.println(STR."\n\u001B[51m Runde \{++runde} \u001B[0m");

            Håndtegn h1 = s1.vælgHåndtegn();
            Håndtegn h2 = s2.vælgHåndtegn();

            System.out.println(STR."""
                \{s1.getNavn()} valgte \{h1.toString().toLowerCase()}.
                \{s2.getNavn()} valgte \{h2.toString().toLowerCase()}."""
            );

            if (h1 == h2) {
                System.out.println("Runden er uafgjort.");
                continue;
            }

            Spiller winner = s2;

            if (
                (h1 == Håndtegn.STEN && h2 == Håndtegn.SAKS) ||
                (h1 == Håndtegn.SAKS && h2 == Håndtegn.PAPIR) ||
                (h1 == Håndtegn.PAPIR && h2 == Håndtegn.STEN)
            ) {
                winner = s1;
            }

            winner.incrementPoint();

            System.out.println(STR."\{winner.getNavn()} vandt runden.");
        }

        int p1 = s1.getPoint();
        int p2 = s2.getPoint();

        System.out.println(STR."""

            \u001B[51m Opgørelse \u001B[0m
            \{s1.getNavn()} fik \{p1} point.
            \{s2.getNavn()} fik \{p2} point."""
        );

        Spiller vinder = s2;

        if (p1 > p2) {
            vinder = s1;
        }

        System.out.print(STR."\{vinder.getNavn()} vandt.");
    }

    // Auxiliary method
    private String talord(int i) {

        return switch (i) {
            case 1 -> "én";
            case 3 -> "tre";
            case 5 -> "fem";
            case 7 -> "syv";
            case 9 -> "ni";
            default -> "" + i;
        };
    }
}