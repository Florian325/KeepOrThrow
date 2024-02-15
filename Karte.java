public class Karte {
    private int wert;
    public Karte next;

    public Karte(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return this.wert;
    }
}
