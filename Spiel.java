import java.util.Random;

public class Spiel {
    private Stapel gemischterStapel;
    private Stapel keepStapel;
    private Stapel throwStapel;

    public Spiel() {
        System.out.print('\u000C');
        System.out.println("Sie haben das Spiel gestartet. Viel Erfolg!");
        this.gemischterStapel = new Stapel();
        this.keepStapel = new Stapel();
        this.throwStapel = new Stapel();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            this.gemischterStapel.push(new Karte(r.nextInt(15) + 1));
        }

    }

    public void betrachteNaechsteKarte() {
        if (!this.gemischterStapel.isEmpty()) {
            Karte aktuelleKarte = this.gemischterStapel.top();
            System.out.println("\nAktuelle Karte: " + aktuelleKarte.getWert());
        } else
            System.out.println("Der gemischte Stapel is leer. Das Spiel ist zu Ende.");
    }

    public void behalten() {
        if (!this.gemischterStapel.isEmpty()) {
            Karte aufgehobeneKarte = this.gemischterStapel.pop();
            if (this.keepStapel.isEmpty() || aufgehobeneKarte.getWert() > this.keepStapel.top().getWert()) {
                this.keepStapel.push(aufgehobeneKarte);
                System.out.println("Karte wurde abgelegt");
            } else {
                this.gemischterStapel.push(aufgehobeneKarte);
                System.out.println("Karte ist zu klein");
            }
        } else {
            System.out.println("Gemischter Stapel ist leer. Spiel ist zu Ende.");
        }
    }

    public void wegwerfen() {
        if (!this.gemischterStapel.isEmpty()) {
            Karte aufgehobeneKarte = this.gemischterStapel.pop();
            this.throwStapel.push(aufgehobeneKarte);
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
        while (!this.keepStapel.isEmpty()) {
            Karte obersteKeepKarte = this.keepStapel.pop();
            System.out.println(obersteKeepKarte.getWert());
            counter += 1;
            tempStapel.push(obersteKeepKarte);
        }
        System.out.println(counter + " Karten befinden sich auf dem Keep Stapel");
        while (!tempStapel.isEmpty()) {
            Karte obersteKeepKarte = tempStapel.pop();
            this.keepStapel.push(obersteKeepKarte);
        }
        System.out.println("\n---------- Throw Stapel ----------");
        while (!throwStapel.isEmpty()) {
            Karte obersteThrowKarte = this.throwStapel.pop();
            System.out.println(obersteThrowKarte.getWert());
            tempStapel.push(obersteThrowKarte);
        }
        while (!tempStapel.isEmpty()) {
            Karte obersteThrowKarte = tempStapel.pop();
            this.throwStapel.push(obersteThrowKarte);
        }
    }
}
