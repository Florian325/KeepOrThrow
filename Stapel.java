public class Stapel {
    private Karte top;

    public Stapel() {
    }

    public Karte top() {
        return this.top;
    }

    public boolean isEmpty() {
        return this.top() == null;
    }

    public void push(Karte karte) {
        if (!this.isEmpty())
            karte.next = this.top;
        this.top = karte;
    }

    public Karte pop() {
        if (!this.isEmpty()) {
            Karte poppedKarte = this.top;
            top = this.top.next;
            poppedKarte.next = null;
            return poppedKarte;
        }
        return null;
    }
}
