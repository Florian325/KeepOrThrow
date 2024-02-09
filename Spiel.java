import java.util.Random;

public class Spiel {
    private Stapel gemischterStapel;
    private Stapel keepStapel;
    private Stapel throwStapel;

    public Spiel() {
        System.out.print('\u000C');
        System.out.println("Sie haben das Spiel gestartet. Viel Erfolg!");
        gemischterStapel = new Stapel();
        keepStapel = new Stapel();
        throwStapel = new Stapel();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            gemischterStapel.push(new Karte(r.nextInt(11)));
        }

    }

    public void betrachteNaechsteKarte() {
        if (!gemischterStapel.isEmpty()) {
            Karte aktuelleKarte = gemischterStapel.top();
            System.out.println("\nAktuelle Karte: " + aktuelleKarte.getWert());
        } else
            System.out.println("Der gemischte Stapel is leer. Das Spiel ist zu Ende.");
    }

    public void behalten() {
        if (!gemischterStapel.isEmpty()) {
            Karte aufgehobeneKarte = gemischterStapel.pop();
            if (keepStapel.isEmpty() || aufgehobeneKarte.getWert() > keepStapel.top().getWert()) {
                keepStapel.push(aufgehobeneKarte);
                System.out.println("Karte wurde abgelegt");
            } else {
                gemischterStapel.push(aufgehobeneKarte);
                System.out.println("Karte ist zu klein");
            }
        } else {
            System.out.println("Gemischter Stapel ist leer. Spiel ist zu Ende.");
        }
    }

    public void wegwerfen() {
        if (!gemischterStapel.isEmpty()) {
            Karte aufgehobeneKarte = gemischterStapel.pop();
            throwStapel.push(aufgehobeneKarte);
            System.out.println("Karte wurde weggelegt");

        } else {
            System.out.println("Gemischter Stapel ist leer. Spiel ist zu Ende.");
        }
    }

    public void auswerten() {
        Stapel tempStapel = new Stapel();
        int counter = 0;
        System.out.println("\nAuswertung");
        System.out.println("---------- Keep Stapel ----------");
        while (!keepStapel.isEmpty()) {
            Karte obersteKeepKarte = keepStapel.pop();
            System.out.println(obersteKeepKarte.getWert());
            counter += 1;
            tempStapel.push(obersteKeepKarte);
        }
        System.out.println(counter + " Karten befinden sich auf dem Keep Stapel");
        while (!tempStapel.isEmpty()) {
            Karte obersteKeepKarte = tempStapel.pop();
            keepStapel.push(obersteKeepKarte);
        }
        System.out.println("\n---------- Throw Stapel ----------");
        while (!throwStapel.isEmpty()) {
            Karte obersteThrowKarte = throwStapel.pop();
            System.out.println(obersteThrowKarte.getWert());
            tempStapel.push(obersteThrowKarte);
        }
        while (!tempStapel.isEmpty()) {
            Karte obersteThrowKarte = tempStapel.pop();
            throwStapel.push(obersteThrowKarte);
        }
    }
}
