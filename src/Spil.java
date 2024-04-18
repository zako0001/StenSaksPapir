public class Spil {

    // Attributes
    private final Spiller s1;
    private final Spiller s2;

    // Constructor
    public Spil(Spiller s1, Spiller s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    // Method
    public void start() {

        System.out.println("""
            
            Velkommen til sten-saks-papir!
            Spillet afgøres ud fra bedst-af-tre."""
        );

        int runde = 0;
        int afgjortRunde = 0;

        while (afgjortRunde < 3) {

            System.out.println(STR."\n\u001B[51m Runde \{++runde} \u001B[0m");

            Håndtegn h1 = s1.vælgHåndtegn();
            Håndtegn h2 = s2.vælgHåndtegn();

            System.out.println(STR."\{s1.getNavn()} valgte \{h1.toString().toLowerCase()}.");
            System.out.println(STR."\{s2.getNavn()} valgte \{h2.toString().toLowerCase()}.");

            if (h1 == h2) {
                System.out.println(STR."Runden er uafgjort.");
                continue;
            }

            afgjortRunde++;
            Spiller winner;

            if (
                (h1 == Håndtegn.STEN && h2 == Håndtegn.SAKS) ||
                (h1 == Håndtegn.SAKS && h2 == Håndtegn.PAPIR) ||
                (h1 == Håndtegn.PAPIR && h2 == Håndtegn.STEN)
            ) {
                winner = s1;
            } else {
                winner = s2;
            }

            winner.incrementPoint();

            System.out.println(STR."\{winner.getNavn()} vandt runden og har nu \{winner.getPoint()} point.");
        }

        int p1 = s1.getPoint();
        int p2 = s2.getPoint();

        System.out.println(STR."""

            \u001B[51m Opgørelse \u001B[0m
            \{s1.getNavn()} fik \{s1.getPoint()} point.
            \{s2.getNavn()} fik \{s2.getPoint()} point."""
        );

        Spiller vinder;

        if (p1 > p2) {
            vinder = s1;
        } else if (p1 < p2) {
            vinder = s2;
        } else {
            System.out.println("Spillet er uafgjort.");
            return;
        }

        System.out.println(STR."\{vinder.getNavn()} vandt.");
    }
}
