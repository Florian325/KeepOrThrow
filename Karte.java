public class Karte {
    private int wert;
    public Karte next;

    public Karte(int w) {
        wert = w;
    }

    public int getWert() {
        return wert;
    }
}
