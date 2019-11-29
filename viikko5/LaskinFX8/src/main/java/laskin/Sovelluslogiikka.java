package laskin;

import java.util.Stack;

public class Sovelluslogiikka {

    private int tulos;
    private Stack<Integer> jono = new Stack<>();

    public void plus(int luku) {
        tulos += luku;
    }

    public void miinus(int luku) {
        tulos -= luku;
    }

    public void nollaa() {
        tulos = 0;
    }

    public int tulos() {
        return tulos;
    }

    public Stack<Integer> getJono() {
        return jono;
    }

    public void pushToJono() {
        jono.push(tulos);
    }

    public Integer getPeek() {
        jonoPop();
        return jonoPeek();
    }

    public void jonoPop() {
        if (!jono.empty()) {
            jono.pop();
        }
    }

    public Integer jonoPeek() {
        if (jono.empty()) {
            return 0;
        }
        return jono.peek();
    }

}
