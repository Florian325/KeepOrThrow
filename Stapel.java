public class Stapel {
    private Karte top;

    public Stapel() {
    }

    public Karte top() {
        return top;
    }

    public boolean isEmpty() {
        return top() == null;
    }

    public void push(Karte k) {
        if (!isEmpty())
            k.next = top;
        top = k;
    }

    public Karte pop() {
        if (!isEmpty()) {
            Karte poppedKarte = top;
            top = top.next;
            poppedKarte.next = null;
            return poppedKarte;
        }
        return null;
    }
}
